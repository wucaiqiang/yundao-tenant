

package com.yundao.tenant.dto.cms.product.recommend;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:08:30 
 * @author   欧阳利
 * @version   
 */
public class RecommendUpdateReqDto {
	
	@ApiModelProperty("id")
	private Long id;
	@ApiModelProperty("产品id")
    private Long productId;

	@ApiModelProperty("平台id")
    private Long platformId;

	@ApiModelProperty("位置(1:热门产品， 2：产品列表)")
    private Long positionId;

	@ApiModelProperty("状态(0:停用， 1：启用)")
    private Integer status;

	@ApiModelProperty("排序")
    private Integer sort;

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


	public Long getPositionId() {
	
		return positionId;
	}

	public void setPositionId(Long positionId) {
	
		this.positionId = positionId;
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
}

