package com.yundao.tenant.service.product.examine.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.dto.product.examine.ProductAuditRecordResDto;
import com.yundao.tenant.dto.product.examine.ProductAuditReqDto;
import com.yundao.tenant.dto.product.examine.ProductExaminePageReqDto;
import com.yundao.tenant.dto.product.examine.ProductExaminePageResDto;
import com.yundao.tenant.dto.sale.declaration.ProductDeclarationAmountDto;
import com.yundao.tenant.dto.sale.reservation.ProductReservationAmountDto;
import com.yundao.tenant.dto.workflow.AuditDetailResDTO;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.enums.product.examine.ProductExamineStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.product.BaseProductExamineMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.product.examine.ProductExamineMapper;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.mapper.sale.reservation.ReservationMapper;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExamine;
import com.yundao.tenant.model.base.product.BaseProductExamineExample;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;
import com.yundao.tenant.service.product.examine.ProductExamineService;
import com.yundao.tenant.service.role.RoleService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.workflow.WorkflowBusinessRelService;
import com.yundao.tenant.service.workflow.WorkflowServie;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.SymbolStrUtils;

/**
 * 产品审核服务实现类
 *
 * @author jan
 * @create 2017-07-22 PM3:28
 **/
@Service
public class ProductExamineServiceImpl extends AbstractService implements ProductExamineService {

    private static Log log = LogFactory.getLog(ProductExamineServiceImpl.class);

    @Autowired
    private ProductExamineMapper productExamineMapper;

    @Autowired
    private BaseProductExamineMapper baseProductExamineMapper;

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private WorkflowServie workflowServie;
    
    @Autowired
    private WorkflowBusinessRelService workflowBusinessRelService;
    
	@Autowired
	ReservationMapper reservationMapper;
	
	@Autowired
	DeclarationMapper declarationMapper;
	
	@Autowired
	UserDetailService userDetailService;

    /**
     * 检查产品是否审核中
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    public boolean checkProductIsApprovaling(Long productId) throws BaseException {
        if (productId == null) {
            throw new BaseException(CodeConstant.CODE_1200041);
        }
        BaseProductExamineExample example = new BaseProductExamineExample();
        example.createCriteria().andProductIdEqualTo(productId);
        BaseProductExamine product = baseProductExamineMapper.selectOne(example);
        if (product == null) {
            return false;
        }
        if (ProductExamineStatusEnum.APPROVALING.getValue().equals(product.getStatus())) {
            return true;
        }
        return false;
    }


    /**
     * 产品当前产品的审核信息
     *
     * @param productId
     * @return
     * @throws BaseException
     */
    @Override
    public BaseProductExamine getCurrentBaseProductExamine(Long productId) throws BaseException {
        BaseProductExamineExample example = new BaseProductExamineExample();
        example.createCriteria().andProductIdEqualTo(productId);
        BaseProductExamine product = baseProductExamineMapper.selectOne(example);
        return product;
    }


    @Override
    public PaginationSupport<ProductExaminePageResDto> getPage(ProductExaminePageReqDto dto) throws BaseException {
        log.begin(dto);

        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<ProductExaminePageResDto> page = PaginationSupport.newDefault(paramMap);
        List<ProductExaminePageResDto> dtos = productExamineMapper.selectPage(paramMap);
        int count = productExamineMapper.selectPageCount(paramMap);
        this.setText(dtos);
        this.setAuditPermission(dtos);
        settReservationAndDeclarationAmount(dtos);
        page.setTotalCount(count);
        page.setDatas(dtos);
        log.end();
        return page;
    }
    
    
    private void settReservationAndDeclarationAmount(List<ProductExaminePageResDto> datas){
    	if(BooleanUtils.isEmpty(datas)){
    		return;
    	}
    	List<Long> allProductIds = new ArrayList<Long>();
    	for(ProductExaminePageResDto dto : datas){
    		allProductIds.add(dto.getProductId());
    		dto.setBusinessTypeText(ProcessDefineKeyEnum.getName(dto.getBusinessType()));
    	}
    	
		// 设置预约金额
		List<ProductReservationAmountDto> productAmounts = reservationMapper.getProductReservationAmountDtos(allProductIds);
		if(!BooleanUtils.isEmpty(productAmounts)){
			for (ProductExaminePageResDto dto : datas) {
				 for(ProductReservationAmountDto amountDto : productAmounts){
					 if(dto.getProductId().equals(amountDto.getProductId())){
						 if(amountDto.getSumAmount() != null){
							 dto.setReservationAmount(SymbolStrUtils.doubleToString(amountDto.getSumAmount()));
						 }
						
					 }
				 }
			}
		}
		
		// 设置报单金额
		List<ProductDeclarationAmountDto> declarationAmountDtos =  declarationMapper.getProductDeclarationAmountDtos(allProductIds);
		if(!BooleanUtils.isEmpty(declarationAmountDtos)){
			for (ProductExaminePageResDto dto : datas) {
				 for(ProductDeclarationAmountDto amountDto : declarationAmountDtos){
					 if(dto.getProductId().equals(amountDto.getProductId())){
						 if(amountDto.getSumAmount() != null){
							 dto.setDeclarationAmount(SymbolStrUtils.doubleToString(amountDto.getSumAmount()));
						 }
					 }
				 }
			}
		}
    }
    
    

