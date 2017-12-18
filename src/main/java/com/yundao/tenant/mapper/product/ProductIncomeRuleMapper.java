package com.yundao.tenant.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;

public interface ProductIncomeRuleMapper {
    List<ProductIncomeRuleDto> selectList(@Param("productIds") String productIds);
}
