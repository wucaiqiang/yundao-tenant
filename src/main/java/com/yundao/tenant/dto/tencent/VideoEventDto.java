
package com.yundao.tenant.dto.tencent;

import java.util.List;

/**
 * Function: Reason: Date: 2017年11月3日 下午3:32:59
 * 
 * @author wucq
 * @version
 */
public class VideoEventDto extends VodBaseDto {

	/**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private List<EventMessageDto> eventList;

	public List<EventMessageDto> getEventList() {

		return eventList;
	}

	public void setEventList(List<EventMessageDto> eventList) {

		this.eventList = eventList;
	}

}
