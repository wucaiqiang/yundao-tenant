package com.yundao.tenant.service.product.commission.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.add.ProductCommissionDto;
import com.yundao.tenant.dto.product.add.ProductCommissionRuleDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionDetailDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleDetailDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionRuleUpdateDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionUpdateDto;
import com.yundao.tenant.mapper.base.product.BaseProductCommissionRuleMapper;
import com.yundao.tenant.model.base.product.BaseProductCommission;
import com.yundao.tenant.model.base.product.BaseProductCommissionRule;
import com.yundao.tenant.model.base.product.BaseProductCommissionRuleExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.product.commission.ProductCommissionRuleService;
import com.yundao.tenant.service.product.commission.ProductCommissionService;

@Service
public class ProductCommissionRuleServiceImpl extends AbstractService implements ProductCommissionRuleService {
	
	@Autowired
	ProductCommissionService productCommissionService;

	@Autowired
	BaseProductCommissionRuleMapper baseProductCommissionRuleMapper;


	/**
	 * 添加产品佣金信
	 * @param commissionDtos
	 * @param productId
	 * @return
	 */
	@Override
	public Result<Integer> saveCommissionDtos(List<ProductCommissionRuleDto> commissionDtos, Long productId)
			throws Exception {
		if(BooleanUtils.isEmpty(commissionDtos)){
			return Result.newSuccessResult(0);
		}
		
		for(ProductCommissionRuleDto dto:commissionDtos){
			BaseProductCommissionRule record = new BaseProductCommissionRule();
			record.setRemark(dto.getRemark());
			record.setRuleName(dto.getRuleName());
			record.setProductId(productId);
			record.setCreateDate(new Date());
			record.setCreateUserId(this.getHeaderUserId());
			record.setTenantId(this.getHeaderTenantId());
			record.setIsDelete(0);
			baseProductCommissionRuleMapper.insert(record);
			
			productCommissionService.addProductCommissionDtos(dto.getProductCommissionDtos(), record.getId());
		}
		
		return Result.newSuccessResult(commissionDtos.size());
	}
	
	public Result<Integer> saveProductCommissionRuleUpdateDto(ProductCommissionRuleUpdateDto dto, Long productId)
			throws Exception {
		
		BaseProductCommissionRule record = new BaseProductCommissionRule();
		record.setRemark(dto.getRemark());
		record.setRuleName(dto.getRuleName());
		record.setProductId(productId);
		record.setCreateDate(new Date());
		record.setCreateUserId(this.getHeaderUserId());
		record.setTenantId(this.getHeaderTenantId());
		record.setIsDelete(0);
		baseProductCommissionRuleMapper.insert(record);
		
		productCommissionService.addProductCommissionUpdateDtos(dto.getProductCommissionDtos(), record.getId());
		return Result.newSuccessResult(1);
	}

	
	/**
	 * 对象转换
	 * @param request
	 * @return
	 * @throws BaseException
	 */
	public List<ProductCommissionRuleDto> getProductCommissionRuleDto(String commissionDtos) throws BaseException{
		if(BooleanUtils.isBlank(commissionDtos)){
			return null;
		}
		JavaType javaType = JsonUtils.getCollectionType(List.class, ProductCommissionRuleDto.class);
		List<ProductCommissionRuleDto> list = JsonUtils.jsonToObject(commissionDtos, javaType);
		return list;
	}
	
	
	/**
	 * 对象转换
	 * @param commissionDtos
	 * @return
	 * @throws BaseException
	 */
	public List<ProductCommissionRuleUpdateDto> getProductCommissionRuleUpdateDtos(String commissionDtos) throws BaseException{
		if(BooleanUtils.isBlank(commissionDtos)){
			return null;
		}
		JavaType javaType = JsonUtils.getCollectionType(List.class, ProductCommissionRuleUpdateDto.class);
		List<ProductCommissionRuleUpdateDto> list = JsonUtils.jsonToObject(commissionDtos, javaType);
		return list;
	}
	
	
	/**
	 * 修改产品佣金规则列表
	 * @param commissionDtos
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public Result<Integer> updateCommissionDtos(List<ProductCommissionRuleUpdateDto>  commissionDtos,Long productId)throws Exception{
		if(BooleanUtils.isEmpty(commissionDtos)){
			// 删除产品的所有佣金队长
			return null;
		}
		// 查询所有的
		List<BaseProductCommissionRule> allList =  getCommissionRule(productId);
		for(ProductCommissionRuleUpdateDto dto:commissionDtos){
			if(dto.getId() == null){
				// 添加
				saveProductCommissionRuleUpdateDto(dto,  productId);
			}else{
				// 修改备注
				updateRemark(dto.getId(),dto.getRemark());
				// 修改
				productCommissionService.updateProductCommissionUpdateDto(dto.getProductCommissionDtos(),dto.getId());
			}
		}
		
		
		List<Long> needDeleteIds = getNeedDeleteIds(allList,commissionDtos);
		delete(needDeleteIds);
		return Result.newSuccessResult(1);
	}

	/**
	 * 编辑备注
	 * @param id
	 * @param remark
	 */
	private void updateRemark(Long id,String remark){
		BaseProductCommissionRule record = new  BaseProductCommissionRule();
		record.setRemark(remark);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
        BaseProductCommissionRuleExample example = new BaseProductCommissionRuleExample();
        example.createCriteria().andIdEqualTo(id);
		baseProductCommissionRuleMapper.updateByExampleSelective(record, example);
	}
	
	
	/**
	 * 删除佣金规则列表
	 * @param ids
	 * @return
	 */
	public Result<Integer> delete(List<Long> ids)throws Exception{
		if(BooleanUtils.isEmpty(ids)){
			return Result.newSuccessResult(0);
		}
		BaseProductCommissionRule record = new BaseProductCommissionRule();
		record.setIsDelete(1);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		BaseProductCommissionRuleExample example = new BaseProductCommissionRuleExample();
		example.createCriteria().andIdIn(ids);
		int count = baseProductCommissionRuleMapper.updateByExampleSelective(record, example);
		
		productCommissionService.deleteCommissionRuleIds(ids);
		return Result.newSuccessResult(count);
	}
	
	
	
