package com.yundao.tenant.service.msg.msgmessage.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.exception.BaseRuntimeException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.Limit;
import com.yundao.core.utils.TemplateUtils;
import com.yundao.core.utils.UUIDUtils;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.MsgConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessageCountResDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessagePageResDto;
import com.yundao.tenant.dto.msg.msgmessage.MsgMessageReqDto;
import com.yundao.tenant.dto.msg.msgmessage.TemplateParamsRuleDto;
import com.yundao.tenant.enums.msg.MsgMessageFirstTypeEnum;
import com.yundao.tenant.enums.msg.MsgMessageReadEnum;
import com.yundao.tenant.enums.msg.MsgMessageTypeEnum;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.mapper.base.msg.BaseMsgFeedMapper;
import com.yundao.tenant.mapper.base.msg.BaseMsgMessageMapper;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateMapper;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateTypeMapper;
import com.yundao.tenant.mapper.base.msg.BaseMsgTemplateTypeRefMapper;
import com.yundao.tenant.mapper.msg.msgmessage.MsgMessageMapper;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import com.yundao.tenant.model.base.msg.BaseMsgFeed;
import com.yundao.tenant.model.base.msg.BaseMsgMessage;
import com.yundao.tenant.model.base.msg.BaseMsgMessageExample;
import com.yundao.tenant.model.base.msg.BaseMsgMessageExample.Criteria;
import com.yundao.tenant.model.base.msg.BaseMsgTemplate;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateExample;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateType;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeExample;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRef;
import com.yundao.tenant.model.base.msg.BaseMsgTemplateTypeRefExample;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.util.lambda.LambdaMap;
import com.yundao.tenant.util.msg.MsgUtil;

@Service
public class MsgMessageServiceImpl extends AbstractService implements MsgMessageService {

	@Autowired
	private BaseMsgMessageMapper baseMsgMessageMapper;

	@Autowired
	private MsgMessageMapper msgMessageMapper;

	@Autowired
	private BaseMsgTemplateMapper baseMsgTemplateMapper;

	@Autowired
	private BaseMsgTemplateTypeRefMapper baseMsgTemplateTypeRefMapper;

	@Autowired
	private BaseMsgTemplateTypeMapper baseMsgTemplateTypeMapper;

	@Autowired
	private BaseMsgFeedMapper feedMapper;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private BaseUserCustomerMapper baseUserCustomerMapper;

	private static Log log = LogFactory.getLog(MsgMessageServiceImpl.class);

	static String PRODUCT_TYPE = "PRODUCT_TYPE";
	static String HTTP_HTTPS_URL = "HTTP_HTTPS_URL";

	public Result<Integer> add(MsgMessageReqDto reqDto) throws Exception {
		BaseMsgMessage model = new BaseMsgMessage();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setId(null);
		int count = baseMsgMessageMapper.insertSelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> update(MsgMessageReqDto reqDto) throws Exception {
		BaseMsgMessage model = new BaseMsgMessage();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseMsgMessageMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseMsgMessage msgMessage = new BaseMsgMessage();
		msgMessage.setId(id);
		msgMessage.setUpdateDate(new Date());
		msgMessage.setUpdateUserId(super.getHeaderUserId());
		int count = baseMsgMessageMapper.updateByPrimaryKeySelective(msgMessage);
		return Result.newSuccessResult(count);
	}

	public Result<BaseMsgMessage> get(Long id) throws Exception {
		BaseMsgMessage model = baseMsgMessageMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model);
	}

