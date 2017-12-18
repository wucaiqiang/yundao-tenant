package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.BaseUserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserDetailMapper {
    int countByExample(BaseUserDetailExample example);

    int deleteByExample(BaseUserDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserDetail record);

    int insertSelective(BaseUserDetail record);

    List<BaseUserDetail> selectByExample(BaseUserDetailExample example);

    BaseUserDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserDetail record, @Param("example") BaseUserDetailExample example);

    BaseUserDetail selectOne(BaseUserDetailExample example);

    int updateByExample(@Param("record") BaseUserDetail record, @Param("example") BaseUserDetailExample example);

    int updateByPrimaryKeySelective(BaseUserDetail record);

    int updateByPrimaryKey(BaseUserDetail record);
}