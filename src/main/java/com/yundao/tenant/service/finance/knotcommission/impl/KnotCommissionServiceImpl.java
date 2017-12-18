package com.yundao.tenant.service.finance.knotcommission.impl;

import com.yundao.core.code.Result;
import com.yundao.core.dto.dictionary.DictionariesDto;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.WorkflowAuditReqDto;
import com.yundao.tenant.dto.finance.knotcommission.*;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanAmountResDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import com.yundao.tenant.dto.workflow.ProcessStartResDTO;
import com.yundao.tenant.dto.workflow.task.KnotCommissionTaskDto;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.ScopeEnum;
import com.yundao.tenant.enums.finance.KnotCommissionStatusEnum;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.finance.BaseKnotCommissionMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.finance.knotcommission.KnotCommissionMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.mapper.workflow.TaskMapper;
import com.yundao.tenant.model.base.finance.BaseKnotCommission;
import com.yundao.tenant.model.base.finance.BaseKnotCommissionExample;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.finance.knotcommission.KnotCommissionService;
import com.yundao.tenant.service.finance.receipt.plan.ReceiptPlanService;
import com.yundao.tenant.service.product.commission.ProductCommissionRuleService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.CamelUtil;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.LocalBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class KnotCommissionServiceImpl extends AbstractService implements KnotCommissionService {

    @Autowired
    private BaseKnotCommissionMapper baseKnotCommissionMapper;

    @Autowired
    private KnotCommissionMapper knotCommissionMapper;

    @Autowired
    private WorkflowServie workflowServie;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private ProductCommissionRuleService productCommissionRuleService;

    @Autowired
    private BaseDeclarationMapper baseDeclarationMapper;

    @Autowired
    private DeclarationMapper declarationMapper;

    @Autowired
    private ReceiptPlanService receiptPlanService;


    @Autowired
    TaskMapper taskMapper;

    private String defaultSortName = "create_date";
    private String defaultSort = "desc";

    private static Log log = LogFactory.getLog(KnotCommissionServiceImpl.class);

    private static String logPrefix = "结佣||添加||";

    public Result<Integer> add(KnotCommissionReqDto reqDto) throws Exception {
        if (reqDto.getAmount() < 0) {
            throw new BaseException(GJLCodeConstant.CODE_1210129);
        }
        if (reqDto.getRate() < 0) {
            throw new BaseException(GJLCodeConstant.CODE_1210130);
        }
        Long declarationId = reqDto.getDeclarationId();
        //判断当前报单的状态
        BaseDeclaration declaration = baseDeclarationMapper.selectByPrimaryKey(declarationId);
        if (declaration == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210066);
        }
        if (!DeclarationStatusEnum.PASS.getValue().equals(declaration.getStatus())) {
            throw new BaseException(GJLCodeConstant.CODE_1210095);
        }
        BaseKnotCommission model = new BaseKnotCommission();
        BeanUtils.copyProperties(reqDto, model);
        Date date = new Date();
        model.setCreateDate(date);
        model.setCreateUserId(super.getHeaderUserId());
        model.setUserId(super.getHeaderUserId());
        model.setTenantId(super.getHeaderTenantId());
        model.setApplyDate(date);
        //获取状态，如果没配置状态就用默认的
        DictionariesDto dictionaryDto = dictionaryService.get(DicCode.DIC_KNOTCOMMISSION_STATUS, null);
        Integer status = KnotCommissionStatusEnum.APPROVALING.getValue();
        if (dictionaryDto != null) {
            status = Integer.valueOf(dictionaryDto.getValue());
        }
        model.setStatus(status);
        model.setId(null);
        int count = baseKnotCommissionMapper.insertSelective(model);
        //发起结佣流程
        ProcessStartResDTO dto = workflowServie.start(model.getId(), ProcessDefineKeyEnum.KNOT_COMMISSION.getKey(),
                BusinessTypeCode.KNOT_COMMISSION);
        log.info("%s启动工作流完成 流水号：%s", logPrefix, dto.getBusinessKey());
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(KnotCommissionReqDto reqDto) throws Exception {
        BaseKnotCommission model = new BaseKnotCommission();
        BeanUtils.copyProperties(reqDto, model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseKnotCommissionMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception {
        BaseKnotCommission knotCommission = new BaseKnotCommission();
        knotCommission.setId(id);
        knotCommission.setUpdateDate(new Date());
        knotCommission.setUpdateUserId(super.getHeaderUserId());
        int count = baseKnotCommissionMapper.updateByPrimaryKeySelective(knotCommission);
        return Result.newSuccessResult(count);
    }

    public Result<KnotCommissionResDto> get(Long declarationId) throws Exception {
        BaseDeclaration baseDeclaration = baseDeclarationMapper.selectByPrimaryKey(declarationId);
        if (baseDeclaration == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210066);
        }
        List<ProductCommissionRuleDetailDto> productCommissionRuleDetailDtos = productCommissionRuleService.getCommissionRuleDetailDtos(baseDeclaration.getProductId());
        KnotCommissionResDto resDto = new KnotCommissionResDto();
        resDto.setProductCommissionRules(productCommissionRuleDetailDtos);
        //获取其他的
        Result<ReceiptPlanAmountResDto> planAmountResDtoResult = receiptPlanService.getAmount(declarationId);
        if (planAmountResDtoResult != null && planAmountResDtoResult.getSuccess()) {
            ReceiptPlanAmountResDto planAmountResDto = planAmountResDtoResult.getResult();
            resDto.setTotalAmount(planAmountResDto.getTotalAmount());
            resDto.setRealityAmount(planAmountResDto.getRealityAmount());
            resDto.setReceiptPlanId(planAmountResDto.getId());
        }
        return Result.newSuccessResult(resDto);
    }

    public Result<PaginationSupport<BaseKnotCommission>> getPage(KnotCommissionListReqDto knotCommissionReqDto, AbstractBasePageDto pageDto) throws Exception {
        BaseKnotCommissionExample baseKnotCommissionExample = new BaseKnotCommissionExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseKnotCommissionExample.Criteria criteria = baseKnotCommissionExample.createCriteria();
        String orderByClause = "provide_date desc,id desc";
        criteria.andDeclarationIdEqualTo(knotCommissionReqDto.getDeclarationId());
        baseKnotCommissionExample.setOrderByClause(orderByClause);
        List<BaseKnotCommission> list = baseKnotCommissionMapper.selectByExample(baseKnotCommissionExample);
        int totalCount = baseKnotCommissionMapper.countByExample(baseKnotCommissionExample);
        PaginationSupport<BaseKnotCommission> result = pageDto.getPaginationSupport();
        result.setDatas(list);
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<PaginationSupport<DeclarationKnot>> getDeclarationPage(KnotCommissionPageReqDto dto, BasePageDto pageDto) throws Exception {
        if (dto.getCommitDateEnd() != null) {
            dto.setCommitDateEnd(DateUtils.parse(DateUtils.getDateEnd(dto.getCommitDateEnd()), DateUtils.YYYY_MM_DD_HH_MM_SS));
        }
        Map<String, Object> params = LocalBeanUtils.toMap(dto);
        if (BooleanUtils.isEmpty(pageDto.getOrderColumn())) {
            pageDto.setOrderColumn(defaultSortName);
            pageDto.setSort(defaultSort);
        } else {
            pageDto.setOrderColumn(CamelUtil.toline(pageDto.getOrderColumn()));
            if (BooleanUtils.isNotEmpty(pageDto.getSort())) {
                pageDto.setSort(pageDto.getSort());
            } else {
                pageDto.setSort(defaultSort);
            }
        }

        if (ScopeEnum.MONTH.getCode().equals(dto.getScope())) {
            params.put("commitDateEnd", new Date());
            params.put("commitDateStart", DateUtil.getFirstMonth());
        } else if (ScopeEnum.UNPROCESS.getCode().equals(dto.getScope())) {
            params.put("countIsNull", false);
        } else if (ScopeEnum.ALL.getCode().equals(dto.getScope())) {
            //不添加任何参数
        } else {
            throw new BaseException(GJLCodeConstant.CODE_1210097);
        }
        params.putAll(LocalBeanUtils.toMap(pageDto));
        params.put("status", DeclarationStatusEnum.PASS.getValue());
        PaginationSupport<DeclarationKnot> pager = PaginationSupport.newDefault(params);
        int totalCount = declarationMapper.queryPageKnotCount(params);
        List<DeclarationKnot> list = declarationMapper.queryPageKnotInfo(params);
        pager.setDatas(list);
        pager.setTotalCount(totalCount);
        return Result.newSuccessResult(pager);
    }

    @Override
    public Result<PaginationSupport<DeclarationAuditKnot>> getsAudit(KnotCommissionAuditPageReqDto dto, BasePageDto pageDto) throws BaseException, SQLException {
        Map<String, Object> params = LocalBeanUtils.toMap(dto);
        if (BooleanUtils.isEmpty(pageDto.getOrderColumn())) {
            pageDto.setOrderColumn(defaultSortName);
            pageDto.setSort(defaultSort);
        } else {
            pageDto.setOrderColumn(CamelUtil.toline(pageDto.getOrderColumn()));
            if (BooleanUtils.isNotEmpty(pageDto.getSort())) {
                pageDto.setSort(pageDto.getSort());
            } else {
                pageDto.setSort(defaultSort);
            }
        }
        if (BooleanUtils.isNotEmpty(dto.getStatus())) {
            String status = dto.getStatus();
            String[] arrs = status.split(CommonConstant.COMMA);
            List<Integer> statusList = new ArrayList<>();
            for (String arr : arrs) {
                statusList.add(Integer.valueOf(arr));
            }
            params.put("statusList", statusList);
        }
        params.putAll(LocalBeanUtils.toMap(pageDto));
        PaginationSupport<DeclarationAuditKnot> pager = PaginationSupport.newDefault(params);
        int totalCount = declarationMapper.queryPageAuditKnotCount(params);
        List<DeclarationAuditKnot> list = declarationMapper.queryPageAuditKnotInfo(params);
        pager.setDatas(list);
        pager.setTotalCount(totalCount);
        return Result.newSuccessResult(pager);
    }

    @Override
    public Result<Integer> processAudit(WorkflowAuditReqDto dto) throws BaseException {
        BaseKnotCommission knotCommission = baseKnotCommissionMapper.selectByPrimaryKey(dto.getId());
        if (knotCommission == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210099);
        }
        if (!KnotCommissionStatusEnum.APPROVALING.getValue().equals(knotCommission.getStatus())) {
            throw new BaseException(GJLCodeConstant.CODE_1210100);
        }
        if (dto.getAction().equals(WorkflowActionEnum.PASS.getValue())) {
            knotCommission.setStatus(KnotCommissionStatusEnum.PASS.getValue());

        } else if (dto.getAction().equals(WorkflowActionEnum.NO_PASS.getValue())) {
            if (BooleanUtils.isEmpty(dto.getReason())) {
                throw new BaseException(GJLCodeConstant.CODE_1210101);
            }
            knotCommission.setStatus(KnotCommissionStatusEnum.NO_PASS.getValue());
            knotCommission.setAuditReason(dto.getReason());
        }
        Date now = new Date();
        knotCommission.setAuditDate(now);
        knotCommission.setOperationDate(now);
        baseKnotCommissionMapper.updateByPrimaryKeySelective(knotCommission);
        String taskId = workflowServie.getTODOTaskId(dto.getId(), BusinessTypeCode.KNOT_COMMISSION, false).getResult();
        //调用工作流
        workflowServie.complete(taskId, dto.getAction(), dto.getReason());
        return Result.newSuccessResult(1);
    }


    public Result<KnotCommissionTaskDto> getTaskDto(Long id) throws Exception {
        KnotCommissionTaskDto dto = taskMapper.getKnotCommissionTaskDto(id);
        if (dto != null) {
            dto.setTypeText(dictionaryService.toText("dic_knotcommission_type", dto.getType()));
        }
        return Result.newSuccessResult(dto);
    }

}
