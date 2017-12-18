package com.yundao.tenant.model.base.product;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseProductNav extends BaseModel implements Serializable {
    /**
	 * 产品id
	 */
    private Long productId;

    /**
	 * 单位净值
	 */
    private Double unitNav;

    /**
	 * 累计净值
	 */
    private Double totalNav;

    /**
	 * 涨跌幅
	 */
    private Double upDownRate;

    /**
	 * 净值日期
	 */
    private Date navDate;

    private static final long serialVersionUID = 1L;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getUnitNav() {
        return unitNav;
    }

    public void setUnitNav(Double unitNav) {
        this.unitNav = unitNav;
    }

    public Double getTotalNav() {
        return totalNav;
    }

    public void setTotalNav(Double totalNav) {
        this.totalNav = totalNav;
    }

    public Double getUpDownRate() {
        return upDownRate;
    }

    public void setUpDownRate(Double upDownRate) {
        this.upDownRate = upDownRate;
    }

    public Date getNavDate() {
        return navDate;
    }

    public void setNavDate(Date navDate) {
        this.navDate = navDate;
    }
}