package com.yundao.tenant.dto.product.add;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.yundao.tenant.constant.code.CodeConstant;

import io.swagger.annotations.ApiModelProperty;


/**
 * 产品添加请求
 * 
 * @author 欧阳利
 * 2017年7月5日
 */
public class ProductAddReqDto {
    /**
	 * 产品类型编码
	 */
	@ApiModelProperty(value="产品类型id")
	@NotNull(message = "{" + CodeConstant.CODE_1200044 + "}")
    private Long typeId;

    /**
	 * 产品名称
	 */
    @ApiModelProperty(value="产品名称")
    private String name;

    /**
	 * 发行通道
	 */
    @ApiModelProperty(value="发行通道")
    private String issuedChannel;

    /**
	 * 投资标的
	 */
    @ApiModelProperty(value="投资标的")
    private String investDomain;

    /**
	 * 投资期限
	 */
    @ApiModelProperty(value="投资期限")
    private String timeLimit;

    /**
	 * 管理机构
	 */
    @ApiModelProperty(value="管理机构")
    private String mechanism;

    /**
	 * 认购起点
	 */
    @ApiModelProperty(value="认购起点")
    private Double buyStartPoint;

    /**
	 * 递增金额
	 */
    @ApiModelProperty(value="递增金额")
    private Double incrementalAmount;

    /**
	 * 投资人数上限
	 */
    @ApiModelProperty(value="投资人数上限")
    private Integer buyPersonLimit;

    /**
	 * 产品等级
	 */
    @ApiModelProperty(value=" 产品等级")
    private String level;

    /**
	 * 风险等级
	 */
    @ApiModelProperty(value=" 风险等级")
    private String riskLevel;

    /**
	 * 产品对接人
	 */
    @ApiModelProperty(value=" 产品对接人")
    private Long receiverId;

    /**
	 * 产品助理
	 */
    @ApiModelProperty(value=" 产品助理")
    private Long assistantId;

    /**
	 * 简要亮点
	 */
    @ApiModelProperty(value=" 简要亮点")
    private String highlight;

    /**
	 * 拟销售日期开始日期
	 */
    @ApiModelProperty(value=" 拟销售日期开始日期")
    private Date saleStartDate;

    /**
	 * 拟销售日期结束日期
	 */
    @ApiModelProperty(value="拟销售日期结束日期")
    private Date saleEndDate;

    /**
	 * 是否有规模
	 */
    @ApiModelProperty(value="是否有规模")
    private Integer isScale;

    /**
	 * 产品规模
	 */
    @ApiModelProperty(value="产品规模")
    private Double productScale;

    /**
	 * 投资币种
	 */
    @ApiModelProperty(value="投资币种")
    private String currencyCode;

    /**
	 * 打款账号
	 */
    @ApiModelProperty(value="打款账号")
    private String payAccount;
    
    /**
	 * 开户名
	 */
    @ApiModelProperty(value="开户名")
    private String accountName;

    /**
	 * 募集银行
	 */
    @ApiModelProperty(value=" 募集银行")
    private String raiseBank;

    /**
	 * 募集银行
	 */
    @ApiModelProperty(value="募集银行")
    private String payRemark;
    
    /**
	 * 微信版内容
	 */
    @ApiModelProperty(value="募集银行")
    private String wxContent;

    /**
     * 产品附件集合
     */
    @ApiModelProperty(value="产品附件集合: [{ \"sourceName\": '文件名称', \"url\": 'url',\"type\": '附件类型',\"showType\":'可见性：1：内部可见 2：外部可见 0或null：全部可见' }]")
    private String attachDtos;
    
    /**
     * 产品供应商报价
     */
    @ApiModelProperty(value="产品供应商报价: [{ \"supplierName(供应商名称)\": '', \"remark(备注)\": '',\"productQuotationDtos(单个报价详情)\": "
    		+ "[{ \"saleMax(销售金额最大)\": '', \"saleMin(销售金额最小)\": '',\"commissionType(佣金类型)\": '',\"frontCommission(前端)\": '',\"backCommission(后端)\": '' }] }]")
    private String supplierDtos;
    
    /**
     * 消息佣金
     */
    @ApiModelProperty(value="消息佣金: [{ \"ruleName(规则名称)\": '', \"remark(备注)\": '',\"productCommissionDtos(单个规则详情)\": "
    		+ "[{ \"saleMax(销售金额最大)\": '', \"saleMin(销售金额最小)\": '',\"commissionType(佣金类型)\": '',\"frontCommission(前端)\": '',\"backCommission(后端)\": '' }] }]")
    private String commissionDtos;
    
    /**
     * 产品收益规则
     */
    @ApiModelProperty(value="产品收益规则: [{ \"ruleName(规则名称)\": '', \"remark(备注)\": '',\"productIncomeDtos(单个规则详情)\": "
    		+ "[{ \"buyMax(认购最大值)\": '', \"buyMin(认购最小值)\": '',\"buyTimeLimit(认购期限)\": '',\"incomeType(收益类型)\": '',\"fixIncomeRate(收益率)\": '',\"floatIncomeRate(浮动收益)\": '' }] }]")
    private String incomeDtos;
    
    @ApiModelProperty(value="到期日期")
    private Date maturityDate;
    
	public Date getMaturityDate() {
	
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
	
		this.maturityDate = maturityDate;
	}

	public String getIncomeDtos() {
		return incomeDtos;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getRaiseBank() {
		return raiseBank;
	}

	public void setRaiseBank(String raiseBank) {
		this.raiseBank = raiseBank;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	public String getWxContent() {
		return wxContent;
	}

	public void setWxContent(String wxContent) {
		this.wxContent = wxContent;
	}

	public void setIncomeDtos(String incomeDtos) {
		this.incomeDtos = incomeDtos;
	}

	public String getAttachDtos() {
		return attachDtos;
	}

	public void setAttachDtos(String attachDtos) {
		this.attachDtos = attachDtos;
	}

	public String getSupplierDtos() {
		return supplierDtos;
	}

	public void setSupplierDtos(String supplierDtos) {
		this.supplierDtos = supplierDtos;
	}

	public String getCommissionDtos() {
		return commissionDtos;
	}

	public void setCommissionDtos(String commissionDtos) {
		this.commissionDtos = commissionDtos;
	}
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMechanism() {
		return mechanism;
	}

	public void setMechanism(String mechanism) {
		this.mechanism = mechanism;
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

	public Integer getBuyPersonLimit() {
		return buyPersonLimit;
	}

	public void setBuyPersonLimit(Integer buyPersonLimit) {
		this.buyPersonLimit = buyPersonLimit;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Long getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Long assistantId) {
		this.assistantId = assistantId;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public Date getSaleStartDate() {
		return saleStartDate;
	}

	public void setSaleStartDate(Date saleStartDate) {
		this.saleStartDate = saleStartDate;
	}

	public Date getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(Date saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public Integer getIsScale() {
		return isScale;
	}

	public void setIsScale(Integer isScale) {
		this.isScale = isScale;
	}

	public Double getProductScale() {
		return productScale;
	}

	public void setProductScale(Double productScale) {
		this.productScale = productScale;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}


}
