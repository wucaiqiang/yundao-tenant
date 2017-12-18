package com.yundao.tenant.mapper.sale.reservation;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageResDto;

import java.util.List;
import java.util.Map;

/**
 * 预约审核
 *
 * @author jan
 * @create 2017-08-24 PM4:36
 **/
public interface ReservationAuditMapper {

    /**
     * 获取审核分页数据
     */
    List<ReservationAuditPageResDto> selectAuditPage(Map<String, Object> paramMap) throws BaseException;

    /**
     * 获取审核分页数据总条数
     */
    int selectAuditPageCount(Map<String, Object> paramMap) throws BaseException;
}
