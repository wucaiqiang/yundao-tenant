package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationCredentialsRel;
import com.yundao.tenant.model.base.sale.BaseDeclarationCredentialsRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationCredentialsRelMapper {
    int countByExample(BaseDeclarationCredentialsRelExample example);

    int deleteByExample(BaseDeclarationCredentialsRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationCredentialsRel record);

    int insertSelective(BaseDeclarationCredentialsRel record);

    List<BaseDeclarationCredentialsRel> selectByExample(BaseDeclarationCredentialsRelExample example);

    BaseDeclarationCredentialsRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationCredentialsRel record, @Param("example") BaseDeclarationCredentialsRelExample example);

    BaseDeclarationCredentialsRel selectOne(BaseDeclarationCredentialsRelExample example);

    int updateByExample(@Param("record") BaseDeclarationCredentialsRel record, @Param("example") BaseDeclarationCredentialsRelExample example);

    int updateByPrimaryKeySelective(BaseDeclarationCredentialsRel record);

    int updateByPrimaryKey(BaseDeclarationCredentialsRel record);
}