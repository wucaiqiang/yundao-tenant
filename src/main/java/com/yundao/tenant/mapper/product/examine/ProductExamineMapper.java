package com.yundao.tenant.mapper.product.examine;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.product.examine.ProductExaminePageResDto;
import com.yundao.tenant.model.base.product.BaseProductExamine;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductExamineMapper {

    /**
     * 获取产品审核分页数据
     */
    List<ProductExaminePageResDto> selectPage(@Param("params") Map<String, Object> params) throws BaseException;

    /**
     * 获取产品审核总条数
     */
    int selectPageCount(@Param("params") Map<String, Object> params) throws BaseException;
    
    
    /**
     * 获取产品审核总条数
     */
    int updateApplyOnLine(@Param("record")BaseProductExamine record);
}
