package com.yundao.tenant.service.workflow.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.Code1200000;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.url.WorkflowUrlConstant;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.dto.workflow.ProcessStartResDTO;
import com.yundao.tenant.dto.workflow.TaskCompleteResDTO;
import com.yundao.tenant.dto.workflow.TaskResDTO;
import com.yundao.tenant.dto.workflow.WorkFlowAuditRecordResDto;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.sale.BaseWorkflowBusinessRelMapper;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRelExample;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.workflow.WorkflowBusinessRelService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.HttpUtils;

/**
 * @author jan
 * @create 2017-08-27 PM1:41
 **/
@Service
public class WorkflowServieImpl extends AbstractService implements WorkflowServie {

    private static Log log = LogFactory.getLog(WorkflowServieImpl.class);


    @Autowired
    private WorkflowBusinessRelService workflowBusinessRelService;

    @Autowired
    BaseWorkflowBusinessRelMapper baseWorkflowBusinessRelMapper;

    @Autowired
    private UserDetailService userDetailService;

    /**
     * 获取待办任务id
     *
     * @param objectId
     * @param type
     * @return
     * @throws BaseException
     */
    @Override
    public Result<String> getTODOTaskId(Long objectId, String type,Boolean isCancel) throws BaseException {
        if (objectId == null) {
            return Result.newFailureResult(CodeConstant.CODE_1200000);
        }
        BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
        example.createCriteria().andTypeEqualTo(type).andObjectIdEqualTo(objectId).andIsCompleteEqualTo(0);
        BaseWorkflowBusinessRel baseWorkflowBusinessRel = baseWorkflowBusinessRelMapper.selectOne(example);
        if (baseWorkflowBusinessRel != null) {
            TaskResDTO task = getSingleTodoTaskId(baseWorkflowBusinessRel.getBusinessNo(),isCancel);
            if (task == null || BooleanUtils.isBlank(task.getId())) {
                log.error("业务no=" + baseWorkflowBusinessRel.getBusinessNo() + ", 没有找到代办任务");
                throw new BaseException(CodeConstant.CODE_1200108, "任务不存在!");
            }
            String taskId = task.getId();
            return Result.newSuccessResult(taskId);
        }else{
        	 throw new BaseException(CodeConstant.CODE_1200111);
        }
    }

    @Override
    public ProcessStartResDTO start(Long objectId, String processDefineKey, String businessTypeCode) throws BaseException {
        // 添加校验
        boolean isCanStart = workflowBusinessRelService.checkCanStartWorkFlow(objectId, businessTypeCode);
        if (!isCanStart){
        	 // TODO 报警
        	 log.error("启动流程异常(已存在相同类型并且没有完成的流程)||businessTypeCode="+businessTypeCode +"||objectId="+objectId);
        	 throw new BaseException(Code1200000.CODE_1200184);
        }
           
    	
    	String logPrefix = "工作流||启动||";
        log.info("%s参数 objectId %s processDefineKey %s businessTypeCode %s", logPrefix, objectId, processDefineKey, businessTypeCode);
        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("processDefineKey", processDefineKey);
        Result<ProcessStartResDTO> result = HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_START, paramMap,
                new BaseTypeReference<Result<ProcessStartResDTO>>() {
                });

        log.info("%s返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
        if (!result.getSuccess())
            throw new BaseException(CodeConstant.CODE_1220053);

        ProcessStartResDTO dto = result.getResult();
        if (dto == null || BooleanUtils.isEmpty(dto.getBusinessKey()) || BooleanUtils.isEmpty(dto.getTaskId()))
            throw new BaseException(CodeConstant.CODE_1200054);

        log.info("%s插入工作流业务关系||开始", logPrefix);
        workflowBusinessRelService.start(objectId, dto.getBusinessKey(), businessTypeCode);
        log.info("%s完成", logPrefix);
        return dto;
    }
    

    @Override
    public TaskCompleteResDTO complete(String taskId, Integer action) throws BaseException {
        return this.complete(taskId, action, "");
    }

