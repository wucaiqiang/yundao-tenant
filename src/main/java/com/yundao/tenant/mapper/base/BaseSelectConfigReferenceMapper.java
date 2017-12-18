package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSelectConfigReference;
import com.yundao.tenant.model.base.BaseSelectConfigReferenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSelectConfigReferenceMapper {
    int countByExample(BaseSelectConfigReferenceExample example);

    int deleteByExample(BaseSelectConfigReferenceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSelectConfigReference record);

    int insertSelective(BaseSelectConfigReference record);

    List<BaseSelectConfigReference> selectByExample(BaseSelectConfigReferenceExample example);

    BaseSelectConfigReference selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSelectConfigReference record, @Param("example") BaseSelectConfigReferenceExample example);

    BaseSelectConfigReference selectOne(BaseSelectConfigReferenceExample example);

    int updateByExample(@Param("record") BaseSelectConfigReference record, @Param("example") BaseSelectConfigReferenceExample example);

    int updateByPrimaryKeySelective(BaseSelectConfigReference record);

    int updateByPrimaryKey(BaseSelectConfigReference record);
}