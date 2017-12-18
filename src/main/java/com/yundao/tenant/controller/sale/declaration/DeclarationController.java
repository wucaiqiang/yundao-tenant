package com.yundao.tenant.controller.sale.declaration;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.RequestUtils;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationApplyRefundReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationAuditRecordResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationDiscardReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationForProDetailResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationPageReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationPatchReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationResDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationResubmitReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationSearchReqDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateBankDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateComplianceDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateCredentialsDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUpdateSubscribeDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserDto;
import com.yundao.tenant.dto.sale.declaration.DeclarationUserReqDto;
import com.yundao.tenant.dto.sale.declaration.apply.DeclarationApplyrReqDto;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.enums.sale.declaration.DeclarationStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationDiscard;
import com.yundao.tenant.model.sale.DeclarationModel;
import com.yundao.tenant.service.sale.declaration.DeclarationService;
import com.yundao.tenant.service.sale.refund.RefundService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.workflow.WorkflowServie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/declaration/")
@ResponseBody
@Api("报单")
public class DeclarationController {

    @Autowired
    private DeclarationService declarationService;
    @Autowired
    private WorkflowServie workflowServie;

    @Autowired
    private UserDetailService userDetailService;
    
    @Autowired
    private RefundService refundService;

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询报单")
    public Result<PaginationSupport<DeclarationModel>> getPage(@ModelAttribute DeclarationPageReqDto dto,
                                                               @ModelAttribute BasePageDto pageDto) throws Exception {
        HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        dto.setUserId(user.getUserId());
        return declarationService.getPage(dto, pageDto);
    }

