package com.yundao.tenant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gjl on 2017/8/9.
 */
public class StringUtil {
    public static boolean isNumber(String number){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
