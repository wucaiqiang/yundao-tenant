package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseTypeProperty extends BaseModel implements Serializable {
    /**
	 * 字段类型id
	 */
    private Long fieldTypeId;

    /**
	 * 属性值class
            
            文本类：[{"type":"text","key":"maxLength","value":"256","name":"最大长度","description":"最大长度不能超过256个字符","sequence":"1","isEnabled":"1"},{"type":"text","key":"minLength","value":"1","name":"最小长度","description":"最小长度不能小于1个字符","sequence":"2","isEnabled":"1"},{"type":"text","key":"description","value":"","name":"帮助文本","description":"最大长度不能超过256个字符","sequence":"3","isEnabled":"1"},{"type":"text","key":"defaultValue","value":"256","name":"默认值","description":"最大长度不能超过256个字符","sequence":"4","isEnabled":"1"}]
            
            文本域类：[{"type":"text","key":"maxLength","value":"65535","name":"最大长度","description":"最大长度不能超过65535个字符","sequence":"1","isEnabled":"1"},{"type":"text","key":"minLength","value":"1","name":"最小长度","description":"最小长度不能小于1个字符","sequence":"2","isEnabled":"1"},{"type":"text","key":"description","value":"","name":"帮助文本","description":"最大长度不能超过256个字符","sequence":"3","isEnabled":"1"}]
            
            单选类：[{"type":"text","key":"maxLength","value":"256","name
	 */
    private String clazz;

    /**
	 * 排序，越小越靠前
	 */
    private Integer sequence;

    private static final long serialVersionUID = 1L;

    public Long getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(Long fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}