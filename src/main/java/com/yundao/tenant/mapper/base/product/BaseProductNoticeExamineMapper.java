package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductNoticeExamine;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductNoticeExamineMapper {
    int countByExample(BaseProductNoticeExamineExample example);

    int deleteByExample(BaseProductNoticeExamineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductNoticeExamine record);

    int insertSelective(BaseProductNoticeExamine record);

    List<BaseProductNoticeExamine> selectByExample(BaseProductNoticeExamineExample example);

    BaseProductNoticeExamine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductNoticeExamine record, @Param("example") BaseProductNoticeExamineExample example);

    BaseProductNoticeExamine selectOne(BaseProductNoticeExamineExample example);

    int updateByExample(@Param("record") BaseProductNoticeExamine record, @Param("example") BaseProductNoticeExamineExample example);

    int updateByPrimaryKeySelective(BaseProductNoticeExamine record);

    int updateByPrimaryKey(BaseProductNoticeExamine record);
}