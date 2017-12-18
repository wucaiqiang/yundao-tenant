package com.yundao.tenant.service.customer.distribution.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DesUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDistributionResDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotReqDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotToCsReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.customer.CustomerBackStatusEnum;
import com.yundao.tenant.enums.customer.CustomerBelongTypeEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.base.customer.*;
import com.yundao.tenant.model.base.customer.*;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.customer.distribution.CustomerDistributionService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.sale.leads.allot.LeadsAllotService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 调配客户服务实现
 *
 * @author jan
 * @create 2017-08-14 PM5:03
 **/
@Service
public class CustomerDistributionServiceImpl extends AbstractService implements CustomerDistributionService {

    private static Log log = LogFactory.getLog(CustomerDistributionServiceImpl.class);

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private BaseUserCustomerMapper baseUserCustomerMapper;

    @Autowired
    private BaseCustomerTransferMapper baseCustomerTransferMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseUserVisitMapper baseUserVisitMapper;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private BaseCustomerBackExamineMapper baseCustomerBackExamineMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private LeadsAllotService leadsAllotService;

    @Override
    public Result<PermissionResultDto> doAllotToFp(CustomerAllotReqDto dto) throws BaseException {
        String logPrefix = "客户调配||分配给理财师||";
        log.info("%s 参数dto %s", logPrefix, JsonUtils.objectToJson(dto));

        PermissionResultDto result = new PermissionResultDto();

        boolean isEnable = userService.checkUserIsEnable(dto.getFpId());
        if (!isEnable)
            throw new BaseException(CodeConstant.CODE_1200022);

        List<Long> customerIds = SymbolStrUtils.toLong(dto.getCustomerIds());

        //校验是否存在正在审批的额度预约和报单
        this.doCheckExistReservationDeclaration(result, customerIds);
        List<Long> newCustomerIds = this.filterProcessedIds(result, customerIds);
        if (BooleanUtils.isNotEmpty(newCustomerIds))
            this.doCheckExistAuditingDeclaration(result, newCustomerIds);
        if (!result.isSuccess())
            return Result.newSuccessResult(result);

        List<BaseCustomer> customerList = this.getCustomers(customerIds);
        if (BooleanUtils.isEmpty(customerList))
            return Result.newSuccessResult(null);

        //获取客户旧的的分配信息
        List<BaseUserCustomer> existUcList = this.getUserCustomers(customerIds);
        boolean isExistUcListEmpty = BooleanUtils.isEmpty(existUcList);

        for (BaseCustomer customer : customerList) {
            BaseUserCustomer existUc = null;
            //删除旧的分配信息
            if (!isExistUcListEmpty) {
                existUc = LambdaFilter.firstOrDefault(existUcList, m -> m.getCustomerId().equals(customer.getId()));
                if (existUc != null)
                    baseUserCustomerMapper.deleteByPrimaryKey(existUc.getId());
            }

            //插入新的分配信息
            BaseUserCustomer uc = new BaseUserCustomer();
            super.initialModel(uc);
            uc.setCustomerId(customer.getId());
            uc.setUserId(dto.getFpId());
            uc.setDistributionUserId(super.getHeaderUserId());
            uc.setDistributionDate(new Date());
            baseUserCustomerMapper.insertSelective(uc);

            //插入调配日志
            BaseCustomerTransfer record = new BaseCustomerTransfer();
            super.initialModel(record);
            if (existUc != null) {
                record.setBeforeUserId(existUc.getUserId());
            }
            record.setAfterUserId(dto.getFpId());
            record.setCustomerId(customer.getId());
            record.setTransferDate(new Date());
            record.setRemark("分配客户");
            baseCustomerTransferMapper.insertSelective(record);

            //更新客户的线索
            leadsAllotService.updateIsAllotedFp(customer.getId());
        }

        deleteUnAuditBackExamine(customerList);

        //上报消息和动态
        this.doSendMsgForAllot(customerList, dto.getFpId(), super.getRealName());
        log.end();
        return Result.newSuccessResult(null);
    }

    private List<Long> filterProcessedIds(PermissionResultDto result, List<Long> customerIds) {
        List<FailListDto> failList = result.getFailList();
        if (BooleanUtils.isEmpty(failList))
            return customerIds;
        List<Long> newCustomerIds = new ArrayList<>();
        for (Long customerId : customerIds) {
            FailListDto fail = LambdaFilter.firstOrDefault(failList, m -> m.getId().equals(customerId));
            if (fail == null)
                newCustomerIds.add(customerId);
        }
        return newCustomerIds;
    }


