

package com.yundao.tenant.controller.customer.opensea;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageReqDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaAppPageResDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageReqDto;
import com.yundao.tenant.dto.customer.opensea.CustomerOpenSeaPageResDto;
import com.yundao.tenant.enums.access.DataObjectPermissionEnum;
import com.yundao.tenant.service.customer.opensea.CustomerOpenSeaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Function:
 * Reason:
 * Date:     2017年9月18日 下午5:03:42
 *
 * @author 欧阳利
 */
@RestController
@RequestMapping(value = "/customer/opensea")
@ResponseBody
@Api("客户公海")
public class CustomerOpenSeaController {

    @Autowired
    private CustomerOpenSeaService customerOpenSeaService;

    @RequestMapping(value = "/get_page_personal", method = RequestMethod.GET)
    @ApiOperation("获取客户公海分页数据数据 - 只获取自己的客户")
    public Result<PaginationSupport<CustomerOpenSeaPageResDto>> getPagePersonal(@Validated @ModelAttribute CustomerOpenSeaPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        this.compatibility(dto);
        return customerOpenSeaService.getPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/get_page_department", method = RequestMethod.GET)
    @ApiOperation("获取客户公海分页数据数据 - 获取部门客户数据")
    public Result<PaginationSupport<CustomerOpenSeaPageResDto>> getPageDepartment(@Validated @ModelAttribute CustomerOpenSeaPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        this.compatibility(dto);
        return customerOpenSeaService.getPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/get_page_public", method = RequestMethod.GET)
    @ApiOperation("获取客户公海分页数据数据 - 获取所有客户数据")
    public Result<PaginationSupport<CustomerOpenSeaPageResDto>> getPagePublic(@Validated @ModelAttribute CustomerOpenSeaPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        this.compatibility(dto);
        return customerOpenSeaService.getPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }

    /**
     * APP 和 PC 的参数做兼容
     */
    private void compatibility(@Validated @ModelAttribute CustomerOpenSeaPageReqDto dto) {
        if (BooleanUtils.isNotBlank(dto.getTags()) && BooleanUtils.isBlank(dto.getTagNames())) {
            dto.setTagNames(dto.getTags());
        }
        if (BooleanUtils.isNotBlank(dto.getTypies()) && BooleanUtils.isBlank(dto.getCustomerTypes())) {
            dto.setCustomerTypes(dto.getTypies());
        }
        if (BooleanUtils.isNotBlank(dto.getInvestTypes()) && BooleanUtils.isBlank(dto.getInvests())) {
            dto.setInvests(dto.getInvestTypes());
        }
        if (BooleanUtils.isNotBlank(dto.getBirthdayBegin()) && BooleanUtils.isBlank(dto.getBirthDayBegin())) {
            dto.setBirthDayBegin(dto.getBirthdayBegin());
        }
        if (BooleanUtils.isNotBlank(dto.getBirthdayEnd()) && BooleanUtils.isBlank(dto.getBirthDayEnd())) {
            dto.setBirthDayEnd(dto.getBirthdayEnd());
        }
    }

    @ApiOperation("领取公海客户")
    @RequestMapping(value = "/receive_customer", method = RequestMethod.POST)
    public Result<Integer> receiveCustomer(@RequestParam Long customerId) throws BaseException {
        return customerOpenSeaService.doReceiveCustomer(customerId);
    }

    @RequestMapping(value = "/app/get_page_personal", method = RequestMethod.GET)
    @ApiOperation("app获取客户公海分页数据数据 - 只获取自己的客户")
    public Result<PaginationSupport<CustomerOpenSeaAppPageResDto>> getAppPagePersonal(@Validated @ModelAttribute CustomerOpenSeaAppPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerOpenSeaService.getAppPage(dto, DataObjectPermissionEnum.PERSONAL.getValue());
    }

    @RequestMapping(value = "/app/get_page_department", method = RequestMethod.GET)
    @ApiOperation("app获取客户公海分页数据数据 - 获取部门客户数据")
    public Result<PaginationSupport<CustomerOpenSeaAppPageResDto>> getAppPageDepartment(@Validated @ModelAttribute CustomerOpenSeaAppPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerOpenSeaService.getAppPage(dto, DataObjectPermissionEnum.DEPARTMENT.getValue());
    }

    @RequestMapping(value = "/app/get_page_public", method = RequestMethod.GET)
    @ApiOperation("app获取客户公海分页数据数据 - 获取所有客户数据")
    public Result<PaginationSupport<CustomerOpenSeaAppPageResDto>> getAppPagePublic(@Validated @ModelAttribute CustomerOpenSeaAppPageReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return customerOpenSeaService.getAppPage(dto, DataObjectPermissionEnum.PUBLIC.getValue());
    }

    @ApiOperation("app领取公海客户")
    @RequestMapping(value = "/app/receive_customer", method = RequestMethod.POST)
    public Result<Integer> appReceiveCustomer(@RequestParam Long customerId) throws BaseException {
        return customerOpenSeaService.doReceiveCustomer(customerId);
    }


}

