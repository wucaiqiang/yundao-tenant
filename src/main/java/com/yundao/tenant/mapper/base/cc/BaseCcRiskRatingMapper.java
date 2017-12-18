package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.model.base.cc.BaseCcRiskRatingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcRiskRatingMapper {
    int countByExample(BaseCcRiskRatingExample example);

    int deleteByExample(BaseCcRiskRatingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcRiskRating record);

    int insertSelective(BaseCcRiskRating record);

    List<BaseCcRiskRating> selectByExample(BaseCcRiskRatingExample example);

    BaseCcRiskRating selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcRiskRating record, @Param("example") BaseCcRiskRatingExample example);

    BaseCcRiskRating selectOne(BaseCcRiskRatingExample example);

    int updateByExample(@Param("record") BaseCcRiskRating record, @Param("example") BaseCcRiskRatingExample example);

    int updateByPrimaryKeySelective(BaseCcRiskRating record);

    int updateByPrimaryKey(BaseCcRiskRating record);
}