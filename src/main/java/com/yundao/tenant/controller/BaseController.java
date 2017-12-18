package com.yundao.tenant.controller;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;

/**
 * 控制器基类
 *
 * @author jan
 * @create 2017-07-20 PM3:42
 **/
public class BaseController {

    protected void checkIdNotNull(Long id) throws BaseException {
        if (id == null)
            throw new BaseException(CodeConstant.CODE_1200000);
    }

    protected void checkRoleIdNotNull(Long roldId) throws BaseException {
        if (roldId == null)
            throw new BaseException(CodeConstant.CODE_1200007);
    }

    protected void checkBoCodeNotEmpty(String boCode) throws BaseException {
        if (BooleanUtils.isEmpty(boCode))
            throw new BaseException(CodeConstant.CODE_1200030);
    }
}
