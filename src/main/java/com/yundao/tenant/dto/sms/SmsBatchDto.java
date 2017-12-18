package com.yundao.tenant.dto.sms;

/**
 * 短信批次dto
 *
 * @author jan
 * @create 2017-06-18 PM7:43
 **/
public class SmsBatchDto {

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 此批次需要发送的手机号码
     */
    private String mobiles;

    /**
     * 发送短信的结果
     */
    private String resultCode;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getMobiles() {
        return mobiles;
    }

    public void setMobiles(String mobiles) {
        this.mobiles = mobiles;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
