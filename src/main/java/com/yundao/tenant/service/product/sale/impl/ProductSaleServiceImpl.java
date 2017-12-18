package com.yundao.tenant.service.product.sale.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.ProductSaleUpdateReqDto;
import com.yundao.tenant.mapper.base.product.BaseProductSaleMapper;
import com.yundao.tenant.mapper.product.ProductUpdateMapper;
import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.product.sale.ProductSaleService;

@Service
public class ProductSaleServiceImpl extends AbstractService implements ProductSaleService {

	@Autowired
	BaseProductSaleMapper baseProductSaleMapper;
	@Autowired
	ProductUpdateMapper productUpdateMapper;
	
	/**
	 * 添加产品销售
	 * @return
	 */
    public Result<Long> saveProductSale(BaseProductSale record)throws BaseException,Exception {
    	record.setCreateDate(new Date());
    	record.setCreateUserId(this.getHeaderUserId());
    	record.setTenantId(this.getHeaderTenantId());
    	record.setIsDelete(0);
    	baseProductSaleMapper.insert(record);
		return Result.newSuccessResult(record.getId());
	}
    
    
    /**
     * 修改产品销售信息
     * @param updateReqDto
     * @return
     * @throws Exception
     */
    public Result<Integer> updateProductSale(ProductSaleUpdateReqDto updateReqDto)throws Exception{
    	BaseProductSale record = new BaseProductSale();
    	BeanUtils.copyProperties(updateReqDto, record);
    	record.setProductId(updateReqDto.getId());
    	record.setId(null);
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	int count = productUpdateMapper.updateProductSaleByProductId(record);
    	return Result.newSuccessResult(count);
    }

}
