package com.yundao.tenant.service.videocategory.impl;

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
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.videocategory.VideoCategoryReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.mapper.base.video.BaseVideoCategoryMapper;
import com.yundao.tenant.model.base.video.BaseVideoCategory;
import com.yundao.tenant.model.base.video.BaseVideoCategoryExample;
import com.yundao.tenant.service.videocategory.VideoCategoryService;

@Service
public class VideoCategoryServiceImpl extends AbstractService implements VideoCategoryService {

	@Autowired
	private BaseVideoCategoryMapper baseVideoCategoryMapper;

	public Result<Integer> add(VideoCategoryReqDto reqDto) throws Exception {
		BaseVideoCategory model = new BaseVideoCategory();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		model.setTenantId(this.getHeaderTenantId());
		int count = baseVideoCategoryMapper.insertSelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> update(VideoCategoryReqDto reqDto) throws Exception {
		BaseVideoCategory model = new BaseVideoCategory();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseVideoCategoryMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseVideoCategory videoCategory = new BaseVideoCategory();
		videoCategory.setId(id);
		videoCategory.setUpdateDate(new Date());
		videoCategory.setUpdateUserId(super.getHeaderUserId());
		videoCategory.setIsDelete(DeleteEnum.DELETED.getValue());
		int count = baseVideoCategoryMapper.updateByPrimaryKeySelective(videoCategory);
		return Result.newSuccessResult(count);
	}

	public Result<BaseVideoCategory> get(Long id) throws Exception {
		BaseVideoCategory model = baseVideoCategoryMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	@Override
	public BaseVideoCategory getOne() throws BaseException {
		BaseVideoCategoryExample example = new BaseVideoCategoryExample();
		example.setOrderByClause("create_date desc");
		BaseVideoCategory baseVideoCategory = baseVideoCategoryMapper.selectOne(example);
		return baseVideoCategory;

	}

	public Result<PaginationSupport<BaseVideoCategory>> getPage(VideoCategoryReqDto videoCategoryReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		BaseVideoCategoryExample baseVideoCategoryExample = new BaseVideoCategoryExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseVideoCategoryExample.Criteria criteria = baseVideoCategoryExample.createCriteria();
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
		baseVideoCategoryExample.setOrderByClause(orderByClause);
		List<BaseVideoCategory> list = baseVideoCategoryMapper.selectByExample(baseVideoCategoryExample);
		int totalCount = baseVideoCategoryMapper.countByExample(baseVideoCategoryExample);
		PaginationSupport<BaseVideoCategory> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
