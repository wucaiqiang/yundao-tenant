package com.yundao.tenant.service.customer.customer;

import java.util.List;
import java.util.Map;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.customer.customer.CustomerContactReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerDetailLeadsChanceResCount;
import com.yundao.tenant.dto.customer.customer.CustomerDetailResDto;
import com.yundao.tenant.dto.customer.customer.CustomerDistributionResDto;
import com.yundao.tenant.dto.customer.customer.CustomerDto;
import com.yundao.tenant.dto.customer.customer.CustomerExclusiveContactReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerScaningAddReqDto;
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
import com.yundao.tenant.model.base.customer.BaseCustomer;

public interface CustomerService {

	public Result<Long> add(CustomerReqDto reqDto) throws Exception;

	public Result<PermissionResultDto> addFromBook(String customerList) throws Exception;

	public Result<Long> addForAppScaning(CustomerScaningAddReqDto reqDto) throws Exception;

	/**
	 * 客户页面 获取分页数据
	 */
	Result<PaginationSupport<CustomerV2PageResDto>> getPageV2(CustomerV2PageReqDto dto, Integer permission)
			throws BaseException;

	public Result<Integer> update(CustomerReqDto reqDto) throws Exception;

	/**
	 * app修改客户信息 updateForApp:
	 *
	 * @param params
	 * @return
	 * @throws Exception
	 * @author: wucq
	 * @description:
	 */
	public Result<Boolean> updateForApp(Map<String, String> params) throws Exception;

	/**
	 * 修改除了联系信息之外的其它信息 updateInfo:
	 *
	 * @param reqDto
	 * @return
	 * @throws Exception
	 * @author: wucq
	 * @description:
	 */
	public Result<Integer> updateInfo(CustomerExclusiveContactReqDto reqDto) throws Exception;

	/**
	 * 修改联系信息 updateContact:
	 *
	 * @param reqDto
	 * @return
	 * @throws Exception
	 * @author: wucq
	 * @description:
	 */
	public Result<Integer> updateContact(CustomerContactReqDto reqDto) throws Exception;

	public Result<Integer> delete(Long id) throws Exception;

	public Result<CustomerDto> get(Long id) throws BaseException;

	public Result<List<BaseCustomer>> getByIds(String ids) throws BaseException;

	/**
	 * 根据客户手机号或客户编号查询客户信息 getByMobileOrNumber:
	 *
	 * @param mobileOrNumber
	 * @return
	 * @throws BaseException
	 * @author: wucq
	 * @description:
	 */
	List<BaseCustomer> getByMobileOrNumber(String mobileOrNumber) throws BaseException;

	/**
	 * 检查客户是否存在 exist:
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	public Result<Boolean> exist(Long id) throws BaseException;

	public Result<CustomerDetailResDto> getDetail(Long id) throws Exception;

	/**
	 * 获取我的客户分页数据
	 *
	 * @param dto
	 *            查询参数
	 */
	@Deprecated
	Result<PaginationSupport<MyCustomerPageResDto>> getMyCustomerPage(MyCustomerPageReqDto dto) throws BaseException;

	/**
	 * 验证手机号是否存在
	 *
	 * @param mobile
	 * @return
	 */
	Result<Boolean> validateMobile(String mobile, Long id) throws Exception;

	/**
	 * 检查是否存在，如果不存在直接返回
	 *
	 * @param id
	 *            客户id
	 */
	void checkNotNullAndTerminal(Long id) throws BaseException;

	/**
	 * 获取我的客户下拉选项，只获取10条
	 */
	Result<List<CustomerSelectionResDto>> getMyCustomerSelections(CustomerSelectionReqDto dto) throws BaseException;

	/**
	 * 更新客户状态
	 */
	Result<Long> updateStatus(CustomerUpdateStatusReqDto dto) throws BaseException;

	/**
	 * 获取客户详情页面 线索机会条数
	 */
	Result<CustomerDetailLeadsChanceResCount> getLeadsChanceCount(LeadsForCustomerDetailReqDto dto, Integer permission)
			throws BaseException;

	/**
	 * 筛选有正在审批报单的客户
	 *
	 * @param customerIds
	 *            客户id
	 */
	List<CustomerDistributionResDto> getAuditingDelcarationCustomerIds(List<Long> customerIds) throws BaseException;

	/**
	 * 筛选有正在审批额度预约的客户
	 *
	 * @param customerIds
	 *            客户id
	 */
	List<CustomerDistributionResDto> getAuditingReservationCustomerIds(List<Long> customerIds) throws BaseException;

	/**
	 * 修改客户证件
	 *
	 * @param updateAssejtsDto
	 * @return
	 */
	Result<Long> updateAssets(UpdateAssejtsDto updateAssejtsDto) throws BaseException;

	/**
	 * 修改证件
	 *
	 * @param credentialsDto
	 * @return
	 */
	Result<Long> updateCredentials(UpdateCredentialsDto credentialsDto) throws BaseException;

	/**
	 * 设置客户属于类型 doSetBelongType:
	 *
	 * @param customerId
	 * @param belongType
	 * @throws BaseException
	 * @author: 欧阳利
	 * @description:
	 */
	public void doSetBelongType(Long customerId, Integer belongType) throws BaseException;
}
