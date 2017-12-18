package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseCustomerDetail extends BaseModel implements Serializable {
    /**
	 * 生日
	 */
    private Date birthday;

    /**
	 * 微信
	 */
    private String wechat;

    /**
	 * qq
	 */
    private String qq;

    /**
	 * 省份
	 */
    private String provinceCode;

    /**
	 * 市
	 */
    private String cityCode;

    /**
	 * 地址
	 */
    private String address;

    /**
	 * 行业
	 */
    private String trade;

    /**
	 * 机构
	 */
    private String organization;

    /**
	 * 职位
	 */
    private String position;

    private static final long serialVersionUID = 1L;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}