package com.yundao.tenant.service.product.supplier.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.product.add.ProductQuotationDto;
import com.yundao.tenant.dto.product.supplier.ProductQuotationUpdateDto;
import com.yundao.tenant.mapper.base.product.BaseProductSupplierQuotationMapper;
import com.yundao.tenant.model.base.product.BaseProductSupplierQuotation;
import com.yundao.tenant.model.base.product.BaseProductSupplierQuotationExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.product.supplier.ProductSupplierQuotationService;

/**
 * 供应商报价
 * 
 * @author 欧阳利
 * 2017年7月12日
 */
@Service
public class ProductSupplierQuotationServiceImpl  extends AbstractService  implements ProductSupplierQuotationService {
	@Autowired
	BaseProductSupplierQuotationMapper baseProductSupplierQuotationMapper;
	
    /**
     * 删除产品供应商报价
     * @param productSuppliersIds
     * @return
     * @throws BaseException
     */
	public Result<Integer> deleteProductQuotation(List<Long> productSuppliersIds)throws BaseException{
		if(BooleanUtils.isEmpty(productSuppliersIds)){
			return Result.newSuccessResult(0);
		}
		BaseProductSupplierQuotation record = new  BaseProductSupplierQuotation();
		record.setIsDelete(1);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		BaseProductSupplierQuotationExample example = new BaseProductSupplierQuotationExample();
		example.createCriteria().andProductSupplierIdIn(productSuppliersIds);
		int count = baseProductSupplierQuotationMapper.updateByExampleSelective(record, example);
		return Result.newSuccessResult(count);
	}
	
	
	/**
	 * 添加一个产品供应商报价的多一个报价
	 * @param productQuotationDtos
	 * @param productSupplierId
	 * @return
	 * @throws BaseException
	 */
	public Result<Integer> addProductQuotation(List<ProductQuotationDto> productQuotationDtos,Long productSupplierId)throws BaseException,Exception{
		if(BooleanUtils.isEmpty(productQuotationDtos)){
			return Result.newSuccessResult(0);
		}
		for(ProductQuotationDto quotationDto : productQuotationDtos ){
			BaseProductSupplierQuotation quotation = new BaseProductSupplierQuotation();
			BeanUtils.copyProperties(quotationDto, quotation);
			quotation.setProductSupplierId(productSupplierId);
			quotation.setCreateDate(new Date());
			quotation.setCreateUserId(this.getHeaderUserId());
			quotation.setIsDelete(0);
			quotation.setTenantId(this.getHeaderTenantId());
			baseProductSupplierQuotationMapper.insert(quotation);
		}
		return null;
	}
	
	
	/**
	 * 修改产品供应商报价
	 * @param productQuotationDtos
	 * @param productSupplierId
	 * @return
	 * @throws BaseException
	 * @throws Exception
	 */
	public Result<Integer> updateProductQuotation(List<ProductQuotationUpdateDto> list,Long productSupplierId)throws BaseException,Exception{
		if(BooleanUtils.isEmpty(list)){
			return Result.newSuccessResult(0);
		}
		
		// 查询供应商报价的详情列表
		BaseProductSupplierQuotationExample example = new BaseProductSupplierQuotationExample();
		example.createCriteria().andProductSupplierIdEqualTo(productSupplierId);
		
		for(ProductQuotationUpdateDto quotationDto : list ){
			if(quotationDto.getId() == null){
				// 添加新报价
				save(quotationDto, productSupplierId);
			}else{
				// 修改旧报价
				update( quotationDto, productSupplierId);
			}
		}
		
	    // 删除老的报价
		List<BaseProductSupplierQuotation> allList = baseProductSupplierQuotationMapper.selectByExample(example);
		List<Long> needDeleteIds = getNeedDeleteIds( allList, list);
		deleteProductQuotationByIds(needDeleteIds);
		
		return Result.newSuccessResult(1);
	}
	
	
	/**
	 * 查询需要删除的报价id
	 * @param allList
	 * @param list
	 * @return
	 */
	private List<Long> getNeedDeleteIds(List<BaseProductSupplierQuotation> allList,List<ProductQuotationUpdateDto> list){
		if(BooleanUtils.isEmpty(allList)){
			return null;
		}
		List<Long> all = new ArrayList<Long>();
		for(BaseProductSupplierQuotation dto: allList){
			all.add(dto.getId());
		}
		
		if(BooleanUtils.isEmpty(list)){
			return all;
		}
		
		List<Long> currentList = new ArrayList<Long>();
		for(ProductQuotationUpdateDto dto : list){
            if(dto.getId() != null ){
            	currentList.add(dto.getId());
			}
		}
		List<Long> ids = new ArrayList<Long>();
		for(Long id:all){
			if(!currentList.contains(id)){
				ids.add(id);
			}
		}
		return ids;
	}
	
	
	
