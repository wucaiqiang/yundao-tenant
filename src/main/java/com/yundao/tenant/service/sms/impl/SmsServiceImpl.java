package com.yundao.tenant.service.sms.impl;

import com.yundao.core.code.Result;
import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.enums.SmsTypeEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.CaptchaUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.ThreadUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.sms.SmsChannel;
import com.yundao.tenant.constant.url.BaseUrlConstant;
import com.yundao.tenant.dto.sms.SmsTemplateDto;
import com.yundao.tenant.dto.sms.SmsRequestDto;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.sms.template.SmsTemplateCodeEnum;
import com.yundao.tenant.model.base.BaseSmsAccount;
import com.yundao.tenant.model.base.BaseSmsConf;
import com.yundao.tenant.model.base.BaseSmsTemplate;
import com.yundao.tenant.service.sms.*;
import com.yundao.tenant.util.HeaderUserThreadLocal;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jans
 * @create 2017-06-18 PM7:39
 **/
@Service
public class SmsServiceImpl extends AbstractService implements SmsService {

    private static Log log = LogFactory.getLog(SmsServiceImpl.class);

    @Autowired
    private SmsCaptchaService smsCaptchaService;

    @Autowired
    private SmsConfService smsConfService;

    @Autowired
    private SmsTemplateService smsTemplateService;

    @Autowired
    private SmsAccountService smsAccountService;

    @Override
    public void sendToB(String mobiles, SmsTemplateDto templateDto) throws BaseException {
        SmsRequestDto dto = toCoreDto(templateDto, SmsChannel.TO_B);
        HeaderUser user = super.getHeaderUser();
        ThreadUtils.execute(() -> {
            HeaderUserThreadLocal.set(user);
            this.doSendNotify(SymbolStrUtils.toList(mobiles), dto, user);
        });
    }

    @Override
    public void sendToB(List<String> mobiles, SmsTemplateDto templateDto) throws BaseException {
        SmsRequestDto dto = toCoreDto(templateDto, SmsChannel.TO_B);
        HeaderUser user = super.getHeaderUser();
        ThreadUtils.execute(() -> {
            HeaderUserThreadLocal.set(user);
            this.doSendNotify(mobiles, dto, user);
        });
    }

    @Override
    public void sendCaptchaToC(String mobile, SmsTemplateDto templateDto) throws BaseException {
        SmsRequestDto dto = toCoreDto(templateDto, SmsChannel.TO_C);
        HeaderUser user = super.getHeaderUser();
        ThreadUtils.execute(() -> {
            HeaderUserThreadLocal.set(user);
            this.doSendCaptcha(mobile, dto, user, null);
        });
    }

    @Override
    public Result<Integer> doSendCaptchaSyncToC(String mobile, SmsTemplateDto templateDto) throws BaseException {
        SmsRequestDto dto = toCoreDto(templateDto, SmsChannel.TO_C);
        return this.doSendCaptcha(mobile, dto, super.getHeaderUser(), null);
    }

    @Override
    public void sendPromotionToB(String mobiles, SmsTemplateDto templateDto) throws BaseException {
        SmsRequestDto dto = toCoreDto(templateDto, SmsChannel.TO_B);
        HeaderUser user = super.getHeaderUser();
        ThreadUtils.execute(() -> {
            HeaderUserThreadLocal.set(user);
            this.doSendPromotion(SymbolStrUtils.toList(mobiles), dto, user);
        });
    }


    /**
     * 推广类短信发送
     */
    private Result<Integer> doSendPromotion(List<String> mobiles, SmsRequestDto dto, HeaderUser user) {
        try {
            dto.setSmsType(SmsTypeEnum.PROMOTION.getValue());
            return this.doSend(mobiles, dto, user);
        } catch (Exception e) {
            log.error("doSendPromotion 异常：%s", e.toString());
            return Result.newFailureResult();
        }
    }

