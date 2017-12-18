package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class BaseUserDetail extends BaseModel implements Serializable {
    /**
	 * 用户账号id
	 */
    private Long userAccountId;

    /**
	 * 昵称
	 */
    private String nickName;

    /**
	 * 真实姓名
	 */
    private String realName;

    /**
	 * 生日
	 */
    private Date birth;

    /**
	 * 性别，0：未知；1：男；2：女
	 */
    private Integer sex;

    /**
	 * 注册来源
	 */
    private String registerSource;

    /**
	 * 理财师名片介绍
	 */
    private String cardIntroduce;

    /**
	 * 理财师名片头衔
	 */
    private String cardHeaderBit;

    /**
	 * 理财师UUID
	 */
    private String cardUuid;

    /**
	 * 地址
	 */
    private String address;

    /**
	 * 头像
	 */
    private String avatar;

    private static final long serialVersionUID = 1L;

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(String registerSource) {
        this.registerSource = registerSource;
    }

    public String getCardIntroduce() {
        return cardIntroduce;
    }

    public void setCardIntroduce(String cardIntroduce) {
        this.cardIntroduce = cardIntroduce;
    }

    public String getCardHeaderBit() {
        return cardHeaderBit;
    }

    public void setCardHeaderBit(String cardHeaderBit) {
        this.cardHeaderBit = cardHeaderBit;
    }

    public String getCardUuid() {
        return cardUuid;
    }

    public void setCardUuid(String cardUuid) {
        this.cardUuid = cardUuid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}