	/**
	 * 获取需要删除的id集合
	 * @param commissionDtos
	 * @param rules
	 * @return
	 */
	private List<Long> getNeedDeleteIds( List<BaseProductCommissionRule> allList,List<ProductCommissionRuleUpdateDto> rules){
		if(BooleanUtils.isEmpty(allList)){
			return null;
		}
		
		List<Long> allIds = new ArrayList<Long>();
		for(BaseProductCommissionRule dto: allList){
			allIds.add(dto.getId());
		}
		
		if(BooleanUtils.isEmpty(rules)){
			return allIds;
		}
		
		List<Long> currentIds = new ArrayList<Long>();
		for(ProductCommissionRuleUpdateDto dto: rules){
			if(dto.getId()!= null){
				currentIds.add(dto.getId());
			}
		}
		
		List<Long> ids = new ArrayList<Long>();
		for(Long id:allIds){
			if(!currentIds.contains(id)){
				ids.add(id);
			}
		}
		
		return ids;
		
	}
	
	
	/**
	 * 查询产品的佣金规则列表
	 * @param productId
	 * @return
	 */
	private List<BaseProductCommissionRule> getCommissionRule(Long productId){
		BaseProductCommissionRuleExample example = new BaseProductCommissionRuleExample();
		example.createCriteria().andProductIdEqualTo(productId);
		return baseProductCommissionRuleMapper.selectByExample(example);
	}
	
	
	/**
	 * 获取产品的佣金信息
	 * @param productId
	 * @return
	 * @throws Exception
	 */
    public List<ProductCommissionRuleDetailDto> getCommissionRuleDetailDtos(Long productId)throws Exception{
    	List<BaseProductCommissionRule> rules = this.getCommissionRule(productId);
    	if(BooleanUtils.isEmpty(rules)){
    		return null;
    	}
    	// 获取收益规则
    	List<ProductCommissionRuleDetailDto> commissionRuleDtos = new ArrayList<ProductCommissionRuleDetailDto>();
    	List<Long> commissionRuleIds = new ArrayList<Long>();
    	for(BaseProductCommissionRule dto:rules){
    		ProductCommissionRuleDetailDto commissionRuleDto = new ProductCommissionRuleDetailDto();
    		BeanUtils.copyProperties(dto, commissionRuleDto);
    		commissionRuleIds.add(dto.getId());
    		commissionRuleDtos.add(commissionRuleDto);
    	}
    	//  获取收益详情
        List<BaseProductCommission> baseProductCommissions =  productCommissionService.getBaseProductCommissions(commissionRuleIds);
        if(BooleanUtils.isEmpty(baseProductCommissions)){
    		return commissionRuleDtos;
    	}
        List<ProductCommissionDetailDto>  productCommissionDetailDtos = new ArrayList<ProductCommissionDetailDto>();
    	for(BaseProductCommission base : baseProductCommissions){
    		ProductCommissionDetailDto productCommissionDto = new ProductCommissionDetailDto();
    		BeanUtils.copyProperties(base, productCommissionDto);
    		productCommissionDetailDtos.add(productCommissionDto);
    	}
    	// 整合收益规则和收益详情
    	for(ProductCommissionRuleDetailDto dto: commissionRuleDtos){
    		if(dto.getProductCommissionDtos() == null){
    			dto.setProductCommissionDtos(new ArrayList<ProductCommissionDetailDto>());
    		}
    		for(ProductCommissionDetailDto detailDto : productCommissionDetailDtos){
    			if(detailDto.getCommissionRuleId().equals(dto.getId())){
    				dto.getProductCommissionDtos().add(detailDto);
    			}
    		}
    	}
    	return commissionRuleDtos;
    }
    
