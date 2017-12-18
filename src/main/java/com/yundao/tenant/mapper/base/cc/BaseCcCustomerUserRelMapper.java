package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRel;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcCustomerUserRelMapper {
    int countByExample(BaseCcCustomerUserRelExample example);

    int deleteByExample(BaseCcCustomerUserRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcCustomerUserRel record);

    int insertSelective(BaseCcCustomerUserRel record);

    List<BaseCcCustomerUserRel> selectByExample(BaseCcCustomerUserRelExample example);

    BaseCcCustomerUserRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcCustomerUserRel record, @Param("example") BaseCcCustomerUserRelExample example);

    BaseCcCustomerUserRel selectOne(BaseCcCustomerUserRelExample example);

    int updateByExample(@Param("record") BaseCcCustomerUserRel record, @Param("example") BaseCcCustomerUserRelExample example);

    int updateByPrimaryKeySelective(BaseCcCustomerUserRel record);

    int updateByPrimaryKey(BaseCcCustomerUserRel record);
}