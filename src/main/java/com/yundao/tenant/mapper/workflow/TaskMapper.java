

package com.yundao.tenant.mapper.workflow;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.workflow.task.KnotCommissionTaskDto;
import com.yundao.tenant.dto.workflow.task.RefundTaskDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年11月16日 下午4:23:38 
 * @author   欧阳利
 * @version   
 */
public interface TaskMapper {
	
	List<KnotCommissionTaskDto>  getKnotCommissionTaskDtos(@Param("ids") List<Long> ids);
	
	KnotCommissionTaskDto  getKnotCommissionTaskDto(@Param("id") Long id);
	
	
	List<RefundTaskDto>  getRefundTaskDtos(@Param("ids") List<Long> ids);
	
	RefundTaskDto  getRefundTaskDto(@Param("id") Long id);
}

