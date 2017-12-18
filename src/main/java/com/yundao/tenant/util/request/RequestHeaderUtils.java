package com.yundao.tenant.util.request;

import com.yundao.core.constant.CommonConstant;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.dto.HeaderUser;

/**
 * 请求头工具类
 *
 * @author jan
 * @create 2017-08-05 PM1:40
 **/
public class RequestHeaderUtils {


    /**
     * 获取请求用户的信息
     *
     * @return 请求用户信息
     */
    public static HeaderUser getUser() {
        return (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
    }

    /**
     * 查找请求用户id
     *
     * @return 请求用户id
     */
    public static Long getUserId() {
        HeaderUser result = getUser();
        return result == null ? 0L : result.getUserId();
    }

    /**
     * 获取租户id
     *
     * @return 租户id
     */
    public static Long getTenantId() {
        HeaderUser result = getUser();
        return getUser() == null ? 0L : result.getTenantId();
    }

}
