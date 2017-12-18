package com.yundao.tenant.service.product.income.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.product.add.ProductIncomeDto;
import com.yundao.tenant.dto.product.income.ProductIncomeUpdateDto;
import com.yundao.tenant.mapper.base.product.BaseProductIncomeMapper;
import com.yundao.tenant.model.base.product.BaseProductIncome;
import com.yundao.tenant.model.base.product.BaseProductIncomeExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.product.income.ProductIncomeService;

/**
 * 产品收益管理
 * 
 * @author 欧阳利
 * 2017年7月7日
 */
@Service
public class ProductIncomeServiceImpl extends AbstractService implements ProductIncomeService {
	
	@Autowired
	BaseProductIncomeMapper baseProductIncomeMapper;
	

	/**
	 * 删除产品收益
	 * @param incomeRuleIds
	 * @return
	 */
    public Result<Integer> deleteIncome(List<Long> incomeRuleIds){
    	if(BooleanUtils.isEmpty(incomeRuleIds)){
    		return Result.newSuccessResult(0);
    	}
    	BaseProductIncome record = new BaseProductIncome();
    	record.setIsDelete(1);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	BaseProductIncomeExample example = new BaseProductIncomeExample();
    	example.createCriteria().andIncomeRuleIdIn(incomeRuleIds);
    	int count =  baseProductIncomeMapper.updateByExampleSelective(record, example);
    	return Result.newSuccessResult(count);
    }
    
    
    /**
     * 修改收益规则列表
     */
    public Result<Integer> updateIncome(List<ProductIncomeUpdateDto> dtos,Long incomeRuleId){
    	if(BooleanUtils.isEmpty(dtos)){
    		// 删除所有详情列表
    		List<Long> incomeRuleIds = new ArrayList<Long>();
    		incomeRuleIds.add(incomeRuleId);
    		return deleteIncome(incomeRuleIds);
    	}
    	
    	//查询所有的列表
    	List<BaseProductIncome> allList =  getIncomes(incomeRuleId);
    	for(ProductIncomeUpdateDto dto: dtos){
    		if(dto.getId() == null){
    			// 添加
    			addIncome(dto, incomeRuleId);
    		}else{
    			// 修改
    			updateIncome(dto);
    		}
    	}
    	List<Long> needDeleteIds =  getNeedDeleteIds(allList, dtos);
    	deleteIncomeByIds(needDeleteIds);
    	return Result.newSuccessResult(0);
    }

    
    /**
     * 通过id删除
     * @param needDeleteIds
     * @return
     */
    private Result<Integer> deleteIncomeByIds(List<Long> needDeleteIds){
    	if(BooleanUtils.isEmpty(needDeleteIds)){
    		return Result.newSuccessResult(0);
    	}
    	BaseProductIncome record = new BaseProductIncome(); 
    	record.setIsDelete(1);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderTenantId());
    	BaseProductIncomeExample example = new BaseProductIncomeExample();
    	example.createCriteria().andIdIn(needDeleteIds);
    	int count = baseProductIncomeMapper.updateByExampleSelective(record, example);
    	return Result.newSuccessResult(count);
    }
    
    
    /**
     * 获取需要删除的id集合
     * @param allList
     * @param dtos
     * @return
     */
    private List<Long> getNeedDeleteIds(List<BaseProductIncome> allList,List<ProductIncomeUpdateDto> dtos){
    	if(BooleanUtils.isEmpty(allList)){
    		return null;
    	}
    	
    	List<Long> allIds = new ArrayList<Long>();
    	for(BaseProductIncome model:allList){
    		allIds.add(model.getId());
    	}
    	
    	if(BooleanUtils.isEmpty(dtos)){
    		return allIds;
    	}
    	
    	List<Long> currentIds = new ArrayList<Long>();
    	for(ProductIncomeUpdateDto model:dtos){
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
     * 查询所有
     * @param incomeRuleId
     * @return
     */
    private List<BaseProductIncome> getIncomes(Long incomeRuleId){
    	BaseProductIncomeExample example = new BaseProductIncomeExample();
    	example.createCriteria().andIncomeRuleIdEqualTo(incomeRuleId);
    	return baseProductIncomeMapper.selectByExample(example);
    }
    
    
    
    /**
     * 添加收益列表
     * @param dtos
     * @param incomeRuleId
     * @return
     */
    public Result<Integer> addIncome(List<ProductIncomeUpdateDto> dtos,Long incomeRuleId){
    	if(BooleanUtils.isEmpty(dtos)){
    		Result.newSuccessResult(0);
    	}
    	for(ProductIncomeUpdateDto incomeDto:dtos){
    		addIncome(incomeDto, incomeRuleId);
		}
    	return Result.newSuccessResult(dtos.size());
    }
    
    
    
    /**
     * 修改单个收益
     * @param dto
     * @return
     */
    public Result<Integer> updateIncome(ProductIncomeUpdateDto dto){
    	BaseProductIncome record = new BaseProductIncome();
    	BeanUtils.copyProperties(dto, record);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	int count = baseProductIncomeMapper.updateByPrimaryKeySelective(record);
    	return Result.newSuccessResult(count);
    }
    
    
    /**
     * 添加收益列表
     * @param dtos
     * @param incomeRuleId
     * @return
     */
    public Result<Integer> addIncome(ProductIncomeUpdateDto incomeDto,Long incomeRuleId){
		BaseProductIncome incomeRecord = new BaseProductIncome();
		BeanUtils.copyProperties(incomeDto, incomeRecord);
		incomeRecord.setId(null);
		incomeRecord.setCreateDate(new Date());
		incomeRecord.setCreateUserId(this.getHeaderUserId());
		incomeRecord.setTenantId(this.getHeaderTenantId());
		incomeRecord.setIsDelete(0);
		incomeRecord.setIncomeRuleId(incomeRuleId);
		baseProductIncomeMapper.insert(incomeRecord);
    	return Result.newSuccessResult(1);
    }
    
    
    /**
     * 添加收益列表
     * @param dtos
     * @param incomeRuleId
     * @return
     */
    public Result<Integer> addIncome2(List<ProductIncomeDto> dtos,Long incomeRuleId){
    	if(BooleanUtils.isEmpty(dtos)){
    		Result.newSuccessResult(0);
    	}
		for(ProductIncomeDto incomeDto:dtos){
			BaseProductIncome incomeRecord = new BaseProductIncome();
			BeanUtils.copyProperties(incomeDto, incomeRecord);
			incomeRecord.setCreateDate(new Date());
			incomeRecord.setCreateUserId(this.getHeaderUserId());
			incomeRecord.setTenantId(this.getHeaderTenantId());
			incomeRecord.setIsDelete(0);
			incomeRecord.setIncomeRuleId(incomeRuleId);
			baseProductIncomeMapper.insert(incomeRecord);
		}

    	return Result.newSuccessResult(dtos.size());
    }
    
    
    
    /**
     * 通过收益规则查询收益详情
     * @param incomeRuleIds
     * @return
     */
    public List<BaseProductIncome> getBaseProductIncomes(List<Long> incomeRuleIds){
    	if(BooleanUtils.isEmpty(incomeRuleIds)){
    		return null;
    	}
    	BaseProductIncomeExample example = new BaseProductIncomeExample();
    	example.createCriteria().andIncomeRuleIdIn(incomeRuleIds);
    	List<BaseProductIncome>  list = baseProductIncomeMapper.selectByExample(example);
    	return list;
    }
}
