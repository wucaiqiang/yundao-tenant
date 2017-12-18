package com.yundao.tenant.controller.customer.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.customer.tag.TagReqDto;
import com.yundao.tenant.model.base.customer.BaseTag;
import com.yundao.tenant.service.customer.tag.TagService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/tag/")
@ResponseBody
@Api("客户标签表")
public class TagController {

	@Autowired
	private TagService tagService;

	// @RequestMapping(value="add", method=RequestMethod.POST)
	// @ApiOperation(value="新增标签表", notes="根据Tag对象创建标签表")
	// public Result<Integer> add(@Validated @ModelAttribute TagReqDto reqDto,
	// BindingResult bindingResult) throws Exception{
	// BindingResultHandler.handleByException(bindingResult);
	// return tagService.add(reqDto);
	// }
	//
	// @RequestMapping(value = "update", method=RequestMethod.POST)
	// @ApiOperation(value="编辑标签表信息")
	// public Result<Integer> update(@Validated(value = {Update.class})
	// @ModelAttribute TagReqDto reqDto, BindingResult bindingResult) throws
	// Exception{
	// BindingResultHandler.handleByException(bindingResult);
	// return tagService.update(reqDto);
	// }
	//
	// @RequestMapping(value = "get", method=RequestMethod.GET)
	// @ApiOperation(value="获取标签表详细信息")
	// public Result<BaseTag> get(@RequestParam Long id) throws Exception{
	// return tagService.get(id);
	// }
	//
	// @RequestMapping(value = "delete", method=RequestMethod.POST)
	// @ApiOperation(value="删除标签表信息")
	// public Result<Integer> delete(@RequestParam Long id) throws Exception{
	// return tagService.delete(id);
	// }

	@RequestMapping(value = "get_page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询标签表")
	public Result<PaginationSupport<BaseTag>> getPage(@ModelAttribute TagReqDto dto) throws Exception {
		return tagService.getPage(dto);
	}

	@RequestMapping(value = "get_top", method = RequestMethod.GET)
	@ApiOperation(value = "查询排名的标签信息")
	public Result<List<BaseTag>> getTop(@RequestParam(required = false, name = "limit") Integer limit)
			throws Exception {
		return tagService.getTop(limit);
	}

	@RequestMapping(value = "get_all", method = RequestMethod.GET)
	@ApiOperation(value = "查询排名的标签信息")
	public Result<List<BaseTag>> getAll() throws Exception {
		return tagService.getAll();
	}

	@RequestMapping(value = "set_customer_tag", method = RequestMethod.POST)
	@ApiOperation(value = "设置客户标签")
	public Result<Boolean> setCustomerTag(@RequestParam Long customerId, @RequestParam String tags) throws Exception {
		return tagService.processSetCustomerTag(customerId, tags);
	}

	@RequestMapping(value = "get_customer_tag", method = RequestMethod.GET)
	@ApiOperation(value = "获取客户标签")
	public Result<List<BaseTag>> getCustomerTag(@RequestParam Long customerId) throws Exception {
		return tagService.getCustomerTag(customerId);
	}
}
