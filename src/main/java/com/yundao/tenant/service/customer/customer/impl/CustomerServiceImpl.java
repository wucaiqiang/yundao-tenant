package com.yundao.tenant.service.customer.customer.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DesUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.Code1230000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.common.DataAndPermissionDto;
import com.yundao.tenant.dto.common.FailListDto;
import com.yundao.tenant.dto.common.FileBaseDto;
import com.yundao.tenant.dto.common.PassListDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.attach.CustomerAttachDto;
import com.yundao.tenant.dto.customer.bank.CustomerBankListDto;
import com.yundao.tenant.dto.customer.credentials.CustomerCredentialsDto;
import com.yundao.tenant.dto.customer.customer.CustomerContactDto;
import com.yundao.tenant.dto.customer.customer.CustomerContactReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDetailLeadsChanceResCount;
import com.yundao.tenant.dto.customer.customer.CustomerDetailResDto;
import com.yundao.tenant.dto.customer.customer.CustomerDistributionResDto;
import com.yundao.tenant.dto.customer.customer.CustomerDto;
import com.yundao.tenant.dto.customer.customer.CustomerExclusiveContactReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerInfoDto;
import com.yundao.tenant.dto.customer.customer.CustomerReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerScaningAddReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSelectionReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSelectionResDto;
import com.yundao.tenant.dto.customer.customer.CustomerUpdateStatusReqDto;
import com.yundao.tenant.dto.customer.customer.MyCustomerPageReqDto;
import com.yundao.tenant.dto.customer.customer.MyCustomerPageResDto;
import com.yundao.tenant.dto.customer.customer.NameIdDto;
import com.yundao.tenant.dto.customer.customerAssets.UpdateAssejtsDto;
import com.yundao.tenant.dto.customer.customerAssets.UpdateCredentialsDto;
import com.yundao.tenant.dto.customer.customerbank.CustomerBankReqDto;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeDto;
import com.yundao.tenant.dto.customer.customerinvesttype.CustomerInvestTypeReqDto;
import com.yundao.tenant.dto.customer.tag.TagResDto;
import com.yundao.tenant.dto.customer.v2.CustomerConditionResult;
import com.yundao.tenant.dto.customer.v2.CustomerV2PageReqDto;
import com.yundao.tenant.dto.customer.v2.CustomerV2PageResDto;
import com.yundao.tenant.dto.department.DepartmentUserDto;
import com.yundao.tenant.dto.question.RiskEvaluationResDto;
import com.yundao.tenant.dto.sale.leads.LeadsForCustomerDetailReqDto;
import com.yundao.tenant.dto.user.customer.UserCustomerFocusReqDto;
import com.yundao.tenant.dto.user.customer.UserCustomerReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.enums.common.SexEnum;
import com.yundao.tenant.enums.customer.CustomerAddTypEnum;
import com.yundao.tenant.enums.customer.CustomerAttachTypeEnum;
import com.yundao.tenant.enums.customer.CustomerBelongTypeEnum;
import com.yundao.tenant.enums.customer.CustomerLevelEnum;
import com.yundao.tenant.enums.customer.CustomerRiskRatingEnum;
import com.yundao.tenant.enums.customer.CustomerSourceEnum;
import com.yundao.tenant.enums.customer.CustomerSourceType;
import com.yundao.tenant.enums.customer.CustomerStatusEnum;
import com.yundao.tenant.enums.customer.CustomerTypeEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerAttachMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerDetailMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerInvestTypeMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerTransferMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerFocusMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsMapper;
import com.yundao.tenant.mapper.customer.customer.CustomerMapper;
import com.yundao.tenant.mapper.customer.tag.TagMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerAttach;
import com.yundao.tenant.model.base.customer.BaseCustomerAttachExample;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;
import com.yundao.tenant.model.base.customer.BaseCustomerDetail;
import com.yundao.tenant.model.base.customer.BaseCustomerExample;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestType;
import com.yundao.tenant.model.base.customer.BaseCustomerInvestTypeExample;
import com.yundao.tenant.model.base.customer.BaseCustomerTransfer;
import com.yundao.tenant.model.base.customer.BaseTag;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomerExample.Criteria;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocus;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocusExample;
import com.yundao.tenant.model.base.sale.BaseLeads;
import com.yundao.tenant.model.base.sale.BaseLeadsExample;
import com.yundao.tenant.service.cc.cccustomeruserrel.CcCustomerUserRelService;
import com.yundao.tenant.service.customer.attach.CustomerAttachService;
import com.yundao.tenant.service.customer.credentials.CustomerCredentialsService;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.customer.customerbank.CustomerBankService;
import com.yundao.tenant.service.customer.customerdetail.CustomerDetailService;
import com.yundao.tenant.service.customer.customerinvesttype.CustomerInvestTypeService;
import com.yundao.tenant.service.customer.tag.impl.TagServiceImpl;
import com.yundao.tenant.service.department.DepartmentService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.question.QuestionService;
import com.yundao.tenant.service.region.RegionService;
import com.yundao.tenant.service.sale.leads.LeadsService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.service.user.customer.UserCustomerFocusService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.util.ArgsUtils;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.MobileUtil;
import com.yundao.tenant.util.StringUtil;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.ValidateUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;

@Service
public class CustomerServiceImpl extends AbstractService implements CustomerService {

	private static Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Autowired
	private BaseCustomerMapper baseCustomerMapper;

	@Autowired
	private BaseCustomerDetailMapper baseCustomerDetailMapper;

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private BaseCustomerAttachMapper baseCustomerAttachMapper;

	@Autowired
	private BaseUserCustomerFocusMapper baseUserCustomerFocusMapper;

	@Autowired
	private BaseCustomerInvestTypeMapper baseCustomerInvestTypeMapper;

	@Autowired
	private CustomerInvestTypeService customerInvestTypeService;

	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired

	private UserCustomerFocusService userCustomerFocus;
	@Autowired
	private TagMapper tagMapper;

	@Autowired
	private TagServiceImpl tagService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private BaseLeadsMapper baseLeadsMapper;

	@Autowired
	private CustomerCredentialsService customerCredentialsService;

	@Autowired
	private CustomerAttachService customerAttachService;

	@Autowired
	private CustomerBankService customerBankService;

	@Autowired
	private BaseUserCustomerMapper baseUserCustomerMapper;

	@Autowired
	private MsgMessageService msgMessageService;

	@Autowired
	private LeadsService leadsService;

	@Autowired
	QuestionService questionService;

	@Autowired
	CcCustomerUserRelService ccCustomerUserRelService;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private UserService userService;

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CustomerDetailService customerDetailService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private BaseCustomerTransferMapper baseCustomerTransferMapper;

