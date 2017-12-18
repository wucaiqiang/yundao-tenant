package com.yundao.tenant.service.loginlog;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.login.LoginLogAddReqDto;

/**
 * Created by gjl on 2017/11/30.
 */
public interface LoginLogService {
    /**
     * 新增
     * @param dto
     * @return
     */
    Result<Long> add(LoginLogAddReqDto dto);
}
