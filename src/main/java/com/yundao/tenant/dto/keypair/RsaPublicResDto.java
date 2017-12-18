

package com.yundao.tenant.dto.keypair;

import java.io.Serializable;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年7月17日 下午7:46:13 
 * @author   wucq
 * @version   
 */
public class RsaPublicResDto implements Serializable{
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 公钥系数
	 */
	private String modulus;
	
	/**
	 * 公钥指数
	 */
	private String exponent;
	
	/**
	 * 登录需要的随机数
	 */
	private String random;

	public String getModulus() {
	
		return modulus;
	}

	public void setModulus(String modulus) {
	
		this.modulus = modulus;
	}

	public String getExponent() {
	
		return exponent;
	}

	public void setExponent(String exponent) {
	
		this.exponent = exponent;
	}

	public String getRandom() {
	
		return random;
	}

	public void setRandom(String random) {
	
		this.random = random;
	}
	
}

