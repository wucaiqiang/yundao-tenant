package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseBrowserLogin extends BaseModel implements Serializable {
    /**
	 * 登录id
	 */
    private Long loginId;

    /**
	 * 浏览器头部代理信息
	 */
    private String userAgent;

    /**
	 * 浏览器类型（Internet Explorer 6）
	 */
    private String browserType;

    /**
	 * 设备类型（Computer）
	 */
    private String deviceType;

    /**
	 * 操作系统（Windows XP）
	 */
    private String operatingSystem;

    /**
	 * 系统编码
	 */
    private String systemCode;

    private static final long serialVersionUID = 1L;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}