    /**
     * 检查佣金规则
     * @param commissionDtos
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkCommissionRuleAddDtos(List<ProductCommissionRuleDto> commissionDtos,Integer isScale, Double  productScale) throws BaseException{
    	if(BooleanUtils.isEmpty(commissionDtos)){
    		return Result.newSuccessResult(true);
    	}
    	// 最多添加20条佣金规则
    	if(commissionDtos.size() > 20){
    		return Result.newFailureResult(CodeConstant.CODE_1200059);
    	}
    	List<String> ruleNames = new ArrayList<String>();
    	for(ProductCommissionRuleDto ruleDto:commissionDtos){
    		// 每条佣金规则最多添加20条佣金项目
    		if(BooleanUtils.isEmpty(ruleDto.getProductCommissionDtos()) || ruleDto.getProductCommissionDtos().size() > 20){
    			return Result.newFailureResult(CodeConstant.CODE_1200061);
    		}
    		
    		if(BooleanUtils.isBlank(ruleDto.getRuleName()) || ruleDto.getRuleName().length() > 100){
    			return Result.newFailureResult(CodeConstant.CODE_1200060);
    		}
    		// 佣金规则不能重复
    		if(ruleNames.contains(ruleDto.getRuleName().trim())){
    			return Result.newFailureResult(CodeConstant.CODE_1200087);
    		}
    		ruleNames.add(ruleDto.getRuleName().trim());
    		// 非必填，输入内容为文本，输入长度上限为200
    		if(!BooleanUtils.isBlank(ruleDto.getRemark()) && ruleDto.getRemark().length() > 100){
    			return Result.newFailureResult(CodeConstant.CODE_1200062);
    		}
			if(!BooleanUtils.isEmpty(ruleDto.getProductCommissionDtos())){
				boolean isFirst = true;
				Double saleMax = null;
				for(ProductCommissionDto dto : ruleDto.getProductCommissionDtos() ){
					// 每只佣金的最小值不能小于0
					if(dto.getSaleMin() == null || dto.getSaleMin() < 0){
						return Result.newFailureResult(CodeConstant.CODE_1200071);
					}
					// 每只佣金的最大值不能小于最小值
					if(dto.getSaleMax() != null && dto.getSaleMax() < dto.getSaleMin()){
						return Result.newFailureResult(CodeConstant.CODE_1200072);
					}
					
					if(!isFirst){
						// 只有最后一只佣金的最大值可以为空
						if(saleMax == null){
							return Result.newFailureResult(CodeConstant.CODE_1200073);
						}
						// 下一只佣金最小值必须大于上一只报价最大值
						if(dto.getSaleMin()<saleMax){
							return Result.newFailureResult(CodeConstant.CODE_1200074);
						}
					}
					saleMax = dto.getSaleMax();
					isFirst = false;
					
					// 检查佣金范围是否大于产品规模
					if(isScale!= null && productScale != null && isScale == 1){
						if(dto.getSaleMin() > productScale){
							return Result.newFailureResult(CodeConstant.CODE_1200082);
						}
						if(saleMax != null  && saleMax > productScale){
							return Result.newFailureResult(CodeConstant.CODE_1200082);
						}
					}
				}
			}
    	}
    	
    	return Result.newSuccessResult(true);
    }
    
    
    /**
     * 检查佣金规则for update
     * @param commissionDtos
     * @return
     * @throws BaseException
     */
    public Result<Boolean> checkCommissionRuleUpdateDtos(List<ProductCommissionRuleUpdateDto> commissionDtos,Integer isScale, Double  productScale) throws BaseException{
    	if(BooleanUtils.isEmpty(commissionDtos)){
    		return Result.newSuccessResult(true);
    	}
		List<ProductCommissionRuleDto> commissionAddDtos = new ArrayList<ProductCommissionRuleDto>();
		for(ProductCommissionRuleUpdateDto updateDto: commissionDtos ){
			// 转换报价
			ProductCommissionRuleDto commissionAddDto = new ProductCommissionRuleDto();
			BeanUtils.copyProperties(updateDto, commissionAddDto);
			commissionAddDtos.add(commissionAddDto);
			
			// 转换报价详情
			List<ProductCommissionUpdateDto> productCommissions =  updateDto.getProductCommissionDtos();
			if(BooleanUtils.isEmpty(productCommissions)){
				continue;
			}
			List<ProductCommissionDto> productCommissionDtos = new ArrayList<ProductCommissionDto>();
			commissionAddDto.setProductCommissionDtos(productCommissionDtos);
			for(ProductCommissionUpdateDto productCommission : productCommissions){
				ProductCommissionDto productCommissionDto = new ProductCommissionDto();
				BeanUtils.copyProperties(productCommission, productCommissionDto);
				productCommissionDtos.add(productCommissionDto);
			}
		}
		return checkCommissionRuleAddDtos(commissionAddDtos,isScale,productScale);
    }
}
