package com.yundao.tenant.dto.product.h5;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ProductNoticeDto  implements Serializable {

    
	private static final long serialVersionUID = 1L;
	
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

   

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

	public String getNoticeTypeName() {
	
		return noticeTypeName;
	}

	public void setNoticeTypeName(String noticeTypeName) {
	
		this.noticeTypeName = noticeTypeName;
	}



    
}