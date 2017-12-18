package com.yundao.tenant.controller.cms.article;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.cms.article.*;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.service.cms.article.ArticleService;
import com.yundao.tenant.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制器
 *
 * @author jan
 * @create 2017-10-20 17:37
 **/
@Controller
@RequestMapping("/cms/article")
@ResponseBody
@Api("文章 - 后台管理使用")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation("删除文章")
    public Result<PermissionResultDto> delete(@Validated @ModelAttribute ArticleDeleteReqDto dto, BindingResult bindingResult) throws BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return articleService.delete(dto);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增文章")
    public Result<Long> add(@Validated @ModelAttribute ArticleAddReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return articleService.add(dto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation("编辑文章")
    public Result<Long> update(@Validated @ModelAttribute ArticleUpdateReqDto dto, BindingResult bindingResult) throws Exception {
        BindingResultHandler.handleByException(bindingResult);
        return articleService.update(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取文章分页数据")
    public Result<PaginationSupport<ArticlePageResDto>> getPage(@ModelAttribute ArticlePageReqDto dto) throws BaseException {
        dto.setPublishDateEnd(DateUtil.toEndDate(dto.getPublishDateEnd()));
        dto.setOperateTimeEnd(DateUtil.toEndDate(dto.getOperateTimeEnd()));
        return articleService.getPage(dto);
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    @ApiOperation("获取文章详情数据")
    public Result<ArticleDetailResDto> get(@RequestParam Long id) throws BaseException{
        return articleService.get(id);
    }

}
