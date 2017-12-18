package com.yundao.tenant.model.base.cc;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCcUserAccount extends BaseModel implements Serializable {
    /**
	 * 手机号
	 */
    private String mobile;

    /**
	 * 账号
	 */
    private String userName;

    /**
	 * 密码
	 */
    private String password;

    /**
	 * 账号状态，1：正常使用；2：禁止登陆
	 */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}