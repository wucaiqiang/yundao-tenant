
package com.yundao.tenant.dto.customer.customerfollowup;

import java.util.ArrayList;
import java.util.List;

import com.yundao.tenant.model.base.customer.BaseCustomerFollowUp;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttach;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;

public class CustomerFollowUpPageResDto extends BaseCustomerFollowUp {
	private String typeText;

	private String statusText;
	/**
	 * 地图类型： 1:高德 2：百度
	 */
	private String mapTypeText;
	/**
	 * 创建人
	 */
	private String createUserName;
	/**
	 * 跟进记录图片
	 */
	private List<BaseCustomerFollowUpAttach> attachs;

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getMapTypeText() {

		return mapTypeText;
	}

	public void setMapTypeText(String mapTypeText) {

		this.mapTypeText = mapTypeText;
	}

	public List<BaseCustomerFollowUpAttach> getAttachs() {
		if (attachs == null) {
			attachs = new ArrayList<>();
		}
		return attachs;
	}

	public void setAttachs(List<BaseCustomerFollowUpAttach> attachs) {

		this.attachs = attachs;
	}

	public String getCreateUserName() {
	
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
	
		this.createUserName = createUserName;
	}

}
