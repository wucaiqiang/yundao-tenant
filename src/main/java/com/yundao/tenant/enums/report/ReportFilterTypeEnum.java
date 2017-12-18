

package com.yundao.tenant.enums.report;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年12月1日 上午10:21:03 
 * @author   欧阳利
 * @version   
 */
public enum ReportFilterTypeEnum {
/**
 * 筛选1:自定义，2：本月, 3：上个月, 4：本季度, 5：上一季度, 6：本年度, 7：上一年度
 */
	
	/**
	 * 自定义
	 */
	CUSTOM(1, "自定义"),
	
	/**
	 * 本月   2
	 */
	MONTH(2, "本月"),
	
	/**
	 * 上个月   3
	 */
	UPPER_MONTH(3, "上个月"),
	
	/**
	 * 本季度   4
	 */
	QUARTER(4, "本季度"),
	
	/**
	 * 上一季度   5
	 */
	UPPER_QUARTER(5, "上一季度"),
	
	/**
	 * 本年度   6
	 */
	YEAR(6, "本年度"),
	
	/**
	 * 上一年度   7
	 */
	UPPER_YEAR(7, "上一年度");
	
	private Integer value;
	private String name;

	private ReportFilterTypeEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}

