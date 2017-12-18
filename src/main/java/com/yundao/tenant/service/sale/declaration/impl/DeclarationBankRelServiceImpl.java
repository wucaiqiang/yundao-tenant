

package com.yundao.tenant.service.sale.declaration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.mapper.base.customer.BaseCustomerBankMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationBankRelMapper;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.model.base.sale.BaseDeclarationBankRel;
import com.yundao.tenant.model.base.sale.BaseDeclarationBankRelExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.sale.declaration.DeclarationBankRelService;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月5日 下午5:57:35 
 * @author   wucq
 * @version   
 */
@Service
public class DeclarationBankRelServiceImpl extends AbstractService implements DeclarationBankRelService {
	@Autowired
	private BaseDeclarationBankRelMapper baseDeclarationBankRelMapper;

	@Autowired
	private BaseCustomerBankMapper baseCustomerBankMapper;
	
	@Override
	public BaseCustomerBank getCustomerBankByDeclarationId(Long declarationId) throws BaseException {
		if (declarationId ==null) {
			throw new BaseException(GJLCodeConstant.CODE_1210066);
		}
		BaseDeclarationBankRelExample bankRelExample = new BaseDeclarationBankRelExample();
		bankRelExample.createCriteria().andDeclarationIdEqualTo(declarationId);
		List<BaseDeclarationBankRel> declarationBankRels = baseDeclarationBankRelMapper.selectByExample(bankRelExample);
		if(declarationBankRels !=null && !declarationBankRels.isEmpty()){
			BaseDeclarationBankRel bankRel=declarationBankRels.get(0);
			BaseCustomerBank customerBank = baseCustomerBankMapper.selectByPrimaryKey(bankRel.getBankId());
			return customerBank;
		}
		return null;
		
	}

}

