package com.yundao.tenant.service.resource.api;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseApiResource;

import java.util.List;

/**
 * api资源服务接口
 *
 * @author jan
 * @create 2017-11-07 14:51
 **/
public interface ApiResourceService {

    /**
     * 获取所有
     */
    List<BaseApiResource> getAll() throws BaseException;

}
