package com.yundao.tenant.dto.field;

import io.swagger.annotations.ApiModelProperty;

public class ImageDto {
	@ApiModelProperty("附件id")
	private Long id;
   /**
    * 文件名称
    */
	@ApiModelProperty("图片名称")
   private String name;
   
   /**
    * url
    */
	@ApiModelProperty("url")
   private String url;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}
   
}
