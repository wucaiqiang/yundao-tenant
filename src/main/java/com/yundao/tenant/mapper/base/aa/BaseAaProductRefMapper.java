package com.yundao.tenant.mapper.base.aa;

import com.yundao.tenant.model.base.aa.BaseAaProductRef;
import com.yundao.tenant.model.base.aa.BaseAaProductRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAaProductRefMapper {
    int countByExample(BaseAaProductRefExample example);

    int deleteByExample(BaseAaProductRefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseAaProductRef record);

    int insertSelective(BaseAaProductRef record);

    List<BaseAaProductRef> selectByExample(BaseAaProductRefExample example);

    BaseAaProductRef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseAaProductRef record, @Param("example") BaseAaProductRefExample example);

    BaseAaProductRef selectOne(BaseAaProductRefExample example);

    int updateByExample(@Param("record") BaseAaProductRef record, @Param("example") BaseAaProductRefExample example);

    int updateByPrimaryKeySelective(BaseAaProductRef record);

    int updateByPrimaryKey(BaseAaProductRef record);
}