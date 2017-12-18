package com.yundao.tenant.service.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.enums.ExamineGroupEnum;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.sale.declaration.DeclarationMapper;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.service.fieldgroup.FieldGroupService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.product.ProductSelectService;
import com.yundao.tenant.service.product.ProductSendService;
import com.yundao.tenant.service.product.attach.ProductAttachService;
import com.yundao.tenant.service.resource.ResourceService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.SymbolStrUtils;

@Service
public class ProductSendServiceImpl implements ProductSendService {

    private static Log log = LogFactory.getLog(ProductSendServiceImpl.class);
	@Autowired
	MsgMessageService msgMessageService;
	@Autowired
	UserDetailService userDetailService;
	@Autowired
	FieldGroupService fieldGroupService;
	@Autowired
	ProductSelectService productSelectService;
	@Autowired
	ProductAttachService productAttachService;
	@Autowired
	UserService userService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	DeclarationMapper declarationMapper;
	/**
	 * 新产品上线
	 */
	@Override
	public void productOnLine(Long productId)throws BaseException {
		BaseProduct baseProduct = productSelectService.getBaseProduct(productId);
		if(baseProduct == null){
			log.error("产品存在productId="+productId);
			return;
		}
		if(baseProduct.getTypeId() == null){
			log.error("产品类型为空");
			return;
		}
		List<Long> userIds = userService.getUserIds();
		if(BooleanUtils.isEmpty(userIds)){
			log.error("新产品上线, 没有通知的人员");
			return;
		}
		String productName = baseProduct.getName();
		String productTypeName= fieldGroupService.getNameById(baseProduct.getTypeId());
		Map<String,Object> parm = new HashMap<String,Object>();
		parm.put("productId", productId);
		parm.put("productName", productName);
		parm.put("productTypeName", productTypeName);
		parm.put("userIds", SymbolStrUtils.longToStr(userIds));
		msgMessageService.processSendMessage(MsgMessageCodeEnum.PRODUCT_ON_LINE.getCode(), parm);
	}

	
	@Override
	public void addProductAttach(Long productId,Long attachId,String attachSourceName,String attachUrl)throws BaseException {
		BaseProduct baseProduct = productSelectService.getBaseProduct(productId);
		List<Long> userIds = new ArrayList<Long>();
		if(baseProduct.getAssistantId() != null){
			userIds.add(baseProduct.getAssistantId());
		}

		if(baseProduct.getReceiverId() != null){
			userIds.add(baseProduct.getReceiverId());
		}
		
		// 添加 有报单的理财师
		List<Long> fpIds = declarationMapper.getFpDeclarationByProductId(baseProduct.getId());
		if(!BooleanUtils.isEmpty(fpIds)){
			for(Long userId : fpIds){
				if(!userIds.contains(userId)){
					userIds.add(userId);
				}
			}
		}
		
		if(BooleanUtils.isEmpty(userIds)){
			return;
		}
		
		String productName = baseProduct.getName();
		Map<String,Object> parm = new HashMap<String,Object>();
		parm.put("productId", productId);
		parm.put("productName", productName);
		parm.put("attachId", attachId);
		parm.put("attachSourceName", attachSourceName);
		parm.put("attachUrl", attachUrl);
		parm.put("userIds", SymbolStrUtils.longToStr(userIds));
		msgMessageService.processSendMessage(MsgMessageCodeEnum.PRODUCT_ADD_ATTACH.getCode(), parm);
	}

	/**
	 * 有待上线审核的产品
	 */
	@Override
	public void auditProduct(Long productId,Long submitUserId,String code)throws BaseException {
		BaseProduct baseProduct = productSelectService.getBaseProduct(productId);
		if(baseProduct == null || baseProduct.getReceiverId() == null){
			return;
		}
		
		List<Long> userIds = resourceService.getUserIds(ExamineGroupEnum.PRODUCT_AUDIT_GROUP.getResourceCode());
		
		String productName = baseProduct.getName();
		Long productTypeId = baseProduct.getTypeId();
		String submitUserRealName = userDetailService.getUserRealName(submitUserId);
		String productTypeName= fieldGroupService.getNameById(productTypeId);
		Map<String,Object> parm = new HashMap<String,Object>();
		parm.put("productId", productId);
		parm.put("productName", productName);
		parm.put("submitUserRealName", submitUserRealName);
		parm.put("productTypeName", productTypeName);
		parm.put("userIds", SymbolStrUtils.longToStr(userIds));
		msgMessageService.processSendMessage(code, parm);
	}
	
}
