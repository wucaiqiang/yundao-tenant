package com.yundao.tenant.mapper.department;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.department.DepartmentUserDto;
import com.yundao.tenant.dto.department.DepartmentUserSimpleResDto;
import com.yundao.tenant.model.base.BaseDepartment;

/**
 * @author jan
 * @create 2017-09-07 AM8:22
 **/
public interface DepartmentMapper {

    /**
     * 获取用户的部门
     */
    List<DepartmentUserDto> selectUserDeaprtment(@Param("userIds") List<Long> userIds) throws BaseException;
    List<DepartmentUserSimpleResDto> selectDepartmentAndUsers() throws BaseException;
    
    /**
     * 查询所有子部门
     */
    List<BaseDepartment> selectAllChilds(@Param("code") String code);

    /**
     * 获取子部门的code最大部门
     * selectChildMaxCodeDepartment:
     * @author: 欧阳利
     * @param parentId
     * @return
     * @description:
     */
    BaseDepartment selectChildMaxCodeDepartment(@Param("parentId") Long parentId);
}
