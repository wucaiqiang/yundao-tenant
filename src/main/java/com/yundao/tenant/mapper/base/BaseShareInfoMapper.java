package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseShareInfo;
import com.yundao.tenant.model.base.BaseShareInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseShareInfoMapper {
    int countByExample(BaseShareInfoExample example);

    int deleteByExample(BaseShareInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseShareInfo record);

    int insertSelective(BaseShareInfo record);

    List<BaseShareInfo> selectByExample(BaseShareInfoExample example);

    BaseShareInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseShareInfo record, @Param("example") BaseShareInfoExample example);

    BaseShareInfo selectOne(BaseShareInfoExample example);

    int updateByExample(@Param("record") BaseShareInfo record, @Param("example") BaseShareInfoExample example);

    int updateByPrimaryKeySelective(BaseShareInfo record);

    int updateByPrimaryKey(BaseShareInfo record);
}