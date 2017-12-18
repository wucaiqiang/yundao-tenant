
package com.yundao.tenant.dto.sale.declaration;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class DeclarationSearchReqDto implements Serializable{

    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "产品名称或客户名称")
    private String keyword;
	
    private Long userId;

	public String getKeyword() {
	
		return keyword;
	}

	public void setKeyword(String keyword) {
	
		this.keyword = keyword;
	}

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}
    
}
