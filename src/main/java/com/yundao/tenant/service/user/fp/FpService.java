package com.yundao.tenant.service.user.fp;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.user.UserOptionResDto;

import java.util.List;

/**
 * 理财师服务接口
 *
 * @author jan
 * @create 2017-08-15 PM3:44
 **/
public interface FpService {

    /**
     * 根据姓名查询
     *
     * @param name 理财师姓名
     */
    Result<List<UserOptionResDto>> getsByName(String name) throws BaseException;
}

