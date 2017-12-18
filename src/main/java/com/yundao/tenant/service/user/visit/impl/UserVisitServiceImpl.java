package com.yundao.tenant.service.user.visit.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDetailVisitPageResDto;
import com.yundao.tenant.dto.operation.visit.UserVisitAddReqDto;
import com.yundao.tenant.dto.user.visit.UserVisitDetailForLeads;
import com.yundao.tenant.dto.user.visit.UserVisitDto;
import com.yundao.tenant.dto.user.visit.UserVisitPageReqDto;
import com.yundao.tenant.dto.user.visit.UserVisitPageResDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.common.SexEnum;
import com.yundao.tenant.enums.customer.CustomerStatusEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserVisitMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsVisitRelMapper;
import com.yundao.tenant.mapper.user.visit.UserVisitMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseUserVisit;
import com.yundao.tenant.model.base.sale.BaseLeads;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.operation.visit.CustomerVisitService;
import com.yundao.tenant.service.region.RegionService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.user.visit.UserVisitService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.LocalBeanUtils;

/**
 * 客户回访服务实现
 *
 * @author jan
 * @create 2017-08-11 AM10:34
 **/
@Service
public class UserVisitServiceImpl extends AbstractService implements UserVisitService {

	private static Log log = LogFactory.getLog(UserVisitServiceImpl.class);

	@Autowired
	private UserVisitMapper userVisitMapper;

	@Autowired
	private BaseUserVisitMapper baseUserVisitMapper;

	@Autowired
	private BaseLeadsMapper baseLeadsMapper;

	@Autowired
	private BaseCustomerMapper baseCustomerMapper;

	@Autowired
	private BaseLeadsVisitRelMapper baseLeadsVisitRelMapper;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private UserService userService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private CustomerVisitService customerVisitService;
	@Autowired
	private UserDetailService userDetailService;

	@Override
	public Result<Long> doVisit(UserVisitAddReqDto dto) throws BaseException {
		String logPrefix = "客户回访||添加||";
		log.info("%s 参数 dto %s", logPrefix, JsonUtils.objectToJson(dto));

		BaseUserVisit model = baseUserVisitMapper.selectByPrimaryKey(dto.getId());
		log.info("%s 回访数据 %s", logPrefix, JsonUtils.objectToJson(model));
		if (model == null)
			throw new BaseException(CodeConstant.CODE_1220070);

		if (!super.getHeaderUserId().equals(model.getUserId()))
			throw new BaseException(CodeConstant.CODE_1220074);

		if (model.getStatus() != null)
			throw new BaseException(CodeConstant.CODE_1220115);

		if (dto.getCustomerStatus() != null) {
			// 修改客户状态
			BaseCustomer customerRecord = new BaseCustomer();
			customerRecord.setId(model.getCustomerId());
			customerRecord.setStatus(dto.getCustomerStatus());
			customerRecord.setUpdateDate(new Date());
			customerRecord.setUpdateUserId(this.getHeaderUserId());
			baseCustomerMapper.updateByPrimaryKeySelective(customerRecord);
		}

		super.updateModel(model);
		model.setVisitDate(new Date());
		model.setType(dto.getType());
		model.setStatus(dto.getStatus());
		model.setContent(dto.getContent());
		model.setNextTime(dto.getNextTime());
		log.info("%s 赋值后数据 %s", logPrefix, JsonUtils.objectToJson(model));
		baseUserVisitMapper.updateByPrimaryKeySelective(model);

		// 回访发送消息
		customerVisitService.visitCustomerSendMessage(model.getId());
		return Result.newSuccessResult(model.getId());
	}

	@Override
	public Result<PaginationSupport<CustomerDetailVisitPageResDto>> getCustomerDetailVisitPage(
			CustomerDetailVisitPageReqDto dto, Integer permission) throws BaseException {
		log.begin(dto.getCustomerId());
		customerService.checkNotNullAndTerminal(dto.getCustomerId());

		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
		PaginationSupport<CustomerDetailVisitPageResDto> page = PaginationSupport.newDefault(paramMap);

		// 无权限，直接返回
		if (permission == null || DataObjectPermissionEnum.NONE.getValue().equals(permission))
			return Result.newSuccessResult(page);

		// 根据访问权限，设置参数
		userService.setPermissionCondition(paramMap, permission);

		List<CustomerDetailVisitPageResDto> dtos = userVisitMapper.selectCustomerDetailVisitPage(paramMap);
		if (BooleanUtils.isEmpty(dtos))
			return Result.newSuccessResult(page);

		Integer count = userVisitMapper.selectCustomerDetailVisitPageCount(paramMap);
		page.setTotalCount(count);
		this.setText(dtos);
		page.setDatas(dtos);
		return Result.newSuccessResult(page);
	}

