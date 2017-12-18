

package com.yundao.tenant.dto.cms.product.recommend;

import java.util.Date;

import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:08:30 
 * @author   欧阳利
 * @version   
 */
public class RecommendListReqDto extends AbstractBasePageDto{
	
	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("产品名称")
    private String productName;
	@ApiModelProperty("产品类型")
    private String productType;
	@ApiModelProperty("平台集合")
    private String platformIds;
	@ApiModelProperty("位置集合")
    private String positions;
	@ApiModelProperty("状态")
	private String statuss;
	@ApiModelProperty("操作人")
	private String updateUserName;
	@ApiModelProperty("操作开始时间")
	private Date updateDateStart;
	@ApiModelProperty("操作结束时间")
	private Date updateDateEnd;
	
	public String getUpdateUserName() {
	
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
	
		this.updateUserName = updateUserName;
	}
	public Date getUpdateDateStart() {
	
		return updateDateStart;
	}
	public void setUpdateDateStart(Date updateDateStart) {
	
		this.updateDateStart = updateDateStart;
	}
	public Date getUpdateDateEnd() {
	
		return updateDateEnd;
	}
	public void setUpdateDateEnd(Date updateDateEnd) {
	
		this.updateDateEnd = updateDateEnd;
	}
	public String getProductName() {
	
		return productName;
	}
	public void setProductName(String productName) {
	
		this.productName = productName;
	}
	public String getProductType() {
	
		return productType;
	}
	public void setProductType(String productType) {
	
		this.productType = productType;
	}
	public String getPlatformIds() {
	
		return platformIds;
	}
	public void setPlatformIds(String platformIds) {
	
		this.platformIds = platformIds;
	}
	public String getPositions() {
	
		return positions;
	}
	public void setPositions(String positions) {
	
		this.positions = positions;
	}
	public String getStatuss() {
	
		return statuss;
	}
	public void setStatuss(String statuss) {
	
		this.statuss = statuss;
	}
	
	
}

