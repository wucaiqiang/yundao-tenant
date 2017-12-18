package com.yundao.tenant.model.base.platform;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BasePlatformPositionRef extends BaseModel implements Serializable {
    /**
	 * 平台id
	 */
    private Long platformId;

    /**
	 * 位置id
	 */
    private Long positionId;

    private static final long serialVersionUID = 1L;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }
}