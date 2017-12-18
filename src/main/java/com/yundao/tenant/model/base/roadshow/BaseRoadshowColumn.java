package com.yundao.tenant.model.base.roadshow;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseRoadshowColumn extends BaseModel implements Serializable {
    /**
	 * 平台ID
	 */
    private Long platformId;

    /**
	 * 名称
	 */
    private String name;

    /**
	 * 编码
	 */
    private String code;

    /**
	 * 排序
	 */
    private Integer sequence;

    /**
	 * 状态
	 */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}