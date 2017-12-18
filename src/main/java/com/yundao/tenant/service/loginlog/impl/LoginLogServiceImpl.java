package com.yundao.tenant.service.loginlog.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.dto.login.LoginLogAddReqDto;
import com.yundao.tenant.mapper.base.BaseLoginLogMapper;
import com.yundao.tenant.model.base.BaseLoginLog;
import com.yundao.tenant.service.loginlog.LoginLogService;
import com.yundao.tenant.util.HeaderUserThreadLocal;

/**
 * Created by gjl on 2017/11/30.
 */
@Service
public class LoginLogServiceImpl extends AbstractService implements LoginLogService {

	@Autowired
	private BaseLoginLogMapper baseLoginLogMapper;

	@Override
	public Result<Long> add(LoginLogAddReqDto dto) {
		HeaderUser user = HeaderUserThreadLocal.get();
		BaseLoginLog model = new BaseLoginLog();
		BeanUtils.copyProperties(dto, model);
		Date date = new Date();
		model.setCreateDate(date);
		model.setCreateUserId(user.getUserId());
		model.setTenantId(user.getTenantId());
		baseLoginLogMapper.insertSelective(model);
		return Result.newSuccessResult(model.getId());
	}
}
