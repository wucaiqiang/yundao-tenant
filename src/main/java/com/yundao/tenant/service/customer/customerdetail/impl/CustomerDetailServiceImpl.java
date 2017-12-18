package com.yundao.tenant.service.customer.customerdetail.impl;

import java.util.List;
import java.util.Date;
import com.yundao.tenant.mapper.base.customer.BaseCustomerDetailMapper;
import com.yundao.tenant.mapper.customer.customerdetail.CustomerDetailMapper;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.customer.BaseCustomerDetail;
import com.yundao.tenant.service.customer.customerdetail.CustomerDetailService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.dto.customer.customerdetail.CustomerDetailReqDto;
import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.constant.CommonConstant;
import com.yundao.tenant.model.base.customer.BaseCustomerDetailExample;
import com.yundao.core.utils.Limit;
import com.yundao.core.service.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerDetailServiceImpl extends AbstractService implements CustomerDetailService{

    @Autowired
    private BaseCustomerDetailMapper baseCustomerDetailMapper;

    @Autowired
    private CustomerDetailMapper customerDetailMapper;

    public Result<Integer> add(CustomerDetailReqDto reqDto) throws Exception{
    	BaseContactUtils.encrypt(reqDto);//加密
        BaseCustomerDetail model = new BaseCustomerDetail();
        BeanUtils.copyProperties(reqDto,model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        model.setTenantId(this.getHeaderTenantId());
        int count = baseCustomerDetailMapper.insertSelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> update(CustomerDetailReqDto reqDto) throws Exception{
    	BaseContactUtils.encrypt(reqDto);//加密
        BaseCustomerDetail model = new BaseCustomerDetail();
        BeanUtils.copyProperties(reqDto,model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerDetailMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    public Result<Integer> delete(Long id) throws Exception{
        BaseCustomerDetail customerDetail = new BaseCustomerDetail();
        customerDetail.setId(id);
        customerDetail.setUpdateDate(new Date());
        customerDetail.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerDetailMapper.updateByPrimaryKeySelective(customerDetail);
        return Result.newSuccessResult(count);
    }

    public Result<BaseCustomerDetail> get(Long id) throws Exception{
       BaseCustomerDetail model = baseCustomerDetailMapper.selectByPrimaryKey(id);
       if(model !=null){
    	   model.setWechat(BaseContactUtils.decrypt(model.getWechat()));
       }
       return Result.newSuccessResult(model);
    }

    public Result<PaginationSupport<BaseCustomerDetail>> getPage(CustomerDetailReqDto customerDetailReqDto, AbstractBasePageDto pageDto) throws Exception{
		BaseCustomerDetailExample baseCustomerDetailExample = new BaseCustomerDetailExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCustomerDetailExample.Criteria criteria = baseCustomerDetailExample.createCriteria();
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
		baseCustomerDetailExample.setOrderByClause(orderByClause);
		List<BaseCustomerDetail> list = baseCustomerDetailMapper.selectByExample(baseCustomerDetailExample);
		int totalCount = baseCustomerDetailMapper.countByExample(baseCustomerDetailExample);
		if(list !=null && !list.isEmpty()){
			for(BaseCustomerDetail detail:list){
				detail.setWechat(BaseContactUtils.decrypt(detail.getWechat()));
				detail.setQq(BaseContactUtils.decrypt(detail.getQq()));
			}
		}
		PaginationSupport<BaseCustomerDetail> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
    }

}
