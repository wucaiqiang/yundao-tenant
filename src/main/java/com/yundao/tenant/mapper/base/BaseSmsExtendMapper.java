package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsExtend;
import com.yundao.tenant.model.base.BaseSmsExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsExtendMapper {
    int countByExample(BaseSmsExtendExample example);

    int deleteByExample(BaseSmsExtendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsExtend record);

    int insertSelective(BaseSmsExtend record);

    List<BaseSmsExtend> selectByExample(BaseSmsExtendExample example);

    BaseSmsExtend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsExtend record, @Param("example") BaseSmsExtendExample example);

    BaseSmsExtend selectOne(BaseSmsExtendExample example);

    int updateByExample(@Param("record") BaseSmsExtend record, @Param("example") BaseSmsExtendExample example);

    int updateByPrimaryKeySelective(BaseSmsExtend record);

    int updateByPrimaryKey(BaseSmsExtend record);
}