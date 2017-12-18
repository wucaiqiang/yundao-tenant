package com.yundao.tenant.dto.user;

/**
 * 用户下拉列表
 * 
 * @author 欧阳利
 * 2017年7月7日
 */
public class UserOptionResDto {
	/**
	 * 用户id
	 */
    private Long id;
    
    /**
     * 用户姓名
     */
    private String realName;
    
    /**
     * 手机号码
     */
    private String mobile;

	public String getMobile() {
	
		return mobile;
	}

	public void setMobile(String mobile) {
	
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
    
}
