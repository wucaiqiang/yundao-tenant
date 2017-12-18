package com.yundao.tenant.util;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Bean工具类
 *
 * @author jan
 * @create 2017-06-26 AM8:34
 **/
public class LocalBeanUtils {

    private static Log log = LogFactory.getLog(LocalBeanUtils.class);

    /**
     * Bean转换为Map
     *
     * @param obj Bean实体
     * @return Map
     */
    public static Map<String, Object> toMap(Object obj) throws BaseException {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            log.error("LocalBeanUtils.toMap 异常：%s", e.toString());
            throw new BaseException(CommonCode.COMMON_1007, "LocalBeanUtils.toMap 异常：" + e.toString());
        }
        return map;
    }

    /**
     * 复制集合
     *
     * @param <E>              目标类型
     * @param source           源数据集合
     * @param destinationClass 目标类型
     * @return 集合
     * @throws BaseException 异常信息
     */
    public static <E> List<E> copyPropertiesList(List<?> source, Class<E> destinationClass) throws BaseException {
        if (source.size() == 0) return Collections.emptyList();
        List<E> res = new ArrayList<>(source.size());
        try {
            for (Object o : source) {
                E e = destinationClass.newInstance();
                BeanUtils.copyProperties(e, o);
                res.add(e);
            }
        } catch (Exception e) {
            log.error("LocalBeanUtils.copyPropertiesList 异常：%s", e.toString());
            throw new BaseException(CommonCode.COMMON_1007, "LocalBeanUtils.copyPropertiesList 异常：" + e.toString());
        }
        return res;
    }
}
