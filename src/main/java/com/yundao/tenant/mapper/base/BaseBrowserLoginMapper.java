package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseBrowserLogin;
import com.yundao.tenant.model.base.BaseBrowserLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseBrowserLoginMapper {
    int countByExample(BaseBrowserLoginExample example);

    int deleteByExample(BaseBrowserLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseBrowserLogin record);

    int insertSelective(BaseBrowserLogin record);

    List<BaseBrowserLogin> selectByExample(BaseBrowserLoginExample example);

    BaseBrowserLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseBrowserLogin record, @Param("example") BaseBrowserLoginExample example);

    BaseBrowserLogin selectOne(BaseBrowserLoginExample example);

    int updateByExample(@Param("record") BaseBrowserLogin record, @Param("example") BaseBrowserLoginExample example);

    int updateByPrimaryKeySelective(BaseBrowserLogin record);

    int updateByPrimaryKey(BaseBrowserLogin record);
}