	@Override
	public Result<PermissionResultDto> addFromBook(String customerList) throws Exception {
		if (StringUtils.isBlank(customerList)) {
			throw new BaseException(Code1200000.CODE_1200193);
		}
		PermissionResultDto permissionResultDto = new PermissionResultDto();

		JavaType javaType = JsonUtils.getCollectionType(List.class, BaseCustomer.class);
		List<BaseCustomer> list = JsonUtils.jsonToObject(customerList, javaType);

		for (BaseCustomer customer : list) {
			////去掉非数字
			customer.setMobile(customer.getMobile().replaceAll("[^0-9]", ""));// 去掉非数字
			if (StringUtils.isBlank(customer.getMobile())) {
				FailListDto fail = new FailListDto();
				fail.setId(customer.getId());
				fail.setName(customer.getName());
				fail.setCode(Code1230000.CODE_1230001);
				permissionResultDto.getFailList().add(fail);
				continue;
			} else if (!MobileUtil.veriyMobile(customer.getMobile())) {
				FailListDto fail = new FailListDto();
				fail.setId(customer.getId());
				fail.setName(customer.getName());
				fail.setCode(Code1230000.CODE_1230003);
				permissionResultDto.getFailList().add(fail);
				continue;
			}
			if (StringUtils.isBlank(customer.getName())) {
				FailListDto fail = new FailListDto();
				fail.setId(customer.getId());
				fail.setName(customer.getName());
				fail.setCode(Code1230000.CODE_1230004);
				permissionResultDto.getFailList().add(fail);
				continue;
			}

			// 判断手机号是否重复,考虑编辑的情况
			BaseCustomerExample example = new BaseCustomerExample();
			BaseCustomerExample.Criteria criteria = example.createCriteria();
			criteria.andMobileEqualTo(DesUtils.encrypt(customer.getMobile()));
			List<BaseCustomer> customers = baseCustomerMapper.selectByExample(example);
			if (customers != null && !customers.isEmpty()) {
				FailListDto fail = new FailListDto();
				fail.setId(customer.getId());
				fail.setName(customer.getName());
				fail.setCode(Code1230000.CODE_1230002);
				permissionResultDto.getFailList().add(fail);
				continue;
			}

			// 添加客户
			customer.setMobile(BaseContactUtils.encrypt(customer.getMobile()));
			customer.setCreateDate(new Date());
			customer.setCreateUserId(super.getHeaderUserId());
			customer.setTenantId(super.getHeaderTenantId());
			customer.setStatus(CustomerStatusEnum.VALID.getValue());
			customer.setId(null);
			customer.setIsDelete(CommonConstant.ZERO);
			customer.setBelongType(CustomerBelongTypeEnum.PRIVATE.getValue());
			baseCustomerMapper.insertSelective(customer);
			// 修改用户编码
			customer.setNumber(String.format("%08d", customer.getId()));
			baseCustomerMapper.updateByPrimaryKeySelective(customer);

			// 新增客户详情
			baseCustomerDetailMapper.deleteByPrimaryKey(customer.getId());// 删除客户详情
			BaseCustomerDetail customerDetail = new BaseCustomerDetail();
			customerDetail.setId(customer.getId());
			customerDetail.setTenantId(customer.getTenantId());
			baseCustomerDetailMapper.insertSelective(customerDetail);

			// 添加关联关系
			BaseUserCustomer userCustomer = new BaseUserCustomer();
			userCustomer.setTenantId(super.getHeaderTenantId());
			userCustomer.setCustomerId(customer.getId());
			userCustomer.setUserId(super.getHeaderUserId());
			userCustomer.setCreateDate(new Date());
			userCustomer.setCreateUserId(super.getHeaderUserId());
			userCustomer.setDistributionDate(new Date());
			userCustomer.setDistributionUserId(super.getHeaderUserId());
			userCustomer.setSourceType(CustomerSourceType.SELF_BUILT.getValue());
			baseUserCustomerMapper.insertSelective(userCustomer);

			// 添加客户移交记录
			BaseCustomerTransfer record = new BaseCustomerTransfer();
			super.initialModel(record);
			record.setAfterUserId(this.getHeaderUserId());
			record.setAfterUser(this.getRealName());
			record.setCustomerId(customer.getId());
			record.setTransferDate(new Date());
			record.setRemark("自建客户");
			baseCustomerTransferMapper.insertSelective(record);

			// 发送动态消息
			sendToMessage(customer);

			PassListDto pass = new PassListDto();
			pass.setId(customer.getId());
			pass.setName(customer.getName());
			permissionResultDto.getPassList().add(pass);
		}

		return Result.newSuccessResult(permissionResultDto);

	}

	public Result<Long> add(CustomerReqDto reqDto) throws Exception {
		validateDto(reqDto);
		BaseContactUtils.encrypt(reqDto);// 基础信息加密
		BaseCustomer model = new BaseCustomer();
		BeanUtils.copyProperties(reqDto, model);
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setTenantId(super.getHeaderTenantId());
		model.setStatus(CustomerStatusEnum.VALID.getValue());
		model.setEmail(reqDto.getEmail());
		model.setId(null);
		model.setIsDelete(CommonConstant.ZERO);
		if (reqDto.getAddCustomerType() == 3) {
			model.setBelongType(1);
		} else if (reqDto.getAddCustomerType() == 1 || reqDto.getAddCustomerType() == 2) {
			model.setBelongType(0);
		}
		baseCustomerMapper.insertSelective(model);
		// 新增客户关联关系
		insertUserCustomer(model.getId(), reqDto.getAddCustomerType());

		// 修改用户编码
		model.setNumber(String.format("%08d", model.getId()));
		baseCustomerMapper.updateByPrimaryKeySelective(model);
		// 新增客户详情
		baseCustomerDetailMapper.deleteByPrimaryKey(model.getId());// 删除客户详情
		BaseCustomerDetail customerDetail = new BaseCustomerDetail();
		BeanUtils.copyProperties(reqDto, customerDetail);
		customerDetail.setId(model.getId());
		customerDetail.setTenantId(model.getTenantId());
		baseCustomerDetailMapper.insertSelective(customerDetail);
		// 新增投资偏好
		if (BooleanUtils.isNotEmpty(reqDto.getInvestTypes())) {
			customerInvestTypeService.addCustomerInvest(model.getId(), reqDto.getInvestTypes());
		}
		// 设置用户标签
		tagService.processSetCustomerTag(model.getId(), reqDto.getTags());

		// 设置用户的银行看信息
		if (reqDto.getCard() != null || BooleanUtils.isNotEmpty(reqDto.getCardId())) {
			BaseCustomerCredentials credentials = new BaseCustomerCredentials();
			credentials.setNumber(reqDto.getCardId());
			credentials.setType(reqDto.getCard() == null ? null : reqDto.getCard().longValue());
			credentials.setTenantId(model.getTenantId());
			customerCredentialsService.insert(credentials);
			customerCredentialsService.insertRel(model.getId(), credentials.getId());
		}
		// 发送动态消息
		sendToMessage(model);
		return Result.newSuccessResult(model.getId());
	}

	@Override
	public Result<Long> addForAppScaning(CustomerScaningAddReqDto reqDto) throws Exception {
		// 验证手机号
		validateMobile(reqDto.getMobile(), null);

		BaseCustomer model = new BaseCustomer();
		model.setName(reqDto.getName());
		model.setMobile(BaseContactUtils.encrypt(reqDto.getMobile()));
		model.setEmail(BaseContactUtils.encrypt(reqDto.getEmail()));
		model.setCreateDate(new Date());
		model.setCreateUserId(super.getHeaderUserId());
		model.setTenantId(super.getHeaderTenantId());
		model.setStatus(CustomerStatusEnum.VALID.getValue());
		model.setId(null);
		model.setIsDelete(CommonConstant.ZERO);
		model.setBelongType(0);
		baseCustomerMapper.insertSelective(model);

		// 添加客户详情
		baseCustomerDetailMapper.deleteByPrimaryKey(model.getId());// 删除客户详情
		BaseCustomerDetail customerDetail = new BaseCustomerDetail();
		customerDetail.setOrganization(reqDto.getOrganization());
		customerDetail.setPosition(reqDto.getPosition());
		customerDetail.setId(model.getId());
		customerDetail.setTenantId(model.getTenantId());
		baseCustomerDetailMapper.insertSelective(customerDetail);

		// 新增客户关联关系
		BaseUserCustomer userCustomer = new BaseUserCustomer();
		userCustomer.setCustomerId(model.getId());
		userCustomer.setUserId(super.getHeaderUserId());
		userCustomer.setSourceType(CustomerSourceType.SELF_BUILT.getValue());
		userCustomerService.insert(userCustomer);

		return Result.newSuccessResult(model.getId());

	}

