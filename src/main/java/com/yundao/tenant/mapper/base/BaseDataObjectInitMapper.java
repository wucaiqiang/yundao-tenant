package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseDataObjectInit;
import com.yundao.tenant.model.base.BaseDataObjectInitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDataObjectInitMapper {
    int countByExample(BaseDataObjectInitExample example);

    int deleteByExample(BaseDataObjectInitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDataObjectInit record);

    int insertSelective(BaseDataObjectInit record);

    List<BaseDataObjectInit> selectByExample(BaseDataObjectInitExample example);

    BaseDataObjectInit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDataObjectInit record, @Param("example") BaseDataObjectInitExample example);

    BaseDataObjectInit selectOne(BaseDataObjectInitExample example);

    int updateByExample(@Param("record") BaseDataObjectInit record, @Param("example") BaseDataObjectInitExample example);

    int updateByPrimaryKeySelective(BaseDataObjectInit record);

    int updateByPrimaryKey(BaseDataObjectInit record);
}