package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseDeclarationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationMapper {
    int countByExample(BaseDeclarationExample example);

    int deleteByExample(BaseDeclarationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclaration record);

    int insertSelective(BaseDeclaration record);

    List<BaseDeclaration> selectByExample(BaseDeclarationExample example);

    BaseDeclaration selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclaration record, @Param("example") BaseDeclarationExample example);

    BaseDeclaration selectOne(BaseDeclarationExample example);

    int updateByExample(@Param("record") BaseDeclaration record, @Param("example") BaseDeclarationExample example);

    int updateByPrimaryKeySelective(BaseDeclaration record);

    int updateByPrimaryKey(BaseDeclaration record);
}