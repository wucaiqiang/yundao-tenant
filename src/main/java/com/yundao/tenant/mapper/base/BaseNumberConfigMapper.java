package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseNumberConfig;
import com.yundao.tenant.model.base.BaseNumberConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseNumberConfigMapper {
    int countByExample(BaseNumberConfigExample example);

    int deleteByExample(BaseNumberConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseNumberConfig record);

    int insertSelective(BaseNumberConfig record);

    List<BaseNumberConfig> selectByExample(BaseNumberConfigExample example);

    BaseNumberConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseNumberConfig record, @Param("example") BaseNumberConfigExample example);

    BaseNumberConfig selectOne(BaseNumberConfigExample example);

    int updateByExample(@Param("record") BaseNumberConfig record, @Param("example") BaseNumberConfigExample example);

    int updateByPrimaryKeySelective(BaseNumberConfig record);

    int updateByPrimaryKey(BaseNumberConfig record);
}