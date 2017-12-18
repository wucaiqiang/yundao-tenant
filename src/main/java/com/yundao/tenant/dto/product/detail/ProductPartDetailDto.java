package com.yundao.tenant.dto.product.detail;

import java.util.List;

import com.yundao.tenant.dto.field.FieldDetailDto;
import com.yundao.tenant.dto.product.attach.ProductAttachListResDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import com.yundao.tenant.dto.product.income.IncomeRuleDetailDto;
import com.yundao.tenant.dto.roadshow.RoadshowResDto;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.model.base.roadshow.BaseRoadshow;
import com.yundao.tenant.model.productnotice.ProductNoticeModel;

import io.swagger.annotations.ApiModelProperty;

public class ProductPartDetailDto extends BaseProduct {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 产品对接人名称
	 */
	private String receiverName;
	/**
	 * 对接人手机号码
	 */
	private String receiverMobile;
	/**
	 * 产品助理名称
	 */
	private String assistantName;
	/**
	 * 产品类型中文名
	 */
	private String typeName;
	/**
	 * 发行通道中文名
	 */
	private String issuedChannelText;
	/**
	 * 投资标的中文名
	 */
	private String investDomainText;
	/**
	 * 币种中文名
	 */
	private String currencyCodeText;

	private BaseProductSale productSale;
	/**
	 * 认购费
	 */
	private String proBuyFee;
	/**
	 * 管理费
	 */
	private String proManageFee;

	/**
	 * 创建人id
	 */
	private Long createUserId;

	/**
	 * 佣金规则
	 */
	private List<ProductCommissionRuleDetailDto> commissionDtos;
	/**
	 * 收益
	 */
	private List<IncomeRuleDetailDto> incomeDtos;
	/**
	 * 产品附件
	 */
	private List<ProductAttachListResDto> attachDtos;
	/**
	 * 产品公告
	 */
	private List<ProductNoticeModel> noticeModels;

	/**
	 * 审核状态( 0: 未提交; 1:已撤销; 2:审核中; 3:已驳回; 4:已通过; )
	 */
	private Integer auditStatus;
	private String issuedStatusText;

	private String levelText;

	private String riskLevelText;
	/**
	 * 产品的预约数
	 */
	private Integer reservationNum;
	/**
	 * 路演信息
	 */
	private List<RoadshowResDto> roadshows;
	@ApiModelProperty("产品信息字段")
	private List<FieldDetailDto> productFieldDtos;

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

	public String getTypeName() {

		return typeName;
	}

	public void setTypeName(String typeName) {

		this.typeName = typeName;
	}

	public BaseProductSale getProductSale() {

		return productSale;
	}

	public void setProductSale(BaseProductSale productSale) {

		this.productSale = productSale;
	}

	public List<ProductNoticeModel> getNoticeModels() {

		return noticeModels;
	}

	public void setNoticeModels(List<ProductNoticeModel> noticeModels) {

		this.noticeModels = noticeModels;
	}

	public String getProBuyFee() {

		return proBuyFee;
	}

	public void setProBuyFee(String proBuyFee) {

		this.proBuyFee = proBuyFee;
	}

	public String getProManageFee() {

		return proManageFee;
	}

	public void setProManageFee(String proManageFee) {

		this.proManageFee = proManageFee;
	}

	public String getReceiverName() {

		return receiverName;
	}

	public void setReceiverName(String receiverName) {

		this.receiverName = receiverName;
	}

	public String getAssistantName() {

		return assistantName;
	}

	public void setAssistantName(String assistantName) {

		this.assistantName = assistantName;
	}

	public String getIssuedChannelText() {

		return issuedChannelText;
	}

	public String getLevelText() {
		return levelText;
	}

	public void setLevelText(String levelText) {
		this.levelText = levelText;
	}

	public String getRiskLevelText() {
		return riskLevelText;
	}

	public void setRiskLevelText(String riskLevelText) {
		this.riskLevelText = riskLevelText;
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

	public List<ProductAttachListResDto> getAttachDtos() {

		return attachDtos;
	}

	public void setAttachDtos(List<ProductAttachListResDto> attachDtos) {

		this.attachDtos = attachDtos;
	}

	public String getCurrencyCodeText() {

		return currencyCodeText;
	}

	public void setCurrencyCodeText(String currencyCodeText) {

		this.currencyCodeText = currencyCodeText;
	}

	@Override
	public Long getCreateUserId() {
		return createUserId;
	}

	@Override
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getIssuedStatusText() {

		return issuedStatusText;
	}

	public void setIssuedStatusText(String issuedStatusText) {

		this.issuedStatusText = issuedStatusText;
	}

	public Integer getReservationNum() {

		return reservationNum;
	}

	public void setReservationNum(Integer reservationNum) {

		this.reservationNum = reservationNum;
	}

	public String getReceiverMobile() {

		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {

		this.receiverMobile = receiverMobile;
	}

	public List<RoadshowResDto> getRoadshows() {
	
		return roadshows;
	}

	public void setRoadshows(List<RoadshowResDto> roadshows) {
	
		this.roadshows = roadshows;
	}

	public List<FieldDetailDto> getProductFieldDtos() {
	
		return productFieldDtos;
	}

	public void setProductFieldDtos(List<FieldDetailDto> productFieldDtos) {
	
		this.productFieldDtos = productFieldDtos;
	}


}
