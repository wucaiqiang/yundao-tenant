package com.yundao.tenant.mapper.base.customer;

import com.yundao.tenant.model.base.customer.BaseTag;
import com.yundao.tenant.model.base.customer.BaseTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseTagMapper {
    int countByExample(BaseTagExample example);

    int deleteByExample(BaseTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseTag record);

    int insertSelective(BaseTag record);

    List<BaseTag> selectByExample(BaseTagExample example);

    BaseTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseTag record, @Param("example") BaseTagExample example);

    BaseTag selectOne(BaseTagExample example);

    int updateByExample(@Param("record") BaseTag record, @Param("example") BaseTagExample example);

    int updateByPrimaryKeySelective(BaseTag record);

    int updateByPrimaryKey(BaseTag record);
}