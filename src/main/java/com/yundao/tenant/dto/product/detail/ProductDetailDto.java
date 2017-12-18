package com.yundao.tenant.dto.product.detail;

import java.util.List;

import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import com.yundao.tenant.dto.product.income.IncomeRuleDetailDto;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;

import io.swagger.annotations.ApiModelProperty;

public class ProductDetailDto {

	@ApiModelProperty("产品id")
    private Long id;
	
	@ApiModelProperty("类别id")
	private Long typeId;
	
	@ApiModelProperty("类别名称")
	private String typeIdText;
	
	@ApiModelProperty("是否关注(1:关注,0:没有关注)")
	private Integer isFocus;
	
	@ApiModelProperty("产品信息字段")
	private List<FieldDetailDto> productFieldDtos;
	
	@ApiModelProperty("销售信息")
	private List<FieldDetailDto> productSaleFieldDtos;
	
	@ApiModelProperty("产品附件列表")
	private  List<ProductAttachListResDto> attachDtos;
	
	/**
	 * 佣金规则
	 */
	@ApiModelProperty("佣金规则")
	private List<ProductCommissionRuleDetailDto> commissionDtos;
	
	/**
	 * 收益
	 */
	@ApiModelProperty("收益")
	private List<IncomeRuleDetailDto> incomeDtos;
	
	/**
	 * 供应商报价
	 */
	@ApiModelProperty("供应商报价")
	private List<ProductSupplierQuotationDetailDto> supplierDtos;
	
	@ApiModelProperty("创建者id")
	private Long createUserId;
    @ApiModelProperty("发行状态")
    private Integer issuedStatus;
    @ApiModelProperty("发行状态文本")
    private String issuedStatusText;
    @ApiModelProperty("审核状态")
    private  Integer examineStatus;
    @ApiModelProperty("审核状态文本")
    private  String examineStatusText;

	public Integer getIssuedStatus() {
		return issuedStatus;
	}

	public void setIssuedStatus(Integer issuedStatus) {
		this.issuedStatus = issuedStatus;
	}

	public String getIssuedStatusText() {
		return issuedStatusText;
	}

	public void setIssuedStatusText(String issuedStatusText) {
		this.issuedStatusText = issuedStatusText;
	}

	public Integer getExamineStatus() {
		return examineStatus;
	}

	public void setExamineStatus(Integer examineStatus) {
		this.examineStatus = examineStatus;
	}

	public String getExamineStatusText() {
		return examineStatusText;
	}

	public void setExamineStatusText(String examineStatusText) {
		this.examineStatusText = examineStatusText;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getIsFocus() {
		return isFocus;
	}

	public void setIsFocus(Integer isFocus) {
		this.isFocus = isFocus;
	}

	public List<FieldDetailDto> getProductSaleFieldDtos() {
		return productSaleFieldDtos;
	}

	public void setProductSaleFieldDtos(List<FieldDetailDto> productSaleFieldDtos) {
		this.productSaleFieldDtos = productSaleFieldDtos;
	}

	public List<ProductCommissionRuleDetailDto> getCommissionDtos() {
		return commissionDtos;
	}

	public void setCommissionDtos(List<ProductCommissionRuleDetailDto> commissionDtos) {
		this.commissionDtos = commissionDtos;
	}

	public List<IncomeRuleDetailDto> getIncomeDtos() {
		return incomeDtos;
	}

	public void setIncomeDtos(List<IncomeRuleDetailDto> incomeDtos) {
		this.incomeDtos = incomeDtos;
	}

	public List<ProductSupplierQuotationDetailDto> getSupplierDtos() {
		return supplierDtos;
	}

	public void setSupplierDtos(List<ProductSupplierQuotationDetailDto> supplierDtos) {
		this.supplierDtos = supplierDtos;
	}

	public List<FieldDetailDto> getProductFieldDtos() {
		return productFieldDtos;
	}

	public void setProductFieldDtos(List<FieldDetailDto> productFieldDtos) {
		this.productFieldDtos = productFieldDtos;
	}


	public List<ProductAttachListResDto> getAttachDtos() {
		return attachDtos;
	}

	public void setAttachDtos(List<ProductAttachListResDto> attachDtos) {
		this.attachDtos = attachDtos;
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

}
