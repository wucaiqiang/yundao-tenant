package com.yundao.tenant.service.sms;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseRole;

import java.util.List;

/**
 * 缓存测试
 *
 * @author jan
 * @create 2017-08-25 AM7:49
 **/
public interface SmsCacheService {

    List<BaseRole> gets(Long tenantId)throws BaseException;

}
