package com.yundao.tenant.service.smsassistantcontent.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.customer.customer.CustomerDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentAddReqDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentReqDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentResDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantContentUpdateDto;
import com.yundao.tenant.dto.smsassistantcontent.SmsAssistantExeTimeUpdateDto;
import com.yundao.tenant.dto.smsassistantcontentref.SmsAssistantContentRefReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.sms.SmsAssistantContentStatusEnum;
import com.yundao.tenant.mapper.base.BaseSmsAssistantContentMapper;
import com.yundao.tenant.mapper.base.BaseSmsAssistantContentRefMapper;
import com.yundao.tenant.model.base.BaseSmsAssistantContent;
import com.yundao.tenant.model.base.BaseSmsAssistantContentExample;
import com.yundao.tenant.model.base.BaseSmsAssistantContentRef;
import com.yundao.tenant.model.base.BaseSmsAssistantContentRefExample;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.smsassistantcontent.SmsAssistantContentService;
import com.yundao.tenant.service.smsassistantcontentref.SmsAssistantContentRefService;
import com.yundao.tenant.util.CalendarUtils;

@Service
public class SmsAssistantContentServiceImpl extends AbstractService implements SmsAssistantContentService {

	private Log logger = LogFactory.getLog(SmsAssistantContentServiceImpl.class);
	@Autowired
	private BaseSmsAssistantContentMapper baseSmsAssistantContentMapper;
	@Autowired
	private BaseSmsAssistantContentRefMapper baseSmsAssistantContentRefMapper;
	@Autowired
	private SmsAssistantContentRefService smsAssistantContentRefService;
	@Autowired
	private CustomerService customerService;

	public Result<Long> add(SmsAssistantContentAddReqDto reqDto) throws Exception {
		BaseSmsAssistantContent model = new BaseSmsAssistantContent();
		BeanUtils.copyProperties(reqDto, model);
		model.setUserId(this.getHeaderUserId());
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setTenantId(this.getHeaderTenantId());
		model.setId(null);
		if (SmsAssistantContentStatusEnum.SEND_SUCCESS.getValue() == reqDto.getSendStatus()
				|| SmsAssistantContentStatusEnum.SEND_FAIL.getValue() == reqDto.getSendStatus()) {
			model.setSendTime(new Date());
		}
		int count = baseSmsAssistantContentMapper.insertSelective(model);

		if (StringUtils.isNotBlank(reqDto.getCustomerIds())) {
			String[] customerIds = reqDto.getCustomerIds().split(",");
			for (int i = 0; i < customerIds.length; i++) {
				Result<CustomerDto> customerResult = customerService.get(NumberUtils.toLong(customerIds[i]));
				if (customerResult.getResult() == null) {
					logger.info("客户ID：" + customerIds[i] + ",不存在，请核对！");
					continue;
				}
				CustomerDto customerDto = customerResult.getResult();
				SmsAssistantContentRefReqDto refReqDto = new SmsAssistantContentRefReqDto();
				refReqDto.setCustomerId(customerDto.getId());
				refReqDto.setCustomerMobile(customerDto.getMobile());
				refReqDto.setSmsAssistantContentId(model.getId());
				smsAssistantContentRefService.add(refReqDto);
			}
		}

		return Result.newSuccessResult(model.getId());
	}

