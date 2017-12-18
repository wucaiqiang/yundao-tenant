package com.yundao.tenant.mapper.base.platform;

import com.yundao.tenant.model.base.platform.BasePlatformPositionRef;
import com.yundao.tenant.model.base.platform.BasePlatformPositionRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasePlatformPositionRefMapper {
    int countByExample(BasePlatformPositionRefExample example);

    int deleteByExample(BasePlatformPositionRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BasePlatformPositionRef record);

    int insertSelective(BasePlatformPositionRef record);

    List<BasePlatformPositionRef> selectByExample(BasePlatformPositionRefExample example);

    BasePlatformPositionRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BasePlatformPositionRef record, @Param("example") BasePlatformPositionRefExample example);

    BasePlatformPositionRef selectOne(BasePlatformPositionRefExample example);

    int updateByExample(@Param("record") BasePlatformPositionRef record, @Param("example") BasePlatformPositionRefExample example);

    int updateByPrimaryKeySelective(BasePlatformPositionRef record);

    int updateByPrimaryKey(BasePlatformPositionRef record);
}