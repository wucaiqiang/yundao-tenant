
package com.yundao.tenant.service.customercenter.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.product.ProductBaseResDto;
import com.yundao.tenant.dto.product.add.ProductIncomeRuleDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseQueryReqDto;
import com.yundao.tenant.dto.product.h5.ProductH5BaseResDto;
import com.yundao.tenant.dto.product.h5.ProductNoticeDto;
import com.yundao.tenant.mapper.base.platform.BasePlatformMapper;
import com.yundao.tenant.mapper.base.platform.BasePositionMapper;
import com.yundao.tenant.mapper.product.ProductH5SelectMapper;
import com.yundao.tenant.mapper.product.ProductIncomeRuleMapper;
import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.model.base.platform.BasePlatformExample;
import com.yundao.tenant.model.base.platform.BasePosition;
import com.yundao.tenant.model.base.platform.BasePositionExample;
import com.yundao.tenant.service.customercenter.ProductH5SelectService;
import com.yundao.tenant.util.SymbolStrUtils;

/**
 * Function: Reason: Date: 2017年9月7日 上午10:57:51
 * 
 * @author 欧阳利
 * @version
 */
@Service
public class ProductH5SelectServiceImpl implements ProductH5SelectService {

	@Autowired
	ProductIncomeRuleMapper productIncomeRuleMapper;

	@Autowired
	ProductH5SelectMapper productH5SelectMapper;

	@Autowired
	BasePlatformMapper platformMapper;

	@Autowired
	BasePositionMapper basePositionMapper;

	public Result<List<ProductH5BaseResDto>> getHotList(ProductH5BaseQueryReqDto reqDto) throws BaseException {
		// 设置平台和位置信息
		setPositionAndPlatformId(reqDto);

		List<ProductH5BaseResDto> datas = productH5SelectMapper.getProductList(reqDto);
		// 设置收益信息
		setIncomeRule(datas);
		return Result.newSuccessResult(datas);
	}

	@Override
	public Result<List<ProductBaseResDto>> getReCommendedListForApp(Integer limit, String issuedStatuses,
			String platformCode, String positionCode) throws BaseException {
		if (StringUtils.isBlank(platformCode)) {
			throw new BaseException(CodeConstant.CODE_1200166);
		}
		if (StringUtils.isBlank(positionCode)) {
			throw new BaseException(CodeConstant.CODE_1200167);
		}
		ProductH5BaseQueryReqDto reqDto = new ProductH5BaseQueryReqDto();
		reqDto.setPageSize(limit);
		if (StringUtils.isNotBlank(issuedStatuses)) {
			String[] issuedStatusesArr = issuedStatuses.split(",");
			List<Integer> issList = new ArrayList<>();
			for (int i = 0; i < issuedStatusesArr.length; i++) {
				issList.add(NumberUtils.toInt(issuedStatusesArr[i]));
			}
			reqDto.setIssuedStatusList(issList);
		}
		reqDto.setPlatformCode(platformCode);
		reqDto.setPositionCode(positionCode);

		setPositionAndPlatformId(reqDto);

		List<ProductBaseResDto> datas = productH5SelectMapper.getReCommendedList(reqDto);
		return Result.newSuccessResult(datas);
	}

	@Override
	public Result<PaginationSupport<ProductH5BaseResDto>> getList(ProductH5BaseQueryReqDto reqDto)
			throws BaseException {
		PaginationSupport<ProductH5BaseResDto> result = reqDto.getPaginationSupport();

		// 设置平台和位置信息
		setPositionAndPlatformId(reqDto);
		int totalCount = productH5SelectMapper.getProductListCount(reqDto);
		if (totalCount > 0) {
			List<ProductH5BaseResDto> datas = productH5SelectMapper.getProductList(reqDto);
			// 设置收益信息
			setIncomeRule(datas);
			result.setDatas(datas);
		}
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);

	}

	/**
	 * 设置平台和位置信息 setPositionAndPlatformId:
	 * 
	 * @author: 欧阳利
	 * @param reqDto
	 * @description:
	 */
	private void setPositionAndPlatformId(ProductH5BaseQueryReqDto reqDto) {

		BasePositionExample example = new BasePositionExample();
		example.createCriteria().andCodeEqualTo(reqDto.getPositionCode());
		BasePosition basePosition = basePositionMapper.selectOne(example);
		reqDto.setPositionId(basePosition.getId());
		//
		BasePlatformExample platformExample = new BasePlatformExample();
		platformExample.createCriteria().andCodeEqualTo(reqDto.getPlatformCode());
		BasePlatform basePlatform = platformMapper.selectOne(platformExample);
		reqDto.setPlatformId(basePlatform.getId());
	}

	/**
	 * 设置收益信息 setIncomeRule:
	 * 
	 * @author: 欧阳利
	 * @param datas
	 * @description:
	 */
	private void setIncomeRule(List<ProductH5BaseResDto> datas) {
		if (BooleanUtils.isEmpty(datas)) {
			return;
		}
		List<Long> productIds = new ArrayList<Long>();
		for (ProductH5BaseResDto dto : datas) {
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
				for (ProductH5BaseResDto productDto : datas) {
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

	/**
	 * 通过产品id查询产品的公告(审核通过并发布的公告) getProductNoticeDtos:
	 * 
	 * @author: 欧阳利
	 * @param productId
	 * @return
	 * @description:
	 */
	public List<ProductNoticeDto> getProductNoticeDtos(@Param("productId") Long productId) throws BaseException {
		return productH5SelectMapper.getProductNoticeDtos(productId);
	}

}
