package com.yundao.tenant.service.roadshowcolumnrel.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.roadshowcolumnrel.RoadshowColumnRelReqDto;
import com.yundao.tenant.mapper.base.roadshow.BaseRoadshowColumnRelMapper;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRel;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRelExample;
import com.yundao.tenant.service.roadshowcolumnrel.RoadshowColumnRelService;

@Service
public class RoadshowColumnRelServiceImpl extends AbstractService implements RoadshowColumnRelService {

	@Autowired
	private BaseRoadshowColumnRelMapper baseRoadshowColumnRelMapper;

	public Result<Long> add(RoadshowColumnRelReqDto reqDto) throws Exception {
		BaseRoadshowColumnRel model = new BaseRoadshowColumnRel();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setUpdateUserId(super.getHeaderUserId());
		model.setUpdateDate(new Date());
		model.setTenantId(super.getHeaderTenantId());
		model.setId(null);
		int count = baseRoadshowColumnRelMapper.insertSelective(model);
		return Result.newSuccessResult(model.getId());
	}

	public Result<Long> update(RoadshowColumnRelReqDto reqDto) throws Exception {
		BaseRoadshowColumnRel model = new BaseRoadshowColumnRel();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseRoadshowColumnRelMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(model.getId());
	}

	@Override
	public Result<Long> updateByColumnIdsAndRoadShowId(String columnIds, Long roadShowId) throws Exception {
		if (roadShowId == null) {
			throw new BaseException(Code1200000.CODE_1200176);
		}
		// 删除已有的栏目关系
		BaseRoadshowColumnRelExample deleteExample = new BaseRoadshowColumnRelExample();
		deleteExample.createCriteria().andRoadshowIdEqualTo(roadShowId);
		baseRoadshowColumnRelMapper.deleteByExample(deleteExample);
		
		if (StringUtils.isNotBlank(columnIds)) {
			String[] columnIdArr = columnIds.split(",");
			for (int i = 0; i < columnIdArr.length; i++) {
				RoadshowColumnRelReqDto reqDto = new RoadshowColumnRelReqDto();
				reqDto.setRoadshowId(roadShowId);
				reqDto.setColumnId(NumberUtils.toLong(columnIdArr[i]));
				this.add(reqDto);
			}
		}

		return Result.newSuccessResult(roadShowId);

	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseRoadshowColumnRel roadshowColumnRel = new BaseRoadshowColumnRel();
		roadshowColumnRel.setId(id);
		roadshowColumnRel.setUpdateDate(new Date());
		roadshowColumnRel.setUpdateUserId(super.getHeaderUserId());
		int count = baseRoadshowColumnRelMapper.updateByPrimaryKeySelective(roadshowColumnRel);
		return Result.newSuccessResult(count);
	}

	public Result<BaseRoadshowColumnRel> get(Long id) throws Exception {
		BaseRoadshowColumnRel model = baseRoadshowColumnRelMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<BaseRoadshowColumnRel>> getPage(RoadshowColumnRelReqDto roadshowColumnRelReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		BaseRoadshowColumnRelExample baseRoadshowColumnRelExample = new BaseRoadshowColumnRelExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseRoadshowColumnRelExample.Criteria criteria = baseRoadshowColumnRelExample.createCriteria();
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
		baseRoadshowColumnRelExample.setOrderByClause(orderByClause);
		List<BaseRoadshowColumnRel> list = baseRoadshowColumnRelMapper.selectByExample(baseRoadshowColumnRelExample);
		int totalCount = baseRoadshowColumnRelMapper.countByExample(baseRoadshowColumnRelExample);
		PaginationSupport<BaseRoadshowColumnRel> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
