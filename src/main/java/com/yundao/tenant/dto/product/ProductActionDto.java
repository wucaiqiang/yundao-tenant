package com.yundao.tenant.dto.product;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ProductActionDto {
    /**
     * 发行状态文本
     */
    @ApiModelProperty("发行状态文本")
    private String issuedStatusText;

    @ApiModelProperty("审核状态文本")
    private  String examineStatusText;
    
    @ApiModelProperty("原因")
    private String reason;
    
    @ApiModelProperty("下拉选项值")
    private List<ProductActionSelectDto> selectDtos;

	public String getIssuedStatusText() {
		return issuedStatusText;
	}

	public void setIssuedStatusText(String issuedStatusText) {
		this.issuedStatusText = issuedStatusText;
	}

	public String getExamineStatusText() {
		return examineStatusText;
	}

	public void setExamineStatusText(String examineStatusText) {
		this.examineStatusText = examineStatusText;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<ProductActionSelectDto> getSelectDtos() {
		return selectDtos;
	}

	public void setSelectDtos(List<ProductActionSelectDto> selectDtos) {
		this.selectDtos = selectDtos;
	}


    
    
    
}
