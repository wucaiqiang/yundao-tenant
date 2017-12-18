

package com.yundao.tenant.dto.product.h5;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午1:42:17 
 * @author   欧阳利
 * @version   
 */
public class NoticeDetailDto {
	@ApiModelProperty("公告id")
	private Long id;
	
	@ApiModelProperty("标题")
    private String title;

	@ApiModelProperty("内容")
    private String content;

	@ApiModelProperty("公告类型")
    private Long noticeTypeId;
    
	@ApiModelProperty("公告类型名称")
    private String noticeTypeName;

	@ApiModelProperty("发送时间")
    private Date sendTime;
	
	@ApiModelProperty("产品id")
	private Long productId;
	
	@ApiModelProperty("产品名称")
	private String productName;
	
	@ApiModelProperty("附件集合")
	private List<NoticeAttachDto> attachDtos;
	
	
	
	public Long getId() {
	
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getTitle() {
	
		return title;
	}

	public void setTitle(String title) {
	
		this.title = title;
	}

	public String getContent() {
	
		return content;
	}

	public void setContent(String content) {
	
		this.content = content;
	}

	public Long getNoticeTypeId() {
	
		return noticeTypeId;
	}

	public void setNoticeTypeId(Long noticeTypeId) {
	
		this.noticeTypeId = noticeTypeId;
	}

	public String getNoticeTypeName() {
	
		return noticeTypeName;
	}

	public void setNoticeTypeName(String noticeTypeName) {
	
		this.noticeTypeName = noticeTypeName;
	}

	public Date getSendTime() {
	
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
	
		this.sendTime = sendTime;
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

	public List<NoticeAttachDto> getAttachDtos() {
	
		return attachDtos;
	}

	public void setAttachDtos(List<NoticeAttachDto> attachDtos) {
	
		this.attachDtos = attachDtos;
	}



	
    
}

