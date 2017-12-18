package com.yundao.tenant.service.customer.back.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.back.CustomerBackApplyReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListResDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineRejectReqDto;
import com.yundao.tenant.enums.access.DataObjectEnum;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.access.OperationPermissionEnum;
import com.yundao.tenant.enums.customer.CustomerBackStatusEnum;
import com.yundao.tenant.enums.customer.CustomerBelongTypeEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerBackExamineMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerTransferMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.mapper.customer.customerbackexamine.CustomerBackExamineMapper;
import com.yundao.tenant.model.base.customer.*;
import com.yundao.tenant.service.customer.back.CustomerBackExamineService;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.dataobject.permission.DataObjectPermissionService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.region.RegionService;
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
 * 客户回退服务实现
 *
 * @author jan
 * @create 2017-08-10 PM2:46
 **/
@Service
public class CustomerBackExamineServiceImpl extends AbstractService implements CustomerBackExamineService {

    private static Log log = LogFactory.getLog(CustomerBackExamineServiceImpl.class);

    @Autowired
    private BaseCustomerBackExamineMapper baseCustomerBackExamineMapper;

    @Autowired
    private BaseUserCustomerMapper baseUserCustomerMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private BaseCustomerTransferMapper baseCustomerTransferMapper;

    @Autowired
    private DataObjectPermissionService dataObjectPermissionService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerBackExamineMapper customerBackExamineMapper;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private RegionService regionService;

    @Autowired
    UserDetailService userDetailService;
    @Autowired
    CustomerService customerService;
    @Autowired
    MsgMessageService msgMessageService;

    @Override
    public Result<Boolean> doApply(CustomerBackApplyReqDto dto) throws BaseException {
        log.begin(dto.getCustomerIds(), dto.getReason());
        Long userId = super.getHeaderUserId();
        List<Long> customerList = SymbolStrUtils.toLong(dto.getCustomerIds());

        BaseUserCustomerExample ucExample = new BaseUserCustomerExample();
        ucExample.createCriteria().andUserIdEqualTo(userId).andCustomerIdIn(customerList);
        List<BaseUserCustomer> userCustomerList = baseUserCustomerMapper.selectByExample(ucExample);
        if (BooleanUtils.isEmpty(userCustomerList)) {
            throw new BaseException(CodeConstant.CODE_1200142);
        }

        for (BaseUserCustomer base : userCustomerList) {
            BaseUserCustomer record = new BaseUserCustomer();
            record.setId(base.getId());
            record.setIsDelete(1);
            record.setUpdateDate(new Date());
            record.setUpdateUserId(this.getHeaderUserId());
            baseUserCustomerMapper.deleteByPrimaryKey(base.getId());
            // baseUserCustomerMapper.updateByPrimaryKeySelective(record);
            customerService.doSetBelongType(base.getCustomerId(), CustomerBelongTypeEnum.OPENSEA.getValue());
            sendBackMessage(base.getCustomerId(), dto.getReason(), super.getRealName());
        }
        log.end();
        return Result.newSuccessResult(true);
    }

