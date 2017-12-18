package com.yundao.tenant.service.finance.receipt.plan;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.finance.receipt.plan.*;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;

import java.util.List;

/**
 * 回款计划服务接口
 *
 * @author jan
 * @create 2017-10-12 13:43
 **/
public interface ReceiptPlanService {

    /**
     * 通过报单ID，获取对应的回款计划的计划总金额和实际回款金额
     */
    Result<ReceiptPlanAmountResDto> getAmount(Long declarationId) throws BaseException;

    /**
     * 插入
     */
    Result<ReceiptPlanAddResult> insert(ReceiptPlanAddReqDto dto) throws BaseException;

    /**
     * 更新
     */
    Result<Long> update(ReceiptPlanUpdateReqDto dto) throws BaseException;

    /**
     * 获取回款计划详情
     */
    Result<ReceiptPlanDetailDto> get(ReceiptPlanDetailReqDto dto) throws BaseException;

    /**
     * 获取分页数据
     */
    Result<PaginationSupport<ReceiptPlanPageResDto>> getPage(ReceiptPlanPageReqDto dto) throws BaseException;

    /**
     * 获取回款记录列表
     *
     * @param id 回款计划id
     */
    Result<List<ReceiptPlanRecordListDto>> getReceiptRecordList(Long id) throws BaseException;

    /**
     * 获取关联报单
     *
     * @param id 回款计划id
     */
    Result<List<ReceiptPlanDeclarationDto>> getDeclarationList(Long id) throws BaseException;

    /**
     * 检查计划名称是否已存在
     */
    Result<Boolean> checkNameExist(ReceiptPlanCheckNameExist dto) throws BaseException;

    /**
     * 检查计划名称是否已存在
     */
    Result<Boolean> checkNameExistForUpdate(ReceiptPlanCheckNameExistForUpdate dto) throws BaseException;

    /**
     * 删除
     */
    Result<PermissionResultDto> delete(ReceiptPlanDelReqDto dto) throws BaseException;

    /**
     * 添加与报单的关联关系
     */
    Result<PermissionResultDto> insertDeclarationRel(DeclarationRelAddReqDto dto) throws BaseException;

    /**
     * 移除关联报单
     */
    Result<PermissionResultDto> deleteDeclarationRel(DeclarationRelDelReqDto dto) throws BaseException;

    /**
     * 获取回款计划关联的产品供应商
     */
    Result<ProductSupplierQuotationDetailDto> getSupplier(ReceiptPlanIdDto dto) throws BaseException;
}
