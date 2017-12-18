package com.yundao.tenant.dto.resource;

public class UserResDto {

    /**
     * 资源id
     */
    private Long userId;

    /**
     * 编码
     */
    private String resCode;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

}
