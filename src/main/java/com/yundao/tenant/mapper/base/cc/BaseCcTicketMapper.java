package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcTicket;
import com.yundao.tenant.model.base.cc.BaseCcTicketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcTicketMapper {
    int countByExample(BaseCcTicketExample example);

    int deleteByExample(BaseCcTicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcTicket record);

    int insertSelective(BaseCcTicket record);

    List<BaseCcTicket> selectByExample(BaseCcTicketExample example);

    BaseCcTicket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcTicket record, @Param("example") BaseCcTicketExample example);

    BaseCcTicket selectOne(BaseCcTicketExample example);

    int updateByExample(@Param("record") BaseCcTicket record, @Param("example") BaseCcTicketExample example);

    int updateByPrimaryKeySelective(BaseCcTicket record);

    int updateByPrimaryKey(BaseCcTicket record);
}