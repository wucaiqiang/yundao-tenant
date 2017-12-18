package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseRoleResource;
import com.yundao.tenant.model.base.BaseRoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoleResourceMapper {
    int countByExample(BaseRoleResourceExample example);

    int deleteByExample(BaseRoleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRoleResource record);

    int insertSelective(BaseRoleResource record);

    List<BaseRoleResource> selectByExample(BaseRoleResourceExample example);

    BaseRoleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRoleResource record, @Param("example") BaseRoleResourceExample example);

    BaseRoleResource selectOne(BaseRoleResourceExample example);

    int updateByExample(@Param("record") BaseRoleResource record, @Param("example") BaseRoleResourceExample example);

    int updateByPrimaryKeySelective(BaseRoleResource record);

    int updateByPrimaryKey(BaseRoleResource record);
}