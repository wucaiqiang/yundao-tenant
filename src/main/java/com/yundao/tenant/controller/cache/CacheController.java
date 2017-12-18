package com.yundao.tenant.controller.cache;


import com.yundao.core.cache.redis.JedisUtils;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.cache.CacheKey;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.permission.UserPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 缓存
 *
 * @author jan
 * @create 2017-09-11 PM7:45
 **/
@Controller
@ResponseBody
@RequestMapping("/cache")
@Api("缓存")
public class CacheController {

    @Autowired
    private UserPermissionService userPermissionService;

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 移除所有基本的资源
     */
    @RequestMapping(value = "/remove/resource/base", method = RequestMethod.GET)
    @ApiOperation(value = "移除所有基本的资源")
    public Result<Boolean> removeBaseResource() throws BaseException {
        Jedis jedis = JedisUtils.getJedis();
        Set<String> keys = jedis.keys(CacheKey.SYS_CODE + "com.yundao.tenant.service.resource.impl.AuthResourceServiceImpl*");
        for (String key : keys)
            JedisUtils.remove(key);
        return Result.newSuccessResult(true);
    }

    /**
     * 移除用户资源
     */
    @RequestMapping(value = "/remove/resource/byuser", method = RequestMethod.GET)
    @ApiOperation(value = "移除用户资源", notes = "tenantId输入-1，表示移除所有租户资源缓存")
    public Result<Boolean> removeByUser() throws
            BaseException {
        Jedis jedis = JedisUtils.getJedis();
        Set<String> keys = jedis.keys(CacheKey.SYS_CODE + "com.yundao.tenant.service.resource.user.impl.UserMenuServiceImpl*");
        for (String key : keys)
            JedisUtils.remove(key);
        return Result.newSuccessResult(true);
    }

    @RequestMapping(value = "/remove/data/permission", method = RequestMethod.GET)
    @ApiOperation("移除租户数据权限缓存")
    public Result<Boolean> removeDataPermission(@RequestParam Long tenantId) throws BaseException {
        if (tenantId == null)
            throw new BaseException(CodeConstant.CODE_1220111);
        userPermissionService.clear(tenantId);
        return Result.newSuccessResult(true);
    }

    @RequestMapping(value = "/dictinary/reload", method = RequestMethod.POST)
    @ApiOperation("重新加载数据字典数据")
    public Result<Boolean> reloadDics() throws BaseException {
        dictionaryService.reload();
        return Result.newSuccessResult();
    }

}
