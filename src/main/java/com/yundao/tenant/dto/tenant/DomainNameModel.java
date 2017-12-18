package com.yundao.tenant.dto.tenant;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

public class DomainNameModel extends BaseModel implements Serializable {
    /**
	 * 系统编码
	 */
    private String systemCode;

    /**
	 * 域名链接
	 */
    private String url;

    /**
	 * 状态（1：正常，2：急需续费，3：急需赎回，4：正在转出，5：域名持有者信息修改中，6：未实名认证，7：审核失败，重新实名认证，8：审核中）
	 */
    private Integer status;

    /**
	 * 注册日期
	 */
    private Date registerDate;

    /**
	 * 到期日期
	 */
    private Date expireDate;
    /**
     * 域名类型
     */
    private String platformCode;

    private static final long serialVersionUID = 1L;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}