

package com.yundao.tenant.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月31日 上午10:54:39 
 * @author   wucq
 * @version   
 */
public class ValidateUtils{
	public static final String REGEX_IS_MOBILE = "(?is)(^[0-9]\\d{6,20}$)";
	
	public static final String NUMBER="^\\d+$";//非负整数（正整数   +   0）
	/**
	 * 校验qq
	 * veriyQQ:
	 * @author: wucq
	 * @param qq
	 * @return
	 * @description:
	 */
	public static boolean veriyQQ(String qq) {
		Pattern p = null;
		Matcher m = null;

		p = Pattern.compile(NUMBER);
		m = p.matcher(qq);

		return m.matches();
	}

}

