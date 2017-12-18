
package com.yundao.tenant.service.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.tenant.TenantDto;
import com.yundao.tenant.service.user.TenantService;
import com.yundao.tenant.util.HttpUtils;

/**
 * Function: Reason: Date: 2017年9月21日 下午2:26:55
 * 
 * @author wucq
 * @version
 */
@Service
public class TenantServiceImpl extends AbstractService implements TenantService {
	@Override
	public TenantDto get() throws BaseException {
		Map<String, Object> methodParams = new HashMap<>();
		methodParams.put("id", this.getHeaderTenantId());
		Result<TenantDto> result = HttpUtils.get(ScmUrlConstant.GET_TENANT, methodParams,
				new BaseTypeReference<Result<TenantDto>>() {
				});
		return result.getResult();

	}

}
