package com.yundao.tenant.service.product.supplier;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.add.ProductQuotationDto;
import com.yundao.tenant.dto.product.supplier.ProductQuotationUpdateDto;
import com.yundao.tenant.model.base.product.BaseProductSupplierQuotation;

public interface ProductSupplierQuotationService {
	
    /**
     * 删除产品供应商报价
     * @param productSuppliersIds
     * @return
     * @throws BaseException
     */
	public Result<Integer> deleteProductQuotation(List<Long> productSuppliersIds)throws BaseException;
	
	
	/**
	 * 添加一个产品供应商报价的多一个报价
	 * @param productQuotationDtos
	 * @param productSupplierId
	 * @return
	 * @throws BaseException
	 */
	public Result<Integer> addProductQuotation(List<ProductQuotationDto> productQuotationDtos,Long productSupplierId)throws BaseException,Exception;
	
	
	/**
	 * 修改产品供应商报价
	 * @param productQuotationDtos
	 * @param productSupplierId
	 * @return
	 * @throws BaseException
	 * @throws Exception
	 */
	public Result<Integer> updateProductQuotation(List<ProductQuotationUpdateDto> productQuotationDtos,Long productSupplierId)throws BaseException,Exception;
	
	/**
	 *  添加产品供应商报价
	 * @param productQuotationDtos
	 * @param productSupplierId
	 * @return
	 * @throws BaseException
	 * @throws Exception
	 */
	public Result<Integer> saveProductQuotation(List<ProductQuotationUpdateDto> productQuotationDtos,Long productSupplierId)throws BaseException,Exception;

	/**
	 * 查询产品供应商报价详细信息
	 * @param productSupplierIds
	 * @return
	 */
    public List<BaseProductSupplierQuotation> getBaseProductSupplierQuotations(List<Long> productSupplierIds);
} 
