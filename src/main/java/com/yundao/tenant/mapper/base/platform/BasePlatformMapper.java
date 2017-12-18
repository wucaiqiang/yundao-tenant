package com.yundao.tenant.mapper.base.platform;

import com.yundao.tenant.model.base.platform.BasePlatform;
import com.yundao.tenant.model.base.platform.BasePlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasePlatformMapper {
    int countByExample(BasePlatformExample example);

    int deleteByExample(BasePlatformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BasePlatform record);

    int insertSelective(BasePlatform record);

    List<BasePlatform> selectByExample(BasePlatformExample example);

    BasePlatform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BasePlatform record, @Param("example") BasePlatformExample example);

    BasePlatform selectOne(BasePlatformExample example);

    int updateByExample(@Param("record") BasePlatform record, @Param("example") BasePlatformExample example);

    int updateByPrimaryKeySelective(BasePlatform record);

    int updateByPrimaryKey(BasePlatform record);
}