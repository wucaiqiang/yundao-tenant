package com.yundao.tenant.service.cms.article.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.cms.article.ArticleCodeDto;
import com.yundao.tenant.dto.cms.article.column.ArticleColumnFrontListResDto;
import com.yundao.tenant.dto.cms.article.front.*;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.enums.PlatformEnum;
import com.yundao.tenant.enums.cms.article.ArticleColumnStatusEnum;
import com.yundao.tenant.enums.cms.article.ArticleStatusEnum;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleColumnMapper;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleDetailMapper;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleMapper;
import com.yundao.tenant.mapper.cms.article.ArticleFrontMapper;
import com.yundao.tenant.model.base.cms.article.*;
import com.yundao.tenant.service.cms.article.ArticleColumnFrontService;
import com.yundao.tenant.service.cms.article.ArticleFrontService;
import com.yundao.tenant.service.cms.articlecolumn.ArticleColumnService;
import com.yundao.tenant.service.platform.PlatformService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.cms.ArticleUrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 前端文章服务实现
 *
 * @author jan
 * @create 2017-10-19 09:09
 **/
@Service
public class ArticleFrontServiceImpl implements ArticleFrontService {

    private static Log log = LogFactory.getLog(ArticleFrontServiceImpl.class);

    @Autowired
    private PlatformService platformService;

    @Autowired
    private ArticleColumnService articleColumnService;

    @Autowired
    private ArticleColumnFrontService articleColumnFrontService;

    @Autowired
    private ArticleFrontMapper articleFrontMapper;

    @Autowired
    private BaseArticleMapper baseArticleMapper;

    @Autowired
    private BaseArticleColumnMapper baseArticleColumnMapper;

    @Autowired
    private BaseArticleDetailMapper baseArticleDetailMapper;

