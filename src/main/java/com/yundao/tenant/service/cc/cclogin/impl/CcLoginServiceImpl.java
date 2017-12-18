package com.yundao.tenant.service.cc.cclogin.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;
import com.yundao.tenant.mapper.base.cc.*;
import com.yundao.tenant.model.base.cc.*;
import com.yundao.tenant.service.question.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.dto.login.TicketModel;
import com.yundao.core.dto.login.UserAccountModel;
import com.yundao.core.dto.login.UserLoginResDto;
import com.yundao.core.enums.AppTypeEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.login.AbstractLoginService;
import com.yundao.core.threadlocal.ThreadLocalContextHolder;
import com.yundao.core.threadlocal.filter.RequestCommonParams;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.core.utils.DesUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.cc.cclogin.LoginDetailReqDto;
import com.yundao.tenant.model.base.cc.BaseCcTicketExample.Criteria;
import com.yundao.tenant.service.cc.ccuseraccount.CcUserAccountService;

@Service
public class CcLoginServiceImpl extends AbstractLoginService {

	@Autowired
	private BaseCcUserAccountMapper baseCcUserAccountMapper;

	@Autowired
	private BaseCcTicketMapper baseCcTicketMapper;

	@Autowired
	private CcUserAccountService ccUserAccountService;

	@Autowired
	private BaseCcLoginMapper baseCcLoginMapper;

	@Autowired
	private BaseCcLoginDetailMapper baseCcLoginDetailMapper;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private BaseCcUserDetailMapper baseCcUserDetailMapper;

	@Autowired
	private BaseCcCustomerUserRelMapper baseCcCustomerUserRelMapper;

	@Override
	protected UserAccountModel selectByMobileOrUsernmae(String userName) throws Exception {
		// 查手机
		String mobile = DesUtils.encrypt(userName);
		BaseCcUserAccountExample userAccountExample = new BaseCcUserAccountExample();
		userAccountExample.createCriteria().andMobileEqualTo(mobile);
		BaseCcUserAccount userAccount = baseCcUserAccountMapper.selectOne(userAccountExample);
		// 为空查用户名
		if (userAccount == null) {
			userAccountExample = new BaseCcUserAccountExample();
			userAccountExample.createCriteria().andUserNameEqualTo(userName);
			userAccount = baseCcUserAccountMapper.selectOne(userAccountExample);
		}
		if (userAccount == null) {
			return null;
		}
		UserAccountModel userAccountModel = new UserAccountModel();
		BeanUtils.copyProperties(userAccount, userAccountModel);
		return userAccountModel;
	}

	@Override
	protected Boolean isExist(String userName, String oldPassword) throws Exception {
		String mobile = DesUtils.encrypt(userName);
		BaseCcUserAccountExample example = new BaseCcUserAccountExample();
		example.createCriteria().andMobileEqualTo(mobile).andPasswordEqualTo(oldPassword);
		BaseCcUserAccount userAccount = baseCcUserAccountMapper.selectOne(example);
		if (userAccount != null) {
			return true;
		}
		example = new BaseCcUserAccountExample();
		example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(oldPassword);
		userAccount = baseCcUserAccountMapper.selectOne(example);
		if (userAccount != null) {
			return true;
		}
		return false;
	}

