package com.yundao.tenant.service.sms.impl;

import com.yundao.tenant.mapper.base.BaseSmsHistoryMapper;
import com.yundao.tenant.model.base.BaseSmsHistory;
import com.yundao.tenant.service.sms.SmsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信历史记录服务实现类
 *
 * @author jan
 * @create 2017-06-19 AM11:17
 **/
@Service
public class SmsHistoryServiceImpl implements SmsHistoryService {

    @Autowired
    private BaseSmsHistoryMapper baseSmsHistoryMapper;

    @Override
    public int insert(BaseSmsHistory model) {
        return baseSmsHistoryMapper.insertSelective(model);
    }
}