    @Override
    public Result<List<ArticleFrontHomeResDto>> getHomeList(ArticleFrontHomeListReqDto dto) throws BaseException {
        String logPrefix = "前端文章||获取首页文章资讯||";
        final int defaultColumnCount = 3;
        final int defaultArticleCount = 4;
        int getColumnCount = dto.getColumnCount() == null ? defaultColumnCount : dto.getColumnCount();
        int getArticleCount = dto.getArticleCount() == null ? defaultArticleCount : dto.getArticleCount();

        List<BaseArticleColumn> columns = articleColumnService.getList(PlatformEnum.OFFICIAL_WEB_SITE.getCode(), getColumnCount);
        log.info("%s columns %s", logPrefix, JsonUtils.objectToJson(columns));
        if (BooleanUtils.isEmpty(columns))
            return Result.newSuccessResult(new ArrayList<>(1));


        List<ArticleFrontHomeResDto> dtos = new ArrayList<>();
        for (BaseArticleColumn column : columns) {
            ArticleFrontHomeResDto columnDto = new ArticleFrontHomeResDto();
            columnDto.setColumnId(column.getId());
            columnDto.setColumnName(column.getName());
            columnDto.setColumnCoverUrl(column.getCoverUrl());
            if (BooleanUtils.isNotBlank(column.getCode()))
                columnDto.setUrl(ArticleUrlUtils.generateColumnUrl(column.getCode()));

            List<ArticleFrontHomeListResDto> articles = articleFrontMapper.selectHomeArticles(column.getId(),
                    getArticleCount, PlatformEnum.OFFICIAL_WEB_SITE.getCode());
            if (BooleanUtils.isNotEmpty(articles)) {
                this.setTextForHomePage(articles);
                columnDto.getArticles().addAll(articles);
            }
            dtos.add(columnDto);
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(dtos);
    }

    @Override
    public Result<Boolean> doPageViewPlus(ArticleCodeDto dto) throws BaseException {
        String logPrefix = "前端文章||增加阅读量||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        BaseArticleExample example = new BaseArticleExample();
        example.createCriteria().andCodeEqualTo(dto.getCode()).andPublishDateLessThan(new Date());

        BaseArticle article = baseArticleMapper.selectOne(example);
        log.info("%s article %s", logPrefix, JsonUtils.objectToJson(article));

        if (article == null)
            throw new BaseException(CodeConstant.CODE_1220142);

        if (!ArticleStatusEnum.ENABLE.getValue().equals(article.getStatus())) {
            log.info("%s 文章状态异常", logPrefix);
            return Result.newSuccessResult(true);
        }
        Integer pvCount = article.getPageview() == null ? 0 : article.getPageview();
        Integer actualPvCount = article.getActualPageview() == null ? 0 : article.getActualPageview();
        article.setPageview(pvCount + 1);
        article.setActualPageview(actualPvCount + 1);
        baseArticleMapper.updateByPrimaryKey(article);
        return Result.newSuccessResult(true);
    }

    @Override
    public Result<PaginationSupport<ArticleFrontPageResDto>> getPage(ArticleFrontPageReqDto dto) throws BaseException {
        String logPrefix = "前端文章||获取文章列表||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        paramMap.put("platformCode", PlatformEnum.OFFICIAL_WEB_SITE.getCode());
        PaginationSupport<ArticleFrontPageResDto> page = PaginationSupport.newDefault(paramMap);
        List<ArticleFrontPageResDto> dtos = articleFrontMapper.selectPage(paramMap);
        for (ArticleFrontPageResDto article : dtos) {
            article.setUrl(ArticleUrlUtils.generateUrl(article.getCode()));
        }
        Integer count = articleFrontMapper.selectPageCount(paramMap);
        page.setDatas(dtos);
        page.setTotalCount(count);
        return Result.newSuccessResult(page);
    }

    @Override
    public Result<List<ArticleColumnFrontListResDto>> getColumns() throws BaseException {
        String logPrefix = "前端文章||获取栏目列表||";

        Long platformId = platformService.getId(PlatformEnum.OFFICIAL_WEB_SITE.getCode());
        log.info("%s platformId %s", logPrefix, platformId);

        BaseArticleColumnExample example = new BaseArticleColumnExample();
        example.createCriteria().andStatusEqualTo(ArticleColumnStatusEnum.ENABLE.getValue()).andPlatformIdEqualTo(platformId);
        example.setOrderByClause("sequence ASC,create_date DESC");
        List<BaseArticleColumn> columns = baseArticleColumnMapper.selectByExample(example);
        log.info("%s columns %s", logPrefix, JsonUtils.objectToJson(columns));
        List<ArticleColumnFrontListResDto> dtos = new ArrayList<>();
        if (BooleanUtils.isEmpty(columns))
            return Result.newSuccessResult(dtos);
        for (BaseArticleColumn column : columns) {
            ArticleColumnFrontListResDto dto = new ArticleColumnFrontListResDto();
            dto.setId(column.getId());
            dto.setCode(column.getCode());
            dto.setName(column.getName());
            dto.setUrl(ArticleUrlUtils.generateColumnUrl(column.getCode()));
            dtos.add(dto);
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(dtos);
    }

    @Override
    public Result<ArticleFrontDetailDto> get(ArticleFrontDetailReqDto dto) throws BaseException {
        String logPrefix = "前端文章||获取文章详情||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        if (BooleanUtils.isBlank(dto.getCode()))
            throw new BaseException(CodeConstant.CODE_1220142);

        BaseArticleExample example = new BaseArticleExample();
        example.createCriteria().andCodeEqualTo(dto.getCode().trim()).andStatusEqualTo(ArticleStatusEnum.ENABLE
                .getValue()).andPublishDateLessThan(new Date());
        BaseArticle article = baseArticleMapper.selectOne(example);
        log.info("%s article %s", logPrefix, JsonUtils.objectToJson(article));
        if (article == null)
            throw new BaseException(CodeConstant.CODE_1220142);

        ArticleFrontDetailDto result = new ArticleFrontDetailDto();
        result.setId(article.getId());
        result.setCode(article.getCode());
        result.setPageview(article.getPageview() == null ? article.getActualPageview() : article.getPageview());
        result.setPublishDate(DateUtils.format(article.getPublishDate(), DateUtils.YYYY_MM_DD_HH_MM));
        result.setTitle(article.getTitle());
        result.setSeoTitle(article.getSeoTitle());
        result.setSeoKeywords(article.getSeoKeywords());
        result.setSeoDescription(article.getSeoDescription());
        BaseArticleDetailExample detailExample = new BaseArticleDetailExample();
        detailExample.createCriteria().andArticleIdEqualTo(article.getId());
        List<BaseArticleDetail> details = baseArticleDetailMapper.selectByExampleWithBLOBs(detailExample);
        if (BooleanUtils.isNotEmpty(details)) {
            BaseArticleDetail detail = details.get(0);
            if (detail != null) {
                result.setSource(detail.getSource());
                result.setFeature(detail.getFeature());
                result.setAuthor(detail.getAuthor());
                result.setContent(detail.getContent());
            }
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<ArticleFrontColumnDetailDto> getColumnDetail(ArticleFrontColumnDetailReqDto dto) throws BaseException {
        String logPrefix = "前端文章||获取文章详情||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        ArticleFrontColumnDetailDto result = new ArticleFrontColumnDetailDto();
        result.setStatus(EnabledEnum.NOT_ENABLED.getValue());
        if (BooleanUtils.isBlank(dto.getCode()))
            return Result.newSuccessResult(result);

        BaseArticleColumn articleColumn = articleColumnFrontService.get(dto.getCode(), PlatformEnum.OFFICIAL_WEB_SITE
                .getCode());
        log.info("%s articleColumn %s", logPrefix, JsonUtils.objectToJson(articleColumn));
        if (articleColumn == null)
            return Result.newSuccessResult(result);

        result.setStatus(articleColumn.getStatus());
        result.setCode(articleColumn.getCode());
        result.setCoverUrl(articleColumn.getCoverUrl());
        result.setId(articleColumn.getId());
        result.setName(articleColumn.getName());
        result.setSequence(articleColumn.getSequence());
        result.setSeoTitle(articleColumn.getSeoTitle());
        result.setSeoKeywords(articleColumn.getSeoKeywords());
        result.setSeoDescription(articleColumn.getSeoDescription());
        result.setUrl(ArticleUrlUtils.generateColumnUrl(articleColumn.getCode()));
        return Result.newSuccessResult(result);
    }

    private void setTextForHomePage(List<ArticleFrontHomeListResDto> articles) {
        for (ArticleFrontHomeListResDto article : articles) {
            if (BooleanUtils.isNotBlank(article.getCode()))
                article.setUrl(ArticleUrlUtils.generateUrl(article.getCode()));
        }
    }

}
