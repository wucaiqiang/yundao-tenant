package com.yundao.tenant.controller.customer.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.back.CustomerBackApplyReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListResDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineRejectReqDto;
import com.yundao.tenant.service.customer.back.CustomerBackExamineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 客户回退
 *
 * @author jan
 * @create 2017-08-10 PM3:35
 **/
@Controller
@RequestMapping("/customer/back")
@ResponseBody
@Api("客户回退")
public class CustomerBackExamineController {

    @Autowired
    private CustomerBackExamineService customerBackExamineService;

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ApiOperation(value = "申请回退")
    public Result<Boolean> apply(@Validated @ModelAttribute CustomerBackApplyReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerBackExamineService.doApply(dto);
    }
    

    /**
     * 分页查询回退客户审核列表
     * @param reqDto
     * @return
     * @throws BaseException
     */
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "申请回退")
    public Result<PaginationSupport<CustomerBackExamineListResDto>> gets(@ModelAttribute CustomerBackExamineListReqDto reqDto)throws BaseException{
    	return customerBackExamineService.gets(reqDto);
    }
    
    
    @RequestMapping(value = "/pass", method = RequestMethod.POST)
    @ApiOperation(value = "客户回退通过")
    public Result<Integer> pass(@RequestParam Long id) throws BaseException {
    	if(id == null){
    		return Result.newFailureResult(CodeConstant.CODE_1200095);
    	}
    	Result<Boolean> checkResult = customerBackExamineService.checkCustomerBackExaminIsApply(id);
    	if(!checkResult.getSuccess()){
    		return Result.newFailureResult(checkResult.getCode());
    	}
    	if(!checkResult.getResult()){
    		return Result.newFailureResult(CodeConstant.CODE_1200097, "只有审核中的回退申请才能审批通过", null);
    	}
    	
        return customerBackExamineService.doPass(id);
    }
    
    
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    @ApiOperation(value = "客户回退驳回")
    public Result<Integer> reject(@Validated @ModelAttribute CustomerBackExamineRejectReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        Result<Boolean> checkResult = customerBackExamineService.checkCustomerBackExaminIsApply(dto.getId());
    	if(!checkResult.getSuccess()){
    		return Result.newFailureResult(checkResult.getCode());
    	}
    	if(!checkResult.getResult()){
    		return Result.newFailureResult(CodeConstant.CODE_1200098, "只有审核中的回退申请才能审批驳回", null);
    	}
        return customerBackExamineService.doReject(dto);
    }
}
