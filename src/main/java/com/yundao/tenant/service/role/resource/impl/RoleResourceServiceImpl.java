package com.yundao.tenant.service.role.resource.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.mapper.base.BaseRoleResourceMapper;
import com.yundao.tenant.model.base.BaseRoleResource;
import com.yundao.tenant.model.base.BaseRoleResourceExample;
import com.yundao.tenant.service.role.resource.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色资源服务实现类
 *
 * @author jan
 * @create 2017-06-23 PM4:36
 **/
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    private static Log log = LogFactory.getLog(RoleResourceServiceImpl.class);

    @Autowired
    private BaseRoleResourceMapper baseRoleResourceMapper;

    @Override
    public List<BaseRoleResource> getByRoleId(Long roleId) throws BaseException {
        log.begin(roleId);
        BaseRoleResourceExample example = new BaseRoleResourceExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<BaseRoleResource> roleResources = baseRoleResourceMapper.selectByExample(example);
        log.end();
        return roleResources;
    }

    @Override
    public List<BaseRoleResource> getByRoleIds(List<Long> roleIds) throws BaseException {
        log.begin(roleIds);
        BaseRoleResourceExample example = new BaseRoleResourceExample();
        example.createCriteria().andRoleIdIn(roleIds);
        List<BaseRoleResource> roleResources = baseRoleResourceMapper.selectByExample(example);
        log.end();
        return roleResources;
    }

    @Override
    public void insert(List<BaseRoleResource> models) throws BaseException {
        if (BooleanUtils.isEmpty(models))
            return;
        for (BaseRoleResource model : models) {
            baseRoleResourceMapper.insertSelective(model);
        }
    }

    @Override
    public void delete(List<BaseRoleResource> models) throws BaseException {
        if (BooleanUtils.isEmpty(models))
            return;
        for (BaseRoleResource model : models) {
            baseRoleResourceMapper.deleteByPrimaryKey(model.getId());
        }
    }
}
