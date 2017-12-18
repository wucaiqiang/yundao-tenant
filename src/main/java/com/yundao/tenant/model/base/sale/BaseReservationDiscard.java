package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseReservationDiscard extends BaseModel implements Serializable {
    /**
	 * 预约id
	 */
    private Long reservationId;

    /**
	 * 废弃原因
	 */
    private String reason;

    private static final long serialVersionUID = 1L;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}