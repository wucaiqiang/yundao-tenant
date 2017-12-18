package com.yundao.tenant.model.base.cc;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCcLoginDetail extends BaseModel implements Serializable {
    /**
	 * 登录id
	 */
    private Long loginId;

    /**
	 * 操作系统名称
	 */
    private String osName;

    /**
	 * 设备类型
	 */
    private String deviceType;

    /**
	 * 设备名称
	 */
    private String deviceName;

    /**
	 * 分辨率
	 */
    private String resolution;

    /**
	 * 终端信息
	 */
    private String userAgent;

    /**
	 * 浏览器
	 */
    private String browser;

    /**
	 * 备注
	 */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}