
package com.yundao.tenant.controller.workflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.dto.workflow.TaskActionResDto;
import com.yundao.tenant.dto.workflow.TaskResDTO;
import com.yundao.tenant.dto.workflow.task.TaskDoneReqDto;
import com.yundao.tenant.dto.workflow.task.TaskPageReqDto;
import com.yundao.tenant.dto.workflow.task.TaskPageResDto;
import com.yundao.tenant.enums.ExamineGroupEnum;
import com.yundao.tenant.service.workflow.TaskAuditService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.service.workflow.WorkflowServie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年9月9日 下午3:35:34
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping(value = "/task/")
@ResponseBody
@Api("任务相关")
public class TaskController {
	@Autowired
	private WorkflowServie workflowServie;
	
	@Autowired
	private WorkFlowGroupUserService workFlowGroupUserService;
	
	@Autowired
	private TaskAuditService taskAuditService;

	@RequestMapping(value = "get_todo_count", method = RequestMethod.GET)
	@ApiOperation(value = "获取我的待办任务数")
	public Result<Integer> getTodoTaskCount() throws BaseException {
		List<TaskResDTO> taskResDTOs=workflowServie.getMyTodoTasks();
		int count =taskResDTOs==null?0:taskResDTOs.size();
		
		return Result.newSuccessResult(count);
	}

	
	/**
	 * 分页查询待审批的任务
	 * getPagePersonal:
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	@ApiOperation(value = "分页查询待审批的任务")
	@RequestMapping(value = "audit/app/get_page", method = RequestMethod.GET)
    public Result<PaginationSupport<TaskPageResDto>> getPage(@ModelAttribute TaskPageReqDto dto) throws BaseException {

		List<String> auditGroups =  workFlowGroupUserService.getAuditGroup();
		auditGroups.remove(ExamineGroupEnum.PROJECT_DECISION.getGroupCode());
		auditGroups.remove(ExamineGroupEnum.PROJECT_DUE_DILIGENCE.getGroupCode());
		auditGroups.remove(ExamineGroupEnum.PROJECT_FIRST_TRIAL.getGroupCode());
		auditGroups.remove(ExamineGroupEnum.PROJECT_INVESTMENT_COMMITTEE.getGroupCode());
		auditGroups.remove(ExamineGroupEnum.PROJECT_INVEST.getGroupCode());
		
		dto.setAuditGroups(JsonUtils.objectToJson(auditGroups));
		
		// 如果不在任何审核组中就没有带审核的任务
		if(BooleanUtils.isEmpty(auditGroups)){
			return new Result<PaginationSupport<TaskPageResDto>>();
		}
		
        return taskAuditService.getPage(dto);
    }
	
	
	@ApiOperation(value = "获取当前用户的审批组")
	@RequestMapping(value = "audit/get_audit_group", method = RequestMethod.GET)
	public Result<List<String>> getCurrentUserAuditGroup()throws BaseException{
		  List<String> auditGroups =  workFlowGroupUserService.getAuditGroup();
		  return Result.newSuccessResult(auditGroups);
	}
	
	/**
	 * 
	 * getDonePage:
	 * @author: wucq
	 * @param orderBy 排序字段
	 * @param filtNodeCategorys 需要过虑的节点
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	@ApiOperation(value = "分页查询我参与的审批任务,排除重新提交的任务")
	@RequestMapping(value = "done/get_page", method = RequestMethod.GET)
    public Result<PaginationSupport<TaskPageResDto>> getDonePage(@ModelAttribute TaskDoneReqDto dto) throws BaseException {
        return taskAuditService.getDonePage(dto);
    }

	
	@ApiOperation(value = "获取当前任务的审核历史记录")
	@RequestMapping(value = "get_task_history", method = RequestMethod.GET)
	public Result<List<AuditDetailResDTO>> getAuditTaskHistory(@RequestParam String taskId)throws BaseException{
		if(BooleanUtils.isBlank(taskId)){
			return Result.newFailureResult(CodeConstant.CODE_1220034);
		}
		return taskAuditService.getAuditTaskHistory(taskId);
	}
	
	
	@ApiOperation(value = "获取任务的操作和申请信息")
	@RequestMapping(value = "get_action_and_apply_info", method = RequestMethod.GET)
	public Result<TaskActionResDto> getTaskActionAndApplyInfo(@RequestParam String taskId)throws BaseException{
		if(BooleanUtils.isBlank(taskId)){
			return Result.newFailureResult(CodeConstant.CODE_1220034);
		}
		return taskAuditService.getTaskActionAndApplyInfo(taskId);
	}
	
}
