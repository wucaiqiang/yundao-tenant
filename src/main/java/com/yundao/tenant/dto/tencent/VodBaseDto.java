
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:28:58
 * 
 * @author wucq
 * @version
 */
public class VodBaseDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 错误码, 0: 成功, 其他值: 失败
	 */
	private Integer code;
	/**
	 * code编码描述
	 */
	private String codeDesc;
	/**
	 * 错误信息
	 */
	private String message;

	public Integer getCode() {

		return code;
	}

	public void setCode(Integer code) {

		this.code = code;
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public String getCodeDesc() {
	
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
	
		this.codeDesc = codeDesc;
	}

}
