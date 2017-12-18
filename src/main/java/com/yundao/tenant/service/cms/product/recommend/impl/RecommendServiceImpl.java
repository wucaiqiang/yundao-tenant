

package com.yundao.tenant.service.cms.product.recommend.impl;

import java.util.Date;
import java.util.List;

import com.yundao.tenant.model.base.cms.product.BaseProductRecommendExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.cms.product.recommend.RecommendAddReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendDetailDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListResDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendUpdateReqDto;
import com.yundao.tenant.enums.cms.product.recommend.RecommendStatusEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.mapper.base.cms.product.BaseProductRecommendMapper;
import com.yundao.tenant.mapper.base.platform.BasePlatformMapper;
import com.yundao.tenant.mapper.base.platform.BasePositionMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.cms.product.recommend.ProductRecommendMapper;
import com.yundao.tenant.model.base.cms.product.BaseProductRecommend;
import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.model.base.platform.BasePosition;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.service.cms.product.recommend.RecommendService;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:28:58 
 * @author   欧阳利
 * @version   
 */
@Service
public class RecommendServiceImpl  extends AbstractService   implements RecommendService{

	@Autowired
	BaseProductRecommendMapper baseProductRecommendMapper;
	@Autowired
	BaseProductMapper baseProductMapper;
	@Autowired
	BasePlatformMapper basePlatformMapper;
	
	@Autowired
	BasePositionMapper basePositionMapper;
	@Autowired
	ProductRecommendMapper productRecommendMapper;
	
