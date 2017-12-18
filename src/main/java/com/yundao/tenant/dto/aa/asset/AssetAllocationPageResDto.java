

package com.yundao.tenant.dto.aa.asset;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午4:34:38 
 * @author   欧阳利
 * @version   
 */
public class AssetAllocationPageResDto {
	@ApiModelProperty("id")
	private Long id;
	@ApiModelProperty("用户名称")
	private Long userId;
	@ApiModelProperty("客户id")
	private Long customerId;
	@ApiModelProperty("客户名称")
	private String customerName;
	@ApiModelProperty("创建时间")
	private Date createDate;
	@ApiModelProperty("得分")
	private Integer grade;
	
	@ApiModelProperty("产品个数")
	private Integer productCount;
	
	@ApiModelProperty("产品id集合")
	private List<Long> productIds;
	
    @ApiModelProperty("风险测评类型值")
    private Integer riskValue;
    @ApiModelProperty("风险测评类型名称")
    private String riskText;

	public List<Long> getProductIds() {
	
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
	
		this.productIds = productIds;
	}

	public Integer getGrade() {
	
		return grade;
	}

	public void setGrade(Integer grade) {
	
		this.grade = grade;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Long getUserId() {
	
		return userId;
	}

	public void setUserId(Long userId) {
	
		this.userId = userId;
	}

	public Long getCustomerId() {
	
		return customerId;
	}

	public void setCustomerId(Long customerId) {
	
		this.customerId = customerId;
	}


	public String getCustomerName() {
	
		return customerName;
	}

	public void setCustomerName(String customerName) {
	
		this.customerName = customerName;
	}

	public Date getCreateDate() {
	
		return createDate;
	}

	public void setCreateDate(Date createDate) {
	
		this.createDate = createDate;
	}

	public Integer getProductCount() {
	
		return productCount;
	}

	public void setProductCount(Integer productCount) {
	
		this.productCount = productCount;
	}

	public Integer getRiskValue() {
	
		return riskValue;
	}

	public void setRiskValue(Integer riskValue) {
	
		this.riskValue = riskValue;
	}

	public String getRiskText() {
	
		return riskText;
	}

	public void setRiskText(String riskText) {
	
		this.riskText = riskText;
	}
}

