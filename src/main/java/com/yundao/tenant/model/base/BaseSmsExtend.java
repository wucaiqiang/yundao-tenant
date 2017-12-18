package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsExtend extends BaseModel implements Serializable {
    /**
	 * 模版CODE
	 */
    private String templateCode;

    /**
	 * 角色id，多个逗号分隔
	 */
    private String roles;

    /**
	 * 用户id，多个逗号分隔
	 */
    private String users;

    /**
	 * 需要扩展的手机号码，多个逗号分隔
	 */
    private String mobile;

    /**
	 * 扩展类型，1：追加；2：过滤
	 */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}