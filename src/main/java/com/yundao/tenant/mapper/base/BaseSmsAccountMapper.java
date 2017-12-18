package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsAccount;
import com.yundao.tenant.model.base.BaseSmsAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsAccountMapper {
    int countByExample(BaseSmsAccountExample example);

    int deleteByExample(BaseSmsAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsAccount record);

    int insertSelective(BaseSmsAccount record);

    List<BaseSmsAccount> selectByExample(BaseSmsAccountExample example);

    BaseSmsAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsAccount record, @Param("example") BaseSmsAccountExample example);

    BaseSmsAccount selectOne(BaseSmsAccountExample example);

    int updateByExample(@Param("record") BaseSmsAccount record, @Param("example") BaseSmsAccountExample example);

    int updateByPrimaryKeySelective(BaseSmsAccount record);

    int updateByPrimaryKey(BaseSmsAccount record);
}