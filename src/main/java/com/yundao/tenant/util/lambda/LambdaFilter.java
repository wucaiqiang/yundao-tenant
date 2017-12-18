package com.yundao.tenant.util.lambda;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lambda表达式过滤工具类
 *
 * @author jan
 * @create 2017-06-15 PM7:56
 **/
public class LambdaFilter {


    /**
     * 获取集合中符合条件的一条记录，如果出现多条，返回第一条，如果没有符合条件的，返回NULL
     *
     * @param list      数据集合
     * @param condition 条件
     * @return 第一条符合条件的记录或 NULL
     */
    public static <T> T firstOrDefault(List<T> list, Predicate<T> condition) {
        Stream<T> streamResult = list.stream().filter(condition);
        Optional<T> optionalResult = streamResult.findFirst();
        return optionalResult.orElse(null);
    }

    /**
     * 获取符合条件的集合
     *
     * @param list      数据集合
     * @param condition 条件
     * @return 符合条件的集合，如果没有任何数据，返回空集合
     */
    public static <T> List<T> toList(List<T> list, Predicate<T> condition) {
        return list.stream().filter(condition).collect(Collectors.toList());
    }

    /**
     * 去重
     *
     * @param list 数据集合
     */
    public static <T> List<T> distinct(List<T> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

}
