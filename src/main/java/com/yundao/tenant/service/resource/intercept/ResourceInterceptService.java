package com.yundao.tenant.service.resource.intercept;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.resource.AuthResultDto;

/**
 * 鉴权资源拦截服务接口
 *
 * @author jan
 * @create 2017-11-07 14:10
 **/
public interface ResourceInterceptService {

    /**
     * 鉴权
     *
     * @param url 请求url
     */
    AuthResultDto doAuthenticate(String url) throws BaseException;

}
