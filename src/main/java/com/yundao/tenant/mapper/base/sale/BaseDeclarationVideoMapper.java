package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseDeclarationVideo;
import com.yundao.tenant.model.base.sale.BaseDeclarationVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeclarationVideoMapper {
    int countByExample(BaseDeclarationVideoExample example);

    int deleteByExample(BaseDeclarationVideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseDeclarationVideo record);

    int insertSelective(BaseDeclarationVideo record);

    List<BaseDeclarationVideo> selectByExample(BaseDeclarationVideoExample example);

    BaseDeclarationVideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseDeclarationVideo record, @Param("example") BaseDeclarationVideoExample example);

    BaseDeclarationVideo selectOne(BaseDeclarationVideoExample example);

    int updateByExample(@Param("record") BaseDeclarationVideo record, @Param("example") BaseDeclarationVideoExample example);

    int updateByPrimaryKeySelective(BaseDeclarationVideo record);

    int updateByPrimaryKey(BaseDeclarationVideo record);
}