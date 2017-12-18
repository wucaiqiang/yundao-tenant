package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseTypeProperty;
import com.yundao.tenant.model.base.BaseTypePropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseTypePropertyMapper {
    int countByExample(BaseTypePropertyExample example);

    int deleteByExample(BaseTypePropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseTypeProperty record);

    int insertSelective(BaseTypeProperty record);

    List<BaseTypeProperty> selectByExample(BaseTypePropertyExample example);

    BaseTypeProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseTypeProperty record, @Param("example") BaseTypePropertyExample example);

    BaseTypeProperty selectOne(BaseTypePropertyExample example);

    int updateByExample(@Param("record") BaseTypeProperty record, @Param("example") BaseTypePropertyExample example);

    int updateByPrimaryKeySelective(BaseTypeProperty record);

    int updateByPrimaryKey(BaseTypeProperty record);
}