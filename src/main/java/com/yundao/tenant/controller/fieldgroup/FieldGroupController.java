package com.yundao.tenant.controller.fieldgroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.field.FieldDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupInfoReqDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupRelReqDto;
import com.yundao.tenant.dto.fieldgroup.FieldGroupReqDto;
import com.yundao.tenant.model.base.BaseFieldGroup;
import com.yundao.tenant.service.field.FieldSelectService;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/fieldgroup/")
@ResponseBody
@Api("业务对象字段分组")
public class FieldGroupController{

    @Autowired
    private FieldGroupService fieldGroupService;

	@Autowired
	FieldSelectService fieldSelectService;
    
	
	/**
	 * 通过类别查询字段信息
	 * getFieldDtosByFieldGroupId:
	 * @author: 欧阳利
	 * @param fieldGroupId
	 * @return
	 * @throws Exception
	 * @description:
	 */
    @RequestMapping(value = "get_field_by_fieldgroupid",method=RequestMethod.GET)
    @ApiOperation(value="分页查询业务对象字段分组")
    public Result<List<FieldDto>> getFieldDtosByFieldGroupId(@RequestParam Long fieldGroupId) throws Exception{
    	if (fieldGroupId == null) {
			return Result.newFailureResult(CodeConstant.CODE_1200044);
		}
		boolean isExist = fieldGroupService.checkFieldGroupExist(fieldGroupId);
		if (!isExist) {
			return Result.newFailureResult(CodeConstant.CODE_1200045);
		}
		List<FieldDto> list = fieldSelectService.getFieldByTypeGroupId(fieldGroupId);
		return Result.newSuccessResult(list);
    }
    
    
    
    
    @RequestMapping(value = "get_page",method=RequestMethod.GET)
    @ApiOperation(value="分页查询业务对象字段分组")
    public Result<PaginationSupport<BaseFieldGroup>> getPage(@ModelAttribute FieldGroupReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
		return fieldGroupService.getPage(dto, pageDto);
    }

    @RequestMapping(value = "get_ids", method=RequestMethod.GET)
    @ApiOperation(value="根据产品公告ids获取对应的产品公告")
    public Result<List<BaseFieldGroup>> getIds(@RequestParam String ids) throws BaseException {
        return fieldGroupService.getIds(ids);
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    @ApiOperation(value="新增业务对象字段分组", notes="根据FieldGroup对象创建业务对象字段分组")
    public Result<Long> add(@Validated @ModelAttribute FieldGroupReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return fieldGroupService.add(dto);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST)
    @ApiOperation(value="编辑业务对象字段分组信息")
    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute FieldGroupReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return fieldGroupService.update(dto);
    }

    @RequestMapping(value = "update_info", method=RequestMethod.POST)
    @ApiOperation(value="编辑业务对象字段分组信息")
    public Result<Integer> updateInfo(@Validated(value = {Update.class}) @ModelAttribute FieldGroupInfoReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        return fieldGroupService.updateInfo(dto);
    }

    @RequestMapping(value = "update_rel", method=RequestMethod.POST)
    @ApiOperation(value="编辑业务对象字段分组基本信息")
    public Result<Integer> updateRel(@Validated(value = {Update.class}) @ModelAttribute FieldGroupRelReqDto dto, BindingResult bindingResult) throws Exception{
        BindingResultHandler.handleByException(bindingResult);
        fieldGroupService.updateFieldGroupRel(dto.getId(),dto.getFieldGroupRelIds());
        return Result.newSuccessResult();
    }

    @RequestMapping(value = "get", method=RequestMethod.GET)
    @ApiOperation(value="获取业务对象字段分组详细信息")
    public Result<BaseFieldGroup> get(@RequestParam Long id) throws Exception{
       return fieldGroupService.get(id);
    }

    @RequestMapping(value = "delete", method=RequestMethod.POST)
    @ApiOperation(value="删除业务对象字段分组信息")
    public Result<PermissionResultDto> delete(@RequestParam String ids) throws Exception{
        return fieldGroupService.delete(ids);
    }

}
