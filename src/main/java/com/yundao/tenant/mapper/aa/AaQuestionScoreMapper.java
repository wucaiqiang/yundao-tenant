

package com.yundao.tenant.mapper.aa;

import java.util.List;

import com.yundao.tenant.dto.aa.asset.AssetAllocationPageReqDto;
import com.yundao.tenant.dto.aa.asset.AssetAllocationPageResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月9日 下午3:07:28 
 * @author   欧阳利
 * @version   
 */
public interface AaQuestionScoreMapper {
    List<AssetAllocationPageResDto> getPage(AssetAllocationPageReqDto reqDto);
    
    int getPageCount(AssetAllocationPageReqDto reqDto);
}

