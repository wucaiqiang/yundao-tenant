package com.yundao.tenant.service.cms.article.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.cms.article.*;
import com.yundao.tenant.dto.common.PermissionResultDto;
import com.yundao.tenant.dto.tenant.DomainNameModel;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.enums.cms.article.ArticleStatusEnum;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleColumnMapper;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleColumnRelMapper;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleDetailMapper;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleMapper;
import com.yundao.tenant.mapper.base.platform.BasePlatformMapper;
import com.yundao.tenant.mapper.cms.article.ArticleMapper;
import com.yundao.tenant.model.base.cms.article.*;
import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.service.cms.article.ArticleService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.platform.PlatformService;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.cms.ArticleUrlUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 文章服务实现
 *
 * @author jan
 * @create 2017-10-21 09:54
 **/
@Service
public class ArticleServiceImpl extends AbstractService implements ArticleService {

    private static Log log = LogFactory.getLog(ArticleServiceImpl.class);

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private BaseArticleMapper baseArticleMapper;

    @Autowired
    private BaseArticleColumnMapper baseArticleColumnMapper;

    @Autowired
    private BasePlatformMapper basePlatformMapper;

    @Override
    public Result<PaginationSupport<ArticlePageResDto>> getPage(ArticlePageReqDto dto) throws BaseException {
        String logPrefix = "文章||获取分页数据||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<ArticlePageResDto> page = PaginationSupport.newDefault(paramMap);
        List<ArticlePageResDto> dtos = articleMapper.selectPage(paramMap);
        if (BooleanUtils.isEmpty(dtos))
            return Result.newSuccessResult(page);
            //封装平台url
        heandlePlatformUrl(dtos);
        this.setText(dtos);
        this.setPageText(dtos);
        Integer count = articleMapper.selectPageCount(paramMap);
        page.setDatas(dtos);
        page.setTotalCount(count);
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(page);
    }

    private void heandlePlatformUrl(List<ArticlePageResDto> dtos) throws BaseException {
        StringBuilder platformCodes = new StringBuilder();
        for (ArticlePageResDto articlePageResDto : dtos) {
            platformCodes.append(",").append(articlePageResDto.getPlatformCode());
        }
        if(platformCodes.length() < 1){
            return;
        }
        Long tenantId = super.getHeaderTenantId();
        Map<String,Object> params = new HashMap<>();
        params.put("tenantId",tenantId);
        params.put("platformCodes",platformCodes.substring(1));
        Result<List<DomainNameModel>> result = HttpUtils.get(ScmUrlConstant.GET_DOMAIN_BYTP,params,new BaseTypeReference<Result<List<DomainNameModel>>>() {});
        if(result.getSuccess()){
            List<DomainNameModel> domainNameModels = result.getResult();
            if(domainNameModels != null && !domainNameModels.isEmpty()){
                //封装返回值
                for (ArticlePageResDto dto : dtos) {
                    for (DomainNameModel domainNameModel : domainNameModels) {
                        if(dto.getPlatformCode().equals(domainNameModel.getPlatformCode())){
                            dto.setPlatformUrl(domainNameModel.getUrl());
                        }
                    }
                }
            }
        }
    }

    private void setText(List<ArticlePageResDto> dtos) throws BaseException {
        for (ArticlePageResDto article : dtos) {
            article.setUrl(ArticleUrlUtils.generateUrl(article.getCode()));
            article.setStatusText(dictionaryService.toText(DicCode.DIC_ARTICLE_STATUS, article.getStatus()));
        }
    }

    private void setPageText(List<ArticlePageResDto> dtos) throws BaseException {
        List<Long> articleIds = LambdaMap.toSingleList(dtos, ArticlePageResDto::getId);
        List<ArticleColumnRelInfoDto> columnRelInfoDtos = articleMapper.selectArticleColumnRelInfo(articleIds);
        if (BooleanUtils.isEmpty(columnRelInfoDtos))
            return;
        //组合多个栏目信息
        for (ArticlePageResDto dto : dtos) {
            List<ArticleColumnRelInfoDto> relInfoDtos = LambdaFilter.toList(columnRelInfoDtos, m -> m.getId()
                    .equals(dto.getId()));
            if (BooleanUtils.isEmpty(relInfoDtos))
                continue;

            List<String> columnNames = LambdaMap.toSingleList(relInfoDtos, ArticleColumnRelInfoDto::getColumnName);
            String columnText = "";
            int index = 0;
            for (String columnName : columnNames) {
                index++;
                if (BooleanUtils.isNotBlank(columnName)) {
                    columnText += columnName;
                    if (index < columnNames.size())
                        columnText += ",";
                }
            }
            dto.setColumnName(columnText);
        }

    }

