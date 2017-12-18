package com.yundao.tenant.service.product.income.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.add.ProductIncomeDto;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.dto.product.income.IncomeRuleDetailDto;
import com.yundao.tenant.dto.product.income.IncomeRuleUpdateDto;
import com.yundao.tenant.dto.product.income.ProductIncomeDetailDto;
import com.yundao.tenant.dto.product.income.ProductIncomeUpdateDto;
import com.yundao.tenant.mapper.base.product.BaseProductIncomeRuleMapper;
import com.yundao.tenant.mapper.product.ProductIncomeRuleMapper;
import com.yundao.tenant.model.base.product.BaseProductIncome;
import com.yundao.tenant.model.base.product.BaseProductIncomeRule;
import com.yundao.tenant.model.base.product.BaseProductIncomeRuleExample;
import com.yundao.tenant.service.product.income.ProductIncomeRuleService;
import com.yundao.tenant.service.product.income.ProductIncomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 产品收益规则
 *
 * @author 欧阳利
 *         2017年7月12日
 */
@Service
public class ProductIncomeRuleServiceImpl extends AbstractService implements ProductIncomeRuleService {
    @Autowired
    ProductIncomeService productIncomeService;

    @Autowired
    BaseProductIncomeRuleMapper baseProductIncomeRuleMapper;
    @Autowired
    ProductIncomeRuleMapper productIncomeRuleMapper;


    @Override
    public Result<Integer> saveProductIncomeRuleDtos(List<ProductIncomeRuleDto> productIncomeRuleDtos, Long productId) throws Exception {
        if (BooleanUtils.isEmpty(productIncomeRuleDtos)) {
            return Result.newSuccessResult(0);
        }
        for (ProductIncomeRuleDto dto : productIncomeRuleDtos) {
            BaseProductIncomeRule record = new BaseProductIncomeRule();
            BeanUtils.copyProperties(dto, record);
            record.setId(null);
            record.setCreateDate(new Date());
            record.setCreateUserId(this.getHeaderUserId());
            record.setTenantId(this.getHeaderTenantId());
            record.setIsDelete(0);
            record.setProductId(productId);
            baseProductIncomeRuleMapper.insert(record);

            // 添加收益详情列表
            productIncomeService.addIncome2(dto.getProductIncomeDtos(), record.getId());
        }

        return Result.newSuccessResult(productIncomeRuleDtos.size());
    }


    /**
     * 保存编辑收益规则
     *
     * @param dto
     * @param productId
     * @return
     * @throws Exception
     */
    public Result<Integer> saveUpdateProductIncomeRuleDtos(IncomeRuleUpdateDto dto, Long productId) throws Exception {
        if (dto == null || productId == null) {
            return Result.newSuccessResult(0);
        }
        BaseProductIncomeRule record = new BaseProductIncomeRule();
        BeanUtils.copyProperties(dto, record);
        record.setCreateDate(new Date());
        record.setCreateUserId(this.getHeaderUserId());
        record.setTenantId(this.getHeaderTenantId());
        record.setIsDelete(0);
        record.setProductId(productId);
        baseProductIncomeRuleMapper.insert(record);

        productIncomeService.addIncome(dto.getProductIncomeDtos(), record.getId());
        return Result.newSuccessResult(1);
    }

    /**
     * 修改产品收益
     *
     * @param productIncomeRuleDtos
     * @param productId
     * @return
     * @throws BaseException
     */
    public Result<Integer> updateIncomeRule(List<IncomeRuleUpdateDto> productIncomeRuleDtos, Long productId) throws Exception {
        if (BooleanUtils.isEmpty(productIncomeRuleDtos)) {
            return deleteComeRuleByProductId(productId);
        }
        // 查询所有的收益规则
        List<BaseProductIncomeRule> incomeRules = getComeRuleByProductId(productId);
        for (IncomeRuleUpdateDto dto : productIncomeRuleDtos) {
            if (dto.getId() == null) {
                // 添加新
                saveUpdateProductIncomeRuleDtos(dto, productId);
            } else {
                // 修改备注
                updateRuleNameAndRemark(dto.getId(), dto.getRuleName(), dto.getRemark());
                // 修改
                productIncomeService.updateIncome(dto.getProductIncomeDtos(), dto.getId());
            }
        }

        // 删除旧的
        List<Long> needDeleteIds = getNeedDeleteIds(incomeRules, productIncomeRuleDtos);
        deleteComeRuleByRuleId(needDeleteIds);
        return Result.newSuccessResult(1);
    }