    private void doCheckExistReservationDeclaration(PermissionResultDto result, List<Long> customerIds) throws BaseException {
        String logPrefix = "客户调配||分配给理财师||校验正在审批的额度预约";
        List<CustomerDistributionResDto> auditingReservationCustomers = customerService.getAuditingReservationCustomerIds(customerIds);
        log.info("%s auditingReservationCustomers %s", logPrefix, JsonUtils.objectToJson(auditingReservationCustomers));
        if (BooleanUtils.isNotEmpty(auditingReservationCustomers)) {
            for (CustomerDistributionResDto customer : auditingReservationCustomers) {
                FailListDto fail = new FailListDto();
                fail.setId(customer.getId());
                fail.setName(customer.getName());
                fail.setOwnerId(customer.getFpId());
                fail.setCode(CodeConstant.CODE_1220114);
                result.getFailList().add(fail);
            }
        }
        log.info("%s result %s", logPrefix, JsonUtils.objectToJson(result));
    }

    private void doCheckExistAuditingDeclaration(PermissionResultDto result, List<Long> customerIds) throws BaseException {
        String logPrefix = "客户调配||分配给理财师||校验正在审批的报单";
        List<CustomerDistributionResDto> auditingDelcarationCustomers = customerService.getAuditingDelcarationCustomerIds(customerIds);
        log.info("%s auditingDelcarationCustomers %s", logPrefix, JsonUtils.objectToJson(auditingDelcarationCustomers));
        if (BooleanUtils.isNotEmpty(auditingDelcarationCustomers)) {
            for (CustomerDistributionResDto customer : auditingDelcarationCustomers) {
                FailListDto fail = new FailListDto();
                fail.setId(customer.getId());
                fail.setName(customer.getName());
                fail.setOwnerId(customer.getFpId());
                fail.setCode(CodeConstant.CODE_1220108);
                result.getFailList().add(fail);
            }
        }
        this.setPassList(result, customerIds, auditingDelcarationCustomers);
        log.info("%s result %s", logPrefix, JsonUtils.objectToJson(result));
    }

    private void setPassList(PermissionResultDto result, List<Long> customerIds, List<CustomerDistributionResDto> auditingCustomers) {
        for (Long customerId : customerIds) {
            CustomerDistributionResDto existCustomer = LambdaFilter.firstOrDefault(auditingCustomers, m -> m.getId().equals(customerId));
            if (existCustomer == null) {
                PassListDto pass = new PassListDto();
                pass.setId(customerId);
                result.getPassList().add(pass);
            }
        }
    }

