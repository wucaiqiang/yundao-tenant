package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductSupplier;
import com.yundao.tenant.model.base.product.BaseProductSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductSupplierMapper {
    int countByExample(BaseProductSupplierExample example);

    int deleteByExample(BaseProductSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductSupplier record);

    int insertSelective(BaseProductSupplier record);

    List<BaseProductSupplier> selectByExample(BaseProductSupplierExample example);

    BaseProductSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductSupplier record, @Param("example") BaseProductSupplierExample example);

    BaseProductSupplier selectOne(BaseProductSupplierExample example);

    int updateByExample(@Param("record") BaseProductSupplier record, @Param("example") BaseProductSupplierExample example);

    int updateByPrimaryKeySelective(BaseProductSupplier record);

    int updateByPrimaryKey(BaseProductSupplier record);
}