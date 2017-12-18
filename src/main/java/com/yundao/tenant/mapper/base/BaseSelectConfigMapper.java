package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSelectConfig;
import com.yundao.tenant.model.base.BaseSelectConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSelectConfigMapper {
    int countByExample(BaseSelectConfigExample example);

    int deleteByExample(BaseSelectConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSelectConfig record);

    int insertSelective(BaseSelectConfig record);

    List<BaseSelectConfig> selectByExample(BaseSelectConfigExample example);

    BaseSelectConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSelectConfig record, @Param("example") BaseSelectConfigExample example);

    BaseSelectConfig selectOne(BaseSelectConfigExample example);

    int updateByExample(@Param("record") BaseSelectConfig record, @Param("example") BaseSelectConfigExample example);

    int updateByPrimaryKeySelective(BaseSelectConfig record);

    int updateByPrimaryKey(BaseSelectConfig record);
}