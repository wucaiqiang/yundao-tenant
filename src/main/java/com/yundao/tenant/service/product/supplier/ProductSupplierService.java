package com.yundao.tenant.service.product.supplier;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.add.ProductSupplierDto;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDto;

import java.util.List;

/**
 * 产品供应商管理
 *
 * @author 欧阳利
 *         2017年7月6日
 */
public interface ProductSupplierService {

    /**
     * 添加产品供应商
     *
     * @param supplierDtos
     * @param productId
     * @throws BaseException
     * @throws Exception
     */
    public void saveProductSupplierQuotation(List<ProductSupplierDto> supplierDtos, Long productId) throws BaseException, Exception;

    /**
     * 对象转换
     *
     * @param request
     * @return
     * @throws BaseException
     */
    public List<ProductSupplierDto> getProductSupplierDto(String supplierDtos) throws BaseException;


    /**
     * 对象转换
     *
     * @param request
     * @return
     * @throws BaseException
     */
    public List<ProductSupplierQuotationDto> getProductSupplierUpdateDto(String supplierDtos) throws BaseException;


    /**
     * 修改产品供应商报价
     *
     * @param productId
     * @param list
     * @return
     * @throws BaseException
     */
    public Result<Integer> updateSupplierQuotation(Long productId, List<ProductSupplierQuotationDto> list) throws Exception;


    /**
     * 通过产品id查询产品报价信息
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public List<ProductSupplierQuotationDetailDto> getProductSupplierQuotationDetailDtos(Long productId) throws
            BaseException;

    /**
     * 检查产品供应商for add
     *
     * @param supplierDtos
     * @return
     * @throws Exception
     */
    public Result<Boolean> checkProductSupplierforAdd(List<ProductSupplierDto> supplierDtos, Integer isScale, Double productScale) throws BaseException;

    /**
     * 检查产品供应商for update
     *
     * @param list
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkProductSupplierforUpdate(List<ProductSupplierQuotationDto> list, Integer isScale, Double productScale) throws BaseException;
}
