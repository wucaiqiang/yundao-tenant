package com.yundao.tenant.service.sale.leads.allot.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.distribution.CustomerAllotReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsAllotReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsAllotToFpReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsRemindResDto;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserVisitMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsVisitRelMapper;
import com.yundao.tenant.mapper.sale.leads.LeadsMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import com.yundao.tenant.model.base.customer.BaseUserVisit;
import com.yundao.tenant.model.base.sale.BaseLeads;
import com.yundao.tenant.model.base.sale.BaseLeadsExample;
import com.yundao.tenant.model.base.sale.BaseLeadsVisitRel;
import com.yundao.tenant.service.customer.distribution.CustomerDistributionService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.sale.leads.LeadsService;
import com.yundao.tenant.service.sale.leads.allot.LeadsAllotService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.SymbolStrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线索分配服务实现
 *
 * @author jan
 * @create 2017-09-09 PM6:32
 **/
@Service
public class LeadsAllotServiceImpl extends AbstractService implements LeadsAllotService {

    private static Log log = LogFactory.getLog(LeadsAllotServiceImpl.class);

    @Autowired
    private LeadsMapper leadsMapper;

    @Autowired
    private BaseLeadsMapper baseLeadsMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private BaseUserVisitMapper baseUserVisitMapper;

    @Autowired
    private BaseLeadsVisitRelMapper baseLeadsVisitRelMapper;

    @Autowired
    private BaseUserCustomerMapper baseUserCustomerMapper;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private LeadsService leadsService;

    @Autowired
    private CustomerDistributionService customerDistributionService;

    @Override
    public Result<List<LeadsRemindResDto>> doTryAllot(LeadsAllotReqDto dto) throws BaseException {
        String logPrefix = "销售线索分配||尝试分配回访||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
        List<BaseLeads> leadsList = checkAndGetLeads(dto);

        List<LeadsRemindResDto> dtos = this.getAlloted(dto.getCustomerId(), dto.getUserId());
        log.info("%s getAlloted结果 %s", logPrefix, JsonUtils.objectToJson(dtos));
        //如果存在同一客户的线索分配给不同的负责人，返回提示给前端
        if (BooleanUtils.isNotEmpty(dtos))
            return Result.newSuccessResult(dtos);

        insertVisitAndUpdateLeads(dto, leadsList);
        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(null);
    }

    @Override
    public Result<Boolean> doAllot(LeadsAllotReqDto dto) throws BaseException {
        String logPrefix = "销售线索分配||分配回访||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
        List<BaseLeads> leadsList = checkAndGetLeads(dto);
        insertVisitAndUpdateLeads(dto, leadsList);
        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(true);
    }

    @Override
    public Result<Boolean> doAllotToFp(LeadsAllotToFpReqDto dto) throws BaseException {
        String logPrefix = "销售线索分配||分配给理财师||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
        BaseUserCustomerExample ucExample = new BaseUserCustomerExample();
        ucExample.createCriteria().andCustomerIdEqualTo(dto.getCustomerId());
        int ucCount = baseUserCustomerMapper.countByExample(ucExample);
        log.info("%s ucCount %s", logPrefix, ucCount);
        if (ucCount > 0)
            throw new BaseException(CodeConstant.CODE_1220101);
        CustomerAllotReqDto reqDto = new CustomerAllotReqDto();
        reqDto.setCustomerIds(dto.getCustomerId().toString());
        reqDto.setFpId(dto.getFpId());
        Result<PermissionResultDto> result = customerDistributionService.doAllotToFp(reqDto);
        log.info("%s 调用分配方法返回结果 %s", logPrefix, JsonUtils.objectToJson(result));
        if (!result.getSuccess())
            return result.newFailureResult(result.getCode());
        if (result.getResult() != null && !result.getResult().isSuccess())
            throw new BaseException(CodeConstant.CODE_1220109);

        //分配成功
        BaseLeadsExample leadsExample = new BaseLeadsExample();
        leadsExample.createCriteria().andCustomerIdEqualTo(dto.getCustomerId()).andIsAllotedFpEqualTo(YesOrNoEnum.NO.getValue());
        List<BaseLeads> leadsList = baseLeadsMapper.selectByExample(leadsExample);
        log.info("%s leadsList %s", logPrefix, JsonUtils.objectToJson(leadsList));
        this.doUpdateIsAllotedFp(leadsList);
        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(true);
    }

    private List<BaseLeads> checkAndGetLeads(LeadsAllotReqDto dto) throws BaseException {
        List<Long> idList = checkArgsForAllot(dto);
        List<BaseLeads> leadsList = getLeadsList(idList);
        for (BaseLeads leads : leadsList) {
            if (!leadsService.checkCanBeAllotToCs(leads.getIsOnceInvalid(), leads.getIsAllotedCs()))
                throw new BaseException(CodeConstant.CODE_1220100);
        }
        this.checkLeadsBelongCustomer(dto.getCustomerId(), leadsList);
        return leadsList;
    }

    /**
     * 检查需要分配的线索 与 传入的客户id是否一致
     */
    private void checkLeadsBelongCustomer(Long customerId, List<BaseLeads> leadsList) throws BaseException {
        for (BaseLeads leads : leadsList) {
            if (!customerId.equals(leads.getCustomerId()))
                throw new BaseException(CodeConstant.CODE_1220099);
        }
    }

