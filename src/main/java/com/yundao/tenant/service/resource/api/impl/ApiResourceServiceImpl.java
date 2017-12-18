package com.yundao.tenant.service.resource.api.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.mapper.base.BaseApiResourceMapper;
import com.yundao.tenant.model.base.BaseApiResource;
import com.yundao.tenant.model.base.BaseApiResourceExample;
import com.yundao.tenant.service.resource.api.ApiResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * API资源服务实现
 *
 * @author jan
 * @create 2017-11-07 14:51
 **/
@Service
public class ApiResourceServiceImpl implements ApiResourceService {

    private static Log log = LogFactory.getLog(ApiResourceServiceImpl.class);

    @Autowired
    private BaseApiResourceMapper baseApiResourceMapper;

    @Override
    public List<BaseApiResource> getAll() throws BaseException {
        String logPrefix = "API接口资源||获取所有||";
        BaseApiResourceExample example = new BaseApiResourceExample();
        example.createCriteria().andUrlIsNotNull().andUrlNotEqualTo("");
        List<BaseApiResource> apiResources = baseApiResourceMapper.selectByExample(example);
        log.info("%s apiResources：%s", logPrefix, JsonUtils.objectToJson(apiResources));
        return apiResources;
    }
}
