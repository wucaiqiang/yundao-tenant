package com.yundao.tenant.mapper.field;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.FieldRoleDto;

import java.util.List;

public interface FieldRoleMapper {

    /**
     * 获取业务字段角色权限
     */
    List<FieldRoleDto> select() throws BaseException;

}
