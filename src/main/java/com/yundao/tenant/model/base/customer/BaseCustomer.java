package com.yundao.tenant.model.base.customer;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseCustomer extends BaseModel implements Serializable {
    /**
	 * 姓名
	 */
    private String name;

    /**
	 * 性别(1：男，2：女)
	 */
    private Integer sex;

    /**
	 * 客户编号
	 */
    private String number;

    /**
	 * 手机号码
	 */
    private String mobile;

    /**
	 * 邮箱
	 */
    private String email;

    /**
	 * 客户级别(1：A[最重要]，2：[重要]，3：[普通]，4[沉默])
	 */
    private Integer level;

    /**
	 * 风险特征（1：保守型，2：适度保守型，3：平衡型，4：适度进取型，5：进取型）
	 */
    private Integer riskRating;

    /**
	 * 投资人类型（1：普通投资人，2：专业投资人）
	 */
    private Integer type;

    /**
	 * 客户来源（1：自我开发，2：客户转介绍，3：市场活动，4：其他）
	 */
    private Integer source;

    /**
	 * 客户状态（0：未确认，1：有效，2：无效）
	 */
    private Integer status;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 属于类型（0： 私人，1：公海）
	 */
    private Integer belongType;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(Integer riskRating) {
        this.riskRating = riskRating;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getBelongType() {
        return belongType;
    }

    public void setBelongType(Integer belongType) {
        this.belongType = belongType;
    }
}