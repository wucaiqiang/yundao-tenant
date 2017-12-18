package com.yundao.tenant.service.product.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.workflow.BusinessTypeCode;
import com.yundao.tenant.enums.ProcessDefineKeyEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.enums.product.ProductIssuedStatusEnum;
import com.yundao.tenant.enums.product.ProductManagerActionEnum;
import com.yundao.tenant.enums.product.examine.ProductExamineStatusEnum;
import com.yundao.tenant.enums.workflow.WorkflowActionEnum;
import com.yundao.tenant.mapper.base.product.BaseProductExamineMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.mapper.product.examine.ProductExamineMapper;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.model.base.product.BaseProductExamine;
import com.yundao.tenant.model.base.product.BaseProductExamineExample;
import com.yundao.tenant.model.base.product.BaseProductExample;
import com.yundao.tenant.service.product.ProductSendService;
import com.yundao.tenant.service.product.ProductStatusService;
import com.yundao.tenant.service.workflow.WorkflowServie;

/**
 * 修改产品状态
 *
 * @author 欧阳利
 *         2017年7月27日
 */
@Service
public class ProductStatusServiceImpl extends AbstractService implements ProductStatusService {

    @Autowired
    BaseProductExamineMapper baseProductExamineMapper;
    
    @Autowired
    BaseProductMapper baseProductMapper;
    
    @Autowired
    ProductSendService productSendService;

    @Autowired
    private WorkflowServie workflowServie;
    
    @Autowired
    private ProductExamineMapper productExamineMapper;

    /**
     * 修改产品状态
     *
     * @param productId
     * @param productManagerAction
     * @return
     * @throws BaseException
     */
    @Override
    public Result<Integer> updateProductStatus(Long productId, Integer productManagerAction,Integer declarationModel,String reason) throws BaseException {
        if (ProductManagerActionEnum.APPLY_ON_LINE.getCode().equals(productManagerAction)) {
            applyOnLine(productId);
        }if (ProductManagerActionEnum.AGAIN_APPLY_ON_LINE.getCode().equals(productManagerAction)) {
        	againSubmit(productId);
        }else if (ProductManagerActionEnum.CANCEL_APPLY_ON_LINE.getCode().equals(productManagerAction)) {
            cancelApplyOnLise(productId,reason);
        } else if (ProductManagerActionEnum.STOP_ISSUED.getCode().equals(productManagerAction)) {
            stopIssued(productId);
        } else if (ProductManagerActionEnum.START_UP_PRE_SAISE.getCode().equals(productManagerAction)) {
            startUpPreRaise(productId);
        } else if (ProductManagerActionEnum.START_ON_LINE_RAISE_ING.getCode().equals(productManagerAction)) {
            startOnLineRaiseIng(productId,declarationModel);
        } else if (ProductManagerActionEnum.RETURN_ON_LINE_READY.getCode().equals(productManagerAction)) {
            returnOnLineReady(productId);
        } else if (ProductManagerActionEnum.START_RAISE.getCode().equals(productManagerAction)) {
            startRaise(productId,declarationModel);
        } else if (ProductManagerActionEnum.SET_RAISE_END.getCode().equals(productManagerAction)) {
            setRaiseEnd(productId);
        } else if (ProductManagerActionEnum.SET_SURVIVING.getCode().equals(productManagerAction)) {
            setSurviving(productId);
        } else if (ProductManagerActionEnum.SET_CLEAR_OUT.getCode().equals(productManagerAction)) {
            setClearOut(productId);
        } else if (ProductManagerActionEnum.OPEN_PURCHASE.getCode().equals(productManagerAction)) {
            openPurchase(productId,declarationModel);
        } else if (ProductManagerActionEnum.RETURN_ON_LINE_READY_FROM_RAISE.getCode().equals(productManagerAction)) {
        	 returnOnLineReady(productId);
        }
        return Result.newSuccessResult(1);
    }

    
    /**
     * 重新提交
     * againSubmit:
     * @author: 欧阳利
     * @param productId
     * @throws BaseException
     * @description:
     */
    private void againSubmit(Long productId)throws BaseException{
    	String taskId = workflowServie.getTODOTaskId(productId, BusinessTypeCode.PRODUCT_AUDIT,false).getResult();
    	
    	workflowServie.complete(taskId, WorkflowActionEnum.RESUBMIT.getValue());
    	
        // 设置当前值0
        BaseProductExamine productExamine = new BaseProductExamine();
        productExamine.setStatus(ProductExamineStatusEnum.APPROVALING.getValue());
        productExamine.setUpdateDate(new Date());
        productExamine.setUpdateUserId(this.getHeaderUserId());
        
        BaseProductExamineExample example = new BaseProductExamineExample();
        example.createCriteria().andProductIdEqualTo(productId);
        baseProductExamineMapper.updateByExampleSelective(productExamine, example);
        productSendService.auditProduct(productId, this.getHeaderUserId(), MsgMessageCodeEnum.PRODUCT_AGAIN_AUDIT.getCode());
    }
    
    

