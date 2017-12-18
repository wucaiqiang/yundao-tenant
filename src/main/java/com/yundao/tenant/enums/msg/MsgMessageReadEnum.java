package com.yundao.tenant.enums.msg;

/**
 * Created by gjl on 2017/8/14.
 */
public enum MsgMessageReadEnum {
    MESSAGE_READ_1(1, "未读"),
    MESSAGE_TYPE_2(2, "已读");
    private Integer type;
    private String name;

    MsgMessageReadEnum(Integer type, String name) {
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