    @Override
    public Result<PermissionResultDto> doApplyV2(CustomerBackApplyReqDto dto) throws BaseException {
        log.begin(dto.getCustomerIds(), dto.getReason());
        Long userId = super.getHeaderUserId();
        List<Long> customerList = SymbolStrUtils.toLong(dto.getCustomerIds());
        if (BooleanUtils.isEmpty(customerList))
            throw new BaseException(CodeConstant.CODE_1200084);

        PermissionResultDto result = new PermissionResultDto();

        BaseCustomerExample customerExample = new BaseCustomerExample();
        customerExample.createCriteria().andIdIn(customerList);
        List<BaseCustomer> customers = baseCustomerMapper.selectByExample(customerExample);
        if (BooleanUtils.isEmpty(customers))
            throw new BaseException(CodeConstant.CODE_1200084);

        BaseUserCustomerExample ucExample = new BaseUserCustomerExample();
        ucExample.createCriteria().andCustomerIdIn(LambdaMap.toSingleList(customers, BaseCustomer::getId));
        List<BaseUserCustomer> userCustomerList = baseUserCustomerMapper.selectByExample(ucExample);
        if (BooleanUtils.isEmpty(userCustomerList)) {
            for (BaseCustomer customer : customers) {
                this.setFailForAbandon(result, customer);
            }
            return Result.newSuccessResult(result);
        }

        for (BaseCustomer customer : customers) {
            BaseUserCustomer uc = LambdaFilter.firstOrDefault(userCustomerList, m -> m.getCustomerId().equals(customer.getId()));
            if (uc == null || !uc.getUserId().equals(userId)) {
                this.setFailForAbandon(result, customer);
            } else {
                PassListDto pass = new PassListDto();
                pass.setId(customer.getId());
                pass.setName(customer.getName());
                result.getPassList().add(pass);
            }
        }
        if (!result.isSuccess())
            return Result.newSuccessResult(result);

        //不能真正执行
        if (!dto.getExecute())
            return Result.newSuccessResult(result);

        Date now = new Date();
        for (BaseUserCustomer uc : userCustomerList) {
            BaseCustomerTransfer customerTransfer = new BaseCustomerTransfer();
            super.initialModel(customerTransfer);
            customerTransfer.setRemark("放弃客户");
            customerTransfer.setBeforeUserId(super.getHeaderUserId());
            customerTransfer.setBeforeUser(super.getRealName());
            customerTransfer.setCustomerId(uc.getCustomerId());
            customerTransfer.setTransferDate(now);
            baseCustomerTransferMapper.insertSelective(customerTransfer);

            baseUserCustomerMapper.deleteByPrimaryKey(uc.getId());

            customerService.doSetBelongType(uc.getCustomerId(), CustomerBelongTypeEnum.OPENSEA.getValue());
            sendBackMessage(uc.getCustomerId(), dto.getReason(), super.getRealName());
        }
        return Result.newSuccessResult(null);
    }

    private void setFailForAbandon(PermissionResultDto result, BaseCustomer customer) {
        FailListDto fail = new FailListDto();
        fail.setId(customer.getId());
        fail.setName(customer.getName());
        fail.setCode(CodeConstant.CODE_1200142);
        result.getFailList().add(fail);
    }

