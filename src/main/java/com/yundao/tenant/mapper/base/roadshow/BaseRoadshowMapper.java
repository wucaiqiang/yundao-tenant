package com.yundao.tenant.mapper.base.roadshow;

import com.yundao.tenant.model.base.roadshow.BaseRoadshow;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoadshowMapper {
    int countByExample(BaseRoadshowExample example);

    int deleteByExample(BaseRoadshowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRoadshow record);

    int insertSelective(BaseRoadshow record);

    List<BaseRoadshow> selectByExample(BaseRoadshowExample example);

    BaseRoadshow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRoadshow record, @Param("example") BaseRoadshowExample example);

    BaseRoadshow selectOne(BaseRoadshowExample example);

    int updateByExample(@Param("record") BaseRoadshow record, @Param("example") BaseRoadshowExample example);

    int updateByPrimaryKeySelective(BaseRoadshow record);

    int updateByPrimaryKey(BaseRoadshow record);
}