	public Result<PaginationSupport<MsgMessagePageResDto>> getPage(MsgMessageReqDto msgMessageReqDto,
			AbstractBasePageDto pageDto) throws Exception {
		if (msgMessageReqDto.getFirstType() == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210054);
		}
		BaseMsgMessageExample baseMsgMessageExample = new BaseMsgMessageExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseMsgMessageExample.Criteria criteria = baseMsgMessageExample.createCriteria();
		criteria.andFirstTypeEqualTo(msgMessageReqDto.getFirstType());
		criteria.andFeedUserIdEqualTo(super.getHeaderUserId());
		if(msgMessageReqDto.getBeginDate() !=null && msgMessageReqDto.getEndDate() !=null){
			criteria.andCreateDateBetween(msgMessageReqDto.getBeginDate(), msgMessageReqDto.getEndDate());
		}
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
		baseMsgMessageExample.setOrderByClause(orderByClause);
		List<BaseMsgMessage> list = baseMsgMessageMapper.selectByExample(baseMsgMessageExample);
		int totalCount = baseMsgMessageMapper.countByExample(baseMsgMessageExample);
		PaginationSupport<MsgMessagePageResDto> result = pageDto.getPaginationSupport();
		List<MsgMessagePageResDto> datas = setDictData(list);
		result.setDatas(datas);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	@Override
	public Result<Long> processSendMessage(String code, Object obj) throws BaseException {
		if (BooleanUtils.isEmpty(code)) {
			throw new BaseException(GJLCodeConstant.CODE_1210050);
		}
		if (MsgUtil.isPrimitiveClass(obj)) {
			throw new BaseException(GJLCodeConstant.CODE_1210053);
		}
		BaseMsgTemplateExample templateExample = new BaseMsgTemplateExample();
		templateExample.createCriteria().andCodeEqualTo(code);
		List<BaseMsgTemplate> templates = baseMsgTemplateMapper.selectByExample(templateExample);
		if (templates == null || templates.isEmpty()) {
			throw new BaseException(GJLCodeConstant.CODE_1210050);
		}
		BaseMsgTemplate template = templates.get(0);
		// 验证参数
		String jsont = JsonUtils.objectToJson(obj);
		Map<String, Object> reqParams = JsonUtils.jsonToObject(jsont, Map.class);
		validateMessageData(template.getParams(), reqParams);
		// 发送消息
		Long msgId = sendMessageByType(template, reqParams);
		return Result.newSuccessResult(msgId);
	}

	@Override
	public Result<MsgMessageCountResDto> getUnreadCount() throws Exception {
		BaseMsgMessageExample example = new BaseMsgMessageExample();
		example.createCriteria().andFeedUserIdEqualTo(super.getHeaderUserId())
				.andReadStatusEqualTo(MsgMessageReadEnum.MESSAGE_READ_1.getType())
				.andFirstTypeEqualTo(MsgMessageFirstTypeEnum.MESSAGE_TYPE_1.getType());
		List<BaseMsgMessage> taskMessage = baseMsgMessageMapper.selectByExample(example);
		Integer taskCount = taskMessage == null || taskMessage.isEmpty() ? 0 : taskMessage.size();
		BaseMsgMessageExample messageExample = new BaseMsgMessageExample();
		messageExample.createCriteria().andFeedUserIdEqualTo(super.getHeaderUserId())
				.andReadStatusEqualTo(MsgMessageReadEnum.MESSAGE_READ_1.getType())
				.andFirstTypeEqualTo(MsgMessageTypeEnum.MESSAGE_TYPE_2.getType());
		List<BaseMsgMessage> messages = baseMsgMessageMapper.selectByExample(messageExample);
		Integer messageCount = messages == null || messages.isEmpty() ? 0 : messages.size();
		MsgMessageCountResDto resDto = new MsgMessageCountResDto();
		resDto.setTaskCount(taskCount);
		resDto.setMessageCount(messageCount);
		return Result.newSuccessResult(resDto);
	}

