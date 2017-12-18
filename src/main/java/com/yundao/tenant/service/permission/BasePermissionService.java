package com.yundao.tenant.service.permission;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.permission.UserPermissionDto;
import com.yundao.tenant.enums.access.OperationPermissionEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限服务基类
 *
 * @author jan
 * @create 2017-08-06 AM12:11
 **/
public class BasePermissionService {

    /**
     * 检查参数
     */
    protected void CheckArgsNotNull(String dataObjectCode, Long userId) throws BaseException {
        if (BooleanUtils.isEmpty(dataObjectCode))
            throw new BaseException(CodeConstant.CODE_1220043);
        if (userId == null)
            throw new BaseException(CodeConstant.CODE_1200014);
    }

    /**
     * 检查参数
     */
    protected void CheckArgsNotNull(String dataObjectCode, Integer operation, Long userId) throws BaseException {
        if (operation == null)
            throw new BaseException(CodeConstant.CODE_1220044);
        this.CheckArgsNotNull(dataObjectCode, userId);
    }

    /**
     * 根据操作类型，获取对应权限
     *
     * @param permissionDto 权限
     * @param operation     操作类型
     */
    protected Integer getpermissionByOperation(UserPermissionDto permissionDto, Integer operation) {
        Map<Integer, Integer> map = new HashMap<>(3);
        map.put(OperationPermissionEnum.READ.getValue(), permissionDto.getReadPermission());
        map.put(OperationPermissionEnum.EDIT.getValue(), permissionDto.getEditPermission());
        map.put(OperationPermissionEnum.DELETE.getValue(), permissionDto.getDeletePermission());
        return map.get(operation);
    }
}
