

package com.yundao.tenant.mapper.customercenter;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.DeclarationH5ResDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ReqDto;
import com.yundao.tenant.dto.customercenter.sale.ReservationH5ResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月8日 下午4:09:05 
 * @author   欧阳利
 * @version   
 */
public interface SaleH5Mapper {
	
	/**
	 * 分页查询我的报单
	 * getMyDeclaration:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public List<DeclarationH5ResDto> getMyDeclarations( DeclarationH5ReqDto dto) throws BaseException;
	
	public int getMyDeclarationCount( DeclarationH5ReqDto dto) throws BaseException;
	
	/**
	 * 分页查询我的预约
	 * getMyReservation:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public List<ReservationH5ResDto> getMyReservations( ReservationH5ReqDto dto) throws BaseException;
	
	public int getMyReservationCount( ReservationH5ReqDto dto) throws BaseException;
}

