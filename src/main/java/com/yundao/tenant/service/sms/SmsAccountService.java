package com.yundao.tenant.service.sms;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseSmsAccount;

/**
 * 短信账号服务接口
 *
 * @author jan
 * @create 2017-09-14 PM11:39
 **/
public interface SmsAccountService {

    /**
     * 获取租户短信账号
     *
     * @param tenantId 租户id
     */
    BaseSmsAccount get(Long tenantId) throws BaseException;
}
