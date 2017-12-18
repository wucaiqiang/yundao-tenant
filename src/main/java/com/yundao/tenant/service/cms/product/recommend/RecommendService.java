

package com.yundao.tenant.service.cms.product.recommend;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.cms.product.recommend.RecommendAddReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendDetailDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListResDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendUpdateReqDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午4:27:14 
 * @author   欧阳利
 * @version   
 */
public interface RecommendService {
    /**
     * 添加产品附件
     * add:
     * @author: 欧阳利
     * @param reqDto
     * @return
     * @description:
     */
    public Result<Long> add(RecommendAddReqDto reqDto)throws BaseException;
	
	
	/**
	 * 列表查询"
	 * getPage:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
    public Result<PaginationSupport<RecommendListResDto>> getPage(RecommendListReqDto reqDto)throws BaseException;
	/**
	 * 删除单个配置
	 * delete:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @description:
	 */
    public Result<Integer> delete(String[] arrayIds)throws BaseException;
	
	/**
	 * 编辑推荐配置
	 * update:
	 * @author: 欧阳利
	 * @param reqDto
	 * @return
	 * @description:
	 */
    public Result<Integer> update(RecommendUpdateReqDto reqDto)throws BaseException;
	
	/**
	 * 详情
	 * get:
	 * @author: 欧阳利
	 * @param id
	 * @return
	 * @description:
	 */
    public Result<RecommendDetailDto> get(Long id)throws BaseException;
}

