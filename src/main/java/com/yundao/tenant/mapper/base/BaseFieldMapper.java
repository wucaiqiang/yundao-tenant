package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseField;
import com.yundao.tenant.model.base.BaseFieldExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFieldMapper {
    int countByExample(BaseFieldExample example);

    int deleteByExample(BaseFieldExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseField record);

    int insertSelective(BaseField record);

    List<BaseField> selectByExample(BaseFieldExample example);

    BaseField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseField record, @Param("example") BaseFieldExample example);

    BaseField selectOne(BaseFieldExample example);

    int updateByExample(@Param("record") BaseField record, @Param("example") BaseFieldExample example);

    int updateByPrimaryKeySelective(BaseField record);

    int updateByPrimaryKey(BaseField record);
}