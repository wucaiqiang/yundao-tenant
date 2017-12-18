package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDictionary;
import com.yundao.tenant.model.base.BaseDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDictionaryMapper {
    int countByExample(BaseDictionaryExample example);

    int deleteByExample(BaseDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDictionary record);

    int insertSelective(BaseDictionary record);

    List<BaseDictionary> selectByExample(BaseDictionaryExample example);

    BaseDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDictionary record, @Param("example") BaseDictionaryExample example);

    BaseDictionary selectOne(BaseDictionaryExample example);

    int updateByExample(@Param("record") BaseDictionary record, @Param("example") BaseDictionaryExample example);

    int updateByPrimaryKeySelective(BaseDictionary record);

    int updateByPrimaryKey(BaseDictionary record);
}