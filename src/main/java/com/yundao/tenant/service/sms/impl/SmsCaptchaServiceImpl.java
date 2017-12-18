package com.yundao.tenant.service.sms.impl;

import com.yundao.core.code.Result;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.DbCodeKeyConstant;
import com.yundao.tenant.dto.sms.captcha.SmsCaptchaDto;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.sms.SmsCaptchaMapper;
import com.yundao.tenant.service.sms.SmsCaptchaService;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.MobileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 短信验证码服务实现类
 *
 * @author jan
 * @create 2017-06-19 AM11:32
 **/
@Service
public class SmsCaptchaServiceImpl extends AbstractService implements SmsCaptchaService {

    private static Log log = LogFactory.getLog(SmsCaptchaServiceImpl.class);

    @Autowired
    private SmsCaptchaMapper smsCaptchaMapper;

    /**
     * 验证码有效时间
     */
    private final int VALID_MINUTE = 15;

    @Override
    public int insert(String captcha, String templateCode, String mobile, HeaderUser user, Integer validMinute) throws BaseException {
        log.info("保存短信验证码开始");
        if (StringUtils.isBlank(mobile)) {
            log.info("手机号码为空，结束");
            throw new BaseException(CodeConstant.CODE_1220023);
        }
        smsCaptchaMapper.updateUnValid(mobile, templateCode, DbCodeKeyConstant.MOBILE);// 修改当前手机号码认证码状态为无效
        log.info("更新旧短信验证码完成");
        SmsCaptchaDto model = new SmsCaptchaDto();
        super.initialModel(model);
        // 如果启用新线程发送，获取不了本多线程信息
        if (user != null) {
            model.setCreateUserId(user.getUserId());
            model.setTenantId(user.getTenantId());
        }
        model.setIsValid(YesOrNoEnum.YES.getValue());
        model.setCode(captcha);
        model.setMobile(mobile);
        model.setExpireTime(DateUtil.addMinute(validMinute == null ? VALID_MINUTE : validMinute));
        model.setTemplateCode(templateCode);
        model.setDbCodeKey(DbCodeKeyConstant.MOBILE);
        int result = smsCaptchaMapper.insert(model);
        log.info("保存短信验证码完成");
        return result;
    }

    @Override
    public Result<Boolean> doVerifyAndSetInvalidIfPass(String mobile, String templateCode, String captcha) throws BaseException {
        String logPrefix = "短信验证码||校验||";
        log.info("%s||参数 templateCode %s,captcha %s,mobile %s", logPrefix, templateCode, captcha,
                MobileUtil.encrypt(mobile));

        SmsCaptchaDto dto = smsCaptchaMapper.selectCaptcha(mobile, templateCode, DbCodeKeyConstant.MOBILE);
        if (dto != null)
            dto.setMobile(MobileUtil.encrypt(dto.getMobile()));
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));

        if (dto == null)
            return Result.newFailureResult(CodeConstant.CODE_1220077);
        if (dto.getIsValid().equals(YesOrNoEnum.NO.getValue()))
            return Result.newFailureResult(CodeConstant.CODE_1220078);
        Date now = new Date();
        if (now.compareTo(dto.getExpireTime()) >= 0)
            return Result.newFailureResult(CodeConstant.CODE_1220078);
        if (!dto.getCode().equals(captcha))
            return Result.newFailureResult(CodeConstant.CODE_1220077);

        // 将验证码设置失效
        super.updateModel(dto);
        dto.setIsValid(YesOrNoEnum.NO.getValue());
        smsCaptchaMapper.updateValid(dto);
        log.info("%s完成", logPrefix);
        return Result.newSuccessResult(true);
    }

}
