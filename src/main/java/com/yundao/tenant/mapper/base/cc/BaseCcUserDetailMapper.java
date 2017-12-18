package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcUserDetail;
import com.yundao.tenant.model.base.cc.BaseCcUserDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcUserDetailMapper {
    int countByExample(BaseCcUserDetailExample example);

    int deleteByExample(BaseCcUserDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcUserDetail record);

    int insertSelective(BaseCcUserDetail record);

    List<BaseCcUserDetail> selectByExample(BaseCcUserDetailExample example);

    BaseCcUserDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcUserDetail record, @Param("example") BaseCcUserDetailExample example);

    BaseCcUserDetail selectOne(BaseCcUserDetailExample example);

    int updateByExample(@Param("record") BaseCcUserDetail record, @Param("example") BaseCcUserDetailExample example);

    int updateByPrimaryKeySelective(BaseCcUserDetail record);

    int updateByPrimaryKey(BaseCcUserDetail record);
}