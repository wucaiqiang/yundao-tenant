package com.yundao.tenant.service.product.commission.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.product.add.ProductCommissionDto;
import com.yundao.tenant.dto.product.commission.ProductCommissionUpdateDto;
import com.yundao.tenant.mapper.base.product.BaseProductCommissionMapper;
import com.yundao.tenant.model.base.product.BaseProductCommission;
import com.yundao.tenant.model.base.product.BaseProductCommissionExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.product.commission.ProductCommissionService;


@Service
public class ProductCommissionServiceImpl extends AbstractService  implements ProductCommissionService {
	@Autowired
	BaseProductCommissionMapper baseProductCommissionMapper;
	
	/**
	 * 添加佣金列表
	 * @param dtos
	 * @param commissionRuleId
	 * @return
	 */
    public Result<Integer> addProductCommissionUpdateDtos(List<ProductCommissionUpdateDto> dtos, Long commissionRuleId)throws Exception{
    	if(BooleanUtils.isEmpty(dtos)){
            return Result.newSuccessResult(0);
		}
    	
		for(ProductCommissionUpdateDto commissionDto : dtos){
			BaseProductCommission commissionRecord = new BaseProductCommission();
			BeanUtils.copyProperties(commissionDto, commissionRecord);
			commissionRecord.setIsDelete(0);
			commissionRecord.setCommissionRuleId(commissionRuleId);
			commissionRecord.setCreateDate(new Date());
			commissionRecord.setTenantId(this.getHeaderTenantId());
			commissionRecord.setCreateUserId(this.getHeaderUserId());
			baseProductCommissionMapper.insert(commissionRecord);
		}
		return Result.newSuccessResult(dtos.size());
    }
	
	
    /**
     * 更新佣金详情列表
     * @param commissionDtos
     * @param commissionRuleId
     * @return
     * @throws Exception
     */
    public Result<Integer>  updateProductCommissionUpdateDto( List<ProductCommissionUpdateDto>  commissionDtos,Long commissionRuleId)throws Exception{
    	if(BooleanUtils.isEmpty(commissionDtos)){
    		// 删除所有的佣金列表
    		return deleteCommissionRuleId(commissionRuleId);
    	}
    	// 查询
    	List<BaseProductCommission> allList =  getCommissionDtosByRuleId(commissionRuleId);
    	for(ProductCommissionUpdateDto dto:commissionDtos){
    		if(dto.getId() == null){
    			// 添加
    			addProductCommissionUpdateDto(dto, commissionRuleId);
    		}else{
    			// 修改
    			updateProductCommissionUpdateDto(dto);
    		}
    	}
    	List<Long> needDeleteIds = 	getNeedDeleteIds(allList, commissionDtos);
    	deleteByIds(needDeleteIds);
    	return null;
    }
	
	
    /**
     * 获取某个规则的所有佣金列表
     * @param ruleId
     * @return
     */
    private List<BaseProductCommission> getCommissionDtosByRuleId(Long ruleId){
    	BaseProductCommissionExample example = new BaseProductCommissionExample();
    	example.createCriteria().andCommissionRuleIdEqualTo(ruleId);
    	return  baseProductCommissionMapper.selectByExample(example);
    }
    
