package com.yundao.tenant.service.user.fp.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.user.UserOptionResDto;
import com.yundao.tenant.dto.user.UserSearchReqDto;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.user.fp.FpService;

/**
 * 理财师服务实现类
 *
 * @author jan
 * @create 2017-08-15 PM3:45
 **/
@Service
public class FpServiceImpl implements FpService {

	private static Log log = LogFactory.getLog(FpServiceImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public Result<List<UserOptionResDto>> getsByName(String name) throws BaseException {
		log.begin(name);
		if (BooleanUtils.isEmpty(name))
			return Result.newSuccessResult(new ArrayList<>(1));
		UserSearchReqDto reqDto = new UserSearchReqDto();
		reqDto.setRealName(name);
		Result<List<UserOptionResDto>> fpList = userService.getUsersByRealName(reqDto);
		log.end();
		return fpList;
	}
}
