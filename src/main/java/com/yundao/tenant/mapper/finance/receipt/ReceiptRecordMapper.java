package com.yundao.tenant.mapper.finance.receipt;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanRecordListDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiptRecordMapper {

    /**
     * 获取回款计划的实际回款金额
     *
     * @param receiptPlanId 回款计划id
     */
    Double selectActualReceiptAmount(@Param("receiptPlanId") Long receiptPlanId) throws BaseException;

    /**
     * 获取回款计划详情 - 回款记录列表
     *
     * @param receiptPlanId 回款计划id
     */
    List<ReceiptPlanRecordListDto> selectForReceiptPlan(@Param("receiptPlanId") Long receiptPlanId) throws BaseException;

}
