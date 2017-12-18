package com.yundao.tenant.mapper.base.sys;

import com.yundao.tenant.model.base.sys.BaseSysConfig;
import com.yundao.tenant.model.base.sys.BaseSysConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSysConfigMapper {
    int countByExample(BaseSysConfigExample example);

    int deleteByExample(BaseSysConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSysConfig record);

    int insertSelective(BaseSysConfig record);

    List<BaseSysConfig> selectByExample(BaseSysConfigExample example);

    BaseSysConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSysConfig record, @Param("example") BaseSysConfigExample example);

    BaseSysConfig selectOne(BaseSysConfigExample example);

    int updateByExample(@Param("record") BaseSysConfig record, @Param("example") BaseSysConfigExample example);

    int updateByPrimaryKeySelective(BaseSysConfig record);

    int updateByPrimaryKey(BaseSysConfig record);
}