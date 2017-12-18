package com.yundao.tenant.service.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.field.FiledSelectDto;
import com.yundao.tenant.dto.product.ProductCenterListReqDto;
import com.yundao.tenant.dto.product.ProductCenterListResDto;
import com.yundao.tenant.dto.sale.declaration.ProductDeclarationAmountDto;
import com.yundao.tenant.dto.sale.reservation.ProductReservationAmountDto;
import com.yundao.tenant.enums.bo.ProductTableFieldEnum;
import com.yundao.tenant.enums.product.DeclarationModelEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.mapper.product.ProductSelectMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.mapper.sale.reservation.ReservationMapper;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.service.field.FieldSelectService;
import com.yundao.tenant.service.product.ProductCenterService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.util.CalendarUtils;
import com.yundao.tenant.util.SymbolStrUtils;

@Service
public class ProductCenterServiceImpl extends AbstractService  implements ProductCenterService {

	@Autowired
	ProductSelectMapper productSelectMapper;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	FieldSelectService fieldSelectService;
	
	@Autowired
	ReservationMapper reservationMapper;
	
	@Autowired
	DeclarationMapper declarationMapper;
	
	/**
	 * 分页查询产品中心列表
	 */
	@Override
	public Result<PaginationSupport<ProductCenterListResDto>> gets(ProductCenterListReqDto reqDto)
			throws BaseException {
		PaginationSupport<ProductCenterListResDto> result = reqDto.getPaginationSupport();
		// 重置参数
		resetParam(reqDto);

		if(BooleanUtils.isEmpty(reqDto.getIssuedStatusList())){
			return Result.newSuccessResult(result);
		}
		
		int totalCount = productSelectMapper.getProductCenterListCount(reqDto);
		if(totalCount > 0){
			 List<ProductCenterListResDto> datas = productSelectMapper.getProductCenterList(reqDto);
			 result.setDatas(datas);
			 resetManagerListReturnData(datas);
			 // 设置预约和报单操作按钮的控制和提示信息
			 setReservationAndReservation(datas);
		}
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}
	
	/**
	 * 设置预约和报单操作按钮的控制和提示信息
	 * setReservationAndReservation:
	 * @author: 欧阳利
	 * @param datas
	 * @description:
	 */
	private void setReservationAndReservation(List<ProductCenterListResDto> datas){
		if(BooleanUtils.isEmpty(datas)){
			return ;
		}
		
		// 预约
		for(ProductCenterListResDto dto : datas){
			if(ProductIssuedStatusEnum.RAISE_END.getValue().equals(dto.getIssuedStatus())
					|| ProductIssuedStatusEnum.SURVIVING.getValue().equals(dto.getIssuedStatus())
					|| ProductIssuedStatusEnum.CLEAR_OUT.getValue().equals(dto.getIssuedStatus())){
				dto.setCanReservation(false);
				dto.setNotCanReservationTitle("该产品募集结束, 无法预约");
				continue;
			}
			
			if(ProductIssuedStatusEnum.TO_RAISE.getValue().equals(dto.getIssuedStatus()) &&
					DeclarationModelEnum.DECLARATION.getValue().equals(dto.getDeclarationModel())){
				dto.setCanReservation(false);
				dto.setNotCanReservationTitle("该产品可以直接报单");
				continue;
			}
			
			if(!ProductIssuedStatusEnum.PRE_SAISE.getValue().equals(dto.getIssuedStatus()) &&
					!ProductIssuedStatusEnum.TO_RAISE.getValue().equals(dto.getIssuedStatus())	){
				dto.setCanReservation(false);
				dto.setNotCanReservationTitle("该产品不是预售或者募集中");
				continue;
			}

			dto.setCanReservation(true);
		}
		
		// 报单
		for(ProductCenterListResDto dto : datas){
			if(ProductIssuedStatusEnum.RAISE_END.getValue().equals(dto.getIssuedStatus())
					|| ProductIssuedStatusEnum.SURVIVING.getValue().equals(dto.getIssuedStatus())
					|| ProductIssuedStatusEnum.CLEAR_OUT.getValue().equals(dto.getIssuedStatus())){
				dto.setCanDeclaration(false);
				dto.setNotCanDeclarationTitle("该产品募集结束, 无法报单");
				continue;
			}
			if(ProductIssuedStatusEnum.PRE_SAISE.getValue().equals(dto.getIssuedStatus())){
				dto.setCanDeclaration(false);
				dto.setNotCanDeclarationTitle("预售状态, 请先预约");
				continue;
			}
			
			if(!ProductIssuedStatusEnum.TO_RAISE.getValue().equals(dto.getIssuedStatus())){
				dto.setCanDeclaration(false);
				dto.setNotCanDeclarationTitle("该产品不是募集中");
				continue;
			}
			
			if(DeclarationModelEnum.RESERVATION_AND_DECLARATION.getValue().equals(dto.getDeclarationModel())
					&& !dto.getExistPassReservation()	){
				dto.setCanDeclaration(false);
				dto.setNotCanDeclarationTitle("请先预约, 审批通过后转报单");
				continue;
			}
			dto.setCanDeclaration(true);
		}
	}
	
	
	/**
	 * 重置查询产品管理列表返回结束数据
	 *
	 * @param datas
	 */
	private void resetManagerListReturnData(List<ProductCenterListResDto> datas) {
		if(BooleanUtils.isEmpty(datas)){
			return;
		}
		// 重置用户信息
		resetManagerListReturnDataUserInfo(datas);

		List<Long> allProductIds = new ArrayList<Long>();
		// 设置状态文本
		for (ProductCenterListResDto dto : datas) {
			dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(dto.getIssuedStatus()));
			allProductIds.add(dto.getId());
		}

