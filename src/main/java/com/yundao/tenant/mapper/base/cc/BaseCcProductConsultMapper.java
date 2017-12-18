package com.yundao.tenant.mapper.base.cc;

import com.yundao.tenant.model.base.cc.BaseCcProductConsult;
import com.yundao.tenant.model.base.cc.BaseCcProductConsultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseCcProductConsultMapper {
    int countByExample(BaseCcProductConsultExample example);

    int deleteByExample(BaseCcProductConsultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCcProductConsult record);

    int insertSelective(BaseCcProductConsult record);

    List<BaseCcProductConsult> selectByExample(BaseCcProductConsultExample example);

    BaseCcProductConsult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCcProductConsult record, @Param("example") BaseCcProductConsultExample example);

    BaseCcProductConsult selectOne(BaseCcProductConsultExample example);

    int updateByExample(@Param("record") BaseCcProductConsult record, @Param("example") BaseCcProductConsultExample example);

    int updateByPrimaryKeySelective(BaseCcProductConsult record);

    int updateByPrimaryKey(BaseCcProductConsult record);
}