	@Override
	public Result<PaginationSupport<CustomerV2PageResDto>> getPageV2(CustomerV2PageReqDto dto, Integer permission)
			throws BaseException {
		String logPrefix = "客户||获取分页数据||";
		log.info("%s dto：%s permission：%s", logPrefix, JsonUtils.objectToJson(dto), permission);
		if (BooleanUtils.isNotEmpty(dto.getMobile()))
			dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));

		this.filterSQLInject(dto);

		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);

		this.convertBirthday(paramMap, dto);

		userService.setPermissionCondition(paramMap, permission);

		this.setUserIdsParamCondition(paramMap, dto, permission);

		this.setCustomerIdsParamCondition(paramMap, dto);

		PaginationSupport<CustomerV2PageResDto> page = PaginationSupport.newDefault(paramMap);
		List<CustomerV2PageResDto> dtos = customerMapper.selectPage(paramMap);
		int count = customerMapper.selectPageCount(paramMap);
		this.setTextForV2(dtos);
		// 设置客户标签
		this.setTags(dtos);

		page.setTotalCount(count);
		page.setDatas(dtos);
		log.info("%s 完成", logPrefix);
		return Result.newSuccessResult(page);
	}

	private void setTags(List<CustomerV2PageResDto> dtos) throws BaseException {
		if (dtos != null && !dtos.isEmpty()) {
			Map<Long, CustomerV2PageResDto> map = new HashMap<>();
			List<Long> ids = new ArrayList<>();
			dtos.forEach((v) -> {
				map.put(v.getId(), v);
				ids.add(v.getId());
			});
			List<TagResDto> tags = tagMapper.selectByCustomerIds(ids, null);
			if (tags != null && !tags.isEmpty()) {
				for (TagResDto tag : tags) {
					if (tag.getCustomerId() == null) {
						continue;
					}
					CustomerV2PageResDto resDto = map.get(tag.getCustomerId());
					resDto.getTags().add(tag);
				}
			}
		}
	}

	private void convertBirthday(Map<String, Object> paramMap, CustomerV2PageReqDto dto) throws BaseException {
		if (BooleanUtils.isNotBlank(dto.getBirthdayBegin())) {
			paramMap.put("birthdayBeginMonth", DateUtil.getMonth(dto.getBirthdayBegin()));
			paramMap.put("birthdayBeginDay", DateUtil.getDay(dto.getBirthdayBegin()));
		}
		if (BooleanUtils.isNotBlank(dto.getBirthdayEnd())) {
			paramMap.put("birthdayEndMonth", DateUtil.getMonth(dto.getBirthdayEnd()));
			paramMap.put("birthdayEndDay", DateUtil.getDay(dto.getBirthdayEnd()));
		}
	}

	private void filterSQLInject(CustomerV2PageReqDto dto) throws BaseException {
		if (BooleanUtils.isNotBlank(dto.getLevels()))
			dto.setLevels(SymbolStrUtils.filterUnNumeric(dto.getLevels()));

		if (BooleanUtils.isNotBlank(dto.getSexs()))
			dto.setSexs(SymbolStrUtils.filterUnNumeric(dto.getSexs()));

		if (BooleanUtils.isNotBlank(dto.getProvinceCodes()))
			dto.setProvinceCodes(SymbolStrUtils.filterUnNumeric(dto.getProvinceCodes()));

		if (BooleanUtils.isNotBlank(dto.getCityCodes()))
			dto.setCityCodes(SymbolStrUtils.filterUnNumeric(dto.getCityCodes()));

		if (BooleanUtils.isNotBlank(dto.getIsDeals()))
			dto.setIsDeals(SymbolStrUtils.filterUnNumeric(dto.getIsDeals()));

		if (BooleanUtils.isNotBlank(dto.getStatuss()))
			dto.setStatuss(SymbolStrUtils.filterUnNumeric(dto.getStatuss()));

		if (BooleanUtils.isNotBlank(dto.getInvestTypes()))
			dto.setInvestTypes(SymbolStrUtils.filterUnNumeric(dto.getInvestTypes()));

		if (BooleanUtils.isNotBlank(dto.getRiskRatings()))
			dto.setRiskRatings(SymbolStrUtils.filterUnNumeric(dto.getRiskRatings()));

		if (BooleanUtils.isNotBlank(dto.getTypies()))
			dto.setTypies(SymbolStrUtils.filterUnNumeric(dto.getTypies()));
	}

	private void setTextForV2(List<CustomerV2PageResDto> dtos) throws BaseException {
		Long userId = super.getHeaderUserId();
		// 所属理财师部门
		List<Long> fpIds = LambdaMap.toSingleList(dtos, CustomerV2PageResDto::getFpId);
		List<DepartmentUserDto> departments = new ArrayList<>();
		if (BooleanUtils.isNotEmpty(fpIds))
			departments = departmentService.getByUserIds(fpIds);

		for (CustomerV2PageResDto dto : dtos) {
			dto.setSexText(dictionaryService.toText(DicCode.DIC_SEX, dto.getSex()));
			dto.setLevelText(dictionaryService.toText(DicCode.DIC_CUSTOMER_LEVEL, dto.getLevel()));
			dto.setMobile(BaseContactUtils.decrypt(dto.getMobile()));
			dto.setIsDealText(dto.getDealDate() != null ? "是" : "否");
			if (BooleanUtils.isNotEmpty(dto.getProvinceCode()))
				dto.setProvinceText(regionService.toText(dto.getProvinceCode()));
			if (BooleanUtils.isNotEmpty(dto.getCityCode()))
				dto.setCityText(regionService.toText(dto.getCityCode()));
			if (userId.equals(dto.getFpId())) {
				dto.setCanFollow(YesOrNoEnum.YES.getValue());
			} else {
				dto.setCanFollow(YesOrNoEnum.NO.getValue());
				dto.setTipsForDisabledFollow("该客户不属于您所有，不可跟进");
			}
			dto.setStatusText(dictionaryService.toText(DicCode.DIC_CUSTOMER_STATUS, dto.getStatus()));
			if (BooleanUtils.isNotEmpty(departments) && dto.getFpId() != null) {
				DepartmentUserDto departmentUserDto = LambdaFilter.firstOrDefault(departments,
						m -> m.getFpId().equals(dto.getFpId()));
				if (departmentUserDto != null)
					dto.setDepartment(departmentUserDto.getDepartmentName());
			}

		}
	}

	private void setCustomerIdsParamCondition(Map<String, Object> paramMap, CustomerV2PageReqDto dto)
			throws BaseException {
		CustomerConditionResult conditionResult = new CustomerConditionResult();
		conditionResult.setHasCondition(false);

		this.setConditionForTags(dto, conditionResult);

		this.setConditionForInvestTypes(dto, conditionResult);

		this.setConditionForFocus(dto, conditionResult);

		if (!conditionResult.getHasCondition())
			return;

		if (BooleanUtils.isNotEmpty(conditionResult.getCustomerIds())) {
			List<Long> customerIds = LambdaFilter.distinct(conditionResult.getCustomerIds());
			paramMap.put("customerIds", SymbolStrUtils.longToStr(customerIds));
		} else {
			paramMap.put("customerIds", "-9999");
		}

	}

	private void setUserIdsParamCondition(Map<String, Object> paramMap, CustomerV2PageReqDto dto, Integer permission)
			throws BaseException {
		// 权限内能查看到谁的理财师id
		List<Long> permissionUserIds = this.getPermissionUserIds(permission);

		String nobody = "-9999";

		// 下拉选择范围过滤，选择我负责的客户或我部门的客户时出发
		if (BooleanUtils.isNotBlank(dto.getScope())) {
			List<Long> conditionForScopeUserIds = this.getConditionForScope(dto.getScope());
			if (BooleanUtils.isNotEmpty(conditionForScopeUserIds))
				permissionUserIds = this.filterNonPermissionUserIds(permissionUserIds, conditionForScopeUserIds);
		}

		if (BooleanUtils.isNotBlank(dto.getDepartment())) {
			// 理财师所在部门筛选
			List<Long> conditionForDepartmentUserIds = this.getConditionForDepartment(dto.getDepartment());
			String userIdsParam;
			if (BooleanUtils.isEmpty(conditionForDepartmentUserIds)) {
				userIdsParam = nobody;
			} else {
				List<Long> userIds = this.filterNonPermissionUserIds(permissionUserIds, conditionForDepartmentUserIds);
				userIdsParam = BooleanUtils.isEmpty(userIds) ? nobody : SymbolStrUtils.longToStr(userIds);
			}
			paramMap.put("userIds", userIdsParam);

		} else {
			if (BooleanUtils.isNotEmpty(permissionUserIds)) {
				paramMap.put("userIds", SymbolStrUtils.longToStr(permissionUserIds));
			}
		}

	}

	private List<Long> getPermissionUserIds(Integer permission) throws BaseException {
		List<Long> permissionUserIds = new ArrayList<>();
		// 全部，直接返回
		if (DataObjectPermissionEnum.PUBLIC.getValue().equals(permission))
			return permissionUserIds;

		if (DataObjectPermissionEnum.PERSONAL.getValue().equals(permission)) {
			permissionUserIds.add(super.getHeaderUserId());
		} else if (DataObjectPermissionEnum.DEPARTMENT.getValue().equals(permission)) {
			permissionUserIds.addAll(userService.getSameDepUsers(super.getHeaderUserId()));
		} else {
			permissionUserIds.add((long) -9999);
		}
		return permissionUserIds;
	}

	/**
	 * 过滤没权限查看的
	 *
	 * @param permissionUserIds
	 *            有权限查看的
	 * @param conditionCollectUserIds
	 *            想要查看的
	 */
	private List<Long> filterNonPermissionUserIds(List<Long> permissionUserIds, List<Long> conditionCollectUserIds)
			throws BaseException {
		List<Long> userIds = new ArrayList<>();
		if (BooleanUtils.isEmpty(conditionCollectUserIds))
			return userIds;
		// 表示拥有查看全部的权限
		if (BooleanUtils.isEmpty(permissionUserIds))
			return conditionCollectUserIds;
		// 去重
		conditionCollectUserIds = LambdaFilter.distinct(conditionCollectUserIds);
		for (Long conditionCollectUserId : conditionCollectUserIds) {
			Long id = LambdaFilter.firstOrDefault(permissionUserIds, m -> m.equals(conditionCollectUserId));
			if (id != null)
				userIds.add(id);
		}
		return userIds;
	}

	/**
	 * 理财师所在部门搜索 条件设置
	 */
	private List<Long> getConditionForDepartment(String departmentReqKeyword) throws BaseException {
		if (BooleanUtils.isBlank(departmentReqKeyword))
			return new ArrayList<>();
		return userService.getLikeDepartmentName(departmentReqKeyword);
	}

	private List<Long> getConditionForScope(String scope) throws BaseException {
		List<Long> userIds = new ArrayList<>();
		if (BooleanUtils.isBlank(scope))
			return new ArrayList<>();
		if (scope.equals("my")) {
			userIds.add(super.getHeaderUserId());
		} else if (scope.equals("department")) {
			userIds.addAll(userService.getSameDepUsers(super.getHeaderUserId()));
		}
		return userIds;
	}

	private void setConditionForTags(CustomerV2PageReqDto dto, CustomerConditionResult conditionResult)
			throws BaseException {
		if (BooleanUtils.isBlank(dto.getTags()))
			return;

		conditionResult.setHasCondition(true);
		List<Long> customerIds = tagService.getCustomerIdLikeNames(SymbolStrUtils.toList(dto.getTags()));
		conditionResult.setCustomerIds(customerIds);
	}

	private void setConditionForInvestTypes(CustomerV2PageReqDto dto, CustomerConditionResult conditionResult)
			throws BaseException {
		if (BooleanUtils.isBlank(dto.getInvestTypes()))
			return;

		if (conditionResult.hasEmptyResult())
			return;

		conditionResult.setHasCondition(true);

		List<Long> emptyList = new ArrayList<>();
		List<Long> ids = SymbolStrUtils.toLongWithTypeCheck(dto.getInvestTypes());
		if (BooleanUtils.isEmpty(ids)) {
			conditionResult.setCustomerIds(emptyList);
			return;
		}

		BaseCustomerInvestTypeExample example = new BaseCustomerInvestTypeExample();
		BaseCustomerInvestTypeExample.Criteria criteria = example.createCriteria();
		criteria.andProductTypeIdIn(ids);
		if (BooleanUtils.isNotEmpty(conditionResult.getCustomerIds())) {
			criteria.andCustomerIdIn(conditionResult.getCustomerIds());
		}
		List<BaseCustomerInvestType> customerInvestTypes = baseCustomerInvestTypeMapper.selectByExample(example);
		if (BooleanUtils.isEmpty(customerInvestTypes)) {
			conditionResult.setCustomerIds(emptyList);
			return;
		}
		List<Long> customerIds = LambdaMap.toSingleList(customerInvestTypes, BaseCustomerInvestType::getCustomerId);
		conditionResult.setCustomerIds(customerIds);
	}

	private void setConditionForFocus(CustomerV2PageReqDto dto, CustomerConditionResult conditionResult)
			throws BaseException {
		if (BooleanUtils.isBlank(dto.getScope()))
			return;

		if (conditionResult.hasEmptyResult())
			return;

		if ("focus".equals(dto.getScope())) {
			conditionResult.setHasCondition(true);
			BaseUserCustomerFocusExample example = new BaseUserCustomerFocusExample();
			BaseUserCustomerFocusExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(super.getHeaderUserId());
			if (BooleanUtils.isNotEmpty(conditionResult.getCustomerIds())) {
				criteria.andCustomerIdIn(conditionResult.getCustomerIds());
			}

			List<BaseUserCustomerFocus> userCustomerFocusList = baseUserCustomerFocusMapper.selectByExample(example);
			if (BooleanUtils.isEmpty(userCustomerFocusList)) {
				conditionResult.setCustomerIds(new ArrayList<>());
				return;
			}
			List<Long> customerIds = LambdaMap.toSingleList(userCustomerFocusList,
					BaseUserCustomerFocus::getCustomerId);
			conditionResult.setCustomerIds(customerIds);
		}
	}

	private void sendToMessage(BaseCustomer model) throws BaseException {
		Map<String, Object> params = ArgsUtils.toMap(model);
		params.put("createUserName", super.getHeaderUser().getRealName());
		params.put("customerId", model.getId());
		msgMessageService.processSendMessage(MsgMessageCodeEnum.ADD_CUSTOMER.getCode(), params);
	}

	private void insertUserCustomer(Long customerId, Integer addCustomerType) throws BaseException {
		if (CustomerAddTypEnum.CUSTOMER_ADD_TYPE_1.getType().equals(addCustomerType)) {
			if (customerId == null) {
				throw new BaseException(GJLCodeConstant.CODE_1210019);
			}
			BaseUserCustomer userCustomer = new BaseUserCustomer();
			userCustomer.setTenantId(super.getHeaderTenantId());
			userCustomer.setCustomerId(customerId);
			userCustomer.setUserId(super.getHeaderUserId());
			userCustomer.setCreateDate(new Date());
			userCustomer.setCreateUserId(super.getHeaderUserId());
			userCustomer.setDistributionDate(new Date());
			userCustomer.setDistributionUserId(super.getHeaderUserId());
			userCustomer.setSourceType(CustomerSourceType.SELF_BUILT.getValue());
			baseUserCustomerMapper.insertSelective(userCustomer);
			// 添加客户移交记录
			BaseCustomerTransfer record = new BaseCustomerTransfer();
			super.initialModel(record);
			record.setAfterUserId(this.getHeaderUserId());
			record.setAfterUser(this.getRealName());
			record.setCustomerId(customerId);
			record.setTransferDate(new Date());
			record.setRemark("自建客户");
			baseCustomerTransferMapper.insertSelective(record);
			// 插入调配日志
			doSetBelongType(customerId, CustomerBelongTypeEnum.PRIVATE.getValue());
		} else {
			doSetBelongType(customerId, CustomerBelongTypeEnum.OPENSEA.getValue());
		}
	}

	private void validateDto(CustomerReqDto reqDto) throws Exception {
		validateAssets(reqDto.getType(), "", reqDto.getId());
		validateQQ(reqDto.getQq());
		validateTags(reqDto.getTags());
		// 验证手机号
		validateMobile(reqDto.getMobile(), reqDto.getId());
	}

	private void validateTags(String tags) throws Exception {
		if (BooleanUtils.isNotEmpty(tags)) {
			String[] tagArr = tags.split(",");
			if (tagArr.length > 30) {
				throw new BaseException(GJLCodeConstant.CODE_1210058);
			}
			for (String tag : tagArr) {
				if (tag.length() > 8) {
					throw new BaseException(GJLCodeConstant.CODE_1210042, tag + "标签过长，标签最多8位");
				}
			}
		}
	}

	private void validateQQ(String qq) throws Exception {
		if (BooleanUtils.isNotEmpty(qq)) {
			if (!StringUtil.isNumber(qq)) {
				throw new BaseException(GJLCodeConstant.CODE_1210037);
			}
		}
	}

	private void validateAssets(Integer type, String assets, Long customerId) throws Exception {
		if (type != null && CustomerTypeEnum.CUSTOMER_TYPE_2.getType() == type) {
			if (StringUtils.isBlank(assets)) {
				if (customerId == null) {
					throw new BaseException(GJLCodeConstant.CODE_1210034);
				}
				// 判断是否有上传了资产证明
				BaseCustomerAttachExample attachExample = new BaseCustomerAttachExample();
				attachExample.createCriteria().andCustomerIdEqualTo(customerId)
						.andTypeEqualTo(CustomerAttachTypeEnum.ASSET.getType());
				List<BaseCustomerAttach> attaches = baseCustomerAttachMapper.selectByExample(attachExample);
				if (attaches == null || attaches.isEmpty()) {
					throw new BaseException(GJLCodeConstant.CODE_1210034);
				}
			}
		}
	}

	public Result<Integer> update(CustomerReqDto reqDto) throws Exception {
		BaseContactUtils.encrypt(reqDto);// 基础信息加密
		BaseCustomer model = new BaseCustomer();
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerMapper.updateByPrimaryKeySelective(model);
		return Result.newSuccessResult(count);
	}

	@Override
	public Result<Boolean> updateForApp(Map<String, String> params) throws Exception {
		if (StringUtils.isBlank(params.get("customerId"))) {
			throw new BaseException(CodeConstant.CODE_1220047);
		}
		Long customerId = NumberUtils.toLong(params.get("customerId"));

		BaseCustomer model = baseCustomerMapper.selectByPrimaryKey(customerId);
		if (model == null) {
			throw new BaseException(CodeConstant.CODE_1200084);
		}
		boolean doUpdate = false;
		if (params.containsKey("customerName")) {
			doUpdate = true;
			model.setName(params.get("customerName"));
		}
		if (params.containsKey("gender")) {// 性别
			doUpdate = true;
			model.setSex(NumberUtils.toInt(params.get("gender")));
		}
		if (params.containsKey("customerLevel")) {// 客户级别
			doUpdate = true;
			model.setLevel(NumberUtils.toInt(params.get("customerLevel")));
		}
		if (params.containsKey("from")) {// 客户来源
			doUpdate = true;
			model.setSource(NumberUtils.toInt(params.get("from")));
		}
		if (params.containsKey("investManType")) {// 投资人类型
			doUpdate = true;
			model.setType(NumberUtils.toInt(params.get("investManType")));
		}
		if (params.containsKey("riskType")) {// 风险特征
			doUpdate = true;
			model.setRiskRating(NumberUtils.toInt(params.get("riskType")));
		}
		if (params.containsKey("remark")) {// 风险特征
			doUpdate = true;
			model.setRemark(params.get("remark"));
		}
		if (params.containsKey("mail")) {// 风险特征
			doUpdate = true;
			model.setEmail(BaseContactUtils.encrypt(params.get("mail")));
		}
		if (params.containsKey("mobile")) {// 风险特征
			doUpdate = true;
			String mobile = params.get("mobile");
			if (StringUtils.isBlank(mobile)) {
				throw new BaseException(CodeConstant.CODE_1220023);
			}
			mobile=mobile.replaceAll("[^0-9]", "");//去掉非数字
			
			if (!MobileUtil.veriyMobile(mobile)) {
				throw new BaseException(GJLCodeConstant.CODE_1210048);
			}
			model.setMobile(BaseContactUtils.encrypt(mobile));
		}
		if (doUpdate) {
			model.setUpdateDate(new Date());
			model.setUpdateUserId(super.getHeaderUserId());
			int count = baseCustomerMapper.updateByPrimaryKey(model);// 修改客户主表信息
		}

		doUpdate = false;
		boolean doInsert = false;
		// 修改客户详情
		BaseCustomerDetail detail = baseCustomerDetailMapper.selectByPrimaryKey(model.getId());
		if (detail == null) {
			detail = new BaseCustomerDetail();
			doInsert = true;
		}
		if (params.containsKey("birthday")) {// 生日
			doUpdate = true;
			Date birthday = new Date(Long.parseLong(params.get("birthday")));
			detail.setBirthday(birthday);
		}
		if (params.containsKey("weChat")) {// 微信
			doUpdate = true;
			String weChat = String.valueOf(params.get("weChat"));
			if (StringUtils.isBlank(weChat)) {
				detail.setWechat("");
			} else if (weChat.length() < 6 || weChat.length() > 20) {
				throw new BaseException(GJLCodeConstant.CODE_1210089);
			} else {
				detail.setWechat(BaseContactUtils.encrypt(params.get("weChat")));
			}
		}
		if (params.containsKey("qq")) {// qq
			doUpdate = true;
			String qq = params.get("qq");
			if (StringUtils.isNotBlank(qq)) {
				if (!ValidateUtils.veriyQQ(qq)) {
					throw new BaseException(CodeConstant.CODE_1200109);
				}
				if (qq.length() > 20) {
					throw new BaseException(CodeConstant.CODE_1200134);
				}

				detail.setQq(BaseContactUtils.encrypt(params.get("qq")));
			} else {
				detail.setQq("");
			}
		}
		if (params.containsKey("province")) {// 省份
			doUpdate = true;
			detail.setProvinceCode(params.get("province"));
		}
		if (params.containsKey("city")) {// 城市
			doUpdate = true;
			detail.setCityCode(params.get("city"));
		}
		if (params.containsKey("address")) {// 地址
			doUpdate = true;
			detail.setAddress(params.get("address"));
		}
		if (params.containsKey("industry")) {// 行业
			doUpdate = true;
			detail.setTrade(params.get("industry"));
		}
		if (params.containsKey("organization")) {// 机构
			doUpdate = true;
			detail.setOrganization(params.get("organization"));
		}
		if (params.containsKey("job")) {// 职位
			doUpdate = true;
			detail.setPosition(params.get("job"));
		}

		if (doInsert && doUpdate) {
			detail.setTenantId(model.getTenantId());
			detail.setIsDelete(0);
			baseCustomerDetailMapper.insert(detail);
		} else if (doUpdate) {
			baseCustomerDetailMapper.updateByPrimaryKey(detail);
		}

		// 修改客户标签
		if (params.containsKey("tags")) {
			StringBuilder builder = new StringBuilder();
			if (StringUtils.isNotBlank(params.get("tags"))) {
				List<NameIdDto> tagList = JsonUtils.jsonToObject(params.get("tags"),
						new BaseTypeReference<List<NameIdDto>>() {
						});
				if (tagList != null && !tagList.isEmpty()) {
					for (NameIdDto nameIdDto : tagList) {
						if (builder.length() > 0) {
							builder.append(",");
						}
						builder.append(nameIdDto.getName());
					}
				}
				validateTags(builder.toString());// 校验标签
			}
			tagService.processSetCustomerTag(model.getId(), builder.toString());// 修改客户标签
		}
		// 修改客户证件信息
		doInsert = false;
		doUpdate = false;
		CustomerCredentialsDto dto = customerCredentialsService.selectByCustomerId(model.getId());
		BaseCustomerCredentials credentials = new BaseCustomerCredentials();
		if (dto != null) {
			BeanUtils.copyProperties(dto, credentials);
		} else {
			doInsert = true;
			credentials.setTenantId(model.getTenantId());
		}

		if (params.containsKey("certificateType")) {// 证件类型
			doUpdate = true;
			credentials.setType(Long.parseLong(params.get("certificateType")));
		}
		if (params.containsKey("certificateNumber")) {
			doUpdate = true;
			credentials.setNumber(params.get("certificateNumber"));
		}
		if (params.containsKey("identityFrontCardUrl")) {
			doUpdate = true;
			credentials.setFront(params.get("identityFrontCardUrl"));
		}
		if (params.containsKey("identityBackCardUrl")) {
			doUpdate = true;
			credentials.setBack(params.get("identityBackCardUrl"));
		}

		if (doInsert && doUpdate) {
			customerCredentialsService.insert(credentials);
			customerCredentialsService.insertRel(model.getId(), credentials.getId());
		} else if (doUpdate) {
			customerCredentialsService.update(credentials);
		}

		// 资产证明
		if (params.containsKey("assetsCertificateUrlList")) {
			String assets = params.get("assetsCertificateUrlList");
			List<String> assetUrls = JsonUtils.jsonToObject(assets, new BaseTypeReference<List<String>>() {
			});
			customerAttachService.deleteByCustomerIdAndtype(model.getId(), CustomerAttachTypeEnum.ASSET.getType());// 删除客户名下所有资产证明附件
			if (assetUrls != null && !assetUrls.isEmpty()) {
				for (int i = 0; i < assetUrls.size(); i++) {
					String url = assetUrls.get(i);
					int indix_ = url.lastIndexOf(".");
					int beginIndix_ = url.lastIndexOf("/");
					// 新增
					BaseCustomerAttach record = new BaseCustomerAttach();
					record.setCustomerId(model.getId());
					record.setTenantId(model.getTenantId());
					if (indix_ != -1 && beginIndix_ != -1) {
						record.setName(url.substring(beginIndix_ + 1, indix_));
					}
					record.setUrl(url);
					record.setSeqencing(i);
					record.setType(CustomerAttachTypeEnum.ASSET.getType());
					customerAttachService.insert(record);
				}
			}
		}

		// 修改投资偏好
		if (params.containsKey("investLikeSelectList")) {
			String investStr = params.get("investLikeSelectList");
			List<String> investList = JsonUtils.jsonToObject(investStr, new BaseTypeReference<List<String>>() {
			});

			customerInvestTypeService.deleteByCustomerId(model.getId());
			if (investList != null && !investList.isEmpty()) {
				for (String invest : investList) {
					// 新增
					CustomerInvestTypeReqDto investDto = new CustomerInvestTypeReqDto();
					investDto.setCustomerId(model.getId());
					investDto.setProductTypeId(NumberUtils.toLong(invest));
					investDto.setTenantId(model.getTenantId());
					customerInvestTypeService.add(investDto);
				}
			}
		}

		return Result.newSuccessResult(true);

	}

	@Override
	public Result<Integer> updateInfo(CustomerExclusiveContactReqDto reqDto) throws Exception {
		validateAssets(reqDto.getType(), reqDto.getAssets(), reqDto.getId());// 校验投资类型
		validateTags(reqDto.getTags());// 校验标签
		BaseCustomer model = baseCustomerMapper.selectByPrimaryKey(reqDto.getId());
		if (model == null) {
			throw new BaseException(CodeConstant.CODE_1200084);
		}
		BeanUtils.copyProperties(reqDto, model);
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerMapper.updateByPrimaryKey(model);// 修改客户主表信息

		// 修改客户详情
		BaseCustomerDetail detail = baseCustomerDetailMapper.selectByPrimaryKey(model.getId());
		boolean isDetailAdd = detail == null;
		if (isDetailAdd)
			detail = new BaseCustomerDetail();

		detail.setBirthday(reqDto.getBirthday());
		detail.setAddress(reqDto.getAddress());
		detail.setCityCode(reqDto.getCityCode());
		detail.setProvinceCode(reqDto.getProvinceCode());
		detail.setOrganization(reqDto.getOrganization());
		detail.setPosition(reqDto.getPosition());
		detail.setTrade(reqDto.getTrade());
		if (!isDetailAdd) {
			baseCustomerDetailMapper.updateByPrimaryKey(detail);
		} else {
			detail.setId(model.getId());
			detail.setTenantId(model.getTenantId());
			detail.setIsDelete(DeleteEnum.NOT_DELETED.getValue());
			baseCustomerDetailMapper.insert(detail);
		}

		// 修改客户标签
		tagService.processSetCustomerTag(model.getId(), reqDto.getTags());

		// 修改客户证件信息
		updateCredentials(reqDto.getCertBack(), reqDto.getCertFront(), reqDto.getCertNo(), reqDto.getCertType(), model);

		// 修改资产证明
		updateAssets(reqDto.getAssets(), model);

		// 修改银行卡信息
		customerBankService.deleteByCustomerId(model.getId());// 根据客户ID删除其所有银行卡信息
		CustomerBankReqDto bankReqDto = new CustomerBankReqDto();
		bankReqDto.setAccount(reqDto.getBankAccount());
		bankReqDto.setBack(reqDto.getBankBack());
		bankReqDto.setFront(reqDto.getBankFront());
		bankReqDto.setCustomerId(model.getId());
		bankReqDto.setTenantId(model.getTenantId());
		bankReqDto.setBankName(reqDto.getBankName());
		customerBankService.add(bankReqDto);

		// 修改投资偏好
		customerInvestTypeService.deleteByCustomerId(model.getId());
		String investTypes = reqDto.getInvestTypes();
		if (StringUtils.isNotBlank(investTypes)) {
			String[] invests = investTypes.split(",");
			for (String invest : invests) {
				CustomerInvestTypeReqDto investDto = new CustomerInvestTypeReqDto();
				investDto.setCustomerId(model.getId());
				investDto.setProductTypeId(NumberUtils.toLong(invest));
				investDto.setTenantId(model.getTenantId());
				customerInvestTypeService.add(investDto);
			}

		}
		return Result.newSuccessResult(count);

	}

	private void updateAssets(String assets, BaseCustomer model) throws BaseException {
		List<FileBaseDto> fileBaseDtos = JsonUtils.jsonToObject(assets, new BaseTypeReference<List<FileBaseDto>>() {
		});
		customerAttachService.deleteByCustomerIdAndtype(model.getId(), CustomerAttachTypeEnum.ASSET.getType());// 删除客户名下所有资产证明附件
		if (fileBaseDtos != null && !fileBaseDtos.isEmpty()) {
			for (FileBaseDto fileBaseDto : fileBaseDtos) {
				// 新增
				BaseCustomerAttach record = new BaseCustomerAttach();
				record.setCustomerId(model.getId());
				record.setTenantId(model.getTenantId());
				record.setName(fileBaseDto.getName());
				record.setUrl(fileBaseDto.getUrl());
				record.setSeqencing(fileBaseDto.getSeqencing());
				record.setType(CustomerAttachTypeEnum.ASSET.getType());
				record.setTypeName(CustomerAttachTypeEnum.ASSET.getName());
				customerAttachService.insert(record);
			}
		}
	}

	private void updateCredentials(String back, String front, String number, Integer type, BaseCustomer model)
			throws BaseException {
		CustomerCredentialsDto dto = customerCredentialsService.selectByCustomerId(model.getId());
		if (dto != null) {
			BaseCustomerCredentials credentials = new BaseCustomerCredentials();
			BeanUtils.copyProperties(dto, credentials);
			credentials.setBack(back);
			credentials.setFront(front);
			credentials.setNumber(number);
			credentials.setType(type == null ? null : type.longValue());
			customerCredentialsService.update(credentials);
		} else {
			BaseCustomerCredentials credentials = new BaseCustomerCredentials();
			credentials.setBack(back);
			credentials.setFront(front);
			credentials.setNumber(number);
			credentials.setType(type == null ? null : type.longValue());
			credentials.setTenantId(model.getTenantId());
			customerCredentialsService.insert(credentials);
			customerCredentialsService.insertRel(model.getId(), credentials.getId());
		}
	}

	@Override
	public Result<Integer> updateContact(CustomerContactReqDto reqDto) throws Exception {
		validateMobile(reqDto.getMobile(), reqDto.getId());// 校验手机号码

		BaseContactUtils.encrypt(reqDto);// 基础信息加密
		BaseCustomer model = new BaseCustomer();
		model.setId(reqDto.getId());
		model.setMobile(reqDto.getMobile());
		model.setEmail(reqDto.getEmail());
		model.setUpdateDate(new Date());
		model.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerMapper.updateByPrimaryKeySelective(model);// 修改客户表

		BaseCustomerDetail detail = baseCustomerDetailMapper.selectByPrimaryKey(model.getId());
		boolean insertFlag = false;
		if (detail == null) {
			insertFlag = true;
			detail = new BaseCustomerDetail();
			detail.setIsDelete(0);
		}
		detail.setQq(reqDto.getQq());
		detail.setWechat(reqDto.getWechat());
		if (insertFlag) {
			baseCustomerDetailMapper.insert(detail);
		} else {
			baseCustomerDetailMapper.updateByPrimaryKey(detail);// 修改客户详情表
		}

		return Result.newSuccessResult(count);

	}

	public Result<Integer> delete(Long id) throws Exception {
		BaseCustomer customer = new BaseCustomer();
		customer.setId(id);
		customer.setUpdateDate(new Date());
		customer.setUpdateUserId(super.getHeaderUserId());
		int count = baseCustomerMapper.updateByPrimaryKeySelective(customer);
		return Result.newSuccessResult(count);
	}

	/**
	 * 检查客户是否存在 exist:
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<Boolean> exist(Long id) throws BaseException {
		BaseCustomer model = baseCustomerMapper.selectByPrimaryKey(id);
		return Result.newSuccessResult(model != null);
	}

	public Result<CustomerDto> get(Long id) throws BaseException {
		BaseCustomer model = baseCustomerMapper.selectByPrimaryKey(id);
		if (model == null) {
			throw new BaseException(Code1200000.CODE_1200205);
		}
		model.setMobile(BaseContactUtils.decrypt(model.getMobile()));// 解密手机号码
		model.setEmail(BaseContactUtils.decrypt(model.getEmail()));// 解密手机号码
		CustomerDto dto = new CustomerDto();
		BeanUtils.copyProperties(model, dto);

		BaseUserCustomerExample example = new BaseUserCustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustomerIdEqualTo(id);
		BaseUserCustomer userCustomer = baseUserCustomerMapper.selectOne(example);
		if (userCustomer != null) {
			dto.setUserId(userCustomer.getUserId());
		}
		return Result.newSuccessResult(dto);
	}

	@Override
	public Result<List<BaseCustomer>> getByIds(String ids) throws BaseException {
		if (StringUtils.isBlank(ids)) {
			throw new BaseException(CodeConstant.CODE_1220047);
		}
		String idArr[] = ids.split(",");
		List<Long> idList = new ArrayList<>();
		for (int i = 0; i < idArr.length; i++) {
			idList.add(NumberUtils.toLong(idArr[i]));
		}
		BaseCustomerExample example = new BaseCustomerExample();
		example.createCriteria().andIdIn(idList);
		List<BaseCustomer> customers = baseCustomerMapper.selectByExample(example);
		if (customers != null && !customers.isEmpty()) {
			for (BaseCustomer customer : customers) {
				customer.setMobile(BaseContactUtils.decrypt(customer.getMobile()));// 解密手机号码
				customer.setEmail(BaseContactUtils.decrypt(customer.getEmail()));// 解密手机号码
			}
		}
		return Result.newSuccessResult(customers);

	}

	@Override
	public List<BaseCustomer> getByMobileOrNumber(String mobileOrNumber) throws BaseException {
		BaseCustomerExample example = new BaseCustomerExample();
		BaseCustomerExample.Criteria criteria = example.createCriteria();
		if (MobileUtil.veriyMobile(mobileOrNumber)) {
			try {
				criteria.andMobileEqualTo(DesUtils.encrypt(mobileOrNumber));
			} catch (Exception e) {
				log.error("手机号码加密出现异常，异常信息为：", e);
			}
		} else {
			criteria.andNumberEqualTo(mobileOrNumber);
		}
		List<BaseCustomer> customers = baseCustomerMapper.selectByExample(example);
		if (customers != null && !customers.isEmpty()) {
			for (BaseCustomer customer : customers) {
				customer.setMobile(BaseContactUtils.decrypt(customer.getMobile()));// 解密手机号码
				customer.setEmail(BaseContactUtils.decrypt(customer.getEmail()));
			}
		}
		return customers;

	}

	public Result<PaginationSupport<BaseCustomer>> getPage(CustomerReqDto customerReqDto, AbstractBasePageDto pageDto)
			throws Exception {
		BaseCustomerExample baseCustomerExample = new BaseCustomerExample()
				.setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
		BaseCustomerExample.Criteria criteria = baseCustomerExample.createCriteria();
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
		baseCustomerExample.setOrderByClause(orderByClause);
		List<BaseCustomer> list = baseCustomerMapper.selectByExample(baseCustomerExample);
		int totalCount = baseCustomerMapper.countByExample(baseCustomerExample);
		if (list != null && !list.isEmpty()) {
			for (BaseCustomer customer : list) {
				if (StringUtils.isNotBlank(customer.getMobile())) {
					customer.setMobile(BaseContactUtils.decrypt(customer.getMobile()));
					customer.setEmail(BaseContactUtils.decrypt(customer.getEmail()));
				}
			}
		}
		PaginationSupport<BaseCustomer> result = pageDto.getPaginationSupport();
		result.setDatas(list);
		result.setTotalCount(totalCount);
		return Result.newSuccessResult(result);
	}

	@Deprecated
	@Override
	public Result<PaginationSupport<MyCustomerPageResDto>> getMyCustomerPage(MyCustomerPageReqDto dto)
			throws BaseException {
		if (BooleanUtils.isNotEmpty(dto.getMobile()))
			dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));
		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
		paramMap.put("userId", super.getHeaderUserId().toString());
		if (StringUtils.isNotBlank(dto.getTagNames())) {
			String[] tags = dto.getTagNames().split(",");
			paramMap.put("tagNames", Arrays.asList(tags));
		}
		PaginationSupport<MyCustomerPageResDto> page = PaginationSupport.newDefault(paramMap);
		List<MyCustomerPageResDto> dtos = customerMapper.selectMyCustomerPage(paramMap);
		int count = customerMapper.selectMyCustomerPageCount(paramMap);
		this.setMyCustomerText(dtos);
		page.setTotalCount(count);
		page.setDatas(dtos);
		return Result.newSuccessResult(page);
	}

	@Override
	public Result<Boolean> validateMobile(String mobile, Long id) throws Exception {
		if (StringUtils.isNotBlank(mobile)) {
			// 去掉非数字
			mobile = mobile.replaceAll("[^0-9]", "");
		}
		if (!MobileUtil.veriyMobile(mobile)) {
			throw new BaseException(Code1230000.CODE_1230003);
		}
		// 判断手机号是否重复,考虑编辑的情况
		BaseCustomerExample example = new BaseCustomerExample();
		BaseCustomerExample.Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(DesUtils.encrypt(mobile));
		if (id != null) {
			criteria.andIdNotEqualTo(id);
		}
		List<BaseCustomer> customers = baseCustomerMapper.selectByExample(example);
		if (customers != null && !customers.isEmpty()) {
			throw new BaseException(GJLCodeConstant.CODE_1210043);
		}
		return Result.newSuccessResult(true);
	}

	@Override
	public void checkNotNullAndTerminal(Long id) throws BaseException {
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(id);
		if (customer == null)
			throw new BaseException(CodeConstant.CODE_1200084);
	}

	@Override
	public Result<List<CustomerSelectionResDto>> getMyCustomerSelections(CustomerSelectionReqDto dto)
			throws BaseException {
		if (BooleanUtils.isNotEmpty(dto.getName()))
			dto.setName(dto.getName().trim());
		Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
		paramMap.put("userId", super.getHeaderUserId());
		return Result.newSuccessResult(this.getCustomerSelections(paramMap));
	}

	@Override
	public Result<Long> updateStatus(CustomerUpdateStatusReqDto dto) throws BaseException {
		String logPrefix = "客户||更新状态||";
		log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));

		if (!CustomerStatusEnum.isValid(dto.getStatus()))
			throw new BaseException(CodeConstant.CODE_1220093);

		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(dto.getId());
		if (customer == null)
			throw new BaseException(CodeConstant.CODE_1200084);
		super.updateModel(customer);
		customer.setStatus(dto.getStatus());
		baseCustomerMapper.updateByPrimaryKeySelective(customer);

		if (CustomerStatusEnum.INVALID.getValue().equals(dto.getStatus()))
			setLeadsInvalid(dto.getId());

		log.info("%s完成", logPrefix);
		return Result.newSuccessResult(dto.getId());
	}

	@Override
	public Result<CustomerDetailLeadsChanceResCount> getLeadsChanceCount(LeadsForCustomerDetailReqDto dto,
			Integer permission) throws BaseException {
		CustomerDetailLeadsChanceResCount result = new CustomerDetailLeadsChanceResCount();
		result.setChanceCount(NumberEnum.ZERO.getValue());
		result.setLeadsCount(leadsService.getPageForCustomerDetailCount(dto, permission));
		return Result.newSuccessResult(result);
	}

	@Override
	public List<CustomerDistributionResDto> getAuditingDelcarationCustomerIds(List<Long> customerIds)
			throws BaseException {
		return customerMapper.selectAuditingDelcarationCustomerIds(customerIds);
	}

	@Override
	public List<CustomerDistributionResDto> getAuditingReservationCustomerIds(List<Long> customerIds)
			throws BaseException {
		return customerMapper.selectAuditingReservationCustomerIds(customerIds);
	}

	@Override
	public Result<Long> updateAssets(UpdateAssejtsDto updateAssejtsDto) throws BaseException {
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(updateAssejtsDto.getId());
		if (customer == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210022);
		}
		updateAssets(updateAssejtsDto.getAssets(), customer);
		// 跟新客户表的投资者类型
		customer.setUpdateDate(new Date());
		customer.setUpdateUserId(super.getHeaderUserId());
		customer.setType(updateAssejtsDto.getType());
		baseCustomerMapper.updateByPrimaryKeySelective(customer);
		return Result.newSuccessResult(updateAssejtsDto.getId());

	}

	@Override
	public Result<Long> updateCredentials(UpdateCredentialsDto credentialsDto) throws BaseException {
		BaseCustomer customer = baseCustomerMapper.selectByPrimaryKey(credentialsDto.getId());
		if (customer == null) {
			throw new BaseException(GJLCodeConstant.CODE_1210022);
		}
		updateCredentials(credentialsDto.getBack(), credentialsDto.getFront(), credentialsDto.getNumber(),
				credentialsDto.getType(), customer);
		return Result.newSuccessResult(customer.getId());
	}

	/**
	 * 设置客户的销售线索无效状态
	 *
	 * @param customerId
	 *            客户id
	 */
	private void setLeadsInvalid(Long customerId) {
		BaseLeadsExample leadsExample = new BaseLeadsExample();
		leadsExample.createCriteria().andCustomerIdEqualTo(customerId);
		List<BaseLeads> leadsList = baseLeadsMapper.selectByExample(leadsExample);
		if (BooleanUtils.isNotEmpty(leadsList)) {
			for (BaseLeads leads : leadsList) {
				super.updateModel(leads);
				leads.setIsOnceInvalid(YesOrNoEnum.YES.getValue());
				baseLeadsMapper.updateByPrimaryKeySelective(leads);
			}
		}
	}

	/**
	 * 获取客户下拉选项数据，默认10条
	 */
	private List<CustomerSelectionResDto> getCustomerSelections(Map<String, Object> paramMap) throws BaseException {
		List<CustomerSelectionResDto> customerList = customerMapper.selectCustomerSelection(paramMap);
		for (CustomerSelectionResDto customerSelectionResDto : customerList) {
			if (BooleanUtils.isNotEmpty(customerSelectionResDto.getMobile()))
				customerSelectionResDto.setMobile(BaseContactUtils.decrypt(customerSelectionResDto.getMobile()));
		}
		return customerList;
	}

	/**
	 * 设置文本值
	 */
	@Deprecated
	private void setMyCustomerText(List<MyCustomerPageResDto> dtos) throws BaseException {
		for (MyCustomerPageResDto dto : dtos) {
			dto.setSexText(SexEnum.getEnumName(dto.getSex()));
			dto.setLevelText(CustomerLevelEnum.getEnumName(dto.getLevel()));
			dto.setMobile(BaseContactUtils.decrypt(dto.getMobile()));
			dto.setIsDealText(dto.getDealDate() != null ? "是" : "否");
			if (BooleanUtils.isNotEmpty(dto.getProvinceCode()))
				dto.setProvinceText(regionService.toText(dto.getProvinceCode()));
			if (BooleanUtils.isNotEmpty(dto.getCityCode()))
				dto.setCityText(regionService.toText(dto.getCityCode()));
		}
	}

	@Override
	public Result<CustomerDetailResDto> getDetail(Long id) throws Exception {
		BaseCustomer model = baseCustomerMapper.selectByPrimaryKey(id);
		if (model == null) {
			throw new BaseException(CodeConstant.CODE_1200084);
		}
		BaseCustomerDetail detail = baseCustomerDetailMapper.selectByPrimaryKey(id);

		// 查询用户分配信息
		UserCustomerReqDto userCustomerReqDto = new UserCustomerReqDto();
		userCustomerReqDto.setCustomerId(model.getId());
		BaseUserCustomer userCustomer = userCustomerService.select(userCustomerReqDto);

		CustomerDetailResDto dto = new CustomerDetailResDto();

		if (userCustomer != null && userCustomer.getUserId() != null) {
			dto.setUserId(userCustomer.getUserId());// 设置理财师ID
			dto.setAfpName(userDetailService.getUserRealName(userCustomer.getUserId()));
		}
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setMobile(BaseContactUtils.decrypt(model.getMobile()));
		dto.setNumber(model.getNumber());
		dto.setStatus(model.getStatus());
		dto.setStatusText(CustomerStatusEnum.getEnumName(model.getStatus()));

		// 查询当前用户是否已关注该客户
		UserCustomerFocusReqDto focusReqDto = new UserCustomerFocusReqDto();
		focusReqDto.setUserId(this.getHeaderUserId());
		focusReqDto.setCustomerId(id);
		List<BaseUserCustomerFocus> focus = userCustomerFocus.select(focusReqDto);
		if (focus != null && !focus.isEmpty()) {
			dto.setFocus(true);
		}

		// 查询客户标签
		List<BaseTag> tags = tagMapper.selectByCustomerId(String.valueOf(id), null);
		if (tags != null && !tags.isEmpty()) {
			dto.setTags(tags);
		}
		// 风险测评结果
		Long userAccountId = ccCustomerUserRelService.getUserIdByCustomerId(id);
		if (userAccountId != null) {
			Result<RiskEvaluationResDto> result = questionService.getRiskEvaluation(userAccountId);
			if (result.getSuccess() && result.getResult() != null) {
				RiskEvaluationResDto risk = result.getResult();
				dto.setRiskText(risk.getRiskText());
			}
		}

		// 查询客户证件
		CustomerCredentialsDto credential = customerCredentialsService.selectByCustomerId(id);
		// 查询客户附件
		List<CustomerAttachDto> attachDtos = customerAttachService.selectByCustomerId(id);

		// 查询客户银行卡信息
		Result<List<CustomerBankListDto>> bankResult = customerBankService.getByCustomerId(id);
		// 查询投资偏好
		Result<List<CustomerInvestTypeDto>> investTypeResult = customerInvestTypeService.getByCustomerId(id);

		// 客户联系方式
		CustomerContactDto contact = new CustomerContactDto();
		contact.setMobile(model.getMobile());
		contact.setEmail(model.getEmail());
		if (detail != null) {
			contact.setWechat(detail.getWechat());
			contact.setQq(detail.getQq());
		}
		BaseContactUtils.decrypt(contact);// 基础信息解密

		dto.setContact(new DataAndPermissionDto(contact));

		CustomerInfoDto info = new CustomerInfoDto();
		info.setName(model.getName());
		info.setLevel(model.getLevel());
		info.setLevelText(CustomerLevelEnum.getEnumName(model.getLevel()));
		info.setRemark(model.getRemark());
		info.setSex(model.getSex());
		info.setSexText(SexEnum.getEnumName(model.getSex()));
		info.setSource(model.getSource());
		info.setSourceText(CustomerSourceEnum.getEnumName(model.getSource()));
		info.setTags(tags);
		info.setCredential(credential);
		info.setAttachDtos(attachDtos);
		info.setRiskRating(model.getRiskRating());
		info.setRiskRatingText(CustomerRiskRatingEnum.getEnumName(model.getRiskRating()));
		info.setType(model.getType());
		info.setTypeText(CustomerTypeEnum.getEnumName(model.getType()));
		if (detail != null) {
			info.setBirthday(detail.getBirthday());
			info.setProvinceCode(detail.getProvinceCode());
			info.setCityCode(detail.getCityCode());
			info.setAddress(detail.getAddress());
			info.setTrade(detail.getTrade());
			info.setOrganization(detail.getOrganization());
			info.setPosition(detail.getPosition());
		}

		if (bankResult != null && bankResult.getResult() != null) {
			info.setBanks(bankResult.getResult());
		}
		if (investTypeResult != null && investTypeResult.getResult() != null) {
			info.setInvestTypes(investTypeResult.getResult());
		}
		dto.setInfo(new DataAndPermissionDto(info));

		return Result.newSuccessResult(dto);
	}

	public void doSetBelongType(Long customerId, Integer belongType) throws BaseException {
		if (customerId == null) {
			return;
		}
		BaseCustomer record = new BaseCustomer();
		record.setId(customerId);
		// 属于类型（0： 私人，1：公海）
		record.setBelongType(belongType);
		record.setUpdateDate(new Date());
		record.setUpdateUserId(this.getHeaderUserId());
		baseCustomerMapper.updateByPrimaryKeySelective(record);
	}
}