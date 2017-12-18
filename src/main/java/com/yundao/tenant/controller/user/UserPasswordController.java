/*package com.yundao.tenant.controller.user;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.keypair.KeyPairResDto;
import com.yundao.tenant.dto.tenant.TenantDto;
import com.yundao.tenant.dto.user.UserDetailResDto;
import com.yundao.tenant.dto.user.password.UserUpdatePasswordReqDto;
import com.yundao.tenant.dto.user.password.UserloginReqDto;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.model.base.BaseUserAccount;
import com.yundao.tenant.service.user.LoginService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.ObjectAndByteUtils;
import com.yundao.tenant.util.RSAUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

*//**
 * 用户管理
 * 
 * @author 欧阳利 2017年6月22日
 *//*
@RestController
@ResponseBody
@RequestMapping("/user")
@Api("密码管理")
public class UserPasswordController {
	private static Log log = LogFactory.getLog(UserPasswordController.class);
	@Autowired
	LoginService userPasswordService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/get_key_pair", method = RequestMethod.GET)
	@ApiOperation(value = "获取密钥对", notes = "获取密钥对")
	public Result<Integer> getKeyPair() throws Exception {
		Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("tenantId", "-1");
		methodParams.put("region", "db");
		Result<KeyPairResDto> result = HttpUtils.get(ScmUrlConstant.KEY_PAIR_GET_BY_TENANT_ID, methodParams,
				new BaseTypeReference<Result<KeyPairResDto>>() {
				});
		KeyPairResDto dto=result.getResult();
		
		KeyPair keyPair=(KeyPair)ObjectAndByteUtils.toObject(dto.getKeyPair()); 
		
		return Result.newSuccessResult();
	}

	*//**
	 * 修改用户密码
	 * 
	 * @param userReqDto
	 * @return
	 *//*
	@RequestMapping(value = "/update_password", method = RequestMethod.POST)
	@ApiOperation(value = "修改用户密码", notes = "修改用户密码")
	public Result<Integer> updateUserPassword(@ModelAttribute @Validated UserUpdatePasswordReqDto userReqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		// 查询用户的手机号码
		String mobile = userService.getCurrentUserMobile();
		if (mobile == null) {
			return Result.newFailureResult(1, "当前用户不存在,请登录！", null);
		}
		// 修改密码
		Map<String, Object> methodParams = new HashMap<String, Object>();
		methodParams.put("username", mobile);
		methodParams.put("oldPassword", userReqDto.getOldPassword());
		methodParams.put("newPassword", userReqDto.getNewPassword());
		Result<Integer> result = HttpUtils.post(ScmUrlConstant.UPDATE_USER_PASSWORD, methodParams,
				new BaseTypeReference<Result<Integer>>() {
				});

		// boolean checkResult = userPasswordService.checkPassword(
		// userReqDto.getOldPassword());
		// if(!checkResult){
		// return
		// Result.newFailureResult(CodeConstant.CODE_1200015,"旧密码错误!",null);
		// }
		// Result<Integer> result =
		// userPasswordService.updateUserPassword(userReqDto);
		return result;
	}

	*//**
	 * 登录
	 * 
	 * @return
	 *//*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "登录", notes = "登录")
	public Result<UserDetailResDto> login(@ModelAttribute @Validated UserloginReqDto loginReqDto,
			BindingResult bindingResult) throws BaseException {
		log.info("登录:", loginReqDto);
		// 用户登录
		BaseUserAccount baseUserAccount = userPasswordService.login(loginReqDto);
		if (baseUserAccount == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200016, "用户名和密码错误!", null);
		}

		// 判断用户是否禁用
		if (EnabledEnum.NOT_ENABLED.getValue().equals(baseUserAccount.getIsEnabled())) {
			return Result.newFailureResult(CodeConstant.CODE_1200017, "登录失败，用户没有启用！", null);
		}

		// 获取用户详情
		UserDetailResDto dto = userService.getUserDetail(baseUserAccount.getId());

		// 获取租户名称
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dto.getTenantId());
		Result<TenantDto> result = HttpUtils.get(ScmUrlConstant.GET_TENANT, map,
				new BaseTypeReference<Result<TenantDto>>() {
				});
		dto.setTenantName(result.getResult().getName());
		return Result.newSuccessResult(dto);
	}

	*//**
	 * 退出
	 * 
	 * @return
	 *//*
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ApiOperation(value = "退出", notes = "退出")
	public Result<Integer> logout() {
		log.info("退出:");
		Boolean resutl = userPasswordService.logout();
		if (!resutl) {
			return Result.newFailureResult(CodeConstant.CODE_1200018, "用户不存在!", null);
		}
		return Result.newSuccessResult(1);
	}
}
*/