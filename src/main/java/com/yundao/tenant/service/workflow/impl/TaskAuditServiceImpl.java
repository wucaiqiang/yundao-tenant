
package com.yundao.tenant.service.workflow.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.constant.url.WorkflowUrlConstant;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeDto;
import com.yundao.tenant.dto.sale.declaration.ProductDeclarationDto;
import com.yundao.tenant.dto.sale.reservation.ProductReservationDto;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.dto.workflow.TaskActionResDto;
import com.yundao.tenant.dto.workflow.task.ContentDto;
import com.yundao.tenant.dto.workflow.task.KnotCommissionTaskDto;
import com.yundao.tenant.dto.workflow.task.RefundTaskDto;
import com.yundao.tenant.dto.workflow.task.TaskDoneReqDto;
import com.yundao.tenant.dto.workflow.task.TaskInfoResDTO;
import com.yundao.tenant.dto.workflow.task.TaskPageReqDto;
import com.yundao.tenant.dto.workflow.task.TaskPageResDto;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.product.BaseProductExamineMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.base.product.BaseProductNoticeMapper;
import com.yundao.tenant.mapper.base.sale.BaseDeclarationMapper;
import com.yundao.tenant.mapper.base.sale.BaseReservationMapper;
import com.yundao.tenant.mapper.base.sale.BaseWorkflowBusinessRelMapper;
import com.yundao.tenant.mapper.productnoticeexamine.ProductNoticeExamineMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.mapper.sale.reservation.ReservationMapper;
import com.yundao.tenant.mapper.workflow.TaskMapper;
import com.yundao.tenant.model.base.BaseUserDetail;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExamine;
import com.yundao.tenant.model.base.product.BaseProductExamineExample;
import com.yundao.tenant.model.base.product.BaseProductExample;
import com.yundao.tenant.model.base.sale.BaseDeclaration;
import com.yundao.tenant.model.base.sale.BaseReservation;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRelExample;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.workflow.TaskAuditService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;
import com.yundao.tenant.util.ArgsUtils;
import com.yundao.tenant.util.HttpUtils;
import com.yundao.tenant.util.SymbolStrUtils;

/**
 * Function: Reason: Date: 2017年9月21日 下午8:58:53
 * 
 * @author 欧阳利
 * @version
 */
@Service
public class TaskAuditServiceImpl implements TaskAuditService {

	@Autowired
	DictionaryService dictionaryService;
	
	@Autowired
	BaseWorkflowBusinessRelMapper baseWorkflowBusinessRelMapper;
	@Autowired
	BaseProductMapper baseProductMapper;

	@Autowired
	ReservationMapper reservationMapper;

	@Autowired
	BaseReservationMapper baseReservationMapper;

	@Autowired
	private BaseProductExamineMapper baseProductExamineMapper;

	@Autowired
	DeclarationMapper declarationMapper;

	@Autowired
	BaseDeclarationMapper baseDeclarationMapper;

	@Autowired
	UserDetailService userDetailService;

	@Autowired
	WorkFlowGroupUserService workFlowGroupUserService;

	@Autowired
	BaseProductNoticeMapper baseProductNoticeMapper;

	@Autowired
	ProductNoticeExamineMapper productNoticeExamineMapper;
	
	@Autowired
	TaskMapper taskMapper;

	/**
	 * 获取任务的操作和申请人信息
	 * 
	 * @param taskId
	 * @return
	 * @throws BaseException
	 */
	public Result<TaskActionResDto> getTaskActionAndApplyInfo(@RequestParam String taskId) throws BaseException {
		Map<String, Object> taskMap = new HashMap<>(2);
		taskMap.put("taskId", taskId);
		Result<TaskActionResDto> taskResult = HttpUtils.get(WorkflowUrlConstant.GET_AUDIT_TASK_ATION_AND_APPLY, taskMap,
				new BaseTypeReference<Result<TaskActionResDto>>() {
				});

		if (!taskResult.getSuccess()) {
			return Result.newFailureResult(taskResult.getCode(), taskResult.getMessage(), null);
		}

		TaskActionResDto dto = taskResult.getResult();
		if (dto != null) {
			dto.setApplyUserRealName(userDetailService.getUserRealName(dto.getApplyUserId()));
			/*if (BooleanUtils.isEmpty(dto.getActions())) {
			resetAction(dto);
		}*/
		}
		return taskResult;
	}

