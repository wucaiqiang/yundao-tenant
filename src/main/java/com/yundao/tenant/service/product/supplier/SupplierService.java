package com.yundao.tenant.service.product.supplier;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.product.BaseSupplier;

import java.util.List;

public interface SupplierService {

    /**
     * 保存供应商
     *
     * @param record
     * @return
     * @throws BaseException
     */
    public Result<Long> saveSupplier(BaseSupplier record) throws BaseException;

    /**
     * 保存或者存在相同名称的就查询
     *
     * @param record
     */
    public void saveOrIfExistSelect(BaseSupplier record) throws BaseException;


    /**
     * 获取供应商信息
     *
     * @param supplierIds
     * @return
     * @throws BaseException
     */
    public List<BaseSupplier> getBaseSuppliers(List<Long> supplierIds) throws BaseException;

    /**
     * 检查是否存在，如果不存在直接返回
     *
     * @param id 供应商id
     */
    void checkNotNullAndTerminal(Long id) throws BaseException;

    /**
     * 获取产品的供应商
     */
    BaseSupplier getByProductId(Long id) throws BaseException;

    /**
     * 检查该
     *
     * @param productId  产品id
     * @param supplierId 供应商id
     */
    Integer getProductAndSupplierRel(Long productId, Long supplierId) throws BaseException;
}
