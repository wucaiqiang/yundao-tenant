package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseRoleSystem;
import com.yundao.tenant.model.base.BaseRoleSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoleSystemMapper {
    int countByExample(BaseRoleSystemExample example);

    int deleteByExample(BaseRoleSystemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRoleSystem record);

    int insertSelective(BaseRoleSystem record);

    List<BaseRoleSystem> selectByExample(BaseRoleSystemExample example);

    BaseRoleSystem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRoleSystem record, @Param("example") BaseRoleSystemExample example);

    BaseRoleSystem selectOne(BaseRoleSystemExample example);

    int updateByExample(@Param("record") BaseRoleSystem record, @Param("example") BaseRoleSystemExample example);

    int updateByPrimaryKeySelective(BaseRoleSystem record);

    int updateByPrimaryKey(BaseRoleSystem record);
}