package com.yundao.tenant.service.user.impl;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.user.password.UserUpdatePasswordReqDto;
import com.yundao.tenant.mapper.base.BaseUserAccountMapper;
import com.yundao.tenant.model.base.BaseUserAccount;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户密码管理
 *
 * @author 欧阳利 2017年6月26日
 */
@Service
public class LoginServiceImpl extends AbstractService implements LoginService {
    /**
     * 用户账户管理
     */
    @Autowired
    BaseUserAccountMapper baseUserAccountMapper;

    /**
     * 修改用户密码
     *
     * @param userReqDto
     * @return
     */
    public Result<Integer> updateUserPassword(UserUpdatePasswordReqDto userReqDto) {
        BaseUserAccount record = new BaseUserAccount();
        record.setId(this.getHeaderUserId());
        record.setPassword(userReqDto.getNewPassword());
        record.setUpdateDate(new Date());
        record.setUpdateUserId(this.getHeaderUserId());
        record.setIsDelete(0);
        Integer count = baseUserAccountMapper.updateByPrimaryKeySelective(record);
        return Result.newSuccessResult(count);
    }

}
