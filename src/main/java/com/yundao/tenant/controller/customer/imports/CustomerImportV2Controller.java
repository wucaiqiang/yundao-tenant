package com.yundao.tenant.controller.customer.imports;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.imports.CustomerImportDto;
import com.yundao.tenant.service.customer.imports.CustomerImportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 客户导入
 *
 * @author jan
 * @create 2017-08-31 PM3:29
 **/
@Controller
@RequestMapping("/customer/v2/import")
@ResponseBody
@Api("客户导入V2")
public class CustomerImportV2Controller {

    @Autowired
    private CustomerImportService customerImportService;

    @RequestMapping(value = "/multi", method = RequestMethod.POST)
    @ApiOperation("批量导入客户V2")
    public Result<Boolean> importV2(String mobiles) throws BaseException {
        if (BooleanUtils.isEmpty(mobiles))
            throw new BaseException(CodeConstant.CODE_1220071);
        List<CustomerImportDto> dtos = JsonUtils.jsonToObject(mobiles, new BaseTypeReference<List<CustomerImportDto>>() {
        });

        return customerImportService.doImportV2(dtos);
    }
}