	@Override
	public Result<Integer> getUnreadCountByType(Integer type, Date fromDate) throws Exception {
		BaseMsgMessageExample example = new BaseMsgMessageExample();
		com.yundao.tenant.model.base.msg.BaseMsgMessageExample.Criteria criteria=example.createCriteria();
		
		criteria.andFeedUserIdEqualTo(super.getHeaderUserId())
				.andReadStatusEqualTo(MsgMessageReadEnum.MESSAGE_READ_1.getType());
		if(type !=null){
			criteria.andFirstTypeEqualTo(type);
		}
		if(fromDate !=null){
			criteria.andCreateDateGreaterThanOrEqualTo(fromDate);
		}
		List<BaseMsgMessage> taskMessage = baseMsgMessageMapper.selectByExample(example);
		Integer taskCount = taskMessage == null || taskMessage.isEmpty() ? 0 : taskMessage.size();
		return Result.newSuccessResult(taskCount);
	}

	@Override
	public Result<Integer> getUnreadCountByTypeAndTime(Integer type, Date beginDate, Date endDate) throws Exception {
		
		BaseMsgMessageExample example = new BaseMsgMessageExample();
		com.yundao.tenant.model.base.msg.BaseMsgMessageExample.Criteria criteria=example.createCriteria();
		
		criteria.andFeedUserIdEqualTo(super.getHeaderUserId())
				.andReadStatusEqualTo(MsgMessageReadEnum.MESSAGE_READ_1.getType());
		if(type !=null){
			criteria.andFirstTypeEqualTo(type);
		}
		if(beginDate !=null && endDate !=null){
			criteria.andCreateDateBetween(beginDate, endDate);
		}
		List<BaseMsgMessage> taskMessage = baseMsgMessageMapper.selectByExample(example);
		Integer taskCount = taskMessage == null || taskMessage.isEmpty() ? 0 : taskMessage.size();
		return Result.newSuccessResult(taskCount);
		
	}

	@Override
	public Result<Integer> processRead(String ids) throws BaseException{
		String[] arrIds = ids.split(CommonConstant.COMMA);
		List<Long> idList = new ArrayList<>();
		for (String arrId : arrIds) {
			idList.add(Long.valueOf(arrId));
		}
		BaseMsgMessageExample example = new BaseMsgMessageExample();
		example.createCriteria().andIdIn(idList);
		BaseMsgMessage message = new BaseMsgMessage();
		message.setReadStatus(MsgMessageReadEnum.MESSAGE_TYPE_2.getType());
		int count = baseMsgMessageMapper.updateByExampleSelective(message, example);
		return Result.newSuccessResult(count);
	}

	@Override
	public Result<Integer> processReadAll(Integer type) throws BaseException {
		
		BaseMsgMessageExample example = new BaseMsgMessageExample();
		Criteria criteria=example.createCriteria();
		criteria.andFeedUserIdEqualTo(this.getHeaderUserId());
		if(type !=null){
			criteria.andFirstTypeEqualTo(type);
		}
		BaseMsgMessage message = new BaseMsgMessage();
		message.setReadStatus(MsgMessageReadEnum.MESSAGE_TYPE_2.getType());
		int count = baseMsgMessageMapper.updateByExampleSelective(message, example);
		return Result.newSuccessResult(count);
		
	}

	@Override
	public Result<Long> processSendCustomerMessage(String code, Long customerId, Map<String, Object> params) throws BaseException {
		if(customerId == null){
			throw new BaseException(GJLCodeConstant.CODE_1210019);
		}
		//获取客户对应的理财经理
		BaseUserCustomerExample userCustomerExample = new BaseUserCustomerExample();
		userCustomerExample.createCriteria().andCustomerIdEqualTo(customerId);
		BaseUserCustomer userCustomer = baseUserCustomerMapper.selectOne(userCustomerExample);
		if(userCustomer != null){
			params.put(MsgConstant.USER_ID,userCustomer.getUserId());
		}
		return processSendMessage(code,params);
	}

