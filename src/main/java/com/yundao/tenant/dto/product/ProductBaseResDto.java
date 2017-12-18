package com.yundao.tenant.dto.product;

import java.io.Serializable;
import java.util.List;

import com.yundao.tenant.dto.product.add.ProductCommissionRuleDto;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.model.base.product.BaseProductSale;

import io.swagger.annotations.ApiModelProperty;

public class ProductBaseResDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品id")
	private Long id;

	@ApiModelProperty("产品名称")
	private String name;
	@ApiModelProperty("产品类型")
	private Long typeId;
	@ApiModelProperty("产品类型名称")
	private String typeName;
	@ApiModelProperty("发行通道")
	private String issuedChannel;
	@ApiModelProperty("发行通道中文")
	private String issuedChannelText;
	@ApiModelProperty("投资标的")
	private String investDomain;
	@ApiModelProperty("投资标的中文")
	private String investDomainText;
	@ApiModelProperty("投资期限")
	private String timeLimit;
	@ApiModelProperty("认购起点")
	private Double buyStartPoint;
	@ApiModelProperty("递增金额")
	private Double incrementalAmount;
	@ApiModelProperty("产品创建人")
	private Long createUserId;
	@ApiModelProperty("是否有规模")
	private Integer isScale;
	@ApiModelProperty("产品规模")
	private Double productScale;
	@ApiModelProperty("产品发行状态")
	private Integer issuedStatus;
	@ApiModelProperty("报单模式")
	private Integer declarationModel;
	@ApiModelProperty("投资币种")
	private Double currencyCode;
	@ApiModelProperty("投资币种中文")
	private String currencyCodeText;
	@ApiModelProperty("预约数")
	private Integer reservationNum;
	@ApiModelProperty("预约总额")
	private Double reservationTotal;
	@ApiModelProperty("报单总额")
	private Double declarationTotal;
	@ApiModelProperty("收益规则")
	private List<ProductIncomeRuleDto> prIncomeRuleDtos;
	@ApiModelProperty("佣金规则")
	private List<ProductCommissionRuleDto> commissionRuleDtos;

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

	public Long getTypeId() {

		return typeId;
	}

	public void setTypeId(Long typeId) {

		this.typeId = typeId;
	}

	public String getTypeName() {

		return typeName;
	}

	public void setTypeName(String typeName) {

		this.typeName = typeName;
	}

	public String getIssuedChannel() {

		return issuedChannel;
	}

	public void setIssuedChannel(String issuedChannel) {

		this.issuedChannel = issuedChannel;
	}

	public String getInvestDomain() {

		return investDomain;
	}

	public void setInvestDomain(String investDomain) {

		this.investDomain = investDomain;
	}

	public String getTimeLimit() {

		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {

		this.timeLimit = timeLimit;
	}

	public List<ProductIncomeRuleDto> getPrIncomeRuleDtos() {

		return prIncomeRuleDtos;
	}

	public void setPrIncomeRuleDtos(List<ProductIncomeRuleDto> prIncomeRuleDtos) {

		this.prIncomeRuleDtos = prIncomeRuleDtos;
	}

	public List<ProductCommissionRuleDto> getCommissionRuleDtos() {

		return commissionRuleDtos;
	}

	public void setCommissionRuleDtos(List<ProductCommissionRuleDto> commissionRuleDtos) {

		this.commissionRuleDtos = commissionRuleDtos;
	}

	public Long getCreateUserId() {

		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {

		this.createUserId = createUserId;
	}

	public String getIssuedChannelText() {

		return issuedChannelText;
	}

	public void setIssuedChannelText(String issuedChannelText) {

		this.issuedChannelText = issuedChannelText;
	}

	public String getInvestDomainText() {

		return investDomainText;
	}

	public void setInvestDomainText(String investDomainText) {

		this.investDomainText = investDomainText;
	}

	public Double getBuyStartPoint() {

		return buyStartPoint;
	}

	public void setBuyStartPoint(Double buyStartPoint) {

		this.buyStartPoint = buyStartPoint;
	}

	public Double getIncrementalAmount() {

		return incrementalAmount;
	}

	public void setIncrementalAmount(Double incrementalAmount) {

		this.incrementalAmount = incrementalAmount;
	}

	public Double getProductScale() {

		return productScale;
	}

	public void setProductScale(Double productScale) {

		this.productScale = productScale;
	}

	public Double getCurrencyCode() {

		return currencyCode;
	}

	public void setCurrencyCode(Double currencyCode) {

		this.currencyCode = currencyCode;
	}

	public Integer getIsScale() {

		return isScale;
	}

	public void setIsScale(Integer isScale) {

		this.isScale = isScale;
	}

	public String getCurrencyCodeText() {

		return currencyCodeText;
	}

	public void setCurrencyCodeText(String currencyCodeText) {

		this.currencyCodeText = currencyCodeText;
	}

	public Double getReservationTotal() {

		return reservationTotal;
	}

	public void setReservationTotal(Double reservationTotal) {

		this.reservationTotal = reservationTotal;
	}

	public Double getDeclarationTotal() {

		return declarationTotal;
	}

	public void setDeclarationTotal(Double declarationTotal) {

		this.declarationTotal = declarationTotal;
	}

	public Integer getIssuedStatus() {
	
		return issuedStatus;
	}

	public void setIssuedStatus(Integer issuedStatus) {
	
		this.issuedStatus = issuedStatus;
	}

	public Integer getDeclarationModel() {
	
		return declarationModel;
	}

	public void setDeclarationModel(Integer declarationModel) {
	
		this.declarationModel = declarationModel;
	}

	public Integer getReservationNum() {
	
		return reservationNum;
	}

	public void setReservationNum(Integer reservationNum) {
	
		this.reservationNum = reservationNum;
	}
	

}
