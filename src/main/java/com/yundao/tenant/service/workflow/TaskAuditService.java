

package com.yundao.tenant.service.workflow;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.dto.workflow.TaskActionResDto;
import com.yundao.tenant.dto.workflow.task.TaskDoneReqDto;
import com.yundao.tenant.dto.workflow.task.TaskInfoResDTO;
import com.yundao.tenant.dto.workflow.task.TaskPageReqDto;
import com.yundao.tenant.dto.workflow.task.TaskPageResDto;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月21日 下午8:58:41 
 * @author   欧阳利
 * @version   
 */
public interface TaskAuditService {
	
	/**
	 * 获取任务的操作和申请人信息
	 * @param taskId
	 * @return
	 * @throws BaseException
	 */
	public  Result<TaskActionResDto> getTaskActionAndApplyInfo(@RequestParam String taskId)throws BaseException;
	
	
	
	
	 /**
	  * 获取当前任务历史记录
	  * @param taskId
	  * @return
	  * @throws BaseException
	  */
	 public Result<List<AuditDetailResDTO>> getAuditTaskHistory(String taskId)throws BaseException;
	
	
	
	
	/**
	  * 分页查询待办任务
	  * getPage:
	  * @author: 欧阳利
	  * @param dto
	  * @return
	  * @throws BaseException
	  * @description:
	  */
	 public Result<PaginationSupport<TaskPageResDto>> getPage(TaskPageReqDto dto) throws BaseException;
	 /**
	  * 分页查询我参与的审批任务,排除重新提交的任务
	  * getDonePage:
	  * @author: wucq
	  * @return
	  * @throws BaseException
	  * @description:
	  */
	 public Result<PaginationSupport<TaskPageResDto>> getDonePage(TaskDoneReqDto dto) throws BaseException;
	
}

