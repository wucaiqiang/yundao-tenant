package com.yundao.tenant.controller.customer.customer;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.RequestUtils;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.customer.CustomerContactReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDetailLeadsChanceResCount;
import com.yundao.tenant.dto.customer.customer.CustomerDetailResDto;
import com.yundao.tenant.dto.customer.customer.CustomerDto;
import com.yundao.tenant.dto.customer.customer.CustomerExclusiveContactReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSelectionReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSelectionResDto;
import com.yundao.tenant.dto.customer.customer.CustomerUpdateStatusReqDto;
import com.yundao.tenant.dto.customer.customer.MyCustomerPageReqDto;
import com.yundao.tenant.dto.customer.customer.MyCustomerPageResDto;
import com.yundao.tenant.dto.customer.customerAssets.UpdateAssejtsDto;
import com.yundao.tenant.dto.customer.customerAssets.UpdateCredentialsDto;
import com.yundao.tenant.dto.customer.v2.CustomerV2PageReqDto;
import com.yundao.tenant.dto.customer.v2.CustomerV2PageResDto;
import com.yundao.tenant.dto.sale.leads.LeadsForCustomerDetailReqDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseUserCustomer;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/customer/")
@ResponseBody
@Api("客户表")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserCustomerService userCustomerService;

	@RequestMapping(value = "/v2/get_page_public", method = RequestMethod.GET)
	@ApiOperation(value = "获取“我的客户”数据 - 只获取所有的客户数据")
	public Result<PaginationSupport<CustomerV2PageResDto>> getPagePublic(@ModelAttribute CustomerV2PageReqDto dto)
			throws BaseException {
		this.convertEndDate(dto);
		return customerService.getPageV2(dto, DataObjectPermissionEnum.PUBLIC.getValue());
	}

	@RequestMapping(value = "/v2/get_page_department", method = RequestMethod.GET)
	@ApiOperation(value = "获取“我的客户”数据 - 只获取部门的客户数据")
	public Result<PaginationSupport<CustomerV2PageResDto>> getPageDepartment(@ModelAttribute CustomerV2PageReqDto dto)
			throws BaseException {
		this.convertEndDate(dto);
		return customerService.getPageV2(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
	}

	@RequestMapping(value = "/v2/get_page_personal", method = RequestMethod.GET)
	@ApiOperation(value = "获取“我的客户”数据 - 只获取自己的客户数据")
	public Result<PaginationSupport<CustomerV2PageResDto>> getPagePersonal(@ModelAttribute CustomerV2PageReqDto dto)
			throws BaseException {
		this.convertEndDate(dto);
		return customerService.getPageV2(dto, DataObjectPermissionEnum.PERSONAL.getValue());
	}

	private void convertEndDate(@ModelAttribute CustomerV2PageReqDto dto) {
		if (BooleanUtils.isNotBlank(dto.getDealDateEnd()))
			dto.setDealDateEnd(DateUtil.toEndDate(dto.getDealDateEnd()));
		if (BooleanUtils.isNotBlank(dto.getFollowDateEnd()))
			dto.setFollowDateEnd(DateUtil.toEndDate(dto.getFollowDateEnd()));
		if (BooleanUtils.isNotBlank(dto.getDistributionDateEnd()))
			dto.setDistributionDateEnd(DateUtil.toEndDate(dto.getDistributionDateEnd()));
		if (BooleanUtils.isNotBlank(dto.getCreateDateEnd()))
			dto.setCreateDateEnd(DateUtil.toEndDate(dto.getCreateDateEnd()));
	}

	@RequestMapping(value = "get_userid_by_customerid", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户的理财师id")
	public Result<Long> getUserIdByCustomerId(@RequestParam Long customerId) throws BaseException {
		return Result.newSuccessResult(userCustomerService.getUserIdByCustomer(customerId));
	}

	@RequestMapping(value = "get_by_mobile_or_number", method = RequestMethod.GET)
	@ApiOperation(value = "根据客户手机号码或客户编号获取客户信息")
	public Result<List<BaseCustomer>> getByMobileOrNumber(@RequestParam String mobileOrNumber) throws BaseException {
		return Result.newSuccessResult(customerService.getByMobileOrNumber(mobileOrNumber));
	}

	@Deprecated
	@RequestMapping(value = "get_my_page", method = RequestMethod.GET)
	@ApiOperation(value = "获取“我的客户”数据 - 只获取自己的客户数据")
	public Result<PaginationSupport<MyCustomerPageResDto>> getMyPage(@ModelAttribute MyCustomerPageReqDto dto)
			throws BaseException {
		return customerService.getMyCustomerPage(dto);
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "新增客户表", notes = "根据客户对象创建客户表和客户详情")
	public Result<Long> add(@Validated(Insert.class) @ModelAttribute CustomerReqDto reqDto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.add(reqDto);
	}

	@RequestMapping(value = "v2/add", method = RequestMethod.POST)
	@ApiOperation(value = "新增客户表 V2版本", notes = "根据客户对象创建客户表和客户详情")
	public Result<Long> addV2(@Validated(Insert.class) @ModelAttribute CustomerReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.add(reqDto);
	}

	@RequestMapping(value = "/add_from_book", method = RequestMethod.POST)
	@ApiOperation(value = "通讯录导入", notes = "通讯录导入")
	public Result<PermissionResultDto> addFromBook(@RequestParam String customerList) throws Exception {
		return customerService.addFromBook(customerList);
	}
	
	
	@RequestMapping(value = "validate_mobile", method = RequestMethod.GET)
	@ApiOperation(value = "验证客户手机号是否可用", notes = "验证客户手机号是否可用")
	public Result<Boolean> validateMobile(@RequestParam String mobile, @RequestParam(required = false) Long id)
			throws Exception {
		return customerService.validateMobile(mobile, id);
	}

	@RequestMapping(value = "/app/update", method = RequestMethod.POST)
	@ApiOperation(value = "app编辑客户表信息")
	public Result<Boolean> updateForApp(HttpServletRequest request) throws Exception {
		Map<String, String> params = RequestUtils.getParameterMap(request);
		return customerService.updateForApp(params);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "编辑客户表信息")
	public Result<Integer> update(@Validated(value = { Update.class }) @ModelAttribute CustomerReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.update(reqDto);
	}

	@RequestMapping(value = "update_info", method = RequestMethod.POST)
	@ApiOperation(value = "编辑客户表信息")
	public Result<Integer> updateInfo(
			@Validated(value = { Update.class }) @ModelAttribute CustomerExclusiveContactReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.updateInfo(reqDto);
	}

	@RequestMapping(value = "update_contact", method = RequestMethod.POST)
	@ApiOperation(value = "编辑客户表信息")
	public Result<Integer> updateContact(
			@Validated(value = { Update.class }) @ModelAttribute CustomerContactReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.updateContact(reqDto);
	}

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户表详细信息")
	public Result<CustomerDto> get(@RequestParam Long id) throws Exception {
		return customerService.get(id);
	}

	@RequestMapping(value = "get_detail", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户表详细信息")
	public Result<CustomerDetailResDto> getDetail(@RequestParam Long id) throws Exception {
		return customerService.getDetail(id);
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ApiOperation(value = "删除客户表信息")
	public Result<Integer> delete(@RequestParam Long id) throws Exception {
		return customerService.delete(id);
	}

	@RequestMapping(value = "/get_my_selections", method = RequestMethod.GET)
	@ApiOperation(value = "获取我的客户下拉选项")
	public Result<List<CustomerSelectionResDto>> getMyCustomerSelections(@ModelAttribute CustomerSelectionReqDto dto)
			throws Exception {
		return customerService.getMyCustomerSelections(dto);
	}

	@RequestMapping(value = "/get_user_customer", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户所属信息")
	public Result<BaseUserCustomer> getMyCustomerSelections(Long customerId) throws Exception {
		return Result.newSuccessResult(userCustomerService.getByCustomerId(customerId));
	}

	@RequestMapping(value = "/update_status", method = RequestMethod.POST)
	@ApiOperation(value = "客户有效性处理")
	public Result<Long> updateStatus(@Validated @ModelAttribute CustomerUpdateStatusReqDto dto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.updateStatus(dto);
	}

	@RequestMapping(value = "/detail/get_leads_chance_count_personal", method = RequestMethod.GET)
	@ApiOperation("获取客户详情页面线索机会条数")
	public Result<CustomerDetailLeadsChanceResCount> getPageForCustomerDetailCountPersonal(
			@Validated @ModelAttribute LeadsForCustomerDetailReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.getLeadsChanceCount(dto, DataObjectPermissionEnum.PERSONAL.getValue());
	}

	@RequestMapping(value = "/detail/get_leads_chance_count_department", method = RequestMethod.GET)
	@ApiOperation("获取客户详情页面线索机会条数")
	public Result<CustomerDetailLeadsChanceResCount> getPageForCustomerDetailCountDepartment(
			@Validated @ModelAttribute LeadsForCustomerDetailReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.getLeadsChanceCount(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
	}

	@RequestMapping(value = "/detail/get_leads_chance_count_public", method = RequestMethod.GET)
	@ApiOperation("获取客户详情页面线索机会条数")
	public Result<CustomerDetailLeadsChanceResCount> getPageForCustomerDetailCountPublic(
			@Validated @ModelAttribute LeadsForCustomerDetailReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.getLeadsChanceCount(dto, DataObjectPermissionEnum.PUBLIC.getValue());
	}

	@RequestMapping(value = "update_assets", method = RequestMethod.POST)
	@ApiOperation("修改客户资产证明")
	public Result<Long> updateAssets(@Validated @ModelAttribute UpdateAssejtsDto updateAssejtsDto,
			BindingResult bindingResult) throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.updateAssets(updateAssejtsDto);
	}

	@RequestMapping(value = "update_credentials", method = RequestMethod.POST)
	@ApiOperation("修改客户证件")
	public Result<Long> updateCredentials(@Validated @ModelAttribute UpdateCredentialsDto credentialsDto,
			BindingResult bindingResult) throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		return customerService.updateCredentials(credentialsDto);
	}
}
