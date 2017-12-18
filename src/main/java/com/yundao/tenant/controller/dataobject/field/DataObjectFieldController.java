package com.yundao.tenant.controller.dataobject.field;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.field.DataObjectFieldDto;
import com.yundao.tenant.service.field.DataObjectFieldService;
import com.yundao.tenant.util.SymbolStrUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据对象字段控制器
 *
 * @author jan
 * @create 2017-07-30 PM1:45
 **/
@Controller
@RequestMapping("/data/object/field")
@ResponseBody
@Api(value = "数据对象字段")
public class DataObjectFieldController {

    @Autowired
    private DataObjectFieldService dataObjectFieldService;

    @RequestMapping(value = "/get_by_codes", method = RequestMethod.GET)
    @ApiOperation(value = "根据字段编码获取，多个以逗号分隔")
    public Result<List<DataObjectFieldDto>> getByCode(String codes) throws BaseException {
        return Result.newSuccessResult(dataObjectFieldService.getByCodes(SymbolStrUtils.toList(codes)));
    }
}
