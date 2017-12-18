package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcLoginDetail;
import com.yundao.tenant.model.base.cc.BaseCcLoginDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcLoginDetailMapper {
    int countByExample(BaseCcLoginDetailExample example);

    int deleteByExample(BaseCcLoginDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcLoginDetail record);

    int insertSelective(BaseCcLoginDetail record);

    List<BaseCcLoginDetail> selectByExample(BaseCcLoginDetailExample example);

    BaseCcLoginDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcLoginDetail record, @Param("example") BaseCcLoginDetailExample example);

    BaseCcLoginDetail selectOne(BaseCcLoginDetailExample example);

    int updateByExample(@Param("record") BaseCcLoginDetail record, @Param("example") BaseCcLoginDetailExample example);

    int updateByPrimaryKeySelective(BaseCcLoginDetail record);

    int updateByPrimaryKey(BaseCcLoginDetail record);
}