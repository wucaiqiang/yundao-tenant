package com.yundao.tenant.dto.product;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划产品下拉选项
 *
 * @author jan
 * @create 2017-10-12 16:27
 **/
public class ProductSelectionForDeclaration {

    @ApiModelProperty(value = "产品id")
    private Long id;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "发行状态")
    private Long issuedStatus;

    @ApiModelProperty(value = "募集形式")
    private String declarationModel;

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

	public Long getIssuedStatus() {
	
		return issuedStatus;
	}

	public void setIssuedStatus(Long issuedStatus) {
	
		this.issuedStatus = issuedStatus;
	}

	public String getDeclarationModel() {
	
		return declarationModel;
	}

	public void setDeclarationModel(String declarationModel) {
	
		this.declarationModel = declarationModel;
	}

}
