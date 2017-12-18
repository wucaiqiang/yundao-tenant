package com.yundao.tenant.dto.resource;

import com.yundao.tenant.enums.resource.AuthResourceTypeEnum;

/**
 * 鉴权结果数据dto
 *
 * @author jan
 * @create 2017-11-07 20:22
 **/
public class AuthResultDto {

    /**
     * 鉴权资源类型，值参照枚举 {@link AuthResourceTypeEnum}
     */
    private Integer authResourceType;

    /**
     * 是否授权
     */
    private Boolean permission;

    /**
     * 请求用户id
     */
    private Long userId;

    /**
     * 请求url
     */
    private String requestUrl;

    /**
     * 编码
     */
    private String code;

    public Integer getAuthResourceType() {
        return authResourceType;
    }

    public void setAuthResourceType(Integer authResourceType) {
        this.authResourceType = authResourceType;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
