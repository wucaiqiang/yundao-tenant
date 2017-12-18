package com.yundao.tenant.mapper.base.sale;

import com.yundao.tenant.model.base.sale.BaseLeadsVisitRel;
import com.yundao.tenant.model.base.sale.BaseLeadsVisitRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseLeadsVisitRelMapper {
    int countByExample(BaseLeadsVisitRelExample example);

    int deleteByExample(BaseLeadsVisitRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseLeadsVisitRel record);

    int insertSelective(BaseLeadsVisitRel record);

    List<BaseLeadsVisitRel> selectByExample(BaseLeadsVisitRelExample example);

    BaseLeadsVisitRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseLeadsVisitRel record, @Param("example") BaseLeadsVisitRelExample example);

    BaseLeadsVisitRel selectOne(BaseLeadsVisitRelExample example);

    int updateByExample(@Param("record") BaseLeadsVisitRel record, @Param("example") BaseLeadsVisitRelExample example);

    int updateByPrimaryKeySelective(BaseLeadsVisitRel record);

    int updateByPrimaryKey(BaseLeadsVisitRel record);
}