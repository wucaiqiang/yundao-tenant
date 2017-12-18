package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseNumberConfig extends BaseModel implements Serializable {
    /**
	 * 业务对象字段id
	 */
    private Long objectFieldId;

    /**
	 * 小数点位数
	 */
    private Integer decimalLength;

    /**
	 * 单位
	 */
    private String unit;

    /**
	 * 最大值
	 */
    private Long maxValue;

    /**
	 * 最小值
	 */
    private Long minValue;

    private static final long serialVersionUID = 1L;

    public Long getObjectFieldId() {
        return objectFieldId;
    }

    public void setObjectFieldId(Long objectFieldId) {
        this.objectFieldId = objectFieldId;
    }

    public Integer getDecimalLength() {
        return decimalLength;
    }

    public void setDecimalLength(Integer decimalLength) {
        this.decimalLength = decimalLength;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    public Long getMinValue() {
        return minValue;
    }

    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }
}