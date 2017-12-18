package com.yundao.tenant.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsResponse extends BaseModel implements Serializable {
    /**
	 * 模版CODE
	 */
    private String templateCode;

    /**
	 * 模版参数
	 */
    private String templateParam;

    /**
	 * 流水号
	 */
    private String seqId;

    /**
	 * 业务id，发送回执id
	 */
    private String bizId;

    /**
	 * 状态码
	 */
    private String code;

    /**
	 * 状态码描述
	 */
    private String message;

    private static final long serialVersionUID = 1L;

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}