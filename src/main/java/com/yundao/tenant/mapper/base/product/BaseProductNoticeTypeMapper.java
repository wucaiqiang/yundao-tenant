package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductNoticeType;
import com.yundao.tenant.model.base.product.BaseProductNoticeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductNoticeTypeMapper {
    int countByExample(BaseProductNoticeTypeExample example);

    int deleteByExample(BaseProductNoticeTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductNoticeType record);

    int insertSelective(BaseProductNoticeType record);

    List<BaseProductNoticeType> selectByExample(BaseProductNoticeTypeExample example);

    BaseProductNoticeType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductNoticeType record, @Param("example") BaseProductNoticeTypeExample example);

    BaseProductNoticeType selectOne(BaseProductNoticeTypeExample example);

    int updateByExample(@Param("record") BaseProductNoticeType record, @Param("example") BaseProductNoticeTypeExample example);

    int updateByPrimaryKeySelective(BaseProductNoticeType record);

    int updateByPrimaryKey(BaseProductNoticeType record);
}