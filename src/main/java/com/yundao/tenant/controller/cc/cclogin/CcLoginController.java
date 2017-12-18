package com.yundao.tenant.controller.cc.cclogin;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.dto.login.UserLoginReqDto;
import com.yundao.core.dto.login.UserLoginResDto;
import com.yundao.core.dto.login.UserUpdatePasswordResDto;
import com.yundao.core.service.login.AbstractLoginService;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.cc.cclogin.CcRegisterReqDto;
import com.yundao.tenant.dto.cc.cclogin.LoginDetailReqDto;
import com.yundao.tenant.dto.login.RetrievePasswordDto;
import com.yundao.tenant.dto.user.password.UserUpdatePasswordReqDto;
import com.yundao.tenant.enums.sms.template.CaptchaTempEnum;
import com.yundao.tenant.service.cc.ccuseraccount.CcUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/cc/user/")
@ResponseBody
@Api("投资用户登录")
public class CcLoginController{

    @Autowired
    private AbstractLoginService ccLoginService;

    @Autowired
    private CcUserAccountService ccUserAccountService;

    @RequestMapping(value="login_out", method=RequestMethod.POST)
    @ApiOperation(value="登出当前用户", notes="登出")
    public Result<Boolean> doLoginOut() throws Exception{
        return ccLoginService.doLoginOut();
    }

    @RequestMapping(value = "login",method=RequestMethod.GET)
    @ApiOperation(value="分页查询投资用户登录")
    public Result<UserLoginResDto> login(@ModelAttribute UserLoginReqDto userLoginReqDto,@ModelAttribute LoginDetailReqDto loginDetailReqDto) throws Exception{
        return ccLoginService.doLogin(userLoginReqDto,loginDetailReqDto);
    }

    @RequestMapping(value="update_password", method=RequestMethod.POST)
    @ApiOperation(value="修改登录用户的密码", notes="修改登陆用户的密码")
    public Result<Integer> updateUserPassword(@ModelAttribute UserUpdatePasswordReqDto userUpdatePasswordResDto) throws Exception{
        //获取当前用户的手机号
        UserUpdatePasswordResDto resDto = new UserUpdatePasswordResDto();
        BeanUtils.copyProperties(userUpdatePasswordResDto,resDto);
        HeaderUser headerUser = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        resDto.setUserName(ccUserAccountService.get(headerUser.getUserId()).getResult().getMobile());
        return ccLoginService.updatePwdByUser(resDto);
    }

    @RequestMapping(value = "/send_retrieve_captcha", method = RequestMethod.POST)
    @ApiOperation(value = "发送找回密码验证码", notes = "发送找回密码验证码")
    public Result<Integer> sendRetrieveCaptcha(@RequestParam String mobile) throws Exception {
        return ccUserAccountService.sendRetrieveCaptcha(mobile, CaptchaTempEnum.RETRIEVE_2C_CAPTCHA);
    }

    @RequestMapping(value = "/send_register_captcha", method = RequestMethod.POST)
    @ApiOperation(value = "发送注册验证码", notes = "发送找回密码验证码")
    public Result<Integer> sendRegisterCaptcha(@RequestParam String mobile) throws Exception {
        return ccUserAccountService.sendRetrieveCaptcha(mobile, CaptchaTempEnum.REGISTER_2C_CAPTCHA);
    }

    @RequestMapping(value = "/retrieve_password", method = RequestMethod.POST)
    @ApiOperation(value = "找回密码", notes = "找回密码")
    public Result<Integer> retrievePassword(@ModelAttribute @Validated RetrievePasswordDto mobile, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return ccUserAccountService.processRetrievePassword(mobile);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户", notes = "注册用户")
    public Result<Map<String, Object>> register(@ModelAttribute @Validated CcRegisterReqDto reqDto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return ccUserAccountService.processRegister(reqDto);
    }

    @RequestMapping(value = "/validate_mobile", method = RequestMethod.POST)
    @ApiOperation(value = "验证手机号是否存在", notes = "注册用户")
    public Result<Boolean> validateMobile(@RequestParam String mobile) throws Exception {
        return ccUserAccountService.validateMobile(mobile);
    }
}
