package com.yundao.tenant.service.roadshowproductrel.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.roadshowproductrel.RoadshowProductRelReqDto;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowProductRelMapper;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRel;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRelExample;
import com.yundao.tenant.service.roadshowproductrel.RoadshowProductRelService;

@Service
public class RoadshowProductRelServiceImpl extends AbstractService implements RoadshowProductRelService {

	@Autowired
	private BaseRoadshowProductRelMapper baseRoadshowProductRelMapper;

	public Result<Long> add(RoadshowProductRelReqDto reqDto) throws Exception {
		BaseRoadshowProductRel model = new BaseRoadshowProductRel();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setTenantId(super.getHeaderTenantId());
		model.setId(null);
		int count = baseRoadshowProductRelMapper.insertSelective(model);
		return Result.newSuccessResult(model.getId());
	}

	@Override
	public Result<Long> updateByProductIdAndRoadShowId(RoadshowProductRelReqDto reqDto) throws Exception {
		if (reqDto.getRoadshowId() == null) {
			throw new BaseException(Code1200000.CODE_1200176);
		}

		BaseRoadshowProductRelExample example = new BaseRoadshowProductRelExample();
		example.createCriteria().andRoadshowIdEqualTo(reqDto.getRoadshowId());
		baseRoadshowProductRelMapper.deleteByExample(example);

		if (reqDto.getProductId() != null) {
			this.add(reqDto);
		}

		return Result.newSuccessResult(reqDto.getRoadshowId());

	}

	public Result<Long> update(RoadshowProductRelReqDto reqDto) throws Exception {
		BaseRoadshowProductRel model = new BaseRoadshowProductRel();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseRoadshowProductRelMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(model.getId());
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseRoadshowProductRel roadshowProductRel = new BaseRoadshowProductRel();
		roadshowProductRel.setId(id);
		roadshowProductRel.setUpdateDate(new Date());
		roadshowProductRel.setUpdateUserId(super.getHeaderUserId());
		int count = baseRoadshowProductRelMapper.updateByPrimaryKeySelective(roadshowProductRel);
		return Result.newSuccessResult(count);
	}

	public Result<BaseRoadshowProductRel> get(Long id) throws Exception {
		BaseRoadshowProductRel model = baseRoadshowProductRelMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<BaseRoadshowProductRel>> getPage(RoadshowProductRelReqDto roadshowProductRelReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		BaseRoadshowProductRelExample baseRoadshowProductRelExample = new BaseRoadshowProductRelExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseRoadshowProductRelExample.Criteria criteria = baseRoadshowProductRelExample.createCriteria();
		String orderByClause = "create_date desc";
		if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
			StringBuilder orderBuider = new StringBuilder();
			orderBuider.append(pageDto.getOrderColumn()).append(" ");
			if (StringUtils.isNotBlank(pageDto.getSort())) {
				orderBuider.append(pageDto.getSort());
			} else {
				orderBuider.append("desc");
			}
			orderByClause = orderBuider.toString();
		}
		baseRoadshowProductRelExample.setOrderByClause(orderByClause);
		List<BaseRoadshowProductRel> list = baseRoadshowProductRelMapper.selectByExample(baseRoadshowProductRelExample);
		int totalCount = baseRoadshowProductRelMapper.countByExample(baseRoadshowProductRelExample);
		PaginationSupport<BaseRoadshowProductRel> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