    /**
     * 修改备注
     *
     * @param id
     * @param remark
     */
    private void updateRuleNameAndRemark(Long id, String ruleName, String remark) {
        if (id == null) {
            return;
        }
        BaseProductIncomeRule record = new BaseProductIncomeRule();
        record.setRemark(remark);
        record.setRuleName(ruleName);
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        BaseProductIncomeRuleExample example = new BaseProductIncomeRuleExample();
        example.createCriteria().andIdEqualTo(id);
        baseProductIncomeRuleMapper.updateByExampleSelective(record, example);
    }


    /**
     * 获取需要删除的规则id集合
     *
     * @param all
     * @param list
     * @return
     */
    private List<Long> getNeedDeleteIds(List<BaseProductIncomeRule> all, List<IncomeRuleUpdateDto> list) {
        if (BooleanUtils.isEmpty(all)) {
            return null;
        }
        List<Long> allIds = new ArrayList<Long>();
        for (BaseProductIncomeRule model : all) {
            allIds.add(model.getId());
        }

        if (BooleanUtils.isEmpty(list)) {
            return allIds;
        }

        List<Long> currentIds = new ArrayList<Long>();
        for (IncomeRuleUpdateDto dto : list) {
            if (dto.getId() != null) {
                currentIds.add(dto.getId());
            }
        }
        List<Long> ids = new ArrayList<Long>();
        for (Long id : allIds) {
            if (!currentIds.contains(id)) {
                ids.add(id);
            }
        }
        return ids;
    }


    /**
     * 对象转换
     *
     * @param request
     * @return
     * @throws BaseException
     */
    public List<ProductIncomeRuleDto> getProductIncomeRuleDto(String productIncomeRuleDtos) throws BaseException {
        if (BooleanUtils.isBlank(productIncomeRuleDtos)) {
            return null;
        }
        JavaType javaType = JsonUtils.getCollectionType(List.class, ProductIncomeRuleDto.class);
        List<ProductIncomeRuleDto> list = JsonUtils.jsonToObject(productIncomeRuleDtos, javaType);
        return list;
    }


    /**
     * 获取更新收益规则
     *
     * @param productIncomeRuleDtos
     * @return
     * @throws BaseException
     */
    public List<IncomeRuleUpdateDto> getIncomeRuleUpdateDtos(String productIncomeRuleDtos) throws BaseException {
        if (BooleanUtils.isBlank(productIncomeRuleDtos)) {
            return null;
        }
        JavaType javaType = JsonUtils.getCollectionType(List.class, IncomeRuleUpdateDto.class);
        List<IncomeRuleUpdateDto> list = JsonUtils.jsonToObject(productIncomeRuleDtos, javaType);
        return list;
    }


    /**
     * 查询产品的素有收益规则
     *
     * @param productId
     * @return
     */
    private List<BaseProductIncomeRule> getComeRuleByProductId(Long productId) {
        // 查询所有的收益规则
        BaseProductIncomeRuleExample example = new BaseProductIncomeRuleExample();
        example.createCriteria().andProductIdEqualTo(productId);
        return baseProductIncomeRuleMapper.selectByExample(example);
    }

    @Override
    public List<ProductIncomeRuleDto> getInComeRuleByProductIds(String productIds) throws BaseException {
        // 查询所有的收益规则
        List<ProductIncomeRuleDto> dtos = productIncomeRuleMapper.selectList(productIds);

        return dtos;
    }

    /**
     * 批量删除规则集合
     *
     * @param incomeRuleIds
     * @return
     */
    private Result<Integer> deleteComeRuleByRuleId(List<Long> incomeRuleIds) {
        if (BooleanUtils.isEmpty(incomeRuleIds)) {
            return null;
        }
        // 删除单个收益规则
        BaseProductIncomeRule record = new BaseProductIncomeRule();
        record.setIsDelete(1);
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        BaseProductIncomeRuleExample example = new BaseProductIncomeRuleExample();
        example.createCriteria().andIdIn(incomeRuleIds);
        baseProductIncomeRuleMapper.updateByExampleSelective(record, example);
        // 删除单个收益规则的收益详情
        productIncomeService.deleteIncome(incomeRuleIds);
        return Result.newSuccessResult(1);
    }


