package com.yundao.tenant.mapper.customer.tag;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.tag.TagResDto;
import com.yundao.tenant.model.base.customer.BaseTag;

public interface TagMapper {

	List<BaseTag> selectTop(@Param("limit") Integer limit);

	List<BaseTag> getPage(Map<String, Object> parmas);

	int getCount(Map<String, Object> parmas);

	List<BaseTag> selectByCustomerId(@Param("customerId") String customerId, @Param("limit") Integer limit);

	List<TagResDto> selectByCustomerIds(@Param("customerIds") List<Long> customerIds, @Param("limit") Integer limit);

	List<Long> selectCustomerIdByNames(@Param("tags") List<String> tags) throws BaseException;
}
