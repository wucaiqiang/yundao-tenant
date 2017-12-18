package com.yundao.tenant.mapper.base.roadshow;

import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRel;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoadshowColumnRelMapper {
    int countByExample(BaseRoadshowColumnRelExample example);

    int deleteByExample(BaseRoadshowColumnRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRoadshowColumnRel record);

    int insertSelective(BaseRoadshowColumnRel record);

    List<BaseRoadshowColumnRel> selectByExample(BaseRoadshowColumnRelExample example);

    BaseRoadshowColumnRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRoadshowColumnRel record, @Param("example") BaseRoadshowColumnRelExample example);

    BaseRoadshowColumnRel selectOne(BaseRoadshowColumnRelExample example);

    int updateByExample(@Param("record") BaseRoadshowColumnRel record, @Param("example") BaseRoadshowColumnRelExample example);

    int updateByPrimaryKeySelective(BaseRoadshowColumnRel record);

    int updateByPrimaryKey(BaseRoadshowColumnRel record);
}