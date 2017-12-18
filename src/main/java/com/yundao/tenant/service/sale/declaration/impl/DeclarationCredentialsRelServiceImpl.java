
package com.yundao.tenant.service.sale.declaration.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.enums.access.DataObjectEnum;
import com.yundao.tenant.enums.access.OperationPermissionEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerCredentialsMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerCredentialsRelMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationCredentialsRelMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRel;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRelExample;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationCredentialsRel;
import com.yundao.tenant.model.base.sale.BaseDeclarationCredentialsRelExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.dataobject.permission.DataObjectPermissionService;
import com.yundao.tenant.service.sale.declaration.DeclarationCredentialsRelService;

/**
 * Function: Reason: Date: 2017年9月5日 下午7:42:50
 * 
 * @author wucq
 * @version
 */
@Service
public class DeclarationCredentialsRelServiceImpl extends AbstractService implements DeclarationCredentialsRelService {
	@Autowired
	private BaseDeclarationCredentialsRelMapper baseDeclarationCredentialsRelMapper;
	@Autowired
	private BaseCustomerCredentialsMapper baseCustomerCredentialsMapper;
	@Autowired
	private BaseCustomerMapper baseCustomerMapper;
	@Autowired
	private DataObjectPermissionService dataObjectPermissionService;
	@Autowired
	private BaseDeclarationMapper baseDeclarationMapper;
	@Autowired
	private BaseCustomerCredentialsRelMapper baseCustomerCredentialsRelMapper;

	@Override
	public Integer add(BaseCustomerCredentials customerCredentials, Long declarationId) throws BaseException {
		customerCredentials.setCreateUserId(super.getHeaderUserId());
		customerCredentials.setCreateDate(new Date());
		customerCredentials.setId(null);
		int count = baseCustomerCredentialsMapper.insertSelective(customerCredentials);
		// 关联关系
		BaseDeclarationCredentialsRel credentialsRel = new BaseDeclarationCredentialsRel();
		credentialsRel.setCredentialsId(customerCredentials.getId());
		credentialsRel.setDeclarationId(declarationId);
		credentialsRel.setCreateUserId(super.getHeaderUserId());
		credentialsRel.setCreateDate(new Date());
		credentialsRel.setTenantId(super.getHeaderTenantId());
		baseDeclarationCredentialsRelMapper.insertSelective(credentialsRel);

		BaseDeclaration declaration=baseDeclarationMapper.selectByPrimaryKey(declarationId);
		if(declaration ==null){
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		// 是否有修改用户的权限
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(declaration.getCustomerId());
		Boolean isAuth = dataObjectPermissionService.check(DataObjectEnum.CUSTOMER.getCode(),
				OperationPermissionEnum.EDIT.getValue(), customer.getCreateUserId());
		if (isAuth) {
			// 是否需要回补客户
			
			BaseCustomerCredentialsRelExample relExample = new BaseCustomerCredentialsRelExample();
			relExample.createCriteria().andCustomerIdEqualTo(declaration.getCustomerId());
			List<BaseCustomerCredentialsRel> customerRels = baseCustomerCredentialsRelMapper
					.selectByExample(relExample);
			if (customerRels == null || customerRels.isEmpty()) {
				BaseCustomerCredentialsRel customerCredentialsRel = new BaseCustomerCredentialsRel();
				customerCredentialsRel.setCredentialsId(customerCredentials.getId());
				customerCredentialsRel.setCustomerId(declaration.getCustomerId());
				customerCredentialsRel.setCreateDate(new Date());
				customerCredentialsRel.setCreateUserId(super.getHeaderUserId());
				customerCredentialsRel.setTenantId(super.getHeaderTenantId());
				baseCustomerCredentialsRelMapper.insertSelective(customerCredentialsRel);
			}
		}

		return count;
	}

	@Override
	public BaseCustomerCredentials getCustomerCredentialsByDeclarationId(Long declarationId) throws BaseException {
		if (declarationId == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}

		BaseDeclarationCredentialsRelExample credentialsRelExample = new BaseDeclarationCredentialsRelExample();
		credentialsRelExample.createCriteria().andDeclarationIdEqualTo(declarationId);
		List<BaseDeclarationCredentialsRel> credentialsRels = baseDeclarationCredentialsRelMapper
				.selectByExample(credentialsRelExample);
		if (credentialsRels != null && !credentialsRels.isEmpty()) {
			BaseDeclarationCredentialsRel customerCredentialsRel = credentialsRels.get(0);
			BaseCustomerCredentials customerCredentials = baseCustomerCredentialsMapper
					.selectByPrimaryKey(customerCredentialsRel.getCredentialsId());
			return customerCredentials;
		}
		return null;

	}

}
