package com.yundao.tenant.dto.product.h5;

import java.util.List;

import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.income.IncomeRuleDetailDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.model.base.roadshow.BaseRoadshow;

import io.swagger.annotations.ApiModelProperty;


public class ProductH5DetailDto {

	@ApiModelProperty("产品id")
    private Long id;
	
	@ApiModelProperty("类别id")
	private Long typeId;
	
	@ApiModelProperty("类别名称")
	private String typeIdText;
	
	@ApiModelProperty("产品名称")
	private String name;
	
	@ApiModelProperty("投资期限")
    private String timeLimit;
	
	@ApiModelProperty("简要亮点")
    private String highlight;
	
	@ApiModelProperty("认购起点")
	private Double buyStartPoint;
	
	@ApiModelProperty("产品信息字段")
	private List<FieldDetailDto> productFieldDtos;
	
	@ApiModelProperty("收益")
	private List<IncomeRuleDetailDto> incomeDtos;
	
	@ApiModelProperty("公告")
	private List<ProductNoticeDto> noticeDtos;
	@ApiModelProperty("附件")
	private List<ProductAttachListResDto> attachDtos;
	@ApiModelProperty("路演")
	private List<RoadshowResDto> roadshows;
	

	public Double getBuyStartPoint() {
	
		return buyStartPoint;
	}

	public void setBuyStartPoint(Double buyStartPoint) {
	
		this.buyStartPoint = buyStartPoint;
	}

	public List<ProductNoticeDto> getNoticeDtos() {
	
		return noticeDtos;
	}

	public void setNoticeDtos(List<ProductNoticeDto> noticeDtos) {
	
		this.noticeDtos = noticeDtos;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}



	public String getTimeLimit() {
	
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
	
		this.timeLimit = timeLimit;
	}

	public String getHighlight() {
	
		return highlight;
	}

	public void setHighlight(String highlight) {
	
		this.highlight = highlight;
	}


	public List<IncomeRuleDetailDto> getIncomeDtos() {
		return incomeDtos;
	}

	public void setIncomeDtos(List<IncomeRuleDetailDto> incomeDtos) {
		this.incomeDtos = incomeDtos;
	}


	public List<FieldDetailDto> getProductFieldDtos() {
		return productFieldDtos;
	}

	public void setProductFieldDtos(List<FieldDetailDto> productFieldDtos) {
		this.productFieldDtos = productFieldDtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeIdText() {
		return typeIdText;
	}

	public void setTypeIdText(String typeIdText) {
		this.typeIdText = typeIdText;
	}

	public List<ProductAttachListResDto> getAttachDtos() {
	
		return attachDtos;
	}

	public void setAttachDtos(List<ProductAttachListResDto> attachDtos) {
	
		this.attachDtos = attachDtos;
	}

	public List<RoadshowResDto> getRoadshows() {
	
		return roadshows;
	}

	public void setRoadshows(List<RoadshowResDto> roadshows) {
	
		this.roadshows = roadshows;
	}

}
