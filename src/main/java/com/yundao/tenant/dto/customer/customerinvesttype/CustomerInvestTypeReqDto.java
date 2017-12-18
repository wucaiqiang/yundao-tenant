
package com.yundao.tenant.dto.customer.customerinvesttype;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CustomerInvestTypeReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "投资偏好")
    private Long productTypeId;

    @ApiModelProperty(value = "排序")
    private Integer seqencing;
    @ApiModelProperty(value = "租户Id")
    private Long tenantId;

    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }


    public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}

	public Long getProductTypeId (){
        return productTypeId;
    }

    public void setProductTypeId (Long productTypeId){
        this.productTypeId = productTypeId;
    }

    public Integer getSeqencing (){
        return seqencing;
    }

    public void setSeqencing (Integer seqencing){
        this.seqencing = seqencing;
    }

	public Long getTenantId() {
	
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
	
		this.tenantId = tenantId;
	}
    

}
