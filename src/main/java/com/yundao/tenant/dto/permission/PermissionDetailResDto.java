package com.yundao.tenant.dto.permission;

/**
 * @author jan
 * @create 2017-08-06 PM4:41
 **/
public class PermissionDetailResDto {

    /**
     * 数据拥有者id
     */
    private Long ownerId;

    /**
     * 是否通过权限校验
     */
    private Boolean isPass;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }
}
