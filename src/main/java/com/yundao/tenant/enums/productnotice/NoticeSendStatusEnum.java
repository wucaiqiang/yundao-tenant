package com.yundao.tenant.enums.productnotice;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gjl on 2017/7/18.
 */
public enum NoticeSendStatusEnum {
    SEND_0(0,"未发送"),
    SEND_1(1,"发送");
    NoticeSendStatusEnum(Integer status, String name){
        this.status = status;
        this.name = name;
    }

    Integer status;
    String name;


    private static Map<Integer, NoticeSendStatusEnum> enumMap = new HashMap<Integer, NoticeSendStatusEnum>();

    static {
        EnumSet<NoticeSendStatusEnum> set = EnumSet.allOf(NoticeSendStatusEnum.class);
        for (NoticeSendStatusEnum each : set) {
            enumMap.put(each.getStatus(), each);
        }
    }

    public static NoticeSendStatusEnum getNoticeStatusEnum(Integer value) {
        return enumMap.get(value);
    }
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}





	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