	/**
	 * 发送消息
	 * 
	 * @param template
	 * @param reqParams
	 * @return
	 */
	private Long sendMessageByType(BaseMsgTemplate template, Map<String, Object> reqParams) throws BaseException {
		// 获取消息类型
		BaseMsgTemplateTypeRefExample templateTypeRefExample = new BaseMsgTemplateTypeRefExample();
		templateTypeRefExample.createCriteria().andTemplateIdEqualTo(template.getId());
		List<BaseMsgTemplateTypeRef> typeRefs = baseMsgTemplateTypeRefMapper.selectByExample(templateTypeRefExample);
		BaseMsgTemplateTypeExample typeExample = new BaseMsgTemplateTypeExample();
		typeExample.createCriteria().andIdIn(LambdaMap.toSingleList(typeRefs, BaseMsgTemplateTypeRef::getTypeId));
		List<BaseMsgTemplateType> types = baseMsgTemplateTypeMapper.selectByExample(typeExample);
		if (types == null || types.isEmpty()) {
			throw new BaseException(GJLCodeConstant.CODE_1210052);
		}
		for (BaseMsgTemplateType templateType : types) {
			if (MsgMessageTypeEnum.MESSAGE_TYPE_1.getType().equals(templateType.getType())) {
				// 发送消息到动态
				sendToFeed(template, reqParams, templateType);
			} else {
				// 发送消息到消息表
				sendToMessage(template, reqParams, templateType);
			}
		}
		return null;
	}

	private void sendToMessage(BaseMsgTemplate template, Map<String, Object> reqParams,
			BaseMsgTemplateType templateType) {
		String userIds = reqParams.get(MsgConstant.USER_IDS) == null ? null
				: reqParams.get(MsgConstant.USER_IDS) + CommonConstant.BLANK;
		// 多个用户新增
		if (BooleanUtils.isNotEmpty(userIds)) {
			String[] addUserIds = userIds.split(CommonConstant.COMMA);
			for (String userIdTmp : addUserIds) {
				Long userId = Long.valueOf(userIdTmp);
				addToMessage(template, reqParams, templateType, userId);
			}
		} else {
			addToMessage(template, reqParams, templateType, null);
		}
	}

	private void addToMessage(BaseMsgTemplate template, Map<String, Object> reqParams, BaseMsgTemplateType templateType,
			Long userId) {
		BaseMsgMessage message = new BaseMsgMessage();
		message.setCustomerId(reqParams.get(MsgConstant.CUSTOMER_ID) == null ? null
				: Long.valueOf(reqParams.get(MsgConstant.CUSTOMER_ID) + CommonConstant.BLANK));
		message.setFeedUserId(
				userId == null ? reqParams.get(MsgConstant.USER_ID) == null ? null : Long.valueOf(reqParams.get(MsgConstant.USER_ID) + CommonConstant.BLANK) : userId);
		message.setFirstType(templateType.getFirstType());
		message.setTwoType(templateType.getTwoType());
		try {
			Date optTime = reqParams.get(MsgConstant.OPT_TIME) != null
					? DateUtils.parse(String.valueOf(reqParams.get(MsgConstant.OPT_TIME)), DateUtils.YY_MM_DD_HH_MM_SS)
					: null;
			message.setOptTime(optTime);
		} catch (Exception e) {
			log.error("日期转换异常:" + reqParams.get(MsgConstant.OPT_TIME));
		}
		message.setParams(JsonUtils.objectToJson(reqParams));
		message.setReadStatus(MsgMessageReadEnum.MESSAGE_READ_1.getType());
		message.setTemplateCode(template.getCode());
		message.setTemplateId(template.getId());
		message.setSeqNo(UUIDUtils.getUUID());
		message.setTitle(template.getTitle());
		message.setCreateDate(new Date());
		message.setCreateUserId(super.getHeaderUserId());
		message.setTenantId(super.getHeaderTenantId());
		baseMsgMessageMapper.insertSelective(message);
	}

