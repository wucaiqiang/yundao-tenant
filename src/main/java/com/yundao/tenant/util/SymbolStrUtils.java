package com.yundao.tenant.util;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.RegularUtils;
import com.yundao.tenant.constant.SymbolConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * 符号字符串工具类
 *
 * @author jan
 * @create 2017-06-19 AM10:05
 **/
public class SymbolStrUtils {


    public static String doubleToString(Double d) {
        if (d == null) {
            return null;
        }
        String s = d.toString();
        if (s.endsWith(".0")) {
            s = s.substring(0, s.length() - 2);
        }
        return s;
    }


    /**
     * 将以符号分隔的字符串转换为list，默认符号为：,(逗号)
     *
     * @param content 字符串
     * @return 处理后结果
     */
    public static List<String> toList(String content) {
        return toList(SymbolConstant.COMMA, content);
    }

    /**
     * 将list转换为指定符号分隔的字符串，默认符号为：,(逗号)
     *
     * @param contents list
     * @return 处理后的结果
     */
    public static String toStr(List<String> contents) {
        return toStr(SymbolConstant.COMMA, contents);
    }

    /**
     * 将Long类型list转换为指定符号分隔的字符串，默认符号为：,(逗号)
     */
    public static String longToStr(List<Long> ids) {
        String content = "";
        for (Long id : ids) {
            if (id == null)
                continue;
            content += id.toString() + SymbolConstant.COMMA;
        }
        return replaceLastSymbol(content, SymbolConstant.COMMA);
    }

    /**
     * 删除最后一个特定符号
     *
     * @param content 内容
     * @param symbol  特定的符号
     * @return 处理结果
     */
    public static String replaceLastSymbol(String content, String symbol) {
        if (BooleanUtils.isNotBlank(content)) {
            if (content.endsWith(symbol)) {
                content = content.substring(0, content.length() - 1);
            }
        }
        return content;
    }

    /**
     * 将逗号分隔的字符串转换成 Long类型列表
     *
     * @param content 字符串
     */
    public static List<Long> toLong(String content) {
        List<String> strs = toList(content);
        List<Long> ls = new ArrayList<>();
        if (BooleanUtils.isEmpty(strs))
            return ls;
        strs.forEach(m -> ls.add(Long.valueOf(m)));
        return ls;
    }

    /**
     * 将逗号分隔的字符串转换成 Long类型列表，检查是否数字
     *
     * @param content 字符串
     */
    public static List<Long> toLongWithTypeCheck(String content) {
        List<String> strs = toList(content);
        List<Long> ls = new ArrayList<>();
        if (BooleanUtils.isEmpty(strs))
            return ls;
        for (String s : strs) {
            boolean isMatch = RegularUtils.isMatch(s, RegularUtils.Regular.NUMBER);
            if (isMatch)
                ls.add(Long.valueOf(s));
        }
        return ls;
    }

    /**
     * 过滤掉非数字
     */
    public static String filterUnNumeric(String args) {
        List<Long> ids = SymbolStrUtils.toLongWithTypeCheck(args);
        return SymbolStrUtils.longToStr(ids);
    }

    /**
     * 将以符号分隔的字符串转换为list
     *
     * @param SplitSymbol 指定符号
     * @param content     字符串
     * @return 处理后结果
     */
    private static List<String> toList(String SplitSymbol, String content) {
        if (BooleanUtils.isEmpty(content))
            return new ArrayList<>();
        String[] array = content.split(SplitSymbol);
        List<String> list = new ArrayList<>();
        for (String item : array) {
            if (BooleanUtils.isNotEmpty(item))
                list.add(item);
        }
        return list;
    }


    /**
     * 将list转换为指定符号分隔的字符串
     *
     * @param SplitSymbol 指定符号
     * @param contents    list
     * @return 处理后的结果
     */
    private static String toStr(String SplitSymbol, List<String> contents) {
        return String.join(SplitSymbol, contents);
    }

}