    @RequestMapping(value = "app/search", method = RequestMethod.GET)
    @ApiOperation(value = "app报单搜索")
    public Result<PaginationSupport<DeclarationModel>> searchForApp(@ModelAttribute DeclarationSearchReqDto dto,
                                                                    @ModelAttribute BasePageDto pageDto) throws Exception {
        HeaderUser user = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        dto.setUserId(user.getUserId());
        return declarationService.searchForApp(dto, pageDto);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增报单", notes = "根据Declaration对象创建报单")
    public Result<Long> add(@Validated @ModelAttribute DeclarationReqDto reqDto, BindingResult bindingResult)
            throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return declarationService.add(reqDto);
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    @ApiOperation(value = "新增报单", notes = "根据Declaration对象创建报单")
    public Result<Long> submit(@RequestParam Long id)
            throws Exception {
        return declarationService.processSubmit(id);
    }

    @RequestMapping(value = "validate", method = RequestMethod.POST)
    @ApiOperation(value = "验证报单", notes = "根据Declaration对象创建报单")
    public Result<Long> validate(@RequestParam Long id)
            throws Exception {
        return declarationService.processValidate(id);
    }

    @RequestMapping(value = "/patch", method = RequestMethod.POST)
    @ApiOperation(value = "补入报单")
    public Result<Long> patch(@ModelAttribute DeclarationPatchReqDto reqDto, BindingResult bindingResult) throws Exception {
    	 BindingResultHandler.handleByException(bindingResult);
    	 return declarationService.doPatch(reqDto);
    }

    // @RequestMapping(value = "update", method = RequestMethod.POST)
    // @ApiOperation(value = "编辑报单信息")
    // public Result<Integer> update(@Validated(value = {Update.class})
    // @ModelAttribute DeclarationReqDto reqDto, BindingResult bindingResult)
    // throws Exception {
    // BindingResultHandler.handleByException(bindingResult);
    // return declarationService.update(reqDto);
    // }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ApiOperation(value = "获取报单详细信息")
    public Result<DeclarationResDto> get(@RequestParam Long id) throws Exception {
        return declarationService.get(id);
    }

    @RequestMapping(value = "resubmit", method = RequestMethod.POST)
    @ApiOperation(value = "重新提交")
    public Result<Long> resubmit(@Validated @ModelAttribute DeclarationApplyrReqDto dto, BindingResult bindingResult)
            throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return declarationService.doResubmit(dto);
    }

    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    @ApiOperation(value = "取消")
    public Result<Long> cancel(@Validated @ModelAttribute DeclarationApplyrReqDto dto, BindingResult bindingResult)
            throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return declarationService.doCancel(dto);
    }

    @RequestMapping(value = "update_credentials", method = RequestMethod.POST)
    @ApiOperation(value = "修改身份资料")
    public Result<Long> updateCredentials(@ModelAttribute DeclarationUpdateCredentialsDto dto) throws BaseException {
        return declarationService.updateCredentials(dto);
    }

    @RequestMapping(value = "update_bank", method = RequestMethod.POST)
    @ApiOperation(value = "修改银行卡")
    public Result<Long> updateBank(@Validated(value = {Update.class}) @ModelAttribute DeclarationUpdateBankDto dto,
                                   BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return declarationService.updateBank(dto);
    }

    @RequestMapping(value = "update_subscribe", method = RequestMethod.POST)
    @ApiOperation(value = "修改认购信息")
    public Result<Long> updateSubscribe(@ModelAttribute DeclarationUpdateSubscribeDto dto) throws BaseException {
        return declarationService.updateSubscribe(dto);
    }

    @RequestMapping(value = "update_compliance", method = RequestMethod.POST)
    @ApiOperation(value = "修改合规文件")
    public Result<Long> updateCompliance(@ModelAttribute DeclarationUpdateComplianceDto dto) throws BaseException {
        return declarationService.updateCompliance(dto);
    }

    @RequestMapping(value = "app/update", method = RequestMethod.POST)
    @ApiOperation(value = "app端口修改报单资料")
    public Result<Boolean> updateForApp(HttpServletRequest request) throws Exception {
        Map<String, String> params = RequestUtils.getParameterMap(request);
        return declarationService.updateForApp(params);
    }

    @RequestMapping(value = "app/resubmit", method = RequestMethod.POST)
    @ApiOperation(value = "新增报单", notes = "根据Declaration对象创建报单")
    public Result<Long> resubmitForApp(@Validated @ModelAttribute DeclarationResubmitReqDto reqDto, BindingResult bindingResult)
            throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return declarationService.doResubmitForApp(reqDto);
    }

    
    
	@RequestMapping(value = "/apply_refund", method = RequestMethod.POST)
    @ApiOperation(value = "申请退款")
    public Result<Long> applyRefund(@Validated @ModelAttribute DeclarationApplyRefundReqDto dto, BindingResult bindingResult) throws BaseException {
    	 BindingResultHandler.handleByException(bindingResult);
    	 return refundService.doApplyRefund(dto);
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
    public Result<Long> discard(@ModelAttribute DeclarationDiscardReqDto dto, BindingResult bindingResult)
            throws BaseException {
        BindingResultHandler.handleByException(bindingResult);

        return declarationService.doDiscard(dto);
    }

    @RequestMapping(value = "/get_customer_count", method = RequestMethod.GET)
    @ApiOperation("获取客户的报单个数")
    public Result<Integer> getCountCount(@RequestParam Long customerId) throws Exception {
        return declarationService.getCustomerCount(customerId);
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
    public Result<DeclarationAuditRecordResDto> getWorkflowList(@RequestParam Long id) throws BaseException {
        if (id == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200000);
        }
        BaseDeclaration base = declarationService.getBaseDeclaration(id);
        if (base == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200114);
        }
        if(DeclarationStatusEnum.UNCOMMITTED.getValue().equals(base.getStatus())){
            throw new BaseException(GJLCodeConstant.CODE_1210132);
        }
        DeclarationAuditRecordResDto auditRecordDto = new DeclarationAuditRecordResDto();
        List<AuditDetailResDTO> list = workflowServie.getWorkflowList(id, BusinessTypeCode.DECLARATION);
        if (!BooleanUtils.isEmpty(list)) {
            for (AuditDetailResDTO dto : list) {
                dto.setActionText(WorkflowActionEnum.getName(dto.getActionValue()));
                dto.setActionUserName(userDetailService.getUserRealName(dto.getActionUserId()));

            }
        }
        auditRecordDto.setAuditList(list);
        auditRecordDto.setId(id);
        auditRecordDto.setStatus(base.getAuditStatus());
        auditRecordDto.setStatusText(DeclarationStatusEnum.getName(base.getAuditStatus()));
        BaseDeclarationDiscard baseDiscard = declarationService.getBaseDeclarationDiscard(id);
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

    @RequestMapping(value = "get_page_for_pro_detail", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品详情页面分页数据")
    public Result<PaginationSupport<DeclarationForProDetailResDto>> getPageForProductDetail(Long productId) throws Exception {
        return declarationService.getPageForProductDetail(productId);
    }
    
    @RequestMapping(value = "get_declaration_user", method = RequestMethod.GET)
    @ApiOperation(value = "获取成单理财师信息")
    public Result<List<DeclarationUserDto>> getDeclarationUserDtos(@ModelAttribute DeclarationUserReqDto reqDto) throws Exception{
    	if(reqDto == null || reqDto.getFilterType() == null){
    		reqDto.setFilterType(2);
    	}
   	    return declarationService.getDeclarationUserDtos(reqDto);
    }
}