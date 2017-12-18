package com.yundao.tenant.mapper.cc.ccuserdetail;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.cc.ccuserdetail.CcUserInfoDto;
import org.apache.ibatis.annotations.Param;

public interface CcUserDetailMapper {

    /**
     * 获取理财用户信息
     */
    CcUserInfoDto selectUserInfo(@Param("userId") Long userId) throws BaseException;

}
