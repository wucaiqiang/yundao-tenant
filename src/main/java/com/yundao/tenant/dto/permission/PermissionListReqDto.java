package com.yundao.tenant.dto.permission;

import java.util.List;

/**
 * 多个权限校验请求结果
 *
 * @author jan
 * @create 2017-08-05 PM10:21
 **/
public class PermissionListReqDto {

    private String dataObjectCode;

    private List<Long> ownerIds;

    public String getDataObjectCode() {
        return dataObjectCode;
    }

    public void setDataObjectCode(String dataObjectCode) {
        this.dataObjectCode = dataObjectCode;
    }

    public List<Long> getOwnerIds() {
        return ownerIds;
    }

    public void setOwnerIds(List<Long> ownerIds) {
        this.ownerIds = ownerIds;
    }
}
