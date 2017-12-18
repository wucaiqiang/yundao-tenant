

package com.yundao.tenant.dto.report;

import java.io.Serializable;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月20日 下午4:06:21 
 * @author   wucq
 * @version   
 */
public class ProductReportDto implements Serializable{

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private Long productId;
	/**
	 * 总额
	 */
	private Double total;
	/**
	 * 数量
	 */
	private Integer num;
	public Long getProductId() {
	
		return productId;
	}
	public void setProductId(Long productId) {
	
		this.productId = productId;
	}
	public Double getTotal() {
	
		return total;
	}
	public void setTotal(Double total) {
	
		this.total = total;
	}
	public Integer getNum() {
	
		return num;
	}
	public void setNum(Integer num) {
	
		this.num = num;
	}
	

}

