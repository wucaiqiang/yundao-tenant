package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductNoticeAttachMapper {
    int countByExample(BaseProductNoticeAttachExample example);

    int deleteByExample(BaseProductNoticeAttachExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductNoticeAttach record);

    int insertSelective(BaseProductNoticeAttach record);

    List<BaseProductNoticeAttach> selectByExample(BaseProductNoticeAttachExample example);

    BaseProductNoticeAttach selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductNoticeAttach record, @Param("example") BaseProductNoticeAttachExample example);

    BaseProductNoticeAttach selectOne(BaseProductNoticeAttachExample example);

    int updateByExample(@Param("record") BaseProductNoticeAttach record, @Param("example") BaseProductNoticeAttachExample example);

    int updateByPrimaryKeySelective(BaseProductNoticeAttach record);

    int updateByPrimaryKey(BaseProductNoticeAttach record);
}