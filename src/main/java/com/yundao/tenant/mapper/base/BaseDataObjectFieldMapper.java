package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDataObjectField;
import com.yundao.tenant.model.base.BaseDataObjectFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDataObjectFieldMapper {
    int countByExample(BaseDataObjectFieldExample example);

    int deleteByExample(BaseDataObjectFieldExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDataObjectField record);

    int insertSelective(BaseDataObjectField record);

    List<BaseDataObjectField> selectByExample(BaseDataObjectFieldExample example);

    BaseDataObjectField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDataObjectField record, @Param("example") BaseDataObjectFieldExample example);

    BaseDataObjectField selectOne(BaseDataObjectFieldExample example);

    int updateByExample(@Param("record") BaseDataObjectField record, @Param("example") BaseDataObjectFieldExample example);

    int updateByPrimaryKeySelective(BaseDataObjectField record);

    int updateByPrimaryKey(BaseDataObjectField record);
}