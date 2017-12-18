package com.yundao.tenant.service.dataobject.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.permission.DataPermissionResDto;
import com.yundao.tenant.dto.permission.PermissionListResDto;
import com.yundao.tenant.dto.permission.PermissionMultiCodeReqDto;

import java.util.List;

/**
 * 数据权限服务接口
 *
 * @author jan
 * @create 2017-08-05 PM1:29
 **/
public interface DataObjectPermissionService {

    /**
     * 获取用户对某个数据对象的操作权限
     *
     * @param dataObjectCode 数据对象编码
     * @param operation      操作类型
     */
    Integer get(String dataObjectCode, Integer operation) throws BaseException;

    /**
     * 获取用户是否具有对某个数据对象的读取权限
     *
     * @param dataObjectCode 数据对象编码
     * @param operation      操作类型
     * @param ownerId        数据的拥有者id
     */
    Boolean check(String dataObjectCode, Integer operation, Long ownerId) throws BaseException;


    /**
     * 多条数据校验是否具有对某个数据对象的操作权限
     *
     * @param dataObjectCode 数据对象编码
     * @param operation      操作类型
     * @param ownerIds       多条数据对应的拥有者id
     */
    List<PermissionListResDto> checkList(String dataObjectCode, Integer operation, List<Long> ownerIds) throws
            BaseException;

    /**
     * 多条数据校验是否具有对某个数据对象的操作权限
     *
     * @param operation  操作类型
     * @param jsonReqDto 请求数据
     */
    List<PermissionListResDto> checkList(Integer operation, String jsonReqDto) throws
            BaseException;

    /**
     * 校验多个数据对象权限
     *
     * @param jsonReqDto 请求数据[List PermissionMultiCodeReqDto]
     */
    List<DataPermissionResDto> checkMultiCode(String jsonReqDto) throws BaseException;


    /**
     * 获取单个数据对象权限
     * @param codeReqDto
     * @return
     */
    DataPermissionResDto checkOnlyCode(PermissionMultiCodeReqDto codeReqDto) throws BaseException;
}
