
package com.yundao.tenant.dto.sale.declaration;

import java.util.Date;
import java.util.List;

import com.yundao.tenant.dto.FileDto;
import com.yundao.tenant.dto.customer.attach.CustomerAttachDto;
import com.yundao.tenant.dto.customer.credentials.CustomerCredentialsDto;
import com.yundao.tenant.dto.video.VideoDto;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationCompliance;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;
import com.yundao.tenant.model.base.sale.BaseReservation;

public class DeclarationResDto extends BaseDeclaration {
	private String customerName;
	private String userName;

	private Long productId;
	private String productName;
	// 产品类型
	private String productTypeId;
	private String productTypeName;
	// 产品期限
	private String productTime;
	// 产品成立时间
	private Date productCreateDate;
	// 产品公告id
	private Long productNoticeId;
	// 产品公告名称
	private String productNoticeName;
	// 预约信息
	private BaseReservation reservation;
	// 客户资产证明
	private List<CustomerAttachDto> customerAttachDtos;
	// 银行卡信息
	private BaseCustomerBank customerBank;
	// 证件信息
	private CustomerCredentialsDto customerCredentials;
	// 资产证明
	private List<FileDto> declarationAttachs;
	// 打款凭证
	private List<FileDto> voucher;
	// 合同附件
	private List<FileDto> contractFile;
	// 合规双录
	private List<VideoDto> complianceRecord;
	// 投资者基本信息表（自然人）
	private List<BaseDeclarationCompliance> baseInfo;
	// 投资者风险匹配告知书及投资者确认函
	private List<BaseDeclarationCompliance> riskNotify;
	// 风险承受能力调查问卷（自然人）
	private List<BaseDeclarationCompliance> riskQuesstionnaire;
	// 基金回访确认书
	private List<BaseDeclarationCompliance> returnConfirmation;
	// 其他合规文件
	private List<BaseDeclarationCompliance> otherFile;
	// 合规文件模板下载
	private String complianceFile;
	// 状态文本
	private String statusText;

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BaseCustomerBank getCustomerBank() {
		return customerBank;
	}

	public void setCustomerBank(BaseCustomerBank customerBank) {
		this.customerBank = customerBank;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Date getProductCreateDate() {
		return productCreateDate;
	}

	public void setProductCreateDate(Date productCreateDate) {
		this.productCreateDate = productCreateDate;
	}

	public Long getProductNoticeId() {
		return productNoticeId;
	}

	public void setProductNoticeId(Long productNoticeId) {
		this.productNoticeId = productNoticeId;
	}

	public String getProductNoticeName() {
		return productNoticeName;
	}

	public void setProductNoticeName(String productNoticeName) {
		this.productNoticeName = productNoticeName;
	}

	public CustomerCredentialsDto getCustomerCredentials() {
		return customerCredentials;
	}

	public void setCustomerCredentials(CustomerCredentialsDto customerCredentials) {
		this.customerCredentials = customerCredentials;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTime() {
		return productTime;
	}

	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}

	@Override
	public Long getProductId() {
		return productId;
	}

	@Override
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<FileDto> getDeclarationAttachs() {
		return declarationAttachs;
	}

	public void setDeclarationAttachs(List<FileDto> declarationAttachs) {
		this.declarationAttachs = declarationAttachs;
	}

	public List<FileDto> getVoucher() {
		return voucher;
	}

	public void setVoucher(List<FileDto> voucher) {
		this.voucher = voucher;
	}

	public List<FileDto> getContractFile() {
		return contractFile;
	}

	public void setContractFile(List<FileDto> contractFile) {
		this.contractFile = contractFile;
	}

	public List<VideoDto> getComplianceRecord() {

		return complianceRecord;
	}

	public void setComplianceRecord(List<VideoDto> complianceRecord) {

		this.complianceRecord = complianceRecord;
	}

	public List<BaseDeclarationCompliance> getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(List<BaseDeclarationCompliance> baseInfo) {
		this.baseInfo = baseInfo;
	}

	public List<BaseDeclarationCompliance> getRiskNotify() {
		return riskNotify;
	}

	public void setRiskNotify(List<BaseDeclarationCompliance> riskNotify) {
		this.riskNotify = riskNotify;
	}

	public List<BaseDeclarationCompliance> getRiskQuesstionnaire() {
		return riskQuesstionnaire;
	}

	public void setRiskQuesstionnaire(List<BaseDeclarationCompliance> riskQuesstionnaire) {
		this.riskQuesstionnaire = riskQuesstionnaire;
	}

	public List<BaseDeclarationCompliance> getReturnConfirmation() {
		return returnConfirmation;
	}

	public void setReturnConfirmation(List<BaseDeclarationCompliance> returnConfirmation) {
		this.returnConfirmation = returnConfirmation;
	}

	public List<BaseDeclarationCompliance> getOtherFile() {
		return otherFile;
	}

	public void setOtherFile(List<BaseDeclarationCompliance> otherFile) {
		this.otherFile = otherFile;
	}

	public String getComplianceFile() {
		return complianceFile;
	}

	public void setComplianceFile(String complianceFile) {
		this.complianceFile = complianceFile;
	}

	public BaseReservation getReservation() {

		return reservation;
	}

	public void setReservation(BaseReservation reservation) {

		this.reservation = reservation;
	}

	public List<CustomerAttachDto> getCustomerAttachDtos() {

		return customerAttachDtos;
	}

	public void setCustomerAttachDtos(List<CustomerAttachDto> customerAttachDtos) {

		this.customerAttachDtos = customerAttachDtos;
	}


}
