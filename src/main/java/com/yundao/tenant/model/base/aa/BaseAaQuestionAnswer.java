package com.yundao.tenant.model.base.aa;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseAaQuestionAnswer extends BaseModel implements Serializable {
    /**
	 * 问答id
	 */
    private Long questionId;

    /**
	 * 选项id
	 */
    private Long optionId;

    /**
	 * 答题成绩id
	 */
    private Long scoreId;

    /**
	 * 答题文本，当问题类型为“文本”时填写
	 */
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}