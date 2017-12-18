package com.yundao.tenant.controller.finance.receipt;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.finance.receipt.DeclarationForReceiptResDto;
import com.yundao.tenant.dto.finance.receipt.ReceiptRecordAddReqDto;
import com.yundao.tenant.dto.finance.receipt.ReceiptRecordDelReqDto;
import com.yundao.tenant.service.finance.receipt.ReceiptRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 回款
 *
 * @author jan
 * @create 2017-10-12 12:24
 **/
@Api("回款记录")
@Controller
@ResponseBody
@RequestMapping("/receipt/record/")
public class ReceiptRecordController {

    @Autowired
    private ReceiptRecordService receiptRecordService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增回款记录")
    public Result<Long> add(@Validated @ModelAttribute ReceiptRecordAddReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return receiptRecordService.insert(dto);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除回款记录")
    public Result<PermissionResultDto> add(@Validated @ModelAttribute ReceiptRecordDelReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return receiptRecordService.delete(dto);
    }

    @RequestMapping(value = "get_can_receipt_declarations", method = RequestMethod.GET)
    @ApiOperation(value = "获取可以回款的报单数据")
    public Result<List<DeclarationForReceiptResDto>> getCanReceiptDeclarations(@RequestParam Long productId) throws BaseException {
        return receiptRecordService.getCanReceiptDeclarations(productId);
    }

}
