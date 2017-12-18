

package com.yundao.tenant.dto.field;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月3日 下午5:51:08 
 * @author   wucq
 * @version   
 */
public class ValuesDto {
	 /**
     * 字段值
     */
    private String value;
    /**
     * 如果 type=number,number_range,设置单位
     */
    private String numUnit;
    /**
     * 如果 type=radio,checkbox,select
     * 下拉列表值所对应的中文名
     */
    private String selectLabel;
	public String getValue() {
	
		return value;
	}
	public void setValue(String value) {
	
		this.value = value;
	}
	public String getNumUnit() {
	
		return numUnit;
	}
	public void setNumUnit(String numUnit) {
	
		this.numUnit = numUnit;
	}
	public String getSelectLabel() {
	
		return selectLabel;
	}
	public void setSelectLabel(String selectLabel) {
	
		this.selectLabel = selectLabel;
	}
    
}

