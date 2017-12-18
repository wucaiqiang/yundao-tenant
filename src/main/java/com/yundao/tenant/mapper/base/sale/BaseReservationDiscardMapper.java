package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseReservationDiscard;
import com.yundao.tenant.model.base.sale.BaseReservationDiscardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseReservationDiscardMapper {
    int countByExample(BaseReservationDiscardExample example);

    int deleteByExample(BaseReservationDiscardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseReservationDiscard record);

    int insertSelective(BaseReservationDiscard record);

    List<BaseReservationDiscard> selectByExample(BaseReservationDiscardExample example);

    BaseReservationDiscard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseReservationDiscard record, @Param("example") BaseReservationDiscardExample example);

    BaseReservationDiscard selectOne(BaseReservationDiscardExample example);

    int updateByExample(@Param("record") BaseReservationDiscard record, @Param("example") BaseReservationDiscardExample example);

    int updateByPrimaryKeySelective(BaseReservationDiscard record);

    int updateByPrimaryKey(BaseReservationDiscard record);
}