
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;
import java.util.List;

/**
 * Function: Reason: Date: 2017年11月3日 下午7:48:10
 * 
 * @author wucq
 * @version
 */
public class VideoTransCodeInfo implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private List<TransCode> transcodeList;
	public List<TransCode> getTranscodeList() {
	
		return transcodeList;
	}
	public void setTranscodeList(List<TransCode> transcodeList) {
	
		this.transcodeList = transcodeList;
	}
	
	
}
