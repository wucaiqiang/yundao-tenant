package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseUserAccount extends BaseModel implements Serializable {
    /**
	 * 用户名
	 */
    private String username;

    /**
	 * 手机号
	 */
    private String mobile;

    /**
	 * 邮箱
	 */
    private String email;

    /**
	 * 密码
	 */
    private String password;

    /**
	 * 是否锁定，0：否，1：是
	 */
    private Integer isLock;

    /**
	 * 是否系统(0:否，1:是)
	 */
    private Integer isSystem;

    /**
	 * 最后一次停用时间
	 */
    private Date enabledDate;

    private static final long serialVersionUID = 1L;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public Date getEnabledDate() {
        return enabledDate;
    }

    public void setEnabledDate(Date enabledDate) {
        this.enabledDate = enabledDate;
    }
}