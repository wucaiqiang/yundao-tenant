package com.yundao.tenant.mapper.sale.reservation;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationReqDto;
import com.yundao.tenant.dto.customer.customer.CustomerSaleReservationResDto;
import com.yundao.tenant.dto.report.AfpReportDto;
import com.yundao.tenant.dto.report.ProductReportDto;
import com.yundao.tenant.dto.sale.reservation.BaseReservationDto;
import com.yundao.tenant.dto.sale.reservation.MyReservationListReqDto;
import com.yundao.tenant.dto.sale.reservation.MyReservationListResDto;
import com.yundao.tenant.dto.sale.reservation.ProductReservationAmountDto;
import com.yundao.tenant.dto.sale.reservation.ProductReservationDto;
import com.yundao.tenant.model.base.sale.BaseReservation;

public interface ReservationMapper {
	
	
	/**
	 * 通过预约id查询查询
	 * getProductReservationDtos:
	 * @author: 欧阳利
	 * @param reservationIds
	 * @return
	 * @description:
	 */
	List<ProductReservationDto> getProductReservationDtos(@Param("reservationIds") List<Long> reservationIds);
	

    /**
     * 查询我的预约
     *
     * @param reqDto
     * @return
     */
    List<MyReservationListResDto> getMyReservations(MyReservationListReqDto reqDto);
    /**
     * 业绩总额
     * selectReservationTotal:
     * @author: wucq
     * @return
     * @description:
     */
    Double selectReservationTotal(@Param("beginDate") Date beginDate,@Param("endDate") Date endDate);
    /**
     * 获取产品预约总额
     * selectTotalByProductIds:
     * @author: wucq
     * @param productIds
     * @return
     * @description:
     */
    List<ProductReportDto> selectTotalByProductIds(@Param("productIds") String productIds);
    /**
     * 获取产品预约总数
     * getNumByProductIds:
     * @author: wucq
     * @param productIds
     * @return
     * @description:
     */
    List<ProductReportDto> selectNumByProductIds(@Param("productIds") String productIds,@Param("userId") Long userId);
    /**
     * 理财师排名
     * selectReservationRank:
     * @author: wucq
     * @param beginDate
     * @param endDate
     * @return
     * @description:
     */
    List<AfpReportDto> selectReservationRank(@Param("beginDate") Date beginDate,@Param("endDate") Date endDate,@Param("limit") Integer limit);
    /**
     * 查询我的预约总数
     *
     * @param reqDto
     * @return
     */
    int getMyReservationCount(MyReservationListReqDto reqDto);

    /**
     * 查询预约详情
     *
     * @param id
     * @return
     */
    BaseReservationDto selectByPrimaryKey(@Param("id") Long id);
    
    /**
     * 通过产品id集合  查询审核通过的预约的产品id集合
     * @param productIds
     * @return
     */
    List<Long> selectPassReserProductIdsByProductIds(@Param("productIds") List<Long> productIds,@Param("userId") Long userId);
    
    
    /**
     * 重新提交
     * @param record
     * @return
     */
    int doAgainCommit(BaseReservation record);
    
    /**
     * 查询客户的预约的个数
     * @param reqDto
     * @return
     */
    int getCustomerReservationCount(CustomerSaleReservationReqDto reqDto);

    /**
     * 查询客户的预约列表
     * @param reqDto
     * @return
     */
    List<CustomerSaleReservationResDto> getCustomerReservations(CustomerSaleReservationReqDto reqDto);
    
    /**
     * 获取审核通过并没有作废的预约金额总数
     * getProductReservationAmountDtos:
     * @author: 欧阳利
     * @param productIds
     * @return
     * @description:
     */
    List<ProductReservationAmountDto> getProductReservationAmountDtos(@Param("productIds") List<Long> productIds);
    
}
