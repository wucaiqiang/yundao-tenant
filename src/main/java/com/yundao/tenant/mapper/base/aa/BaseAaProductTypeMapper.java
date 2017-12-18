package com.yundao.tenant.mapper.base.aa;

import com.yundao.tenant.model.base.aa.BaseAaProductType;
import com.yundao.tenant.model.base.aa.BaseAaProductTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAaProductTypeMapper {
    int countByExample(BaseAaProductTypeExample example);

    int deleteByExample(BaseAaProductTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseAaProductType record);

    int insertSelective(BaseAaProductType record);

    List<BaseAaProductType> selectByExample(BaseAaProductTypeExample example);

    BaseAaProductType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseAaProductType record, @Param("example") BaseAaProductTypeExample example);

    BaseAaProductType selectOne(BaseAaProductTypeExample example);

    int updateByExample(@Param("record") BaseAaProductType record, @Param("example") BaseAaProductTypeExample example);

    int updateByPrimaryKeySelective(BaseAaProductType record);

    int updateByPrimaryKey(BaseAaProductType record);
}