package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseSupplier;
import com.yundao.tenant.model.base.product.BaseSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSupplierMapper {
    int countByExample(BaseSupplierExample example);

    int deleteByExample(BaseSupplierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSupplier record);

    int insertSelective(BaseSupplier record);

    List<BaseSupplier> selectByExample(BaseSupplierExample example);

    BaseSupplier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSupplier record, @Param("example") BaseSupplierExample example);

    BaseSupplier selectOne(BaseSupplierExample example);

    int updateByExample(@Param("record") BaseSupplier record, @Param("example") BaseSupplierExample example);

    int updateByPrimaryKeySelective(BaseSupplier record);

    int updateByPrimaryKey(BaseSupplier record);
}