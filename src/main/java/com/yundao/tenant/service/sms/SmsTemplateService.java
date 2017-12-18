package com.yundao.tenant.service.sms;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseSmsTemplate;

/**
 * 短信模版服务接口
 *
 * @author jan
 * @create 2017-06-19 PM2:12
 **/
public interface SmsTemplateService {

    /**
     * 根据模版编码获取
     *
     * @param code     模版编码
     * @param tenantId 租户id
     * @return 模版信息
     */
    BaseSmsTemplate getByCode(String code, Long tenantId) throws BaseException;
}
