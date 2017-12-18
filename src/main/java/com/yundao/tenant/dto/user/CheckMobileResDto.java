package com.yundao.tenant.dto.user;

/**
 * 检查手机号码存在返回结果
 * 
 * @author 欧阳利
 * 2017年7月13日
 */
public class CheckMobileResDto {
	/**
	 * 当前租户是否存在
	 */
    private Boolean tenantExist;
    
    /**
     * 公开库是否存在
     */
    private Boolean commonExist;

	public Boolean getTenantExist() {
		return tenantExist;
	}

	public void setTenantExist(Boolean tenantExist) {
		this.tenantExist = tenantExist;
	}

	public Boolean getCommonExist() {
		return commonExist;
	}

	public void setCommonExist(Boolean commonExist) {
		this.commonExist = commonExist;
	}
    
}