    @Autowired
    private BaseArticleColumnRelMapper baseArticleColumnRelMapper;

    @Autowired
    private BaseArticleDetailMapper baseArticleDetailMapper;

    @Override
    public Result<PermissionResultDto> delete(ArticleDeleteReqDto dto) throws BaseException {
        String logPrefix = "文章||删除||";
        log.info("%s 入参 %s", logPrefix, JsonUtils.objectToJson(dto));
        List<Long> ids = SymbolStrUtils.toLongWithTypeCheck(dto.getIds());
        if (BooleanUtils.isEmpty(ids))
            throw new BaseException(CodeConstant.CODE_1220142);

        BaseArticleExample example = new BaseArticleExample();
        example.createCriteria().andIdIn(ids);
        List<BaseArticle> articles = baseArticleMapper.selectByExample(example);
        log.info("%s articles %s", logPrefix, JsonUtils.objectToJson(articles));
        if (BooleanUtils.isEmpty(articles))
            throw new BaseException(CodeConstant.CODE_1220142);

        for (BaseArticle article : articles) {
            super.updateModel(article);
            article.setIsDelete(DeleteEnum.DELETED.getValue());
            baseArticleMapper.updateByPrimaryKey(article);
        }
        log.info("%s 完成", logPrefix);
        return Result.newSuccessResult(null);
    }

    @Override
    public Result<Long> add(ArticleAddReqDto dto) throws BaseException {
        BaseArticle article = new BaseArticle();
        BeanUtils.copyProperties(dto,article);
        Long userId = super.getHeaderUserId();
        Date now = new Date();
        article.setCreateUserId(userId);
        article.setUpdateUserId(userId);
        article.setCreateDate(now);
        article.setUpdateDate(now);
        if(dto.getStatus().equals(ArticleStatusEnum.ENABLE.getValue())){
            if(dto.getPublishDate() == null){
                throw new BaseException(GJLCodeConstant.CODE_1210121);
            }else if(DateUtils.getDistanceTimes(dto.getPublishDate(),now) > 0){
                dto.setPublishDate(now);
            }
        }
        article.setTenantId(super.getHeaderTenantId());
        baseArticleMapper.insertSelective(article);
        article.setCode(article.getId() + CommonConstant.BLANK);
        baseArticleMapper.updateByPrimaryKeySelective(article);
        //栏目的关联关系
        if(BooleanUtils.isNotEmpty(dto.getColumnIds())){
            relColumn(dto.getColumnIds(),article.getId());
        }
        //新增详情表
        BaseArticleDetail articleDetail = new BaseArticleDetail();
        articleDetail.setTenantId(super.getHeaderTenantId());
        articleDetail.setCreateDate(now);
        articleDetail.setCreateUserId(userId);
        articleDetail.setArticleId(article.getId());
        articleDetail.setAuthor(dto.getAuthor());
        articleDetail.setContent(dto.getContent());
        articleDetail.setSource(dto.getSource());
        articleDetail.setFeature(dto.getFeature());
        baseArticleDetailMapper.insertSelective(articleDetail);
        return Result.newSuccessResult(article.getId());
    }

    private void relColumn(String columnIds, Long id) {
        //清空关联关系
        BaseArticleColumnRelExample relExample = new BaseArticleColumnRelExample();
        relExample.createCriteria().andArticleIdEqualTo(id);
        baseArticleColumnRelMapper.deleteByExample(relExample);
        //新增关联关系
        if(BooleanUtils.isEmpty(columnIds)){
            return;
        }
        String[] arrIds = columnIds.split(CommonConstant.COMMA);
        BaseArticleColumnRel columnRel = new BaseArticleColumnRel();
        Date now = new Date();
        Long userId = super.getHeaderUserId();
        for (String arrId : arrIds) {
            columnRel.setId(null);
            columnRel.setArticleId(id);
            columnRel.setColumnId(Long.valueOf(arrId));
            columnRel.setCreateDate(now);
            columnRel.setCreateUserId(userId);
            baseArticleColumnRelMapper.insertSelective(columnRel);
        }
    }

    private void validate(String code,Long id) throws BaseException {
        BaseArticleExample articleExample = new BaseArticleExample();
        BaseArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andCodeEqualTo(code);
        if(id != null ){
            criteria.andIdEqualTo(id);
        }
        BaseArticle article = baseArticleMapper.selectOne(articleExample);
        if(article != null){
            throw new BaseException(GJLCodeConstant.CODE_1210115);
        }
    }

