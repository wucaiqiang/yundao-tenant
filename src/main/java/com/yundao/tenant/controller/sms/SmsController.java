package com.yundao.tenant.controller.sms;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sms.SmsTemplateDto;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.sms.template.SmsTemplateCodeEnum;
import com.yundao.tenant.model.base.BaseRole;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.sms.SmsCacheService;
import com.yundao.tenant.service.sms.SmsCaptchaService;
import com.yundao.tenant.service.sms.SmsService;
import com.yundao.tenant.util.request.RequestHeaderUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jan
 * @create 2017-06-19 PM8:14
 **/
@Controller
@ResponseBody
@RequestMapping("/sms")
@Api("短信")
public class SmsController {

    @Autowired
    private SmsCacheService smsCacheService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private SmsCaptchaService smsCaptchaService;

    @Autowired
    private MsgMessageService msgMessageService;

    @RequestMapping(value = "/msg", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信", notes = "异步发送")
    public Result<Long> msg(String content) throws BaseException {
        Map<String, Object> params = new HashMap<>(2);
        params.put("createUserName", "ABCC");
        params.put("customerIds", content);
        return msgMessageService.processSendMessage(MsgMessageCodeEnum.ADD_CUSTOMER.getCode(), params);
    }

    @RequestMapping(value = "/send_captcha", method = RequestMethod.GET)
    @ApiOperation(value = "发送验证码")
    public Result<Boolean> sendCaptcha(@RequestParam String mobile) throws BaseException {
        SmsTemplateDto std = new SmsTemplateDto();
        std.setCode(SmsTemplateCodeEnum.NOTIFY_2B_TEST.getValue());
        Map<String, String> param = new HashMap<>();
        param.put("code", "ST0998876793");
        std.setParams(param);
        smsService.sendToB(mobile, std);
        return Result.newSuccessResult(true);
    }

    @RequestMapping(value = "/verify_captcha", method = RequestMethod.GET)
    @ApiOperation(value = "校验验证码")
    public Result<Boolean> verifyCaptcha(@RequestParam String mobile, @RequestParam String captcha) throws
            BaseException {
        return smsCaptchaService.doVerifyAndSetInvalidIfPass(mobile, "SMS_85930037", captcha);
    }


    @RequestMapping(value = "/get_cache", method = RequestMethod.GET)
    @ApiOperation(value = "缓存测试")
    public Result<List<BaseRole>> getCache() throws BaseException {
        return Result.newSuccessResult(smsCacheService.gets(RequestHeaderUtils.getTenantId()));
    }

    @RequestMapping(value = "/send_2c", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信", notes = "异步发送")
    public Result<String> send2c(@RequestParam String mobile) throws BaseException {
        SmsTemplateDto std = new SmsTemplateDto();
        std.setCode(SmsTemplateCodeEnum.CAPTCHA_2C_RETRIEVE.getValue());
        smsService.sendCaptchaToC(mobile, std);

        return Result.newSuccessResult("短信已通过异步发送");
    }

    @RequestMapping(value = "/send_2c_sync", method = RequestMethod.POST)
    @ApiOperation(value = "发送短信", notes = "异步发送")
    public Result<String> send2cSync(@RequestParam String mobile) throws BaseException {
        SmsTemplateDto std = new SmsTemplateDto();
        std.setCode(SmsTemplateCodeEnum.CAPTCHA_2C_RETRIEVE.getValue());
        smsService.doSendCaptchaSyncToC(mobile, std);

        return Result.newSuccessResult("短信已通过异步发送");
    }

}
