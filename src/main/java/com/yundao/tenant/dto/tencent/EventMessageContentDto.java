
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;
import java.util.List;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class EventMessageContentDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 版本
	 */
	private String version;
	/**
	 * 该字段表明事件通知的类型为“视频转码完成”
	 */
	private String eventType;
	/**
	 * 转码后的数据
	 */
	private Object data;
	public String getVersion() {
	
		return version;
	}
	public void setVersion(String version) {
	
		this.version = version;
	}
	public String getEventType() {
	
		return eventType;
	}
	public void setEventType(String eventType) {
	
		this.eventType = eventType;
	}
	public Object getData() {
	
		return data;
	}
	public void setData(Object data) {
	
		this.data = data;
	}
	
}
