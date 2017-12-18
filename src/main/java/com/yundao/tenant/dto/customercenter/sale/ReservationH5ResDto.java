

package com.yundao.tenant.dto.customercenter.sale;

import java.util.Date;
import java.util.List;

import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午3:51:13 
 * @author   欧阳利
 * @version   
 */
public class ReservationH5ResDto {
	
	@ApiModelProperty("销售线索id")
    private Long id;
	
	@ApiModelProperty("预约时间")
	private Date reservationDate;
	
	@ApiModelProperty("产品id")
	private Long productId;

	@ApiModelProperty("产品名称")
	private String productName;
	
	@ApiModelProperty("产品类型")
	private Long productTypeId;
	
	@ApiModelProperty("产品类型名称")
	private String productTypeName;
	
	@ApiModelProperty("投资期限")
	private String productTimeLimit;
	
	@ApiModelProperty("产品亮点")
	private String productHighlight;

	@ApiModelProperty("收益规则")
	private List<ProductIncomeRuleDto> prIncomeRuleDtos;
	
	public List<ProductIncomeRuleDto> getPrIncomeRuleDtos() {
		return prIncomeRuleDtos;
	}

	public void setPrIncomeRuleDtos(List<ProductIncomeRuleDto> prIncomeRuleDtos) {
		this.prIncomeRuleDtos = prIncomeRuleDtos;
	}

	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public Date getReservationDate() {
	
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
	
		this.reservationDate = reservationDate;
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

	public Long getProductTypeId() {
	
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
	
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
	
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
	
		this.productTypeName = productTypeName;
	}



	public String getProductTimeLimit() {
	
		return productTimeLimit;
	}

	public void setProductTimeLimit(String productTimeLimit) {
	
		this.productTimeLimit = productTimeLimit;
	}

	public String getProductHighlight() {
	
		return productHighlight;
	}

	public void setProductHighlight(String productHighlight) {
	
		this.productHighlight = productHighlight;
	}

	
	
	
}

