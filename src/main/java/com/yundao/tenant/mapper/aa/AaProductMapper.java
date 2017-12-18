

package com.yundao.tenant.mapper.aa;

import java.util.List;

import com.yundao.tenant.dto.aa.product.AssetAllocationProductPageReqDto;
import com.yundao.tenant.dto.product.ProductSimpleResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月9日 下午6:15:04 
 * @author   欧阳利
 * @version   
 */
public interface AaProductMapper {
    List<ProductSimpleResDto> getPage(AssetAllocationProductPageReqDto reqDto);
    
    int getPageCount(AssetAllocationProductPageReqDto reqDto);
    
    
    List<Long> getProductIds(Long id);
}

