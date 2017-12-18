package com.yundao.tenant.service.finance.receipt.plan.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.plan.*;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.mapper.base.finance.BaseReceiptDeclarationMapper;
import com.yundao.tenant.mapper.base.finance.BaseReceiptPlanMapper;
import com.yundao.tenant.mapper.base.finance.BaseReceiptRecordMapper;
import com.yundao.tenant.mapper.base.product.BaseProductSupplierMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.finance.receipt.plan.ReceiptPlanMapper;
import com.yundao.tenant.model.base.finance.*;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSupplier;
import com.yundao.tenant.model.base.product.BaseProductSupplierExample;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationExample;
import com.yundao.tenant.service.finance.receipt.ReceiptRecordService;
import com.yundao.tenant.service.finance.receipt.plan.ReceiptPlanService;
import com.yundao.tenant.service.product.ProductService;
import com.yundao.tenant.service.product.supplier.ProductSupplierService;
import com.yundao.tenant.service.product.supplier.SupplierService;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.util.DoubleUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 回款计划服务实现
 *
 * @author jan
 * @create 2017-10-12 13:43
 **/
@Service
public class ReceiptPlanServiceImpl extends AbstractService implements ReceiptPlanService {

    private static Log log = LogFactory.getLog(ReceiptPlanServiceImpl.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private DeclarationService declarationService;

    @Autowired
    private ReceiptRecordService receiptRecordService;

    @Autowired
    ProductSupplierService productSupplierService;

    @Autowired
    private BaseReceiptPlanMapper baseReceiptPlanMapper;

    @Autowired
    private BaseReceiptDeclarationMapper receiptDeclarationMapper;

    @Autowired
    private BaseReceiptRecordMapper baseReceiptRecordMapper;

    @Autowired
    private ReceiptPlanMapper receiptPlanMapper;

    @Autowired
    private BaseReceiptDeclarationMapper baseReceiptDeclarationMapper;

    @Autowired
    private BaseDeclarationMapper baseDeclarationMapper;

    @Autowired
    private BaseProductSupplierMapper baseProductSupplierMapper;

    @Override
    public Result<ReceiptPlanAmountResDto> getAmount(Long declarationId) throws BaseException {
        BaseReceiptDeclarationExample declarationExample = new BaseReceiptDeclarationExample();
        declarationExample.createCriteria().andDeclarationIdEqualTo(declarationId);
        BaseReceiptDeclaration receiptDeclaration = receiptDeclarationMapper.selectOne(declarationExample);
        if (receiptDeclaration == null) {
            return null;
        }
        BaseReceiptPlan receiptPlan = baseReceiptPlanMapper.selectByPrimaryKey(receiptDeclaration.getReceiptPlanId());
        //獲取當前的实际回款金额
        BaseReceiptRecordExample receiptRecordExample = new BaseReceiptRecordExample();
        receiptRecordExample.createCriteria().andReceiptPlanIdEqualTo(receiptPlan.getId());
        List<BaseReceiptRecord> receiptRecordList = baseReceiptRecordMapper.selectByExample(receiptRecordExample);
        Double realityAmount = 0D;
        for (BaseReceiptRecord baseReceiptRecord : receiptRecordList) {
            realityAmount += baseReceiptRecord.getAmount();
        }
        ReceiptPlanAmountResDto resDto = new ReceiptPlanAmountResDto();
        BeanUtils.copyProperties(receiptPlan, resDto);
        resDto.setRealityAmount(realityAmount);
        resDto.setTotalAmount(receiptPlan.getAmount());
        return Result.newSuccessResult(resDto);
    }

    @Override
    public Result<ReceiptPlanAddResult> insert(ReceiptPlanAddReqDto dto) throws BaseException {
        String logPrefix = "回款计划||添加||";
        log.info("%s 入参：%s", logPrefix, JsonUtils.objectToJson(dto));

        Boolean isNameExist = this.checkNameExist(dto.getName());
        if (isNameExist)
            throw new BaseException(CodeConstant.CODE_1220130);

        productService.checkNotNullAndTerminal(dto.getProductId());

        if (dto.getSupplierId() != null) {
            supplierService.checkNotNullAndTerminal(dto.getSupplierId());
            //检查产品和供应商关系
            Integer count = supplierService.getProductAndSupplierRel(dto.getProductId(), dto.getSupplierId());
            if (count <= 0)
                throw new BaseException(CodeConstant.CODE_1220125);
        }

        BaseReceiptPlan model = new BaseReceiptPlan();
        super.initialModel(model);
        model.setAmount(dto.getAmount());
        model.setName(dto.getName());
        model.setPayUnit(dto.getPayUnit());
        model.setProductId(dto.getProductId());
        if (dto.getSupplierId() != null) {
            //这里要存的是产品与供应商的关联表id
            BaseProductSupplierExample bsExample = new BaseProductSupplierExample();
            bsExample.createCriteria().andSupplierIdEqualTo(dto.getSupplierId()).andProductIdEqualTo(dto.getProductId());
            BaseProductSupplier productSupplier = baseProductSupplierMapper.selectOne(bsExample);
            log.info("%s productSupplier %s", logPrefix, JsonUtils.objectToJson(productSupplier));
            if (productSupplier != null) {
                model.setProductSupplierId(productSupplier.getId());
            }
        }

        model.setRemark(dto.getRemark());
        baseReceiptPlanMapper.insertSelective(model);
        log.info("%s 添加回款计划完成", logPrefix);

        Integer declarationCount = doRelReceiptAndDeclaration(model.getId(), dto.getProductId());
        ReceiptPlanAddResult result = new ReceiptPlanAddResult();
        result.setId(model.getId());
        result.setDeclarationCount(declarationCount);

        return Result.newSuccessResult(result);
    }

    @Override
    public Result<Long> update(ReceiptPlanUpdateReqDto dto) throws BaseException {
        String logPrefix = "回款计划||更新||";
        log.info("%s入参 %s", logPrefix, JsonUtils.objectToJson(dto));

        Boolean isNameExist = this.checkNameExistForUpdate(dto.getId(), dto.getName());
        if (isNameExist)
            throw new BaseException(CodeConstant.CODE_1220130);

        BaseReceiptPlan receiptPlan = baseReceiptPlanMapper.selectByPrimaryKey(dto.getId());
        log.info("%s 回款计划实体 %s", logPrefix, JsonUtils.objectToJson(receiptPlan));
        if (receiptPlan == null)
            throw new BaseException(CodeConstant.CODE_1220129);
        super.updateModel(receiptPlan);
        receiptPlan.setName(dto.getName());
        receiptPlan.setPayUnit(dto.getPayUnit());
        receiptPlan.setAmount(dto.getAmount());
        receiptPlan.setRemark(dto.getRemark());
        baseReceiptPlanMapper.updateByPrimaryKeySelective(receiptPlan);
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(receiptPlan.getId());
    }

    @Override
    public Result<ReceiptPlanDetailDto> get(ReceiptPlanDetailReqDto dto) throws BaseException {
        String logPrefix = "回款计划||获取详情||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        BaseReceiptPlan receiptPlan = baseReceiptPlanMapper.selectByPrimaryKey(dto.getId());
        log.info("%s 回款计划实体 %s", logPrefix, JsonUtils.objectToJson(receiptPlan));
        if (receiptPlan == null)
            throw new BaseException(CodeConstant.CODE_1220129);

        ReceiptPlanDetailDto result = new ReceiptPlanDetailDto();
        BeanUtils.copyProperties(receiptPlan, result);
        result.setAmount(DoubleUtils.toWholeString(receiptPlan.getAmount()));
        if (result.getProductId() != null) {
            BaseProduct product = productService.get(result.getProductId());
            if (product != null)
                result.setProductName(product.getName());
        }
        //获取实际回款金额
        Double actualReceiptAmount = receiptRecordService.getActualReceiptAmount(dto.getId());
        log.info("%s 实际回款金额 %s", logPrefix, actualReceiptAmount);
        result.setActualReceiptAmount(DoubleUtils.toWholeString(actualReceiptAmount));
        return Result.newSuccessResult(result);
    }

    /**
     * 关联报单
     *
     * @param receiptPlanId 回款计划id
     * @param productId     产品id
     */
    private Integer doRelReceiptAndDeclaration(Long receiptPlanId, Long productId) throws BaseException {
        String logPrefix = "回款计划||关联报单||";
        log.info("%s 添加关联报单开始", logPrefix);
        List<DeclarationForReceiptResDto> canReceiptDeclarations = declarationService.getCanReceiptDeclarations(productId);

        log.info("%s 可以关联的报单 %s", logPrefix, JsonUtils.objectToJson(canReceiptDeclarations));
        if (BooleanUtils.isNotEmpty(canReceiptDeclarations)) {
            for (DeclarationForReceiptResDto declaration : canReceiptDeclarations) {
                BaseReceiptDeclaration rd = new BaseReceiptDeclaration();
                super.initialModel(rd);
                rd.setDeclarationId(declaration.getId());
                rd.setReceiptPlanId(receiptPlanId);
                baseReceiptDeclarationMapper.insertSelective(rd);
            }
        }
        log.info("%s 完成", logPrefix);
        return canReceiptDeclarations.size();
    }

    @Override
    public Result<PaginationSupport<ReceiptPlanPageResDto>> getPage(ReceiptPlanPageReqDto dto) throws BaseException {
        String logPrefix = "回款计划||分页列表||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<ReceiptPlanPageResDto> page = PaginationSupport.newDefault(paramMap);
        List<ReceiptPlanPageResDto> dtos = receiptPlanMapper.selectReceiptPlanPage(paramMap);
        if (BooleanUtils.isEmpty(dtos))
            return Result.newSuccessResult(page);
        int count = receiptPlanMapper.selectReceiptPlanPageCount(paramMap);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    @Override
    public Result<List<ReceiptPlanRecordListDto>> getReceiptRecordList(Long id) throws BaseException {
        if (id == null)
            throw new BaseException(CodeConstant.CODE_1220124);
        return Result.newSuccessResult(receiptRecordService.getReceiptRecordListForPlanDetail(id));
    }

    @Override
    public Result<List<ReceiptPlanDeclarationDto>> getDeclarationList(Long id) throws BaseException {
        if (id == null)
            throw new BaseException(CodeConstant.CODE_1220124);
        return Result.newSuccessResult(declarationService.getReceiptPlanDeclarations(id));
    }

    private Boolean checkNameExist(String name) throws BaseException {
        ReceiptPlanCheckNameExist dto = new ReceiptPlanCheckNameExist();
        dto.setName(name);
        return this.checkNameExist(dto).getResult();
    }

    private Boolean checkNameExistForUpdate(Long id, String name) throws BaseException {
        ReceiptPlanCheckNameExistForUpdate dto = new ReceiptPlanCheckNameExistForUpdate();
        dto.setId(id);
        dto.setName(name);
        return this.checkNameExistForUpdate(dto).getResult();
    }

    @Override
    public Result<Boolean> checkNameExist(ReceiptPlanCheckNameExist dto) throws BaseException {
        BaseReceiptPlanExample example = new BaseReceiptPlanExample();
        example.createCriteria().andNameEqualTo(dto.getName().trim());
        int count = baseReceiptPlanMapper.countByExample(example);
        return Result.newSuccessResult(count > 0);
    }

    @Override
    public Result<Boolean> checkNameExistForUpdate(ReceiptPlanCheckNameExistForUpdate dto) throws BaseException {
        BaseReceiptPlanExample example = new BaseReceiptPlanExample();
        example.createCriteria().andNameEqualTo(dto.getName().trim()).andIdNotEqualTo(dto.getId());
        int count = baseReceiptPlanMapper.countByExample(example);
        return Result.newSuccessResult(count > 0);
    }

    @Override
    public Result<PermissionResultDto> delete(ReceiptPlanDelReqDto dto) throws BaseException {
        String logPrefix = "回款计划||删除||";
        log.info("%s入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        List<Long> reqIds = SymbolStrUtils.toLongWithTypeCheck(dto.getIds());
        if (BooleanUtils.isEmpty(reqIds))
            throw new BaseException(CodeConstant.CODE_1220126);

        BaseReceiptPlanExample example = new BaseReceiptPlanExample();
        example.createCriteria().andIdIn(reqIds);
        List<BaseReceiptPlan> receiptPlans = baseReceiptPlanMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(receiptPlans))
            throw new BaseException(CodeConstant.CODE_1220127);

        PermissionResultDto resultDto = new PermissionResultDto();
        List<Long> ids = LambdaMap.toSingleList(receiptPlans, BaseReceiptPlan::getId);
        //计划下存在回款记录的，不允许删除
        this.checkReceiptRecord(receiptPlans, resultDto);
        if (!resultDto.isSuccess()) {
            return Result.newSuccessResult(resultDto);
        }

        //删除关联的报单
        this.deleteDeclarationRel(ids);

        //删除回款计划
        for (BaseReceiptPlan receiptPlan : receiptPlans) {
            super.updateModel(receiptPlan);
            receiptPlan.setIsDelete(DeleteEnum.DELETED.getValue());
            baseReceiptPlanMapper.updateByPrimaryKeySelective(receiptPlan);
        }
        log.info("%s回款计划 删除完成", logPrefix);

        log.info("%s执行完毕", logPrefix);
        return Result.newSuccessResult(null);
    }

    @Override
    public Result<PermissionResultDto> insertDeclarationRel(DeclarationRelAddReqDto dto) throws BaseException {
        String logPrefix = "回款计划||添加关联报单||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));

        //检查回款计划是否存在
        BaseReceiptPlan receiptPlan = baseReceiptPlanMapper.selectByPrimaryKey(dto.getReceiptPlanId());
        if (receiptPlan == null)
            throw new BaseException(CodeConstant.CODE_1220127);

        List<Long> ids = SymbolStrUtils.toLongWithTypeCheck(dto.getIds());
        if (BooleanUtils.isEmpty(ids))
            throw new BaseException(CodeConstant.CODE_1220061);
        BaseDeclarationExample example = new BaseDeclarationExample();
        example.createCriteria().andIdIn(ids);
        List<BaseDeclaration> declarations = baseDeclarationMapper.selectByExample(example);
        log.info("%s 报单数据 %s", logPrefix, JsonUtils.objectToJson(declarations));
        if (BooleanUtils.isEmpty(declarations))
            throw new BaseException(CodeConstant.CODE_1220062);

        //查询报单是否已被关联
        BaseReceiptDeclarationExample rdExample = new BaseReceiptDeclarationExample();
        rdExample.createCriteria().andDeclarationIdIn(LambdaMap.toSingleList(declarations, BaseDeclaration::getId));
        List<BaseReceiptDeclaration> rels = baseReceiptDeclarationMapper.selectByExample(rdExample);
        log.info("%s 已被关联的数据%s", logPrefix, JsonUtils.objectToJson(rels));

        for (BaseDeclaration declaration : declarations) {
            if (BooleanUtils.isNotEmpty(rels)) {
                BaseReceiptDeclaration reledItem = LambdaFilter.firstOrDefault(rels, m -> declaration.getId().equals(m.getDeclarationId()));
                if (reledItem != null) {
                    log.info("%s 报单 %s 已被关联", logPrefix, declaration.getId());
                    continue;
                }
            }
            BaseReceiptDeclaration model = new BaseReceiptDeclaration();
            super.initialModel(model);
            model.setReceiptPlanId(dto.getReceiptPlanId());
            model.setDeclarationId(declaration.getId());
            baseReceiptDeclarationMapper.insertSelective(model);
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(null);
    }

    @Override
    public Result<PermissionResultDto> deleteDeclarationRel(DeclarationRelDelReqDto dto) throws BaseException {
        String logPrefix = "回款计划||移除关联报单||";
        log.info("%s入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        List<Long> ids = SymbolStrUtils.toLongWithTypeCheck(dto.getIds());
        if (BooleanUtils.isEmpty(ids))
            throw new BaseException(CodeConstant.CODE_1220061);

        BaseDeclarationExample example = new BaseDeclarationExample();
        example.createCriteria().andIdIn(ids);
        List<BaseDeclaration> declarations = baseDeclarationMapper.selectByExample(example);
        log.info("%s 报单数据 %s", logPrefix, JsonUtils.objectToJson(declarations));
        if (BooleanUtils.isEmpty(declarations))
            throw new BaseException(CodeConstant.CODE_1220062);

        //查询报单是否已被关联
        BaseReceiptDeclarationExample rdExample = new BaseReceiptDeclarationExample();
        rdExample.createCriteria().andDeclarationIdIn(LambdaMap.toSingleList(declarations, BaseDeclaration::getId));
        List<BaseReceiptDeclaration> rels = baseReceiptDeclarationMapper.selectByExample(rdExample);
        log.info("%s 已被关联的数据%s", logPrefix, JsonUtils.objectToJson(rels));

        for (BaseReceiptDeclaration rel : rels) {
            super.updateModel(rel);
            rel.setIsDelete(DeleteEnum.DELETED.getValue());
            baseReceiptDeclarationMapper.updateByPrimaryKeySelective(rel);
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(null);
    }

    @Override
    public Result<ProductSupplierQuotationDetailDto> getSupplier(ReceiptPlanIdDto dto) throws BaseException {
        String logPrefix = "回款计划||获取产品供应商||";
        BaseReceiptPlan receiptPlan = baseReceiptPlanMapper.selectByPrimaryKey(dto.getId());
        log.info("%s 回款计划实体 %s", logPrefix, JsonUtils.objectToJson(receiptPlan));
        if (receiptPlan == null)
            throw new BaseException(CodeConstant.CODE_1220129);
        if (receiptPlan.getProductId() == null || receiptPlan.getProductSupplierId() == null)
            return Result.newSuccessResult();
        List<ProductSupplierQuotationDetailDto> suppliers = productSupplierService.getProductSupplierQuotationDetailDtos(receiptPlan.getProductId());
        if (BooleanUtils.isEmpty(suppliers))
            return Result.newSuccessResult();

        ProductSupplierQuotationDetailDto supplier = LambdaFilter.firstOrDefault(suppliers, m -> m.getId().equals(receiptPlan.getProductSupplierId()));
        return Result.newSuccessResult(supplier);
    }

    /**
     * 检查计划下是否存在回款记录
     *
     * @param receiptPlans 回款计划列表
     */
    private void checkReceiptRecord(List<BaseReceiptPlan> receiptPlans, PermissionResultDto resultDto) throws BaseException {
        String logPrefix = "回款计划||删除||检查计划下是否存在回款记录";
        log.info("%s receiptPlans：%s，resultDto：%s", logPrefix, JsonUtils.objectToJson(receiptPlans), JsonUtils.objectToJson(resultDto));
        List<Long> receiptPlanIds = LambdaMap.toSingleList(receiptPlans, BaseReceiptPlan::getId);
        BaseReceiptRecordExample example = new BaseReceiptRecordExample();
        example.createCriteria().andReceiptPlanIdIn(receiptPlanIds);
        List<BaseReceiptRecord> records = baseReceiptRecordMapper.selectByExample(example);
        log.info("%s records %s", logPrefix, JsonUtils.objectToJson(records));
        if (BooleanUtils.isEmpty(records))
            return;
        for (BaseReceiptPlan receiptPlan : receiptPlans) {
            BaseReceiptRecord record = LambdaFilter.firstOrDefault(records, m -> m.getReceiptPlanId().equals(receiptPlan.getId()));
            if (record != null) {
                FailListDto fail = new FailListDto();
                fail.setId(receiptPlan.getId());
                fail.setName(receiptPlan.getName());
                fail.setCode(CodeConstant.CODE_1220128);
                resultDto.getFailList().add(fail);
            } else {
                PassListDto pass = new PassListDto();
                pass.setId(receiptPlan.getId());
                pass.setName(receiptPlan.getName());
                resultDto.getPassList().add(pass);
            }
        }
        log.info("%s完成 result %s", logPrefix, JsonUtils.objectToJson(resultDto));
    }

    /**
     * 逻辑删除回款计划与报单的关联关系
     *
     * @param receiptPlanIds 回款计划id
     */
    private void deleteDeclarationRel(List<Long> receiptPlanIds) throws BaseException {
        String logPrefix = "回款计划||删除||删除与报单的关联关系";
        log.info("%s入参 %s", logPrefix, JsonUtils.objectToJson(receiptPlanIds));
        BaseReceiptDeclarationExample example = new BaseReceiptDeclarationExample();
        example.createCriteria().andReceiptPlanIdIn(receiptPlanIds);
        List<BaseReceiptDeclaration> rels = baseReceiptDeclarationMapper.selectByExample(example);
        log.info("%s rels %s", logPrefix, JsonUtils.objectToJson(rels));
        if (BooleanUtils.isEmpty(rels))
            return;
        for (BaseReceiptDeclaration rel : rels) {
            super.updateModel(rel);
            rel.setIsDelete(DeleteEnum.DELETED.getValue());
            baseReceiptDeclarationMapper.updateByPrimaryKeySelective(rel);
        }
        log.info("%s删除完成", logPrefix);
    }
}
