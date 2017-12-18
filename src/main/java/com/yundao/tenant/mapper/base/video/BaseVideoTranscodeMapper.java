package com.yundao.tenant.mapper.base.video;

import com.yundao.tenant.model.base.video.BaseVideoTranscode;
import com.yundao.tenant.model.base.video.BaseVideoTranscodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseVideoTranscodeMapper {
    int countByExample(BaseVideoTranscodeExample example);

    int deleteByExample(BaseVideoTranscodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseVideoTranscode record);

    int insertSelective(BaseVideoTranscode record);

    List<BaseVideoTranscode> selectByExample(BaseVideoTranscodeExample example);

    BaseVideoTranscode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseVideoTranscode record, @Param("example") BaseVideoTranscodeExample example);

    BaseVideoTranscode selectOne(BaseVideoTranscodeExample example);

    int updateByExample(@Param("record") BaseVideoTranscode record, @Param("example") BaseVideoTranscodeExample example);

    int updateByPrimaryKeySelective(BaseVideoTranscode record);

    int updateByPrimaryKey(BaseVideoTranscode record);
}