	/**
     * 添加产品附件
     * add:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @description:
     */
    public Result<Long> add(RecommendAddReqDto reqDto)throws BaseException{
    	if(reqDto == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200041);
    	}
    	// 判断产品是否存在
    	BaseProduct product = baseProductMapper.selectByPrimaryKey(reqDto.getProductId());
    	if(product == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200042);
    	}
    	// 判断平台是否存在
    	BasePlatform basePlatform = basePlatformMapper.selectByPrimaryKey(reqDto.getPlatformId());
    	if(basePlatform == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200162);
    	}
    	
    	// 判断位置是否存在
    	BasePosition basePosition = basePositionMapper.selectByPrimaryKey(reqDto.getPositionId());
    	if(basePosition == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200165);
    	}
    	
    	
    	// 判断该配置是否已经存在
    	BaseProductRecommendExample example = new BaseProductRecommendExample();
    	example.createCriteria().andProductIdEqualTo(reqDto.getProductId())
    	   .andPlatformIdEqualTo(reqDto.getPlatformId()).andPositionIdEqualTo(reqDto.getPositionId());
    	List<BaseProductRecommend> list = baseProductRecommendMapper.selectByExample(example);
    	if(!BooleanUtils.isEmpty(list)){
    		return Result.newFailureResult(CodeConstant.CODE_1200164);
    	}

    	BaseProductRecommend record = new BaseProductRecommend();
    	BeanUtils.copyProperties(reqDto, record);
    	record.setTenantId(this.getHeaderTenantId());
    	record.setCreateDate(new Date());
    	record.setCreateUserId(this.getHeaderUserId());
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	record.setIsDelete(0);
    	baseProductRecommendMapper.insert(record);
    	return Result.newSuccessResult(record.getId());
    }
	
	
	/**
	 * 列表查询"
	 * getPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
    public Result<PaginationSupport<RecommendListResDto>> getPage(RecommendListReqDto reqDto)throws BaseException{
    	PaginationSupport<RecommendListResDto> result = reqDto.getPaginationSupport();
		// 重置参数
		resetParam(reqDto);
    	
    	int totalCount = productRecommendMapper.getPageCount(reqDto);
    	if(totalCount > 0){
    		List<RecommendListResDto> datas = productRecommendMapper.getPage(reqDto);
    		result.setDatas(datas);
    		for(RecommendListResDto dto : datas){
    			dto.setStatusText(RecommendStatusEnum.getEnumName(dto.getStatus()));
    		}
    	}
    	
    	result.setTotalCount(totalCount);
    	
    	return Result.newSuccessResult(result);
    }
	
	private void resetParam(RecommendListReqDto reqDto){
		// 设置排序
		resetParamOrderBy(reqDto);
	}
	
	
	/**
	 * 设置排序
	 * @param reqDto
	 */
	private void resetParamOrderBy(RecommendListReqDto reqDto){
		if(reqDto == null ){
			return;
		}
		if(BooleanUtils.isBlank(reqDto.getOrderColumn()) ){
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
		
		if(reqDto.getOrderColumn().equals("updateDate")){
			reqDto.setOrderColumn(" pr.update_date");
			reqDto.setSort("desc");
		}
	}


	/**
	 * 删除单个配置
	 * delete:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @description:
	 */
    public Result<Integer> delete(String[] arrayIds)throws BaseException{
    	if(BooleanUtils.isEmpty(arrayIds)){
    		return Result.newFailureResult(CodeConstant.CODE_1200000);
    	}
    	int count = 0;
    	for(String idstr:arrayIds){
    		Long id = Long.parseLong(idstr);
        	// 检查是否存在
        	BaseProductRecommend base = baseProductRecommendMapper.selectByPrimaryKey(id);
        	if(base == null ){
        		return Result.newFailureResult(CodeConstant.CODE_1200163);
        	}
        	
        	// 删除数据
        	BaseProductRecommend record = new BaseProductRecommend();
        	record.setId(id);
        	record.setIsDelete(1);
        	record.setUpdateDate(new Date());
        	record.setUpdateUserId(this.getHeaderUserId());
        	count = count +  baseProductRecommendMapper.updateByPrimaryKeySelective(record);
    	}
    	 

    	return Result.newSuccessResult(count);
    }
	
	/**
	 * 编辑推荐配置
	 * update:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
    public Result<Integer> update(RecommendUpdateReqDto reqDto)throws BaseException{
    	if(reqDto == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200000);
    	}
    	
    	// 检查是否存在
    	BaseProductRecommend base = baseProductRecommendMapper.selectByPrimaryKey(reqDto.getId());
    	if(base == null ){
    		return Result.newFailureResult(CodeConstant.CODE_1200163);
    	}
    	
    	// 判断产品是否存在
    	BaseProduct product = baseProductMapper.selectByPrimaryKey(reqDto.getProductId());
    	if(product == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200042);
    	}
    	// 判断平台是否存在
    	BasePlatform basePlatform = basePlatformMapper.selectByPrimaryKey(reqDto.getPlatformId());
    	if(basePlatform == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200162);
    	}
    	
    	// 判断位置是否存在
    	BasePosition basePosition = basePositionMapper.selectByPrimaryKey(reqDto.getPositionId());
    	if(basePosition == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200165);
    	}
    	
    	// 判断该配置是否已经存在
//    	BaseProductRecommendExample example = new BaseProductRecommendExample();
//    	example.createCriteria().andProductIdEqualTo(reqDto.getProductId())
//    	   .andPlatformIdEqualTo(reqDto.getPlatformId()).andPositionIdEqualTo(reqDto.getPositionId());
//    	List<BaseProductRecommend> list = baseProductRecommendMapper.selectByExample(example);
//    	if(!BooleanUtils.isEmpty(list)){
//    		for(BaseProductRecommend baseRe : list){
//    			if(!reqDto.getId().equals(baseRe.getId())){
//    				return Result.newFailureResult(CodeConstant.CODE_1200164);
//    			}
//    		}
//    	}
    	
    	BaseProductRecommend record = new BaseProductRecommend();
    	BeanUtils.copyProperties(reqDto, record);
    	record.setTenantId(this.getHeaderTenantId());
    	record.setUpdateDate(new Date());
    	record.setUpdateUserId(this.getHeaderUserId());
    	int count = baseProductRecommendMapper.updateByPrimaryKeySelective(record);
    	return Result.newSuccessResult(count);
    }
	
	/**
	 * 详情
	 * get:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @description:
	 */
    public Result<RecommendDetailDto> get(Long id)throws BaseException{
    	if(id == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200000);
    	}
    	BaseProductRecommend base = baseProductRecommendMapper.selectByPrimaryKey(id);
    	if(base == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200163);
    	}
    	RecommendDetailDto dto = new RecommendDetailDto();
    	BeanUtils.copyProperties(base, dto);
    	
    	BaseProduct baseProduct = baseProductMapper.selectByPrimaryKey(dto.getProductId());
    	if(baseProduct == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200042);
    	}
    	dto.setProductName(baseProduct.getName());
    	dto.setIssuedStatus(baseProduct.getIssuedStatus());
    	dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(baseProduct.getIssuedStatus()));
    	
    	BasePlatform basePlatform = basePlatformMapper.selectByPrimaryKey(dto.getPlatformId());
    	if(basePlatform != null){
    		dto.setPlatformName(basePlatform.getName());
    	}
    	
    	BasePosition basePosition = basePositionMapper.selectByPrimaryKey(dto.getPositionId());
    	if(basePosition != null){
    		dto.setPositionName(basePosition.getName());
    	}
		dto.setStatusText(RecommendStatusEnum.getEnumName(dto.getStatus()));
    	return Result.newSuccessResult(dto);
    }
}

