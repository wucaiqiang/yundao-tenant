package com.yundao.tenant.service.sms;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sms.SmsTemplateDto;

import java.util.List;

/**
 * 短信发送服务接口
 *
 * @author jan
 * @create 2017-06-18 PM7:25
 **/
public interface SmsService {

    /**
     * 使用默认通道发送短信，通知类
     *
     * @param mobiles     需要发送的手机号，多个逗号分隔
     * @param templateDto 短信模版参数
     */
    void sendToB(String mobiles, SmsTemplateDto templateDto) throws BaseException;

    /**
     * 使用默认通道发送短信，通知类
     *
     * @param mobiles     需要发送的手机号，多个逗号分隔
     * @param templateDto 短信模版参数
     */
    void sendToB(List<String> mobiles, SmsTemplateDto templateDto) throws BaseException;

    /**
     * 使用租户自己的通道 发送验证码,请将验证码放到 templateDto的map，有效时长默认15minute
     *
     * @param mobile 需要发送的手机号，只能发送单个
     */
    void sendCaptchaToC(String mobile, SmsTemplateDto templateDto) throws BaseException;

    /**
     * 使用租户自己的通道 同步发送验证码,请将验证码放到 templateDto的map，有效时长默认15minute
     *
     * @param mobile 需要发送的手机号，只能发送单个
     */
    Result<Integer> doSendCaptchaSyncToC(String mobile, SmsTemplateDto templateDto) throws BaseException;

    /**
     * 使用默认通道 发送推广类短信
     *
     * @param mobiles     需要发送的手机号，多个逗号分隔
     * @param templateDto 短信模版参数
     */
    void sendPromotionToB(String mobiles, SmsTemplateDto templateDto) throws BaseException;


}
