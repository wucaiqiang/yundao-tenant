package com.yundao.tenant.dto.field;

import java.io.Serializable;
import java.util.List;

/**
 * 字段值详情
 * 
 * @author 欧阳利
 * 2017年7月27日
 */
public class FieldDetailAndValueDto implements Serializable{
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 业务对象字段ID
	 */
	private Long id;
	/**
	 * 字段code
	 */
	private String code;
	/**
	 * 字段中文名
	 */
    private String name;
    /**
     * 字段类型
     */
    private Integer type;
    /**
     * 字段类型编码
     */
    private String typeCode;
    /**
     * 字段类型中文名
     */
    private String typeName;
    
    private List<ValuesDto> values;
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public String getCode() {
	
		return code;
	}
	public void setCode(String code) {
	
		this.code = code;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	public Integer getType() {
	
		return type;
	}
	public void setType(Integer type) {
	
		this.type = type;
	}
	public List<ValuesDto> getValues() {
	
		return values;
	}
	public void setValues(List<ValuesDto> values) {
	
		this.values = values;
	}
	public String getTypeName() {
	
		return typeName;
	}
	public void setTypeName(String typeName) {
	
		this.typeName = typeName;
	}
	public String getTypeCode() {
	
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
	
		this.typeCode = typeCode;
	}

}
