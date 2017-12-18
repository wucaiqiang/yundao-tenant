package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseFieldGroupRel;
import com.yundao.tenant.model.base.BaseFieldGroupRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseFieldGroupRelMapper {
    int countByExample(BaseFieldGroupRelExample example);

    int deleteByExample(BaseFieldGroupRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseFieldGroupRel record);

    int insertSelective(BaseFieldGroupRel record);

    List<BaseFieldGroupRel> selectByExample(BaseFieldGroupRelExample example);

    BaseFieldGroupRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseFieldGroupRel record, @Param("example") BaseFieldGroupRelExample example);

    BaseFieldGroupRel selectOne(BaseFieldGroupRelExample example);

    int updateByExample(@Param("record") BaseFieldGroupRel record, @Param("example") BaseFieldGroupRelExample example);

    int updateByPrimaryKeySelective(BaseFieldGroupRel record);

    int updateByPrimaryKey(BaseFieldGroupRel record);
}