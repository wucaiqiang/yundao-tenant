package com.yundao.tenant.mapper.base.finance;

import com.yundao.tenant.model.base.finance.BaseKnotCommission;
import com.yundao.tenant.model.base.finance.BaseKnotCommissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseKnotCommissionMapper {
    int countByExample(BaseKnotCommissionExample example);

    int deleteByExample(BaseKnotCommissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseKnotCommission record);

    int insertSelective(BaseKnotCommission record);

    List<BaseKnotCommission> selectByExample(BaseKnotCommissionExample example);

    BaseKnotCommission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseKnotCommission record, @Param("example") BaseKnotCommissionExample example);

    BaseKnotCommission selectOne(BaseKnotCommissionExample example);

    int updateByExample(@Param("record") BaseKnotCommission record, @Param("example") BaseKnotCommissionExample example);

    int updateByPrimaryKeySelective(BaseKnotCommission record);

    int updateByPrimaryKey(BaseKnotCommission record);
}