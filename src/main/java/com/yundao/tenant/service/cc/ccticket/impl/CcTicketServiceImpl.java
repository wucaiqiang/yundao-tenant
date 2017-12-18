package com.yundao.tenant.service.cc.ccticket.impl;

import com.yundao.core.dto.login.TicketModel;
import com.yundao.core.dto.login.UserAccountModel;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.ticket.AbstractTicketService;
import com.yundao.core.threadlocal.ThreadLocalContextHolder;
import com.yundao.core.threadlocal.filter.RequestCommonParams;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.mapper.base.cc.BaseCcTicketMapper;
import com.yundao.tenant.mapper.base.cc.BaseCcUserAccountMapper;
import com.yundao.tenant.model.base.cc.BaseCcTicket;
import com.yundao.tenant.model.base.cc.BaseCcTicketExample;
import com.yundao.tenant.model.base.cc.BaseCcTicketExample.Criteria;
import com.yundao.tenant.model.base.cc.BaseCcUserAccount;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CcTicketServiceImpl extends AbstractTicketService {

	@Autowired
	private BaseCcTicketMapper baseCcTicketMapper;

	@Autowired
	private BaseCcUserAccountMapper baseCcUserAccountMapper;

	@Override
	protected TicketModel selectByTicket(String ticket) throws Exception {
		RequestCommonParams requestParams = ThreadLocalContextHolder.getThreadLocalContext().getRequestCommonParams();
		if (StringUtils.isBlank(requestParams.getAppType())) {
			throw new BaseException(CodeConstant.CODE_1200132);
		}
		BaseCcTicketExample ticketExample = new BaseCcTicketExample();
		Criteria criteria = ticketExample.createCriteria();
		criteria.andTicketEqualTo(ticket);
		criteria.andTypeEqualTo(requestParams.getAppType());
		BaseCcTicket ccTicket = baseCcTicketMapper.selectOne(ticketExample);
		if (ccTicket == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210086);
		}
		TicketModel ticketModel = new TicketModel();
		BeanUtils.copyProperties(ticketModel, ccTicket);
		ticketModel.setAccountId(ccTicket.getUserAccountId());
		return ticketModel;
	}

	@Override
	protected int updateByPrimaryKeySelective(TicketModel model) throws Exception{
		BaseCcTicket ccTicket = new BaseCcTicket();
		BeanUtils.copyProperties(model, ccTicket);
		ccTicket.setUserAccountId(model.getAccountId());
		int count = baseCcTicketMapper.updateByPrimaryKeySelective(ccTicket);
		return count;
	}

	@Override
	protected UserAccountModel selectUserById(Long accountId) throws Exception{
		BaseCcUserAccount userAccount = baseCcUserAccountMapper.selectByPrimaryKey(accountId);
		UserAccountModel userAccountModel = new UserAccountModel();
		BeanUtils.copyProperties(userAccount, userAccountModel);
		return userAccountModel;
	}
}