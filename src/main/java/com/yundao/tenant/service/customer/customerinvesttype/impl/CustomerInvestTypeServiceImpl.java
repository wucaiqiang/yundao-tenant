package com.yundao.tenant.service.customer.customerinvesttype.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeDto;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeReqDto;
import com.yundao.tenant.mapper.base.BaseFieldGroupMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerInvestTypeMapper;
import com.yundao.tenant.mapper.customer.customerinvesttype.CustomerInvestTypeMapper;
import com.yundao.tenant.model.base.BaseFieldGroup;
import com.yundao.tenant.model.base.BaseFieldGroupExample;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestType;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestTypeExample;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestTypeExample.Criteria;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.customer.customerinvesttype.CustomerInvestTypeService;

@Service
public class CustomerInvestTypeServiceImpl extends AbstractService implements CustomerInvestTypeService {

    @Autowired
    private BaseCustomerInvestTypeMapper baseCustomerInvestTypeMapper;

    @Autowired
    private CustomerInvestTypeMapper customerInvestTypeMapper;

    @Autowired
    private BaseFieldGroupMapper baseFieldGroupMapper;

    public Result<Integer> add(CustomerInvestTypeReqDto reqDto) throws Exception {
        BaseCustomerInvestType model = new BaseCustomerInvestType();
        BeanUtils.copyProperties(reqDto, model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseCustomerInvestTypeMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(CustomerInvestTypeReqDto reqDto) throws Exception {
        BaseCustomerInvestType model = new BaseCustomerInvestType();
        BeanUtils.copyProperties(reqDto, model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerInvestTypeMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception {
        BaseCustomerInvestType customerInvestType = new BaseCustomerInvestType();
        customerInvestType.setId(id);
        customerInvestType.setUpdateDate(new Date());
        customerInvestType.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerInvestTypeMapper.updateByPrimaryKeySelective(customerInvestType);
        return Result.newSuccessResult(count);
    }

    @Override
	public Result<Integer> deleteByCustomerId(Long customerId) throws Exception {
    	BaseCustomerInvestTypeExample example=new BaseCustomerInvestTypeExample();
    	Criteria criteria=example.createCriteria();
    	criteria.andCustomerIdEqualTo(customerId);
    	int count=baseCustomerInvestTypeMapper.deleteByExample(example);
		return Result.newSuccessResult(count);
		
	}

    public Result<BaseCustomerInvestType> get(Long id) throws Exception {
        BaseCustomerInvestType model = baseCustomerInvestTypeMapper.selectByPrimaryKey(id);
        return Result.newSuccessResult(model);
    }

    @Override
    public Result<List<CustomerInvestTypeDto>> getByCustomerId(Long customerId) throws Exception {
        List<CustomerInvestTypeDto> dtos = customerInvestTypeMapper.selectByCustomerId(customerId);
        return Result.newSuccessResult(dtos);

    }

    public Result<PaginationSupport<BaseCustomerInvestType>> getPage(CustomerInvestTypeReqDto customerInvestTypeReqDto, AbstractBasePageDto pageDto) throws Exception {
        BaseCustomerInvestTypeExample baseCustomerInvestTypeExample = new BaseCustomerInvestTypeExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseCustomerInvestTypeExample.Criteria criteria = baseCustomerInvestTypeExample.createCriteria();
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
        baseCustomerInvestTypeExample.setOrderByClause(orderByClause);
        List<BaseCustomerInvestType> list = baseCustomerInvestTypeMapper.selectByExample(baseCustomerInvestTypeExample);
        int totalCount = baseCustomerInvestTypeMapper.countByExample(baseCustomerInvestTypeExample);
        PaginationSupport<BaseCustomerInvestType> result = pageDto.getPaginationSupport();
        result.setDatas(list);
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<Boolean> addCustomerInvest(Long customerId, String investTypes) throws BaseException {
        if (BooleanUtils.isEmpty(investTypes)) {
            return null;
        }
        //去除重复值。
        List<Long> typeIds = removeRepeat(investTypes);
        if (typeIds == null || typeIds.isEmpty()) {
            return null;
        }
        //判断类型是否都在。
        BaseFieldGroupExample groupExample = new BaseFieldGroupExample();
        groupExample.createCriteria().andIdIn(typeIds);
        List<BaseFieldGroup> groups = baseFieldGroupMapper.selectByExample(groupExample);
        if (typeIds.size() != groups.size()) {
            throw new BaseException(GJLCodeConstant.CODE_1210044);
        }
        //新增客户投资偏好
        BaseCustomerInvestType investType = new BaseCustomerInvestType();
        for (int i = 0; i < typeIds.size(); i++) {
            Long typeId = typeIds.get(i);
            investType.setId(null);
            investType.setCustomerId(customerId);
            investType.setProductTypeId(typeId);
            investType.setCreateDate(new Date());
            investType.setCreateUserId(super.getHeaderUserId());
            investType.setTenantId(super.getHeaderTenantId());
            investType.setIsDelete(CommonConstant.ZERO);
            baseCustomerInvestTypeMapper.insertSelective(investType);
        }
        return Result.newSuccessResult(true);
    }

    private List<Long> removeRepeat(String investTypes) {
        String[] ids = investTypes.split(",");
        List<Long> result = new ArrayList<>();
        for (String id : ids) {
            Long typeId = Long.valueOf(id);
            if (!result.contains(typeId)) {
                result.add(typeId);
            }
        }
        return result;
    }

}