    private void sendBackMessage(Long id, String reason, String realName) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("createUserName", realName);
        params.put("reason", reason);
        params.put("customerId", id);
        msgMessageService.processSendMessage(MsgMessageCodeEnum.RENOUNCE_CUSTOMER.getCode(), params);
    }

    /**
     * 审批通过
     *
     * @param id
     * @return
     * @throws BaseException
     */
    public Result<Integer> doPass(Long id) throws BaseException {
        if (id == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200095);
        }
        BaseCustomerBackExamine base = baseCustomerBackExamineMapper.selectByPrimaryKey(id);
        if (base == null) {
            return Result.newFailureResult(CodeConstant.CODE_1220073);
        }

        BaseUserCustomerExample example = new BaseUserCustomerExample();
        example.createCriteria().andCustomerIdEqualTo(base.getCustomerId()).andUserIdEqualTo(base.getUserId());
        baseUserCustomerMapper.deleteByExample(example);

        BaseCustomerBackExamine record = new BaseCustomerBackExamine();
        record.setId(base.getId());
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        record.setStatus(CustomerBackStatusEnum.PASS.getValue());
        record.setExamineDate(new Date());
        record.setExamineUserId(this.getHeaderUserId());
        baseCustomerBackExamineMapper.updateByPrimaryKeySelective(record);

        // 审核通过后给当前理财师发送消息
        doPassSendMessage(base.getCustomerId(), base.getUserId(), base.getUserId(), this.getHeaderUserId());
        return Result.newSuccessResult(1);
    }

    /**
     * 客户回退-审核通过 发送消息
     *
     * @param customerId
     */
    private void doPassSendMessage(Long customerId, Long userId, Long applyUserId, Long auditUserId)
            throws BaseException {
        BaseCustomer baseCustomer = customerService.get(customerId).getResult();
        String customerName = baseCustomer.getName();
        String customerMobile = baseCustomer.getMobile();

        String auditUserName = userDetailService.getUserRealName(auditUserId);
        String applyUserName = userDetailService.getUserRealName(applyUserId);
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("customerId", customerId);
        parm.put("customerName", customerName);
        parm.put("customerMobile", customerMobile);
        parm.put("auditUserName", auditUserName);
        parm.put("applyUserName", applyUserName);
        parm.put("userId", userId);
        msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_BACK_EXAMINE_PASS.getCode(), parm);
    }

    /**
     * 驳回
     *
     * @param dto
     * @return
     * @throws BaseException
     */
    public Result<Integer> doReject(CustomerBackExamineRejectReqDto dto) throws BaseException {
        BaseCustomerBackExamine base = baseCustomerBackExamineMapper.selectByPrimaryKey(dto.getId());
        if (base == null) {
            return Result.newFailureResult(CodeConstant.CODE_1220073);
        }

        BaseCustomerBackExamine record = new BaseCustomerBackExamine();
        record.setId(base.getId());
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        record.setStatus(CustomerBackStatusEnum.REJECT.getValue());
        record.setRejectReason(dto.getReason());
        record.setExamineDate(new Date());
        record.setExamineUserId(this.getHeaderUserId());
        baseCustomerBackExamineMapper.updateByPrimaryKeySelective(record);

        // 审核驳回后给当前理财师发送消息
        doRejectSendMessage(base.getCustomerId(), base.getUserId(), this.getHeaderUserId(), dto.getReason());
        return Result.newSuccessResult(1);
    }

    /**
     * 客户回退-驳回
     */
    private void doRejectSendMessage(Long customerId, Long userId, Long auditUserId, String rejectReason)
            throws BaseException {
        BaseCustomer baseCustomer = customerService.get(customerId).getResult();
        String customerName = baseCustomer.getName();
        String customerMobile = baseCustomer.getMobile();

        String auditUserName = userDetailService.getUserRealName(auditUserId);
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("customerId", customerId);
        parm.put("customerName", customerName);
        parm.put("customerMobile", customerMobile);
        parm.put("auditUserName", auditUserName);
        parm.put("rejectReason", rejectReason);
        parm.put("userId", userId);
        msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_BACK_EXAMINE_REJECT.getCode(), parm);
    }

    /**
     * 分页查询审核信息
     *
     * @param reqDto
     * @return
     * @throws BaseException
     */
    public Result<PaginationSupport<CustomerBackExamineListResDto>> gets(CustomerBackExamineListReqDto reqDto)
            throws BaseException {
        PaginationSupport<CustomerBackExamineListResDto> result = reqDto.getPaginationSupport();
        // 重置参数
        resetParam(reqDto);
        Integer permission = dataObjectPermissionService.get(DataObjectEnum.CUSTOMER.getCode(),
                OperationPermissionEnum.READ.getValue());
        if (DataObjectPermissionEnum.NONE.getValue().equals(permission)) {
            return Result.newSuccessResult(result);
        }

        List<Long> userIds = null;
        if (DataObjectPermissionEnum.PERSONAL.getValue().equals(permission)) {
            userIds = new ArrayList<Long>();
            userIds.add(this.getHeaderUserId());
        } else if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)) {
            // 查询当前操作人同部门用户id
            userIds = userService.getSameDepUsers(this.getHeaderUserId());
        }
        reqDto.setUserIds(userIds);

        int totalCount = customerBackExamineMapper.getCount(reqDto);
        if (totalCount > 0) {
            List<CustomerBackExamineListResDto> datas = customerBackExamineMapper.gets(reqDto);
            result.setDatas(datas);
            resetDatas(datas);
        }
        result.setTotalCount(totalCount);

        return Result.newSuccessResult(result);
    }

    /**
     * 重置数据
     *
     * @param datas
     */
    private void resetDatas(List<CustomerBackExamineListResDto> datas) throws BaseException {
        if (BooleanUtils.isEmpty(datas)) {
            return;
        }
        for (CustomerBackExamineListResDto dto : datas) {
            dto.setCustomerLevelText(
                    dictionaryService.toText(DicCode.DIC_CUSTOMER_LEVEL, dto.getCustomerLevel()));
            dto.setProvinceCodeText(regionService.toText(dto.getProvinceCode()));
            dto.setCityCodeText(regionService.toText(dto.getCityCode()));
            if (dto.getStatus() != null) {
                dto.setStatusText(dictionaryService.toText(DicCode.DIC_CUSTOMER_BACK_STATUS, dto.getStatus().toString()));
            }
            if (dto.getCustomerSex() != null) {
                dto.setCustomerSexText(
                        dictionaryService.toText(DicCode.DIC_SEX, dto.getCustomerSex().toString()));
            }
            dto.setCustomerMobile(BaseContactUtils.decrypt(dto.getCustomerMobile()));
        }
    }

    /**
     * 重置参数
     *
     * @param reqDto
     */
    private void resetParam(CustomerBackExamineListReqDto reqDto) {
        if (!BooleanUtils.isBlank(reqDto.getCityCodes())) {
            String[] cityCodeList = reqDto.getCityCodes().split(",");
            if (!BooleanUtils.isEmpty(cityCodeList)) {
                reqDto.setCityCodeList(cityCodeList);
            }
        }

        if (!BooleanUtils.isBlank(reqDto.getProvinceCodes())) {
            String[] provinceCodeList = reqDto.getProvinceCodes().split(",");
            if (!BooleanUtils.isEmpty(provinceCodeList)) {
                reqDto.setProvinceCodeList(provinceCodeList);
            }
        }

        if (!BooleanUtils.isBlank(reqDto.getCustomerSexs())) {
            String[] customerSexList = reqDto.getCustomerSexs().split(",");
            if (!BooleanUtils.isEmpty(customerSexList)) {
                reqDto.setCustomerSexList(customerSexList);
            }
        }

        if (!BooleanUtils.isBlank(reqDto.getCustomerLevels())) {
            String[] customerLevelList = reqDto.getCustomerLevels().split(",");
            if (!BooleanUtils.isEmpty(customerLevelList)) {
                reqDto.setCustomerLevelList(customerLevelList);
            }
        }

        if (!BooleanUtils.isBlank(reqDto.getCustomerMobile())) {
            reqDto.setCustomerMobile(BaseContactUtils.encrypt(reqDto.getCustomerMobile().trim()));
        }

        // 重置排序
        resetOrderBy(reqDto);

    }

    /**
     * 重置排序参数
     *
     * @param reqDto
     */
    private void resetOrderBy(CustomerBackExamineListReqDto reqDto) {
        if (BooleanUtils.isBlank(reqDto.getOrderColumn())) {
            reqDto.setOrderColumn(null);
            reqDto.setSort(null);
            return;
        }

        if ("customerLevels".equals(reqDto.getOrderColumn())) {
            reqDto.setOrderColumn("c.level");
        } else if ("applyDate".equals(reqDto.getOrderColumn())) {
            reqDto.setOrderColumn("cbe.application_date");
        } else if ("examineDate".equals(reqDto.getOrderColumn())) {
            reqDto.setOrderColumn("cbe.examine_date");
        } else {
            reqDto.setOrderColumn(null);
            reqDto.setSort(null);
            return;
        }
        if (BooleanUtils.isBlank(reqDto.getSort())) {
            reqDto.setSort("desc");
        }
    }

    /**
     * 检查客户申请是否在申请中
     *
     * @param id
     * @return
     */
    public Result<Boolean> checkCustomerBackExaminIsApply(Long id) throws BaseException {
        if (id == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200095);
        }
        BaseCustomerBackExamine base = baseCustomerBackExamineMapper.selectByPrimaryKey(id);
        if (base == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200096);
        }
        // (1：审核中 2：已通过 3：已驳回)
        if (base.getStatus() != null && CustomerBackStatusEnum.APPROVALING.getValue().equals(base.getStatus())) {
            return Result.newSuccessResult(true);
        }
        return Result.newSuccessResult(false);
    }
}
