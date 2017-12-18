package com.yundao.tenant.mapper.base.platform;

import com.yundao.tenant.model.base.platform.BasePosition;
import com.yundao.tenant.model.base.platform.BasePositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasePositionMapper {
    int countByExample(BasePositionExample example);

    int deleteByExample(BasePositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BasePosition record);

    int insertSelective(BasePosition record);

    List<BasePosition> selectByExample(BasePositionExample example);

    BasePosition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BasePosition record, @Param("example") BasePositionExample example);

    BasePosition selectOne(BasePositionExample example);

    int updateByExample(@Param("record") BasePosition record, @Param("example") BasePositionExample example);

    int updateByPrimaryKeySelective(BasePosition record);

    int updateByPrimaryKey(BasePosition record);
}