package com.yundao.tenant.enums.user;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yundao.core.dto.dictionary.DictionaryDto;

public enum OrderStatusEnum {
	ORDER_STATUS_RESERVATION_PRODUCT_ING(0, "预约产品"),
	/**
	 * 预约产品
	 */
	ORDER_STATUS_RESERVATION_PRODUCT(10, "预约确认"),

	/**
	 * 确认打款
	 */
	ORDER_STATUS_CONFIRM_PAY(20, "确认打款"),

	/**
	 * 确认订单
	 */
	ORDER_STATUS_CONFIRM_ORDER(30, "确认订单"),

	/**
	 * 产品成立
	 */
	ORDER_STATUS_PRODUCT_ESTABLISH(40, "产品成立"),

	/**
	 * 财务回款
	 */
	ORDER_STATUS_BACK_MONEY(50, "财务回款"),

	/**
	 * 结佣
	 */
	ORDER_STATUS_COMMISSION(60, "结佣"),

	/**
	 * 已取消
	 */
	ORDER_STATUS_CANCEL(80, "已取消"),

	/**
	 * 退款中
	 */
	ORDER_STATUS_REFUNDING(70, "退款中"),

	/**
	 * 已完成
	 */
	ORDER_STATUS_COMPLETED(100, "已完成");

	private Integer value;
	private String name;
	private static Map<Integer, OrderStatusEnum> enumMap = new HashMap<Integer, OrderStatusEnum>();
	private static List<Integer> canCancelList = new ArrayList<Integer>();
	private static List<Integer> canEditList = new ArrayList<Integer>();

	static {
		EnumSet<OrderStatusEnum> set = EnumSet.allOf(OrderStatusEnum.class);
		for (OrderStatusEnum each : set) {
			enumMap.put(each.getValue(), each);
		}
		// 订单可取消的状态
		canCancelList.add(OrderStatusEnum.ORDER_STATUS_RESERVATION_PRODUCT_ING.getValue());
		canCancelList.add(OrderStatusEnum.ORDER_STATUS_RESERVATION_PRODUCT.getValue());
		canCancelList.add(OrderStatusEnum.ORDER_STATUS_CONFIRM_PAY.getValue());
		canCancelList.add(OrderStatusEnum.ORDER_STATUS_CONFIRM_ORDER.getValue());
		canCancelList.add(OrderStatusEnum.ORDER_STATUS_PRODUCT_ESTABLISH.getValue());

		// 订单可编辑的状态
		canEditList.add(OrderStatusEnum.ORDER_STATUS_RESERVATION_PRODUCT_ING.getValue());
		canEditList.add(OrderStatusEnum.ORDER_STATUS_RESERVATION_PRODUCT.getValue());
		canEditList.add(OrderStatusEnum.ORDER_STATUS_CONFIRM_PAY.getValue());
		canEditList.add(OrderStatusEnum.ORDER_STATUS_CONFIRM_ORDER.getValue());
		canEditList.add(OrderStatusEnum.ORDER_STATUS_PRODUCT_ESTABLISH.getValue());
	}

	private OrderStatusEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	/**
	 * 获取枚举
	 * 
	 * @param value
	 * @return
	 */
	public static OrderStatusEnum getOrderStatusEnum(Integer value) {
		return enumMap.get(value);
	}

	/**
	 * 获取名称
	 * 
	 * @param value
	 * @return
	 */
	public static String getName(Integer value) {
		OrderStatusEnum status = enumMap.get(value);
		if (status == null) {
			return null;
		}
		return status.getName();
	}

	/**
	 * 判断类型是否一样
	 * 
	 * @param value
	 * @return
	 */
	public boolean isEqual(Integer value) {
		OrderStatusEnum status = enumMap.get(value);
		if (status == null) {
			return false;
		}
		return this.getValue().equals(value);
	}

	/**
	 * 是否打款
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isConfirmPay(Integer value) {
		if (value == null) {
			return false;
		}
		OrderStatusEnum status = enumMap.get(value);
		if (status == null) {
			return false;
		}
		return ORDER_STATUS_CONFIRM_PAY == status;
	}

	/**
	 * 是否能够取消订单
	 * 
	 * @author chenyuanjian
	 * @param value
	 * @return
	 */
	public static boolean isCanCancelOrder(Integer value) {
		if (value == null) {
			return false;
		}
		return canCancelList.contains(value);
	}

	/**
	 * 未确认订单状态
	 * @return
	 */
	public static List<DictionaryDto> getNotConfirmed(){
		List<OrderStatusEnum> list = new ArrayList<OrderStatusEnum>();
		list.add(OrderStatusEnum.ORDER_STATUS_RESERVATION_PRODUCT_ING);
		list.add(OrderStatusEnum.ORDER_STATUS_RESERVATION_PRODUCT);
		list.add(OrderStatusEnum.ORDER_STATUS_CONFIRM_PAY);
		list.add(OrderStatusEnum.ORDER_STATUS_REFUNDING);
		
		List<DictionaryDto> dtos = new ArrayList<DictionaryDto>();
		for(OrderStatusEnum status : list){
			DictionaryDto dto = new DictionaryDto();
			dto.setCode(status.getValue().toString());
			dto.setName(status.getName());
			dtos.add(dto);
		}
		return dtos;
	}
	
	/**
	 * 已确认订单状态
	 * @return
	 */
	public static List<DictionaryDto> getConfirmed(){
		List<OrderStatusEnum> list = new ArrayList<OrderStatusEnum>();
		list.add(OrderStatusEnum.ORDER_STATUS_CONFIRM_ORDER);
		list.add(OrderStatusEnum.ORDER_STATUS_PRODUCT_ESTABLISH);
		list.add(OrderStatusEnum.ORDER_STATUS_BACK_MONEY);
		list.add(OrderStatusEnum.ORDER_STATUS_COMMISSION);
		//list.add(OrderStatusEnum.ORDER_STATUS_COMPLETED);
		
		List<DictionaryDto> dtos = new ArrayList<DictionaryDto>();
		for(OrderStatusEnum status : list){
			DictionaryDto dto = new DictionaryDto();
			dto.setCode(status.getValue().toString());
			dto.setName(status.getName());
			dtos.add(dto);
		}
		return dtos;
	}
}
