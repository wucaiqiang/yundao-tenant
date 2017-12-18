package com.yundao.tenant.mapper.base.msg;

import com.yundao.tenant.model.base.msg.BaseMsgMessage;
import com.yundao.tenant.model.base.msg.BaseMsgMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMsgMessageMapper {
    int countByExample(BaseMsgMessageExample example);

    int deleteByExample(BaseMsgMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMsgMessage record);

    int insertSelective(BaseMsgMessage record);

    List<BaseMsgMessage> selectByExample(BaseMsgMessageExample example);

    BaseMsgMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseMsgMessage record, @Param("example") BaseMsgMessageExample example);

    BaseMsgMessage selectOne(BaseMsgMessageExample example);

    int updateByExample(@Param("record") BaseMsgMessage record, @Param("example") BaseMsgMessageExample example);

    int updateByPrimaryKeySelective(BaseMsgMessage record);

    int updateByPrimaryKey(BaseMsgMessage record);
}