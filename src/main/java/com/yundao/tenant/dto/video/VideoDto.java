
package com.yundao.tenant.dto.video;

import java.util.List;

import com.yundao.tenant.model.base.video.BaseVideo;
import com.yundao.tenant.model.base.video.BaseVideoTranscode;

/**
 * Function: Reason: Date: 2017年11月6日 下午9:04:04
 * 
 * @author wucq
 * @version
 */
public class VideoDto extends BaseVideo {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态中文
	 */
	private String statusText;
	/**
	 * 创建人中文名
	 */
	private String createUserName;
	private List<BaseVideoTranscode> baseVideoTranscodes;

	public String getStatusText() {

		return statusText;
	}

	public void setStatusText(String statusText) {

		this.statusText = statusText;
	}

	public String getCreateUserName() {

		return createUserName;
	}

	public void setCreateUserName(String createUserName) {

		this.createUserName = createUserName;
	}

	public List<BaseVideoTranscode> getBaseVideoTranscodes() {
	
		return baseVideoTranscodes;
	}

	public void setBaseVideoTranscodes(List<BaseVideoTranscode> baseVideoTranscodes) {
	
		this.baseVideoTranscodes = baseVideoTranscodes;
	}

}
