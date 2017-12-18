
package com.yundao.tenant.dto.productnotice;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

public class ProductNoticePageReqDto {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "1代表我发起的，默认为所有")
    private Integer type;

    @ApiModelProperty(value = "审核状态")
    private Integer status;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "公告类型ids,多个时，隔开")
    private String noticeTypeIds;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品id")
    private Long productId;

    @ApiModelProperty(value = "是否发布")
    private Integer isSend;
    
    @ApiModelProperty(value = "申请人姓名")
    private String applyUserRealName;

    @ApiModelProperty("创建人名称")
    private String createUserRealName;
    
    
    public String getCreateUserRealName() {
	
		return createUserRealName;
	}

	public void setCreateUserRealName(String createUserRealName) {
	
		this.createUserRealName = createUserRealName;
	}
    
    public String getApplyUserRealName() {
	
		return applyUserRealName;
	}

	public void setApplyUserRealName(String applyUserRealName) {
	
		this.applyUserRealName = applyUserRealName;
	}

	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoticeTypeIds() {
        return noticeTypeIds;
    }

    public void setNoticeTypeIds(String noticeTypeIds) {
        this.noticeTypeIds = noticeTypeIds;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
