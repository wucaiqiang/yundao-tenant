package com.yundao.tenant.enums.msg;

/**
 * Created by gjl on 2017/8/14.
 */
public enum MsgMessageTypeEnum {
    MESSAGE_TYPE_1(1, "动态"),
    MESSAGE_TYPE_2(2, "消息");
    private Integer type;
    private String name;

    MsgMessageTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
