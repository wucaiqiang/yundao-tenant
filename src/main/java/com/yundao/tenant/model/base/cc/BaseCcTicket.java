package com.yundao.tenant.model.base.cc;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseCcTicket extends BaseModel implements Serializable {
    /**
	 * 用户账号id
	 */
    private Long userAccountId;

    /**
	 * 登录凭证码
	 */
    private String ticket;

    /**
	 * 存活时间，单位秒，-1代表永不过期
	 */
    private Integer activeTime;

    /**
	 * 过期时间
	 */
    private Date expireTime;

    /**
	 * 类型，1：网页，2：app
	 */
    private String type;

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Integer activeTime) {
        this.activeTime = activeTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

	public String getType() {
	
		return type;
	}

	public void setType(String type) {
	
		this.type = type;
	}

   
}