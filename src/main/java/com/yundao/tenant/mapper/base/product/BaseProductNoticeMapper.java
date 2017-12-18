package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductNotice;
import com.yundao.tenant.model.base.product.BaseProductNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductNoticeMapper {
    int countByExample(BaseProductNoticeExample example);

    int deleteByExample(BaseProductNoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductNotice record);

    int insertSelective(BaseProductNotice record);

    List<BaseProductNotice> selectByExample(BaseProductNoticeExample example);

    BaseProductNotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductNotice record, @Param("example") BaseProductNoticeExample example);

    BaseProductNotice selectOne(BaseProductNoticeExample example);

    int updateByExample(@Param("record") BaseProductNotice record, @Param("example") BaseProductNoticeExample example);

    int updateByPrimaryKeySelective(BaseProductNotice record);

    int updateByPrimaryKey(BaseProductNotice record);
}