package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseFieldConfig extends BaseModel implements Serializable {
    /**
	 * 业务对象字段id
	 */
    private Long objectFieldId;

    /**
	 * 默认值；如果是区间值，用逗号分隔如 数值：0,10000   日期：2017-10-10,,2099-10-10
	 */
    private String defaultValue;

    /**
	 * 最大长度；一般文本类型使用
	 */
    private Integer maxLength;

    /**
	 * 最小长度；一般文本类型使用
	 */
    private Integer minLength;

    /**
	 * 最大值；一般数值和日期类型使用
	 */
    private String maxValue;

    /**
	 * 最小值；一般数值和日期类型使用
	 */
    private String minValue;

    private static final long serialVersionUID = 1L;

    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }
}