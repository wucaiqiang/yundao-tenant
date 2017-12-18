
package com.yundao.tenant.controller.sale.refund;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.sale.refund.MyRefundListReqDto;
import com.yundao.tenant.dto.sale.refund.MyRefundListResDto;
import com.yundao.tenant.dto.sale.refund.RefundCancelReqDto;
import com.yundao.tenant.dto.sale.refund.RefundDeclarationCancelDto;
import com.yundao.tenant.dto.sale.refund.RefundResubmitReqDto;
import com.yundao.tenant.dto.workflow.task.RefundTaskDto;
import com.yundao.tenant.model.base.sale.BaseDeclarationRefund;
import com.yundao.tenant.service.sale.refund.RefundService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 我的退款 Reason: Date: 2017年10月16日 下午2:00:41
 * 
 * @author 欧阳利
 * @version
 */

@RestController
@RequestMapping(value = "/refund/")
@ResponseBody
@Api("我的退款")
public class RefundController {

	@Autowired
	private RefundService refundService;

	@RequestMapping(value = "get_my_refund_page", method = RequestMethod.GET)
	@ApiOperation(value = "我的退款列表")
	public Result<PaginationSupport<MyRefundListResDto>> getMyRefundPage(@ModelAttribute MyRefundListReqDto dto)
			throws Exception {
		HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
		dto.setUserId(user.getUserId());
		return refundService.getMyRefundPage(dto);
	}

	@RequestMapping(value = "resubmit", method = RequestMethod.POST)
	@ApiOperation(value = "根据退款ID进行重新提交")
	public Result<Long> resubmit(@Validated @ModelAttribute RefundResubmitReqDto dto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return refundService.doResubmit(dto);
	}

	@RequestMapping(value = "resubmit_by_declaration_id", method = RequestMethod.POST)
	@ApiOperation(value = "根据报单ID进行重新提交")
	public Result<Long> resubmitByDeclarationId(@RequestParam Long declarationId) throws Exception {
		return refundService.doResubmitByDeclarationId(declarationId);
	}

	@RequestMapping(value = "get_by_declaration_id", method = RequestMethod.GET)
	@ApiOperation(value = "根据报单ID查询报单退款记录信息")
	public Result<List<BaseDeclarationRefund>> getByDeclarationId(@RequestParam Long declarationId) throws Exception {
		return refundService.getByDeclarationId(declarationId);
	}

	@RequestMapping(value = "cancel_by_declaration_id", method = RequestMethod.POST)
	@ApiOperation(value = "取消申请")
	public Result<Long> cancelByDeclarationId(@Validated @ModelAttribute RefundDeclarationCancelDto dto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return refundService.doCancelByDeclarationId(dto);
	}
	
	@RequestMapping(value = "cancel", method = RequestMethod.POST)
	@ApiOperation(value = "取消申请")
	public Result<Long> cancel(@Validated  RefundCancelReqDto dto, BindingResult bindingResult)
			throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		return refundService.doCancel(dto);
	}

	@RequestMapping(value = "get_task", method = RequestMethod.GET)
	@ApiOperation(value = "获取退款的任务信息")
	public Result<RefundTaskDto> getTaskDto(@RequestParam Long id) throws BaseException {
		return refundService.getTaskDto(id);
	}

}
