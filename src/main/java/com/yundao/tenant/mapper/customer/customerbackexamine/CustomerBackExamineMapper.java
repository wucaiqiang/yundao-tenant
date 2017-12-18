package com.yundao.tenant.mapper.customer.customerbackexamine;

import java.util.List;

import com.yundao.tenant.dto.customer.back.CustomerBackExamineListReqDto;
import com.yundao.tenant.dto.customer.back.CustomerBackExamineListResDto;

public interface CustomerBackExamineMapper {

	/**
	 * 分页查询待审核列表
	 * @param reqDto
	 * @return
	 */
	public List<CustomerBackExamineListResDto> gets(CustomerBackExamineListReqDto reqDto);
	
	/**
	 * 查询审核列表的总记录数
	 * @param reqDto
	 * @return
	 */
	public int getCount(CustomerBackExamineListReqDto reqDto);
	
}
