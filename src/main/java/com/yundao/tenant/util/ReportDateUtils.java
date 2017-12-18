

package com.yundao.tenant.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.dto.report.customer.DepartmentAndUserDetailReqDto;
import com.yundao.tenant.enums.report.ReportCustomGroupEnum;
import com.yundao.tenant.enums.report.ReportFilterTypeEnum;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月10日 下午5:30:13 
 * @author   欧阳利
 * @version   
 */
public class ReportDateUtils {
	
	public static boolean getWeekOfMonth(DepartmentAndUserDetailReqDto reqDto){
		if (reqDto.getFilterType() > ReportFilterTypeEnum.UPPER_MONTH.getValue().intValue() ) {// 按月分组
			return false;
		}
		else if (ReportFilterTypeEnum.UPPER_MONTH.getValue().equals(reqDto.getFilterType()) ||
				ReportFilterTypeEnum.MONTH.getValue().equals(reqDto.getFilterType())) {  // 按周分组
			return false;
		}else if(ReportFilterTypeEnum.CUSTOM.getValue().equals(reqDto.getFilterType())){ // 自定义 按天，周，月分组
			if(ReportCustomGroupEnum.DAY.getValue().equals(reqDto.getStatType())){ //天
				return false;
			}else if(ReportCustomGroupEnum.WEEK.getValue().equals(reqDto.getStatType())){ // 周
				return true;
			}else{ // 月
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean getWeekOfMonth(Integer filterType, String statType){
		if (filterType > ReportFilterTypeEnum.UPPER_MONTH.getValue().intValue() ) {// 按月分组
			return false;
		}
		else if (ReportFilterTypeEnum.UPPER_MONTH.getValue().equals(filterType) ||
				ReportFilterTypeEnum.MONTH.getValue().equals(filterType)) {  // 按周分组
			return false;
		}else if(ReportFilterTypeEnum.CUSTOM.getValue().equals(filterType)){ // 自定义 按天，周，月分组
			if(ReportCustomGroupEnum.DAY.getValue().equals(statType)){ //天
				return false;
			}else if(ReportCustomGroupEnum.WEEK.getValue().equals(statType)){ // 周
				return true;
			}else{ // 月
				return false;
			}
		}
		return true;
	}
	
	public static String getWeekStartDay(String day) throws Exception{
		 Date date = DateUtils.parse(day, DateUtils.YYYY_MM_DD);
		 Calendar calendar = Calendar.getInstance();
	     calendar.setTime(date);
	     for (int i = 0; calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY; i++) {
	        calendar.add(Calendar.DAY_OF_MONTH, -1);
	     }
		 return  DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
	}
	
	public static String getWeekLastDay(String day) throws Exception{
		 Date date = DateUtils.parse(day, DateUtils.YYYY_MM_DD);
		 Calendar calendar = Calendar.getInstance();
	     calendar.setTime(date);
	     for (int i = 0; calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY; i++) {
	        calendar.add(Calendar.DAY_OF_MONTH, +1);
	     }
		 return  DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
	}
	
	
	public static String getMonthStartDay(String day) throws Exception{
		 Date date = DateUtils.parse(day, DateUtils.YYYY_MM_DD);
		 return  getMonthStartDay(date);
	}
	
	public static String getMonthLastDay(String day) throws Exception{
		 Date date = DateUtils.parse(day, DateUtils.YYYY_MM_DD);
		 return  getMonthLastDay(date);
	}

/**
 * 获取一个月份的所有周
 * getAllWeekOfMonth:
 *
 * @return
 * @author: 欧阳利
 * @description:
 */
public static Map<Integer, List<Date>> getAllWeekOfMonth(Date date) {
    Date startDate = getFirstDayOfFirstWeekOfMonth(date);
    Date endDate = getLastDayOfLastWeekOfMonth(date);
    return getAllWeekOfMonth(startDate, endDate);
}


public static Map<Integer, List<Date>> getAllWeekOfMonth(Date startDate, Date endDate) {
    Map<Integer, List<Date>> map = new HashMap<Integer, List<Date>>();
    for (int i = 1; startDate.before(endDate); i++) {
        List<Date> list = new ArrayList<Date>();
        list.add(startDate);
        
        // 开始时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH, 6);
        
        // 结束时间
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(calendar.getTime());
        endCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endCalendar.set(Calendar.MINUTE, 59);
        endCalendar.set(Calendar.SECOND, 59);
        list.add(endCalendar.getTime());
        
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        startDate = calendar.getTime();
        map.put(i, list);
    }
    return map;
}


public static Map<Integer, List<Date>> getAllWeekOfUpperMonth(Date date) {
    Date startDate = getFirstDayOfFirstWeekOfUpperMonth(date);
    Date endDate = getLastDayOfLastWeekOfUpperMonth(date);
    return getAllWeekOfMonth(startDate, endDate);
}

/**
 * 获取本月第一周第一天
 */
public static Date getFirstDayOfFirstWeekOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    for (int i = 0; calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY; i++) {
        calendar.add(Calendar.DAY_OF_MONTH, -1);
    }
    return calendar.getTime();
}

/**
 * 获取上月第一周第一天
 */
private static Date getFirstDayOfFirstWeekOfUpperMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.MONTH, -1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    for (int i = 0; calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY; i++) {
        calendar.add(Calendar.DAY_OF_MONTH, -1);
    }
    return calendar.getTime();
}

/**
 * 获取本月最后一周最后一天
 */
public static Date getLastDayOfLastWeekOfMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);

