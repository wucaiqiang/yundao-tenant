package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcLogin;
import com.yundao.tenant.model.base.cc.BaseCcLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcLoginMapper {
    int countByExample(BaseCcLoginExample example);

    int deleteByExample(BaseCcLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcLogin record);

    int insertSelective(BaseCcLogin record);

    List<BaseCcLogin> selectByExample(BaseCcLoginExample example);

    BaseCcLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcLogin record, @Param("example") BaseCcLoginExample example);

    BaseCcLogin selectOne(BaseCcLoginExample example);

    int updateByExample(@Param("record") BaseCcLogin record, @Param("example") BaseCcLoginExample example);

    int updateByPrimaryKeySelective(BaseCcLogin record);

    int updateByPrimaryKey(BaseCcLogin record);
}