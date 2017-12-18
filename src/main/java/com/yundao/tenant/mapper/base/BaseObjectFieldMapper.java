package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseObjectField;
import com.yundao.tenant.model.base.BaseObjectFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseObjectFieldMapper {
    int countByExample(BaseObjectFieldExample example);

    int deleteByExample(BaseObjectFieldExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseObjectField record);

    int insertSelective(BaseObjectField record);

    List<BaseObjectField> selectByExample(BaseObjectFieldExample example);

    BaseObjectField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseObjectField record, @Param("example") BaseObjectFieldExample example);

    BaseObjectField selectOne(BaseObjectFieldExample example);

    int updateByExample(@Param("record") BaseObjectField record, @Param("example") BaseObjectFieldExample example);

    int updateByPrimaryKeySelective(BaseObjectField record);

    int updateByPrimaryKey(BaseObjectField record);
}