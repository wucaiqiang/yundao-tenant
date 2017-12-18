package com.yundao.tenant.dto.field;

import java.util.Date;

public class DateRangeFieldDto {
	/**
	 * 开始日期
	 */
    private Date startDate;
    /**
     * 结束日期
     */
    private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
