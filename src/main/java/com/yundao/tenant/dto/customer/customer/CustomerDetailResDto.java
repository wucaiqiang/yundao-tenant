
package com.yundao.tenant.dto.customer.customer;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.yundao.tenant.dto.common.DataAndPermissionDto;
import com.yundao.tenant.model.base.customer.BaseTag;

import io.swagger.annotations.ApiModelProperty;

/**
 * Function: Reason: Date: 2017年8月9日 上午11:00:38
 * 
 * @author wucq
 * @version
 */
public class CustomerDetailResDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 客户ID
	 */
	private Long id;
	/**
	 * 客户名称
	 */
	private String name;
	private String mobile;
	/**
	 * 客户编号
	 */
	private String number;
	/**
	 * 用户所属理财师ID
	 */
	private Long userId;
	/**
	 * 用户所属理财师名称
	 */
	private String afpName;
	/**
	 * 是否关注
	 */
	private boolean focus;
	/**
	 * 客户标签
	 */
	private List<BaseTag> tags;
	@ApiModelProperty("风险测评结果")
	private String riskText;
	/**
	 * 客户联系方式
	 */
	private DataAndPermissionDto contact;
	/**
	 * 除了联系方式外其它资料
	 */
	private DataAndPermissionDto info;

	@ApiModelProperty("客户状态")
	private Integer status;
	@ApiModelProperty("客户状态名称")
	private String statusText;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public boolean isFocus() {

		return focus;
	}

	public void setFocus(boolean focus) {

		this.focus = focus;
	}

	public List<BaseTag> getTags() {

		return tags;
	}

	public void setTags(List<BaseTag> tags) {

		this.tags = tags;
	}

	public DataAndPermissionDto getContact() {

		return contact;
	}

	public void setContact(DataAndPermissionDto contact) {

		this.contact = contact;
	}

	public DataAndPermissionDto getInfo() {

		return info;
	}

	public void setInfo(DataAndPermissionDto info) {

		this.info = info;
	}

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public String getMobile() {

		return mobile;
	}

	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String number) {

		this.number = number;
	}

	public String getRiskText() {
	
		return riskText;
	}

	public void setRiskText(String riskText) {
	
		this.riskText = riskText;
	}

	public String getAfpName() {
	
		return afpName;
	}

	public void setAfpName(String afpName) {
	
		this.afpName = afpName;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
