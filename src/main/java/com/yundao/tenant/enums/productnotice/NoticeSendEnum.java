package com.yundao.tenant.enums.productnotice;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gjl on 2017/7/18.
 */
public enum NoticeSendEnum {
    SEND_0(0,"不是定时发送"),
    SEND_1(1,"是定时发送");
    NoticeSendEnum(Integer status, String name){
        this.status = status;
        this.name = name;
    }

    Integer status;
    String name;


    private static Map<Integer, NoticeSendEnum> enumMap = new HashMap<Integer, NoticeSendEnum>();

    static {
        EnumSet<NoticeSendEnum> set = EnumSet.allOf(NoticeSendEnum.class);
        for (NoticeSendEnum each : set) {
            enumMap.put(each.getStatus(), each);
        }
    }

    public static NoticeSendEnum getNoticeStatusEnum(Integer value) {
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
