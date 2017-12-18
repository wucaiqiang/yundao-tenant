package com.yundao.tenant.service.customer.tag.impl;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.customer.tag.TagReqDto;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerTagMapper;
import com.yundao.tenant.mapper.base.customer.BaseTagMapper;
import com.yundao.tenant.mapper.customer.tag.TagMapper;
import com.yundao.tenant.model.base.customer.*;
import com.yundao.tenant.service.customer.tag.TagService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

//import com.yundao.tenant.mapper.base.customer.BaseCustomerTagMapper;

@Service
public class TagServiceImpl extends AbstractService implements TagService {

	@Autowired
	private BaseTagMapper baseTagMapper;

	@Autowired
	private TagMapper tagMapper;

	@Autowired
	private BaseCustomerMapper baseCustomerMapper;

	@Autowired
	private BaseCustomerTagMapper baseCustomerTagMapper;

	public Result<Integer> add(TagReqDto reqDto) throws Exception {
		BaseTag model = new BaseTag();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		int count = baseTagMapper.insertSelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> update(TagReqDto reqDto) throws Exception {
		BaseTag model = new BaseTag();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseTagMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseTag tag = new BaseTag();
		tag.setId(id);
		tag.setUpdateDate(new Date());
		tag.setUpdateUserId(super.getHeaderUserId());
		int count = baseTagMapper.updateByPrimaryKeySelective(tag);
		return Result.newSuccessResult(count);
	}

	public Result<BaseTag> get(Long id) throws Exception {
		BaseTag model = baseTagMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<BaseTag>> getPage(TagReqDto tagReqDto) throws Exception {
		Map<String, Object> paramMap = LocalBeanUtils.toMap(tagReqDto);
		List<BaseTag> list = tagMapper.getPage(paramMap);
		int totalCount = tagMapper.getCount(paramMap);
		PaginationSupport<BaseTag> result = tagReqDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	@Override
	public Result<List<BaseTag>> getAll() throws Exception {
		List<BaseTag> tags = tagMapper.selectTop(null);
		return Result.newSuccessResult(tags);

	}

	@Override
	public Result<List<BaseTag>> getTop(Integer limit) {
		if (limit == null) {
			limit = 30;
		}
		List<BaseTag> tags = tagMapper.selectTop(limit);
		return Result.newSuccessResult(tags);
	}

	@Override
	public Result<Boolean> processSetCustomerTag(Long customerId, String tags) throws Exception {
		if (customerId == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210022);
		}
		// 新增的时候客户还不在数据库中
		// BaseCustomer customer =
		// baseCustomerMapper.selectByPrimaryKey(customerId);
		// if(customer == null){
		// throw new BaseException(GJLCodeConstant.CODE_1210022);
		// }
		// 清楚客户的关联关系
		deleteCustomerTag(customerId);
		// 新增新的客户关系 考虑合并的情况
		if (BooleanUtils.isNotEmpty(tags)) {
			String[] tagArrs = tags.split(",");
			if (tagArrs.length > 30) {
				throw new BaseException(GJLCodeConstant.CODE_1210058);
			}
			List<String> tagNames = Arrays.asList(tagArrs);
			BaseTagExample tagExample = new BaseTagExample();
			tagExample.createCriteria().andNameIn(tagNames);
			List<BaseTag> baseTags = baseTagMapper.selectByExample(tagExample);
			List<Long> tagIds = addTag(tagNames, baseTags);
			addCustomerTags(customerId, tagIds);
		}
		return Result.newSuccessResult(true);
	}

	private void addCustomerTags(Long customerId, List<Long> tagIds) {
		BaseCustomerTag customerTag = new BaseCustomerTag();
		customerTag.setCreateDate(new Date());
		customerTag.setCreateUserId(super.getHeaderUserId());
		for (Long tagId : tagIds) {
			customerTag.setId(null);
			customerTag.setCustomerId(customerId);
			customerTag.setTagId(tagId);
			customerTag.setTenantId(super.getHeaderTenantId());
			customerTag.setIsDelete(CommonConstant.ZERO);
			baseCustomerTagMapper.insertSelective(customerTag);
		}
	}

	private List<Long> addTag(List<String> tagNames, List<BaseTag> baseTags) {
		List<Long> tagIds = new ArrayList<>();
		for (String name : tagNames) {
			Boolean isNot = true;
			for (BaseTag tag : baseTags) {
				if (name.equals(tag.getName())) {
					isNot = false;
					tagIds.add(tag.getId());
					break;
				}
			}
			if (isNot) {
				BaseTag tag = new BaseTag();
				tag.setCreateDate(new Date());
				tag.setCreateUserId(super.getHeaderUserId());
				tag.setName(BooleanUtils.isNotBlank(name) ? name.trim() : name);
				tag.setTenantId(super.getHeaderTenantId());
				tag.setIsDelete(CommonConstant.ZERO);
				baseTagMapper.insertSelective(tag);
				tagIds.add(tag.getId());
			}
		}
		return tagIds;
	}

	private void deleteCustomerTag(Long customerId) {
		BaseCustomerTagExample tagExample = new BaseCustomerTagExample();
		tagExample.createCriteria().andCustomerIdEqualTo(customerId);
		baseCustomerTagMapper.deleteByExample(tagExample);
	}

	public Result<List<BaseTag>> getCustomerTag(Long customerId) throws BaseException {
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(customerId);
		if (customer == null || customer.getIsDelete() == CommonConstant.ONE) {
			throw new BaseException(GJLCodeConstant.CODE_1210057);
		}
		BaseCustomerTagExample tagExample = new BaseCustomerTagExample();
		tagExample.createCriteria().andCustomerIdEqualTo(customerId);
		List<BaseCustomerTag> customerTags = baseCustomerTagMapper.selectByExample(tagExample);
		List<BaseTag> baseTags = new ArrayList<>();
		if (customerTags != null && !customerTags.isEmpty()) {
			BaseTagExample baseTagExample = new BaseTagExample();
			baseTagExample.createCriteria().andIdIn(LambdaMap.toSingleList(customerTags, m -> m.getTagId()));
			baseTags = baseTagMapper.selectByExample(baseTagExample);
		}
		return Result.newSuccessResult(baseTags);
	}

	@Override
	public List<Long> getCustomerIdLikeNames(List<String> tags) throws BaseException {
		return tagMapper.selectCustomerIdByNames(tags);
	}
}
