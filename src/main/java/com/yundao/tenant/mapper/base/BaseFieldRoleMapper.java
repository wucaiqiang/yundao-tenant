package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseFieldRole;
import com.yundao.tenant.model.base.BaseFieldRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFieldRoleMapper {
    int countByExample(BaseFieldRoleExample example);

    int deleteByExample(BaseFieldRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseFieldRole record);

    int insertSelective(BaseFieldRole record);

    List<BaseFieldRole> selectByExample(BaseFieldRoleExample example);

    BaseFieldRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseFieldRole record, @Param("example") BaseFieldRoleExample example);

    BaseFieldRole selectOne(BaseFieldRoleExample example);

    int updateByExample(@Param("record") BaseFieldRole record, @Param("example") BaseFieldRoleExample example);

    int updateByPrimaryKeySelective(BaseFieldRole record);

    int updateByPrimaryKey(BaseFieldRole record);
}