package com.yundao.tenant.mapper.base.roadshow;

import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumn;
import com.yundao.tenant.model.base.roadshow.BaseRoadshowColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseRoadshowColumnMapper {
    int countByExample(BaseRoadshowColumnExample example);

    int deleteByExample(BaseRoadshowColumnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseRoadshowColumn record);

    int insertSelective(BaseRoadshowColumn record);

    List<BaseRoadshowColumn> selectByExample(BaseRoadshowColumnExample example);

    BaseRoadshowColumn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseRoadshowColumn record, @Param("example") BaseRoadshowColumnExample example);

    BaseRoadshowColumn selectOne(BaseRoadshowColumnExample example);

    int updateByExample(@Param("record") BaseRoadshowColumn record, @Param("example") BaseRoadshowColumnExample example);

    int updateByPrimaryKeySelective(BaseRoadshowColumn record);

    int updateByPrimaryKey(BaseRoadshowColumn record);
}