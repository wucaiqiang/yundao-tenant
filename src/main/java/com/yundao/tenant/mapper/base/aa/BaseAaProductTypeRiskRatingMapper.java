package com.yundao.tenant.mapper.base.aa;

import com.yundao.tenant.model.base.aa.BaseAaProductTypeRiskRating;
import com.yundao.tenant.model.base.aa.BaseAaProductTypeRiskRatingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAaProductTypeRiskRatingMapper {
    int countByExample(BaseAaProductTypeRiskRatingExample example);

    int deleteByExample(BaseAaProductTypeRiskRatingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseAaProductTypeRiskRating record);

    int insertSelective(BaseAaProductTypeRiskRating record);

    List<BaseAaProductTypeRiskRating> selectByExample(BaseAaProductTypeRiskRatingExample example);

    BaseAaProductTypeRiskRating selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseAaProductTypeRiskRating record, @Param("example") BaseAaProductTypeRiskRatingExample example);

    BaseAaProductTypeRiskRating selectOne(BaseAaProductTypeRiskRatingExample example);

    int updateByExample(@Param("record") BaseAaProductTypeRiskRating record, @Param("example") BaseAaProductTypeRiskRatingExample example);

    int updateByPrimaryKeySelective(BaseAaProductTypeRiskRating record);

    int updateByPrimaryKey(BaseAaProductTypeRiskRating record);
}