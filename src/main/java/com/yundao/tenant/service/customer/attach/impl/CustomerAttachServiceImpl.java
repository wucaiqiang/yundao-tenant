
package com.yundao.tenant.service.customer.attach.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.attach.CustomerAttachDto;
import com.yundao.tenant.enums.customer.CustomerAttachTypeEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerAttachMapper;
import com.yundao.tenant.model.base.customer.BaseCustomerAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerAttachExample;
import com.yundao.tenant.model.base.customer.BaseCustomerAttachExample.Criteria;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.customer.attach.CustomerAttachService;

/**
 * Function: Reason: Date: 2017年8月10日 下午2:51:07
 * 
 * @author wucq
 * @version
 */
@Service
public class CustomerAttachServiceImpl extends AbstractService implements CustomerAttachService {
	@Autowired
	private BaseCustomerAttachMapper baseCustomerAttachMapper;

	@Override
	public List<CustomerAttachDto> selectByCustomerId(Long customerId) throws BaseException {
		BaseCustomerAttachExample example=new BaseCustomerAttachExample();
		Criteria criteria=example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		List<BaseCustomerAttach> attachs=baseCustomerAttachMapper.selectByExample(example);
		
		List<CustomerAttachDto> dtos=new ArrayList<>();
		
		if(attachs !=null && !attachs.isEmpty()){
			for(BaseCustomerAttach attach:attachs){
				CustomerAttachDto dto=new CustomerAttachDto();
				BeanUtils.copyProperties(attach, dto);
				dto.setTypeText(CustomerAttachTypeEnum.getEnumName(attach.getType()));
				dtos.add(dto);
			}
		}
		return dtos;

	}

	@Override
	public List<CustomerAttachDto> selectByCustomerIdAndType(Long customerId, Integer type) throws BaseException {
		
		BaseCustomerAttachExample example=new BaseCustomerAttachExample();
		Criteria criteria=example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		criteria.andTypeEqualTo(type);
		List<BaseCustomerAttach> attachs=baseCustomerAttachMapper.selectByExample(example);
		
		List<CustomerAttachDto> dtos=new ArrayList<>();
		
		if(attachs !=null && !attachs.isEmpty()){
			for(BaseCustomerAttach attach:attachs){
				CustomerAttachDto dto=new CustomerAttachDto();
				BeanUtils.copyProperties(attach, dto);
				dto.setTypeText(CustomerAttachTypeEnum.getEnumName(attach.getType()));
				dtos.add(dto);
			}
		}
		return dtos;
		
	}

	@Override
	public BaseCustomerAttach get(Long id) throws BaseException {
		BaseCustomerAttach attach=baseCustomerAttachMapper.selectByPrimaryKey(id);
		return attach;
		
	}

	@Override
	public int deleteByCustomerIdAndtype(Long customerId,Integer type) throws BaseException {
		if(customerId ==null){
			throw new BaseException(CodeConstant.CODE_1200000);
		}
		if(type==null){
			throw new BaseException(CodeConstant.CODE_1200090);
		}
		BaseCustomerAttachExample example =new BaseCustomerAttachExample();
		Criteria criteria=example.createCriteria();
		criteria.andCustomerIdEqualTo(customerId);
		criteria.andTypeEqualTo(type);
		int count=baseCustomerAttachMapper.deleteByExample(example);
		return count;
		
	}

	@Override
	public int insert(BaseCustomerAttach model) throws BaseException {
		if(model ==null){
			model=new BaseCustomerAttach();
		}
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setTenantId(super.getHeaderTenantId());
		model.setId(null);
		model.setIsDelete(CommonConstant.ZERO);
		
		int count=baseCustomerAttachMapper.insert(model);
		return count;
		
	}

	@Override
	public int update(BaseCustomerAttach model) throws BaseException {
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderTenantId());
		int count =baseCustomerAttachMapper.updateByPrimaryKey(model);
		return count;
	}

}
