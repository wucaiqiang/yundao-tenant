package com.yundao.tenant.service.resource.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.service.resource.AuthResourceService;
import com.yundao.tenant.service.resource.ResourceCacheService;
import com.yundao.tenant.service.resource.user.UserAuthService;
import com.yundao.tenant.service.resource.user.UserMenuService;
import com.yundao.tenant.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源缓存服务实现
 *
 * @author jan
 * @create 2017-09-26 AM11:38
 **/
@Service
public class ResourceCacheServiceImpl implements ResourceCacheService {

    private static Log log = LogFactory.getLog(ResourceCacheServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthResourceService authResourceService;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private UserMenuService userMenuService;

    @Override
    public void removeRoleCache(Long tenantId, Long roleId) throws BaseException {
        String logPrefix = "资源||移除角色下所有用户资源缓存||";
        log.info("%s 获取该角色下所有用户开始", logPrefix);

        List<Long> userIds = userService.getIdByRole(roleId);
        log.info("%s userIds:%s", logPrefix, JsonUtils.objectToJson(userIds));
        if (BooleanUtils.isNotEmpty(userIds)) {
            for (Long userId : userIds) {
                this.removeUserResourceCache(tenantId, userId);
            }
        }
        log.info("%s 完成", logPrefix);
    }

    @Override
    public void removeBaseResourceCache(Long tenantId) throws BaseException {
        authResourceService.clear(tenantId);
    }

    @Override
    public void removeUserResourceCache(Long tenantId, Long userId) throws BaseException {
        userAuthService.clear(tenantId, userId);
        userMenuService.clear(tenantId, userId);
    }
}
