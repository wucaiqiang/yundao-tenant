package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseAppLogin;
import com.yundao.tenant.model.base.BaseAppLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAppLoginMapper {
    int countByExample(BaseAppLoginExample example);

    int deleteByExample(BaseAppLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseAppLogin record);

    int insertSelective(BaseAppLogin record);

    List<BaseAppLogin> selectByExample(BaseAppLoginExample example);

    BaseAppLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseAppLogin record, @Param("example") BaseAppLoginExample example);

    BaseAppLogin selectOne(BaseAppLoginExample example);

    int updateByExample(@Param("record") BaseAppLogin record, @Param("example") BaseAppLoginExample example);

    int updateByPrimaryKeySelective(BaseAppLogin record);

    int updateByPrimaryKey(BaseAppLogin record);
}