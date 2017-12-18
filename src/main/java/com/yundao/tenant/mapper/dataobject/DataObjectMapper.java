package com.yundao.tenant.mapper.dataobject;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.dataobject.RoleDataObjectDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataObjectMapper {

    /**
     * 获取角色数据对象字段
     */
    List<RoleDataObjectDto> selectRoleDataObjects(@Param("code") String code, @Param("roleIds") List<Long> roleIds)
            throws
            BaseException;

}
