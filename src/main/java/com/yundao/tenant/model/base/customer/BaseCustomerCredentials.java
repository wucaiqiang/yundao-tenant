package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomerCredentials extends BaseModel implements Serializable {
    /**
	 * 证件类型（1：身份证，2：护照）
	 */
    private Long type;

    /**
	 * 证件号码
	 */
    private String number;

    /**
	 * 证件正面
	 */
    private String front;

    /**
	 * 证件反面
	 */
    private String back;

    private static final long serialVersionUID = 1L;

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}