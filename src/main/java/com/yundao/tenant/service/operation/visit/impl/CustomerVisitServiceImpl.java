package com.yundao.tenant.service.operation.visit.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.DateUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.DicCode;
import com.yundao.tenant.enums.msg.MsgMessageCodeEnum;
import com.yundao.tenant.mapper.base.customer.BaseUserVisitMapper;
import com.yundao.tenant.mapper.base.sale.BaseLeadsVisitRelMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseUserVisit;
import com.yundao.tenant.model.base.customer.BaseUserVisitExample;
import com.yundao.tenant.model.base.sale.BaseLeadsVisitRel;
import com.yundao.tenant.model.base.sale.BaseLeadsVisitRelExample;
import com.yundao.tenant.service.customer.customer.CustomerService;
import com.yundao.tenant.service.dictionary.DictionaryService;
import com.yundao.tenant.service.msg.msgmessage.MsgMessageService;
import com.yundao.tenant.service.operation.visit.CustomerVisitService;
import com.yundao.tenant.service.user.UserDetailService;
import com.yundao.tenant.service.user.customer.UserCustomerService;
import com.yundao.tenant.util.DateUtil;


@Service
public class CustomerVisitServiceImpl extends AbstractService implements CustomerVisitService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserCustomerService userCustomerService;

    @Autowired
    private MsgMessageService msgMessageService;

    @Autowired
    private BaseUserVisitMapper baseUserVisitMapper;

    @Autowired
    private UserDetailService userDetailService;
    
    @Autowired
    private BaseLeadsVisitRelMapper baseLeadsVisitRelMapper;
    
    @Autowired
    private DictionaryService dictionaryService;
    
    private static Log log = LogFactory.getLog(CustomerVisitServiceImpl.class);

    /**
     * 客户发送消息回访
     *
     * @param id 回访id
     * @throws BaseException
     */
    @Override
    public void visitCustomerSendMessage(Long id) throws BaseException {
        BaseUserVisit baseUserVisit = baseUserVisitMapper.selectByPrimaryKey(id);
        if (baseUserVisit == null) {
            return;
        }
        BaseCustomer customer = customerService.get(baseUserVisit.getCustomerId()).getResult();
        if (customer == null) {
            throw new BaseException(CodeConstant.CODE_1200084);
        }
        Long userId = userCustomerService.getUserIdByCustomer(baseUserVisit.getCustomerId());
        if (userId == null) {
            log.warn("客户发送消息回访时没有找到对应的理财师, customerId=" + baseUserVisit.getCustomerId());
            return;
        }

        
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("content", baseUserVisit.getContent());
        parm.put("customerMobile", customer.getMobile());
        parm.put("customerName", customer.getName());
        parm.put("customerId", baseUserVisit.getCustomerId());
        parm.put("userId", userId);
        parm.put("visitId", baseUserVisit.getId());
        parm.put("visitOperationUserId", this.getHeaderUserId());
        parm.put("visitOperationUserName", userDetailService.getUserRealName(this.getHeaderUserId()));
        parm.put("type", dictionaryService.toText(DicCode.DIC_USER_VISIT_TYPE, baseUserVisit.getType())) ;
        parm.put("status",  dictionaryService.toText(DicCode.DIC_USER_VISIT_STATUS, baseUserVisit.getStatus()));
        msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_VISIT.getCode(), parm);
        
        // 下次回访
        if(baseUserVisit.getNextTime() != null){
        	// 创建记录
            BaseUserVisit record = new BaseUserVisit();
            record.setCustomerId(baseUserVisit.getCustomerId());
            record.setUserId(baseUserVisit.getUserId());
            record.setMatter(baseUserVisit.getMatter());
            record.setSubDate(new Date());
            record.setCreateUserId(baseUserVisit.getUserId());
            record.setTenantId(this.getHeaderTenantId());
            record.setCreateDate(new Date());
            record.setIsDelete(0);
            record.setSendStatus(0);
            baseUserVisitMapper.insert(record);

            // 修改下次回访id
            BaseUserVisit oldBaseUserVisit = new BaseUserVisit();
            oldBaseUserVisit.setSendStatus(0);// 0：没有发送，1：已经发送，2 ：不需要发送
            oldBaseUserVisit.setId(baseUserVisit.getId());
            oldBaseUserVisit.setNextVisitId(record.getId());
            baseUserVisitMapper.updateByPrimaryKeySelective(oldBaseUserVisit);
            
            // 添加关系
            addLeadsVisitRef(baseUserVisit.getId(), record.getId());
            
            // 如下下次更加时间是今天
            Date nowEndTime = DateUtil.toEndDate(new Date());
            if(baseUserVisit.getNextTime().before(nowEndTime)){
            	createNextVisitUpcoming(baseUserVisit,  customer);
            }
        }
        
    }


    /**
     * 创建下次回访代办
     *
     * @param baseUserVisit 回访
     * @param customer      客户
     * @throws BaseException
     */
    private void createNextVisitUpcoming(BaseUserVisit baseUserVisit, BaseCustomer customer) throws BaseException {
        if (baseUserVisit == null || baseUserVisit.getNextTime() == null) {
            return;
        }

        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("customerMobile", customer.getMobile());
        parm.put("customerName", customer.getName());
        parm.put("customerId", baseUserVisit.getCustomerId());
        parm.put("userId", baseUserVisit.getUserId());
        parm.put("visitId", baseUserVisit.getId());
        parm.put("nextTime", DateUtils.format(baseUserVisit.getNextTime(), DateUtils.YYYY_MM_DD_HH_MM));
        msgMessageService.processSendMessage(MsgMessageCodeEnum.CUSTOMER_NEXT_VISIT.getCode(), parm);
        
        
        BaseUserVisit oldBaseUserVisit = new BaseUserVisit();
        oldBaseUserVisit.setSendStatus(1);// 0：没有发送，1：已经发送，2 ：不需要发送
        oldBaseUserVisit.setId(baseUserVisit.getId());
        baseUserVisitMapper.updateByPrimaryKeySelective(oldBaseUserVisit);
    }


    /**
     * 创建下次回访记录
     *
     * @param messageId
     * @throws BaseException
     */
    @Override
    public void doNextVisitCustomerSendMessage() throws Exception {
        //获取今天未生成消息
        Date nowEnd = DateUtils.parse(DateUtils.getDateEnd(new Date()), DateUtils.YY_MM_DD_HH_MM_SS);
        BaseUserVisitExample example = new BaseUserVisitExample();
        example.createCriteria().andNextTimeIsNotNull()
                .andNextTimeLessThanOrEqualTo(nowEnd).andSendStatusEqualTo(0);

        List<BaseUserVisit> list = baseUserVisitMapper.selectByExample(example);

        if (BooleanUtils.isEmpty(list)) {
            return;
        }
        for (BaseUserVisit baseUserVisit : list) {
            BaseCustomer customer = customerService.get(baseUserVisit.getCustomerId()).getResult();

            // 创建下次回访代办
            createNextVisitUpcoming(baseUserVisit, customer);
        }
    }
    
    
    
    private void addLeadsVisitRef(Long parentId,Long id){
    	BaseLeadsVisitRelExample example = new BaseLeadsVisitRelExample();
    	example.createCriteria().andUserVisitIdEqualTo(parentId);
    	BaseLeadsVisitRel base = baseLeadsVisitRelMapper.selectOne(example);
    	if(base == null){
    		return ;
    	}
        BaseLeadsVisitRel rel = new BaseLeadsVisitRel();
        super.initialModel(rel);
        rel.setLeadsId(base.getLeadsId());
        rel.setUserVisitId(id);
        baseLeadsVisitRelMapper.insertSelective(rel);
    }
    
    
}
