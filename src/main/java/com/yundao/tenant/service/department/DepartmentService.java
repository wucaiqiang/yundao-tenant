package com.yundao.tenant.service.department;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.department.DepartmentAddReqDto;
import com.yundao.tenant.dto.department.DepartmentDetailResDto;
import com.yundao.tenant.dto.department.DepartmentListResDto;
import com.yundao.tenant.dto.department.DepartmentUpdateReqDto;
import com.yundao.tenant.dto.department.DepartmentUserDto;
import com.yundao.tenant.dto.department.DepartmentUserListResDto;
import com.yundao.tenant.model.base.BaseDepartment;

/**
 * 部门服务接口
 *
 * @author duzhixiong
 * @create 2017-06-18 PM7:25
 **/
public interface DepartmentService {

    /**
     * 检查部门名称是否重复
     *
     * @param parentId
     * @param name
     * @return
     * @throws BaseException
     */
    Result<Boolean> checkDepartmentNameExist(Long parentId, String name) throws BaseException;


    /**
     * 检查部门名称是否重复
     *
     * @param parentId
     * @param name
     * @param departmentId
     * @return
     * @throws BaseException
     */
    Result<Boolean> checkDepartmentNameExist(Long parentId, String name, Long departmentId) throws BaseException;

    /**
     * 插入
     *
     * @param departmentAddReqDto 部门信息
     * @return 部门id
     */
    Result<Long> insert(DepartmentAddReqDto departmentAddReqDto) throws BaseException;

    /**
     * 获取部门
     *
     * @param id 部门id
     * @return 部门信息
     */
    DepartmentDetailResDto get(Long id) throws BaseException;

    /**
     * 获取租户的部门列表
     *
     * @return 部门列表
     */
    List<DepartmentListResDto> gets() throws BaseException;
    DepartmentUserListResDto getDepartmentAndUsers() throws BaseException;

    /**
     * 更新部门
     *
     * @param departmentAddReqDto 部门信息
     * @return 部门id
     */
    Result<Long> update(DepartmentUpdateReqDto departmentAddReqDto) throws BaseException;

    /**
     * 删除部门
     *
     * @param id 部门id
     * @return 部门id
     */
    Result<Long> delete(long id) throws BaseException;

    /**
     * 查询某个部门下面的所有子部门
     *
     * @param departmentId
     * @return
     */
    List<Long> getAllChildsByDepartmentId(Long departmentId) throws BaseException;

    /**
     * 检查部门是否存在
     *
     * @param departmentId
     * @return
     * @throws BaseException
     */
    Boolean checkDepartmentExist(Long departmentId) throws BaseException;

    /**
     * 获取用户部门
     *
     * @param userId 用户id
     */
    BaseDepartment getByUserId(Long userId) throws BaseException;
    
    /**
     * 查询当前用户所在的部门
     * getCurrentUserDepartment:
     * @author: 欧阳利
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<BaseDepartment> getCurrentUserDepartment()throws BaseException;
    
    /**
     * 通过部门id查询部门信息
     * getBaseDepartment:
     * @author: 欧阳利
     * @param id
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<BaseDepartment> getBaseDepartment(Long id)throws BaseException;

    /**
     * 获取用户所属部门
     *
     * @param userIds 用户id集合
     */
    List<DepartmentUserDto> getByUserIds(List<Long> userIds) throws BaseException;
    
    
    
	/**
	 * 查询部门的直接部门
	 * getDirectChilDepartment:
	 * @author: 欧阳利
	 * @param departmentId
	 * @return
	 * @description:
	 */
	public List<BaseDepartment> getDirectChilDepartment(Long departmentId);

}
