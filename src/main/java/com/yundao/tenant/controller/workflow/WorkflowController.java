
package com.yundao.tenant.controller.workflow;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.sale.declaration.DeclarationAuditRecordResDto;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.dto.workflow.TaskResDTO;
import com.yundao.tenant.dto.workflow.task.TaskPageReqDto;
import com.yundao.tenant.dto.workflow.task.TaskPageResDto;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.service.workflow.TaskAuditService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Function: Reason: Date: 2017年9月9日 下午3:35:34
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping(value = "/workflow/")
@ResponseBody
@Api("流程相关接口")
public class WorkflowController {
	@Autowired
	private WorkflowServie workflowServie;
	
	@RequestMapping(value = "get_audit_record", method = RequestMethod.GET)
	@ApiOperation(value = "获取流程相关历史记录")
	public Result<List<AuditDetailResDTO>> getAuditRecord(@RequestParam Long id, @RequestParam String code) throws BaseException {
		return workflowServie.getAuditRecord(id,code);
	}
}
