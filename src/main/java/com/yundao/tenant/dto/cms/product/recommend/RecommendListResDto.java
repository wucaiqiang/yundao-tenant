

package com.yundao.tenant.dto.cms.product.recommend;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:34:32 
 * @author   欧阳利
 * @version   
 */
public class RecommendListResDto {
	@ApiModelProperty("id")
    private Long id;
	
	@ApiModelProperty("产品id")
    private Long productId;
    @ApiModelProperty("产品名称")
    private String productName;
	@ApiModelProperty("产品类型")
    private String productType;
	
	@ApiModelProperty("平台id")
    private Long platformId;
	@ApiModelProperty("平台名称")
    private String platformName;
	
	@ApiModelProperty("位置id")
    private Integer positionId;
	@ApiModelProperty("位置名称")
    private String positionName;
	
	@ApiModelProperty("状态")
	private Integer status;
	@ApiModelProperty("状态名称")
	private String statusText;
	@ApiModelProperty("操作人id")
	private Long updateUserId;
	
	@ApiModelProperty("操作人")
	private String updateUserName;
	@ApiModelProperty("操作开始")
	private Date updateDate;
	private Integer sort;
	

	public String getStatusText() {
	
		return statusText;
	}
	public void setStatusText(String statusText) {
	
		this.statusText = statusText;
	}

	public Long getUpdateUserId() {
	
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
	
		this.updateUserId = updateUserId;
	}
	public Integer getSort() {
	
		return sort;
	}
	public void setSort(Integer sort) {
	
		this.sort = sort;
	}
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public Long getProductId() {
	
		return productId;
	}
	public void setProductId(Long productId) {
	
		this.productId = productId;
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
	public Long getPlatformId() {
	
		return platformId;
	}
	public void setPlatformId(Long platformId) {
	
		this.platformId = platformId;
	}
	public String getPlatformName() {
	
		return platformName;
	}
	public void setPlatformName(String platformName) {
	
		this.platformName = platformName;
	}
	public Integer getStatus() {
	
		return status;
	}
	public void setStatus(Integer status) {
	
		this.status = status;
	}
	public String getUpdateUserName() {
	
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
	
		this.updateUserName = updateUserName;
	}
	public Date getUpdateDate() {
	
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
	
		this.updateDate = updateDate;
	}
	public Integer getPositionId() {
	
		return positionId;
	}
	public void setPositionId(Integer positionId) {
	
		this.positionId = positionId;
	}
	public String getPositionName() {
	
		return positionName;
	}
	public void setPositionName(String positionName) {
	
		this.positionName = positionName;
	}
}

