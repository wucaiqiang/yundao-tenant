package com.yundao.tenant.service.sms.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.mapper.base.BaseRoleMapper;
import com.yundao.tenant.model.base.BaseRole;
import com.yundao.tenant.model.base.BaseRoleExample;
import com.yundao.tenant.service.sms.SmsCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jan
 * @create 2017-08-25 AM7:50
 **/
@Service
public class SmsCacheServiceImpl implements SmsCacheService {

    private static Log log = LogFactory.getLog(SmsCacheServiceImpl.class);

    @Autowired
    private BaseRoleMapper baseRoleMapper;

    @Override
    @Cacheable(value = "smsCache")
    public List<BaseRole> gets(Long tenantId) throws BaseException {
        log.info("SmsCacheServiceImpl 从DB获取数据");
        return doGet(tenantId);
    }

    private List<BaseRole> doGet(Long tenantId) throws BaseException {
        BaseRoleExample example = new BaseRoleExample();
        example.createCriteria().andTenantIdEqualTo(tenantId);
        return baseRoleMapper.selectByExample(example);
    }

}