    /**
     * 删除收益规则
     *
     * @param productId
     * @return
     */
    private Result<Integer> deleteComeRuleByProductId(Long productId) {
        // 查询所有的收益规则
        List<BaseProductIncomeRule> incomeRules = getComeRuleByProductId(productId);
        if (BooleanUtils.isEmpty(incomeRules)) {
            return Result.newSuccessResult(0);
        }
        // 删除收益规则
        BaseProductIncomeRule record = new BaseProductIncomeRule();
        record.setIsDelete(1);
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        BaseProductIncomeRuleExample example = new BaseProductIncomeRuleExample();
        example.createCriteria().andProductIdEqualTo(productId);
        baseProductIncomeRuleMapper.updateByExampleSelective(record, example);

        List<Long> incomeRuleIds = new ArrayList<Long>();
        for (BaseProductIncomeRule dto : incomeRules) {
            incomeRuleIds.add(dto.getId());
        }

        // 删除收益
        productIncomeService.deleteIncome(incomeRuleIds);
        return Result.newSuccessResult(incomeRules.size());
    }

    /**
     * 通过产品id获取收益信息
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public List<IncomeRuleDetailDto> getIncomeRuleDetailDtos(Long productId) throws Exception {
        BaseProductIncomeRuleExample example = new BaseProductIncomeRuleExample();
        example.createCriteria().andProductIdEqualTo(productId);
        // 查询收益规则
        List<BaseProductIncomeRule> baseProductIncomeRules = baseProductIncomeRuleMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(baseProductIncomeRules)) {
            return null;
        }
        List<IncomeRuleDetailDto> incomeRuleDetailDtos = new ArrayList<IncomeRuleDetailDto>();
        List<Long> incomeRuleIds = new ArrayList<Long>();
        for (BaseProductIncomeRule base : baseProductIncomeRules) {
            IncomeRuleDetailDto dto = new IncomeRuleDetailDto();
            BeanUtils.copyProperties(base, dto);
            incomeRuleDetailDtos.add(dto);
            incomeRuleIds.add(dto.getId());
        }
        // 查询收益详情
        List<BaseProductIncome> baseProductIncomes = productIncomeService.getBaseProductIncomes(incomeRuleIds);
        if (BooleanUtils.isEmpty(baseProductIncomes)) {
            return incomeRuleDetailDtos;
        }
        List<ProductIncomeDetailDto> productIncomeDtos = new ArrayList<ProductIncomeDetailDto>();
        for (BaseProductIncome base : baseProductIncomes) {
            ProductIncomeDetailDto dto = new ProductIncomeDetailDto();
            BeanUtils.copyProperties(base, dto);
            productIncomeDtos.add(dto);
        }

        // 整合数据
        for (IncomeRuleDetailDto dto : incomeRuleDetailDtos) {
            if (dto.getProductIncomeDtos() == null) {
                dto.setProductIncomeDtos(new ArrayList<ProductIncomeDetailDto>());
            }
            for (ProductIncomeDetailDto detailDto : productIncomeDtos) {
                if (dto.getId().equals(detailDto.getIncomeRuleId())) {
                    dto.getProductIncomeDtos().add(detailDto);
                }
            }
        }

        return incomeRuleDetailDtos;
    }

    /**
     * 检查收益规则 for add
     *
     * @param productIncomeRuleDtos
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkIncomeRuleAddDtos(List<ProductIncomeRuleDto> productIncomeRuleDtos, Integer isScale, Double productScale) throws BaseException {
        if (BooleanUtils.isEmpty(productIncomeRuleDtos)) {
            return Result.newSuccessResult(true);
        }
        if (productIncomeRuleDtos.size() > 20) {
            return Result.newFailureResult(CodeConstant.CODE_1200063);
        }
//		List<String> ruleNames = new ArrayList<String>();
        for (ProductIncomeRuleDto ruleDto : productIncomeRuleDtos) {
            // 每条收益佣金规则最多添加20条佣金项目
            if (BooleanUtils.isEmpty(ruleDto.getProductIncomeDtos()) || ruleDto.getProductIncomeDtos().size() > 20) {
                return Result.newFailureResult(CodeConstant.CODE_1200065);
            }

//    		if(BooleanUtils.isBlank(ruleDto.getRuleName()) || ruleDto.getRuleName().length() > 100){
//    			return Result.newFailureResult(CodeConstant.CODE_1200064);
//    		}
//    		
//    		if(ruleNames.contains(ruleDto.getRuleName().trim())){
//    			return Result.newFailureResult(CodeConstant.CODE_1200088);
//    		}
//    		ruleNames.add(ruleDto.getRuleName().trim());

            // 非必填，输入内容为文本，输入长度上限为200
            if (!BooleanUtils.isBlank(ruleDto.getRemark()) && ruleDto.getRemark().length() > 100) {
                return Result.newFailureResult(CodeConstant.CODE_1200066);
            }
            if (!BooleanUtils.isEmpty(ruleDto.getProductIncomeDtos())) {
                boolean isFirst = true;
                Double buyMax = null;
                for (ProductIncomeDto dto : ruleDto.getProductIncomeDtos()) {
                    // 每只收益佣金的最小值不能小于0
                    if (dto.getBuyMin() == null || dto.getBuyMin() < 0) {
                        return Result.newFailureResult(CodeConstant.CODE_1200076);
                    }
                    // 每只收益佣金的最大值不能小于最小值
                    if (dto.getBuyMax() != null && dto.getBuyMax() < dto.getBuyMin()) {
                        return Result.newFailureResult(CodeConstant.CODE_1200077);
                    }

                    if (!isFirst) {
                        // 只有最后一只收益佣金的最大值可以为空
                        if (buyMax == null) {
                            return Result.newFailureResult(CodeConstant.CODE_1200078);
                        }
                        // 下一只收益佣金最小值必须大于上一只收益佣金最大值
                        if (dto.getBuyMin() < buyMax) {
                            return Result.newFailureResult(CodeConstant.CODE_1200079);
                        }
                    }
                    buyMax = dto.getBuyMax();
                    isFirst = false;

                    if (isScale != null && productScale != null && isScale == 1) {
                        if (dto.getBuyMin() > productScale) {
                            return Result.newFailureResult(CodeConstant.CODE_1200083);
                        }
                        if (buyMax != null && buyMax > productScale) {
                            return Result.newFailureResult(CodeConstant.CODE_1200083);
                        }
                    }
                }
            }
        }

        return Result.newSuccessResult(true);
    }


    /**
     * 检查收益规则 for update
     *
     * @param incomeRuleUpdateDtos
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkIncomeRuleUpdateDtos(List<IncomeRuleUpdateDto> incomeRuleUpdateDtos, Integer isScale, Double productScale) throws BaseException {
        if (BooleanUtils.isEmpty(incomeRuleUpdateDtos)) {
            return Result.newSuccessResult(true);
        }
        List<ProductIncomeRuleDto> incomeRuleAddDtos = new ArrayList<ProductIncomeRuleDto>();
        for (IncomeRuleUpdateDto updateDto : incomeRuleUpdateDtos) {
            ProductIncomeRuleDto incomeRuleAddDto = new ProductIncomeRuleDto();
            BeanUtils.copyProperties(updateDto, incomeRuleAddDto);
            incomeRuleAddDtos.add(incomeRuleAddDto);

            if (BooleanUtils.isEmpty(updateDto.getProductIncomeDtos())) {
                continue;
            }
            List<ProductIncomeDto> productIncomeAddDtos = new ArrayList<ProductIncomeDto>();
            incomeRuleAddDto.setProductIncomeDtos(productIncomeAddDtos);
            for (ProductIncomeUpdateDto incomeUpdateDto : updateDto.getProductIncomeDtos()) {
                ProductIncomeDto incomeAddDto = new ProductIncomeDto();
                BeanUtils.copyProperties(incomeUpdateDto, incomeAddDto);
                productIncomeAddDtos.add(incomeAddDto);
            }
        }
        return checkIncomeRuleAddDtos(incomeRuleAddDtos, isScale, productScale);
    }
}
