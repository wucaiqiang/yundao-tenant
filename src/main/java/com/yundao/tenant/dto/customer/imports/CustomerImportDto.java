package com.yundao.tenant.dto.customer.imports;

import com.yundao.core.base.model.BaseModel;

import java.io.Serializable;

/**
 * 客户导入数据dto
 *
 * @author jan
 * @create 2017-08-31 PM3:40
 **/
public class CustomerImportDto extends BaseModel implements Serializable {

    static final long serialVersionUID = 1L;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 性别，1：男，2：女
     */
    private String sex;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 客户有效性
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 客户级别
     */
    private String level;

    /**
     * 标签
     */
    private String tag;

    /**
     * 来源
     */
    private String source;

    /**
     * 证件类型
     */
    private String credentialsType;

    /**
     * 证件号码
     */
    private String credentialsNumber;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

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

    /**
     * QQ
     */
    private String qq;

    /**
     * 银行卡账号
     */
    private String bankAccount;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 属于类型（0： 私人，1：公海）
     */
    private Integer belongType;

    public Integer getBelongType() {
        return belongType;
    }

    public void setBelongType(Integer belongType) {
        this.belongType = belongType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsNumber() {
        return credentialsNumber;
    }

    public void setCredentialsNumber(String credentialsNumber) {
        this.credentialsNumber = credentialsNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSex() {
        return sex;
    }
}

