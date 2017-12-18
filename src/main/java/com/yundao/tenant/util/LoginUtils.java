package com.yundao.tenant.util;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;

import com.yundao.core.utils.RegularUtils;  

/**
 * 登录工具类
 * 
 * @author 欧阳利
 * 2017年6月26日
 */
public class LoginUtils {
	
	/**
	 * 判断是否是手机号码
	 * @param mobile
	 * @return
	 */
    public static boolean isMobile(String mobile){
        Pattern p = Pattern.compile(RegularUtils.Regular.MOBILE);  
        Matcher m = p.matcher(mobile);  
        return m.matches();  
    }
    
    /**
     * 判断是否是用户名
     * @param userName
     * @return
     */
    public static boolean isUserName(String userName){
    	if(isMobile(userName) || isEmail(userName)){
    		return false;
    	}
    	return true;
    }
    
    /**
     * 判断是否是邮箱
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
    	Pattern p = Pattern.compile(RegularUtils.Regular.EMAIL);
    	Matcher m = p.matcher(email);
    	return m.matches();
    }
}
