
package com.yundao.tenant.dto.msg.msgmessage;

import java.util.Date;

import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

public class MsgMessageReqDto{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "1、代办 ，2、消息")
    @Number(message = "{" + GJLCodeConstant.CODE_1210054 + "}", isBlank = false)
    private Integer firstType;
    @ApiModelProperty(value = "开始时间")
    private Date beginDate;
    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    public Integer getFirstType() {
        return firstType;
    }

    public void setFirstType(Integer firstType) {
        this.firstType = firstType;
    }

	public Date getBeginDate() {
	
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
	
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
	
		return endDate;
	}

	public void setEndDate(Date endDate) {
	
		this.endDate = endDate;
	}
    
}
