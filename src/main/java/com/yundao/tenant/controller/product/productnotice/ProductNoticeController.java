package com.yundao.tenant.controller.product.productnotice;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.Code1220000;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.productnotice.ProductNoticePageReqDto;
import com.yundao.tenant.dto.productnotice.ProductNoticeReqDto;
import com.yundao.tenant.dto.workflow.WorkFlowAuditRecordResDto;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.model.base.product.BaseProductNotice;
import com.yundao.tenant.model.productnotice.ProductNoticeModel;
import com.yundao.tenant.service.product.productnotice.ProductNoticeService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/productnotice/")
@ResponseBody
@Api("产品公告")
public class ProductNoticeController {

    @Autowired
    private ProductNoticeService productNoticeService;

    @Autowired
    private WorkflowServie workflowServie;

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询产品公告")
    public Result<PaginationSupport<ProductNoticeModel>> getPage(@ModelAttribute ProductNoticePageReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception {
        return productNoticeService.getPage(dto, pageDto);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增产品公告", notes = "根据ProductNotice对象创建产品公告")
    public Result<Integer> add(@Validated(value = {Insert.class}) @ModelAttribute ProductNoticeReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return productNoticeService.add(dto);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑产品公告信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute ProductNoticeReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return productNoticeService.update(dto);
    }

    @RequestMapping(value = "flow", method = RequestMethod.POST)
    @ApiOperation(value = "流程流转")
    public Result<Integer> flow(@RequestParam Long id, @RequestParam Integer status, @RequestParam(required = false) String reason) throws Exception {
        return productNoticeService.processFlow(id, status, reason);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ApiOperation(value = "获取产品公告详细信息")
    public Result<BaseProductNotice> get(@RequestParam Long id) throws Exception {
        return productNoticeService.get(id);
    }

    @RequestMapping(value = "get_ids", method = RequestMethod.GET)
    @ApiOperation(value = "根据产品公告ids获取对应的产品公告")
    public Result<List<BaseProductNotice>> get(@RequestParam String ids) throws Exception {
        return productNoticeService.getIds(ids);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除产品公告信息")
    public Result<PermissionResultDto> delete(@RequestParam String ids) throws Exception {
        return productNoticeService.delete(ids);
    }

    @RequestMapping(value = "qrtz_notice", method = RequestMethod.GET)
    @ApiOperation(value = "定时发布产品公告")
    public Result<Long> qrtzNotice() throws Exception {
        return productNoticeService.processQrtzNotice();
    }

    @ApiOperation(value = "查询审核历史记录")
    @RequestMapping(value = "get_history_audit_detail", method = RequestMethod.GET)
    public Result<List<WorkFlowAuditRecordResDto>> getAuditDetail(@RequestParam Long noticeId) throws BaseException {
        // 检查产品是否存在
        if (noticeId == null) {
            return Result.newFailureResult(GJLCodeConstant.CODE_1210032);
        }
        BaseProductNotice notice = productNoticeService.get(noticeId).getResult();
        if (notice == null) {
            return Result.newFailureResult(Code1220000.CODE_1220153);
        }

        return workflowServie.getAuditDetail(noticeId, ProcessDefineKeyEnum.PRODUCT_NOTICE.getKey());
    }


}
