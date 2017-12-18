package com.yundao.tenant.service.bo;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.bo.*;
import com.yundao.tenant.dto.common.PermissionResultDto;

import java.util.List;
import java.util.Map;


/**
 * 业务对象字段服务接口
 *
 * @author jan
 * @create 2017-07-04 AM10:19
 **/
public interface ObjectFieldService {

    /**
     * 获取分页数据
     *
     * @param dto 查询参数
     * @return 分页数据
     */
    PaginationSupport<ObjectFieldPageResDto> getPage(ObjectFieldPageReqDto dto) throws BaseException;

    /**
     * 获取单个数据
     *
     * @param id id
     */
    Result<ObjectFieldDetailResDto> get(Long id) throws BaseException;

    /**
     * 根据业务对象id获取业务对象字段
     *
     * @param boCode 业务对象编码
     */
    Result<List<ObjectFieldSimpleResDto>> getByBoCode(String boCode) throws BaseException;

    /**
     * 添加业务对象字段
     */
    Result<Long> add(ObjectFieldAddReqDto dto) throws BaseException;

    /**
     * 修改业务对象字段
     */
    Result<Long> update(ObjectFieldUpdateReqDto dto) throws BaseException;

    /**
     * 删除
     *
     * @param ids    多个id逗号分隔
     * @param boCode 业务对象编码
     */
    Result<PermissionResultDto> delete(String ids, String boCode) throws BaseException;

    /**
     * 获取业务对象分组页面字段列表
     */
    Result<List<ObjectFieldPageResDto>> getFieldList(String boCode) throws BaseException;

    /**
     * 根据多个id获取
     */
    Result<List<ObjectFieldPageResDto>> getByIds(List<Long> ids) throws BaseException;

    /**
     * 获取多条数据
     */
    Result<List<ObjectFieldPageResDto>> gets(Map<String, Object> params) throws BaseException;


//    List<ObjectFieldAccessDto> getFieldRole() throws BaseException;

    /**
     * 设置文案
     * @param dtos
     * @throws BaseException
     */
    public void setText(List<ObjectFieldPageResDto> dtos) throws BaseException;

    /**
     * 按ID排序
     * @param objectFieldIds
     * @return
     */
    Result<List<ObjectFieldPageResDto>> getByIdsOrder(List<Long> objectFieldIds);
}