	@Override
	protected Integer updateUserPassword(String userName, String newPassword) throws Exception {
		String mobile = DesUtils.encrypt(userName);
		BaseCcUserAccountExample example = new BaseCcUserAccountExample();
		example.createCriteria().andMobileEqualTo(mobile);
		BaseCcUserAccount userAccount = baseCcUserAccountMapper.selectOne(example);
		if (userAccount == null) {
			example = new BaseCcUserAccountExample();
			example.createCriteria().andUserNameEqualTo(userName);
			userAccount = baseCcUserAccountMapper.selectOne(example);
		}
		if (userAccount == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210057);
		}
		userAccount.setPassword(newPassword);
		userAccount.setUpdateDate(new Date());
		userAccount.setUpdateUserId(super.getHeaderUserId());
		int count = baseCcUserAccountMapper.updateByPrimaryKeySelective(userAccount);
		return count;
	}

	@Override
	protected String processEncryptDBPassword(String password) throws Exception {
		return ccUserAccountService.processEncryptDBPassword(password);
	}

	@Override
	protected String processDecryptTranPassword(String password) throws Exception {
		return ccUserAccountService.processDecryptTranPassword(password);
	}

	@Override
	protected TicketModel insertTicket(Long userId, Object object, String ticketValue) throws Exception {
		RequestCommonParams requestParams = ThreadLocalContextHolder.getThreadLocalContext().getRequestCommonParams();
		if (StringUtils.isBlank(requestParams.getAppType())) {
			throw new BaseException(CodeConstant.CODE_1200132);
		}
		BaseCcTicket ticket = new BaseCcTicket();
		ticket.setUserAccountId(userId);
		ticket.setCreateDate(new Date());
		ticket.setCreateUserId(userId);
		ticket.setTicket(ticketValue);
		ticket.setTenantId(super.getHeaderTenantId());
		ticket.setType(requestParams.getAppType());
		if(AppTypeEnum.C_APP.getType().equals(requestParams.getAppType())){
			ticket.setActiveTime(Integer.parseInt(ConfigUtils.getValue("app.active.time", "300")));
		}else{
			ticket.setActiveTime(Integer.parseInt(ConfigUtils.getValue("pc.active.time", "300")));
		}
		ticket.setExpireTime(org.apache.commons.lang.time.DateUtils.addSeconds(new Date(), ticket.getActiveTime()));
		baseCcTicketMapper.insertSelective(ticket);
		TicketModel ticketModel = new TicketModel();
		BeanUtils.copyProperties(ticket, ticketModel);
		return ticketModel;
	}

	@Override
	protected Integer deleteByTicket(Long userId, boolean clearAll) throws Exception {
		BaseCcTicketExample ccTicketExample = new BaseCcTicketExample();
		Criteria criteria = ccTicketExample.createCriteria();
		criteria.andUserAccountIdEqualTo(userId);
		if (!clearAll) {
			RequestCommonParams requestParams = ThreadLocalContextHolder.getThreadLocalContext()
					.getRequestCommonParams();
			if (StringUtils.isBlank(requestParams.getAppType())) {
				throw new BaseException(CodeConstant.CODE_1200132);
			}
			criteria.andTypeEqualTo(requestParams.getAppType());
		}
		int count = baseCcTicketMapper.deleteByExample(ccTicketExample);
		return count;
	}

	protected Map<String, Object> loginAfter(UserLoginResDto dto, Object object) throws BaseException {
		LoginDetailReqDto loginDetailReqDto = (LoginDetailReqDto) object;
		// 记录登录日志
		BaseCcLogin ccLogin = new BaseCcLogin();
		ccLogin.setTenantId(super.getHeaderTenantId());
		ccLogin.setSystemCode(loginDetailReqDto.getSystemCode());
		ccLogin.setUserAccountId(dto.getId());
		ccLogin.setIp(loginDetailReqDto.getIp());
		ccLogin.setStatus(dto.getStatus());
		ccLogin.setTicket(dto.getTicket());
		ccLogin.setType(loginDetailReqDto.getType());
		ccLogin.setCreateDate(new Date());
		baseCcLoginMapper.insertSelective(ccLogin);
		// 日志详情2
		BaseCcLoginDetail loginDetail = new BaseCcLoginDetail();
		loginDetail.setTenantId(super.getHeaderTenantId());
		loginDetail.setLoginId(dto.getId());
		loginDetail.setOsName(loginDetail.getOsName());
		loginDetail.setDeviceType(loginDetail.getDeviceType());
		loginDetail.setDeviceName(loginDetail.getDeviceName());
		loginDetail.setResolution(loginDetail.getResolution());
		loginDetail.setUserAgent(loginDetail.getUserAgent());
		loginDetail.setBrowser(loginDetail.getBrowser());
		loginDetail.setRemark(loginDetail.getRemark());
		loginDetail.setCreateDate(new Date());
		baseCcLoginDetailMapper.insertSelective(loginDetail);

		//获取返回参数答题分数
		Result<RiskEvaluationResDto> riskEvaluationResDtoResult =  questionService.getRiskEvaluation(dto.getId());
		RiskEvaluationResDto resDto = riskEvaluationResDtoResult.getResult();
		Map<String,Object> params = new HashMap<>();
		params.put("evaluation", resDto);

		//真实姓名
		BaseCcUserDetailExample detailExample = new BaseCcUserDetailExample();
		detailExample.createCriteria().andUserAccountIdEqualTo(dto.getId());
		BaseCcUserDetail userDetail = baseCcUserDetailMapper.selectOne(detailExample);
		params.put("realName",userDetail == null ? null : userDetail.getRealName());

		//返回客户ID
		BaseCcCustomerUserRelExample userRelExample = new BaseCcCustomerUserRelExample();
		userRelExample.createCriteria().andUserAccountIdEqualTo(dto.getId());
		BaseCcCustomerUserRel customerUserRel = baseCcCustomerUserRelMapper.selectOne(userRelExample);
		if(customerUserRel != null){
			params.put("customerId",customerUserRel.getCustomerId());
		}
		return params;
	}
}