    /**
     * 申请上线
     *
     * @param productId
     */
    private void applyOnLine(Long productId) throws BaseException {

        workflowServie.start(productId,ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey(), BusinessTypeCode.PRODUCT_AUDIT);

        BaseProductExamineExample example = new BaseProductExamineExample();
        example.createCriteria().andProductIdEqualTo(productId);
        BaseProductExamine base = baseProductExamineMapper.selectOne(example);
        
        if(base == null){
            BaseProductExamine record = new BaseProductExamine();
            record.setProductId(productId);
            record.setTenantId(this.getHeaderTenantId());
            record.setCreateDate(new Date());
            record.setCreateUserId(this.getHeaderUserId());
            record.setIssuedStatus(ProductIssuedStatusEnum.NOT_ON_LINE.getValue());
            record.setReqIssuedStatus(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
            record.setStatus(ProductExamineStatusEnum.APPROVALING.getValue());
            record.setBusinessType(ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey());
            record.setApplyUserId(this.getHeaderUserId());
            record.setIsDelete(0);
            baseProductExamineMapper.insert(record);
        }else{
        	 BaseProductExamine record = new BaseProductExamine();
        	 record.setId(base.getId());
        	 record.setIssuedStatus(ProductIssuedStatusEnum.NOT_ON_LINE.getValue());
             record.setReqIssuedStatus(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
             record.setStatus(ProductExamineStatusEnum.APPROVALING.getValue());
             record.setBusinessType(ProcessDefineKeyEnum.PRODUCT_AUDIT.getKey());
             record.setApplyUserId(this.getHeaderUserId());
             record.setApproveId(null);
             record.setApproveDate(null);
             record.setReason(null);
             record.setUpdateDate(new Date());
             record.setUpdateUserId(this.getHeaderUserId());
             productExamineMapper.updateApplyOnLine(record);
        }
        
        productSendService.auditProduct(productId, this.getHeaderUserId(), MsgMessageCodeEnum.PRODUCT_ON_LINE_AUDIT.getCode());
    }

    /**
     * 取消产品上线
     *
     * @param productId
     */
    private void cancelApplyOnLise(Long productId,String reason) throws BaseException {
    	if(StringUtils.isBlank(reason)){
    		throw new BaseException(CodeConstant.CODE_1200168);
    	}
    	String taskId = workflowServie.getTODOTaskId(productId, BusinessTypeCode.PRODUCT_AUDIT,true).getResult();
    	
    	workflowServie.complete(taskId, WorkflowActionEnum.CANCEL.getValue(),reason);
    	
    	
        BaseProductExamine productExamine = new BaseProductExamine();
        productExamine.setStatus(ProductExamineStatusEnum.CANCEL.getValue());
        productExamine.setReason(reason);
        productExamine.setUpdateDate(new Date());
        productExamine.setUpdateUserId(this.getHeaderUserId());

        BaseProductExamineExample example = new BaseProductExamineExample();
        example.createCriteria().andProductIdEqualTo(productId);
        baseProductExamineMapper.updateByExampleSelective(productExamine, example);
    }

    /**
     * 上线准备中
     * 终止发行   from     预售                             to 未上线
     * 募集中
     *
     * @param productId
     */
    private void stopIssued(Long productId) {
//        // 设置当前值0
//        BaseProductExamine productExamine = new BaseProductExamine();
//        productExamine.setIsCurrent(0);
//        productExamine.setUpdateDate(new Date());
//        productExamine.setUpdateUserId(this.getHeaderUserId());
//        BaseProductExamineExample example = new BaseProductExamineExample();
//        example.createCriteria().andProductIdEqualTo(productId).andIsCurrentEqualTo(1);
//        baseProductExamineMapper.updateByExampleSelective(productExamine, example);

        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.NOT_ON_LINE.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());
        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId);
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }

