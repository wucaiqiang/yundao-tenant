package com.yundao.tenant.controller.dictionary;

import com.yundao.core.code.Result;
import com.yundao.core.dto.dictionary.DictionariesDto;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.region.RegionService;
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
 * 数据字典控制器
 *
 * @author jan
 * @create 2017-07-16 PM7:38
 **/
@Controller
@RequestMapping("/dictionary")
@ResponseBody
@Api(value = "数据字典")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/get_region_text", method = RequestMethod.GET)
    @ApiOperation(value = "根据编码获取数据字典")
    public Result<String> getRegionText(@RequestParam String code) throws BaseException {
        if (BooleanUtils.isEmpty(code))
            throw new BaseException(CodeConstant.CODE_1220017);
        return Result.newSuccessResult(regionService.toText(code));
    }

    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    @ApiOperation(value = "根据编码获取数据字典")
    public Result<List<DictionariesDto>> gets(@RequestParam String codes) throws BaseException {
        if (BooleanUtils.isEmpty(codes))
            throw new BaseException(CodeConstant.CODE_1220017);
        return Result.newSuccessResult(dictionaryService.gets(codes));
    }

    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ApiOperation("重新加载数据字典数据")
    public Result<Boolean> reloadDics() throws BaseException {
        dictionaryService.reload();
        return Result.newSuccessResult();
    }

}
