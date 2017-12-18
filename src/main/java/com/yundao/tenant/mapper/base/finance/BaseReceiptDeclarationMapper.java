package com.yundao.tenant.mapper.base.finance;

import com.yundao.tenant.model.base.finance.BaseReceiptDeclaration;
import com.yundao.tenant.model.base.finance.BaseReceiptDeclarationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseReceiptDeclarationMapper {
    int countByExample(BaseReceiptDeclarationExample example);

    int deleteByExample(BaseReceiptDeclarationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseReceiptDeclaration record);

    int insertSelective(BaseReceiptDeclaration record);

    List<BaseReceiptDeclaration> selectByExample(BaseReceiptDeclarationExample example);

    BaseReceiptDeclaration selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseReceiptDeclaration record, @Param("example") BaseReceiptDeclarationExample example);

    BaseReceiptDeclaration selectOne(BaseReceiptDeclarationExample example);

    int updateByExample(@Param("record") BaseReceiptDeclaration record, @Param("example") BaseReceiptDeclarationExample example);

    int updateByPrimaryKeySelective(BaseReceiptDeclaration record);

    int updateByPrimaryKey(BaseReceiptDeclaration record);
}