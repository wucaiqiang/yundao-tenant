

package com.yundao.tenant.mapper.cms.product.recommend;

import java.util.List;

import com.yundao.tenant.dto.cms.product.recommend.RecommendListReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月19日 上午9:14:13 
 * @author   欧阳利
 * @version   
 */
public interface ProductRecommendMapper {

	/**
	 * 分页查询产品配置记录
	 * getPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
	List<RecommendListResDto> getPage(RecommendListReqDto reqDto);
	
	/**
	 * 产品配置总记录数
	 * getPageCount:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
	int getPageCount(RecommendListReqDto reqDto);
	
}

