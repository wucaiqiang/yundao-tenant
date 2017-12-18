package com.yundao.tenant.controller.fieldgrouprel;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.bo.ObjectFieldPageResDto;
import com.yundao.tenant.service.fieldgrouprel.FieldGroupRelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fieldgrouprel/")
@ResponseBody
@Api("业务对象字段分组关联")
public class FieldGroupRelController {

    @Autowired
    private FieldGroupRelService fieldGroupRelService;

//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询业务对象字段分组关联")
//    public Result<PaginationSupport<BaseFieldGroupRel>> getPage(@ModelAttribute FieldGroupRelReqDto dto, @ModelAttribute AbstractBasePageDto pageDto) throws Exception{
//        BaseFieldGroupRel model = new BaseFieldGroupRel();
//        BeanUtils.copyProperties(dto,model);
//		return fieldGroupRelService.getPage(model, pageDto);
//    }
//
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增业务对象字段分组关联", notes="根据FieldGroupRel对象创建业务对象字段分组关联")
//    public Result<Integer> add(@Validated @ModelAttribute FieldGroupRelReqDto dto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        BaseFieldGroupRel model = new BaseFieldGroupRel();
//        BeanUtils.copyProperties(dto,model);
//        return fieldGroupRelService.add(model);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑业务对象字段分组关联信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute FieldGroupRelReqDto dto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        BaseFieldGroupRel model = new BaseFieldGroupRel();
//        BeanUtils.copyProperties(dto,model);
//        return fieldGroupRelService.update(model);
//    }

    @RequestMapping(value = "get_groupid", method = RequestMethod.GET)
    @ApiOperation(value = "获取业务对象字段分组关联列表")
    public Result<List<ObjectFieldPageResDto>> getGroups(@RequestParam Long id) throws BaseException {
        return fieldGroupRelService.getGroups(id);
    }

//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除业务对象字段分组关联信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return fieldGroupRelService.delete(id);
//    }

}