	private void sendToFeed(BaseMsgTemplate template, Map<String, Object> reqParams, BaseMsgTemplateType templateType)
			throws BaseException {
		String customerIds = reqParams.get(MsgConstant.CUSTOMER_IDS) == null ? null
				: reqParams.get(MsgConstant.CUSTOMER_IDS) + CommonConstant.BLANK;
		String customerId = reqParams.get(MsgConstant.CUSTOMER_ID) == null ? null
				: reqParams.get(MsgConstant.CUSTOMER_ID) + CommonConstant.BLANK;
		if (BooleanUtils.isEmpty(customerId) && BooleanUtils.isEmpty(customerIds)) {
			throw new BaseException(GJLCodeConstant.CODE_1210019);
		}
		if (BooleanUtils.isNotEmpty(customerIds)) {
			String[] addUserIds = customerIds.split(CommonConstant.COMMA);
			for (String userIdTmp : addUserIds) {
				Long id = Long.valueOf(userIdTmp);
				addToFeed(template, reqParams, templateType, id);
			}
		} else {
			addToFeed(template, reqParams, templateType, Long.valueOf(customerId));
		}
	}

	private void addToFeed(BaseMsgTemplate template, Map<String, Object> reqParams, BaseMsgTemplateType templateType,
			Long customerId) {
		BaseMsgFeed msgFeed = new BaseMsgFeed();
		msgFeed.setCustomerId(customerId);
		msgFeed.setParams(JsonUtils.objectToJson(reqParams));
		msgFeed.setTemplateCode(template.getCode());
		msgFeed.setTemplateId(template.getId());
		msgFeed.setUserId(super.getHeaderUserId());
		msgFeed.setCreateDate(new Date());
		msgFeed.setCreateUserId(super.getHeaderUserId());
		msgFeed.setFirstType(templateType.getFirstType());
		msgFeed.setType(templateType.getTwoType());
		try {
			Date optTime = reqParams.get(MsgConstant.OPT_TIME) != null
					? DateUtils.parse(String.valueOf(reqParams.get(MsgConstant.OPT_TIME)), DateUtils.YY_MM_DD_HH_MM_SS)
					: null;
			msgFeed.setOptTime(optTime);
		} catch (Exception e) {
			log.error("日期转换异常:" + reqParams.get(MsgConstant.OPT_TIME));
		}
		msgFeed.setSeqNo(UUIDUtils.getUUID());
		msgFeed.setTenantId(super.getHeaderTenantId());
		feedMapper.insertSelective(msgFeed);
	}

	private void validateMessageData(String params, Map<String, Object> reqParams) {
		if (BooleanUtils.isEmpty(params)) {
			return;
		}
		Map<String, TemplateParamsRuleDto> parameters = null;
		parameters = JsonUtils.jsonToObject(params, new TypeReference<Map<String, TemplateParamsRuleDto>>() {
		});
		for (Iterator<String> iterator = parameters.keySet().iterator(); iterator.hasNext();) {
			String paramName = iterator.next();
			String paramValue = null;
			TemplateParamsRuleDto paramRule = parameters.get(paramName);
			if (null != paramRule) {
				Boolean isBlank = paramRule.getIsBlank(); // 获取是否允许为空
				String message = paramRule.getMessage(); // 获取错误的提示
				Integer code = paramRule.getCode(); // 错误码
				String business = paramRule.getBusiness();
				Integer min = paramRule.getMin();
				Integer max = paramRule.getMax();

				boolean reqParamsEmpty = BooleanUtils.isEmpty(reqParams);
				if (!reqParamsEmpty) {
					paramValue = reqParams.get(paramName) == null ? null : String.valueOf(reqParams.get(paramName));
				}

				// 不允许为空的
				if (null != isBlank && !isBlank) {
					if (reqParamsEmpty) {
						paramEmptyDealWith(message, paramName);
					}
					if (BooleanUtils.isBlank(paramValue)) {
						paramEmptyDealWith(message, paramName);
					}
					paramLengthDealWith(min, max, message, code, paramValue);
				} else {
					// 允许为空的
					if (BooleanUtils.isNotBlank(paramValue)) {
						paramLengthDealWith(min, max, message, code, paramValue);
					}
				}
			}
		}
	}

