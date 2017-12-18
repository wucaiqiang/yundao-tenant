package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseRole;
import com.yundao.tenant.model.base.BaseRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoleMapper {
    int countByExample(BaseRoleExample example);

    int deleteByExample(BaseRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    List<BaseRole> selectByExample(BaseRoleExample example);

    BaseRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);

    BaseRole selectOne(BaseRoleExample example);

    int updateByExample(@Param("record") BaseRole record, @Param("example") BaseRoleExample example);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);
}