package com.yundao.tenant.mapper.base.cms.product;

import com.yundao.tenant.model.base.cms.product.BaseProductRecommend;
import com.yundao.tenant.model.base.cms.product.BaseProductRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductRecommendMapper {
    int countByExample(BaseProductRecommendExample example);

    int deleteByExample(BaseProductRecommendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductRecommend record);

    int insertSelective(BaseProductRecommend record);

    List<BaseProductRecommend> selectByExample(BaseProductRecommendExample example);

    BaseProductRecommend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductRecommend record, @Param("example") BaseProductRecommendExample example);

    BaseProductRecommend selectOne(BaseProductRecommendExample example);

    int updateByExample(@Param("record") BaseProductRecommend record, @Param("example") BaseProductRecommendExample example);

    int updateByPrimaryKeySelective(BaseProductRecommend record);

    int updateByPrimaryKey(BaseProductRecommend record);
}