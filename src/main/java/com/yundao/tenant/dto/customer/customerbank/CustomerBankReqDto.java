
package com.yundao.tenant.dto.customer.customerbank;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CustomerBankReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "客户id")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210019 + "}", groups = {Update.class,Insert.class})
    private Long customerId;

    @ApiModelProperty(value = "银行卡账号")
    @Length(min = 1, max = 30, message = "{" + GJLCodeConstant.CODE_1210023 + "}", groups = {Update.class,Insert.class})
    @Number(message = "{" + GJLCodeConstant.CODE_1210077 + "}", groups = {Update.class,Insert.class})
    private String account;

    @ApiModelProperty(value = "开户行")
    @Length(min = 1, max = 30, message = "{" + GJLCodeConstant.CODE_1210024 + "}", groups = {Update.class,Insert.class})
    private String bankName;

    @ApiModelProperty(value = "银行卡正面")
    @Length(message = "{" + GJLCodeConstant.CODE_1210025 + "}", groups = {Update.class,Insert.class})
    private String front;

    @ApiModelProperty(value = "银行卡反面")
    @Length(message = "{" + GJLCodeConstant.CODE_1210026 + "}", groups = {Update.class,Insert.class})
    private String back;

    @ApiModelProperty(value = "租户ID")
    private Long tenantId;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getCustomerId (){
        return customerId;
    }

    public void setCustomerId (Long customerId){
        this.customerId = customerId;
    }

    public String getAccount (){
        return account;
    }

    public void setAccount (String account){
        this.account = account;
    }

    public String getBankName (){
        return bankName;
    }

    public void setBankName (String bankName){
        this.bankName = bankName;
    }

    public String getFront (){
        return front;
    }

    public void setFront (String front){
        this.front = front;
    }

    public String getBack (){
        return back;
    }

    public void setBack (String back){
        this.back = back;
    }

	public Long getTenantId() {
	
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
	
		this.tenantId = tenantId;
	}
    
}