	@Override
	public Result<PaginationSupport<UserVisitPageResDto>> getPage(UserVisitPageReqDto dto, Integer permission)
			throws BaseException {
		String logPrefix = "客户回访||分页数据||";
		log.info("%s开始", logPrefix);
		log.info("%s参数 dto %s permission %s", logPrefix, JsonUtils.objectToJson(dto), permission);
		// 手机号解密
		if (BooleanUtils.isNotEmpty(dto.getMobile())) {
			dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));
		}

		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
		PaginationSupport<UserVisitPageResDto> page = PaginationSupport.newDefault(paramMap);

		// 无权限，直接返回
		if (permission == null || DataObjectPermissionEnum.NONE.getValue().equals(permission))
			return Result.newSuccessResult(page);

		// 根据访问权限，设置参数
		userService.setPermissionCondition(paramMap, permission);

		List<UserVisitPageResDto> dtos = userVisitMapper.selectPage(paramMap);
		if (BooleanUtils.isEmpty(dtos))
			return Result.newSuccessResult(page);

		Integer count = userVisitMapper.selectPageCount(paramMap);
		page.setTotalCount(count);
		this.setPageText(dtos);
		page.setDatas(dtos);
		log.info("%s完成", logPrefix);
		return Result.newSuccessResult(page);
	}

	@Override
	public Result<UserVisitDto> get(Long id) throws BaseException {
		BaseUserVisit baseUserVisit = baseUserVisitMapper.selectByPrimaryKey(id);
		if (baseUserVisit == null) {
			throw new BaseException(CodeConstant.CODE_1220070);
		}
		UserVisitDto dto = new UserVisitDto();
		BeanUtils.copyProperties(baseUserVisit, dto);
		dto.setStatusText(dictionaryService.toText(DicCode.DIC_USER_VISIT_STATUS, dto.getStatus()));
		dto.setTypeText(dictionaryService.toText(DicCode.DIC_USER_VISIT_TYPE, dto.getType()));
		if (dto.getCustomerId() != null) {
			BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(dto.getCustomerId());
			if (customer != null) {
				dto.setStatus(customer.getStatus());
				dto.setCustomerStatusText(dictionaryService.toText(DicCode.CUSTOMER_STATUS, customer.getStatus()));
			}
		}
		if (dto.getUserId() != null) {
			dto.setUserName(userDetailService.getUserRealName(dto.getUserId()));
		}
		return Result.newSuccessResult(dto);

	}

	@Override
	public Result<UserVisitDetailForLeads> getForLeads(Long leadsId) throws BaseException {
		String logPrefix = "客户回访||销售线索列表回访详情||";
		log.info("%s leadsId %s", logPrefix, leadsId);
		BaseLeads leads = baseLeadsMapper.selectByPrimaryKey(leadsId);
		if (leads == null)
			throw new BaseException(CodeConstant.CODE_1220090);

		UserVisitDetailForLeads dto = userVisitMapper.selectForLeads(leadsId);
		log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
		if (dto == null)
			throw new BaseException(CodeConstant.CODE_1220091);

		dto.setStatusText(dictionaryService.toText(DicCode.DIC_USER_VISIT_STATUS, dto.getStatus()));
		dto.setTypeText(dictionaryService.toText(DicCode.DIC_USER_VISIT_TYPE, dto.getType()));
		dto.setCustomerStatusText(dictionaryService.toText(DicCode.CUSTOMER_STATUS, dto.getCustomerStatus()));
		dto.setIsProcess(dto.getStatus() != null);
		return Result.newSuccessResult(dto);
	}

	private void setPageText(List<UserVisitPageResDto> dtos) throws BaseException {
		for (UserVisitPageResDto dto : dtos) {
			dto.setStatusText(dictionaryService.toText(DicCode.DIC_USER_VISIT_STATUS, dto.getStatus()));
			dto.setTypeText(dictionaryService.toText(DicCode.DIC_USER_VISIT_TYPE, dto.getType()));
			if (BooleanUtils.isNotEmpty(dto.getMobile()))
				dto.setMobile(BaseContactUtils.decrypt(dto.getMobile()));
			if (dto.getSex() != null)
				dto.setSexText(SexEnum.getEnumName(dto.getSex()));
			if (dto.getProvinceCode() != null)
				dto.setProvinceText(regionService.toText(dto.getProvinceCode()));
			if (dto.getCityCode() != null)
				dto.setCityText(regionService.toText(dto.getCityCode()));
			boolean canVisit = false;
			if (dto.getStatus() != null) {
				dto.setIsVisitText("已回访");
			} else {
				if (dto.getUserId().equals(super.getHeaderUserId())) {
					canVisit = true;
					dto.setIsVisitText("未回访");
				} else {
					// 非本人不能回访
					dto.setIsVisitText("待回访");
				}
			}
			dto.setCanVisit(canVisit);

			dto.setCustomerStatusText(CustomerStatusEnum.getEnumName(dto.getCustomerStatus()));
		}
	}

	/**
	 * 翻译文本
	 */
	private void setText(List<CustomerDetailVisitPageResDto> dtos) throws BaseException {
		for (CustomerDetailVisitPageResDto dto : dtos) {
			if (dto.getStatus() != null)
				dto.setStatusText(dictionaryService.toText(DicCode.DIC_USER_VISIT_STATUS, dto.getStatus().toString()));
			if (dto.getType() != null)
				dto.setTypeText(dictionaryService.toText(DicCode.DIC_USER_VISIT_TYPE, dto.getType().toString()));
		}
	}
}
