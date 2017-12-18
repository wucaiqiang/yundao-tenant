package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseShareInfo extends BaseModel implements Serializable {
    /**
	 * 类型：product:产品 product_notice:产品公告 product_attach:产品附件
	 */
    private String type;

    /**
	 * 对象ID
	 */
    private Long objectId;

    /**
	 * 描述
	 */
    private String desc;

    /**
	 * 用户id
	 */
    private Long userId;

    /**
	 * 分享地址
	 */
    private String shareUrl;

    private static final long serialVersionUID = 1L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}