	/**
	 * 重置参数
	 * 
	 * @param dto
	 */
	private void resetAction(TaskActionResDto dto) throws BaseException {
		Map<String, Object> taskMap = new HashMap<>(2);
		taskMap.put("taskId", dto.getTaskId());
		Result<String> taskResult = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_BUSINESSKEY, taskMap,
				new BaseTypeReference<Result<String>>() {
				});

		String businessKey = taskResult.getResult();
		if (BooleanUtils.isBlank(businessKey)) {
			return;
		}
		BaseWorkflowBusinessRelExample relExample = new BaseWorkflowBusinessRelExample();
		relExample.createCriteria().andBusinessNoEqualTo(businessKey).andIsCompleteEqualTo(0);
		BaseWorkflowBusinessRel base = baseWorkflowBusinessRelMapper.selectOne(relExample);
		if (base == null) {
			return;
		}
		Integer status = null;
		if (ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey().equals(base.getType())) {
			BaseProductExamineExample example = new BaseProductExamineExample();
			BaseProductExamine model = baseProductExamineMapper.selectOne(example);
			if (model != null) {
				status = model.getStatus();
			}
		} else if (ProcessDefineKeyEnum.DECLARATION.getKey().equals(base.getType())) {
			BaseDeclaration model = baseDeclarationMapper.selectByPrimaryKey(base.getObjectId());
			if (model != null) {
				status = model.getAuditStatus();
			}
		} else if (ProcessDefineKeyEnum.RESERVATIN.getKey().equals(base.getType())) {
			BaseReservation model = baseReservationMapper.selectByPrimaryKey(base.getObjectId());
			if (model != null) {
				status = model.getStatus();
			}
		}

		List<Integer> actions = new ArrayList<Integer>();
		if (status == 3) {
			actions.add(WorkflowActionEnum.RESUBMIT.getValue());
			actions.add(WorkflowActionEnum.CANCEL.getValue());
		}

