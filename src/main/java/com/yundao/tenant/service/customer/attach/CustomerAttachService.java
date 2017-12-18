

package com.yundao.tenant.service.customer.attach;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.attach.CustomerAttachDto;
import com.yundao.tenant.model.base.customer.BaseCustomerAttach;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年8月10日 下午2:50:30 
 * @author   wucq
 * @version   
 */
public interface CustomerAttachService {
   public List<CustomerAttachDto> selectByCustomerId(Long customerId)throws BaseException;
   public List<CustomerAttachDto> selectByCustomerIdAndType(Long customerId,Integer type)throws BaseException;
   public int insert(BaseCustomerAttach model)throws BaseException;
   public int update(BaseCustomerAttach model)throws BaseException;
   public BaseCustomerAttach get(Long id)throws BaseException;
   public int deleteByCustomerIdAndtype(Long customerId,Integer type)throws BaseException;
}

