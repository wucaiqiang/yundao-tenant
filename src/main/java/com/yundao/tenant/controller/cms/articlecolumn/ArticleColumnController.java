package com.yundao.tenant.controller.cms.articlecolumn;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.BasePageDto;
import com.yundao.tenant.dto.cms.articlecolumn.*;
import com.yundao.tenant.service.cms.articlecolumn.ArticleColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cms/article/column/")
@ResponseBody
@Api("文章栏目管理")
public class ArticleColumnController {

    @Autowired
    private ArticleColumnService articleColumnService;

    @RequestMapping(value = "get_page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询")
    public Result<PaginationSupport<ArticleColumnPageResDto>> getPage(@ModelAttribute ArticleColumnPageReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception {
        return articleColumnService.getPage(dto, pageDto);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ApiOperation(value = "新增", notes = "根据文章栏目对象创建")
    public Result<Long> add(@Validated @ModelAttribute ArticleColumnReqDto reqDto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return articleColumnService.add(reqDto);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "编辑信息")
    public Result<Integer> update(@Validated @ModelAttribute ArticleColumnUPReqDto reqDto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return articleColumnService.update(reqDto);
    }

    @RequestMapping(value = "update_status", method = RequestMethod.GET)
    @ApiOperation(value = "修改启用和禁用状态")
    public Result<Integer> updateStatus(@RequestParam Long id, @RequestParam Integer status) throws Exception {
        return articleColumnService.updateStatus(id, status);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除信息")
    public Result<Integer> delete(@RequestParam String ids) throws Exception {
        return articleColumnService.delete(ids);
    }

    @RequestMapping(value = "get_select_option", method = RequestMethod.GET)
    @ApiOperation(value = "获取指定平台下的栏目")
    public Result<List<ArticleColumnSelectDto>> getPage(@RequestParam Long platformId) throws Exception {
        return articleColumnService.getSelectOption(platformId);
    }

}
