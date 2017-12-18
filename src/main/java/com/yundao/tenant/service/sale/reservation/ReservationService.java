package com.yundao.tenant.service.sale.reservation;

import java.util.Date;
import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationResDto;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.sale.reservation.BaseReservationDto;
import com.yundao.tenant.dto.sale.reservation.MyReservationListReqDto;
import com.yundao.tenant.dto.sale.reservation.MyReservationListResDto;
import com.yundao.tenant.dto.sale.reservation.ReservationAddReqDto;
import com.yundao.tenant.dto.sale.reservation.ReservationCancelReqDto;
import com.yundao.tenant.dto.sale.reservation.ReservationDetailDto;
import com.yundao.tenant.dto.sale.reservation.ReservationDiscardReqDto;
import com.yundao.tenant.dto.sale.reservation.ReservationUpdateReqDto;
import com.yundao.tenant.model.base.sale.BaseReservation;
import com.yundao.tenant.model.base.sale.BaseReservationDiscard;

/**
 * 预约服务接口
 *
 * @author jan
 * @create 2017-08-23 PM6:38
 **/
public interface ReservationService {

	/**
	 * 查询有预约的产品id集合
	 * 
	 * @param productIds
	 * @return
	 * @throws BaseException
	 */
	List<Long> getHasReservationProductIds(String productIds) throws BaseException;

	/**
	 * 添加预约
	 */
	Result<Long> insert(ReservationAddReqDto dto) throws BaseException;

	/**
	 * 检查是否能编辑预约
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	Result<Boolean> checkIsCanUpdate(Long id) throws BaseException;

	/**
	 * 检查是否能取消
	 */
	public Result<Boolean> checkIsCancel(Long id) throws BaseException;

	/**
	 * 检查是否能重新提交
	 *
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	Result<Boolean> checkIsAgainCommit(Long id) throws BaseException;

	/**
	 * 重新提交预约
	 */
	Result<Long> doAgainCommit(Long id) throws BaseException;

	/**
	 * 取消预约
	 */
	Result<Long> doCancel(ReservationCancelReqDto dto) throws BaseException;

	/**
	 * 预约作废
	 * 
	 * @param dto
	 * @return
	 * @throws BaseException
	 */
	Result<Long> doDiscard(ReservationDiscardReqDto dto) throws BaseException;

	/**
	 * 修改预约
	 */
	Result<Long> update(ReservationUpdateReqDto dto) throws BaseException;

	/**
	 * 修改预约forApp
	 */
	Result<Long> updateForApp(ReservationUpdateReqDto dto) throws BaseException;

	/**
	 * 我的预约列表
	 */
	Result<PaginationSupport<MyReservationListResDto>> getMyReservations(MyReservationListReqDto reqDto)
			throws BaseException;

	Result<List<MyReservationListResDto>> getsByProductId(Long productId, String[] statuses,
			Integer isRemoveDeclaratoin) throws BaseException;

	/**
	 * 查询单个预约详情
	 */
	BaseReservationDto getBaseReservationDto(Long id) throws BaseException;

	ReservationDetailDto getBaseReservationDetailDto(Long id) throws BaseException;

	/**
	 * 查询单个预约详情
	 */
	BaseReservation getBaseReservation(Long id) throws BaseException;

	/**
	 * 获取客户详情--> 销售信息--> 预约列表
	 */
	public Result<PaginationSupport<CustomerSaleReservationResDto>> getCustomerReservations(
			CustomerSaleReservationReqDto reqDto) throws BaseException;

	/**
	 * 获取客户详情--> 销售信息--> 预约列表 总个数
	 */
	public Integer getCustomerReservationCount(Long customerId) throws BaseException;

	/**
	 * 获取作废信息
	 * 
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	public BaseReservationDiscard getDiscard(Long id) throws BaseException;

	/**
	 * 预约总额 getReservationTotal:
	 * 
	 * @author: wucq
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Double> getReservationTotal(Date beginDate, Date endDate) throws BaseException;

	public List<ProductReportDto> getTotalByProductIds(String productIds) throws BaseException;

	public List<ProductReportDto> getNumByProductIds(String productIds) throws BaseException;

	public Result<List<AfpReportDto>> getReservationRank(Date beginDate, Date endDate, Integer limit)
			throws BaseException;
}
