package com.yundao.tenant.service.cms.articlecolumn.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.Limit;
import com.yundao.tenant.constant.CommonConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cms.articlecolumn.*;
import com.yundao.tenant.dto.tenant.DomainNameModel;
import com.yundao.tenant.enums.EnabledEnum;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleColumnMapper;
import com.yundao.tenant.mapper.base.cms.article.BaseArticleColumnRelMapper;
import com.yundao.tenant.mapper.base.platform.BasePlatformMapper;
import com.yundao.tenant.mapper.cms.articlecolumn.ArticleColumnMapper;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumn;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumnExample;
import com.yundao.tenant.model.base.cms.article.BaseArticleColumnRelExample;
import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.service.cms.articlecolumn.ArticleColumnService;
import com.yundao.tenant.util.DateUtil;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleColumnServiceImpl extends AbstractService implements ArticleColumnService {

    @Autowired
    private BaseArticleColumnMapper baseArticleColumnMapper;

    @Autowired
    private ArticleColumnMapper articleColumnMapper;

    @Autowired
    private BasePlatformMapper basePlatformMapper;

    @Autowired
    private BaseArticleColumnRelMapper baseArticleColumnRelMapper;

    public Result<Long> add(ArticleColumnReqDto reqDto) throws Exception {
        validateAdd(reqDto);
        BaseArticleColumn model = new BaseArticleColumn();
        BeanUtils.copyProperties(reqDto, model);
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setTenantId(super.getHeaderTenantId());
        model.setId(null);
        baseArticleColumnMapper.insertSelective(model);
        return Result.newSuccessResult(model.getId());
    }

    private void validateAdd(ArticleColumnReqDto reqDto) throws BaseException {
        validatePlat(reqDto.getPlatformId());

        BaseArticleColumnExample baseArticleColumnExample = new BaseArticleColumnExample();
        BaseArticleColumnExample.Criteria criteria = baseArticleColumnExample.createCriteria();
        //栏目名称唯一
        criteria.andNameEqualTo(reqDto.getName());
        criteria.andPlatformIdEqualTo(reqDto.getPlatformId());
        BaseArticleColumn articleColumn = baseArticleColumnMapper.selectOne(baseArticleColumnExample);
        if (articleColumn != null) {
            throw new BaseException(GJLCodeConstant.CODE_1210108);
        }
        //url唯一
        baseArticleColumnExample = new BaseArticleColumnExample();
        criteria = baseArticleColumnExample.createCriteria();
        criteria.andCodeEqualTo(reqDto.getCode());
        articleColumn = baseArticleColumnMapper.selectOne(baseArticleColumnExample);
        if (articleColumn != null) {
            throw new BaseException(GJLCodeConstant.CODE_1210109);
        }
    }

    private void validatePlat(Long platformId) throws BaseException {
        BasePlatform platform = basePlatformMapper.selectByPrimaryKey(platformId);
        if (platform == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210110);
        }
    }

    public Result<Integer> update(ArticleColumnUPReqDto reqDto) throws Exception {
        validateUP(reqDto);
        BaseArticleColumn model = new BaseArticleColumn();
        BeanUtils.copyProperties(reqDto, model);
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseArticleColumnMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(count);
    }

    private void validateUP(ArticleColumnUPReqDto reqDto) throws BaseException {
        BaseArticleColumn baseArticleColumn = baseArticleColumnMapper.selectByPrimaryKey(reqDto.getId());
        if(baseArticleColumn == null){
            throw new BaseException(GJLCodeConstant.CODE_1210123);
        }
        BaseArticleColumnExample baseArticleColumnExample = new BaseArticleColumnExample();
        BaseArticleColumnExample.Criteria criteria = baseArticleColumnExample.createCriteria();
        //栏目名称唯一
        criteria.andNameEqualTo(reqDto.getName());
        criteria.andPlatformIdEqualTo(baseArticleColumn.getPlatformId());
        criteria.andIdNotEqualTo(reqDto.getId());
        BaseArticleColumn articleColumn = baseArticleColumnMapper.selectOne(baseArticleColumnExample);
        if (articleColumn != null) {
            throw new BaseException(GJLCodeConstant.CODE_1210108);
        }
    }

    public Result<Integer> delete(String ids) throws Exception {
        String[] arrIds = ids.split(CommonConstant.COMMA);
        List<Long> idList = new ArrayList<>();
        for (String arrId : arrIds) {
            idList.add(Long.valueOf(arrId));
        }
        BaseArticleColumnExample articleColumnExample = new BaseArticleColumnExample();
        articleColumnExample.createCriteria().andIdIn(idList);
        BaseArticleColumn articleColumn = new BaseArticleColumn();
        articleColumn.setIsDelete(com.yundao.core.constant.CommonConstant.ONE);
        articleColumn.setUpdateDate(new Date());
        articleColumn.setUpdateUserId(super.getHeaderUserId());
        int count = baseArticleColumnMapper.updateByExampleSelective(articleColumn, articleColumnExample);
        //去除对应的关联关系
        BaseArticleColumnRelExample articleColumnRelExample = new BaseArticleColumnRelExample();
        articleColumnRelExample.createCriteria().andColumnIdIn(idList);
        baseArticleColumnRelMapper.deleteByExample(articleColumnRelExample);
        return Result.newSuccessResult(count);
    }

    public Result<BaseArticleColumn> get(Long id) throws Exception {
        BaseArticleColumn model = baseArticleColumnMapper.selectByPrimaryKey(id);
        return Result.newSuccessResult(model);
    }

    @Override
    public Result<PaginationSupport<ArticleColumnPageResDto>> getPage(ArticleColumnPageReqDto articleColumnReqDto, AbstractBasePageDto pageDto) throws Exception {
        Map<String, Object> params = LocalBeanUtils.toMap(articleColumnReqDto);
        String orderBy = "sequence asc,create_date desc";
        if (pageDto.getOrderColumn() != null || pageDto.getSort() != null) {
            orderBy = pageDto.getOrderColumn() + " " + pageDto.getSort();
        }
        if (BooleanUtils.isNotEmpty(articleColumnReqDto.getPlatformIds())) {
            params.put("platformIds", articleColumnReqDto.getPlatformIds().replace(",", "','"));
        }
        if (articleColumnReqDto.getHandlerDateEnd() != null) {
            params.put("handlerDateEnd", DateUtil.toEndDate(articleColumnReqDto.getHandlerDateEnd()));
        }
        params.putAll(LocalBeanUtils.toMap(pageDto));
        params.put("order", orderBy);
        PaginationSupport<ArticleColumnPageResDto> pager = PaginationSupport.newDefault(params);
        int totalCount = articleColumnMapper.queryPageCount(params);
        if (totalCount > 0) {
            List<ArticleColumnPageResDto> list = articleColumnMapper.queryPageInfo(params);
            pager.setDatas(list);
            handlerPlatformUrl(list);
        }
        pager.setTotalCount(totalCount);
        return Result.newSuccessResult(pager);
    }

    private void handlerPlatformUrl(List<ArticleColumnPageResDto> list) throws BaseException {
        StringBuilder platformCodes = new StringBuilder();
        for (ArticleColumnPageResDto dto : list) {
            platformCodes.append(",").append(dto.getPlatformCode());
        }
        if (platformCodes.length() > 0) {
            String platformArr = platformCodes.substring(1);
            Map<String, Object> params = new HashMap<>();
            params.put("platformCodes", platformArr);
            params.put("tenantId", super.getHeaderTenantId());
            Result<List<DomainNameModel>> result = HttpUtils.get(ScmUrlConstant.GET_DOMAIN_BYTP, params, new BaseTypeReference<Result<List<DomainNameModel>>>() {
            });
            if (result.getSuccess()) {
                List<DomainNameModel> domainNameModels = result.getResult();
                if (domainNameModels != null && !domainNameModels.isEmpty()) {
                    //封装返回值
                    for (ArticleColumnPageResDto dto : list) {
                        for (DomainNameModel domainNameModel : domainNameModels) {
                            if (dto.getPlatformCode().equals(domainNameModel.getPlatformCode())) {
                                dto.setPlatformUrl(domainNameModel.getUrl());
                            }
                        }
                    }
                }
            }
        }
    }

    public Result<PaginationSupport<BaseArticleColumn>> getPageOld(ArticleColumnPageReqDto articleColumnReqDto, AbstractBasePageDto pageDto) throws Exception {
        BaseArticleColumnExample baseArticleColumnExample = new BaseArticleColumnExample().setLimit(Limit.buildLimit(pageDto.getCurrentPage(), pageDto.getPageSize()));
        BaseArticleColumnExample.Criteria criteria = baseArticleColumnExample.createCriteria();
        String orderByClause = "create_date desc";
        if (StringUtils.isNotBlank(pageDto.getOrderColumn())) {
            StringBuilder orderBuider = new StringBuilder();
            orderBuider.append(pageDto.getOrderColumn()).append(" ");
            if (StringUtils.isNotBlank(pageDto.getSort())) {
                orderBuider.append(pageDto.getSort());
            } else {
                orderBuider.append("desc");
            }
            orderByClause = orderBuider.toString();
        }
        baseArticleColumnExample.setOrderByClause(orderByClause);
        if (BooleanUtils.isEmpty(articleColumnReqDto.getName())) {
            criteria.andNameLike(articleColumnReqDto.getName());
        }

        List<BaseArticleColumn> list = baseArticleColumnMapper.selectByExample(baseArticleColumnExample);
        int totalCount = baseArticleColumnMapper.countByExample(baseArticleColumnExample);
        PaginationSupport<BaseArticleColumn> result = pageDto.getPaginationSupport();
        result.setDatas(list);
        result.setTotalCount(totalCount);
        return Result.newSuccessResult(result);
    }

    @Override
    public Result<Integer> updateStatus(Long id, Integer status) throws BaseException {
        BaseArticleColumn articleColumn = baseArticleColumnMapper.selectByPrimaryKey(id);
        if (articleColumn == null) {
            throw new BaseException(GJLCodeConstant.CODE_1210101);
        }
        articleColumn.setStatus(status);
        articleColumn.setUpdateDate(new Date());
        articleColumn.setUpdateUserId(super.getHeaderUserId());
        baseArticleColumnMapper.updateByPrimaryKeySelective(articleColumn);
        return Result.newSuccessResult(1);
    }

    @Override
    public Result<List<ArticleColumnSelectDto>> getSelectOption(Long platformId) throws BaseException {
        List<ArticleColumnSelectDto> dtos = new ArrayList<>();
        if (platformId == null)
            return Result.newSuccessResult(dtos);

        BasePlatform platform = basePlatformMapper.selectByPrimaryKey(platformId);
        if (platform == null || platform.getIsEnabled() == null || !platform.getIsEnabled().equals(EnabledEnum
                .ENABLED.getValue()))
            return Result.newSuccessResult(dtos);

        BaseArticleColumnExample example = new BaseArticleColumnExample();
        example.createCriteria().andPlatformIdEqualTo(platformId);
        List<BaseArticleColumn> articleColumns = baseArticleColumnMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(articleColumns))
            return Result.newSuccessResult(dtos);

        dtos = LocalBeanUtils.copyPropertiesList(articleColumns, ArticleColumnSelectDto.class);
        return Result.newSuccessResult(dtos);
    }

    @Override
    public List<BaseArticleColumn> getList(String platformCode, Integer count) throws BaseException {
        return articleColumnMapper.selectList(platformCode, count);
    }

}
