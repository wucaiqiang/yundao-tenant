
package com.yundao.tenant.service.user.customer.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.user.customer.UserCustomerReqDto;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample.Criteria;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.user.customer.UserCustomerService;

/**
 * Function: Reason: Date: 2017年8月9日 下午3:59:59
 *
 * @author wucq
 */
@Service
public class UserCustomerServiceImpl extends AbstractService implements UserCustomerService {
	@Autowired
	private BaseUserCustomerMapper baseUserCustomerMapper;
	@Autowired
	private CustomerService customerService;

	@Override
	public Integer insert(BaseUserCustomer record) throws BaseException {
		
		record.setTenantId(this.getHeaderTenantId());
		record.setDistributionDate(new Date());
		record.setDistributionUserId(this.getHeaderUserId());
		record.setIsDelete(0);
		int count = baseUserCustomerMapper.insert(record);
		return count;

	}

	@Override
	public BaseUserCustomer select(UserCustomerReqDto reqDto) throws BaseException {
		BaseUserCustomerExample example = new BaseUserCustomerExample();
		Criteria criteria = example.createCriteria();
		if (reqDto.getCustomerId() != null) {
			criteria.andCustomerIdEqualTo(reqDto.getCustomerId());
		}
		if (reqDto.getUserId() != null) {
			criteria.andUserIdEqualTo(reqDto.getUserId());
		}
		BaseUserCustomer customer = baseUserCustomerMapper.selectOne(example);
		return customer;
	}

	@Override
	public Map<Long, BaseUserCustomer> getUserByCustomer(List<Long> customerId) {
		BaseUserCustomerExample example = new BaseUserCustomerExample();
		example.createCriteria().andCustomerIdIn(customerId);
		List<BaseUserCustomer> baseUserCustomers = baseUserCustomerMapper.selectByExample(example);
		Map<Long, BaseUserCustomer> result = new HashMap<>();
		if (baseUserCustomers != null) {
			baseUserCustomers.forEach(m -> result.put(m.getCustomerId(), m));
		}
		return result;
	}

	/**
	 * 获取客户的理财师id集合
	 *
	 * @param customerId
	 * @return
	 */
	@Override
	public Long getUserIdByCustomer(Long customerId) {
		BaseUserCustomerExample example = new BaseUserCustomerExample();
		example.createCriteria().andCustomerIdEqualTo(customerId);
		List<BaseUserCustomer> baseUserCustomers = baseUserCustomerMapper.selectByExample(example);
		if (BooleanUtils.isEmpty(baseUserCustomers)) {
			return null;
		}
		return baseUserCustomers.get(0).getUserId();
	}


	@Override
	public BaseUserCustomer getByCustomerId(Long customerId) throws BaseException {
		if (customerId == null)
			throw new BaseException(CodeConstant.CODE_1220047);
		BaseUserCustomerExample example = new BaseUserCustomerExample();
		example.createCriteria().andCustomerIdEqualTo(customerId);
		return baseUserCustomerMapper.selectOne(example);
	}

}
