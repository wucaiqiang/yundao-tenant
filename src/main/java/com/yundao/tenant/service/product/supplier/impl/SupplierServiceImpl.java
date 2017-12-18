package com.yundao.tenant.service.product.supplier.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.mapper.base.product.BaseProductSupplierMapper;
import com.yundao.tenant.mapper.base.product.BaseSupplierMapper;
import com.yundao.tenant.model.base.product.BaseProductSupplier;
import com.yundao.tenant.model.base.product.BaseProductSupplierExample;
import com.yundao.tenant.model.base.product.BaseSupplier;
import com.yundao.tenant.model.base.product.BaseSupplierExample;
import com.yundao.tenant.service.product.supplier.SupplierService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;


/**
 * 供应商管理
 *
 * @author 欧阳利
 *         2017年7月6日
 */
@Service
public class SupplierServiceImpl extends AbstractService implements SupplierService {

    @Autowired
    BaseSupplierMapper baseSupplierMapper;

    @Autowired
    private BaseProductSupplierMapper baseProductSupplierMapper;

    @Override
    public Result<Long> saveSupplier(BaseSupplier record) throws BaseException {
        record.setCreateDate(new Date());
        record.setCreateUserId(this.getHeaderUserId());
        record.setTenantId(this.getHeaderTenantId());
        record.setIsDelete(0);
        baseSupplierMapper.insert(record);
        return Result.newSuccessResult(record.getId());
    }


    /**
     * 保存或者存在相同名称的就查询
     *
     * @param record
     */
    @Override
    public void saveOrIfExistSelect(BaseSupplier record) throws BaseException {
        BaseSupplierExample example = new BaseSupplierExample();
        example.createCriteria().andNameEqualTo(record.getName());
        List<BaseSupplier> list = baseSupplierMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(list)) {
            saveSupplier(record);
            return;
        }
        record.setId(list.get(0).getId());
    }

    /**
     * 获取供应商信息
     */
    @Override
    public List<BaseSupplier> getBaseSuppliers(List<Long> supplierIds) throws BaseException {
        if (BooleanUtils.isEmpty(supplierIds)) {
            return null;
        }
        BaseSupplierExample example = new BaseSupplierExample();
        example.createCriteria().andIdIn(supplierIds);
        List<BaseSupplier> list = baseSupplierMapper.selectByExample(example);
        return list;
    }

    @Override
    public void checkNotNullAndTerminal(Long id) throws BaseException {
        BaseSupplier supplier = baseSupplierMapper.selectByPrimaryKey(id);
        if (supplier == null)
            throw new BaseException(CodeConstant.CODE_1220122);

    }

    @Override
    public BaseSupplier getByProductId(Long id) throws BaseException {
        BaseProductSupplierExample psExample = new BaseProductSupplierExample();
        psExample.createCriteria().andProductIdEqualTo(id);
        List<BaseProductSupplier> productSuppliers = baseProductSupplierMapper.selectByExample(psExample);
        if (BooleanUtils.isEmpty(productSuppliers))
            return null;

        productSuppliers.sort(Comparator.comparing(BaseProductSupplier::getSupplierId));

        return baseSupplierMapper.selectByPrimaryKey(LambdaFilter.firstOrDefault(productSuppliers, m -> true).getSupplierId
                ());
    }

    @Override
    public Integer getProductAndSupplierRel(Long productId, Long supplierId) throws BaseException {
        BaseProductSupplierExample psExample = new BaseProductSupplierExample();
        psExample.createCriteria().andProductIdEqualTo(productId).andSupplierIdEqualTo(supplierId);
        return baseProductSupplierMapper.countByExample(psExample);
    }

}