	/**
	 * 修改报价
	 * @param quotationDto
	 * @param productSupplierId
	 * @return
	 */
	private Result<Integer> update(ProductQuotationUpdateDto quotationDto,Long productSupplierId){
		BaseProductSupplierQuotation record = new BaseProductSupplierQuotation();
		BeanUtils.copyProperties(quotationDto, record);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		record.setProductSupplierId(productSupplierId);
		int count = baseProductSupplierQuotationMapper.updateByPrimaryKeySelective(record);
		return Result.newSuccessResult(count);
	}
	
	
	/**
	 * 添加产品报价
	 * @param quotationDto
	 * @param productSupplierId
	 * @return
	 */
	private Result<Integer> save(ProductQuotationUpdateDto quotationDto,Long productSupplierId){
		// 添加报价
		BaseProductSupplierQuotation record = new BaseProductSupplierQuotation();
		BeanUtils.copyProperties(quotationDto, record);
		record.setTenantId(this.getHeaderTenantId());
		record.setCreateDate(new Date());
		record.setCreateUserId(this.getHeaderUserId());
		record.setProductSupplierId(productSupplierId);
		record.setIsDelete(0);
		int count = baseProductSupplierQuotationMapper.insert(record);
		return Result.newSuccessResult(count);
	}
	
	
	/**
	 *  添加产品供应商报价
	 * @param productQuotationDtos
	 * @param productSupplierId
	 * @return
	 * @throws BaseException
	 * @throws Exception
	 */
	public Result<Integer> saveProductQuotation(List<ProductQuotationUpdateDto> productQuotationDtos,Long productSupplierId)throws BaseException,Exception{
		if(BooleanUtils.isEmpty(productQuotationDtos) || productSupplierId == null){
			return Result.newSuccessResult(0);
		}
		for(ProductQuotationUpdateDto quotationDto:productQuotationDtos){
			save( quotationDto, productSupplierId);
		}
		return Result.newSuccessResult(productQuotationDtos.size());
	}
	
	
	
    /**
     * 删除产品供应商报价
     * @param productSuppliersIds
     * @return
     * @throws BaseException
     */
	public Result<Integer> deleteProductQuotationByIds(List<Long> ids)throws BaseException{
		if(BooleanUtils.isEmpty(ids)){
			return Result.newSuccessResult(0);
		}
		BaseProductSupplierQuotation record = new  BaseProductSupplierQuotation();
		record.setIsDelete(0);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		BaseProductSupplierQuotationExample example = new BaseProductSupplierQuotationExample();
		example.createCriteria().andIdIn(ids);
		int count = baseProductSupplierQuotationMapper.updateByExampleSelective(record, example);
		return Result.newSuccessResult(count);
	}
	
	
	/**
	 * 查询产品供应商报价详细信息
	 * @param productSupplierIds
	 * @return
	 */
    public List<BaseProductSupplierQuotation> getBaseProductSupplierQuotations(List<Long> productSupplierIds){
    	if(BooleanUtils.isEmpty(productSupplierIds)){
    		return null;
    	}
    	BaseProductSupplierQuotationExample example = new BaseProductSupplierQuotationExample();
    	example.createCriteria().andProductSupplierIdIn(productSupplierIds);
    	return baseProductSupplierQuotationMapper.selectByExample(example);
    }
}