    @Override
    public TaskCompleteResDTO complete(String taskId, Integer action, String comment) throws BaseException {
        String logPrefix = "工作流||审核||";
        log.info("%s开始||参数 taskId %s action %s comment %s", logPrefix, taskId, action, comment);

        Map<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("taskId", taskId);
        paramMap.put("actionValue", action);
        paramMap.put("comment", comment);
        //List<Long> roles = roleService.getsByUserId().getResult();
        //paramMap.put(HeaderConstant.USER_ROLE, SymbolStrUtils.longToStr(roles));
        Result<TaskCompleteResDTO> result = HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_DO, paramMap, new
                BaseTypeReference<Result<TaskCompleteResDTO>>() {
                });
        log.info("%s返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
        if (!result.getSuccess())
            throw new BaseException(result.getCode(),result.getMessage());

        TaskCompleteResDTO dto = result.getResult();
        if (dto == null || BooleanUtils.isEmpty(dto.getBusinessKey()))
            throw new BaseException(CodeConstant.CODE_1200054);
        //工作流已结束
        if (dto.getProcessIsEnd()) {
            log.info("%s更改工作流业务关系||开始", logPrefix);
            workflowBusinessRelService.end(dto.getBusinessKey());
        }
        return dto;
    }

    
    /**
     * 获取待办任务id  并处理
     *
     * @param taskId 任务id
     * @param action 动作值 ，例如：1：通过  2：驳回 3：取消 4：重新提交 枚举：WorkflowActionEnum
     */
    @Override
    public  Result<TaskCompleteResDTO> getTODOTaskIdAndcomplete(Long objectId,String type,Boolean isCancel,
    		Integer action, String comment) throws BaseException{
    	Result<String> result = getTODOTaskId(objectId, type, isCancel);
		if (!result.getSuccess()) {
			return Result.newFailureResult(result.getCode());
		}
		String taskId = result.getResult();
		return Result.newSuccessResult(complete(taskId,action,comment));
    }

    @Override
    public List<TaskResDTO> getTodoTaskIds(String businessKey,Boolean isCancel) throws BaseException {
        String logPrefix = "工作流||获取待办||";
        Map<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("businessKey", businessKey);
        paramMap.put("taskStatus", "TODO");
        paramMap.put("isCancel", isCancel);
        //List<Long> roles = roleService.getsByUserId().getResult();
        //paramMap.put(HeaderConstant.USER_ROLE, SymbolStrUtils.longToStr(roles));
        Result<List<TaskResDTO> > result = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GETS, paramMap, new
                BaseTypeReference<Result<List<TaskResDTO> >>() {
                });
        log.info("%s返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
        if (result == null || !result.getSuccess())
            throw new BaseException(CodeConstant.CODE_1200054);

        List<TaskResDTO> dtos =result.getResult();
        return dtos;
    }


    @Override
	public List<TaskResDTO> getMyTodoTasks() throws BaseException {
    	 String logPrefix = "工作流||获取待办||";
    	 Map<String, Object> paramMap = new HashMap<>(2);
         paramMap.put("taskStatus", "TODO");
         Result<List<TaskResDTO> > result = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_MY_TO_DO, paramMap, new
                 BaseTypeReference<Result<List<TaskResDTO> >>() {
                 });
         log.info("%s返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
         if (result == null || !result.getSuccess())
             throw new BaseException(CodeConstant.CODE_1200054);
         
		return result.getResult();
		
	}

	@Override
    public TaskResDTO getSingleTodoTaskId(String businessKey,Boolean isCancel) throws BaseException {
        List<TaskResDTO> dtos = this.getTodoTaskIds(businessKey,isCancel);
        if (BooleanUtils.isEmpty(dtos))
            return null;
        return dtos.get(0);
    }
    
    
    /**
     * 查询单个业务的审核记录
     * @param objectId  业务id
     * @param type  业务类型
     * @return
     * @throws BaseException
     */
    public List<AuditDetailResDTO> getWorkflowList(Long objectId,String type) throws BaseException{
    	 String logPrefix = "工作流||获取审核详情||";
    	if (objectId == null) {
    		 throw new BaseException(CodeConstant.CODE_1200000);
        }
    	 BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
         example.createCriteria().andTypeEqualTo(type).andObjectIdEqualTo(objectId);
         BaseWorkflowBusinessRel baseWorkflowBusinessRel = baseWorkflowBusinessRelMapper.selectOne(example);
         if(baseWorkflowBusinessRel==null){
        	 log.error("objectId=" + objectId +"type=" + type + ", 找不到对应的业务流水号");
        	 Result.newFailureResult(CodeConstant.CODE_1200111);
         }
         Map<String, Object> paramMap = new HashMap<>(2);
         paramMap.put("businessKey", baseWorkflowBusinessRel.getBusinessNo());
         Result<List<AuditDetailResDTO> > result = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_AUDIT_LIST, paramMap, new
                 BaseTypeReference<Result<List<AuditDetailResDTO> >>() {
                 });
         log.info("%s返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
         if (result == null || !result.getSuccess())
             throw new BaseException(CodeConstant.CODE_1200054);

         return result.getResult();
    }
    
    
    
