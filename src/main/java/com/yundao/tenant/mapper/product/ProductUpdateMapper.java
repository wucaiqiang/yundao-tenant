package com.yundao.tenant.mapper.product;

import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;

public interface ProductUpdateMapper {
	 int updateProductSaleByProductId(BaseProductSale record);
	 
	 int updateProductByPrimaryKey(BaseProduct record);
}
