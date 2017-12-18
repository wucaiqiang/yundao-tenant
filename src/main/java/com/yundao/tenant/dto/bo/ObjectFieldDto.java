package com.yundao.tenant.dto.bo;

import com.yundao.tenant.model.base.BaseObjectField;

/**
 * 业务对象字段dto
 *
 * @author jan
 * @create 2017-07-13 AM8:44
 **/
public class ObjectFieldDto extends BaseObjectField {

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段编码
     */
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
