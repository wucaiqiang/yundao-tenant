package com.yundao.tenant.service.sale.reservation;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageReqDto;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditPageResDto;
import com.yundao.tenant.dto.sale.reservation.audit.ReservationAuditReqDto;

/**
 * 预约审核服务接口
 *
 * @author jan
 * @create 2017-08-24 PM3:13
 **/
public interface ReservationAuditService {

    /**
     * 预约审核分页数据
     */
    Result<PaginationSupport<ReservationAuditPageResDto>> getPage(ReservationAuditPageReqDto dto) throws
            BaseException;

    /**
     * 更新状态
     */
    Result<Boolean> doAudit(ReservationAuditReqDto dto) throws BaseException;

}
