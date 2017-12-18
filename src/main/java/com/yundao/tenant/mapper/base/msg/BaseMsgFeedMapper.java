package com.yundao.tenant.mapper.base.msg;

import com.yundao.tenant.model.base.msg.BaseMsgFeed;
import com.yundao.tenant.model.base.msg.BaseMsgFeedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMsgFeedMapper {
    int countByExample(BaseMsgFeedExample example);

    int deleteByExample(BaseMsgFeedExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseMsgFeed record);

    int insertSelective(BaseMsgFeed record);

    List<BaseMsgFeed> selectByExample(BaseMsgFeedExample example);

    BaseMsgFeed selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseMsgFeed record, @Param("example") BaseMsgFeedExample example);

    BaseMsgFeed selectOne(BaseMsgFeedExample example);

    int updateByExample(@Param("record") BaseMsgFeed record, @Param("example") BaseMsgFeedExample example);

    int updateByPrimaryKeySelective(BaseMsgFeed record);

    int updateByPrimaryKey(BaseMsgFeed record);
}