

package com.yundao.tenant.service.customercenter;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.customercenter.MyIndexDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ResDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ResDto;

/**
 * Function: h5 报单预约服务
 * Reason:	  
 * Date:     2017年9月8日 下午3:48:29 
 * @author   欧阳利
 * @version   
 */
public interface SaleH5Service {
	
	/**
	 * 分页查询我的报单
	 * getMyDeclaration:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<DeclarationH5ResDto>> getMyDeclaration( DeclarationH5ReqDto dto) throws BaseException;
	
	/**
	 * 分页查询我的预约
	 * getMyReservation:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<ReservationH5ResDto>> getMyReservation( ReservationH5ReqDto dto) throws BaseException;
	
	/**
	 * 获取投资者的首页信息
	 * getMyIndex:
	 * @author: 欧阳利
	 * @param userId
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<MyIndexDto> getMyIndex(Long userId) throws BaseException;
}

