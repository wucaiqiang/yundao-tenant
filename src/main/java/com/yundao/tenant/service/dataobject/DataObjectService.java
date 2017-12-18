package com.yundao.tenant.service.dataobject;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.dataobject.DataObjectDetailResDto;
import com.yundao.tenant.dto.dataobject.DataObjectReqDto;

import java.util.List;

/**
 * 数据对象服务接口
 *
 * @author jan
 * @create 2017-07-15 AM9:36
 **/
public interface DataObjectService {

    /**
     * 获取所有数据对象数据
     */
    List<DataObjectDetailResDto> gets() throws BaseException;

    /**
     * 更新角色的数据权限
     */
    Long update(Long roleId, List<DataObjectReqDto> dtos) throws BaseException;

    /**
     * 获取角色对应的数据权限
     */
    List<DataObjectDetailResDto> getByRoleId(Long roledId) throws BaseException;

}
