package com.yundao.tenant.service.cc.ccuseraccount;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cc.cclogin.CcRegisterReqDto;
import com.yundao.tenant.dto.cc.ccuseraccount.CcUserAccountReqDto;
import com.yundao.tenant.dto.login.RetrievePasswordDto;
import com.yundao.tenant.enums.sms.template.CaptchaTempEnum;
import com.yundao.tenant.model.base.cc.BaseCcUserAccount;

import java.util.Map;


public interface CcUserAccountService{


    public Result<Integer> add(CcUserAccountReqDto reqDto) throws Exception;


    public Result<Integer> update(CcUserAccountReqDto reqDto) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCcUserAccount> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCcUserAccount>> getPage(CcUserAccountReqDto ccUserAccountReqDto, AbstractBasePageDto pageDto) throws Exception;

    /**
     * 发送短信验证码
     * @param mobile
     * @param retrieve2cCaptcha
     * @return
     */
    Result<Integer> sendRetrieveCaptcha(String mobile, CaptchaTempEnum retrieve2cCaptcha) throws Exception;

    /**
     * 找回密码
     * @param mobile
     * @return
     */
    Result<Integer> processRetrievePassword(RetrievePasswordDto mobile) throws Exception;

    String processEncryptDBPassword(String password) throws Exception;

    String processDecryptTranPassword(String password) throws Exception;

    /**
     * 注册用户
     * @param reqDto
     * @return
     */
    Result<Map<String, Object>> processRegister(CcRegisterReqDto reqDto) throws Exception;

    /**
     * 验证手机号是否存在
     * @param mobile
     * @return
     */
    Result<Boolean> validateMobile(String mobile) throws Exception;
}