    @Override
    public Result<PermissionResultDto> doRecycle(CustomerMultiIdReqDto dto) throws BaseException {
        String logPrefix = "客户调配||回收客户||";
        log.info("%s开始 参数 %s", logPrefix, JsonUtils.objectToJson(dto));
        PermissionResultDto result = new PermissionResultDto();
        List<Long> customerIds = SymbolStrUtils.toLong(dto.getCustomerIds());


        //校验是否存在正在审批的额度预约和报单
        this.doCheckExistReservationDeclaration(result, customerIds);
        List<Long> newCustomerIds = this.filterProcessedIds(result, customerIds);
        if (BooleanUtils.isNotEmpty(newCustomerIds))
            this.doCheckExistAuditingDeclaration(result, newCustomerIds);
        if (!result.isSuccess())
            return Result.newSuccessResult(result);

        List<BaseCustomer> customerList = this.getCustomers(customerIds);
        if (BooleanUtils.isEmpty(customerList))
            return Result.newSuccessResult(null);

        List<BaseUserCustomer> userCustomerList = this.getUserCustomers(customerIds);
        if (BooleanUtils.isEmpty(userCustomerList))
            return Result.newSuccessResult(result);
        for (BaseUserCustomer userCustomer : userCustomerList) {
            baseUserCustomerMapper.deleteByPrimaryKey(userCustomer.getId());
            customerService.doSetBelongType(userCustomer.getCustomerId(), CustomerBelongTypeEnum.OPENSEA.getValue());
        }

        log.info("%s上报消息和动态||开始", logPrefix);
        for (BaseUserCustomer uc : userCustomerList) {
            BaseCustomer customer = LambdaFilter.firstOrDefault(customerList, m -> m.getId().equals(uc.getCustomerId()));
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("userId", uc.getUserId());
            paramMap.put("customerId", customer.getId());
            paramMap.put("createUserName", super.getRealName());
            paramMap.put("customerName", customer.getName());
            paramMap.put("mobile", BaseContactUtils.decrypt(customer.getMobile()));
            msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_RECYCLE.getCode(), paramMap);
        }
        log.info("%s上报消息和动态||完成", logPrefix);

        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(null);
    }

    private List<BaseCustomer> getCustomers(List<Long> customerIds) throws BaseException {
        BaseCustomerExample customerExample = new BaseCustomerExample();
        customerExample.createCriteria().andIdIn(customerIds);
        List<BaseCustomer> customerList = baseCustomerMapper.selectByExample(customerExample);
        log.info("需要分配的客户 customerList:%s", JsonUtils.objectToJson(customerList));
        return customerList;
    }

    private List<BaseUserCustomer> getUserCustomers(List<Long> customerIds) throws BaseException {
        BaseUserCustomerExample existUcExample = new BaseUserCustomerExample();
        existUcExample.createCriteria().andCustomerIdIn(customerIds);
        List<BaseUserCustomer> existUcList = baseUserCustomerMapper.selectByExample(existUcExample);
        log.info("客户旧的分配数据 existUcList:%s", JsonUtils.objectToJson(existUcList));
        return existUcList;
    }


    /**
     * 分配客户给客服
     */
    public Result<Boolean> doAllotToCs(CustomerAllotToCsReqDto dto) throws BaseException {
        List<Long> customerIds = SymbolStrUtils.toLong(dto.getCustomerIds());
        if (BooleanUtils.isEmpty(customerIds)) {
            throw new BaseException(CodeConstant.CODE_1200101);
        }
        List<BaseCustomer> customerList = this.getCustomers(customerIds);
        if (BooleanUtils.isEmpty(customerList)) {
            throw new BaseException(CodeConstant.CODE_1200101);
        }

        for (Long customerId : customerIds) {
            // 添加回访记录
            BaseUserVisit userVisit = new BaseUserVisit();
            userVisit.setCustomerId(customerId);
            userVisit.setMatter(dto.getMatter());
            userVisit.setUserId(dto.getCsId());
            userVisit.setSubDate(new Date());
            userVisit.setCreateDate(new Date());
            userVisit.setCreateUserId(this.getHeaderUserId());
            userVisit.setTenantId(this.getHeaderTenantId());
            userVisit.setIsDelete(DeleteEnum.NOT_DELETED.getValue());
            baseUserVisitMapper.insert(userVisit);
        }

        return Result.newSuccessResult(true);
    }

    /**
     * 分配客户，上报消息和动态
     *
     * @param customerList 分配的客户
     * @param fpId         理财师id
     * @param creator      操作人姓名
     */
    private void doSendMsgForAllot(List<BaseCustomer> customerList, Long fpId, String creator) throws BaseException {
        String logPrefix = "客户调配||分配客户给理财师||";
        log.info("%s参数 customerList:%s", logPrefix, JsonUtils.objectToJson(customerList));
        log.info("%s参数 fpId:%s creator:%s", logPrefix, fpId, creator);

        //是否批量
        boolean isMulti = customerList.size() > 1;
        String fpName = userDetailService.getUserRealName(fpId);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", fpId);
        paramMap.put("fpName", fpName != null ? fpName : "--");
        paramMap.put("createUserName", creator != null ? creator : "--");

        if (isMulti) {
            paramMap.put("customerIds", SymbolStrUtils.longToStr(LambdaMap.toSingleList(customerList, m -> m.getId())));
            paramMap.put("customerNum", Integer.valueOf(customerList.size()));
            msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_ALLOT_MULTI.getCode(), paramMap);
        } else {
            BaseCustomer customer = customerList.get(0);
            paramMap.put("name", customer.getName() != null ? customer.getName() : "--");
            try {
                paramMap.put("mobile", DesUtils.decrypt(customer.getMobile()));
            } catch (Exception ex) {
                log.error("%s手机号解密失败 %s", logPrefix, ex.toString());
                paramMap.put("mobile", "--");
            }
            paramMap.put("customerId", customer.getId());
            msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_ALLOT.getCode(), paramMap);
        }
        log.info("%s完成", logPrefix);
    }


    /**
     * 移除未审核的客户回退申请
     *
     * @param customerList 客户列表
     */
    private void deleteUnAuditBackExamine(List<BaseCustomer> customerList) {
        String logPrefix = "客户调配||移除未审核客户回退申请||";
    /*回退审核未操作期间，涉及的客户被回收或调配给其他用户，移除相关申请*/
        BaseCustomerBackExamineExample cbExample = new BaseCustomerBackExamineExample();
        cbExample.createCriteria().andCustomerIdIn(LambdaMap.toSingleList(customerList, m -> m.getId()))
                .andStatusEqualTo(CustomerBackStatusEnum.APPROVALING.getValue());
        List<BaseCustomerBackExamine> cbList = baseCustomerBackExamineMapper.selectByExample(cbExample);
        log.info("%s cbList %s", logPrefix, JsonUtils.objectToJson(cbList));
        if (BooleanUtils.isNotEmpty(cbList)) {
            for (BaseCustomerBackExamine cb : cbList) {
                super.updateModel(cb);
                cb.setRejectReason(cb.getRejectReason() + " [客户被调配，所以移除该记录]");
                cb.setIsDelete(DeleteEnum.DELETED.getValue());
                baseCustomerBackExamineMapper.updateByPrimaryKeySelective(cb);
            }
        }
        log.info("%s完成", logPrefix);
    }
}
