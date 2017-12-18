package com.yundao.tenant.service.customer.customerfollowup.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.MsgConstant;
import com.yundao.tenant.constant.code.Code1220000;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpPageDto;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpPageResDto;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpReqDto;
import com.yundao.tenant.dto.customerfollowupattach.CustomerFollowUpAttachReqDto;
import com.yundao.tenant.dto.user.customer.UserCustomerReqDto;
import com.yundao.tenant.enums.customer.CustomerFollowNextEnum;
import com.yundao.tenant.enums.customer.MapTypeEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerFollowUpAttachMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerFollowUpMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.customer.customerfollowup.CustomerFollowUpMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUp;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpAttachExample;
import com.yundao.tenant.model.base.customer.BaseCustomerFollowUpExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.service.customer.customerfollowup.CustomerFollowUpService;
import com.yundao.tenant.service.customerfollowupattach.CustomerFollowUpAttachService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.util.ArgsUtils;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.LocalBeanUtils;

@Service
public class CustomerFollowUpServiceImpl extends AbstractService implements CustomerFollowUpService {

	private static Log log = LogFactory.getLog(CustomerFollowUpServiceImpl.class);
	@Autowired
	private BaseCustomerFollowUpMapper baseCustomerFollowUpMapper;

	@Autowired
	private CustomerFollowUpMapper customerFollowUpMapper;

	@Autowired
	private BaseCustomerMapper customerMapper;

	@Autowired
	private MsgMessageService msgMessageService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private CustomerFollowUpAttachService customerFollowUpAttachService;
	@Autowired
	private BaseCustomerFollowUpAttachMapper baseCustomerFollowUpAttachMapper;

	public Result<Long> add(CustomerFollowUpReqDto reqDto) throws Exception {
		validate(reqDto);
		// 获取客户对应的理财师
		UserCustomerReqDto userCustomerReqDto = new UserCustomerReqDto();
		userCustomerReqDto.setCustomerId(reqDto.getCustomerId());
		userCustomerReqDto.setUserId(this.getHeaderUserId());
		BaseUserCustomer baseUserCustomer = userCustomerService.select(userCustomerReqDto);
		if (baseUserCustomer == null) {
			throw new BaseException(Code1220000.CODE_1220150);
		}
		Long userId = super.getHeaderUserId();
		if (!baseUserCustomer.getUserId().equals(userId)) {
			throw new BaseException(Code1220000.CODE_1220150);
		}

		BaseCustomerFollowUp model = new BaseCustomerFollowUp();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(userId);
		model.setTenantId(super.getHeaderTenantId());
		model.setId(null);
		baseCustomerFollowUpMapper.insertSelective(model);

		// 添加客户跟进附件信息
		if (StringUtils.isNotBlank(reqDto.getAttachs())) {
			List<String> attachs = JsonUtils.jsonToObject(reqDto.getAttachs(), new BaseTypeReference<List<String>>() {
			});
			for (String url : attachs) {
				CustomerFollowUpAttachReqDto attach = new CustomerFollowUpAttachReqDto();
				attach.setCustoemrFollowUpId(model.getId());
				attach.setUrl(url);
				int index_ = url.lastIndexOf(".");
				int index_1 = url.lastIndexOf("/");
				if (index_ != -1) {
					attach.setFormat(url.substring(index_ + 1));
					if (index_1 != -1) {
						attach.setName(url.substring(index_1 + 1, index_));
					}
				}
				customerFollowUpAttachService.add(attach);
			}
		}
		// 发送下次跟进消息
		sendToMessage(model, baseUserCustomer);
		return Result.newSuccessResult(model.getId());
	}

