package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUserSystem;
import com.yundao.tenant.model.base.BaseUserSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserSystemMapper {
    int countByExample(BaseUserSystemExample example);

    int deleteByExample(BaseUserSystemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserSystem record);

    int insertSelective(BaseUserSystem record);

    List<BaseUserSystem> selectByExample(BaseUserSystemExample example);

    BaseUserSystem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserSystem record, @Param("example") BaseUserSystemExample example);

    BaseUserSystem selectOne(BaseUserSystemExample example);

    int updateByExample(@Param("record") BaseUserSystem record, @Param("example") BaseUserSystemExample example);

    int updateByPrimaryKeySelective(BaseUserSystem record);

    int updateByPrimaryKey(BaseUserSystem record);
}