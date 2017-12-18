package com.yundao.tenant.util.field;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.dto.field.DateRangeFieldDto;

public class FieldUtils {
	
	public static String SPLIT_SYMBOL = ",";
	
    public static DateRangeFieldDto getDateRangeField(String dateRange){
    	DateRangeFieldDto date = new DateRangeFieldDto();
    	if(BooleanUtils.isEmpty(dateRange)){
    		return date;
    	}
    	String[] dateArray = dateRange.split(FieldUtils.SPLIT_SYMBOL);
    	try{
    		Date startDate = null;
    		Date endDate = null;
    		if(dateArray.length ==2){
        		startDate = DateUtils.parse(dateArray[0], DateUtils.YYYY_MM_DD);
        		endDate = DateUtils.parse(dateArray[1], DateUtils.YYYY_MM_DD);
        	}else{
        		startDate = DateUtils.parse(dateArray[0], DateUtils.YYYY_MM_DD);
        	}
    		date.setStartDate(startDate);
    		date.setEndDate(endDate);
    	}catch(Exception e){
    		
    	}
    	return date;
    }
    
    /**
     * 获取复选框的值
     * @param checkBox
     * @return
     */
    public static List<String> getCheckBoxField(String checkBox){
    	if(BooleanUtils.isEmpty(checkBox)){
    		return null;
    	}
    	String[] checkBoxArray = checkBox.split(FieldUtils.SPLIT_SYMBOL);
    	List<String> list = Arrays.asList(checkBoxArray);
    	return list;
    }
    
    
    /**
     * 获取数字范围值
     * @param numberRange
     * @return
     */
    public static List<String> getNumberRangeField(String numberRange){
    	if(BooleanUtils.isEmpty(numberRange)){
    		return null;
    	}
    	String[] checkBoxArray = numberRange.split(FieldUtils.SPLIT_SYMBOL);
    	List<String> list = Arrays.asList(checkBoxArray);
    	return list;
    }
    
	
	 /** 
    * 判断str1中包含str2的个数 
     * @param str1 
    * @param str2 
    * @return counter 
    */  
   public static int containsCharCount(String str1, String str2 ,Integer counter) {  
       if (str1.indexOf(str2) == -1) {  
           return counter;  
       } else if (str1.indexOf(str2) != -1) {  
           counter++;  
           counter = containsCharCount(str1.substring(str1.indexOf(str2) + str2.length()), str2,counter);  
           return counter;  
       }  
       return counter;  
   } 
}
