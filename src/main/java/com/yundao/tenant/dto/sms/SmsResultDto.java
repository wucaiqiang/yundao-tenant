package com.yundao.tenant.dto.sms;

import java.io.Serializable;
import java.util.List;

/**
 * 短信发送结果
 *
 * @author jan
 * @create 2017-06-18 PM7:41
 **/
public class SmsResultDto implements Serializable {

    /**
     * 流水号
     */
    private String seqNo;

    /**
     * 批次号
     */
    private List<SmsBatchDto> batchs;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public List<SmsBatchDto> getBatchs() {
        return batchs;
    }

    public void setBatchs(List<SmsBatchDto> batchs) {
        this.batchs = batchs;
    }

}