    /**
     * 获取已分配线索
     *
     * @param customerId 客户id
     * @param userId     需要过滤的负责人id
     */
    private List<LeadsRemindResDto> getAlloted(Long customerId, Long userId) throws BaseException {
        String logPrefix = "销售线索分配||获取客户已被分配的线索||";
        log.info("%s customerId %s", logPrefix, customerId);
        Date limitDate = DateUtil.addDay(new Date(), -7);
        String limitDateStr = DateUtils.format(limitDate, DateUtils.YYYY_MM_DD_HH_MM_SS);
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("userId", userId);
        paramMap.put("limitDate", limitDateStr);
        paramMap.put("customerId", customerId);
        List<LeadsRemindResDto> dtos = leadsMapper.selectRemindAlloted(paramMap);
        log.info("%s dtos %s", logPrefix, JsonUtils.objectToJson(dtos));
        this.setTextsForAllt(dtos);
        return dtos;
    }

    private void insertVisitAndUpdateLeads(LeadsAllotReqDto dto, List<BaseLeads> leadsList) {
        Date now = new Date();
        for (BaseLeads leads : leadsList) {
            BaseUserVisit userVisit = new BaseUserVisit();
            super.initialModel(userVisit);
            userVisit.setSubDate(now);
            userVisit.setUserId(dto.getUserId());
            userVisit.setCustomerId(dto.getCustomerId());
            userVisit.setMatter(dto.getMatter());
            baseUserVisitMapper.insertSelective(userVisit);

            BaseLeadsVisitRel rel = new BaseLeadsVisitRel();
            super.initialModel(rel);
            rel.setLeadsId(leads.getId());
            rel.setUserVisitId(userVisit.getId());
            baseLeadsVisitRelMapper.insertSelective(rel);

            super.updateModel(leads);
            leads.setIsAllotedCs(YesOrNoEnum.YES.getValue());
            baseLeadsMapper.updateByPrimaryKeySelective(leads);
        }
    }

    private void setTextsForAllt(List<LeadsRemindResDto> dtos) throws BaseException {
        for (LeadsRemindResDto dto : dtos) {
            dto.setTypeText(dictionaryService.toText(DicCode.LEADS_TYPE, dto.getType()));
            dto.setChannelText(dictionaryService.toText(DicCode.LEADS_CHANNEL, dto.getChannel()));
        }
    }

    private List<BaseLeads> getLeadsList(List<Long> idList) throws BaseException {
        BaseLeadsExample example = new BaseLeadsExample();
        example.createCriteria().andIdIn(idList);
        List<BaseLeads> leadsList = baseLeadsMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(leadsList))
            throw new BaseException(CodeConstant.CODE_1220097);
        return leadsList;
    }

    private List<Long> checkArgsForAllot(LeadsAllotReqDto dto) throws BaseException {
        BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(dto.getCustomerId());
        if (customer == null)
            throw new BaseException(CodeConstant.CODE_1200084);
        boolean userExist = userService.checkUserExist(dto.getUserId());
        if (!userExist)
            throw new BaseException(CodeConstant.CODE_1220094);
        List<Long> idList = SymbolStrUtils.toLongWithTypeCheck(dto.getLeadsIds());
        if (BooleanUtils.isEmpty(idList))
            throw new BaseException(CodeConstant.CODE_1220097);
        return idList;
    }

    @Override
    public Result<List<LeadsRemindResDto>> getUnAllots(Long customerId) throws BaseException {
        String logPrefix = "销售线索分配||获取客户未分配线索||";
        log.info("%s customerId %s", logPrefix, customerId);
        BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(customerId);
        if (customer == null)
            throw new BaseException(CodeConstant.CODE_1200084);
        List<LeadsRemindResDto> dtos = leadsMapper.selectRemindUnAllot(customerId);
        this.setTextsForAllt(dtos);
        log.info("%s dtos %s", logPrefix, JsonUtils.objectToJson(dtos));
        return Result.newSuccessResult(dtos);
    }


    @Override
    public void updateIsAllotedFp(Long customerId) throws BaseException {
        BaseLeadsExample example = new BaseLeadsExample();
        example.createCriteria().andCustomerIdEqualTo(customerId).andIsAllotedFpEqualTo(YesOrNoEnum.NO.getValue());
        List<BaseLeads> leadsList = baseLeadsMapper.selectByExample(example);
        log.info("updateIsAllotedFp leadsList %s", JsonUtils.objectToJson(leadsList));
        this.doUpdateIsAllotedFp(leadsList);
    }

    private void doUpdateIsAllotedFp(List<BaseLeads> leadsList) throws BaseException {
        if (BooleanUtils.isNotEmpty(leadsList)) {
            for (BaseLeads leads : leadsList) {
                super.updateModel(leads);
                leads.setIsAllotedFp(YesOrNoEnum.YES.getValue());
                baseLeadsMapper.updateByPrimaryKeySelective(leads);
            }
        }
    }

    @Override
    public BaseLeads getById(Long id) throws BaseException {
        return baseLeadsMapper.selectByPrimaryKey(id);
    }
}
