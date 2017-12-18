package com.yundao.tenant.dto.field;

import java.io.Serializable;

/**
 * 数据对象字段
 *
 * @author jan
 * @create 2017-07-13 PM2:42
 **/
public class DataObjectFieldDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字段id
     */
    private Long id;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段编码
     */
    private String code;

    /**
     * 数据对象id
     */
    private Long dataObjectId;

    /**
     * 数据对象编码
     */
    private String dataObjectCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getDataObjectId() {
        return dataObjectId;
    }

    public void setDataObjectId(Long dataObjectId) {
        this.dataObjectId = dataObjectId;
    }

    public String getDataObjectCode() {
        return dataObjectCode;
    }

    public void setDataObjectCode(String dataObjectCode) {
        this.dataObjectCode = dataObjectCode;
    }
}
