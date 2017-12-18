package com.yundao.tenant.dto.product.h5;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductH5BaseQueryReqDto extends AbstractBasePageDto{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品名称")
    private String name;
	
	/**
	 * 产品的发行状态列表
	 */
	private List<Integer> issuedStatusList;
	
	@ApiModelProperty("平台code")
	@NotNull(message = "{" + CodeConstant.CODE_1200166 + "}")
	private String platformCode;
	
	@ApiModelProperty("位置code")
	@NotNull(message = "{" + CodeConstant.CODE_1200167 + "}")
	private String positionCode;
	
	private Long platformId;
	
	private Long positionId;
	
	public String getPlatformCode() {
	
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
	
		this.platformCode = platformCode;
	}

	public String getPositionCode() {
	
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
	
		this.positionCode = positionCode;
	}

	public Long getPlatformId() {
	
		return platformId;
	}

	public void setPlatformId(Long platformId) {
	
		this.platformId = platformId;
	}

	public Long getPositionId() {
	
		return positionId;
	}

	public void setPositionId(Long positionId) {
	
		this.positionId = positionId;
	}

	public void addIssuedStatus(Integer issuedStatus){
		if(issuedStatusList == null){
			issuedStatusList = new ArrayList<Integer>();
		}
		issuedStatusList.add(issuedStatus);
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	public List<Integer> getIssuedStatusList() {
	
		return issuedStatusList;
	}

	public void setIssuedStatusList(List<Integer> issuedStatusList) {
	
		this.issuedStatusList = issuedStatusList;
	}


    
}
