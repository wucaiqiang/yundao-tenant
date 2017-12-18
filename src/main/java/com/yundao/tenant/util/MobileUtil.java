package com.yundao.tenant.util;

import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MobileUtil extends AbstractService {

	private static Log log = LogFactory.getLog(MobileUtil.class);

	// 正则表达式,抽取手机归属地
	public static final String REGEX_GET_MOBILE = "(?is)(<tr[^>]+>[\\s]*<td[^>]+>[\\s]*卡号归属地[\\s]*</td>[\\s]*<td[^>]+>([^<]+)</td>[\\s]*</tr>)"; // 2:from
	// 正则表达式,审核要获取手机11位,1开关
	public static final String REGEX_IS_MOBILE = "(?is)(^[1]\\d{10}$)";

	/**
	 * 验证手机号
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static boolean veriyMobile(String mobileNumber) {
		if (org.apache.commons.lang3.StringUtils.isBlank(mobileNumber)) {
			return false;
		}
		Pattern p = null;
		Matcher m = null;

		p = Pattern.compile(REGEX_IS_MOBILE);
		m = p.matcher(mobileNumber);

		return m.matches();
	}

	public static String encrypt(String mobile) {
		if (StringUtils.isEmpty(mobile)) {
			return mobile;
		}
		int len = mobile.length();
		if (len > 7) {
			return mobile.substring(0, mobile.length() - (mobile.substring(3)).length()) + "****" + mobile.substring(7);
		}
		return mobile;
	}
	public static void main(String[] args)throws Exception{
		System.out.println(MobileUtil.veriyMobile("13699791518"));
	}
}
