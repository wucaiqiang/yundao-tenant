package com.yundao.tenant.mapper.base.roadshow;

import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRel;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowProductRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoadshowProductRelMapper {
    int countByExample(BaseRoadshowProductRelExample example);

    int deleteByExample(BaseRoadshowProductRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRoadshowProductRel record);

    int insertSelective(BaseRoadshowProductRel record);

    List<BaseRoadshowProductRel> selectByExample(BaseRoadshowProductRelExample example);

    BaseRoadshowProductRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRoadshowProductRel record, @Param("example") BaseRoadshowProductRelExample example);

    BaseRoadshowProductRel selectOne(BaseRoadshowProductRelExample example);

    int updateByExample(@Param("record") BaseRoadshowProductRel record, @Param("example") BaseRoadshowProductRelExample example);

    int updateByPrimaryKeySelective(BaseRoadshowProductRel record);

    int updateByPrimaryKey(BaseRoadshowProductRel record);
}