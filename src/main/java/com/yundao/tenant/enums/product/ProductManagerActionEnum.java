package com.yundao.tenant.enums.product;

import java.util.ArrayList;
import java.util.List;

import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.product.ProductActionSelectDto;
import com.yundao.tenant.enums.product.examine.ProductExamineStatusEnum;

public enum ProductManagerActionEnum {
	/**
	 * 申请上线
	 */
    APPLY_ON_LINE(1,"申请上线"),
	
    /**
     * 取消申请上线
     */
	CANCEL_APPLY_ON_LINE(2,"取消申请"),
	
	
    /**
     * 终止发行
     */
	STOP_ISSUED(3,"终止发行"),
	
	
    /**
     * 重新申请上线
     */
	AGAIN_APPLY_ON_LINE(4,"重新申请"),
	
	
	
	/**
	 * 启动上线发行：预售
	 */
	START_UP_PRE_SAISE(5,"启动预售"),
	
	
    /**
     * 启动募集
     */
	START_RAISE(6,"启动募集"),
	
    /**
     * 启动上线发行：募集中
     */
	START_ON_LINE_RAISE_ING(7,"启动募集"),
	
	
	/**
	 * 返回上线准备
	 */
	RETURN_ON_LINE_READY(8,"暂停预售"),
	
	/**
	 * 返回上线准备(募集中到上线准备中)
	 */
	RETURN_ON_LINE_READY_FROM_RAISE(13,"暂停募集"),
	
	
    /**
     * 设为募集结束
     */
    SET_RAISE_END(9, "结束募集"),
	
	
	/**
	 * 开放申购
	 */
	OPEN_PURCHASE(10,"开放申购"),
	
	/**
	 * 设为存续/封闭
	 */
	SET_SURVIVING(11,"设为封闭中"),

	/**
	 * 设为清算退出
	 */
	SET_CLEAR_OUT(12,"清算退出");
	
	private Integer code;
	
	private String name;
	
	ProductManagerActionEnum(Integer code,String name){
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * 通过审核状态和发行状态获取操作功能
	 * @param examineStatus
	 * @param issuedStatus
	 * @return
	 */
	public static List<ProductManagerActionEnum> getManagerActionEnums(Integer examineStatus,Integer issuedStatus){
		List<ProductManagerActionEnum> list = new ArrayList<ProductManagerActionEnum>();
		if(ProductIssuedStatusEnum.SURVIVING.getValue().equals(issuedStatus)){
			list.add(SET_CLEAR_OUT);
			list.add(OPEN_PURCHASE);
		}else if(ProductIssuedStatusEnum.RAISE_END.getValue().equals(issuedStatus)){
			list.add(SET_SURVIVING);
		}else if(ProductIssuedStatusEnum.TO_RAISE.getValue().equals(issuedStatus)){
			list.add(SET_RAISE_END);
			//list.add(RETURN_ON_LINE_READY);
			list.add(RETURN_ON_LINE_READY_FROM_RAISE);
			list.add(STOP_ISSUED);
		}else if(ProductIssuedStatusEnum.PRE_SAISE.getValue().equals(issuedStatus)){
			list.add(START_RAISE);
			list.add(RETURN_ON_LINE_READY);
			list.add(STOP_ISSUED);
		}else if(ProductIssuedStatusEnum.NOT_ON_LINE.getValue().equals(issuedStatus)){
			if(ProductExamineStatusEnum.INITIAL.getValue().equals(examineStatus)){
				list.add(APPLY_ON_LINE);
			}if(ProductExamineStatusEnum.PASS.getValue().equals(examineStatus)){
				list.add(APPLY_ON_LINE);
			}else if(ProductExamineStatusEnum.APPROVALING.getValue().equals(examineStatus)){
				list.add(CANCEL_APPLY_ON_LINE);
			}else if(ProductExamineStatusEnum.REJECT.getValue().equals(examineStatus)){
				list.add(AGAIN_APPLY_ON_LINE);
				list.add(CANCEL_APPLY_ON_LINE);
			}else if(ProductExamineStatusEnum.CANCEL.getValue().equals(examineStatus)){
				list.add(APPLY_ON_LINE);
			}
		}else if(ProductIssuedStatusEnum.ON_LINE_PRE.getValue().equals(issuedStatus)){
			list.add(START_UP_PRE_SAISE);
			list.add(START_ON_LINE_RAISE_ING);
			list.add(STOP_ISSUED);
		}
		return list;
	}
	
	
	/**
	 * 检查操作是否合法
	 * @param examineStatus
	 * @param issuedStatus
	 * @param action
	 * @return
	 */
	public static boolean checkActionIsCorrect(Integer examineStatus,Integer issuedStatus,Integer action){
		if(action == null){
			return false;
		}
		List<ProductManagerActionEnum> list = getManagerActionEnums(examineStatus, issuedStatus);
		if(BooleanUtils.isEmpty(list)){
			return false;
		}
		
		for(ProductManagerActionEnum actionCode:list){
			if(actionCode.getCode().equals(action)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取下拉选择的值
	 * @param examineStatus
	 * @param issuedStatus
	 * @return
	 */
	public static List<ProductActionSelectDto> getProductActionSelectDtos(Integer examineStatus,Integer issuedStatus){
		 List<ProductManagerActionEnum> list = ProductManagerActionEnum.getManagerActionEnums(examineStatus, issuedStatus);
		 List<ProductActionSelectDto> dtos = new ArrayList<ProductActionSelectDto>();
		 if(BooleanUtils.isEmpty(list)){
			 return dtos;
		 }
		 for(ProductManagerActionEnum action : list){
			 ProductActionSelectDto dto = new ProductActionSelectDto();
			 dtos.add(dto);
			 dto.setLable(action.getName());
			 dto.setValue(action.getCode());
		 }
		 return dtos;
	}
	
	
}
