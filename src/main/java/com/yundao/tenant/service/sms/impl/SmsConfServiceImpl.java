package com.yundao.tenant.service.sms.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.mapper.base.BaseSmsConfMapper;
import com.yundao.tenant.model.base.BaseSmsConf;
import com.yundao.tenant.model.base.BaseSmsConfExample;
import com.yundao.tenant.service.sms.SmsConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信配置服务实现
 *
 * @author jan
 * @create 2017-09-14 PM8:16
 **/
@Service
public class SmsConfServiceImpl implements SmsConfService {

    @Autowired
    private BaseSmsConfMapper baseSmsConfMapper;

    @Override
    public BaseSmsConf get(Long tenantId) throws BaseException {
        BaseSmsConfExample example = new BaseSmsConfExample();
        example.createCriteria().andTenantIdEqualTo(tenantId);
        example.setOrderByClause("create_date DESC");
        List<BaseSmsConf> confs = baseSmsConfMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(confs))
            return null;
        return confs.get(0);
    }
}
