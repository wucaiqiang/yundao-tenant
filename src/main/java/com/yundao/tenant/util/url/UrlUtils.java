package com.yundao.tenant.util.url;

import com.yundao.core.utils.BooleanUtils;

/**
 * url工具
 *
 * @author jan
 * @create 2017-11-07 19:47
 **/
public class UrlUtils {

    /**
     * 转换为小写
     *
     * @param url url地址
     */
    public static String toLowerCase(String url) {
        if (BooleanUtils.isBlank(url))
            return url;
        return url.trim().toLowerCase();
    }

}
