
package com.yundao.tenant.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.user.UserCardResDto;
import com.yundao.tenant.service.user.UserDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年9月21日 上午11:03:38
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping("/user_detail")
@ResponseBody
@Api("用户详情")
public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;

	@RequestMapping(value = "/update_card_introduce", method = RequestMethod.POST)
	@ApiOperation(value = "修改用户名片", notes = "修改用户名片")
	public Result<Long> updateCardIntroduce(@RequestParam String cardIntroduce) throws Exception {
		return Result.newSuccessResult(userDetailService.updateCardIntroduce(cardIntroduce));
	}

	@RequestMapping(value = "/update_introduce_and_header_bit", method = RequestMethod.POST)
	@ApiOperation(value = "修改用户名片简介与头衔", notes = "修改用户名片简介与头衔")
	public Result<Long> updateCardIntroduceAndHeaderBit(@RequestParam(defaultValue = "") String cardIntroduce,
			@RequestParam(defaultValue = "") String headerBit) throws Exception {
		return Result.newSuccessResult(userDetailService.updateCardIntroduceAndHeaderBit(cardIntroduce,headerBit));
	}

	@RequestMapping(value = "/get_card", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户名片", notes = "获取用户名片")
	public Result<UserCardResDto> getCard() throws Exception {
		return Result.newSuccessResult(userDetailService.doAndGetCardByUserId());
	}

	@RequestMapping(value = "/get_card_by_uuid", method = RequestMethod.GET)
	@ApiOperation(value = "根据理财师uuid获取名片", notes = "根据理财师uuid获取名片")
	public Result<UserCardResDto> getCardByUUID(@RequestParam String uuid) throws Exception {
		return Result.newSuccessResult(userDetailService.getCardByUUID(uuid));
	}
}
