

package com.yundao.tenant.enums.report;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月1日 上午10:30:41 
 * @author   欧阳利
 * @version   
 */
public enum ReportCustomGroupEnum {
	
	DAY("DAY", "天"),
	WEEK("WEEK", "周"),
	MONTH("MONTH", "月");
	
	
	private String value;
	private String name;

	private ReportCustomGroupEnum(String value, String name) {
		this.value = value;
		this.name = name;
	}


	public String getValue() {
	
		return value;
	}


	public void setValue(String value) {
	
		this.value = value;
	}


	public String getName() {
		return name;
	}
}

