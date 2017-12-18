package com.yundao.tenant.service.sms;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseSmsExtend;

import java.util.List;

/**
 * 短信扩展服务接口
 *
 * @author jan
 * @create 2017-06-20 AM9:56
 **/
public interface SmsExtendService {

    /**
     * 根据模板编码获取
     *
     * @param templateCode 短信模版编码
     * @return 短信扩展信息
     */
    List<BaseSmsExtend> getByTemplateCode(String templateCode);
}
