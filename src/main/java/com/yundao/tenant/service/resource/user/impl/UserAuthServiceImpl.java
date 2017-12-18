package com.yundao.tenant.service.resource.user.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.resource.AuthMenuDto;
import com.yundao.tenant.dto.resource.AuthResourceDto;
import com.yundao.tenant.dto.resource.api.AuthApiDto;
import com.yundao.tenant.mapper.resource.user.UserAuthMapper;
import com.yundao.tenant.service.resource.user.UserAuthService;
import com.yundao.tenant.util.lambda.LambdaMap;
import com.yundao.tenant.util.url.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户鉴权服务
 *
 * @author jan
 * @create 2017-11-07 20:38
 **/
@Service
public class UserAuthServiceImpl implements UserAuthService {

    private static Log log = LogFactory.getLog(UserAuthServiceImpl.class);

    private static final String CACHE_KEY = "T(com.yundao.core.cache.interceptor.BaseKeyGenerator).getKey(#root" +
            ".targetClass,#tenantId,#userId)";

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    @Cacheable(value = "userAuth", key = CACHE_KEY)
    public AuthResourceDto get(Long tenantId, Long userId) throws BaseException {
        return this.doGet(tenantId, userId);
    }

    private AuthResourceDto doGet(Long tenantId, Long userId) throws BaseException {
        String logPrefix = "用户鉴权||从DB获取用户拥有的功能菜单及api||";
        log.info("%s tenantId %s userId %s", logPrefix, tenantId, userId);

        AuthResourceDto authResourceDto = new AuthResourceDto();
        List<AuthMenuDto> authMenuDtos = userAuthMapper.selectUserMenus(userId);
        log.info("%s authMenuDtos %s", logPrefix, JsonUtils.objectToJson(authMenuDtos));
        authMenuDtos.forEach(m -> m.setUrl(UrlUtils.toLowerCase(m.getUrl())));
        authResourceDto.setMenuMap(authMenuDtos.stream().collect(Collectors.toMap(AuthMenuDto::getUrl, m -> m)));

        if (BooleanUtils.isNotEmpty(authMenuDtos)) {
            List<AuthApiDto> authApiDtos = userAuthMapper.selectUserApis(LambdaMap.toSingleList(authMenuDtos, AuthMenuDto::getId));
            authApiDtos.forEach(m -> m.setUrl(UrlUtils.toLowerCase(m.getUrl())));
            log.info("%s authApiDtos %s", logPrefix, JsonUtils.objectToJson(authApiDtos));
            authResourceDto.setApiMap(authApiDtos.stream().collect(Collectors.toMap(AuthApiDto::getUrl, m -> m)));
        }
        log.info("%s完成", logPrefix);
        return authResourceDto;
    }

    @Override
    @CachePut(value = "userAuth", key = CACHE_KEY)
    public AuthResourceDto reload(Long tenantId, Long userId) throws BaseException {
        return this.doGet(tenantId, userId);
    }

    @Override
    @CacheEvict(value = "userAuth", key = CACHE_KEY, beforeInvocation = true)
    public void clear(Long tenantId, Long userId) throws BaseException {
        log.info("authResource clear complete! tenantId=%s userId=%s", tenantId, userId);
    }
}