	/**
	 * 必填参数的空处理
	 *
	 * @param message
	 * @param paramName
	 */
	private static void paramEmptyDealWith(String message, String paramName) {
		if (BooleanUtils.isBlank(message)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", paramName);
			throw new BaseRuntimeException(GJLCodeConstant.CODE_1210051, map);
		}
		throw new BaseRuntimeException(0, message);
	}

	/**
	 * 参数的长度处理
	 * 
	 * @param min
	 * @param max
	 * @param message
	 * @param code
	 * @param paramValue
	 */
	private static void paramLengthDealWith(Integer min, Integer max, String message, Integer code, String paramValue) {
		if (BooleanUtils.isNotBlank(paramValue)) {
			if (null == code) {
				code = 0;
			}
			int length = paramValue.length();
			boolean error = false;
			if (BooleanUtils.isNotBlank(message)) {
				message = message.replace("{min}", min + "").replace("{max}", max + "");
				if (null != min && length < min) {
					error = true;
				}

				if (null != max && length > max) {
					error = true;
				}

				if (error) {
					throw new BaseRuntimeException(code, message);
				}
			}
		}
	}

	public List<MsgMessagePageResDto> setDictData(List<BaseMsgMessage> dictData) throws BaseException {
		if (dictData == null || dictData.isEmpty()) {
			return null;
		}
		// 获取所有的模板
		List<Long> templateIds = new ArrayList<>();
		dictData.forEach(m -> templateIds.add(m.getTemplateId()));
		BaseMsgTemplateExample templateExample = new BaseMsgTemplateExample();
		templateExample.createCriteria().andIdIn(templateIds);
		List<BaseMsgTemplate> msgTemplates = baseMsgTemplateMapper.selectByExample(templateExample);
		Map<Long, BaseMsgTemplate> templateMap = new HashMap<>();
		msgTemplates.forEach(m -> templateMap.put(m.getId(), m));

		List<MsgMessagePageResDto> result = new ArrayList<>();
		for (BaseMsgMessage dictDatum : dictData) {
			MsgMessagePageResDto resDto = new MsgMessagePageResDto();
			BeanUtils.copyProperties(dictDatum, resDto);
			BaseMsgTemplate template = templateMap.get(dictDatum.getTemplateId());
			Map<String, Object> params = JsonUtils.jsonToObject(dictDatum.getParams(), Map.class);
			if (BooleanUtils.isNotEmpty(template.getFeedContent())) {
				resDto.setFeedContent(TemplateUtils.parse(template.getFeedContent(), params));
			}
			if (BooleanUtils.isNotEmpty(template.getMessageContent())) {
				resDto.setMessageContent(TemplateUtils.parse(template.getMessageContent(), params));
			}
			if (BooleanUtils.isNotEmpty(template.getAppContent())) {
				resDto.setAppContent(TemplateUtils.parse(template.getAppContent(), params));
			}
			if (BooleanUtils.isNotEmpty(template.getIndexContent())) {
				resDto.setIndexContent(TemplateUtils.parse(template.getIndexContent(), params));
			}
			if (BooleanUtils.isNotEmpty(template.getAppAction())) {
				resDto.setAppAction(TemplateUtils.parse(template.getAppAction(), params));
			}
			if (BooleanUtils.isNotEmpty(template.getPcAction())) {
				resDto.setPcAction(TemplateUtils.parse(template.getPcAction(), params));
			}
			resDto.setFirstTypeText(dictionaryService.toText(DicCode.MSG_MESSAGE_FIRST_TYPE,
					dictDatum.getFirstType() + CommonConstant.BLANK));
			resDto.setTwoTypeText(dictionaryService.toText(DicCode.MSG_MESSAGE_TWO_TYPE,
					dictDatum.getTwoType() + CommonConstant.BLANK));
			resDto.setRemark(template.getRemark());
			result.add(resDto);
		}
		return result;
	}
}
