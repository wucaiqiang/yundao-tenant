package com.yundao.tenant.service.sms.impl;

import com.yundao.tenant.mapper.base.BaseSmsExtendMapper;
import com.yundao.tenant.model.base.BaseSmsExtend;
import com.yundao.tenant.model.base.BaseSmsExtendExample;
import com.yundao.tenant.service.sms.SmsExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信扩展服务实现类
 *
 * @author jan
 * @create 2017-06-20 AM10:00
 **/
@Service
public class SmsExtendServiceImpl implements SmsExtendService {

    @Autowired
    private BaseSmsExtendMapper baseSmsExtendMapper;

    @Override
    public List<BaseSmsExtend> getByTemplateCode(String templateCode) {
        BaseSmsExtendExample seExample = new BaseSmsExtendExample();
        seExample.createCriteria().andTemplateCodeEqualTo(templateCode);
        List<BaseSmsExtend> extendList = baseSmsExtendMapper.selectByExample(seExample);
        return extendList;
    }
}
