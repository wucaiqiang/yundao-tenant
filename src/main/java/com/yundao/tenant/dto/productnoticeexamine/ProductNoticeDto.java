

package com.yundao.tenant.dto.productnoticeexamine;
/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月25日 下午5:05:48 
 * @author   欧阳利
 * @version   
 */
public class ProductNoticeDto {
	/**
	 * 主键
	 */
	private Long id;
	
	private Long productId;
	
	private String productName;
	
	private String noticeTypeName;
	
	private String title;

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

	public String getNoticeTypeName() {
	
		return noticeTypeName;
	}

	public void setNoticeTypeName(String noticeTypeName) {
	
		this.noticeTypeName = noticeTypeName;
	}

	public String getTitle() {
	
		return title;
	}

	public void setTitle(String title) {
	
		this.title = title;
	}
	
}