    /**
     * 启动上线发行：预售  目标状态    from 上线准备中   to  预售
     *
     * @param productId
     */
    private void startUpPreRaise(Long productId)throws BaseException{
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.PRE_SAISE.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());
        baseProduct.setOnLineTime(new Date());

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
        
        productSendService.productOnLine(productId);
    }

    /**
     * 启动上线发行：募集中    from 上线准备中    to 募集中
     */
    private void startOnLineRaiseIng(Long productId,Integer declarationModel)throws BaseException{
    	if(declarationModel == null){
    		throw new BaseException(CodeConstant.CODE_1200144);
    	}
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.TO_RAISE.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());
        baseProduct.setOnLineTime(new Date());
        baseProduct.setDeclarationModel(declarationModel);

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
        
        productSendService.productOnLine(productId);
    }


    /**
     * from 状态： 募集中   to  上线准备中
     * 返回上线准备       from 状态：  预售      to  上线准备中
     */
    private void returnOnLineReady(Long productId) {
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId);
        // .andIssuedStatusEqualTo(ProductIssuedStatusEnum.ON_LINE_PRE.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }

    /**
     * 启动募集  from 预售    to 募集中
     *
     * @param productId
     */
    private void startRaise(Long productId,Integer declarationModel) throws BaseException{
    	if(declarationModel == null){
    		throw new BaseException(CodeConstant.CODE_1200144);
    	}
    	
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.TO_RAISE.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());
        baseProduct.setDeclarationModel(declarationModel);

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.PRE_SAISE.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }


    /**
     * 设为募集结束   from 募集中  to 募集结束
     */
    private void setRaiseEnd(Long productId) {
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.RAISE_END.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.TO_RAISE.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }


    /**
     * 设为存续／封闭     from 募集结束  to 存续／封闭中
     */
    private void setSurviving(Long productId) {
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.SURVIVING.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.RAISE_END.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }

    /**
     * 状态：清算退出    from   存续/封闭中    to   清算退出
     */
    private void setClearOut(Long productId) {
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.CLEAR_OUT.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.SURVIVING.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }

    /**
     * 开放申购  from 存续/封闭中    to   募集中
     */
    private void openPurchase(Long productId,Integer declarationModel) throws BaseException{
    	if(declarationModel == null){
    		throw new BaseException(CodeConstant.CODE_1200144);
    	}
    	
        BaseProduct baseProduct = new BaseProduct();
        baseProduct.setIssuedStatus(ProductIssuedStatusEnum.TO_RAISE.getValue());
        baseProduct.setUpdateDate(new Date());
        baseProduct.setUpdateUserId(this.getHeaderUserId());
        baseProduct.setDeclarationModel(declarationModel);

        BaseProductExample baseProductExample = new BaseProductExample();
        baseProductExample.createCriteria().andIdEqualTo(productId)
                .andIssuedStatusEqualTo(ProductIssuedStatusEnum.SURVIVING.getValue());
        baseProductMapper.updateByExampleSelective(baseProduct, baseProductExample);
    }
}
