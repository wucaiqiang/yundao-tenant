package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUserDepartment;
import com.yundao.tenant.model.base.BaseUserDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserDepartmentMapper {
    int countByExample(BaseUserDepartmentExample example);

    int deleteByExample(BaseUserDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserDepartment record);

    int insertSelective(BaseUserDepartment record);

    List<BaseUserDepartment> selectByExample(BaseUserDepartmentExample example);

    BaseUserDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserDepartment record, @Param("example") BaseUserDepartmentExample example);

    BaseUserDepartment selectOne(BaseUserDepartmentExample example);

    int updateByExample(@Param("record") BaseUserDepartment record, @Param("example") BaseUserDepartmentExample example);

    int updateByPrimaryKeySelective(BaseUserDepartment record);

    int updateByPrimaryKey(BaseUserDepartment record);
}