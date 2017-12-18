package com.yundao.tenant.dto.sale.leads;

/**
 * 线索添加数据请求dto
 *
 * @author jan
 * @create 2017-09-07 PM2:56
 **/
public class LeadsAddReqDto {

    /**
     * 类型，值请参考 LeadsTypeEnum 枚举
     */
    private Integer type;

    /**
     * 渠道（如：网站、服务和、APP），由调用的接口可决定
     */
    private Integer channel;

    /**
     * 内容
     */
    private String content;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