		// 设置字段的文本信息
		List<FiledSelectDto> filedSelectDtos = getlevelAndRiskLevelSelect();
		for (ProductCenterListResDto dto : datas) {
			dto.setLevelText(FiledSelectDto.getSelectLableName(filedSelectDtos,
					ProductTableFieldEnum.LEVEL.getPropertyName(), dto.getLevel()));
			dto.setRiskLevelText(FiledSelectDto.getSelectLableName(filedSelectDtos,
					ProductTableFieldEnum.RISK_LEVEL.getPropertyName(), dto.getRiskLevel()));
		}

		if(BooleanUtils.isEmpty(allProductIds)){
			return;
		}
		
		// 设置是否包含审核通过预约
		List<Long> passProductIds =  reservationMapper.selectPassReserProductIdsByProductIds(allProductIds,this.getHeaderUserId());
		for (ProductCenterListResDto dto : datas) {
			if(passProductIds.contains(dto.getId())){
				dto.setExistPassReservation(true);
			}else{
				dto.setExistPassReservation(false);
			}
		}
		
		// 设置预约金额
		List<ProductReservationAmountDto> productAmounts = reservationMapper.getProductReservationAmountDtos(allProductIds);
		if(!BooleanUtils.isEmpty(productAmounts)){
			for (ProductCenterListResDto dto : datas) {
				 for(ProductReservationAmountDto amountDto : productAmounts){
					 if(dto.getId().equals(amountDto.getProductId())){
						 if(amountDto.getSumAmount() != null){
							 dto.setReservationAmount(SymbolStrUtils.doubleToString(amountDto.getSumAmount()));
						 }
						
					 }
				 }
			}
		}
		
