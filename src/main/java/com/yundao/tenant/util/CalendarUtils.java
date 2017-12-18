package com.yundao.tenant.util;

import java.util.Calendar;
import java.util.Date;

/**
 * ClassName:CalendarUtils 
 * Function: TODO ADD FUNCTION. 
 * Reason:	 TODO ADD REASON. 
 * Date:     2016年10月17日 下午8:06:27 
 * @author   wucq
 * @version   
 */
public class CalendarUtils {
	/**
	 * 当前时候取前或后几天，几周，几月的时间的开始时间
	 * getDayBegin:
	 * @author: wucq
	 * @param date
	 * @param type
	 * @param operateNum
	 * @return
	 * @description:
	 */
	public static Date getDayBegin(Date date,Integer type,Integer operateNum){
		//type 0:天，1：周 ，2：月 
		//operateNum 负数向前减，正数向后加
		Calendar dateCalenda=Calendar.getInstance();
		dateCalenda.setTime(date);//设置时间
		if(type == 0){
			dateCalenda.set(Calendar.DATE, dateCalenda.get(Calendar.DATE)+operateNum);	
		}
		if(type == 1){
			dateCalenda.set(Calendar.WEEK_OF_YEAR, dateCalenda.get(Calendar.WEEK_OF_YEAR)+operateNum);	
			dateCalenda.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//取当前周的开始时间，即星期天的开始时间
		}
		if(type == 2){
			dateCalenda.set(Calendar.MONTH, dateCalenda.get(Calendar.MONTH)+operateNum);
			dateCalenda.set(Calendar.DAY_OF_MONTH, 1);//取当前月1号时间
		}
		dateCalenda.set(Calendar.HOUR_OF_DAY,dateCalenda.getActualMinimum(Calendar.HOUR_OF_DAY));
		dateCalenda.set(Calendar.MINUTE, dateCalenda.getActualMinimum(Calendar.MINUTE));
		dateCalenda.set(Calendar.SECOND, dateCalenda.getActualMinimum(Calendar.SECOND));
		dateCalenda.set(Calendar.MILLISECOND, dateCalenda.getActualMinimum(Calendar.MILLISECOND));
		return dateCalenda.getTime();
	}
	/**
	 * 当前时候取前或后几天，几周，几月的时间的结束时间
	 * getDayEnd:
	 * @author: wucq
	 * @param date
	 * @param type
	 * @param operateNum
	 * @return
	 * @description:
	 */
	public static Date getDayEnd(Date date,Integer type,Integer operateNum){
		//type 0:天，1：周 ，2：月 
		//operateNum 负数向前减，正数向后加
		Calendar dateCalenda=Calendar.getInstance();
		dateCalenda.setTime(date);//设置时间
		if(type == 0){
			dateCalenda.set(Calendar.DATE, dateCalenda.get(Calendar.DATE)+operateNum);	
		}
		if(type == 1){
			dateCalenda.set(Calendar.WEEK_OF_YEAR, dateCalenda.get(Calendar.WEEK_OF_YEAR)+operateNum);	
			dateCalenda.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY );//取当前周的开始时间，即星期六的结束时间
		}
		if(type == 2){
			dateCalenda.set(Calendar.MONTH, dateCalenda.get(Calendar.MONTH)+operateNum);
			dateCalenda.set(Calendar.DAY_OF_MONTH, dateCalenda.getActualMaximum(Calendar.DAY_OF_MONTH));//取当前月最大那天的结束时间
		}
		dateCalenda.set(Calendar.HOUR_OF_DAY,dateCalenda.getActualMaximum(Calendar.HOUR_OF_DAY));
		dateCalenda.set(Calendar.MINUTE, dateCalenda.getActualMaximum(Calendar.MINUTE));
		dateCalenda.set(Calendar.SECOND, dateCalenda.getActualMaximum(Calendar.SECOND));
		dateCalenda.set(Calendar.MILLISECOND, dateCalenda.getActualMaximum(Calendar.MILLISECOND));
		return dateCalenda.getTime();
	}
	/**
	 * 取当前天的开始时间
	 * getDayBegin:
	 * @author: wucq
	 * @param date
	 * @return
	 * @description:
	 */
	public static Date getCurrentDayBeginTime(Date date){
		Calendar dateCalenda=Calendar.getInstance();
		dateCalenda.setTime(date);//设置时间
		dateCalenda.set(Calendar.HOUR_OF_DAY,dateCalenda.getActualMinimum(Calendar.HOUR_OF_DAY));
		dateCalenda.set(Calendar.MINUTE, dateCalenda.getActualMinimum(Calendar.MINUTE));
		dateCalenda.set(Calendar.SECOND, dateCalenda.getActualMinimum(Calendar.SECOND));
		dateCalenda.set(Calendar.MILLISECOND, dateCalenda.getActualMinimum(Calendar.MILLISECOND));
		return dateCalenda.getTime();
	}
	
	/**
	 * 取当前天的结束时间
	 * getDayEnd:
	 * @author: wucq
	 * @param date
	 * @return
	 * @description:
	 */
	public static Date getCurrentDateEndTime(Date date){
		Calendar dateCalenda=Calendar.getInstance();
		dateCalenda.setTime(date);//设置时间
		dateCalenda.set(Calendar.HOUR_OF_DAY,dateCalenda.getActualMaximum(Calendar.HOUR_OF_DAY));
		dateCalenda.set(Calendar.MINUTE, dateCalenda.getActualMaximum(Calendar.MINUTE));
		dateCalenda.set(Calendar.SECOND, dateCalenda.getActualMaximum(Calendar.SECOND));
		dateCalenda.set(Calendar.MILLISECOND, dateCalenda.getActualMaximum(Calendar.MILLISECOND));
		return dateCalenda.getTime();
	}
	public static String fewDaysLongFromToday(Date dictDate){
		
		String retContent="";
		if(dictDate ==null){
			retContent="从未跟进过";
			return retContent;
		}
		Calendar dictCalendar=Calendar.getInstance();
		dictCalendar.setTime(dictDate);
		
		
		//今天的开始 >昨天的结束
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.DATE, todayStart.get(Calendar.DATE)-1);	
		todayStart.set(Calendar.HOUR_OF_DAY,todayStart.getActualMaximum(Calendar.HOUR_OF_DAY));
		todayStart.set(Calendar.MINUTE, todayStart.getActualMaximum(Calendar.MINUTE));
		todayStart.set(Calendar.SECOND, todayStart.getActualMaximum(Calendar.SECOND));
		todayStart.set(Calendar.MILLISECOND, todayStart.getActualMaximum(Calendar.MILLISECOND));
		
		//昨天的结束 < 今天的开始
		Calendar yesterdayEnd = Calendar.getInstance();
		yesterdayEnd.set(Calendar.HOUR_OF_DAY,yesterdayEnd.getActualMinimum(Calendar.HOUR_OF_DAY));
		yesterdayEnd.set(Calendar.MINUTE, yesterdayEnd.getActualMinimum(Calendar.MINUTE));
		yesterdayEnd.set(Calendar.SECOND, yesterdayEnd.getActualMinimum(Calendar.SECOND));
		yesterdayEnd.set(Calendar.MILLISECOND, yesterdayEnd.getActualMinimum(Calendar.MILLISECOND));
		
		//昨天的开始 >前天的结束
		Calendar yesterdayStart = Calendar.getInstance();
		yesterdayStart.set(Calendar.DATE, yesterdayStart.get(Calendar.DATE)-2);	
		yesterdayStart.set(Calendar.HOUR_OF_DAY, yesterdayStart.getActualMaximum(Calendar.HOUR_OF_DAY));
		yesterdayStart.set(Calendar.MINUTE, yesterdayStart.getActualMaximum(Calendar.MINUTE));
		yesterdayStart.set(Calendar.SECOND, yesterdayStart.getActualMaximum(Calendar.SECOND));
		yesterdayStart.set(Calendar.MILLISECOND, yesterdayStart.getActualMaximum(Calendar.MILLISECOND));
		
		
		//前天的结束 < 昨天的开始
		Calendar dayBeforeYesterdayEnd = Calendar.getInstance();
		dayBeforeYesterdayEnd.set(Calendar.DATE, dayBeforeYesterdayEnd.get(Calendar.DATE)-1);	
		dayBeforeYesterdayEnd.set(Calendar.HOUR_OF_DAY,dayBeforeYesterdayEnd.getActualMinimum(Calendar.HOUR_OF_DAY));
		dayBeforeYesterdayEnd.set(Calendar.MINUTE, dayBeforeYesterdayEnd.getActualMinimum(Calendar.MINUTE));
		dayBeforeYesterdayEnd.set(Calendar.SECOND, dayBeforeYesterdayEnd.getActualMinimum(Calendar.SECOND));
		dayBeforeYesterdayEnd.set(Calendar.MILLISECOND, dayBeforeYesterdayEnd.getActualMinimum(Calendar.MILLISECOND));
		
		//前天的开始 >大前天的结束
		Calendar dayBeforeYesterdayStart = Calendar.getInstance();
		dayBeforeYesterdayStart.set(Calendar.DATE, dayBeforeYesterdayStart.get(Calendar.DATE)-3);	
		dayBeforeYesterdayStart.set(Calendar.HOUR_OF_DAY, dayBeforeYesterdayStart.getActualMaximum(Calendar.HOUR_OF_DAY));
		dayBeforeYesterdayStart.set(Calendar.MINUTE, dayBeforeYesterdayStart.getActualMaximum(Calendar.MINUTE));
		dayBeforeYesterdayStart.set(Calendar.SECOND, dayBeforeYesterdayStart.getActualMaximum(Calendar.SECOND));
		dayBeforeYesterdayStart.set(Calendar.MILLISECOND, dayBeforeYesterdayStart.getActualMaximum(Calendar.MILLISECOND));
		
		
		if(dictCalendar.after(todayStart)){
			//今天已经跟进过
			return "今天已跟进";
			
		}else if(dictCalendar.after(yesterdayStart) && dictCalendar.before(yesterdayEnd)){
			retContent="今天未跟进";
		}else if(dictCalendar.after(dayBeforeYesterdayStart) && dictCalendar.before(dayBeforeYesterdayEnd)) {
			retContent="昨天未跟进";
		}else {
			
			Calendar today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY,0);
			today.set(Calendar.MINUTE, 0);
			today.set(Calendar.SECOND, 0);
			today.set(Calendar.MILLISECOND, 0);
			
			
			dictCalendar.set(Calendar.HOUR_OF_DAY,0);
			dictCalendar.set(Calendar.MINUTE, 0);
			dictCalendar.set(Calendar.SECOND, 0);
			dictCalendar.set(Calendar.MILLISECOND, 0);
			
			long timePoor=today.getTimeInMillis()-dictCalendar.getTimeInMillis();
			
			long dateMillis = 24*60*60*1000;
			long monthMillis = 30*dateMillis;
			long yearMillis = 365*dateMillis;
			if(timePoor < 0 ){
				retContent="数据有误";
				return retContent;
			}
			if(timePoor <= dateMillis){
				retContent="1天未跟进";
			}else if(timePoor > dateMillis && timePoor <= monthMillis){
				long poolDay=timePoor%dateMillis == 0? (timePoor/dateMillis):(timePoor/dateMillis+1);
				retContent=((int)poolDay)+"天未跟进";
			}else if(timePoor > monthMillis && timePoor < yearMillis){
				int poolMonth=(int)(timePoor/monthMillis);
				retContent="近"+poolMonth+"月未跟进";
			}else{
				int poolYear=(int)(timePoor/yearMillis);
				retContent="近"+poolYear+"年未跟进";
			}
			
		}
		
		return retContent;
	}
}


