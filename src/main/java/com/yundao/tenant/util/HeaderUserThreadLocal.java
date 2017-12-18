package com.yundao.tenant.util;

import com.yundao.core.dto.HeaderUser;

/**
 * 当前线程 设置或获取 头部用户信息
 *
 * @author jan
 * @create 2017-09-22 PM7:14
 **/
public class HeaderUserThreadLocal {

    private static final ThreadLocal threadHeaderUser = new ThreadLocal();

    public static void set(HeaderUser user) {
        threadHeaderUser.set(user);
    }

    public static HeaderUser get() {
        Object obj = threadHeaderUser.get();
        if (obj == null)
            return null;
        return (HeaderUser) obj;
    }

}
