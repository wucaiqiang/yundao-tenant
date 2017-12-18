package com.yundao.tenant.util.msg;

import com.yundao.core.utils.BooleanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gjl on 2017/8/15.
 */
public class MsgUtil {
    private static final List<Class<?>> PrimitiveClasses = new ArrayList<Class<?>>() {
        {
            this.add(Long.class);
            this.add(Double.class);
            this.add(Integer.class);
            this.add(String.class);
            this.add(Boolean.class);
            this.add(Date.class);
            this.add(java.sql.Date.class);
            this.add(java.util.List.class);
        }
    };

    public static Boolean isPrimitiveClass(Object obj){
        Class<?> cls = obj.getClass();
        return cls.isPrimitive() || PrimitiveClasses.contains(cls);
    }
}
