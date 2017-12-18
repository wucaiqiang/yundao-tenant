

package com.yundao.tenant.dto.product.h5;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午1:51:25 
 * @author   欧阳利
 * @version   
 */
public class NoticeAttachDto {
	@ApiModelProperty("附件id")
    private Long id;
	@ApiModelProperty("附件url")
    private String url;
	@ApiModelProperty("附件原始名称")
    private String sourceName;
	@ApiModelProperty("附件类型")
    private String type;
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
	
		this.id = id;
	}
	public String getUrl() {
	
		return url;
	}
	public void setUrl(String url) {
	
		this.url = url;
	}
	public String getSourceName() {
	
		return sourceName;
	}
	public void setSourceName(String sourceName) {
	
		this.sourceName = sourceName;
	}
	public String getType() {
	
		return type;
	}
	public void setType(String type) {
	
		this.type = type;
	}
	
}