    @Override
    public Result<Long> doAudit(ProductAuditReqDto dto) throws BaseException {
        log.info("dto:%s", JsonUtils.objectToJson(dto));
        //审核操作，只能通过或驳回
        if (WorkflowActionEnum.PASS.getValue() != dto.getAction() 
        		&& dto.getAction() != WorkflowActionEnum.REJECT.getValue()
        		&& dto.getAction() != WorkflowActionEnum.CANCEL.getValue())
        {
        	throw new BaseException(CodeConstant.CODE_1220038);
        }
        
        BaseProductExamine examine = baseProductExamineMapper.selectByPrimaryKey(dto.getId());
        if (examine == null){
        	throw new BaseException(CodeConstant.CODE_1220032);
        }
            

        //获取产品
        BaseProduct product = baseProductMapper.selectByPrimaryKey(examine.getProductId());
        if (product == null)
            throw new BaseException(CodeConstant.CODE_1220031);

        if (ProductExamineStatusEnum.APPROVALING.getValue().intValue() != examine.getStatus())
            throw new BaseException(CodeConstant.CODE_1220039);

        boolean isPass = WorkflowActionEnum.PASS.getValue().intValue() == dto.getAction();

        Boolean isCancel = dto.getAction() == WorkflowActionEnum.CANCEL.getValue();
        
        //调用工作流
        String taskId = workflowServie.getTODOTaskId(product.getId(), BusinessTypeCode.PRODUCT_AUDIT,isCancel).getResult();
        workflowServie.complete(taskId, dto.getAction(), dto.getReason());

        super.updateModel(examine);
        examine.setApproveId(super.getHeaderUserId());
        examine.setApproveDate(new Date());
        examine.setReason(dto.getReason());
        if (WorkflowActionEnum.PASS.getValue() == dto.getAction() ) {
            //审核通过
            examine.setStatus(ProductExamineStatusEnum.PASS.getValue());
            examine.setIssuedStatus(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
        }else if (WorkflowActionEnum.CANCEL.getValue() == dto.getAction() ) {
            //取消
            examine.setStatus(ProductExamineStatusEnum.CANCEL.getValue());
        }else  if (WorkflowActionEnum.REJECT.getValue() == dto.getAction() ){
        	 //驳回
            examine.setStatus(ProductExamineStatusEnum.REJECT.getValue());
        }
        baseProductExamineMapper.updateByPrimaryKeySelective(examine);

        if (isPass) {
            //审核通过，同时修改产品的发行状态
            super.updateModel(product);
            product.setIssuedStatus(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
            baseProductMapper.updateByPrimaryKeySelective(product);
        }
        log.end();
        return Result.newSuccessResult(examine.getId());
    }

    private void setText(List<ProductExaminePageResDto> dtos) throws BaseException {
        for (ProductExaminePageResDto dto : dtos) {
            dto.setStatusText(ProductExamineStatusEnum.getEnumName(dto.getStatus()));
            dto.setIssuedStatusText(ProductIssuedStatusEnum.getEnumName(dto.getIssuedStatus()));
            dto.setReqIssuedStatusText(ProductIssuedStatusEnum.getEnumName(dto.getReqIssuedStatus()));
            //先根据当前状态判断是否能进行审核，下面还要根据工作流判断
            dto.setCanAudit(ProductExamineStatusEnum.canAudit(dto.getStatus()));
        }
    }

    /**
     * 判断是否有审核操作
     */
    private void setAuditPermission(List<ProductExaminePageResDto> dtos) throws BaseException {
//        //工作流获取
//        List<Long> roles = roleService.getsByUserId().getResult();
//        Map<String, Object> wfMap = new HashMap<>();
//        //wfMap.put("resourceName", ConfigUtils.getValue(ConfigCode.WORK_FLOW_PRODUCT_AUDIT));
//        wfMap.put("processDefineKey", ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey());
//        wfMap.put(HeaderConstant.USER_ROLE, SymbolStrUtils.longToStr(roles));
//        Result<List<TaskResDTO>> taskResult = HttpUtils.get(WorkflowUrlConstant.WORK_FLOW_GET_BY_RESOURCE, wfMap, new BaseTypeReference<Result<List<TaskResDTO>>>() {
//        });
//        log.info("taskResult:%s", JsonUtils.objectToJson(taskResult));
//        List<TaskResDTO> tasks = taskResult.getResult();
//        if (BooleanUtils.isEmpty(tasks)) {
//            for (ProductExaminePageResDto dto : dtos)
//                dto.setCanAudit(false);
//            return;
//        }
//
//        List<String> businessKeys = LambdaMap.toSingleList(tasks, m -> m.getBusinessKey());
//
        for (ProductExaminePageResDto dto : dtos) {
        	if(ProductExamineStatusEnum.canAudit(dto.getStatus())){
        		 dto.setCanAudit(true);
        	}else{
        		 dto.setCanAudit(false);
        	}
        }
    }
    
    
    /**
     * 查询产品的审核历史记录
     * getAuditDetail:
     * @author: 欧阳利
     * @param productId
     * @return
     * @throws BaseException
     * @description:
     */
    public Result<List<ProductAuditRecordResDto>> getAuditDetail(Long productId)throws BaseException{
    	List<String> businessTypeCodes = new ArrayList<String>();
    	businessTypeCodes.add(ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey());
    	List<BaseWorkflowBusinessRel> businessList = workflowBusinessRelService.getBusinessNos(productId, businessTypeCodes);
    	
    	List<ProductAuditRecordResDto> list = new ArrayList<ProductAuditRecordResDto>();
    	if(!BooleanUtils.isEmpty(businessList)){
    		List<String> businessNos = new ArrayList<String>();
    		for(BaseWorkflowBusinessRel rel : businessList){
    			ProductAuditRecordResDto dto = new ProductAuditRecordResDto();
    			BeanUtils.copyProperties(rel, dto);
    			list.add(dto);
    			dto.setTypeText(ProcessDefineKeyEnum.getName(dto.getType()));
    			dto.setAuditList(workflowServie.getWorkflowList(dto.getBusinessNo()));
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
