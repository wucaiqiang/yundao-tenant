package com.yundao.tenant.mapper.base.cms.article;

import com.yundao.tenant.model.base.cms.article.BaseArticleDetail;
import com.yundao.tenant.model.base.cms.article.BaseArticleDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseArticleDetailMapper {
    int countByExample(BaseArticleDetailExample example);

    int deleteByExample(BaseArticleDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseArticleDetail record);

    int insertSelective(BaseArticleDetail record);

    List<BaseArticleDetail> selectByExampleWithBLOBs(BaseArticleDetailExample example);

    List<BaseArticleDetail> selectByExample(BaseArticleDetailExample example);

    BaseArticleDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseArticleDetail record, @Param("example") BaseArticleDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") BaseArticleDetail record, @Param("example") BaseArticleDetailExample example);

    BaseArticleDetail selectOne(BaseArticleDetailExample example);

    int updateByExample(@Param("record") BaseArticleDetail record, @Param("example") BaseArticleDetailExample example);

    int updateByPrimaryKeySelective(BaseArticleDetail record);

    int updateByPrimaryKeyWithBLOBs(BaseArticleDetail record);

    int updateByPrimaryKey(BaseArticleDetail record);
}