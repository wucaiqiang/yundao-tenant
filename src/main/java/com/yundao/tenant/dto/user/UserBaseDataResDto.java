package com.yundao.tenant.dto.user;

import java.io.Serializable;

/**
 * 请求头
 *
 * @author jan
 * @create 2017-06-30 PM6:12
 **/

public class UserBaseDataResDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long headerUserId;

    /**
     * 真实姓名
     */
    private String headerRealName;

    /**
     * 租户id
     */
    private Long headerTenantId;
    /**
     * ticket
     */
    private String ticket;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 租户code编码
     */
    private String tenantCode;
    /**
     * 手机号码
     */
    private String mobile;


    public Long getHeaderUserId() {
        return headerUserId;
    }

    public void setHeaderUserId(Long headerUserId) {
        this.headerUserId = headerUserId;
    }

    public String getHeaderRealName() {
        return headerRealName;
    }

    public void setHeaderRealName(String headerRealName) {
        this.headerRealName = headerRealName;
    }

    public Long getHeaderTenantId() {
        return headerTenantId;
    }

    public void setHeaderTenantId(Long headerTenantId) {
        this.headerTenantId = headerTenantId;
    }

	public String getTicket() {
	
		return ticket;
	}

	public void setTicket(String ticket) {
	
		this.ticket = ticket;
	}

	public String getTenantId() {
	
		return tenantId;
	}

	public void setTenantId(String tenantId) {
	
		this.tenantId = tenantId;
	}

	public String getTenantCode() {
	
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
	
		this.tenantCode = tenantCode;
	}

	public String getMobile() {
	
		return mobile;
	}

	public void setMobile(String mobile) {
	
		this.mobile = mobile;
	}
    
}