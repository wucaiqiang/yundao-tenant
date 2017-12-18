package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcUserAccount;
import com.yundao.tenant.model.base.cc.BaseCcUserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcUserAccountMapper {
    int countByExample(BaseCcUserAccountExample example);

    int deleteByExample(BaseCcUserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcUserAccount record);

    int insertSelective(BaseCcUserAccount record);

    List<BaseCcUserAccount> selectByExample(BaseCcUserAccountExample example);

    BaseCcUserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcUserAccount record, @Param("example") BaseCcUserAccountExample example);

    BaseCcUserAccount selectOne(BaseCcUserAccountExample example);

    int updateByExample(@Param("record") BaseCcUserAccount record, @Param("example") BaseCcUserAccountExample example);

    int updateByPrimaryKeySelective(BaseCcUserAccount record);

    int updateByPrimaryKey(BaseCcUserAccount record);
}