    for (int i = 0; calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY; i++) {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    return calendar.getTime();
}


private static Date getLastDayOfLastWeekOfUpperMonth(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);

    for (int i = 0; calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY; i++) {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    return calendar.getTime();
}


private static int getQuarterInMonth(int month, boolean isQuarterStart) {
    int months[] = {1, 4, 7, 10};
    if (!isQuarterStart) {
        months = new int[]{3, 6, 9, 12};
    }
    if (month >= 2 && month <= 4)
        return months[0];
    else if (month >= 5 && month <= 7)
        return months[1];
    else if (month >= 8 && month <= 10)
        return months[2];
    else
        return months[3];
}


public static List<String> getDayStrList(String customStart, String customEnd) throws Exception{
	 if (BooleanUtils.isBlank(customStart)|| BooleanUtils.isBlank(customEnd)) {
		 
         return null;
     }
	 Date startDate = DateUtils.parse(customStart, DateUtils.YYYY_MM_DD);
     Date endDate = DateUtils.parse(customEnd, DateUtils.YYYY_MM_DD);
     Calendar calendar = Calendar.getInstance();
     calendar.setTime(startDate);
     List<String> days = new ArrayList<String>();
     for(;startDate.before(endDate);){
    	 days.add(DateUtils.format(startDate, DateUtils.YYYY_MM_DD));
    	 calendar.add(Calendar.DAY_OF_MONTH, 1);
    	 startDate = calendar.getTime();
     }
     if(!days.contains(customEnd)){
    	 days.add(customEnd);
     }
	 return days;
}


/**
 * 获取月份
 * getMonthStr:
 *
 * @param date
 * @param filterType 筛选1:自定义，2：本月, 3：上个月, 4：本季度, 5：上一季度, 6：本年度, 7：上一年度
 * @return
 * @author: 欧阳利
 * @description:
 */
public static List<String> getMonthStr(Date date, Integer filterType, String customStart, String customEnd) throws Exception {
    if (filterType == null || date == null) {
        return null;
    }
    List<String> list = new ArrayList<String>();
    if (filterType == 1) {
        Date startDate = DateUtils.parse(customStart, DateUtils.YYYY_MM_DD);
        Date endDate = DateUtils.parse(customEnd, DateUtils.YYYY_MM_DD);

        Calendar calendar = Calendar.getInstance();
        for (; startDate.before(endDate); ) {
            calendar.setTime(startDate);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            month = month + 1;
//            String monthStr = ""+month;
//            if(month < 10){
//            	monthStr = "0"+month;
//            }
//            list.add(year + "-" + monthStr);
            addMonthStr(list, year, month);
            calendar.add(Calendar.MONTH, 1);
            startDate = calendar.getTime();
        }

        calendar.setTime(endDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;
        String monthStr = ""+month;
        if(month < 10){
        	monthStr = "0"+month;
        }
        if (!list.contains(year + "-" + monthStr)) {
            list.add(year + "-" + monthStr);
        }

    } else if (filterType == 4) {
        String startDate = getStartDay(date, filterType, false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parse(startDate, DateUtils.YYYY_MM_DD));
        for (int i = 1; i <= 3; i++) {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            calendar.add(Calendar.MONTH, 1);
            month = month + 1;
//            String monthStr = ""+month;
//            if(month < 10){
//            	monthStr = "0"+month;
//            }
//            list.add(year + "-" + monthStr);
            addMonthStr(list, year, month);
        }

    } else if (filterType == 5) {
        String startDate = getStartDay(date, filterType, false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parse(startDate, DateUtils.YYYY_MM_DD));
        for (int i = 1; i <= 3; i++) {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            calendar.add(Calendar.MONTH, 1);
            month = month + 1;
//            String monthStr = ""+month;
//            if(month < 10){
//            	monthStr = "0"+month;
//            }
//            list.add(year + "-" + monthStr);
            addMonthStr(list, year, month);
        }

    } else if (filterType == 6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        for (int i = 1; i <= 12; i++) {
//        	String monthStr = ""+i;
//            if(i < 10){
//            	monthStr = "0"+i;
//            }
//           list.add(year + "-" + monthStr);
        	addMonthStr(list, year,  i);
        }
    } else if (filterType == 7) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        int year = calendar.get(Calendar.YEAR);
        for (int i = 1; i <= 12; i++) {
//        	 String monthStr = ""+i;
//             if(i < 10){
//             	monthStr = "0"+i;
//             }
//            list.add(year + "-" + monthStr);
            addMonthStr(list, year,  i);
        }
    }
    return list;
}


private static void addMonthStr( List<String> list,int year,int month){
	 String monthStr = ""+month;
     if(month < 10){
     	monthStr = "0"+month;
     }
    list.add(year + "-" + monthStr);
}


/**
 * 查询第一天
 * getStartDay:
 *
 * @param date
 * @param filterType 筛选1:自定义，2：本月, 3：上个月, 4：本季度, 5：上一季度, 6：本年度, 7：上一年度
 * @return
 * @author: 欧阳利
 * @description:
 */
public static String getStartDay(Date date, Integer filterType, Boolean weekOfMonth) {
    if (filterType == null || date == null) {
        return null;
    }
    if (filterType == 2) {
        if (weekOfMonth) {
            return DateUtils.format(getFirstDayOfFirstWeekOfMonth(date), DateUtils.YYYY_MM_DD);
        } else {
            return getMonthStartDay(date);
        }

    } else if (filterType == 3) {
        if (weekOfMonth) {
            return DateUtils.format(getFirstDayOfFirstWeekOfUpperMonth(date), DateUtils.YYYY_MM_DD);
        } else {
            return getUpperMonthStartDay(date);
        }
    } else if (filterType == 4) {
        return getQuarterStartDay(date);
    } else if (filterType == 5) {
        return getUpperQuarterStartDay(date);
    } else if (filterType == 6) {
        return getYearStartDay(date);
    } else if (filterType == 7) {
        return getUpperYearStartDay(date);
    }
    return null;
}

/**
 * 查询最后一天
 * getStartDay:
 *
 * @param date
 * @param filterType 筛选1:自定义，2：本月, 3：上个月, 4：本季度, 5：上一季度, 6：本年度, 7：上一年度
 * @return
 * @author: 欧阳利
 * @description:
 */
public static String getLastDay(Date date, Integer filterType, Boolean weekOfMonth) {
    if (filterType == null || date == null) {
        return null;
    }
    if (filterType == 2) {
        if (weekOfMonth) {
            return DateUtils.format(getLastDayOfLastWeekOfMonth(date), DateUtils.YYYY_MM_DD);
        } else {
            return getMonthLastDay(date);
        }
    } else if (filterType == 3) {
        if (weekOfMonth) {
            return DateUtils.format(getLastDayOfLastWeekOfUpperMonth(date), DateUtils.YYYY_MM_DD);
        } else {
            return getUpperMonthLastDay(date);
        }
    } else if (filterType == 4) {
        return getQuarterLastDay(date);
    } else if (filterType == 5) {
        return getUpperQuarterLastDay(date);
    } else if (filterType == 6) {
        return getYearLastDay(date);
    } else if (filterType == 7) {
        return getUpperYearLastDay(date);
    }
    return null;
}


/**
 * 本年第一天
 */
private static String getUpperYearStartDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.YEAR, -1);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 本年最后一天
 */
