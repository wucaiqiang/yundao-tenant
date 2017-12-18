package com.yundao.tenant.mapper.base.product;

import com.yundao.tenant.model.base.product.BaseProductSale;
import com.yundao.tenant.model.base.product.BaseProductSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProductSaleMapper {
    int countByExample(BaseProductSaleExample example);

    int deleteByExample(BaseProductSaleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseProductSale record);

    int insertSelective(BaseProductSale record);

    List<BaseProductSale> selectByExample(BaseProductSaleExample example);

    BaseProductSale selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseProductSale record, @Param("example") BaseProductSaleExample example);

    BaseProductSale selectOne(BaseProductSaleExample example);

    int updateByExample(@Param("record") BaseProductSale record, @Param("example") BaseProductSaleExample example);

    int updateByPrimaryKeySelective(BaseProductSale record);

    int updateByPrimaryKey(BaseProductSale record);
}