    /**
     * 获取素有需要删除的id集合
     * @param allList
     * @param dtos
     * @return
     */
    private List<Long> getNeedDeleteIds(List<BaseProductCommission> allList, List<ProductCommissionUpdateDto>  dtos){
    	if(BooleanUtils.isEmpty(allList)){
    		return null;
    	}
    	
    	List<Long> allIds = new ArrayList<Long>();
    	for(BaseProductCommission model:allList){
    		allIds.add(model.getId());
    	}
    	
    	if(BooleanUtils.isEmpty(dtos)){
    		return allIds;
    	}
    	
    	List<Long> currentIds = new ArrayList<Long>();
    	for(ProductCommissionUpdateDto model:dtos){
    		if(model.getId() != null){
    			currentIds.add(model.getId());
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
	 * 添加佣金列表
	 * @param dtos
	 * @param commissionRuleId
	 * @return
	 */
    public Result<Integer> addProductCommissionDtos(List<ProductCommissionDto> dtos, Long commissionRuleId)throws Exception{
    	if(BooleanUtils.isEmpty(dtos)){
            return Result.newSuccessResult(0);
		}
    	
		for(ProductCommissionDto commissionDto : dtos){
			BaseProductCommission commissionRecord = new BaseProductCommission();
			BeanUtils.copyProperties(commissionDto, commissionRecord);
			commissionRecord.setIsDelete(0);
			commissionRecord.setCommissionRuleId(commissionRuleId);
			commissionRecord.setCreateDate(new Date());
			commissionRecord.setTenantId(this.getHeaderTenantId());
			commissionRecord.setCreateUserId(this.getHeaderUserId());
			baseProductCommissionMapper.insert(commissionRecord);
		}
		return Result.newSuccessResult(dtos.size());
    }
    
    
    private Result<Integer> addProductCommissionUpdateDto(ProductCommissionUpdateDto dto,Long commissionRuleId){
    	if(dto == null ||commissionRuleId == null ){
    		 return Result.newSuccessResult(0);
    	}
    	BaseProductCommission commissionRecord = new BaseProductCommission();
		BeanUtils.copyProperties(dto, commissionRecord);
		commissionRecord.setIsDelete(0);
		commissionRecord.setCommissionRuleId(commissionRuleId);
		commissionRecord.setCreateDate(new Date());
		commissionRecord.setTenantId(this.getHeaderTenantId());
		commissionRecord.setCreateUserId(this.getHeaderUserId());
		int count = baseProductCommissionMapper.insert(commissionRecord);
		return Result.newSuccessResult(count);
    }
    
    
    private Result<Integer> updateProductCommissionUpdateDto(ProductCommissionUpdateDto dto){
    	if(dto == null ){
   		 return Result.newSuccessResult(0);
	   	}
	   	BaseProductCommission record=new BaseProductCommission();
	   	BeanUtils.copyProperties(dto, record);
	   	record.setUpdateDate(new Date());
	   	record.setUpdateUserId(this.getHeaderUserId());
		int count = baseProductCommissionMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(count);
   }
    
    
    /**
     * 通过佣金规则id集合删除佣金
     * @param ids
     * @return
     * @throws Exception
     */
    public Result<Integer> deleteCommissionRuleIds(List<Long> ids)throws Exception{
    	BaseProductCommission record = new BaseProductCommission(); 
    	record.setIsDelete(0);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	BaseProductCommissionExample example = new BaseProductCommissionExample(); 
    	example.createCriteria().andCommissionRuleIdIn(ids);
    	int count = baseProductCommissionMapper.updateByExampleSelective(record, example);
    	return Result.newSuccessResult(count);
    }
    
    
    
    public Result<Integer> deleteCommissionRuleId(Long id)throws Exception{
    	BaseProductCommission record = new BaseProductCommission(); 
    	record.setIsDelete(0);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	BaseProductCommissionExample example = new BaseProductCommissionExample(); 
    	example.createCriteria().andCommissionRuleIdEqualTo(id);
    	int count = baseProductCommissionMapper.updateByExampleSelective(record, example);
    	return Result.newSuccessResult(count);
    }
    
    
    public Result<Integer> deleteByIds(List<Long> ids)throws Exception{
    	if(BooleanUtils.isEmpty(ids)){
    		return Result.newSuccessResult(0);
    	}
    	BaseProductCommission record = new BaseProductCommission(); 
    	record.setIsDelete(1);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	BaseProductCommissionExample example = new BaseProductCommissionExample(); 
    	example.createCriteria().andIdIn(ids);
    	int count = baseProductCommissionMapper.updateByExampleSelective(record, example);
    	return Result.newSuccessResult(count);
    }
    
    
    /**
     * 获取产品佣金详情
     * @param commissionRuleIds
     * @return
     * @throws Exception
     */
    public List<BaseProductCommission> getBaseProductCommissions(List<Long> commissionRuleIds)throws Exception{
    	if(BooleanUtils.isEmpty(commissionRuleIds)){
    		return null;
    	}
    	BaseProductCommissionExample example = new BaseProductCommissionExample();
    	example.createCriteria().andCommissionRuleIdIn(commissionRuleIds);
    	List<BaseProductCommission>  list = baseProductCommissionMapper.selectByExample(example);
    	return list;
    }
}
