package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationDiscard;
import com.yundao.tenant.model.base.sale.BaseDeclarationDiscardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationDiscardMapper {
    int countByExample(BaseDeclarationDiscardExample example);

    int deleteByExample(BaseDeclarationDiscardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationDiscard record);

    int insertSelective(BaseDeclarationDiscard record);

    List<BaseDeclarationDiscard> selectByExample(BaseDeclarationDiscardExample example);

    BaseDeclarationDiscard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationDiscard record, @Param("example") BaseDeclarationDiscardExample example);

    BaseDeclarationDiscard selectOne(BaseDeclarationDiscardExample example);

    int updateByExample(@Param("record") BaseDeclarationDiscard record, @Param("example") BaseDeclarationDiscardExample example);

    int updateByPrimaryKeySelective(BaseDeclarationDiscard record);

    int updateByPrimaryKey(BaseDeclarationDiscard record);
}