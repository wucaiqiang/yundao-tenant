package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseFieldConfig;
import com.yundao.tenant.model.base.BaseFieldConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFieldConfigMapper {
    int countByExample(BaseFieldConfigExample example);

    int deleteByExample(BaseFieldConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseFieldConfig record);

    int insertSelective(BaseFieldConfig record);

    List<BaseFieldConfig> selectByExample(BaseFieldConfigExample example);

    BaseFieldConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseFieldConfig record, @Param("example") BaseFieldConfigExample example);

    BaseFieldConfig selectOne(BaseFieldConfigExample example);

    int updateByExample(@Param("record") BaseFieldConfig record, @Param("example") BaseFieldConfigExample example);

    int updateByPrimaryKeySelective(BaseFieldConfig record);

    int updateByPrimaryKey(BaseFieldConfig record);
}