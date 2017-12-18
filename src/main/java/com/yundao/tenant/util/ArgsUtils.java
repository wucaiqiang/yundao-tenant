package com.yundao.tenant.util;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.exception.BaseRuntimeException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数工具类
 *
 * @author jan
 * @create 2017-07-01 PM3:40
 **/
public class ArgsUtils {

    private static Log log = LogFactory.getLog(ArgsUtils.class);

    /**
     * Bean转换为Map
     *
     * @param obj Bean实体
     * @return Map
     */
    public static Map<String, Object> toMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性,paginationSupport分页属性
                if (!key.equals("class") && !key.equals("paginationSupport")) {
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if (value != null && StringUtils.isNotBlank(String.valueOf(value))) {
                        if (value instanceof Date) {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                            String dataStr = format.format(value);
                            map.put(key, dataStr);
                            continue;
                        }
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            throw new BaseRuntimeException(CommonCode.COMMON_1007, e);
        }

        return map;
    }
}
