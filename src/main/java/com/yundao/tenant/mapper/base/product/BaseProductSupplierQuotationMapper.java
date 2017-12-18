package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductSupplierQuotation;
import com.yundao.tenant.model.base.product.BaseProductSupplierQuotationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductSupplierQuotationMapper {
    int countByExample(BaseProductSupplierQuotationExample example);

    int deleteByExample(BaseProductSupplierQuotationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductSupplierQuotation record);

    int insertSelective(BaseProductSupplierQuotation record);

    List<BaseProductSupplierQuotation> selectByExample(BaseProductSupplierQuotationExample example);

    BaseProductSupplierQuotation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductSupplierQuotation record, @Param("example") BaseProductSupplierQuotationExample example);

    BaseProductSupplierQuotation selectOne(BaseProductSupplierQuotationExample example);

    int updateByExample(@Param("record") BaseProductSupplierQuotation record, @Param("example") BaseProductSupplierQuotationExample example);

    int updateByPrimaryKeySelective(BaseProductSupplierQuotation record);

    int updateByPrimaryKey(BaseProductSupplierQuotation record);
}