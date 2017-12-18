package com.yundao.tenant.mapper.sms;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sms.captcha.SmsCaptchaDto;
import org.apache.ibatis.annotations.Param;

/**
 * @author jan
 * @create 2017-09-05 PM6:03
 **/
public interface SmsCaptchaMapper {

    /**
     * 插入短信验证码
     */
    int insert(SmsCaptchaDto dto) throws BaseException;

    /**
     * 获取验证码
     *
     * @param mobile       手机号码
     * @param templateCode 模板CODE
     * @param dbCodeKey    数据库密钥
     */
    SmsCaptchaDto selectCaptcha(@Param("mobile") String mobile, @Param("templateCode") String templateCode, @Param("dbCodeKey") String dbCodeKey) throws BaseException;

    /**
     * 设置有效性
     */
    int updateValid(SmsCaptchaDto dto) throws BaseException;
    /**
     * 根据手机号码修改验证码为无效
     * updateUnValid:
     * @author: wucq
     * @param mobile
     * @param templateCode
     * @param dbCodeKey
     * @return
     * @throws BaseException
     * @description:
     */
    int updateUnValid(@Param("mobile") String mobile,@Param("templateCode") String templateCode,  @Param("dbCodeKey") String dbCodeKey) throws BaseException;
}
