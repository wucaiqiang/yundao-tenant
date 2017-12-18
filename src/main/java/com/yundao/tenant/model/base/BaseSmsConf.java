package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsConf extends BaseModel implements Serializable {
    /**
	 * 如果未设置短信账号(sms_account无数据)，是否使用默认通道；1：是，0：否
	 */
    private Integer useDefalutChannel;

    /**
	 * 是否过滤离职员工，只针对内部员工；1：是，0：否
	 */
    private Integer isFilterDimission;

    private static final long serialVersionUID = 1L;

    public Integer getUseDefalutChannel() {
        return useDefalutChannel;
    }

    public void setUseDefalutChannel(Integer useDefalutChannel) {
        this.useDefalutChannel = useDefalutChannel;
    }

    public Integer getIsFilterDimission() {
        return isFilterDimission;
    }

    public void setIsFilterDimission(Integer isFilterDimission) {
        this.isFilterDimission = isFilterDimission;
    }
}