package com.yundao.tenant.service.finance.receipt;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.ReceiptRecordAddReqDto;
import com.yundao.tenant.dto.finance.receipt.ReceiptRecordDelReqDto;
import com.yundao.tenant.dto.finance.receipt.plan.ReceiptPlanRecordListDto;

import java.util.List;

/**
 * 回款记录服务接口
 *
 * @author jan
 * @create 2017-10-12 13:41
 **/
public interface ReceiptRecordService {

    /**
     * 插入
     */
    Result<Long> insert(ReceiptRecordAddReqDto dto) throws BaseException;

    /**
     * 获取回款计划的实际回款金额
     *
     * @param receiptPlanId 回款计划id
     */
    Double getActualReceiptAmount(Long receiptPlanId) throws BaseException;

    /**
     * 获取回款计划详情 - 回款记录列表
     *
     * @param receiptPlanId 回款计划id
     */
    List<ReceiptPlanRecordListDto> getReceiptRecordListForPlanDetail(Long receiptPlanId) throws BaseException;

    /**
     * 获取可以关联回款的报单
     *
     * @param productId 产品id
     */
    Result<List<DeclarationForReceiptResDto>> getCanReceiptDeclarations(Long productId) throws BaseException;

    /**
     * 删除
     */
    Result<PermissionResultDto> delete(ReceiptRecordDelReqDto dto) throws BaseException;
}
