package com.yundao.tenant.controller.sale.reservation;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.sale.declaration.DeclarationReqDto;
import com.yundao.tenant.dto.sale.reservation.BaseReservationDto;
import com.yundao.tenant.dto.sale.reservation.MyReservationListReqDto;
import com.yundao.tenant.dto.sale.reservation.MyReservationListResDto;
import com.yundao.tenant.dto.sale.reservation.ReservationAddReqDto;
import com.yundao.tenant.dto.sale.reservation.ReservationAuditRecordResDto;
import com.yundao.tenant.dto.sale.reservation.ReservationCancelReqDto;
import com.yundao.tenant.dto.sale.reservation.ReservationDetailDto;
import com.yundao.tenant.dto.sale.reservation.ReservationDiscardReqDto;
import com.yundao.tenant.dto.sale.reservation.ReservationUpdateReqDto;
import com.yundao.tenant.dto.sale.reservation.SubmitDeclarationReqDto;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.enums.sale.reservation.ReservationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.model.base.sale.BaseReservation;
import com.yundao.tenant.model.base.sale.BaseReservationDiscard;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.service.sale.reservation.ReservationService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.workflow.WorkflowServie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 预约
 *
 * @author jan
 * @create 2017-08-23 PM6:18
 **/
@Controller
@RequestMapping("/reservation")
@ResponseBody
@Api("预约")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private WorkflowServie workflowServie;

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private DeclarationService declarationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ApiOperation("添加预约")
	public Result<Long> add(@Validated @ModelAttribute ReservationAddReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);
		if (BooleanUtils.isNotEmpty(dto.getRemark()) && dto.getRemark().length() > 200)
			throw new BaseException(CodeConstant.CODE_1220052);
		if (dto.getReservationAmount() == 0)
			throw new BaseException(CodeConstant.CODE_1220076);
		return reservationService.insert(dto);
	}

	@RequestMapping(value = "/submit_declaration", method = RequestMethod.POST)
	@ApiOperation(value = "提交报单(欧阳利)")
	public Result<Long> submitDeclaration(@Validated @ModelAttribute SubmitDeclarationReqDto reqDto,
			BindingResult bindingResult) throws Exception {
		BindingResultHandler.handleByException(bindingResult);
		DeclarationReqDto declarationReqDto = new DeclarationReqDto();
		BeanUtils.copyProperties(reqDto, declarationReqDto);
		return declarationService.doSubmitDeclaration(declarationReqDto);
	}

	@RequestMapping(value = "/gets/my", method = RequestMethod.GET)
	@ApiOperation(value = "获取我的预约列表")
	public Result<PaginationSupport<MyReservationListResDto>> getMyReservations(
			@ModelAttribute MyReservationListReqDto reqDto) throws BaseException {
		return reservationService.getMyReservations(reqDto);
	}

	@RequestMapping(value = "/gets_by_product_id", method = RequestMethod.GET)
	@ApiOperation(value = "获取我的预约列表(已通过且没有报单的预约)")
	public Result<List<MyReservationListResDto>> getsByProductId(@RequestParam Long productId) throws BaseException {
		String[] statusList = { String.valueOf(ReservationStatusEnum.PASS.getValue()) };
		return reservationService.getsByProductId(productId, statusList, 1);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ApiOperation("编辑预约")
	public Result<Long> update(@Validated @ModelAttribute ReservationUpdateReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);

		// 检查是否能编辑
		Result<Boolean> result = reservationService.checkIsCanUpdate(dto.getId());
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		if (!result.getResult()) {
			return Result.newFailureResult(CodeConstant.CODE_1200103);
		}
		return reservationService.update(dto);
	}

	@RequestMapping(value = "/update/app", method = RequestMethod.POST)
	@ApiOperation("编辑预约forApp")
	public Result<Long> updateForApp(ReservationUpdateReqDto dto) throws BaseException {
		if (dto == null || dto.getId() == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		// 检查是否能编辑
		Result<Boolean> result = reservationService.checkIsCanUpdate(dto.getId());
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		if (!result.getResult()) {
			return Result.newFailureResult(CodeConstant.CODE_1200103);
		}
		return reservationService.update(dto);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ApiOperation("查询单个预约详情")
	public Result<BaseReservationDto> get(@RequestParam Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		BaseReservationDto dto = reservationService.getBaseReservationDto(id);
		return Result.newSuccessResult(dto);
	}

	@RequestMapping(value = "/app/get_detail", method = RequestMethod.GET)
	@ApiOperation("查询单个预约详情")
	public Result<ReservationDetailDto> getDetail(@RequestParam Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		ReservationDetailDto dto = reservationService.getBaseReservationDetailDto(id);

		return Result.newSuccessResult(dto);
	}

	@RequestMapping(value = "/again_commit", method = RequestMethod.POST)
	@ApiOperation("重新提交")
	public Result<Long> againCommit(@RequestParam Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		// 检查是否能重新提交
		Result<Boolean> result = reservationService.checkIsAgainCommit(id);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		if (!result.getResult()) {
			return Result.newFailureResult(CodeConstant.CODE_1200105);
		}
		return reservationService.doAgainCommit(id);
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ApiOperation("取消")
	public Result<Long> cancel(@Validated @ModelAttribute ReservationCancelReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);

		Result<Boolean> result = reservationService.checkIsCancel(dto.getId());
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		if (!result.getResult()) {
			return Result.newFailureResult(CodeConstant.CODE_1200117);
		}
		return reservationService.doCancel(dto);
	}

	/**
	 * 作废
	 *
	 * @param dto
	 * @param bindingResult
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/discard", method = RequestMethod.POST)
	@ApiOperation("作废")
	public Result<Long> discard(@Validated @ModelAttribute ReservationDiscardReqDto dto, BindingResult bindingResult)
			throws BaseException {
		BindingResultHandler.handleByException(bindingResult);

		if (declarationService.hasDeclaration(dto.getId())) {
			return Result.newFailureResult(CodeConstant.CODE_1200102, "该预约已经报单,不能作废！", null);
		}

		return reservationService.doDiscard(dto);
	}

	/**
	 * 查询审核列表
	 * 
	 * @param id
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = "/gets_audit_record", method = RequestMethod.GET)
	@ApiOperation("查询审核列表")
	public Result<ReservationAuditRecordResDto> getWorkflowList(@RequestParam Long id) throws BaseException {
		if (id == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200102);
		}
		BaseReservation base = reservationService.getBaseReservation(id);
		if (base == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200104);
		}
		ReservationAuditRecordResDto auditRecordDto = new ReservationAuditRecordResDto();
		List<AuditDetailResDTO> list = workflowServie.getWorkflowList(id, BusinessTypeCode.RESERVATION);
		if (!BooleanUtils.isEmpty(list)) {
			for (AuditDetailResDTO dto : list) {
				dto.setActionText(WorkflowActionEnum.getName(dto.getActionValue()));
				dto.setActionUserName(userDetailService.getUserRealName(dto.getActionUserId()));

			}
		}

		auditRecordDto.setHasDeclaration(declarationService.hasDeclaration(id));
		auditRecordDto.setAuditList(list);
		auditRecordDto.setId(id);
		auditRecordDto.setStatus(base.getStatus());
		auditRecordDto.setStatusText(ReservationStatusEnum.getName(base.getStatus()));
		BaseReservationDiscard baseDiscard = reservationService.getDiscard(id);
		if (baseDiscard != null) {
			auditRecordDto.setDiscard(true);
			auditRecordDto.setReason(baseDiscard.getReason());
			auditRecordDto.setDiscardUserId(baseDiscard.getCreateUserId());
			auditRecordDto.setDiscardUserName(userDetailService.getUserRealName(baseDiscard.getCreateUserId()));
			auditRecordDto.setDiscardTime(baseDiscard.getCreateDate());
		} else {
			auditRecordDto.setDiscard(false);
		}
		return Result.newSuccessResult(auditRecordDto);
	}

}
