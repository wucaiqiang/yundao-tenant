
package com.yundao.tenant.util;

import org.apache.commons.lang3.StringUtils;

import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DesUtils;
import com.yundao.tenant.model.customer.BaseContact;
import com.yundao.tenant.model.customer.MobileEmail;
import com.yundao.tenant.model.customer.WechatQQ;

/**
 * Function: Reason: Date: 2017年8月10日 上午9:49:45
 * 
 * @author wucq
 * @version
 */
public class BaseContactUtils {
	public static Log logger = LogFactory.getLog(BaseContactUtils.class);

	/**
	 * 加密并返回加密结果
	 * @param msg
	 * @return
	 */
	public static String encrypt(String msg){
		try {
			if (!BooleanUtils.isBlank(msg)) {
				return  DesUtils.encrypt(msg);
			}
		} catch (Exception e) {
			logger.error("加密值出现异常，异常信息为：", e);
		}
		return null;
	}
	
	
	/**
	 * 基本联系信息加密 encrypt:
	 * 
	 * @author: wucq
	 * @param reqDto
	 * @throws Exception
	 * @description:
	 */
	public static void encrypt(BaseContact reqDto){
		try {
			if (BooleanUtils.isNotEmpty(reqDto.getMobile())) {
				reqDto.setMobile(DesUtils.encrypt(reqDto.getMobile()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getWechat())) {
				reqDto.setWechat(DesUtils.encrypt(reqDto.getWechat()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getQq())) {
				reqDto.setQq(DesUtils.encrypt(reqDto.getQq()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getEmail())) {
				reqDto.setEmail(DesUtils.encrypt(reqDto.getEmail()));
			}
		} catch (Exception e) {
			logger.error("加密值出现异常，异常信息为：", e);
		}
	}

	public static void encrypt(MobileEmail reqDto){
		try {
			if (BooleanUtils.isNotEmpty(reqDto.getMobile())) {
				reqDto.setMobile(DesUtils.encrypt(reqDto.getMobile()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getEmail())) {
				reqDto.setEmail(DesUtils.encrypt(reqDto.getEmail()));
			}
		} catch (Exception e) {
			logger.error("加密值出现异常，异常信息为：", e);
		}
	}

	public static void encrypt(WechatQQ reqDto)  {
		try {
			if (BooleanUtils.isNotEmpty(reqDto.getWechat())) {
				reqDto.setWechat(DesUtils.encrypt(reqDto.getWechat()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getQq())) {
				reqDto.setQq(DesUtils.encrypt(reqDto.getQq()));
			}
		} catch (Exception e) {
			logger.error("加密值出现异常，异常信息为：", e);
		}
	}

	public static void decrypt(BaseContact reqDto) {
		try {
			if (BooleanUtils.isNotEmpty(reqDto.getMobile())) {
				reqDto.setMobile(DesUtils.decrypt(reqDto.getMobile()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getWechat())) {
				reqDto.setWechat(DesUtils.decrypt(reqDto.getWechat()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getQq())) {
				reqDto.setQq(DesUtils.decrypt(reqDto.getQq()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getEmail())) {
				reqDto.setEmail(DesUtils.decrypt(reqDto.getEmail()));
			}
		} catch (Exception e) {
			logger.error("解密值出现异常，异常信息为：", e);
		}
	}

	public static void decrypt(MobileEmail reqDto) {
		try {
			if (BooleanUtils.isNotEmpty(reqDto.getMobile())) {
				reqDto.setMobile(DesUtils.decrypt(reqDto.getMobile()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getEmail())) {
				reqDto.setEmail(DesUtils.decrypt(reqDto.getEmail()));
			}
		} catch (Exception e) {
			logger.error("解密值出现异常，异常信息为：", e);
		}
	}

	public static void decrypt(WechatQQ reqDto) {
		try {
			if (BooleanUtils.isNotEmpty(reqDto.getWechat())) {
				reqDto.setWechat(DesUtils.decrypt(reqDto.getWechat()));
			}
			if (BooleanUtils.isNotEmpty(reqDto.getQq())) {
				reqDto.setQq(DesUtils.decrypt(reqDto.getQq()));
			}
		} catch (Exception e) {
			logger.error("解密值出现异常，异常信息为：", e);
		}
	}

	
	public static String decrypt(String encryptStr) {
		try {
			if (StringUtils.isNotBlank(encryptStr)) {
				return DesUtils.decrypt(encryptStr);
			}
		} catch (Exception e) {
			logger.error("解密值出现异常，异常信息为：", e);
		}
		return "";
	}
}
