package com.yundao.tenant.mapper.base.video;

import com.yundao.tenant.model.base.video.BaseVideoCategory;
import com.yundao.tenant.model.base.video.BaseVideoCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseVideoCategoryMapper {
    int countByExample(BaseVideoCategoryExample example);

    int deleteByExample(BaseVideoCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseVideoCategory record);

    int insertSelective(BaseVideoCategory record);

    List<BaseVideoCategory> selectByExample(BaseVideoCategoryExample example);

    BaseVideoCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseVideoCategory record, @Param("example") BaseVideoCategoryExample example);

    BaseVideoCategory selectOne(BaseVideoCategoryExample example);

    int updateByExample(@Param("record") BaseVideoCategory record, @Param("example") BaseVideoCategoryExample example);

    int updateByPrimaryKeySelective(BaseVideoCategory record);

    int updateByPrimaryKey(BaseVideoCategory record);
}