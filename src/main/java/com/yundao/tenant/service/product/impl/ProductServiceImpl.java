package com.yundao.tenant.service.product.impl;

import com.yundao.core.code.Result;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.Code1220000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.field.FieldValueDto;
import com.yundao.tenant.dto.product.*;
import com.yundao.tenant.dto.product.add.*;
import com.yundao.tenant.enums.bo.FieldPrefixEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.mapper.base.product.*;
import com.yundao.tenant.mapper.product.ProductUpdateMapper;
import com.yundao.tenant.model.base.product.*;
import com.yundao.tenant.service.field.FieldValueService;
import com.yundao.tenant.service.product.ProductService;
import com.yundao.tenant.service.product.attach.ProductAttachService;
import com.yundao.tenant.service.product.commission.ProductCommissionRuleService;
import com.yundao.tenant.service.product.income.ProductIncomeRuleService;
import com.yundao.tenant.service.product.sale.ProductSaleService;
import com.yundao.tenant.service.product.supplier.ProductSupplierService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl extends AbstractService implements ProductService {

    private static Log log = LogFactory.getLog(ProductServiceImpl.class);

    @Autowired
    BaseProductMapper baseProductMapper;
    @Autowired
    ProductSaleService productSaleService;
    @Autowired
    ProductSupplierService productSupplierService;
    @Autowired
    ProductAttachService productAttachService;
    @Autowired
    ProductIncomeRuleService productIncomeRuleService;
    @Autowired
    ProductCommissionRuleService productCommissionRuleService;
    @Autowired
    FieldValueService fieldValueService;
    @Autowired
    ProductUpdateMapper productUpdateMapper;
    @Autowired
    BaseProductFocusMapper baseProductFocusMapper;

    @Autowired
    private BaseProductFieldValueMapper baseProductFieldValueMapper;

    @Autowired
    private BaseProductAttachMapper baseProductAttachMapper;

    @Autowired
    private BaseProductIncomeMapper baseProductIncomeMapper;

    @Autowired
    private BaseProductIncomeRuleMapper baseProductIncomeRuleMapper;

    @Autowired
    private BaseProductSaleMapper baseProductSaleMapper;

    /**
     * 获取添加的集合
     *
     * @return
     */
    public ProductAddListDto getProductAddListDto(ProductAddReqDto productAddReqDto) throws Exception {
        ProductAddListDto dto = new ProductAddListDto();
        // 添加供应商, 供应商报价
        List<ProductSupplierDto> supplierDtos = productSupplierService.getProductSupplierDto(productAddReqDto.getSupplierDtos());
        dto.setSupplierDtos(supplierDtos);
        // 添加佣金信息
        List<ProductCommissionRuleDto> commissionDtos = productCommissionRuleService.getProductCommissionRuleDto(productAddReqDto.getCommissionDtos());
        dto.setCommissionDtos(commissionDtos);
        // 添加收益信息
        List<ProductIncomeRuleDto> productIncomeRuleDtos = productIncomeRuleService.getProductIncomeRuleDto(productAddReqDto.getIncomeDtos());
        dto.setProductIncomeRuleDtos(productIncomeRuleDtos);
        // 添加附件
        List<ProductAttachDto> attachDtos = productAttachService.getProductAttachDto(productAddReqDto.getAttachDtos());
        dto.setAttachDtos(attachDtos);
        return dto;
    }


    /**
     * 数据校验
     *
     * @param dto
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkProductAddListDto(ProductAddListDto dto, Integer isScale, Double productScale) throws BaseException {
        // 校验报价
        Result<Boolean> quoResult = productSupplierService.checkProductSupplierforAdd(dto.getSupplierDtos(), isScale, productScale);
        if (!quoResult.getSuccess()) {
            return quoResult;
        }

        // 校验佣金
        Result<Boolean> commissionResult = productCommissionRuleService.checkCommissionRuleAddDtos(dto.getCommissionDtos(), isScale, productScale);
        if (!commissionResult.getSuccess()) {
            return commissionResult;
        }

        // 校验收益
        Result<Boolean> incomeResult = productIncomeRuleService.checkIncomeRuleAddDtos(dto.getProductIncomeRuleDtos(), isScale, productScale);
        if (!incomeResult.getSuccess()) {
            return incomeResult;
        }
        return Result.newSuccessResult(true);
    }


    /**
     * 添加产品
     *
     * @param productAddReqDto
     * @return
     * @throws BaseException
     */
    public Result<Long> saveProduct(ProductAddReqDto productAddReqDto, Map<String, String> params, List<FieldDto> list, ProductAddListDto productAddListDto) throws BaseException, Exception {
        Date now = new Date();
        // 添加产品基本信息
        BaseProduct product = new BaseProduct();
        BeanUtils.copyProperties(productAddReqDto, product);
        product.setCreateUserId(this.getHeaderUserId());
        product.setTenantId(this.getHeaderTenantId());
        product.setCreateDate(now);
        product.setIsDelete(0);
        product.setIssuedStatus(ProductIssuedStatusEnum.NOT_ON_LINE.getValue());
        baseProductMapper.insert(product);

        // 添加产品自定义字段
        saveExtProperty(params, product.getId(), list);

        // 添加销售信息
        BaseProductSale productSale = new BaseProductSale();
        BeanUtils.copyProperties(productAddReqDto, productSale);
        productSale.setProductId(product.getId());
        productSaleService.saveProductSale(productSale);

        // 添加供应商, 供应商报价
        List<ProductSupplierDto> supplierDtos = productAddListDto.getSupplierDtos();
        productSupplierService.saveProductSupplierQuotation(supplierDtos, product.getId());

        // 添加佣金信息
        List<ProductCommissionRuleDto> commissionDtos = productAddListDto.getCommissionDtos();
        productCommissionRuleService.saveCommissionDtos(commissionDtos, product.getId());

        // 添加收益信息
        List<ProductIncomeRuleDto> productIncomeRuleDtos = productAddListDto.getProductIncomeRuleDtos();
        productIncomeRuleService.saveProductIncomeRuleDtos(productIncomeRuleDtos, product.getId());

        // 添加附件
        List<ProductAttachDto> attachDtos = productAddListDto.getAttachDtos();
        productAttachService.saveProductAttach(attachDtos, product.getId());

        return Result.newSuccessResult(product.getId());
    }


    /**
     * 修改产品基本信息
     *
     * @param updateReqDto
     * @param params
     * @param list
     * @return
     * @throws BaseException
     * @throws Exception
     */
    public Result<Integer> updateBaseProduct(ProductBaseUpdateReqDto updateReqDto, Map<String, String> params, List<FieldDto> list) throws Exception {
        // 添加基本信息
        BaseProduct record = new BaseProduct();
        BeanUtils.copyProperties(updateReqDto, record);
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        int count = productUpdateMapper.updateProductByPrimaryKey(record);

        // 添加扩展表的信息
        updateExtProperty(params, record.getId(), list);

        return Result.newSuccessResult(count);
    }

    /**
     * 删除产品信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public Result<Integer> delete(List<Long> ids) throws Exception {
        if (BooleanUtils.isEmpty(ids)) {
            return Result.newSuccessResult(0);
        }
        BaseProduct record = new BaseProduct();
        record.setIsDelete(1);
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        BaseProductExample example = new BaseProductExample();
        example.createCriteria().andIdIn(ids);
        int count = baseProductMapper.updateByExampleSelective(record, example);
        return Result.newSuccessResult(count);
    }


    /**
     * 关注产品
     */
    public Result<Integer> doFocusProduct(List<Long> productIds) throws Exception {
        if (BooleanUtils.isEmpty(productIds)) {
            return Result.newSuccessResult(0);
        }
        BaseProductFocusExample example = new BaseProductFocusExample();
        example.createCriteria().andProductIdIn(productIds).andUserIdEqualTo(this.getHeaderUserId());
        List<BaseProductFocus> list = baseProductFocusMapper.selectByExample(example);
        int count = 0;
        for (Long productId : productIds) {
            boolean isExist = false;
            for (BaseProductFocus base : list) {
                if (base.getProductId().equals(productId)) {
                    isExist = true;
                }
            }
            if (!isExist) {
                BaseProductFocus record = new BaseProductFocus();
                record.setTenantId(this.getHeaderTenantId());
                record.setCreateUserId(this.getHeaderUserId());
                record.setCreateDate(new Date());
                record.setProductId(productId);
                record.setFocusDate(new Date());
                record.setIsDelete(0);
                record.setUserId(this.getHeaderUserId());
                count = count + baseProductFocusMapper.insert(record);
            }
        }

        return Result.newSuccessResult(count);
    }

    /**
     * 取消产品关注
     */
    public Result<Integer> doCancelFocusProduct(List<Long> productIds) throws Exception {
        if (BooleanUtils.isEmpty(productIds)) {
            return Result.newSuccessResult(0);
        }
        BaseProductFocusExample example = new BaseProductFocusExample();
        example.createCriteria().andProductIdIn(productIds).andUserIdEqualTo(this.getHeaderUserId());
        int count = baseProductFocusMapper.deleteByExample(example);
        return Result.newSuccessResult(count);
    }

    @Override
    public BaseProduct get(Long id) throws BaseException {
        return baseProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public void checkNotNullAndTerminal(Long id) throws BaseException {
        BaseProduct product = baseProductMapper.selectByPrimaryKey(id);
        if (product == null)
            throw new BaseException(CodeConstant.CODE_1200042);
    }

    @Override
    public Result<Long> doImportFormFund(FundDto dto) throws BaseException {
        String logPrefix = "产品||从基金导入||";
        log.info("%s dto=%s", logPrefix, JsonUtils.objectToJson(dto));

        this.checkNameExist(dto);

        //插入产品
        BaseProduct product = new BaseProduct();
        super.initialModel(product);
        BeanUtils.copyProperties(dto, product);
        product.setId(null);
        product.setIssuedStatus(ProductIssuedStatusEnum.NOT_ON_LINE.getValue());
        product.setCreateUserId(super.getHeaderUserId());
        product.setCreateDate(new Date());
        product.setUpdateDate(null);
        product.setUpdateUserId(null);
        log.info("%s product=%s", logPrefix, JsonUtils.objectToJson(product));
        baseProductMapper.insertSelective(product);
        log.info("%s 插入产品完成", logPrefix);

        this.insertFieldValueFromFund(dto.getFieldValues(), product.getId());
        log.info("%s 插入产品自定义字段完成", logPrefix);

        this.insertAttachFromFund(dto.getAttachs(), product.getId());
        log.info("%s 插入产品附件完成", logPrefix);

        this.insertSaleFromFund(dto.getRaises(), product.getId());
        log.info("%s 插入产品销售信息完成", logPrefix);

        this.insertIncomeFromFund(dto.getIncomeRules(), dto.getIncomes(), product.getId());
        log.info("%s 插入收益完成", logPrefix);

        log.info("%s 操作成功", logPrefix);
        return Result.newSuccessResult(product.getId());
    }

    private void insertIncomeFromFund(List<FundIncomeRuleDto> incomeRules, List<FundIncomeDto> incomes, Long
            productId) {
        Date now = new Date();
        Long userId = super.getHeaderUserId();
        for (FundIncomeRuleDto incomeRule : incomeRules) {
            BaseProductIncomeRule pir = new BaseProductIncomeRule();
            super.initialModel(pir);
            pir.setId(null);
            pir.setProductId(productId);
            pir.setRemark(incomeRule.getRemark());
            pir.setRuleName(incomeRule.getRuleName());
            baseProductIncomeRuleMapper.insertSelective(pir);

            if (BooleanUtils.isNotEmpty(incomes)) {
                List<FundIncomeDto> incomeList = LambdaFilter.toList(incomes, m -> m.getIncomeRuleId().equals(incomeRule.getId()));
                for (FundIncomeDto income : incomeList) {
                    BaseProductIncome pi = new BaseProductIncome();
                    super.initialModel(pi);
                    BeanUtils.copyProperties(income, pi);
                    pi.setId(null);
                    pi.setIncomeRuleId(pir.getId());
                    pi.setCreateDate(now);
                    pi.setCreateUserId(userId);
                    pi.setUpdateDate(null);
                    pi.setUpdateUserId(null);
                    baseProductIncomeMapper.insertSelective(pi);
                }
            }
        }
    }

    private void insertSaleFromFund(List<FundRaiseDto> raises, Long productId) {
        if (BooleanUtils.isEmpty(raises))
            return;
        Date now = new Date();
        Long userId = super.getHeaderUserId();
        for (FundRaiseDto raise : raises) {
            BaseProductSale ps = new BaseProductSale();
            super.initialModel(ps);
            BeanUtils.copyProperties(raise, ps);
            ps.setId(null);
            ps.setProductId(productId);
            ps.setCreateDate(now);
            ps.setCreateUserId(userId);
            ps.setUpdateDate(null);
            ps.setUpdateUserId(null);
            baseProductSaleMapper.insertSelective(ps);
        }
    }

    private void insertAttachFromFund(List<FundAttachDto> attachs, Long productId) {
        if (BooleanUtils.isEmpty(attachs))
            return;
        for (FundAttachDto attach : attachs) {
            BaseProductAttach pa = new BaseProductAttach();
            super.initialModel(pa);
            pa.setProductId(productId);
            pa.setSort(attach.getSort());
            pa.setSourceName(attach.getSourceName());
            pa.setType(attach.getType());
            pa.setUrl(attach.getUrl());
            pa.setShowType(NumberEnum.ZERO.getValue());//内部和外部都可见
            baseProductAttachMapper.insertSelective(pa);
        }
    }

    private void insertFieldValueFromFund(List<FundFieldValueDto> fieldValues, Long productId) {
        if (BooleanUtils.isEmpty(fieldValues))
            return;
        for (FundFieldValueDto fieldValue : fieldValues) {
            super.initialModel(fieldValue);
            BaseProductFieldValue pfv = new BaseProductFieldValue();
            pfv.setObjectFieldId(fieldValue.getObjectFieldId());
            pfv.setReferenceTableId(productId);
            pfv.setSlot(fieldValue.getSlot());
            pfv.setValue(fieldValue.getValue());
            baseProductFieldValueMapper.insertSelective(pfv);
        }
    }

    private void checkNameExist(FundDto dto) throws BaseException {
        BaseProductExample example = new BaseProductExample();
        example.createCriteria().andNameEqualTo(dto.getName().trim());
        if (baseProductMapper.countByExample(example) > 0)
            throw new BaseException(Code1220000.CODE_1220151);
    }


    /**
     * 修改扩展信息
     *
     * @param allParams
     * @param productId
     * @param list
     */
    private void updateExtProperty(Map<String, String> allParams, Long productId, List<FieldDto> list) {
        if (BooleanUtils.isEmpty(allParams)) {
            return;
        }
        Map<String, String> extParams = getExtPropertys(allParams);
        // 转换需要保持的数据
        List<FieldValueDto> fieldValueList = fieldValueService.transformFieldValue(list, extParams);
        // 修改扩展信息
        fieldValueService.updateProductFieldValue(fieldValueList, productId);
    }


    /**
     * 保存扩展属性
     */
    private void saveExtProperty(Map<String, String> allParams, Long productId, List<FieldDto> list) throws BaseException {
        if (BooleanUtils.isEmpty(allParams)) {
            return;
        }
        Map<String, String> extParams = getExtPropertys(allParams);
        // 转换需要保持的数据
        List<FieldValueDto> fieldValueList = fieldValueService.transformFieldValue(list, extParams);
        // 保存数据
        fieldValueService.saveProductFieldValue(fieldValueList, productId);
    }

    /**
     * 获取扩展属性
     *
     * @param allParams
     * @return
     */
    private Map<String, String> getExtPropertys(Map<String, String> allParams) {
        if (BooleanUtils.isEmpty(allParams)) {
            return null;
        }
        Map<String, String> params = new HashMap<String, String>();
        for (String key : allParams.keySet()) {
            if (key.startsWith(FieldPrefixEnum.PRODUCT.getPrefix())) {
                params.put(key, allParams.get(key));
            }
        }
        return params;
    }

}
