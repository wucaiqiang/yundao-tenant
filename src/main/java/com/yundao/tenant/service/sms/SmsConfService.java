package com.yundao.tenant.service.sms;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseSmsConf;

/**
 * 短信配置服务接口
 *
 * @author jan
 * @create 2017-09-14 PM8:05
 **/
public interface SmsConfService {

    /**
     * 获取租户短信配置
     *
     * @param tenantId 租户id
     */
    BaseSmsConf get(Long tenantId) throws BaseException;

}