private static String getUpperYearLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.YEAR, -1);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.DAY_OF_MONTH, 31);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 本年第一天
 */
private static String getYearStartDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.MONTH, 0);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 本年最后一天
 */
private static String getYearLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.DAY_OF_MONTH, 31);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 上季度第一天
 */
private static String getUpperQuarterStartDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = getQuarterInMonth(calendar.get(calendar.MONTH) + 1, true);
    calendar.set(Calendar.MONTH, month - 1 - 3);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 上季度最后一天
 */
private static String getUpperQuarterLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = getQuarterInMonth(calendar.get(calendar.MONTH) + 1, false);
    calendar.set(Calendar.MONTH, month - 3);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}


/**
 * 本季度第一天
 */
private static String getQuarterStartDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = getQuarterInMonth(calendar.get(calendar.MONTH) + 1, true);
    calendar.set(Calendar.MONTH, month - 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 本季度最后一天
 */
private static String getQuarterLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = getQuarterInMonth(calendar.get(calendar.MONTH) + 1, false);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}


/**
 * 上个月第一天
 */
private static String getUpperMonthStartDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.MONTH, -1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 本月最后一天
 */
private static String getUpperMonthLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}


/**
 * 本月第一天
 */
private static String getMonthStartDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}

/**
 * 本月最后一天
 */
private static String getMonthLastDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    return DateUtils.format(calendar.getTime(), DateUtils.YYYY_MM_DD);
}


}

