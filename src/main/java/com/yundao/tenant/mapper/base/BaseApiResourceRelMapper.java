package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseApiResourceRel;
import com.yundao.tenant.model.base.BaseApiResourceRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseApiResourceRelMapper {
    int countByExample(BaseApiResourceRelExample example);

    int deleteByExample(BaseApiResourceRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseApiResourceRel record);

    int insertSelective(BaseApiResourceRel record);

    List<BaseApiResourceRel> selectByExample(BaseApiResourceRelExample example);

    BaseApiResourceRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseApiResourceRel record, @Param("example") BaseApiResourceRelExample example);

    BaseApiResourceRel selectOne(BaseApiResourceRelExample example);

    int updateByExample(@Param("record") BaseApiResourceRel record, @Param("example") BaseApiResourceRelExample example);

    int updateByPrimaryKeySelective(BaseApiResourceRel record);

    int updateByPrimaryKey(BaseApiResourceRel record);
}