    /**
     * 验证码类短信发送
     */
    private Result<Integer> doSendCaptcha(String mobile, SmsRequestDto dto, HeaderUser user, Integer validMinute) {
        try {
            String captchaCode = CaptchaUtils.getCaptcha().toString();
            dto.getTemplateParmaMap().put(CommonConstant.CAPTCHA_NAME, captchaCode);
            List<String> mobiles = new ArrayList<>(1);
            mobiles.add(mobile);
            dto.setSmsType(SmsTypeEnum.CAPTCHA.getValue());
            Result<Integer> result = this.doSend(mobiles, dto, user);
            if (result.getSuccess())
                smsCaptchaService.insert(captchaCode, dto.getCode(), mobile, user, validMinute);
            else
                log.info("调用bs发送短信失败，不保存短信验证码");
            return result;
        } catch (Exception e) {
            log.error("doSendCaptcha 异常：%s", e.toString());
            return Result.newFailureResult();
        }
    }


    /**
     * 通知类短信发送
     */
    private Result<Integer> doSendNotify(List<String> mobiles, SmsRequestDto dto, HeaderUser user) {
        try {
            //mobiles = this.doExtend(templateDto.getCode(), mobiles);
            dto.setSmsType(SmsTypeEnum.NOTIFY.getValue());
            return this.doSend(mobiles, dto, user);
        } catch (Exception e) {
            log.error("doSendNotify 异常：" + e.toString());
            return Result.newFailureResult();
        }
    }

