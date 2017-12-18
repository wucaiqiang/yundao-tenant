package com.yundao.tenant.service.sms.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.base.BaseSmsTemplateMapper;
import com.yundao.tenant.model.base.BaseSmsTemplate;
import com.yundao.tenant.model.base.BaseSmsTemplateExample;
import com.yundao.tenant.service.sms.SmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信模版服务实现类
 *
 * @author jan
 * @create 2017-06-19 PM2:14
 **/
@Service
public class SmsTemplateServiceImpl implements SmsTemplateService {

    @Autowired
    private BaseSmsTemplateMapper baseSmsTemplateMapper;

    @Override
    public BaseSmsTemplate getByCode(String code, Long tenantId) throws BaseException {
        BaseSmsTemplateExample stExample = new BaseSmsTemplateExample();
        stExample.createCriteria().andCodeEqualTo(code).andIsEnableEqualTo(YesOrNoEnum.YES.getValue()).andTenantIdEqualTo(tenantId);
        stExample.setOrderByClause("create_date DESC");
        List<BaseSmsTemplate> templates = baseSmsTemplateMapper.selectByExample(stExample);
        if (BooleanUtils.isEmpty(templates))
            return null;
        return templates.get(0);
    }
}
