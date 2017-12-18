package com.yundao.tenant.controller.cms.article;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.cms.article.ArticleCodeDto;
import com.yundao.tenant.dto.cms.article.column.ArticleColumnFrontListResDto;
import com.yundao.tenant.dto.cms.article.front.*;
import com.yundao.tenant.service.cms.article.ArticleFrontService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 前端文章
 *
 * @author jan
 * @create 2017-10-19 08:53
 **/
@Controller
@RequestMapping("/cms/front/article")
@ResponseBody
@Api("文章 - 前端显示")
public class ArticleFrontController {

    @Autowired
    private ArticleFrontService articleFrontService;

    @RequestMapping(value = "/get_home_list", method = RequestMethod.GET)
    @ApiOperation("获取首页文章列表")
    public Result<List<ArticleFrontHomeResDto>> getHomeList(@ModelAttribute ArticleFrontHomeListReqDto dto) throws
            BaseException {
        return articleFrontService.getHomeList(dto);
    }

    @RequestMapping(value = "/pageview/plus", method = RequestMethod.POST)
    @ApiOperation("增加阅读量")
    public Result<Boolean> getHomeList(@Validated @ModelAttribute ArticleCodeDto dto, BindingResult bindingResult) throws
            BaseException {
        BindingResultHandler.handleByException(bindingResult);
        return articleFrontService.doPageViewPlus(dto);
    }

    @RequestMapping(value = "/get_page", method = RequestMethod.GET)
    @ApiOperation("获取文章分页数据")
    public Result<PaginationSupport<ArticleFrontPageResDto>> getHomeList(@ModelAttribute ArticleFrontPageReqDto dto) throws
            BaseException {
        return articleFrontService.getPage(dto);
    }

    @RequestMapping(value = "/get_columns", method = RequestMethod.GET)
    @ApiOperation("获取栏目列表")
    public Result<List<ArticleColumnFrontListResDto>> getColumns() throws BaseException {
        return articleFrontService.getColumns();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation("获取文章详情")
    public Result<ArticleFrontDetailDto> get(@ModelAttribute ArticleFrontDetailReqDto dto) throws BaseException {
        return articleFrontService.get(dto);
    }

    @RequestMapping(value = "/column/get", method = RequestMethod.GET)
    @ApiOperation("获取文章栏目详情")
    public Result<ArticleFrontColumnDetailDto> get(@ModelAttribute ArticleFrontColumnDetailReqDto dto) throws BaseException {
        return articleFrontService.getColumnDetail(dto);
    }

}
