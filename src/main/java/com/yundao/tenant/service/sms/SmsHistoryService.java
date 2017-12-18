package com.yundao.tenant.service.sms;


import com.yundao.tenant.model.base.BaseSmsHistory;

/**
 * 短信历史记录服务接口
 *
 * @author jan
 * @create 2017-06-19 AM11:15
 **/
public interface SmsHistoryService {

    /**
     * 插入
     *
     * @param model 短信历史记录
     * @return 操作结果
     */
    int insert(BaseSmsHistory model);

}
