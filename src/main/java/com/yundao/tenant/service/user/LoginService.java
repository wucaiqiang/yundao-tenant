package com.yundao.tenant.service.user;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.user.password.UserUpdatePasswordReqDto;

/**
 * 用户密码管理
 *
 * @author 欧阳利
 *         2017年6月22日
 */
public interface LoginService {

    /**
     * 修改用户密码
     *
     * @param userReqDto
     * @return
     */
    Result<Integer> updateUserPassword(UserUpdatePasswordReqDto userReqDto);

}
