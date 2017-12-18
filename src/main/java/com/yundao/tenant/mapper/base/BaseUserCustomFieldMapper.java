package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUserCustomField;
import com.yundao.tenant.model.base.BaseUserCustomFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserCustomFieldMapper {
    int countByExample(BaseUserCustomFieldExample example);

    int deleteByExample(BaseUserCustomFieldExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserCustomField record);

    int insertSelective(BaseUserCustomField record);

    List<BaseUserCustomField> selectByExample(BaseUserCustomFieldExample example);

    BaseUserCustomField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserCustomField record, @Param("example") BaseUserCustomFieldExample example);

    BaseUserCustomField selectOne(BaseUserCustomFieldExample example);

    int updateByExample(@Param("record") BaseUserCustomField record, @Param("example") BaseUserCustomFieldExample example);

    int updateByPrimaryKeySelective(BaseUserCustomField record);

    int updateByPrimaryKey(BaseUserCustomField record);
}