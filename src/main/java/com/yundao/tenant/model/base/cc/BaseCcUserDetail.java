package com.yundao.tenant.model.base.cc;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseCcUserDetail extends BaseModel implements Serializable {
    /**
	 * 用户账号id
	 */
    private Long userAccountId;

    /**
	 * 头像
	 */
    private String avatar;

    /**
	 * 昵称
	 */
    private String nickName;

    /**
	 * 姓名
	 */
    private String realName;

    /**
	 * 1：男；2：女
	 */
    private Integer sex;

    /**
	 * 生日
	 */
    private Date birth;

    /**
	 * 微信
	 */
    private String wechat;

    /**
	 * qq
	 */
    private String qq;

    /**
	 * 邮箱
	 */
    private String email;

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

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}