package com.yundao.tenant.controller.dataobject.permission;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.permission.DataPermissionResDto;
import com.yundao.tenant.dto.permission.PermissionListResDto;
import com.yundao.tenant.dto.permission.PermissionMultiCodeReqDto;
import com.yundao.tenant.enums.access.OperationPermissionEnum;
import com.yundao.tenant.service.dataobject.permission.DataObjectPermissionService;
import com.yundao.tenant.service.permission.UserPermissionService;
import com.yundao.tenant.util.SymbolStrUtils;
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
 * 数据权限控制器
 *
 * @author jan
 * @create 2017-08-05 PM1:17
 **/
@Controller
@RequestMapping("/data/object/permission")
@ResponseBody
@Api("数据权限控制")
public class DataObjectPermissionController {

    @Autowired
    private DataObjectPermissionService dataObjectPermissionService;

    @Autowired
    private UserPermissionService userPermissionService;

    @RequestMapping(value = "/get_read", method = RequestMethod.GET)
    @ApiOperation(value = "获取读取权限")
    public Result<Integer> getRead(String dataObjectCode) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        return Result.newSuccessResult(dataObjectPermissionService.get(dataObjectCode, OperationPermissionEnum.READ.getValue()));
    }

    @RequestMapping(value = "/get_update", method = RequestMethod.GET)
    @ApiOperation(value = "获取编辑权限")
    public Result<Integer> getUpdate(String dataObjectCode) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        return Result.newSuccessResult(dataObjectPermissionService.get(dataObjectCode, OperationPermissionEnum.EDIT.getValue()));
    }

    @RequestMapping(value = "/get_delete", method = RequestMethod.GET)
    @ApiOperation(value = "获取删除权限")
    public Result<Integer> getDelete(String dataObjectCode) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        return Result.newSuccessResult(dataObjectPermissionService.get(dataObjectCode, OperationPermissionEnum.DELETE.getValue()));
    }

    @RequestMapping(value = "/check_read", method = RequestMethod.GET)
    @ApiOperation(value = "校验读取权限")
    public Result<Boolean> checkRead(String dataObjectCode, Long ownerId) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        return Result.newSuccessResult(dataObjectPermissionService.check(dataObjectCode, OperationPermissionEnum.READ.getValue(),
                ownerId));
    }

    @RequestMapping(value = "/check_update", method = RequestMethod.GET)
    @ApiOperation(value = "校验编辑权限")
    public Result<Boolean> checkUpdate(String dataObjectCode, Long ownerId) throws
            BaseException {
        this.checkArgsNotNull(dataObjectCode);
        return Result.newSuccessResult(dataObjectPermissionService.check(dataObjectCode, OperationPermissionEnum.EDIT.getValue(), ownerId));
    }

    @RequestMapping(value = "/check_delete", method = RequestMethod.GET)
    @ApiOperation(value = "校验编辑权限")
    public Result<Boolean> checkDelete(String dataObjectCode, Long ownerId) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        return Result.newSuccessResult(dataObjectPermissionService.check(dataObjectCode, OperationPermissionEnum.DELETE.getValue(), ownerId));
    }

    @RequestMapping(value = "/check_delete_list", method = RequestMethod.GET)
    @ApiOperation(value = "校验多个删除权限")
    public Result<List<PermissionListResDto>> checkDeleteList(String dataObjectCode, String ownerIds) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        if (BooleanUtils.isEmpty(ownerIds))
            throw new BaseException(CodeConstant.CODE_1220042);
        List<Long> ownerIdList = SymbolStrUtils.toLong(ownerIds);
        return Result.newSuccessResult(dataObjectPermissionService.checkList(dataObjectCode, OperationPermissionEnum.DELETE.getValue(), ownerIdList));
    }

    @RequestMapping(value = "/check_update_list", method = RequestMethod.GET)
    @ApiOperation(value = "校验多个修改权限")
    public Result<List<PermissionListResDto>> checkUpdateList(String dataObjectCode, String ownerIds) throws BaseException {
        this.checkArgsNotNull(dataObjectCode);
        List<Long> ownerIdList = SymbolStrUtils.toLong(ownerIds);
        return Result.newSuccessResult(dataObjectPermissionService.checkList(dataObjectCode, OperationPermissionEnum.EDIT.getValue(), ownerIdList));
    }


    @RequestMapping(value = "/check_read_list", method = RequestMethod.GET)
    @ApiOperation(value = "校验多个读取权限")
    public Result<List<PermissionListResDto>> checkReadList(String jsonReqDto) throws
            BaseException {
        return Result.newSuccessResult(dataObjectPermissionService.checkList(OperationPermissionEnum.READ.getValue(),
                jsonReqDto));
    }

    @RequestMapping(value = "/check_multi_code", method = RequestMethod.GET)
    @ApiOperation(value = "校验多个数据对象权限")
    public Result<List<DataPermissionResDto>> checkMultiCode(String jsonReqDto) throws
            BaseException {
        return Result.newSuccessResult(dataObjectPermissionService.checkMultiCode(jsonReqDto));
    }

    @RequestMapping(value = "/check_only_code", method = RequestMethod.GET)
    @ApiOperation(value = "校验单个数据对象权限")
    public Result<DataPermissionResDto> checkSignCode(String jsonReqDto) throws
            BaseException {
        PermissionMultiCodeReqDto codeReqDto = JsonUtils.jsonToObject(jsonReqDto, new BaseTypeReference<PermissionMultiCodeReqDto>() {
        });
        return Result.newSuccessResult(dataObjectPermissionService.checkOnlyCode(codeReqDto));
    }

    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    @ApiOperation(value = "重新加载缓存数据")
    public Result<Boolean> reload(@RequestParam Long tenantID) throws BaseException {
        userPermissionService.reload(tenantID);
        return Result.newSuccessResult(true);
    }


    private void checkArgsNotNull(String dataObjectCode) throws BaseException {
        if (BooleanUtils.isEmpty(dataObjectCode))
            throw new BaseException(CodeConstant.CODE_1220043);
    }

}
