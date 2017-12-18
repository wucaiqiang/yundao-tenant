
package com.yundao.tenant.dto.video;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.GJLCodeConstant;

import io.swagger.annotations.ApiModelProperty;

public class VideoAddReqDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "文件ID")
	@NotNull(message = "{" + Code1200000.CODE_1200173 + "}")
	private String fileId;
	@ApiModelProperty(value = "视频名称")
	@Length(min = 1, max = 50, message = "{" + GJLCodeConstant.CODE_1210103 + "}")
	private String name;
	@ApiModelProperty(value = "文件大小")
	@Number(isBlank = false, message = "{" + Code1200000.CODE_1200174 + "}")
	private Long size;
	@ApiModelProperty(value = "视频分类 1:路演 2：合规双录 ")
	@NotNull(message = "{" + Code1200000.CODE_1200200 + "}")
	private Integer category;
	/**
	 * 源文件地址
	 */
	@ApiModelProperty(value = "源文件地址")
	private String sourceUrl;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileId() {
	
		return fileId;
	}

	public void setFileId(String fileId) {
	
		this.fileId = fileId;
	}

	public Long getSize() {
	
		return size;
	}

	public void setSize(Long size) {
	
		this.size = size;
	}

	public Integer getCategory() {
	
		return category;
	}

	public void setCategory(Integer category) {
	
		this.category = category;
	}

	public String getSourceUrl() {
	
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
	
		this.sourceUrl = sourceUrl;
	}
	

}