	private void sendToMessage(BaseCustomerFollowUp model, BaseUserCustomer baseUserCustomer) throws Exception {
		// 客户跟进发送动态
		Map<String, Object> feedParams = ArgsUtils.toMap(model);
		feedParams.put("typeName",
				dictionaryService.toText(DicCode.DIC_FOLLOW_UP_TYPE, model.getType() + CommonConstant.BLANK));
		feedParams.put("statusName",
				dictionaryService.toText(DicCode.DIC_FOLLOW_UP_STATUS, model.getStatus() + CommonConstant.BLANK));
		feedParams.put("createUserName", super.getHeaderUser().getRealName());
		msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_FOLLOW.getCode(), feedParams);
		// 如果有下次跟进时间并且时间在今天内部直接发送消息
		Date nowEnd = DateUtils.parse(DateUtils.getDateEnd(new Date()), DateUtils.YY_MM_DD_HH_MM_SS);
		if (model.getNextFollowDate() != null && DateUtils.getDistanceTimes(model.getNextFollowDate(), nowEnd) < 1) {
			sendNextMessage(model, baseUserCustomer);
		}
	}

	private void sendNextMessage(BaseCustomerFollowUp model, BaseUserCustomer baseUserCustomer) throws BaseException {
		if (baseUserCustomer == null) {
			log.error("有找到跟进对应的客户信息，客户ID：" + model.getCustomerId());
			return;
		}
		Map<String, Object> params = ArgsUtils.toMap(model);
		params.put(MsgConstant.OPT_TIME, model.getCreateDate());
		params.put("userId", baseUserCustomer.getUserId());
		params.put("nextFollowDate", DateUtils.format(model.getNextFollowDate(), DateUtils.YYYY_MM_DD_HH_MM));
		BaseCustomer customer = customerMapper.selectByPrimaryKey(model.getCustomerId());
		params.put("name", customer.getName());
		params.put("mobile", BaseContactUtils.decrypt(customer.getMobile()));
		msgMessageService.processSendMessage(MsgMessageCodeEnum.NEXT_FOLLOW.getCode(), params);
		model.setNextMessageSend(CustomerFollowNextEnum.STATSU_2.getValue());
		baseCustomerFollowUpMapper.updateByPrimaryKeySelective(model);
	}

	private void validate(CustomerFollowUpReqDto reqDto) throws BaseException {
		Long customerId = reqDto.getCustomerId();
		BaseCustomer customer = customerMapper.selectByPrimaryKey(customerId);
		if (customer == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210022);
		}
		if (reqDto.getNextFollowDate() != null
				&& DateUtils.getDistanceTimes(reqDto.getNextFollowDate(), new Date()) < 1) {
			throw new BaseException(GJLCodeConstant.CODE_1210056);
		}
	}

	public Result<Integer> update(CustomerFollowUpReqDto reqDto) throws Exception {
		BaseCustomerFollowUp model = new BaseCustomerFollowUp();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerFollowUpMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseCustomerFollowUp customerFollowUp = new BaseCustomerFollowUp();
		customerFollowUp.setId(id);
		customerFollowUp.setUpdateDate(new Date());
		customerFollowUp.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerFollowUpMapper.updateByPrimaryKeySelective(customerFollowUp);
		return Result.newSuccessResult(count);
	}

	public Result<BaseCustomerFollowUp> get(Long id) throws Exception {
		BaseCustomerFollowUp model = baseCustomerFollowUpMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<CustomerFollowUpPageResDto>> getPage(CustomerFollowUpPageDto dto,
			Integer permission) throws Exception {
		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
		PaginationSupport<CustomerFollowUpPageResDto> page = PaginationSupport.newDefault(paramMap);
		// 根据不同权限，设置查询条件
		userService.setPermissionCondition(paramMap, permission);
		List<BaseCustomerFollowUp> datas = customerFollowUpMapper.selectPageByCustomerId(paramMap);
		if (BooleanUtils.isEmpty(datas))
			return Result.newSuccessResult(page);
		int count = customerFollowUpMapper.selectPageByCustomerIdCount(paramMap);
		page.setTotalCount(count);
		List<CustomerFollowUpPageResDto> dtos = this.setText(datas);
		// 设置附件
		this.setAttachs(dtos);
		page.setDatas(dtos);
		return Result.newSuccessResult(page);
	}

	@Override
	public Result<Long> processFollow() throws Exception {
		// 获取今天未生成消息
		Date nowEnd = DateUtils.parse(DateUtils.getDateEnd(new Date()), DateUtils.YY_MM_DD_HH_MM_SS);
		BaseCustomerFollowUpExample example = new BaseCustomerFollowUpExample();
		example.createCriteria().andNextMessageSendEqualTo(CustomerFollowNextEnum.STATSU_1.getValue())
				.andNextFollowDateLessThanOrEqualTo(nowEnd);
		List<BaseCustomerFollowUp> followUps = baseCustomerFollowUpMapper.selectByExample(example);
		if (followUps != null && !followUps.isEmpty()) {
			// 获取客户对应的关联客户
			List<Long> customerIds = new ArrayList<>();
			followUps.forEach(m -> customerIds.add(m.getCustomerId()));
			Map<Long, BaseUserCustomer> userCustomerMap = userCustomerService.getUserByCustomer(customerIds);
			for (BaseCustomerFollowUp followUp : followUps) {
				sendNextMessage(followUp, userCustomerMap.get(followUp.getCustomerId()));
			}
		}
		return Result.newSuccessResult();
	}

	public List<CustomerFollowUpPageResDto> setText(List<BaseCustomerFollowUp> list) throws BaseException {
		if (list == null || list.isEmpty()) {
			return null;
		}
		List<CustomerFollowUpPageResDto> result = new ArrayList<>();
		for (BaseCustomerFollowUp baseCustomerFollowUp : list) {
			CustomerFollowUpPageResDto resDto = new CustomerFollowUpPageResDto();
			BeanUtils.copyProperties(baseCustomerFollowUp, resDto);
			resDto.setTypeText(dictionaryService.toText(DicCode.FOLLOW_TYPE,
					baseCustomerFollowUp.getType() + CommonConstant.BLANK));
			resDto.setStatusText(dictionaryService.toText(DicCode.FOLLOW_STATUS,
					baseCustomerFollowUp.getStatus() + CommonConstant.BLANK));
			if (resDto.getMapType() != null) {
				resDto.setMapTypeText(MapTypeEnum.getEnumName(resDto.getMapType()));
			}
			resDto.setCreateUserName(userDetailService.getUserRealName(baseCustomerFollowUp.getCreateUserId()));
			result.add(resDto);
		}
		return result;
	}

	public void setAttachs(List<CustomerFollowUpPageResDto> list) throws BaseException {
		if (list != null || !list.isEmpty()) {
			List<Long> followUpIds = new ArrayList<>();
			Map<Long, CustomerFollowUpPageResDto> map = new HashMap<>();
			for (CustomerFollowUpPageResDto dto : list) {
				followUpIds.add(dto.getId());
				map.put(dto.getId(), dto);
			}
			if (!followUpIds.isEmpty()) {
				BaseCustomerFollowUpAttachExample example = new BaseCustomerFollowUpAttachExample();
				example.createCriteria().andCustoemrFollowUpIdIn(followUpIds);
				List<BaseCustomerFollowUpAttach> attachs = baseCustomerFollowUpAttachMapper.selectByExample(example);
				if (attachs != null && !attachs.isEmpty()) {
					for (BaseCustomerFollowUpAttach attach : attachs) {
						CustomerFollowUpPageResDto dto = map.get(attach.getCustoemrFollowUpId());
						if (dto == null) {
							continue;
						}
						dto.getAttachs().add(attach);
					}
				}
			}
		}

	}
}
