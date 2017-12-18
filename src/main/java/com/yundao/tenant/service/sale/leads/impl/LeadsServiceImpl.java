package com.yundao.tenant.service.sale.leads.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.Code1220000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.sale.leads.*;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.sale.leads.LeadsStatusEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerFollowUpMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsMapper;
import com.yundao.tenant.mapper.sale.leads.LeadsMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerExample;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUp;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.sale.BaseLeads;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.sale.leads.LeadsService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 销售线索服务实现
 *
 * @author jan
 * @create 2017-09-07 AM8:59
 **/
@Service
public class LeadsServiceImpl extends AbstractService implements LeadsService {

    private static Log log = LogFactory.getLog(LeadsServiceImpl.class);

    @Autowired
    private LeadsMapper leadsMapper;

    @Autowired
    private BaseLeadsMapper baseLeadsMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private BaseCustomerFollowUpMapper baseCustomerFollowUpMapper;

    @Autowired
    private UserCustomerService userCustomerService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserService userService;

    @Override
    public Result<PaginationSupport<LeadsPageResDto>> getPage(LeadsPageReqDto dto, Integer permission) throws BaseException {
        String logPrefix = "销售线索||分页数据查询||";
        log.info("%s 查询参数 %s", logPrefix, JsonUtils.objectToJson(dto));
        if (BooleanUtils.isNotEmpty(dto.getMobile()))
            dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<LeadsPageResDto> page = PaginationSupport.newDefault(paramMap);
        //根据不同权限，设置查询条件
        userService.setPermissionCondition(paramMap, permission);
        List<LeadsPageResDto> dtos = leadsMapper.selectPage(paramMap);
        int count = leadsMapper.selectPageCount(paramMap);
        this.setText(dtos);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    private void setText(List<LeadsPageResDto> dtos) throws BaseException {
        for (LeadsPageResDto dto : dtos) {
            if (BooleanUtils.isNotEmpty(dto.getMobile()))
                dto.setMobile(BaseContactUtils.decrypt(dto.getMobile()));
            dto.setTypeText(dictionaryService.toText(DicCode.LEADS_TYPE, dto.getType()));
            dto.setChannelText(dictionaryService.toText(DicCode.LEADS_CHANNEL, dto.getChannel()));
            dto.setStatusText(dictionaryService.toText(DicCode.LEADS_STATUS, dto.getStatus()));
            dto.setCustomerStatusText(dictionaryService.toText(DicCode.CUSTOMER_STATUS, dto.getCustomerStatus()));
            dto.setCanAllotToCs(this.checkCanBeAllotToCs(dto.getIsOnceInvalid(), dto.getIsAllotedCs()));
            dto.setCanAllotToFp(this.checkCanBeAllotToFp(dto.getIsOnceInvalid(), dto.getIsAllotedFp()));
            dto.setCanViewVisitDetail(dto.getUserVisitId() != null);
        }
    }

    /**
     * 检查是否能分配给客服回访
     */
    @Override
    public Boolean checkCanBeAllotToCs(Integer isOnceInvalid, Integer isAllotedCs) {
        if (YesOrNoEnum.YES.getValue().equals(isOnceInvalid))
            return false;
        return YesOrNoEnum.NO.getValue().equals(isAllotedCs);
    }

    /**
     * 检查是否能分配给理财师
     */
    @Override
    public Boolean checkCanBeAllotToFp(Integer isOnceInvalid, Integer isAllotedFp) {
        if (YesOrNoEnum.YES.getValue().equals(isOnceInvalid))
            return false;
        return YesOrNoEnum.NO.getValue().equals(isAllotedFp);
    }

    @Override
    public Result<PaginationSupport<LeadsForCustomerDetailResDto>> getPageForCustomerDetail(LeadsForCustomerDetailReqDto dto, Integer permission) throws BaseException {
        String logPrefix = "销售线索||获取客户详情线索列表||";
        log.info("%s 查询参数 %s", logPrefix, JsonUtils.objectToJson(dto));
        BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(dto.getCustomerId());
        if (customer == null)
            throw new BaseException(CodeConstant.CODE_1200084);

        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<LeadsForCustomerDetailResDto> page = PaginationSupport.newDefault(paramMap);
        //根据不同权限，设置查询条件
        userService.setPermissionCondition(paramMap, permission);
        List<LeadsForCustomerDetailResDto> dtos = leadsMapper.selectPageForCustomerDetail(paramMap);
        int count = leadsMapper.selectPageForCustomerDetailCount(paramMap);
        this.setForCustomerDetailText(dtos);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    @Override
    public Integer getPageForCustomerDetailCount(LeadsForCustomerDetailReqDto dto, Integer permission) throws BaseException {
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        //根据不同权限，设置查询条件
        userService.setPermissionCondition(paramMap, permission);
        int count = leadsMapper.selectPageForCustomerDetailCount(paramMap);
        return count;
    }

    private void setForCustomerDetailText(List<LeadsForCustomerDetailResDto> dtos) throws BaseException {
        for (LeadsForCustomerDetailResDto dto : dtos) {
            dto.setTypeText(dictionaryService.toText(DicCode.LEADS_TYPE, dto.getType()));
            dto.setChannelText(dictionaryService.toText(DicCode.LEADS_CHANNEL, dto.getChannel()));
            dto.setStatusText(dictionaryService.toText(DicCode.LEADS_STATUS, dto.getStatus()));
            // 注意：这里只判断未处理的，数据权限的判断，前置系统会判断
            dto.setCanProcess(LeadsStatusEnum.UNPROCESS.getValue().equals(dto.getStatus()));
        }
    }

    @Override
    public Result<Long> add(String mobile, LeadsAddReqDto dto) throws BaseException {
        String logPrefix = "销售线索||添加||";
        log.info("%s参数 mobile %s,dto %s", logPrefix, mobile, JsonUtils.objectToJson(dto));
        if (BooleanUtils.isEmpty(mobile))
            throw new BaseException(CodeConstant.CODE_1220080);
        BaseCustomerExample example = new BaseCustomerExample();
        mobile = BaseContactUtils.encrypt(mobile);
        example.createCriteria().andMobileEqualTo(mobile);
        BaseCustomer customer = baseCustomerMapper.selectOne(example);
        if (customer == null)
            throw new BaseException(CodeConstant.CODE_1200084);
        return this.doInsert(customer.getId(), dto);
    }

    @Override
    public Result<Long> add(Long customerId, LeadsAddReqDto dto) throws BaseException {
        return this.doInsert(customerId, dto);
    }

    @Override
    public Result<Long> updateStatus(LeadsUpdateStatusReqDto dto) throws BaseException {
        String logPrefix = "销售线索||更新线索状态||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
        BaseLeads leads = baseLeadsMapper.selectByPrimaryKey(dto.getId());

        if (leads == null)
            throw new BaseException(CodeConstant.CODE_1220090);

        if (!LeadsStatusEnum.UNPROCESS.getValue().equals(leads.getStatus()))
            throw new BaseException(CodeConstant.CODE_1220087);

        if (LeadsStatusEnum.UNPROCESS.getValue().equals(dto.getStatus()))
            throw new BaseException(CodeConstant.CODE_1220088);

        if (LeadsStatusEnum.CONNECTED.getValue().equals(dto.getStatus()) && YesOrNoEnum.YES.getValue().equals(dto.getIsSyncToFollow())) {
            //处理销售线索时，选择为已跟进时且 “同步到跟进记录”时，判断
            if (BooleanUtils.isBlank(dto.getFollowRemark()))
                throw new BaseException(Code1220000.CODE_1220147);
            if (dto.getFollowRemark().length() > 100)
                throw new BaseException(Code1220000.CODE_1220148);
            if (dto.getType() == null)
                throw new BaseException(Code1220000.CODE_1220149);

            //同时生成跟进信息
            BaseCustomerFollowUp followUp = new BaseCustomerFollowUp();
            super.initialModel(followUp);
            followUp.setContent(dto.getFollowRemark());
            followUp.setCustomerId(leads.getCustomerId());
            followUp.setType(dto.getType());
            baseCustomerFollowUpMapper.insertSelective(followUp);
        }

        leads.setStatus(dto.getStatus());
        leads.setProcessDate(new Date());
        leads.setFollowRemark(dto.getFollowRemark());
        leads.setProcessUserId(super.getHeaderUserId());
        super.updateModel(leads);
        baseLeadsMapper.updateByPrimaryKeySelective(leads);
        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(leads.getId());
    }

    /**
     * 添加线索统一处理
     *
     * @param customerId 客户id
     * @param dto        线索dto
     */
    private Result<Long> doInsert(Long customerId, LeadsAddReqDto dto) throws BaseException {
        String logPrefix = "销售线索||添加线索统一处理||";
        log.info("%s参数 customerId %s,dto %s", logPrefix, customerId, JsonUtils.objectToJson(dto));
        checkArgsForInsert(customerId, dto);
        BaseLeads leads = new BaseLeads();
        super.initialModel(leads);
        leads.setCustomerId(customerId);
        leads.setChannel(dto.getChannel());
        leads.setType(dto.getType());
        leads.setContent(dto.getContent());
        leads.setStatus(LeadsStatusEnum.UNPROCESS.getValue());
        leads.setIsAllotedCs(YesOrNoEnum.NO.getValue());
        leads.setIsAllotedFp(this.checkCustomerIsAlloted(customerId) ? YesOrNoEnum.YES.getValue() : YesOrNoEnum.NO.getValue());
        baseLeadsMapper.insertSelective(leads);
        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(leads.getId());
    }

    /**
     * 检查参数
     */
    private void checkArgsForInsert(Long customerId, LeadsAddReqDto dto) throws BaseException {
        if (customerId == null)
            throw new BaseException(CodeConstant.CODE_1220047);
        if (dto == null)
            throw new BaseException(CodeConstant.CODE_1220083);
        if (dto.getType() == null)
            throw new BaseException(CodeConstant.CODE_1220081);
        if (BooleanUtils.isNotEmpty(dto.getContent()) && dto.getContent().length() > 120)
            throw new BaseException(CodeConstant.CODE_1220084);
    }

    /**
     * 检查客户是否已被分配给理财师
     *
     * @param customerId 客户id
     */
    private Boolean checkCustomerIsAlloted(Long customerId) throws BaseException {
        BaseUserCustomer userCustomer = userCustomerService.getByCustomerId(customerId);
        return userCustomer != null;
    }
    
    
    /**
     * 查询有预约理财师的客户id集合
     * getHasConsultFpCustomerIds:
     * @author: 欧阳利
     * @param customerIds
     * @return
     * @throws BaseException
     * @description:
     */
    public List<Long> getHasConsultFpCustomerIds(List<Long> customerIds)throws BaseException{
    	if(BooleanUtils.isEmpty(customerIds)){
    		return null;
    	}
    	return  leadsMapper.getHasConsultFpCustomerIds(customerIds);
    }
}
