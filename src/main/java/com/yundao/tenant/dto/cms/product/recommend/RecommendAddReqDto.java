

package com.yundao.tenant.dto.cms.product.recommend;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:08:30 
 * @author   欧阳利
 * @version   
 */
public class RecommendAddReqDto {

	@ApiModelProperty("产品id")
	@NotNull(message = "{" + CodeConstant.CODE_1200041 + "}")
    private Long productId;

	@ApiModelProperty("平台id")
	@NotNull(message = "{" + CodeConstant.CODE_1200159 + "}")
    private Long platformId;

	@ApiModelProperty("位置")
	@NotNull(message = "{" + CodeConstant.CODE_1200160 + "}")
    private Long positionId;

	@ApiModelProperty("状态(0:停用， 1：启用)")
	@NotNull(message = "{" + CodeConstant.CODE_1200161 + "}")
    private Integer status;

	@ApiModelProperty("排序")
    private Integer sort;

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

