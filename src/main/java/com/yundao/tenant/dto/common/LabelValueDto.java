package com.yundao.tenant.dto.common;

import java.io.Serializable;

/**
 * 文本值dto
 *
 * @author jan
 * @create 2017-07-14 PM8:41
 **/
public class LabelValueDto implements Serializable {

    static final long serialVersionUID = 1L;

    /**
     * 文本
     */
    private String label;

    /**
     * 值
     */
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