		// 设置报单金额
		List<ProductDeclarationAmountDto> declarationAmountDtos =  declarationMapper.getProductDeclarationAmountDtos(allProductIds);
		if(!BooleanUtils.isEmpty(declarationAmountDtos)){
			for (ProductCenterListResDto dto : datas) {
				 for(ProductDeclarationAmountDto amountDto : declarationAmountDtos){
					 if(dto.getId().equals(amountDto.getProductId())){
						 if(amountDto.getSumAmount() != null){
							 dto.setDeclarationAmount(SymbolStrUtils.doubleToString(amountDto.getSumAmount()));
						 }
					 }
				 }
			}
		}
		
	}
	
    /**
     * 获取等级和风险等级的下拉选项值
     *
     * @return
     */
    public List<FiledSelectDto> getlevelAndRiskLevelSelect() {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add(ProductTableFieldEnum.LEVEL.getFieldName());
        fieldNames.add(ProductTableFieldEnum.RISK_LEVEL.getFieldName());

        List<FiledSelectDto> list = fieldSelectService.getFiledSelectConfigs(fieldNames);
        ProductTableFieldEnum.resetFiledSelectPropertyName(list);
        return list;
    }
	
	/**
	 * 重置用户信息(对接人, 产品助理)
	 *
	 * @param datas
	 */
	private void resetManagerListReturnDataUserInfo(List<ProductCenterListResDto> datas) {
		// 设置产品助理和产品对接人姓名
		List<Long> userIds = new ArrayList<Long>();
		for (ProductCenterListResDto dto : datas) {
			if (!userIds.contains(dto.getReceiverId())) {
				userIds.add(dto.getReceiverId());
			}
			if (!userIds.contains(dto.getAssistantId())) {
				userIds.add(dto.getAssistantId());
			}
		}
		List<BaseUserDetail> userList = userDetailService.getUserDetail(userIds);
		for (ProductCenterListResDto dto : datas) {
			if (dto.getReceiverId() != null) {
				for (BaseUserDetail model : userList) {
					if (dto.getReceiverId().equals(model.getId())) {
						dto.setReceiverRealName(model.getRealName());
					}
				}
			}
			if (dto.getAssistantId() != null) {
				for (BaseUserDetail model : userList) {
					if (dto.getAssistantId().equals(model.getId())) {
						dto.setAssistantRealName(model.getRealName());
					}
				}
			}
		}

	}
	
	
	private void resetParam(ProductCenterListReqDto reqDto){
		List<Integer> allIssuedStatusList = ProductIssuedStatusEnum.getProductCenterStatus();
		// 产品范围(全部：0, 在售：1, 我关注的：2)
		if(reqDto.getProductRange() != null && reqDto.getProductRange() == 1){
			allIssuedStatusList = ProductIssuedStatusEnum.getProductCenterSaleStatus();
		}else if(reqDto.getProductRange() != null && reqDto.getProductRange() == 2){
			reqDto.setUserId(this.getHeaderUserId());
		}
		reqDto.setIssuedStatusList(allIssuedStatusList);
		
		if(!BooleanUtils.isBlank(reqDto.getTypeIds())){
			String[] typeIdList =  reqDto.getTypeIds().split(",");
			if(!BooleanUtils.isEmpty(typeIdList)){
				reqDto.setTypeIdList(typeIdList);
			}
		}
		
		
		if(!BooleanUtils.isBlank(reqDto.getLevels())){
			String[] levelList =  reqDto.getLevels().split(",");
			if(!BooleanUtils.isEmpty(levelList)){
				reqDto.setLevelList(levelList);
			}
		}
		
		if(!BooleanUtils.isBlank(reqDto.getRiskLevels())){
			String[] riskLevelList =  reqDto.getRiskLevels().split(",");
			if(!BooleanUtils.isEmpty(riskLevelList)){
				reqDto.setRiskLevelList(riskLevelList);
			}
		}
		
		if(!BooleanUtils.isBlank(reqDto.getIssuedStatuss())){
			String[] issuedStatusList =  reqDto.getIssuedStatuss().split(",");
			if(!BooleanUtils.isEmpty(issuedStatusList)){
				List<Integer> currentIssuedStatusList = new  ArrayList<Integer>();
				for(String issuedStatus:issuedStatusList){
					if(allIssuedStatusList.contains(Integer.valueOf(issuedStatus))){
						currentIssuedStatusList.add(Integer.valueOf(issuedStatus));
					}
				}
				reqDto.setIssuedStatusList(currentIssuedStatusList);
			}
		}
		if(reqDto.getOnLineTimeStart() != null){
			reqDto.setOnLineTimeStart(CalendarUtils.getCurrentDayBeginTime(reqDto.getOnLineTimeStart()));
		}
		if(reqDto.getOnLineTimeEnd() != null){
			reqDto.setOnLineTimeEnd(CalendarUtils.getCurrentDateEndTime(reqDto.getOnLineTimeEnd()));
		}
		
		// 设置排序
		resetParamOrderBy(reqDto);
	}
	
	
	/**
	 * 设置排序
	 * @param reqDto
	 */
	private void resetParamOrderBy(ProductCenterListReqDto reqDto){
		if(reqDto == null ){
			return;
		}
		if(BooleanUtils.isBlank(reqDto.getOrderColumn()) ){
			reqDto.setOrderColumn(" p.on_line_time");
			reqDto.setSort("desc");
			return ;
		}
		
		if(BooleanUtils.isBlank(reqDto.getSort()) ){
			reqDto.setSort("asc");
		}else if(reqDto.getSort().trim().equals("asc")){
			reqDto.setSort("asc");
		}else if(reqDto.getSort().trim().equals("desc")){
			reqDto.setSort("desc");
		}else{
			reqDto.setSort("asc");
		}
		
		if(reqDto.getOrderColumn().equals("levels")){
			if(reqDto.getSort().trim().equals("asc")){
				reqDto.setOrderColumn("IF(p.level='' OR p.level IS NULL,9999,level)");
			}else if(reqDto.getSort().trim().equals("desc")){
				reqDto.setOrderColumn("IF(p.level='' OR p.level IS NULL,-9999,level)");
			}
		}else if(reqDto.getOrderColumn().equals("riskLevels")){
			reqDto.setOrderColumn("p.risk_level");
		}else if(reqDto.getOrderColumn().equals("productScale")){
			reqDto.setOrderColumn("ps.product_scale");
		}else if(reqDto.getOrderColumn().equals("createDate")){
			reqDto.setOrderColumn(" p.create_date");
		}else if(reqDto.getOrderColumn().equals("onLineTime")){
			reqDto.setOrderColumn("p.on_line_time");
		}
		

	}
}