    /**
     * 调用消息中心，发送短信统一方法
     *
     * @param mobiles 手机号码
     * @param dto     请求数据
     * @param user    用户信息
     * @return 执行结果
     */
    private Result<Integer> doSend(List<String> mobiles, SmsRequestDto dto, HeaderUser user) throws BaseException {
        String logPrefix = "短信服务||调用bs发送短信||";
        log.info("%s 参数：dto:%s,user:%s", logPrefix, JsonUtils.objectToJson(dto), JsonUtils.objectToJson(user));

        Boolean useDefaultAccount = this.checkIsUseDefaultAccount(user.getTenantId(), dto.getChannel());
        String thirdPartyCode = this.getThirdPartyCode(user.getTenantId(), useDefaultAccount, dto.getCode());
        Map<String, Object> params = getRequestParam(mobiles, dto, user, useDefaultAccount, thirdPartyCode);
        Map<String, Object> headerParams = getRequestHeader(user);

        String url = useDefaultAccount ? BaseUrlConstant.SEND_SMS : BaseUrlConstant.SEND_SMS_WITH_ACCOUNT;
        log.info("%s url %s", logPrefix, url);
        Result<Integer> result = HttpUtils.post(url, headerParams, params, new
                BaseTypeReference<Result<Integer>>() {
                });
        log.info("%s 调用bs发送短信返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
        return result;
    }

    /**
     * 获取请求参数
     */
    private Map<String, Object> getRequestParam(List<String> mobiles, SmsRequestDto dto, HeaderUser user, Boolean useDefaultAccount, String thirdPartyCode) throws BaseException {
        String logPrefix = "短信服务||获取请求参数||";
        Map<String, Object> params = new HashMap<>();
        if (!useDefaultAccount) {
            BaseSmsAccount smsAccount = this.getAccount(user.getTenantId());
            params.put("accessKeyId", smsAccount.getAccessKeyId());
            params.put("accessKeySecret", smsAccount.getAccessKeySecret());
            params.put("sign", smsAccount.getSign());
        }
        params.put("templateCode", thirdPartyCode);
        params.put("templateParam", JsonUtils.objectToJson(dto.getTemplateParmaMap()));
        params.put("smsType", dto.getSmsType());
        log.info("%s params:%s", logPrefix, JsonUtils.objectToJson(params));
        params.put("mobiles", SymbolStrUtils.toStr(mobiles));
        log.info("%s mobiles 条数", mobiles.size());
        return params;
    }

    /**
     * 获取请求头部
     */
    private Map<String, Object> getRequestHeader(HeaderUser user) {
        //如果启用了新线程调用，需要自己塞请求头
        Map<String, Object> headerParams = new HashMap<>(3);
        headerParams.put(HeaderConstant.HEADER_USER_ID, user.getUserId());
        headerParams.put(HeaderConstant.HEADER_TENANT_ID, user.getTenantId());
        headerParams.put(HeaderConstant.HEADER_REAL_NAME, user.getRealName());
        return headerParams;
    }

    /**
     * 是否使用默认通道（云道短信通道）
     *
     * @param tenantId    租户id
     * @param channelType 类型：2B OR 2C
     */
    private Boolean checkIsUseDefaultAccount(Long tenantId, String channelType) throws BaseException {
        String logPrefix = "短信服务||获取三方平台短信模板编码";
        log.info("%s channelType %s", logPrefix, channelType);
        if (BooleanUtils.isBlank(channelType))
            throw new BaseException(CodeConstant.CODE_1220106);
        if (SmsChannel.TO_B.equals(channelType))
            return true;
        if (SmsChannel.TO_C.equals(channelType)) {
            //获取租户配置
            BaseSmsConf conf = smsConfService.get(tenantId);
            log.info("%s conf %s", logPrefix, JsonUtils.objectToJson(conf));
            return conf != null && YesOrNoEnum.YES.getValue().equals(conf.getUseDefalutChannel());
        }
        throw new BaseException(CodeConstant.CODE_1220107);
    }

    /**
     * 获取对应的三方平台模板CODE
     *
     * @param tenantId            租户id
     * @param isUseDefaultAccount 是否使用默认通道
     * @param templateCode        本地模板CODE
     */
    private String getThirdPartyCode(Long tenantId, Boolean isUseDefaultAccount, String templateCode) throws BaseException {
        String logPrefix = "短信服务||获取三方平台短信模板编码";
        log.info("%s checkIsUseDefaultAccount %s,templateCode:%s", logPrefix, isUseDefaultAccount, templateCode);
        if (isUseDefaultAccount)
            return SmsTemplateCodeEnum.getDefaultCode(templateCode);

        //获取租户自己的模板
        log.info("%s 获取租户自己的模板", logPrefix);
        BaseSmsTemplate template = smsTemplateService.getByCode(templateCode, tenantId);
        log.info("%s template %s", logPrefix, JsonUtils.objectToJson(template));
        if (template == null)
            throw new BaseException(CodeConstant.CODE_1220104);
        return template.getThirdPartyCode();
    }

    /**
     * 获取租户短信账号
     */
    private BaseSmsAccount getAccount(Long tenantId) throws BaseException {
        String logPrefix = "短信服务||获取租户短信账号||";
        log.info("%s tenantId %s", logPrefix, tenantId);
        BaseSmsAccount account = smsAccountService.get(tenantId);
        log.info("%s account %s", logPrefix, JsonUtils.objectToJson(account));
        if (account == null)
            throw new BaseException(CodeConstant.CODE_1220105);
        return account;
    }

    /**
     * dto转换
     */
    private SmsRequestDto toCoreDto(SmsTemplateDto templateDto, String channleType) {
        SmsRequestDto coreDto = new SmsRequestDto();
        coreDto.setCode(templateDto.getCode());
        coreDto.setChannel(channleType);
        coreDto.setTemplateParmaMap(templateDto.getParams());
        return coreDto;
    }

/*
    *
     * 短信扩展
     *
     * @param templateCode 短信模版code
     * @param mobiles      需要发送的手机号码
     * @return 扩展后的手机号码

    private List<String> doExtend(String templateCode, List<String> mobiles) {
        String blackLists = null;
        String whiteLists = null;
        List<BaseSmsExtend> extendList = smsExtendService.getByTemplateCode(templateCode);
        if (BooleanUtils.isNotEmpty(extendList)) {
            BaseSmsExtend appendExtend = LambdaFilter.firstOrDefault(extendList, m -> SmsExtendTypeEnum.APPEND.getValue().equals(m.getType()));
            if (appendExtend != null) {
                whiteLists = appendExtend.getMobiles();
            }
            BaseSmsExtend filterExtend = LambdaFilter.firstOrDefault(extendList, m -> SmsExtendTypeEnum.FILTER.getValue().equals(m.getType()));
            if (filterExtend != null) {
                blackLists = filterExtend.getMobiles();
            }
        }
        //过滤
        if (BooleanUtils.isNotEmpty(blackLists)) {
            List<String> blacks = Arrays.asList(blackLists.split(SymbolConstant.COMMA));
            List<String> legalMobiles = new ArrayList<>();
            for (String mobile : mobiles) {
                if (!blacks.contains(mobile))
                    legalMobiles.add(mobile);
            }
            mobiles = legalMobiles;
        }
        //追加
        if (BooleanUtils.isNotEmpty(whiteLists)) {
            List<String> whites = Arrays.asList(whiteLists.split(SymbolConstant.COMMA));
            mobiles.addAll(whites);
        }
        return mobiles;
    }*/

}
