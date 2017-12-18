package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationCompliance;
import com.yundao.tenant.model.base.sale.BaseDeclarationComplianceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationComplianceMapper {
    int countByExample(BaseDeclarationComplianceExample example);

    int deleteByExample(BaseDeclarationComplianceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationCompliance record);

    int insertSelective(BaseDeclarationCompliance record);

    List<BaseDeclarationCompliance> selectByExample(BaseDeclarationComplianceExample example);

    BaseDeclarationCompliance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationCompliance record, @Param("example") BaseDeclarationComplianceExample example);

    BaseDeclarationCompliance selectOne(BaseDeclarationComplianceExample example);

    int updateByExample(@Param("record") BaseDeclarationCompliance record, @Param("example") BaseDeclarationComplianceExample example);

    int updateByPrimaryKeySelective(BaseDeclarationCompliance record);

    int updateByPrimaryKey(BaseDeclarationCompliance record);
}