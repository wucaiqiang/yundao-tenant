package com.yundao.tenant.dto.common;

import com.yundao.core.utils.ConfigUtils;

/**
 * @author jan
 * @create 2017-07-13 AM11:12
 **/
public class FailListDto {


    /**
     * 编码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 对象的id
     */
    private Long id;

    /**
     * 对象的名称
     */
    private String name;

    /**
     * 数据的拥有者id
     */
    private Long ownerId;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.message = ConfigUtils.getValue(Integer.valueOf(this.code).toString());
    }

    public String getMessage() {
        return message;
    }

    /**
     * 已在setCode自动设置了message
     *
     * @param message
     */
    private void setMessage(String message) {
        this.message = message;
    }

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

    public FailListDto(int code, String message, Long id, String name) {
        this.code = code;
        this.message = message;
        this.id = id;
        this.name = name;
    }

    public FailListDto() {
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
