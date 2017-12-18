package com.yundao.tenant.dto.bo;

import com.yundao.tenant.model.base.BaseObjectField;

/**
 * @author jan
 * @create 2017-07-24 PM9:00
 **/
public class ObjectFieldListDto extends BaseObjectField {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
