package com.yundao.tenant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gjl on 2017/7/19.
 */
public class CamelUtil {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    public static String toline(String param){
        Matcher matcher = humpPattern.matcher(param);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String toSprit(String param){
        Matcher matcher = humpPattern.matcher(param);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "/"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String toCamel(String param){
        param = param.toLowerCase();
        Matcher matcher = linePattern.matcher(param);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(CamelUtil.toline("userName"));
        System.out.println(CamelUtil.toCamel("user_name"));
    }
}
