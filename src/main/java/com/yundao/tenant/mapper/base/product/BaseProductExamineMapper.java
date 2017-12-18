package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductExamine;
import com.yundao.tenant.model.base.product.BaseProductExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductExamineMapper {
    int countByExample(BaseProductExamineExample example);

    int deleteByExample(BaseProductExamineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductExamine record);

    int insertSelective(BaseProductExamine record);

    List<BaseProductExamine> selectByExample(BaseProductExamineExample example);

    BaseProductExamine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductExamine record, @Param("example") BaseProductExamineExample example);

    BaseProductExamine selectOne(BaseProductExamineExample example);

    int updateByExample(@Param("record") BaseProductExamine record, @Param("example") BaseProductExamineExample example);

    int updateByPrimaryKeySelective(BaseProductExamine record);

    int updateByPrimaryKey(BaseProductExamine record);
}