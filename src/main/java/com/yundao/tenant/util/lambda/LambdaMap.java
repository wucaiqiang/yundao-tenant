package com.yundao.tenant.util.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Lambda表达式映射工具类
 *
 * @author jan
 * @create 2017-07-02 PM12:53
 **/
public class LambdaMap {

    /**
     * 将 bean列表中 转换 单个字段列表
     * 如：获取List<userModel> 中 List<id>
     *
     * @param list      bean list
     * @param condition 条件
     * @return 返回结果
     */
    public static <T, V> List<V> toSingleList(List<T> list, Function<T, V> condition) {
        return list.stream().map(condition).collect(Collectors.toList());
    }
}
