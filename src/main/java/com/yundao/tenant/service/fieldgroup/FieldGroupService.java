package com.yundao.tenant.service.fieldgroup;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupInfoReqDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupReqDto;
import com.yundao.tenant.model.base.BaseFieldGroup;

import java.util.List;


public interface FieldGroupService {


    public Result<Long> add(FieldGroupReqDto dto) throws Exception;


    public Result<Integer> update(FieldGroupReqDto dto) throws Exception;


    public Result<PermissionResultDto> delete(String ids) throws Exception;


    public Result<BaseFieldGroup> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseFieldGroup>> getPage(FieldGroupReqDto dto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 获取某个字段所关联的分组
     *
     * @param fieldId 字段id
     */
    List<BaseFieldGroup> getFieldRelList(Long fieldId) throws BaseException;

    /**
     * 根据名称模糊搜索
     *
     * @param name 名称
     */
    List<BaseFieldGroup> getByName(String name) throws BaseException;
    
    /**
     * 通过businessCode查询字段组信息
     * @param code
     * @return
     * @throws BaseException
     */
    public List<BaseFieldGroup> getByBusinessCode(String code) throws BaseException;
    
    /**
     * 检查fieldGroupid是否存在
     * @param fieldGroupId
     * @return
     * @throws BaseException
     */
    public boolean checkFieldGroupExist(Long fieldGroupId) throws BaseException;

    
    /**
     * 通过id查询名称
     * @param fieldGroupId
     * @return
     * @throws BaseException
     */
    public String getNameById(Long id) throws BaseException;

    /**
     * 查询ids
     * @param ids
     * @return
     * @throws BaseException
     */
    Result<List<BaseFieldGroup>> getIds(String ids) throws BaseException;

    /**
     * 更新字段关联
     * @param fieldGroupId
     * @param fieldGroupRelIds
     * @throws BaseException
     */
    void updateFieldGroupRel(Long fieldGroupId, String fieldGroupRelIds) throws BaseException;

    /**
     * 修改基本信息
     * @param dto
     * @return
     */
    Result<Integer> updateInfo(FieldGroupInfoReqDto dto) throws BaseException;
}
