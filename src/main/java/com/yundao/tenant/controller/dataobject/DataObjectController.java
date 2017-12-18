package com.yundao.tenant.controller.dataobject;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.controller.BaseController;
import com.yundao.tenant.dto.dataobject.DataObjectDetailResDto;
import com.yundao.tenant.dto.dataobject.DataObjectReqDto;
import com.yundao.tenant.service.dataobject.DataObjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据对象控制器
 *
 * @author jan
 * @create 2017-07-15 AM9:34
 **/
@Controller
@RequestMapping("/data/object")
@ResponseBody
@Api("数据对象权限")
public class DataObjectController extends BaseController {

    @Autowired
    private DataObjectService dataObjectService;

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "获取数据权限数据")
    public Result<List<DataObjectDetailResDto>> gets(@RequestParam(required = false) Long roleId) throws
            BaseException {
        return Result.newSuccessResult(roleId != null ? dataObjectService.getByRoleId(roleId) : dataObjectService.gets());
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新角色的数据权限")
    public Result<Long> update(@RequestParam Long roleId, @RequestParam String selections) throws BaseException {
        super.checkRoleIdNotNull(roleId);
        if (BooleanUtils.isEmpty(selections))
            throw new BaseException(CodeConstant.CODE_1220014);

        List<DataObjectReqDto> dtos = JsonUtils.jsonToObject(selections, new BaseTypeReference<List<DataObjectReqDto>>() {
        });
        return Result.newSuccessResult(dataObjectService.update(roleId, dtos));
    }

}
