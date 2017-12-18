

package com.yundao.tenant.dto.smsassistantcontent;

import java.util.List;

import com.yundao.tenant.model.base.BaseSmsAssistantContent;
import com.yundao.tenant.model.base.customer.BaseCustomer;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月29日 下午6:23:31 
 * @author   wucq
 * @version   
 */
public class SmsAssistantContentResDto extends BaseSmsAssistantContent {

	
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BaseCustomer> customers;
	   /**
     * 发送状态中文
     */
    private String sendStatusText;

	public List<BaseCustomer> getCustomers() {
	
		return customers;
	}

	public void setCustomers(List<BaseCustomer> customers) {
	
		this.customers = customers;
	}

	public String getSendStatusText() {
	
		return sendStatusText;
	}

	public void setSendStatusText(String sendStatusText) {
	
		this.sendStatusText = sendStatusText;
	}
	

}