		if (status == 1) {
			actions.add(WorkflowActionEnum.PASS.getValue());
			actions.add(WorkflowActionEnum.REJECT.getValue());
		}
		dto.setActions(actions);
	}

	public Result<List<AuditDetailResDTO>> getAuditTaskHistory(String taskId) throws BaseException {
		Map<String, Object> taskMap = new HashMap<>(2);
		taskMap.put("taskId", taskId);
		Result<String> taskResult = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_BUSINESSKEY, taskMap,
				new BaseTypeReference<Result<String>>() {
				});

		String businessKey = taskResult.getResult();

		Map<String, Object> paramMap = new HashMap<>(2);
		paramMap.put("businessKey", businessKey);
		Result<List<AuditDetailResDTO>> result = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_AUDIT_LIST, paramMap,
				new BaseTypeReference<Result<List<AuditDetailResDTO>>>() {
				});

		List<AuditDetailResDTO> list = result.getResult();
		if (!BooleanUtils.isEmpty(list)) {
			for (AuditDetailResDTO dto : list) {
				dto.setActionText(WorkflowActionEnum.getName(dto.getActionValue()));
				dto.setActionUserName(userDetailService.getUserRealName(dto.getActionUserId()));

			}
		}

		return result;
	}

	/**
	 * 分页查询待办任务 getPage:
	 * 
	 * @author: 欧阳利
	 * @param dto
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public Result<PaginationSupport<TaskPageResDto>> getPage(TaskPageReqDto dto) throws BaseException {

		Result<PaginationSupport<TaskPageResDto>> result = HttpUtils.get(
				WorkflowUrlConstant.WORK_FLOW_GET_AUDIT_LIST_PAGE, ArgsUtils.toMap(dto),
				new BaseTypeReference<Result<PaginationSupport<TaskPageResDto>>>() {
				});

		if (result.getSuccess() && result.getResult() != null) {
			List<TaskPageResDto> taskDtos = result.getResult().getDatas();
			if (BooleanUtils.isEmpty(taskDtos)) {
				return result;
			}

			List<String> businesskeys = new ArrayList<String>();
			for (TaskPageResDto taskDto : taskDtos) {
				businesskeys.add(taskDto.getBusinesskey());
			}

			BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
			example.createCriteria().andBusinessNoIn(businesskeys);
			List<BaseWorkflowBusinessRel> list = baseWorkflowBusinessRelMapper.selectByExample(example);

			// 设置业务id和业务类型
			if (!BooleanUtils.isEmpty(list)) {
				for (TaskPageResDto taskDto : taskDtos) {
					for (BaseWorkflowBusinessRel model : list) {
						if (!BooleanUtils.isBlank(taskDto.getBusinesskey())
								&& taskDto.getBusinesskey().equals(model.getBusinessNo())) {
							BeanUtils.copyProperties(model, taskDto);
						}
					}
				}
			}

			// 设置内容和标题
			setContextAndTitle(taskDtos);

			// 设置申请人名称
			setApplyUserName(taskDtos);

			// 清楚有误数据
			result.getResult().setDatas(getValidTaskDtos(taskDtos));
		}

		return result;
	}

	@Override
	public Result<PaginationSupport<TaskPageResDto>> getDonePage(TaskDoneReqDto dto)
			throws BaseException {
		Result<PaginationSupport<TaskInfoResDTO>> result = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_DONE_PAGE,
				ArgsUtils.toMap(dto), new BaseTypeReference<Result<PaginationSupport<TaskInfoResDTO>>>() {
				});

		PaginationSupport paginationSupport=dto.getPaginationSupport();
				
		if (result.getSuccess() && result.getResult() != null) {
			List<TaskInfoResDTO> taskDtos = result.getResult().getDatas();
			if (BooleanUtils.isEmpty(taskDtos)) {
				return Result.newSuccessResult();
			}

			List<String> businesskeys = new ArrayList<String>();
			for (TaskInfoResDTO taskDto : taskDtos) {
				businesskeys.add(taskDto.getBusinessKey());
			}

			BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
			example.createCriteria().andBusinessNoIn(businesskeys);
			List<BaseWorkflowBusinessRel> list = baseWorkflowBusinessRelMapper.selectByExample(example);

			// 设置业务id和业务类型
			List<TaskPageResDto> resDtos=new ArrayList<>();
			
			if (!BooleanUtils.isEmpty(list)) {
				for (TaskInfoResDTO taskDto : taskDtos) {
					TaskPageResDto taskPageResDto=new TaskPageResDto();
					resDtos.add(taskPageResDto);
					taskPageResDto.setApplyTime(taskDto.getApplyTime());
					taskPageResDto.setApplyUserId(taskDto.getApplyUserId());
					taskPageResDto.setBusinesskey(taskDto.getBusinessKey());
					taskPageResDto.setEndTime(taskDto.getEndTime());
					taskPageResDto.setExecutionId(taskDto.getExecutionId());
					taskPageResDto.setTaskId(taskDto.getId());
					taskPageResDto.setProcessInstanceId(taskDto.getProcessInstanceId());
					taskPageResDto.setTaskName(taskDto.getName());
					taskPageResDto.setActionValue(taskDto.getActionValue());
					for (BaseWorkflowBusinessRel model : list) {
						if (!BooleanUtils.isBlank(taskDto.getBusinessKey())
								&& taskDto.getBusinessKey().equals(model.getBusinessNo())) {
							taskPageResDto.setObjectId(model.getObjectId());
							taskPageResDto.setType(model.getType());
						}
					}
				}
			}
			// 设置内容和标题
			setContextAndTitle(resDtos);

			// 设置申请人名称
			setApplyUserName(resDtos);
			
			paginationSupport.setDatas(getValidTaskDtos(resDtos));
			// 清楚有误数据
		}
		return Result.newSuccessResult(paginationSupport);
	}

	/**
	 * 清除有误数据
	 * 
	 * @param taskDtos
	 * @return
	 */
	private List<TaskPageResDto> getValidTaskDtos(List<TaskPageResDto> taskDtos) {
		List<TaskPageResDto> validTaskDtos = new ArrayList<TaskPageResDto>();
		for (TaskPageResDto dto : taskDtos) {
			if (BooleanUtils.isBlank(dto.getType())) {
				continue;
			}
			validTaskDtos.add(dto);
		}
		return validTaskDtos;
	}

	private void setApplyUserName(List<TaskPageResDto> taskDtos) {
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}
		List<Long> userIds = new ArrayList<Long>();
		for (TaskPageResDto dto : taskDtos) {
			userIds.add(dto.getApplyUserId());
		}

		List<BaseUserDetail> list = userDetailService.getUserDetail(userIds);
		if (BooleanUtils.isEmpty(list)) {
			return;
		}
		for (TaskPageResDto dto : taskDtos) {
			for (BaseUserDetail userDto : list) {
				if (dto.getApplyUserId() != null && dto.getApplyUserId().equals(userDto.getUserAccountId())) {
					dto.setApplyUserRealName(userDto.getRealName());
				}
			}
		}
	}

	/**
	 * 设置内容和标题 setContextAndTitle:
	 * 
	 * @author: 欧阳利
	 * @param taskDtos
	 * @description:
	 */
	private void setContextAndTitle(List<TaskPageResDto> taskDtos)throws BaseException {
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}

		// 设置产品相关信息
		setProductContextAndTitle(taskDtos);

		// 设置预约相关信息
		setReservatinContextAndTitle(taskDtos);

		// 设置报单的相关信息
		setDeclarationContextAndTitle(taskDtos);

		// 设置产品公告相关信息
		setProductNoticeContextAndTitle(taskDtos);
		
		// 设置结佣审批相关信息
		setRefundContextAndTitle(taskDtos);
		
		// 设置退款审批相关信息
		setKnotCommissionContextAndTitle(taskDtos);
		
	}

	
	private void setRefundContextAndTitle(List<TaskPageResDto> taskDtos){
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}
		List<TaskPageResDto> refundTaskDtos = getTaskPageResDtos(taskDtos,ProcessDefineKeyEnum.REFUND);
		List<Long> refundIds = getObjectIds(taskDtos,ProcessDefineKeyEnum.REFUND);
		if (BooleanUtils.isEmpty(refundIds)) {
			return;
		}
		
		
		List<RefundTaskDto>  list = taskMapper.getRefundTaskDtos(refundIds);
		
		
		for (TaskPageResDto dto : refundTaskDtos) {
			for (RefundTaskDto taskDto : list) {
				if (dto.getObjectId().equals(taskDto.getId())) {
					List<ContentDto> contentList = new ArrayList<ContentDto>();
					ContentDto d = new ContentDto();
					d.setName("报单编号");
					d.setText(taskDto.getNumber());
					contentList.add(d);
					
					ContentDto product = new ContentDto();
					product.setName("产品名称");
					product.setText(taskDto.getProductName());
					contentList.add(product);

					ContentDto de = new ContentDto();
					de.setName("打款金额");
					de.setText(SymbolStrUtils.doubleToString(taskDto.getDealAmount())+"万");
					contentList.add(de);

					ContentDto com = new ContentDto();
					com.setName("退款原因");
					com.setText(taskDto.getReason());
					contentList.add(com);

					dto.setContentList(contentList);
				}

			}
		}
		
	}
	
	

	
    private void setKnotCommissionContextAndTitle(List<TaskPageResDto> taskDtos)throws BaseException{
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}
		List<TaskPageResDto> commissionTaskDtos = getTaskPageResDtos(taskDtos,ProcessDefineKeyEnum.KNOT_COMMISSION);
		List<Long> commissionIds = getObjectIds(taskDtos,ProcessDefineKeyEnum.KNOT_COMMISSION);
		if (BooleanUtils.isEmpty(commissionIds)) {
			return;
		}
		
		List<KnotCommissionTaskDto> list = taskMapper.getKnotCommissionTaskDtos(commissionIds);
		if (BooleanUtils.isEmpty(list)) {
			return;
		}

		for (TaskPageResDto dto : commissionTaskDtos) {
			for (KnotCommissionTaskDto taskDto : list) {
				if (dto.getObjectId().equals(taskDto.getId())) {
					List<ContentDto> contentList = new ArrayList<ContentDto>();
					ContentDto product = new ContentDto();
					product.setName("产品名称");
					product.setText(taskDto.getProductName());
					contentList.add(product);

					ContentDto de = new ContentDto();
					de.setName("认购金额");
					de.setText(taskDto.getDealAmount().toString());
					contentList.add(de);

					taskDto.setTypeText(dictionaryService.toText("dic_knotcommission_type", taskDto.getType()));
					
					ContentDto com = new ContentDto();
					com.setName("佣金信息");
					com.setText(taskDto.getTypeText()+","+SymbolStrUtils.doubleToString(taskDto.getRate())+"%,"+SymbolStrUtils.doubleToString(taskDto.getAmount())+"元");
					contentList.add(com);

					dto.setContentList(contentList);
				}

			}
		}
	}
	
	
	private void setProductNoticeContextAndTitle(List<TaskPageResDto> taskDtos) {
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}
		List<TaskPageResDto> noticeTaskDtos = new ArrayList<TaskPageResDto>();
		List<Long> noticeIds = new ArrayList<Long>();
		for (TaskPageResDto dto : taskDtos) {
			if (ProcessDefineKeyEnum.PRODUCT_NOTICE.getKey().equals(dto.getType())) {
				noticeTaskDtos.add(dto);
				dto.setTitle(ProcessDefineKeyEnum.PRODUCT_NOTICE.getName());
				noticeIds.add(dto.getObjectId());
			}
		}
		if (BooleanUtils.isEmpty(noticeIds)) {
			return;
		}

		List<ProductNoticeDto> list = productNoticeExamineMapper.getProductNoticeDto(noticeIds);
		if (BooleanUtils.isEmpty(list)) {
			return;
		}

		for (TaskPageResDto dto : noticeTaskDtos) {
			for (ProductNoticeDto notice : list) {
				if (dto.getObjectId().equals(notice.getId())) {
					List<ContentDto> contentList = new ArrayList<ContentDto>();
					ContentDto customer = new ContentDto();
					customer.setName("产品名称");
					customer.setText(notice.getProductName());
					contentList.add(customer);

					ContentDto product = new ContentDto();
					product.setName("公告类型");
					product.setText(notice.getNoticeTypeName());
					contentList.add(product);

					ContentDto amount = new ContentDto();
					amount.setName("公告标题");
					amount.setText(notice.getTitle());
					contentList.add(amount);

					dto.setContentList(contentList);
				}

			}
		}

	}

	/**
	 * 设置报单相关信息 setDeclarationContextAndTitle:
	 * 
	 * @author: 欧阳利
	 * @param taskDtos
	 * @description:
	 */
	private void setDeclarationContextAndTitle(List<TaskPageResDto> taskDtos) {
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}
		List<TaskPageResDto> declarationTaskDtos = new ArrayList<TaskPageResDto>();
		List<Long> declarationIds = new ArrayList<Long>();
		for (TaskPageResDto dto : taskDtos) {
			if (ProcessDefineKeyEnum.DECLARATION.getKey().equals(dto.getType())) {
				declarationTaskDtos.add(dto);
				dto.setTitle(ProcessDefineKeyEnum.DECLARATION.getName());
				declarationIds.add(dto.getObjectId());
			}
		}
		if (BooleanUtils.isEmpty(declarationIds)) {
			return;
		}

		List<ProductDeclarationDto> list = declarationMapper.getProductDeclarationDtos(declarationIds);
		for (TaskPageResDto dto : declarationTaskDtos) {
			for (ProductDeclarationDto resDto : list) {
				if (dto.getObjectId().equals(resDto.getDeclarationId())) {
					List<ContentDto> contentList = new ArrayList<ContentDto>();
					ContentDto customer = new ContentDto();
					customer.setName("客户名称");
					customer.setText(resDto.getCustomerName());
					contentList.add(customer);

					ContentDto product = new ContentDto();
					product.setName("产品名称");
					product.setText(resDto.getProductName());
					contentList.add(product);

					ContentDto amount = new ContentDto();
					amount.setName("认购金额");
					amount.setText(SymbolStrUtils.doubleToString(resDto.getDealAmount()) + "万");
					contentList.add(amount);

					dto.setContentList(contentList);
					dto.setAuditStatus(resDto.getStatus());
				}
			}
		}

	}

	/**
	 * 设置预约 setReservatinContextAndTitle:
	 * 
	 * @author: 欧阳利
	 * @param taskDtos
	 * @description:
	 */
	private void setReservatinContextAndTitle(List<TaskPageResDto> taskDtos) {
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}
		List<TaskPageResDto> reservatinTaskDtos = new ArrayList<TaskPageResDto>();
		List<Long> reservationIds = new ArrayList<Long>();
		for (TaskPageResDto dto : taskDtos) {
			if (ProcessDefineKeyEnum.RESERVATIN.getKey().equals(dto.getType())) {
				reservatinTaskDtos.add(dto);
				dto.setTitle(ProcessDefineKeyEnum.RESERVATIN.getName());
				reservationIds.add(dto.getObjectId());
			}
		}
		if (BooleanUtils.isEmpty(reservationIds)) {
			return;
		}

		List<ProductReservationDto> list = reservationMapper.getProductReservationDtos(reservationIds);
		for (TaskPageResDto dto : reservatinTaskDtos) {
			for (ProductReservationDto resDto : list) {
				if (dto.getObjectId().equals(resDto.getReservationId())) {
					List<ContentDto> contentList = new ArrayList<ContentDto>();
					ContentDto customer = new ContentDto();
					customer.setName("客户名称");
					customer.setText(resDto.getCustomerName());
					contentList.add(customer);

					ContentDto product = new ContentDto();
					product.setName("产品名称");
					product.setText(resDto.getProductName());
					contentList.add(product);

					ContentDto amount = new ContentDto();
					amount.setName("预约金额");
					amount.setText(SymbolStrUtils.doubleToString(resDto.getReservationAmount()) + "万");
					contentList.add(amount);

					dto.setContentList(contentList);
					dto.setAuditStatus(resDto.getStatus());
				}
			}
		}

	}

	/**
	 * 设置产品相关信息 setProductContextAndTitle:
	 * 
	 * @author: 欧阳利
	 * @param taskDtos
	 * @description:
	 */
	private void setProductContextAndTitle(List<TaskPageResDto> taskDtos) {
		if (BooleanUtils.isEmpty(taskDtos)) {
			return;
		}

		List<TaskPageResDto> productTaskDtos = new ArrayList<TaskPageResDto>();
		List<Long> productIds = new ArrayList<Long>();
		for (TaskPageResDto dto : taskDtos) {
			if (ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey().equals(dto.getType())) {
				productTaskDtos.add(dto);
				dto.setTitle(ProcessDefineKeyEnum.PRODUCT_AUDIT.getName());
				productIds.add(dto.getObjectId());
			}
		}
		if (BooleanUtils.isEmpty(productIds)) {
			return;
		}

		BaseProductExample example = new BaseProductExample();
		example.createCriteria().andIdIn(productIds);
		List<BaseProduct> products = baseProductMapper.selectByExample(example);

		BaseProductExamineExample examineExample = new BaseProductExamineExample();
		examineExample.createCriteria().andProductIdIn(productIds);
		List<BaseProductExamine> productExamines = baseProductExamineMapper.selectByExample(examineExample);

		for (BaseProduct base : products) {
			for (TaskPageResDto dto : productTaskDtos) {
				if (base.getId().equals(dto.getObjectId())) {
					String name = base.getName();
					List<ContentDto> contentList = new ArrayList<ContentDto>();
					ContentDto contentDto = new ContentDto();
					contentDto.setName("产品名称");
					contentDto.setText(name);
					contentList.add(contentDto);
					dto.setContentList(contentList);
				}
			}
		}

		for (BaseProductExamine base : productExamines) {
			for (TaskPageResDto dto : productTaskDtos) {
				if (base.getProductId().equals(dto.getObjectId())) {
					dto.setAuditStatus(base.getStatus());
				}
			}
		}

	}
	
	private List<Long> getObjectIds(List<TaskPageResDto> taskDtos,ProcessDefineKeyEnum processDefineKeyEnum){
		if (BooleanUtils.isEmpty(taskDtos)) {
			return null;
		}
		List<Long> objectIds = new ArrayList<Long>();
		for (TaskPageResDto dto : taskDtos) {
			if (processDefineKeyEnum.getKey().equals(dto.getType())) {
				dto.setTitle(processDefineKeyEnum.getName());
				objectIds.add(dto.getObjectId());
			}
		}
		return objectIds;
	}
	
	private List<TaskPageResDto> getTaskPageResDtos(List<TaskPageResDto> taskDtos,ProcessDefineKeyEnum processDefineKeyEnum){
		if (BooleanUtils.isEmpty(taskDtos)) {
			return null;
		}
		List<TaskPageResDto> taskPageResDtos = new ArrayList<TaskPageResDto>();
		for (TaskPageResDto dto : taskDtos) {
			if (processDefineKeyEnum.getKey().equals(dto.getType())) {
				taskPageResDtos.add(dto);
				dto.setTitle(processDefineKeyEnum.getName());
			}
		}
		return taskPageResDtos;
	}

}
