package com.yundao.tenant.util;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.constant.code.CodeConstant;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gjl on 2017/8/16.
 */
public class DateUtil {

    private static Log log = LogFactory.getLog(DateUtil.class);

    
    /**
     * 上个月第一天
     */
    public static String getUpperMonthStartDay(Date date){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.MONTH, -1);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	return DateUtils.format(calendar.getTime(),DateUtils.YYYY_MM_DD);
    }
    
    /**
     * 本月最后一天
     */
    public static String getUpperMonthLastDay(Date date){
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.add(Calendar.DAY_OF_MONTH, -1);
    	return DateUtils.format(calendar.getTime(),DateUtils.YYYY_MM_DD);
    }
    
    
    /**
     * 本月第一天
     */
    public static String getMonthStartDay(Date date){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	return DateUtils.format(calendar.getTime(),DateUtils.YYYY_MM_DD);
    }
    
    /**
     * 本月最后一天
     */
    public static String getMonthLastDay(Date date){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.MONTH, 1);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.add(Calendar.DAY_OF_MONTH, -1);
    	return DateUtils.format(calendar.getTime(),DateUtils.YYYY_MM_DD);
    }
    

    public static List<String> getMonthList(int month){
    	List<String> list = new ArrayList<String>();
    	for(int i = month;i<=0; i++){
    		list.add(getMonth(i));
    	}
    	return list;
    }
    
    
    public static String getMonth(int month){
   	 Calendar cal_1=Calendar.getInstance();//获取当前日期
     cal_1.add(Calendar.MONTH,month);
     Date date = cal_1.getTime();
     return DateUtils.format(date,"yyyy-MM");
    }

    public static List<String> getMonthList(int month,int startMonth) {
        List<String> list = new ArrayList<String>();
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, startMonth);
        Date date = cal_1.getTime();
        for (int i = month; i <= 0; i++) {
            list.add(getMonth(i,date));
        }
        return list;
    }


    public static String getMonth(int month,Date date) {
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.setTime(date);
        cal_1.add(Calendar.MONTH, month);
        Date date1 = cal_1.getTime();
        return DateUtils.format(date1, "yyyy-MM");
    }
    /**
     * 把日期往后增加天.整数往后推,负数往前移动
     *
     * @param date
     * @param day
     */
    public static Date addDay(Date date, Integer day) {
        return addTime(date, Calendar.DATE, day);
    }

    /**
     * 从当前时间增加分钟数
     *
     * @param amount 需要增加的分钟数
     */
    public static Date addMinute(Integer amount) {
        return addTime(new Date(), Calendar.MINUTE, amount);
    }


    /**
     * 将字符串格式的日期，转换为精确到分钟的格式：YYYY_MM_DD_HH_MM
     *
     * @param strDate 日期
     */
    public static String formatExactMinute(String strDate) {
        return fetchDate(strDate, ":");
    }

    /**
     * 将日期，转换为精确到分钟的格式：YYYY_MM_DD_HH_MM
     *
     * @param date 日期
     */
    public static String formatExactMinute(Date date) {
        if (date == null)
            return null;
        return com.yundao.core.utils.DateUtils.format(date, com.yundao.core.utils.DateUtils.YYYY_MM_DD_HH_MM);
    }

    /**
     * 将字符串格式的日期，转换为精确到日的格式：YYYY_MM_DD
     *
     * @param strDate 日期
     */
    public static String formatExactDay(String strDate) {
        return fetchDate(strDate, " ");
    }

    /**
     * 将日期，转换为精确到日的格式：YYYY_MM_DD
     *
     * @param date 日期
     */
    public static String formatExactDay(Date date) {
        if (date == null)
            return null;
        return com.yundao.core.utils.DateUtils.format(date, com.yundao.core.utils.DateUtils.YYYY_MM_DD);
    }

    /**
     * 将YYYY_MM_DD 格式日期 加上23:59:59
     *
     * @param strDate 日期
     */
    public static String toEndDate(String strDate) {
        if (BooleanUtils.isBlank(strDate))
            return strDate;
        boolean validDate = com.yundao.core.utils.DateUtils.isValidDate(strDate, com.yundao.core.utils.DateUtils.YYYY_MM_DD);
        if (!validDate)
            return strDate;
        if (strDate.contains(":"))
            return strDate;
        return strDate.trim() + " " + com.yundao.core.utils.DateUtils.DAY_END;
    }

    /**
     * 将YYYY_MM_DD 格式日期 加上23:59:59
     *
     * @param endDate 日期
     */
    public static Date toEndDate(Date endDate) {
        if (endDate == null)
            return endDate;
        try {
            return com.yundao.core.utils.DateUtils.parse(com.yundao.core.utils.DateUtils.getDateEnd(endDate), com.yundao.core.utils.DateUtils.YYYY_MM_DD_HH_MM_SS);
        } catch (Exception e) {
            log.error("DateUtils.toEndDate 异常：%s", e.toString());
        }
        return null;
    }

    private static String fetchDate(String strDate, String splitSymbol) {
        if (BooleanUtils.isEmpty(strDate))
            return strDate;
        strDate = strDate.trim();
        int index = strDate.lastIndexOf(splitSymbol);
        return strDate.substring(0, index);
    }

    private static Date addTime(Date date, int field, Integer amount) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static Date getFirstMonth() {
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return cal_1.getTime();
    }

    /**
     * 转化字符串为日期
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static Date parse(String date) throws BaseException {
        if (BooleanUtils.isBlank(date)) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat(DateUtils.YYYY_MM_DD_HH_MM_SS);
            return format.parse(date);
        } catch (Exception ex) {
            log.error("DateUtils.parse 异常：%s", ex.toString());
            throw new BaseException(-1, "日期格式有误");
        }
    }

    /**
     * 补全日期
     */
    public static String repair(String date) throws BaseException {
        if (BooleanUtils.isBlank(date))
            return date;
        boolean validDate = DateUtils.isValidDate(date, DateUtils.YYYY_MM_DD_HH_MM_SS);
        if (validDate)
            return date;
        validDate = DateUtils.isValidDate(date, DateUtils.YYYY_MM_DD_HH_MM);
        if (validDate)
            return date + ":00";
        validDate = DateUtils.isValidDate(date, DateUtils.YYYY_MM_DD);
        if (validDate)
            return date + " 00:00:00";

        throw new BaseException(CodeConstant.CODE_1220138);
    }


    public static Date toDate(String dateStr) throws BaseException {
        try {
            SimpleDateFormat format = new SimpleDateFormat(DateUtils.YYYY_MM_DD);
            return format.parse(dateStr);
        } catch (Exception ex) {
            log.error("DateUtils.parse 异常：%s", ex.toString());
            throw new BaseException(-1, "日期格式有误");
        }
    }

    public static String getMonth(String dateStr) throws BaseException {
        if (BooleanUtils.isBlank(dateStr))
            return dateStr;
        Date date = toDate(dateStr);
        return Integer.valueOf(date.getMonth() + 1).toString();
    }

    public static String getDay(String dateStr) throws BaseException {
        if (BooleanUtils.isBlank(dateStr))
            return dateStr;
        Date date = toDate(dateStr);
        return Integer.valueOf(date.getDate()).toString();
    }
}
