package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductFocus;
import com.yundao.tenant.model.base.product.BaseProductFocusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductFocusMapper {
    int countByExample(BaseProductFocusExample example);

    int deleteByExample(BaseProductFocusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductFocus record);

    int insertSelective(BaseProductFocus record);

    List<BaseProductFocus> selectByExample(BaseProductFocusExample example);

    BaseProductFocus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductFocus record, @Param("example") BaseProductFocusExample example);

    BaseProductFocus selectOne(BaseProductFocusExample example);

    int updateByExample(@Param("record") BaseProductFocus record, @Param("example") BaseProductFocusExample example);

    int updateByPrimaryKeySelective(BaseProductFocus record);

    int updateByPrimaryKey(BaseProductFocus record);
}