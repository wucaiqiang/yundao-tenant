package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseProductFocus extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 用户id
	 */
    private Long userId;

    /**
	 * 关注时间
	 */
    private Date focusDate;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getFocusDate() {
        return focusDate;
    }

    public void setFocusDate(Date focusDate) {
        this.focusDate = focusDate;
    }
}