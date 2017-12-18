package com.yundao.tenant.service.product.sale;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.ProductSaleUpdateReqDto;
import com.yundao.tenant.model.base.product.BaseProductSale;

public interface ProductSaleService {
	
	/**
	 * 添加产品销售
	 * @return
	 */
    public Result<Long> saveProductSale(BaseProductSale record)throws BaseException,Exception;
    
    /**
     * 修改产品销售信息
     * @param updateReqDto
     * @return
     * @throws Exception
     */
    public Result<Integer> updateProductSale(ProductSaleUpdateReqDto updateReqDto)throws Exception;
}
