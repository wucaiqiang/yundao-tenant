package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomerBank extends BaseModel implements Serializable {
    /**
	 * 银行卡账号
	 */
    private String account;

    /**
	 * 开户行
	 */
    private String bankName;

    /**
	 * 银行卡正面
	 */
    private String front;

    /**
	 * 银行卡反面
	 */
    private String back;

    private static final long serialVersionUID = 1L;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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