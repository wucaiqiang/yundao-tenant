package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseReservation;
import com.yundao.tenant.model.base.sale.BaseReservationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseReservationMapper {
    int countByExample(BaseReservationExample example);

    int deleteByExample(BaseReservationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseReservation record);

    int insertSelective(BaseReservation record);

    List<BaseReservation> selectByExample(BaseReservationExample example);

    BaseReservation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseReservation record, @Param("example") BaseReservationExample example);

    BaseReservation selectOne(BaseReservationExample example);

    int updateByExample(@Param("record") BaseReservation record, @Param("example") BaseReservationExample example);

    int updateByPrimaryKeySelective(BaseReservation record);

    int updateByPrimaryKey(BaseReservation record);
}