	@Override
	public Result<Integer> updateExeTime(SmsAssistantExeTimeUpdateDto reqDto) throws Exception {
		BaseSmsAssistantContent model = new BaseSmsAssistantContent();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseSmsAssistantContentMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);

	}

	public Result<Long> update(SmsAssistantContentUpdateDto reqDto) throws Exception {
		BaseSmsAssistantContent baseSmsAssistantContent = baseSmsAssistantContentMapper
				.selectByPrimaryKey(reqDto.getId());

		if (baseSmsAssistantContent == null) {
			throw new BaseException(Code1200000.CODE_1200203);
		}

		if (SmsAssistantContentStatusEnum.SEND_SUCCESS.getValue() == baseSmsAssistantContent.getSendStatus()
				|| SmsAssistantContentStatusEnum.SEND_FAIL.getValue() == baseSmsAssistantContent.getSendStatus()) {
			throw new BaseException(Code1200000.CODE_1200204);
		}

		if (baseSmsAssistantContent.getUserId() != this.getHeaderUserId()) {
			throw new BaseException(CodeConstant.CODE_1200141);
		}
		
		BaseSmsAssistantContent model = new BaseSmsAssistantContent();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		if (SmsAssistantContentStatusEnum.SEND_SUCCESS.getValue() == reqDto.getSendStatus()
				|| SmsAssistantContentStatusEnum.SEND_FAIL.getValue() == reqDto.getSendStatus()) {
			model.setSendTime(new Date());
		}
		int count = baseSmsAssistantContentMapper.updateByPrimaryKeySelective(model);

		// 删除短信所关联的客户信息
		BaseSmsAssistantContentRefExample refExample = new BaseSmsAssistantContentRefExample();
		refExample.createCriteria().andSmsAssistantContentIdEqualTo(reqDto.getId());
		BaseSmsAssistantContentRef refRecord = new BaseSmsAssistantContentRef();
		refRecord.setUpdateDate(new Date());
		refRecord.setUpdateUserId(super.getHeaderUserId());
		refRecord.setIsDelete(DeleteEnum.DELETED.getValue());
		baseSmsAssistantContentRefMapper.updateByExampleSelective(refRecord, refExample);

		if (StringUtils.isNotBlank(reqDto.getCustomerIds())) {
			String[] customerIds = reqDto.getCustomerIds().split(",");
			for (int i = 0; i < customerIds.length; i++) {
				Result<CustomerDto> customerResult = customerService.get(NumberUtils.toLong(customerIds[i]));
				if (customerResult.getResult() == null) {
					logger.info("客户ID：" + customerIds[i] + ",不存在，请核对！");
					continue;
				}
				CustomerDto customerDto = customerResult.getResult();
				SmsAssistantContentRefReqDto refReqDto = new SmsAssistantContentRefReqDto();
				refReqDto.setCustomerId(customerDto.getId());
				refReqDto.setCustomerMobile(customerDto.getMobile());
				refReqDto.setSmsAssistantContentId(model.getId());
				smsAssistantContentRefService.add(refReqDto);
			}
		}

		return Result.newSuccessResult(model.getId());
	}

	@Override
	public Result<Integer> delete(String ids) throws Exception {
		if (StringUtils.isBlank(ids)) {
			throw new BaseException(CodeConstant.CODE_1200000);
		}
		String[] idArr = ids.split(",");
		List<Long> idList = new ArrayList<>();
		for (int i = 0; i < idArr.length; i++) {
			idList.add(NumberUtils.toLong(idArr[i]));
		}
		BaseSmsAssistantContentExample example = new BaseSmsAssistantContentExample();
		example.createCriteria().andIdIn(idList);

		BaseSmsAssistantContent record = new BaseSmsAssistantContent();
		record.setIsDelete(DeleteEnum.DELETED.getValue());
		record.setUpdateDate(new Date());
		record.setUpdateUserId(super.getHeaderUserId());
		int count = baseSmsAssistantContentMapper.updateByExampleSelective(record, example);

		// 删除关联关系表
		BaseSmsAssistantContentRefExample refExample = new BaseSmsAssistantContentRefExample();
		refExample.createCriteria().andSmsAssistantContentIdIn(idList);
		BaseSmsAssistantContentRef ref = new BaseSmsAssistantContentRef();
		ref.setIsDelete(DeleteEnum.DELETED.getValue());
		ref.setUpdateDate(new Date());
		ref.setUpdateUserId(super.getHeaderUserId());
		baseSmsAssistantContentRefMapper.updateByExampleSelective(ref, refExample);

		return Result.newSuccessResult(count);

	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseSmsAssistantContent smsAssistantContent = new BaseSmsAssistantContent();
		smsAssistantContent.setId(id);
		smsAssistantContent.setUpdateDate(new Date());
		smsAssistantContent.setUpdateUserId(super.getHeaderUserId());
		int count = baseSmsAssistantContentMapper.updateByPrimaryKeySelective(smsAssistantContent);
		return Result.newSuccessResult(count);
	}

	public Result<SmsAssistantContentResDto> get(Long id) throws Exception {
		BaseSmsAssistantContent model = baseSmsAssistantContentMapper.selectByPrimaryKey(id);
		SmsAssistantContentResDto dto = new SmsAssistantContentResDto();
		if (model != null) {
			BeanUtils.copyProperties(model, dto);
		}
		// 查询客户信息
		BaseSmsAssistantContentRefExample refExample = new BaseSmsAssistantContentRefExample();
		refExample.createCriteria().andSmsAssistantContentIdEqualTo(dto.getId());
		List<BaseSmsAssistantContentRef> baseSmsAssistantContentRefs = baseSmsAssistantContentRefMapper
				.selectByExample(refExample);
		if (baseSmsAssistantContentRefs != null && !baseSmsAssistantContentRefs.isEmpty()) {
			StringBuilder customerIds = new StringBuilder();
			for (BaseSmsAssistantContentRef ref : baseSmsAssistantContentRefs) {
				if (customerIds.length() > 0) {
					customerIds.append(",");
				}
				customerIds.append(ref.getCustomerId());
			}
			Result<List<BaseCustomer>> customerResult = customerService.getByIds(customerIds.toString());
			if (customerResult.getResult() != null) {
				dto.setCustomers(customerResult.getResult());
			}
		}

		if (dto.getSendStatus() != null) {
			dto.setSendStatusText(
					SmsAssistantContentStatusEnum.getSmsAssistantContentStatusEnum(dto.getSendStatus()).getName());
		}
		return Result.newSuccessResult(dto);
	}

	@Override
	public Result<List<SmsAssistantContentResDto>> getStayAlert() throws Exception {
		Date today = new Date();
		BaseSmsAssistantContentExample example = new BaseSmsAssistantContentExample();
		example.createCriteria().andSendStatusEqualTo(SmsAssistantContentStatusEnum.UN_SEND.getValue())
				.andExecuteTimeGreaterThanOrEqualTo(CalendarUtils.getCurrentDayBeginTime(today))
				.andExecuteTimeLessThanOrEqualTo(CalendarUtils.getCurrentDateEndTime(today));
		List<BaseSmsAssistantContent> baseSmsAssistantContents = baseSmsAssistantContentMapper.selectByExample(example);
		List<SmsAssistantContentResDto> dtos = new ArrayList<>();

		if (baseSmsAssistantContents != null && !baseSmsAssistantContents.isEmpty()) {
			for (BaseSmsAssistantContent content : baseSmsAssistantContents) {
				SmsAssistantContentResDto dto = new SmsAssistantContentResDto();
				BeanUtils.copyProperties(content, dto);
				// 查询客户信息
				BaseSmsAssistantContentRefExample refExample = new BaseSmsAssistantContentRefExample();
				refExample.createCriteria().andSmsAssistantContentIdEqualTo(content.getId());
				List<BaseSmsAssistantContentRef> baseSmsAssistantContentRefs = baseSmsAssistantContentRefMapper
						.selectByExample(refExample);
				if (baseSmsAssistantContentRefs != null && !baseSmsAssistantContentRefs.isEmpty()) {
					StringBuilder customerIds = new StringBuilder();
					for (BaseSmsAssistantContentRef ref : baseSmsAssistantContentRefs) {
						if (customerIds.length() > 0) {
							customerIds.append(",");
						}
						customerIds.append(ref.getCustomerId());
					}
					Result<List<BaseCustomer>> customerResult = customerService.getByIds(customerIds.toString());
					if (customerResult.getResult() != null) {
						dto.setCustomers(customerResult.getResult());
					}
				}

				if (dto.getSendStatus() != null) {
					dto.setSendStatusText(SmsAssistantContentStatusEnum
							.getSmsAssistantContentStatusEnum(dto.getSendStatus()).getName());
				}
				dtos.add(dto);
			}

		}
		return Result.newSuccessResult(dtos);

	}

	public Result<PaginationSupport<SmsAssistantContentResDto>> getPage(
			SmsAssistantContentReqDto smsAssistantContentReqDto, AbstractBasePageDto pageDto) throws Exception {
		BaseSmsAssistantContentExample baseSmsAssistantContentExample = new BaseSmsAssistantContentExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseSmsAssistantContentExample.Criteria criteria = baseSmsAssistantContentExample.createCriteria();
		criteria.andUserIdEqualTo(this.getHeaderUserId());
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
		baseSmsAssistantContentExample.setOrderByClause(orderByClause);

		PaginationSupport<SmsAssistantContentResDto> result = pageDto.getPaginationSupport();
		int totalCount = baseSmsAssistantContentMapper.countByExample(baseSmsAssistantContentExample);
		if (totalCount > 0) {
			List<SmsAssistantContentResDto> dtos = new ArrayList<>();

			List<BaseSmsAssistantContent> list = baseSmsAssistantContentMapper
					.selectByExample(baseSmsAssistantContentExample);
			for (BaseSmsAssistantContent content : list) {
				SmsAssistantContentResDto dto = new SmsAssistantContentResDto();
				BeanUtils.copyProperties(content, dto);

				// 查询客户信息
				BaseSmsAssistantContentRefExample example = new BaseSmsAssistantContentRefExample();
				example.createCriteria().andSmsAssistantContentIdEqualTo(content.getId());
				List<BaseSmsAssistantContentRef> baseSmsAssistantContentRefs = baseSmsAssistantContentRefMapper
						.selectByExample(example);
				if (baseSmsAssistantContentRefs != null && !baseSmsAssistantContentRefs.isEmpty()) {
					StringBuilder customerIds = new StringBuilder();
					for (BaseSmsAssistantContentRef ref : baseSmsAssistantContentRefs) {
						if (customerIds.length() > 0) {
							customerIds.append(",");
						}
						customerIds.append(ref.getCustomerId());
					}
					Result<List<BaseCustomer>> customerResult = customerService.getByIds(customerIds.toString());
					if (customerResult.getResult() != null) {
						dto.setCustomers(customerResult.getResult());
					}
				}

				if (dto.getSendStatus() != null) {
					dto.setSendStatusText(SmsAssistantContentStatusEnum
							.getSmsAssistantContentStatusEnum(dto.getSendStatus()).getName());
				}
				dtos.add(dto);
			}

			result.setDatas(dtos);

		}

		result.setTotalCount(totalCount);

		return Result.newSuccessResult(result);
	}

}
