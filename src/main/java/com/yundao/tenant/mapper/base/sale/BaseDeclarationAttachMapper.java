package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationAttach;
import com.yundao.tenant.model.base.sale.BaseDeclarationAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationAttachMapper {
    int countByExample(BaseDeclarationAttachExample example);

    int deleteByExample(BaseDeclarationAttachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationAttach record);

    int insertSelective(BaseDeclarationAttach record);

    List<BaseDeclarationAttach> selectByExample(BaseDeclarationAttachExample example);

    BaseDeclarationAttach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationAttach record, @Param("example") BaseDeclarationAttachExample example);

    BaseDeclarationAttach selectOne(BaseDeclarationAttachExample example);

    int updateByExample(@Param("record") BaseDeclarationAttach record, @Param("example") BaseDeclarationAttachExample example);

    int updateByPrimaryKeySelective(BaseDeclarationAttach record);

    int updateByPrimaryKey(BaseDeclarationAttach record);
}