package com.yundao.tenant.mapper.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.product.add.ProductCommissionRuleDto;

public interface ProductCommissionRuleMapper {
    List<ProductCommissionRuleDto> selectList(@Param("productIds") String productIds);
}
