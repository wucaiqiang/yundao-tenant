
package com.yundao.tenant.dto.sale.declaration;


import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class DeclarationUpdateBankDto{
    @ApiModelProperty(value = "报单ID")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210082 + "}", groups = {Update.class,Insert.class})
    private Long id;

    /**
     * 银行卡账号
     */
    @ApiModelProperty(value = "银行卡账号")
    @Length(min = 1, max = 30, message = "{" + GJLCodeConstant.CODE_1210023 + "}", groups = {Update.class,Insert.class})
    @Number(message = "{" + GJLCodeConstant.CODE_1210077 + "}", groups = {Update.class,Insert.class})
    private String account;

    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    @Length(min = 1, max = 30, message = "{" + GJLCodeConstant.CODE_1210024 + "}", groups = {Update.class,Insert.class})
    private String bankName;

    /**
     * 银行卡正面
     */
    @ApiModelProperty(value = "银行卡正面")
    private String front;

    /**
     * 银行卡反面
     */
    @ApiModelProperty(value = "银行卡反面")
    private String back;
    
    private Long bankId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getBankId() {
	
		return bankId;
	}

	public void setBankId(Long bankId) {
	
		this.bankId = bankId;
	}
    
}

