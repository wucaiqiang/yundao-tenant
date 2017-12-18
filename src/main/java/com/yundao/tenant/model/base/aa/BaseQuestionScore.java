package com.yundao.tenant.model.base.aa;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseQuestionScore extends BaseModel implements Serializable {
    /**
	 * 用户id
	 */
    private Long userId;

    /**
	 * 客户id
	 */
    private Long customerId;

    /**
	 * 得分
	 */
    private Integer grade;

    /**
	 * 题目类型
	 */
    private Long questionTypeId;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }
}