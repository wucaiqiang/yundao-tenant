package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsConf;
import com.yundao.tenant.model.base.BaseSmsConfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsConfMapper {
    int countByExample(BaseSmsConfExample example);

    int deleteByExample(BaseSmsConfExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsConf record);

    int insertSelective(BaseSmsConf record);

    List<BaseSmsConf> selectByExample(BaseSmsConfExample example);

    BaseSmsConf selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsConf record, @Param("example") BaseSmsConfExample example);

    BaseSmsConf selectOne(BaseSmsConfExample example);

    int updateByExample(@Param("record") BaseSmsConf record, @Param("example") BaseSmsConfExample example);

    int updateByPrimaryKeySelective(BaseSmsConf record);

    int updateByPrimaryKey(BaseSmsConf record);
}