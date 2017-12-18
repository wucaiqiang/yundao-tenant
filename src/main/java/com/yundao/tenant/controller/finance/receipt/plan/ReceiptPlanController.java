package com.yundao.tenant.controller.finance.receipt.plan;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.finance.receipt.plan.*;
import com.yundao.tenant.dto.product.supplier.ProductSupplierQuotationDetailDto;
import com.yundao.tenant.service.finance.receipt.plan.ReceiptPlanService;
import com.yundao.tenant.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 回款计划
 *
 * @author jan
 * @create 2017-10-12 12:25
 **/
@Api("回款计划")
@Controller
@RequestMapping("/receipt/plan/")
@ResponseBody
public class ReceiptPlanController {

    @Autowired
    private ReceiptPlanService receiptPlanService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加回款计划")
    public Result<ReceiptPlanAddResult> add(@Validated @ModelAttribute ReceiptPlanAddReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        if (dto.getAmount() != null && dto.getAmount() < 0)
            throw new BaseException(CodeConstant.CODE_1220123);
        return receiptPlanService.insert(dto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改回款计划")
    public Result<Long> update(@Validated @ModelAttribute ReceiptPlanUpdateReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        if (dto.getAmount() != null && dto.getAmount() < 0)
            throw new BaseException(CodeConstant.CODE_1220123);
        return receiptPlanService.update(dto);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "获取回款计划详情")
    public Result<ReceiptPlanDetailDto> get(@Validated @ModelAttribute ReceiptPlanDetailReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.get(dto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除回款计划")
    public Result<PermissionResultDto> delete(@Validated @ModelAttribute ReceiptPlanDelReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.delete(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取分页数据")
    public Result<PaginationSupport<ReceiptPlanPageResDto>> getPage(@ModelAttribute ReceiptPlanPageReqDto dto) throws BaseException {
        if (dto.getCreateDateEnd() != null)
            dto.setCreateDateEnd(DateUtil.toEndDate(dto.getCreateDateEnd()));
        return receiptPlanService.getPage(dto);
    }

    @RequestMapping(value = "/check_name_exist", method = RequestMethod.GET)
    @ApiOperation(value = "检查回款计划名称是否存在")
    public Result<Boolean> checkNameExist(@Validated @ModelAttribute ReceiptPlanCheckNameExist dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.checkNameExist(dto);
    }

    @RequestMapping(value = "/check_name_exist_for_update", method = RequestMethod.GET)
    @ApiOperation(value = "检查回款计划名称是否存在（更新操作使用）")
    public Result<Boolean> checkNameExistForUpdate(@Validated @ModelAttribute ReceiptPlanCheckNameExistForUpdate dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.checkNameExistForUpdate(dto);
    }

    @RequestMapping(value = "/detail/get_receipts", method = RequestMethod.GET)
    @ApiOperation(value = "获取回款记录列表,id:回款计划id")
    public Result<List<ReceiptPlanRecordListDto>> getReceiptRecord(@RequestParam Long id) throws BaseException {
        return receiptPlanService.getReceiptRecordList(id);
    }

    @RequestMapping(value = "/detail/get_declarations", method = RequestMethod.GET)
    @ApiOperation(value = "获取回款计划关联的报单列表,id:回款计划id")
    public Result<List<ReceiptPlanDeclarationDto>> getDeclarations(@RequestParam Long id) throws BaseException {
        return receiptPlanService.getDeclarationList(id);
    }

    @RequestMapping(value = "/add_declaration_rel", method = RequestMethod.POST)
    @ApiOperation(value = "添加关联报单")
    public Result<PermissionResultDto> addDeclarationRel(@Validated @ModelAttribute DeclarationRelAddReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.insertDeclarationRel(dto);
    }

    @RequestMapping(value = "/delete_declaration_rel", method = RequestMethod.POST)
    @ApiOperation(value = "移除关联报单")
    public Result<PermissionResultDto> deleteDeclarationRel(@Validated @ModelAttribute DeclarationRelDelReqDto dto,
                                                            BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.deleteDeclarationRel(dto);
    }

    @RequestMapping(value = "/detail/get_supplier", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品供应商")
    public Result<ProductSupplierQuotationDetailDto> getSupplier(@Validated @ModelAttribute ReceiptPlanIdDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return receiptPlanService.getSupplier(dto);
    }

}
