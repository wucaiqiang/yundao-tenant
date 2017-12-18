

package com.yundao.tenant.dto.cms.product.recommend;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:08:30 
 * @author   欧阳利
 * @version   
 */
public class RecommendDetailDto {
	private Long id;

	@ApiModelProperty("产品id")
    private Long productId;
    
    @ApiModelProperty("产品名称")
    private String productName;
    
    @ApiModelProperty("产品发行状态(0:未上线; 1:上线准备中; 2:预售; 3:募集中; 4:募集结束; 5:存续封闭中;6:清算退出)")
    private Integer issuedStatus;
    @ApiModelProperty("产品发行状态名称")
    private String issuedStatusText;

    @ApiModelProperty("平台id")
    private Long platformId;
    
    @ApiModelProperty("平台名称")
    private String platformName;

    @ApiModelProperty("位置id")
    private Long positionId;
    
    @ApiModelProperty("位置名称")
    private String positionName;

    @ApiModelProperty("状态(0:停用， 1：启用)")
    private Integer status;

	@ApiModelProperty("状态名称")
	private String statusText;
    
    @ApiModelProperty("排序")
    private Integer sort;


	public String getStatusText() {
	
		return statusText;
	}

	public void setStatusText(String statusText) {
	
		this.statusText = statusText;
	}

	public String getIssuedStatusText() {
	
		return issuedStatusText;
	}

	public void setIssuedStatusText(String issuedStatusText) {
	
		this.issuedStatusText = issuedStatusText;
	}

	public Integer getIssuedStatus() {
	
		return issuedStatus;
	}

	public void setIssuedStatus(Integer issuedStatus) {
	
		this.issuedStatus = issuedStatus;
	}

	public String getProductName() {
	
		return productName;
	}

	public void setProductName(String productName) {
	
		this.productName = productName;
	}

	public String getPlatformName() {
	
		return platformName;
	}

	public void setPlatformName(String platformName) {
	
		this.platformName = platformName;
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

	public Long getPlatformId() {
	
		return platformId;
	}

	public void setPlatformId(Long platformId) {
	
		this.platformId = platformId;
	}


	public Integer getStatus() {
	
		return status;
	}

	public void setStatus(Integer status) {
	
		this.status = status;
	}

	public Integer getSort() {
	
		return sort;
	}

	public void setSort(Integer sort) {
	
		this.sort = sort;
	}

	public Long getPositionId() {
	
		return positionId;
	}

	public void setPositionId(Long positionId) {
	
		this.positionId = positionId;
	}

	public String getPositionName() {
	
		return positionName;
	}

	public void setPositionName(String positionName) {
	
		this.positionName = positionName;
	}
}

