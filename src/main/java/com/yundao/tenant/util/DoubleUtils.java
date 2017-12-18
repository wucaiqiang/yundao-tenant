package com.yundao.tenant.util;

import java.text.DecimalFormat;

/**
 * 双精度数字工具类
 *
 * @author jan
 * @create 2017-09-23 PM1:07
 **/
public class DoubleUtils {

    /**
     * 完整数字字符串形式
     */
    public static String toWholeString(Double d) {
        if (d == null)
            return null;
        DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
        return decimalFormat.format(d);
    }

}
