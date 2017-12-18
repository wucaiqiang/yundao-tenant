package com.yundao.tenant.service.customerfollowupattach.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.customerfollowupattach.CustomerFollowUpAttachReqDto;
import com.yundao.tenant.mapper.base.customer.BaseCustomerFollowUpAttachMapper;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttachExample;
import com.yundao.tenant.service.customerfollowupattach.CustomerFollowUpAttachService;

@Service
public class CustomerFollowUpAttachServiceImpl extends AbstractService implements CustomerFollowUpAttachService {

	@Autowired
	private BaseCustomerFollowUpAttachMapper baseCustomerFollowUpAttachMapper;

	public Result<Integer> add(CustomerFollowUpAttachReqDto reqDto) throws Exception {
		BaseCustomerFollowUpAttach model = new BaseCustomerFollowUpAttach();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		model.setTenantId(this.getHeaderTenantId());
		int count = baseCustomerFollowUpAttachMapper.insertSelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> update(CustomerFollowUpAttachReqDto reqDto) throws Exception {
		BaseCustomerFollowUpAttach model = new BaseCustomerFollowUpAttach();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerFollowUpAttachMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseCustomerFollowUpAttach customerFollowUpAttach = new BaseCustomerFollowUpAttach();
		customerFollowUpAttach.setId(id);
		customerFollowUpAttach.setUpdateDate(new Date());
		customerFollowUpAttach.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerFollowUpAttachMapper.updateByPrimaryKeySelective(customerFollowUpAttach);
		return Result.newSuccessResult(count);
	}

	public Result<BaseCustomerFollowUpAttach> get(Long id) throws Exception {
		BaseCustomerFollowUpAttach model = baseCustomerFollowUpAttachMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<BaseCustomerFollowUpAttach>> getPage(
			CustomerFollowUpAttachReqDto customerFollowUpAttachReqDto, AbstractBasePageDto pageDto) throws Exception {
		BaseCustomerFollowUpAttachExample baseCustomerFollowUpAttachExample = new BaseCustomerFollowUpAttachExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCustomerFollowUpAttachExample.Criteria criteria = baseCustomerFollowUpAttachExample.createCriteria();
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
		baseCustomerFollowUpAttachExample.setOrderByClause(orderByClause);
		List<BaseCustomerFollowUpAttach> list = baseCustomerFollowUpAttachMapper
				.selectByExample(baseCustomerFollowUpAttachExample);
		int totalCount = baseCustomerFollowUpAttachMapper.countByExample(baseCustomerFollowUpAttachExample);
		PaginationSupport<BaseCustomerFollowUpAttach> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

}