    /**
     * 查询单个业务的审核记录
     * @param businessNo  业务no
     * @return
     * @throws BaseException
     */
    public List<AuditDetailResDTO> getWorkflowList(String businessNo) throws BaseException{
    	 String logPrefix = "工作流||获取审核详情||"+businessNo;
         Map<String, Object> paramMap = new HashMap<>(2);
         paramMap.put("businessKey", businessNo);
         Result<List<AuditDetailResDTO> > result = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_AUDIT_LIST, paramMap, new
                 BaseTypeReference<Result<List<AuditDetailResDTO> >>() {
                 });
         log.info("%s返回结果:%s", logPrefix, JsonUtils.objectToJson(result));
         if (result == null || !result.getSuccess())
             throw new BaseException(CodeConstant.CODE_1200054);

         return result.getResult();
    }

    @Override
    public Result<List<AuditDetailResDTO>> getAuditRecord(Long id, String code) throws BaseException {
        List<AuditDetailResDTO> list = getWorkflowList(id, code);

        if (!BooleanUtils.isEmpty(list)) {
            List<Long> ids = new ArrayList<>(list.size());
            list.forEach(m -> {ids.add(m.getActionUserId());m.setActionText(WorkflowActionEnum.getName(m.getActionValue()));});
            List<BaseUserDetail> userDetails = userDetailService.getUserDetail(ids);
            for (AuditDetailResDTO dto : list) {
                for (BaseUserDetail userDetail : userDetails) {
                    if(userDetail.getUserAccountId().equals(dto.getActionUserId())) {
                        dto.setActionUserName(userDetail.getRealName());
                    }
                }
            }
        }
        return Result.newSuccessResult(list);
    }
    
    
	/**
	 * 初始化工作流
	 * initCommonWorkFlow:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<Boolean> initCommonWorkFlow()throws BaseException{
		Map<String, Object> map = new HashMap<String, Object>();
		Result<Boolean> result =  HttpUtils.post(WorkflowUrlConstant.WORK_FLOW_DEPLOY_COMMON, map, new
                BaseTypeReference<Result<Boolean>>() {
                });
		
		return result;
		
	}
	
	
	/**
	 * 多次流程审批记录
	 * getAuditDetail:
	 * @author: 欧阳利
	 * @param noticeId
	 * @return
	 * @throws BaseException
	 * @description:
	 */
    public Result<List<WorkFlowAuditRecordResDto>> getAuditDetail(Long objectId,String type)throws BaseException{
    	List<String> businessTypeCodes = new ArrayList<String>();
    	businessTypeCodes.add(type);
    	List<BaseWorkflowBusinessRel> businessList = workflowBusinessRelService.getBusinessNos(objectId, businessTypeCodes);
    	
    	List<WorkFlowAuditRecordResDto> list = new ArrayList<WorkFlowAuditRecordResDto>();
    	if(!BooleanUtils.isEmpty(businessList)){
    		List<String> businessNos = new ArrayList<String>();
    		for(BaseWorkflowBusinessRel rel : businessList){
    			WorkFlowAuditRecordResDto dto = new WorkFlowAuditRecordResDto();
    			BeanUtils.copyProperties(rel, dto);
    			list.add(dto);
    			dto.setTypeText(ProcessDefineKeyEnum.getName(dto.getType()));
    			dto.setAuditList(this.getWorkflowList(dto.getBusinessNo()));
    			businessNos.add(rel.getBusinessNo());
    			
    			if(!BooleanUtils.isEmpty(dto.getAuditList())){
    	    		for(AuditDetailResDTO resdto : dto.getAuditList()){
    	    			resdto.setActionText(WorkflowActionEnum.getName(resdto.getActionValue()));
    	    			resdto.setActionUserName(userDetailService.getUserRealName(resdto.getActionUserId()));
    	    			
    	    		}
    	    	}
    		}
    	}
    	
    	return Result.newSuccessResult(list);
    }
}
