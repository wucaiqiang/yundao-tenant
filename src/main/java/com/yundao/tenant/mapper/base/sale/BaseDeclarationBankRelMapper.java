package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationBankRel;
import com.yundao.tenant.model.base.sale.BaseDeclarationBankRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationBankRelMapper {
    int countByExample(BaseDeclarationBankRelExample example);

    int deleteByExample(BaseDeclarationBankRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationBankRel record);

    int insertSelective(BaseDeclarationBankRel record);

    List<BaseDeclarationBankRel> selectByExample(BaseDeclarationBankRelExample example);

    BaseDeclarationBankRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationBankRel record, @Param("example") BaseDeclarationBankRelExample example);

    BaseDeclarationBankRel selectOne(BaseDeclarationBankRelExample example);

    int updateByExample(@Param("record") BaseDeclarationBankRel record, @Param("example") BaseDeclarationBankRelExample example);

    int updateByPrimaryKeySelective(BaseDeclarationBankRel record);

    int updateByPrimaryKey(BaseDeclarationBankRel record);
}