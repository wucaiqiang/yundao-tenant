package com.yundao.tenant.controller.bo;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.controller.BaseController;
import com.yundao.tenant.dto.bo.*;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.service.bo.ObjectFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 业务对象字段控制器
 *
 * @author jan
 * @create 2017-07-06 PM4:39
 **/
@Controller
@RequestMapping(value = "/object/field")
@Api(value = "业务对象字段")
@ResponseBody
public class ObjectFieldController extends BaseController {

    @Autowired
    private ObjectFieldService objectFieldService;

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation(value = "获取分页数据")
    public Result<PaginationSupport<ObjectFieldPageResDto>> getPage(@Validated @ModelAttribute ObjectFieldPageReqDto
                                                                            dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return Result.newSuccessResult(objectFieldService.getPage(dto));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "获取业务对象字段")
    public Result<ObjectFieldDetailResDto> get(@RequestParam Long id) throws BaseException {
        super.checkIdNotNull(id);
        return objectFieldService.get(id);
    }

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "获取业务对象字段列表")
    public Result<List<ObjectFieldSimpleResDto>> gets(String boCode) throws
            BaseException {
        super.checkBoCodeNotEmpty(boCode);
        return objectFieldService.getByBoCode(boCode);
    }

    @RequestMapping(value = "/get_list", method = RequestMethod.GET)
    @ApiOperation(value = "获取列表数据")
    public Result<List<ObjectFieldPageResDto>> getPage(String boCode) throws BaseException {
        super.checkBoCodeNotEmpty(boCode);
        return objectFieldService.getFieldList(boCode);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加业务对象字段")
    public Result<Long> add(@Validated @ModelAttribute ObjectFieldAddReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return objectFieldService.add(dto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "添加业务对象字段")
    public Result<Long> update(@Validated @ModelAttribute ObjectFieldUpdateReqDto dto, BindingResult bindingResult) throws
            BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return objectFieldService.update(dto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除业务对象字段，多个以逗号分隔")
    public Result<PermissionResultDto> delete(@RequestParam String ids, @RequestParam String boCode) throws BaseException {
        if (BooleanUtils.isEmpty(ids))
            throw new BaseException(CodeConstant.CODE_1200000);
        super.checkBoCodeNotEmpty(boCode);
        return objectFieldService.delete(ids, boCode);
    }

}
