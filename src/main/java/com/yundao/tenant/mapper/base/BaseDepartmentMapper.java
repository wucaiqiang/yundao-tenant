package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDepartment;
import com.yundao.tenant.model.base.BaseDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDepartmentMapper {
    int countByExample(BaseDepartmentExample example);

    int deleteByExample(BaseDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDepartment record);

    int insertSelective(BaseDepartment record);

    List<BaseDepartment> selectByExample(BaseDepartmentExample example);

    BaseDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDepartment record, @Param("example") BaseDepartmentExample example);

    BaseDepartment selectOne(BaseDepartmentExample example);

    int updateByExample(@Param("record") BaseDepartment record, @Param("example") BaseDepartmentExample example);

    int updateByPrimaryKeySelective(BaseDepartment record);

    int updateByPrimaryKey(BaseDepartment record);
}