package com.yundao.tenant.model.base.sale;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseDeclarationVideo extends BaseModel implements Serializable {
    /**
	 * 报单id
	 */
    private Long declarationId;

    /**
	 * 视频id
	 */
    private Long videoId;

    /**
	 * 视频类型(1:合规双录)
	 */
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Long getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(Long declarationId) {
        this.declarationId = declarationId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}