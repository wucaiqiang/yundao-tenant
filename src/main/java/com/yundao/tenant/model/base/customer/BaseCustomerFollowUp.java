package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseCustomerFollowUp extends BaseModel implements Serializable {
    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 跟进方式
	 */
    private Integer type;

    /**
	 * 跟进状态
	 */
    private Integer status;

    /**
	 * 跟进内容
	 */
    private String content;

    /**
	 * 地图类型： 1:高德 2：百度
	 */
    private Integer mapType;

    /**
	 * 经度
	 */
    private Double itudeX;

    /**
	 * 纬度
	 */
    private Double itudeY;

    /**
	 * 地址
	 */
    private String address;

    /**
	 * 下次跟进时间
	 */
    private Date nextFollowDate;

    /**
	 * 下次跟进是否生成消息，1未生成，2生成。
	 */
    private Integer nextMessageSend;

    private static final long serialVersionUID = 1L;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMapType() {
        return mapType;
    }

    public void setMapType(Integer mapType) {
        this.mapType = mapType;
    }

    public Double getItudeX() {
        return itudeX;
    }

    public void setItudeX(Double itudeX) {
        this.itudeX = itudeX;
    }

    public Double getItudeY() {
        return itudeY;
    }

    public void setItudeY(Double itudeY) {
        this.itudeY = itudeY;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getNextFollowDate() {
        return nextFollowDate;
    }

    public void setNextFollowDate(Date nextFollowDate) {
        this.nextFollowDate = nextFollowDate;
    }

    public Integer getNextMessageSend() {
        return nextMessageSend;
    }

    public void setNextMessageSend(Integer nextMessageSend) {
        this.nextMessageSend = nextMessageSend;
    }
}