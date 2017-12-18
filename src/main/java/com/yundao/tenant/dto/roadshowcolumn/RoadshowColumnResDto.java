
package com.yundao.tenant.dto.roadshowcolumn;

import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumn;

/**
 * Function: Reason: Date: 2017年11月9日 上午10:13:40
 * 
 * @author wucq
 * @version
 */
public class RoadshowColumnResDto extends BaseRoadshowColumn {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 平台名
	 */
	private String platformName;
	/**
	 * 平台code
	 */
	private String platformCode;
	/**
	 * 操作人
	 */
	private String updateUserName;
	/**
	 * 状态中文
	 */
	private String statusText;

	public String getPlatformName() {

		return platformName;
	}

	public void setPlatformName(String platformName) {

		this.platformName = platformName;
	}

	public String getUpdateUserName() {

		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {

		this.updateUserName = updateUserName;
	}

	public String getStatusText() {

		return statusText;
	}

	public void setStatusText(String statusText) {

		this.statusText = statusText;
	}

	public String getPlatformCode() {
	
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
	
		this.platformCode = platformCode;
	}
	

}
