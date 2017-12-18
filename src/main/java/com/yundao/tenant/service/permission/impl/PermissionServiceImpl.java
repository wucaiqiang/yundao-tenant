package com.yundao.tenant.service.permission.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.dto.permission.UserPermissionDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.permission.BasePermissionService;
import com.yundao.tenant.service.permission.PermissionService;
import com.yundao.tenant.service.permission.UserPermissionService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限校验基础服务实现
 *
 * @author jan
 * @create 2017-08-02 PM12:51
 **/
@Service
public class PermissionServiceImpl extends BasePermissionService implements PermissionService {

    private static Log log = LogFactory.getLog(PermissionServiceImpl.class);

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private UserService userService;

    @Override
    public Integer get(String dataObjectCode, Integer operation, Long tenantId, Long userId) throws BaseException {
        log.info(dataObjectCode, operation, userId);
        this.CheckArgsNotNull(dataObjectCode, operation, userId);
        UserPermissionDto permissionDto = this.getUserPermission(tenantId, userId, dataObjectCode);
        if (permissionDto == null) {
            log.info("用户没有配置任何数据权限");
            return DataObjectPermissionEnum.NONE.getValue();
        }
        Integer permission = this.getpermissionByOperation(permissionDto, operation);
        log.info("permission:%s", permission);
        return permission;
    }

    @Override
    public UserPermissionDto get(String dataObjectCode, Long tenantId, Long userId) throws BaseException {
        log.info(dataObjectCode, userId);
        this.CheckArgsNotNull(dataObjectCode, userId);
        UserPermissionDto permissionDto = this.getUserPermission(tenantId, userId, dataObjectCode);
        log.end();
        return permissionDto;
    }

    @Override
    public Boolean check(String dataObjectCode, Integer operation, Long ownerId, Long tenantId, Long userId) throws
            BaseException {
        log.begin(dataObjectCode, operation, ownerId, userId);

        this.CheckArgsNotNull(dataObjectCode, operation, userId);

        Integer permission = this.get(dataObjectCode, operation, tenantId, userId);
        if (DataObjectPermissionEnum.PUBLIC.getValue().equals(permission))
            return true;
        if (DataObjectPermissionEnum.NONE.getValue().equals(permission))
            return false;
        if (ownerId == null){
        	return false;
        	//throw new BaseException(CodeConstant.CODE_1220042);
        }
        if (DataObjectPermissionEnum.PERSONAL.getValue().equals(permission))
            return ownerId.equals(userId);
        if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)) {
            List<Long> userIds = userService.getSameDepUsers(userId);
            return userIds.contains(ownerId);
        }
        return false;
    }

    private UserPermissionDto getUserPermission(Long tenantId, Long userId, String dataObjectCode) throws BaseException {
        return LambdaFilter.firstOrDefault(userPermissionService.gets(tenantId), m -> userId.equals(m.getUserId())
                && dataObjectCode.equals(m.getDataObjectCode()));
    }

}
