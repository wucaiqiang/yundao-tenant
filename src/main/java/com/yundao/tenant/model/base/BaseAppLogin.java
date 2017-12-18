package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseAppLogin extends BaseModel implements Serializable {
    /**
	 * 登录id
	 */
    private Long loginId;

    /**
	 * 网络类型（WIFI）
	 */
    private String networkType;

    /**
	 * 设备id
	 */
    private String deviceId;

    /**
	 * 设备名称（iPhone 6s）
	 */
    private String deviceName;

    /**
	 * 设备型号（iPhone）
	 */
    private String deviceModel;

    /**
	 * 厂商（iPhone）
	 */
    private String vendor;

    /**
	 * 操作系统（iPhone OS）
	 */
    private String operatingSystem;

    /**
	 * app版本号
	 */
    private String appVersion;

    /**
	 * 设备分辨率
	 */
    private String deviceResolution;

    /**
	 * 国际移动设备身份
	 */
    private String imei;

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

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceResolution() {
        return deviceResolution;
    }

    public void setDeviceResolution(String deviceResolution) {
        this.deviceResolution = deviceResolution;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}