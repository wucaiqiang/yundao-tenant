package com.yundao.tenant.enums.productnotice;

import com.yundao.tenant.enums.sms.SmsExtendTypeEnum;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gjl on 2017/7/18.
 */
public enum NoticeStatusEnum {
    STATUS_1(1,"未申请","2"),
    STATUS_2(2,"申请审批","3,4,5"),
    STATUS_3(3,"已通过",null),
    STATUS_4(4,"已驳回","2,5"),
    STATUS_5(5,"已撤销","2");
    NoticeStatusEnum(Integer status,String name,String nextStatus){
        this.status = status;
        this.name = name;
        this.nextStatus = nextStatus;
    }

    Integer status;
    String name;
    String nextStatus;


    private static Map<Integer, NoticeStatusEnum> enumMap = new HashMap<Integer, NoticeStatusEnum>();

    static {
        EnumSet<NoticeStatusEnum> set = EnumSet.allOf(NoticeStatusEnum.class);
        for (NoticeStatusEnum each : set) {
            enumMap.put(each.getStatus(), each);
        }
    }

    public static NoticeStatusEnum getNoticeStatusEnum(Integer value) {
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

    public String getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }
}
