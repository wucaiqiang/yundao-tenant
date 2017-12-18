
package com.yundao.tenant.dto.tencent;

import java.io.Serializable;
import java.util.List;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class EventMessageDto implements Serializable {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private String msgHandle;
	private EventMessageContentDto eventContent;
	public String getMsgHandle() {
	
		return msgHandle;
	}
	public void setMsgHandle(String msgHandle) {
	
		this.msgHandle = msgHandle;
	}
	public EventMessageContentDto getEventContent() {
	
		return eventContent;
	}
	public void setEventContent(EventMessageContentDto eventContent) {
	
		this.eventContent = eventContent;
	}

}
