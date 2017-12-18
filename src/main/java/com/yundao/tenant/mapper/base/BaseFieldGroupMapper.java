package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseFieldGroup;
import com.yundao.tenant.model.base.BaseFieldGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFieldGroupMapper {
    int countByExample(BaseFieldGroupExample example);

    int deleteByExample(BaseFieldGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseFieldGroup record);

    int insertSelective(BaseFieldGroup record);

    List<BaseFieldGroup> selectByExample(BaseFieldGroupExample example);

    BaseFieldGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseFieldGroup record, @Param("example") BaseFieldGroupExample example);

    BaseFieldGroup selectOne(BaseFieldGroupExample example);

    int updateByExample(@Param("record") BaseFieldGroup record, @Param("example") BaseFieldGroupExample example);

    int updateByPrimaryKeySelective(BaseFieldGroup record);

    int updateByPrimaryKey(BaseFieldGroup record);
}