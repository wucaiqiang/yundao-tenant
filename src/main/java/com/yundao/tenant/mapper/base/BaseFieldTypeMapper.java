package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseFieldType;
import com.yundao.tenant.model.base.BaseFieldTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFieldTypeMapper {
    int countByExample(BaseFieldTypeExample example);

    int deleteByExample(BaseFieldTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseFieldType record);

    int insertSelective(BaseFieldType record);

    List<BaseFieldType> selectByExample(BaseFieldTypeExample example);

    BaseFieldType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseFieldType record, @Param("example") BaseFieldTypeExample example);

    BaseFieldType selectOne(BaseFieldTypeExample example);

    int updateByExample(@Param("record") BaseFieldType record, @Param("example") BaseFieldTypeExample example);

    int updateByPrimaryKeySelective(BaseFieldType record);

    int updateByPrimaryKey(BaseFieldType record);
}