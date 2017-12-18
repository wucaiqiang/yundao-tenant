package com.yundao.tenant.service.sms;


import com.yundao.core.code.Result;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;

/**
 * 短信验证码服务接口
 *
 * @author jan
 * @create 2017-06-19 AM11:30
 **/
public interface SmsCaptchaService {

    /**
     * 插入
     *
     * @param captcha      验证码
     * @param templateCode 模版code
     * @param mobile       手机号码
     * @param user         user
     * @param validMinute  有效时长，单位：分钟
     * @return 操作结果
     */
    int insert(String captcha, String templateCode, String mobile, HeaderUser user, Integer validMinute) throws BaseException;

    /**
     * 校验验证码，如果验证码通过，设置失效
     *
     * @param mobile       手机号码
     * @param captcha      验证码
     * @param templateCode 模板CODE
     * @return 如果校验成功，返回 Result isSuccess为true，否则为false并返回对应错误提示码
     * @throws BaseException
     */
    Result<Boolean> doVerifyAndSetInvalidIfPass(String mobile, String templateCode, String captcha) throws BaseException;
}
