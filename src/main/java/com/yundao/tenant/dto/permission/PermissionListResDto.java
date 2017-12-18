package com.yundao.tenant.dto.permission;

import java.util.ArrayList;
import java.util.List;

/**
 * 多个权限校验返回结果
 *
 * @author jan
 * @create 2017-08-05 PM10:21
 **/
public class PermissionListResDto {

    private String dataObjectCode;

    private List<PermissionDetailResDto> permissions;

    public String getDataObjectCode() {
        return dataObjectCode;
    }

    public void setDataObjectCode(String dataObjectCode) {
        this.dataObjectCode = dataObjectCode;
    }

    public List<PermissionDetailResDto> getPermissions() {
        if (this.permissions == null)
            this.permissions = new ArrayList<>();
        return permissions;
    }

    public void setPermissions(List<PermissionDetailResDto> permissions) {
        this.permissions = permissions;
    }
}
