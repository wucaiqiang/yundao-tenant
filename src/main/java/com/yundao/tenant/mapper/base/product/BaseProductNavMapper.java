package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductNav;
import com.yundao.tenant.model.base.product.BaseProductNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductNavMapper {
    int countByExample(BaseProductNavExample example);

    int deleteByExample(BaseProductNavExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductNav record);

    int insertSelective(BaseProductNav record);

    List<BaseProductNav> selectByExample(BaseProductNavExample example);

    BaseProductNav selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductNav record, @Param("example") BaseProductNavExample example);

    BaseProductNav selectOne(BaseProductNavExample example);

    int updateByExample(@Param("record") BaseProductNav record, @Param("example") BaseProductNavExample example);

    int updateByPrimaryKeySelective(BaseProductNav record);

    int updateByPrimaryKey(BaseProductNav record);
}