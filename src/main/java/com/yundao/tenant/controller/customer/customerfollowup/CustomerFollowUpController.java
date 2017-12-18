package com.yundao.tenant.controller.customer.customerfollowup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpPageDto;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpPageResDto;
import com.yundao.tenant.dto.customer.customerfollowup.CustomerFollowUpReqDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.customer.customerfollowup.CustomerFollowUpService;
import com.yundao.tenant.service.operation.visit.CustomerVisitService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/customer/follow/up/")
@ResponseBody
@Api("客户跟进")
public class CustomerFollowUpController {

    @Autowired
    private CustomerFollowUpService customerFollowUpService;
    @Autowired
    CustomerVisitService customerVisitService;
    @Autowired
    WorkFlowGroupUserService workFlowGroupUserService;

    private static Log log = LogFactory.getLog(CustomerFollowUpController.class);

    @RequestMapping(value = "get_page_personal", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询客户跟进 - 只获取自己的客户")
    public Result<PaginationSupport<CustomerFollowUpPageResDto>> getPagePersonal(@Validated @ModelAttribute CustomerFollowUpPageDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return customerFollowUpService.getPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "get_page_department", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询客户跟进 - 获取部门客户数据")
    public Result<PaginationSupport<CustomerFollowUpPageResDto>> getPageDepartment(@Validated @ModelAttribute CustomerFollowUpPageDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return customerFollowUpService.getPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "get_page_public", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询客户跟进 - 获取所有客户数据")
    public Result<PaginationSupport<CustomerFollowUpPageResDto>> getPagePublic(@Validated @ModelAttribute CustomerFollowUpPageDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return customerFollowUpService.getPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增客户跟进", notes = "根据CustomerFollowUp对象创建客户跟进")
    public Result<Long> add(@Validated(Insert.class) @ModelAttribute CustomerFollowUpReqDto reqDto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return customerFollowUpService.add(reqDto);
    }

    /**
     * 每天凌晨执行
     * qrtzFollow:
     * @author: 欧阳利
     * @return
     * @throws Exception
     * @description:
     */
    @RequestMapping(value = "qrtz_follow", method = RequestMethod.GET)
    @ApiOperation(value = "定时下次跟进", notes = "定时下次跟进")
    public Result<Long> qrtzFollow() throws Exception {
        try {
        	// 待回访消息
            customerVisitService.doNextVisitCustomerSendMessage();
        } catch (Exception e) {
            log.error("生成下次回访消息异常：", e);
        }
        
        try {
            // 同步工作流用户组
            workFlowGroupUserService.updateRole();
        } catch (Exception e) {
            log.error("同步工作流用户组异常：", e);
        }

        return customerFollowUpService.processFollow();
    }


//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑客户跟进信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CustomerFollowUpReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return customerFollowUpService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取客户跟进详细信息")
//    public Result<BaseCustomerFollowUp> get(@RequestParam Long id) throws Exception{
//       return customerFollowUpService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除客户跟进信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return customerFollowUpService.delete(id);
//    }

}
