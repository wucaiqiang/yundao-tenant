package com.yundao.tenant.mapper.base.video;

import com.yundao.tenant.model.base.video.BaseVideo;
import com.yundao.tenant.model.base.video.BaseVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseVideoMapper {
    int countByExample(BaseVideoExample example);

    int deleteByExample(BaseVideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseVideo record);

    int insertSelective(BaseVideo record);

    List<BaseVideo> selectByExample(BaseVideoExample example);

    BaseVideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseVideo record, @Param("example") BaseVideoExample example);

    BaseVideo selectOne(BaseVideoExample example);

    int updateByExample(@Param("record") BaseVideo record, @Param("example") BaseVideoExample example);

    int updateByPrimaryKeySelective(BaseVideo record);

    int updateByPrimaryKey(BaseVideo record);
}