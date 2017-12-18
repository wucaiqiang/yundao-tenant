package com.yundao.tenant.dto.area;

import java.io.Serializable;

/**
 * @author jan
 * @create 2017-08-09 PM3:31
 **/
public class RegionDto implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 文本
     */
    private String label;

    /**
     * 值
     */
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
