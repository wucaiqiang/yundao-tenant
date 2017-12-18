package com.yundao.tenant.service.customer.customeranniversaries.impl;

import java.util.List;
import java.util.Date;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.mapper.base.customer.BaseCustomerAnniversariesMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.customer.customeranniversaries.CustomerAnniversariesMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerAnniversaries;
import com.yundao.tenant.service.customer.customeranniversaries.CustomerAnniversariesService;
import com.yundao.tenant.dto.customer.customeranniversaries.CustomerAnniversariesReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.model.base.customer.BaseCustomerAnniversariesExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerAnniversariesServiceImpl extends AbstractService implements CustomerAnniversariesService{

    @Autowired
    private BaseCustomerAnniversariesMapper baseCustomerAnniversariesMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Autowired
    private CustomerAnniversariesMapper customerAnniversariesMapper;

    public Result<Integer> add(CustomerAnniversariesReqDto reqDto) throws Exception{
        BaseCustomerAnniversaries model = new BaseCustomerAnniversaries();
        BeanUtils.copyProperties(reqDto,model);
        validateData(model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        int count = baseCustomerAnniversariesMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    private void validateData(BaseCustomerAnniversaries model) throws BaseException {
        //验证客户是否存在
        Long customerId = model.getCustomerId();
        BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(customerId);
        if(customer == null){
            throw new BaseException(GJLCodeConstant.CODE_1210022);
        }
    }

    public Result<Integer> update(CustomerAnniversariesReqDto reqDto) throws Exception{
        BaseCustomerAnniversaries model = new BaseCustomerAnniversaries();
        BeanUtils.copyProperties(reqDto,model);
        validateData(model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerAnniversariesMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseCustomerAnniversaries customerAnniversaries = new BaseCustomerAnniversaries();
        customerAnniversaries.setId(id);
        customerAnniversaries.setUpdateDate(new Date());
        customerAnniversaries.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerAnniversariesMapper.updateByPrimaryKeySelective(customerAnniversaries);
        return Result.newSuccessResult(count);
    }

    public Result<BaseCustomerAnniversaries> get(Long id) throws Exception{
       BaseCustomerAnniversaries model = baseCustomerAnniversariesMapper.selectByPrimaryKey(id);
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseCustomerAnniversaries>> getPage(CustomerAnniversariesReqDto customerAnniversariesReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseCustomerAnniversariesExample baseCustomerAnniversariesExample = new BaseCustomerAnniversariesExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCustomerAnniversariesExample.Criteria criteria = baseCustomerAnniversariesExample.createCriteria();
		String orderByClause="create_date desc";
		if(StringUtils.isNotBlank(pageDto.getOrderColumn())){
		  StringBuilder orderBuider=new StringBuilder();
		  orderBuider.append(pageDto.getOrderColumn()).append(" ");
		  if(StringUtils.isNotBlank(pageDto.getSort())){
			orderBuider.append(pageDto.getSort());
		  }else{
			orderBuider.append("desc");
		  }
		  orderByClause=orderBuider.toString();
		}
		baseCustomerAnniversariesExample.setOrderByClause(orderByClause);
		List<BaseCustomerAnniversaries> list = baseCustomerAnniversariesMapper.selectByExample(baseCustomerAnniversariesExample);
		int totalCount = baseCustomerAnniversariesMapper.countByExample(baseCustomerAnniversariesExample);
		PaginationSupport<BaseCustomerAnniversaries> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

    @Override
    public Result<List<BaseCustomerAnniversaries>> getByCustomerId(Long customerId) throws BaseException {
        if(customerId != null){
            throw new BaseException(GJLCodeConstant.CODE_1210019);
        }
        BaseCustomerAnniversariesExample example = new BaseCustomerAnniversariesExample();
        BaseCustomerAnniversariesExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(customerId);
        List<BaseCustomerAnniversaries> result = baseCustomerAnniversariesMapper.selectByExample(example);
        return Result.newSuccessResult(result);
    }

}
