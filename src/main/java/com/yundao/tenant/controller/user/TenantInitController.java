package com.yundao.tenant.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.tenant.TenantInitDataDto;
import com.yundao.tenant.service.user.TenantInitService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.service.workflow.WorkflowServie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("初始化系统")
@RequestMapping("/user")
public class TenantInitController {
	private static Log log = LogFactory.getLog(TenantInitController.class);
	@Autowired
	TenantInitService tenantInitService;
	
	@Autowired
	WorkFlowGroupUserService workFlowGroupUserService;
	
	@Autowired
	WorkflowServie workflowServie;
	
	/**
	 * 初始化租户信息
	 * @return
	 */
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    @ApiOperation(value = "初始化租户信息", notes = "初始化租户信息")
	public Result<Integer> tenantInit(@RequestParam Long tenantId)throws BaseException{
    	log.info("初始化租户信息tenantId："+tenantId);
    	// 检查是否有用户
    	try{
    		boolean checkResult = tenantInitService.checkDBFinishInit(tenantId);
        	if(checkResult){
        		return Result.newFailureResult(CodeConstant.CODE_1200023, "租户数据库存在用户, 请清空数据!", null);
        	}
    	}catch(Exception e){
    		log.error("初始数据异常",e);
    		return Result.newFailureResult(CodeConstant.CODE_1200024, "租户数据库表没有创建!", null);
    	}
    	
    	// 获取初始化租户的数据
    	Result<TenantInitDataDto> tenantInitDataDtoResult = tenantInitService.getInitData(tenantId);
    	if(!tenantInitDataDtoResult.getSuccess()){
    		return Result.newFailureResult(tenantInitDataDtoResult.getCode());
    	}
    	
    	// 初始化租户信息
		tenantInitService.doTenantInit(tenantInitDataDtoResult.getResult(),tenantId);
		
		// 初始化工作流
		workflowServie.initCommonWorkFlow();
		// 通过工作流审批人员
		workFlowGroupUserService.updateRole();
		return Result.newSuccessResult(1);
	}
    
    
    
    @RequestMapping(value = "/init_workflow_group_user", method = RequestMethod.POST)
    @ApiOperation(value = "初始化租户信息", notes = "初始化租户信息")
    public Result<Integer> initTenantWorkFlowGroupUser()throws BaseException{
		workFlowGroupUserService.updateRole();
    	return Result.newSuccessResult(1);
    }
    
	
}
