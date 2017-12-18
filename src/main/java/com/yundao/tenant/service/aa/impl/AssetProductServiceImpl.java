

package com.yundao.tenant.service.aa.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.aa.product.AssetAllocationProductPageReqDto;
import com.yundao.tenant.dto.product.ProductSimpleResDto;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.mapper.aa.AaProductMapper;
import com.yundao.tenant.mapper.base.aa.BaseAaProductRefMapper;
import com.yundao.tenant.mapper.product.ProductIncomeRuleMapper;
import com.yundao.tenant.model.base.aa.BaseAaProductRef;
import com.yundao.tenant.model.base.aa.BaseAaProductRefExample;
import com.yundao.tenant.service.aa.AssetProductService;
import com.yundao.tenant.util.SymbolStrUtils;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月8日 下午1:59:08 
 * @author   欧阳利
 * @version   
 */
@Service
public class AssetProductServiceImpl extends AbstractService implements AssetProductService {

	
	@Autowired
	BaseAaProductRefMapper baseProductRefMapper; 
	@Autowired
	ProductIncomeRuleMapper productIncomeRuleMapper;
	@Autowired
	AaProductMapper aaProductMapper;
	/**
 	 * 资产配置修改产品
 	 * addAssetAllocationProduct:
 	 * @author: 欧阳利
 	 * @param id
 	 * @param productIds
 	 * @return
 	 * @throws BaseException
 	 * @description:
 	 */
 	public Result<Integer> addAssetAllocationProduct( Long id,  List<Long> productIds)throws BaseException{
 		if(id == null ){
 			return Result.newFailureResult(Code1200000.CODE_1200178);
 		}
 		
 		BaseAaProductRefExample example = new BaseAaProductRefExample();
 		example.createCriteria().andScoreIdEqualTo(id);
 		baseProductRefMapper.deleteByExample(example);
 		
 		if(!BooleanUtils.isEmpty(productIds)){
 			for(Long productId : productIds){
 	 	 		BaseAaProductRef record = new BaseAaProductRef();
 	 	 		record.setScoreId(id);
 	 	 		record.setProductId(productId);
 	 	 		record.setCreateDate(new Date());
 	 	 		record.setCreateUserId(this.getHeaderUserId());
 	 	 		record.setTenantId(this.getHeaderTenantId());
 	 	 		record.setIsDelete(0);
 	 	 		baseProductRefMapper.insert(record);
 	 		}
 		}

 		return Result.newSuccessResult(1);
 	}
 	
    
	/**
	 * 分页查询资产配置的产品列表
	 * getAssetAllocationProductPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<ProductSimpleResDto>> getAssetAllocationProductPage(AssetAllocationProductPageReqDto reqDto)throws BaseException{
		PaginationSupport<ProductSimpleResDto> page = reqDto.getPaginationSupport();
		int totalCount = aaProductMapper.getPageCount(reqDto);
		if(totalCount > 0){
			List<ProductSimpleResDto> datas = aaProductMapper.getPage(reqDto);
			setIncomeRule(datas);
			page.setDatas(datas);
		}
		page.setTotalCount(totalCount);
		return Result.newSuccessResult(page);
 	}
	
	
	/**
	 * 查询资产配置关联的产品id集合
	 * getProductIds:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<List<Long>> getProductIds(Long id)throws BaseException{
		if(id == null){
			Result.newSuccessResult(new ArrayList<Long>()) ;
		}
		return Result.newSuccessResult(aaProductMapper.getProductIds(id)) ;
	}
	
	
	/**
	 * 设置收益信息 setIncomeRule:
	 * 
	 * @author: 欧阳利
	 * @param datas
	 * @description:
	 */
	private void setIncomeRule(List<ProductSimpleResDto> datas) {
		if (BooleanUtils.isEmpty(datas)) {
			return;
		}
		List<Long> productIds = new ArrayList<Long>();
		for (ProductSimpleResDto dto : datas) {
			productIds.add(dto.getId());
		}

		// 设置收益
		List<ProductIncomeRuleDto> incomeList = productIncomeRuleMapper
				.selectList(SymbolStrUtils.longToStr(productIds));
		if (!BooleanUtils.isEmpty(incomeList)) {
			for (ProductIncomeRuleDto rule : incomeList) {
				if (rule.getProductId() == null) {
					continue;
				}
				for (ProductSimpleResDto productDto : datas) {
					if (productDto.getId().equals(rule.getProductId())) {
						List<ProductIncomeRuleDto> incomes = productDto.getPrIncomeRuleDtos();
						if (incomes == null) {
							incomes = new ArrayList<>();
							productDto.setPrIncomeRuleDtos(incomes);
						}
						incomes.add(rule);
					}
				}

			}
		}
	}
}