    @Override
    public Result<Long> update(ArticleUpdateReqDto dto) throws BaseException {
        BaseArticle article = baseArticleMapper.selectByPrimaryKey(dto.getId());
        if(article == null){
            throw new BaseException(GJLCodeConstant.CODE_1210114);
        }
        Date now = new Date();
        if(dto.getStatus().equals(ArticleStatusEnum.ENABLE.getValue())){
            if(dto.getPublishDate() == null){
                throw new BaseException(GJLCodeConstant.CODE_1210122);
            }else if(DateUtils.getDistanceTimes(dto.getPublishDate(),now) > 0){
                dto.setPublishDate(now);
            }
        }
        BeanUtils.copyProperties(dto,article);
        //更新
        Long userId = super.getHeaderUserId();
        article.setUpdateDate(now);
        article.setUpdateUserId(userId);
        baseArticleMapper.updateByPrimaryKey(article);
        relColumn(dto.getColumnIds(),dto.getId());
        //更新详情
        BaseArticleDetailExample articleDetailExample = new BaseArticleDetailExample();
        articleDetailExample.createCriteria().andArticleIdEqualTo(dto.getId());
        BaseArticleDetail articleDetail = baseArticleDetailMapper.selectOne(articleDetailExample);
        articleDetail.setFeature(dto.getFeature());
        articleDetail.setSource(dto.getSource());
        articleDetail.setContent(dto.getContent());
        articleDetail.setAuthor(dto.getAuthor());
        articleDetail.setUpdateDate(now);
        articleDetail.setUpdateUserId(userId);
        baseArticleDetailMapper.updateByPrimaryKeyWithBLOBs(articleDetail);
        return Result.newSuccessResult(dto.getId());
    }

    @Override
    public Result<ArticleDetailResDto> get(Long id) throws BaseException {
        if(id == null || id == 0){
            throw new BaseException(CodeConstant.CODE_1200000);
        }
        BaseArticle article = baseArticleMapper.selectByPrimaryKey(id);
        if(article == null){
            throw new BaseException(GJLCodeConstant.CODE_1210114);
        }
        BaseArticleDetailExample articleDetailExample = new BaseArticleDetailExample();
        articleDetailExample.createCriteria().andArticleIdEqualTo(id);
        List<BaseArticleDetail> articleDetails = baseArticleDetailMapper.selectByExampleWithBLOBs(articleDetailExample);
        ArticleDetailResDto articleDetailResDto = new ArticleDetailResDto();
        BeanUtils.copyProperties(article,articleDetailResDto);
        if(articleDetails != null && !articleDetails.isEmpty()){
            BaseArticleDetail articleDetail = articleDetails.get(0);
            articleDetailResDto.setArticleDetail(articleDetail);
        }

        //平台信息
        BasePlatform platform = basePlatformMapper.selectByPrimaryKey(article.getPlatformId());
        if(platform != null){
            articleDetailResDto.setPlatformName(platform.getName());
        }

        //栏目信息
        BaseArticleColumnRelExample articleColumnRelExample = new BaseArticleColumnRelExample();
        articleColumnRelExample.createCriteria().andArticleIdEqualTo(id);
        List<BaseArticleColumnRel> articleColumnRels = baseArticleColumnRelMapper.selectByExample(articleColumnRelExample);
        if(articleColumnRels != null && !articleColumnRels.isEmpty()){
            StringBuilder columns = new StringBuilder();
            List<Long> columnIds = new ArrayList<>();
            for (BaseArticleColumnRel articleColumnRel : articleColumnRels) {
                columns.append(CommonConstant.COMMA).append(articleColumnRel.getColumnId());
                columnIds.add(articleColumnRel.getColumnId());
            }
            articleDetailResDto.setColumnIds(columns.substring(com.yundao.core.constant.CommonConstant.ONE));
            //获取所有栏目
            BaseArticleColumnExample columnExample = new BaseArticleColumnExample();
            columnExample.createCriteria().andIdIn(columnIds);
            List<BaseArticleColumn> columnList = baseArticleColumnMapper.selectByExample(columnExample);
            StringBuilder columnName = new StringBuilder();
            for (BaseArticleColumn articleColumn : columnList) {
                columnName.append(CommonConstant.COMMA).append(articleColumn.getName());
            }
            if(columnName.length() > 0) {
                articleDetailResDto.setColumnName(columnName.substring(com.yundao.core.constant.CommonConstant.ONE));
            }
        }

        return Result.newSuccessResult(articleDetailResDto);
    }
}
