package com.yundao.tenant.service.workflow.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.base.sale.BaseWorkflowBusinessRelMapper;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRelExample;
import com.yundao.tenant.service.workflow.WorkflowBusinessRelService;
import com.yundao.tenant.util.lambda.LambdaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作流业务关系服务实现
 *
 * @author jan
 * @create 2017-08-23 PM7:12
 **/
@Service
public class WorkflowBusinessRelServiceImpl extends AbstractService implements WorkflowBusinessRelService {

    private static Log log = LogFactory.getLog(WorkflowBusinessRelServiceImpl.class);

    @Autowired
    private BaseWorkflowBusinessRelMapper baseWorkflowBusinessRelMapper;


    /**
     * 通过业务类型查询业务no集合
     * getBusinessNos:
     *
     * @param objectId
     * @param businessTypeCodes
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public List<BaseWorkflowBusinessRel> getBusinessNos(Long objectId, String businessTypeCodes) throws BaseException {
        BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
        example.createCriteria().andObjectIdEqualTo(objectId).andTypeEqualTo(businessTypeCodes);
        example.setOrderByClause("create_date desc");
        List<BaseWorkflowBusinessRel> list = baseWorkflowBusinessRelMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<BaseWorkflowBusinessRel> getBusinessNos(Long objectId, String businessTypeCodes, Integer isComplete) throws BaseException {
        List<BaseWorkflowBusinessRel> businessNos = this.getBusinessNos(objectId, businessTypeCodes);
        return LambdaFilter.toList(businessNos, m -> m.getIsComplete().equals(isComplete));
    }


    /**
     * 检查是否能启动工作流
     * checkCanStartWorkFlow:
     *
     * @param objectId
     * @param businessTypeCode
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public boolean checkCanStartWorkFlow(Long objectId, String businessTypeCode) throws BaseException {
        BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
        example.createCriteria().andObjectIdEqualTo(objectId).andTypeEqualTo(businessTypeCode)
                .andObjectIdEqualTo(objectId).andIsCompleteEqualTo(0);
        List<BaseWorkflowBusinessRel> list = baseWorkflowBusinessRelMapper.selectByExample(example);
        return BooleanUtils.isEmpty(list);
        //return true;
    }


    /**
     * 通过业务类型查询业务no集合
     * getBusinessNos:
     *
     * @param objectId
     * @param businessTypeCodes
     * @return
     * @throws BaseException
     * @author: 欧阳利
     * @description:
     */
    public List<BaseWorkflowBusinessRel> getBusinessNos(Long objectId, List<String> businessTypeCodes) throws BaseException {
        BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
        example.createCriteria().andObjectIdEqualTo(objectId).andTypeIn(businessTypeCodes);
        example.setOrderByClause("create_date desc");
        List<BaseWorkflowBusinessRel> list = baseWorkflowBusinessRelMapper.selectByExample(example);
        return list;
    }


    @Override
    public void start(Long objectId, String businessNo, String businessTypeCode) throws BaseException {
        log.begin(objectId, businessNo, businessTypeCode);
        log.info("工作流业务关系||启动||操作开始");
        BaseWorkflowBusinessRel model = new BaseWorkflowBusinessRel();
        super.initialModel(model);
        model.setBusinessNo(businessNo);
        model.setIsComplete(YesOrNoEnum.NO.getValue());
        model.setObjectId(objectId);
        model.setType(businessTypeCode);
        baseWorkflowBusinessRelMapper.insertSelective(model);
        log.info("工作流业务关系||启动||操作成功");
        log.end();
    }

    @Override
    public void end(String businessNo) throws BaseException {
        String logPrefix = "工作流业务关系||工作流终止||";
        log.info("%s操作开始", logPrefix);
        log.info("%s 参数 businessNo %s ", logPrefix, businessNo);
        BaseWorkflowBusinessRelExample example = new BaseWorkflowBusinessRelExample();
        example.createCriteria().andBusinessNoEqualTo(businessNo);
        BaseWorkflowBusinessRel model = baseWorkflowBusinessRelMapper.selectOne(example);
        if (model == null) {
            return;
        }
        super.updateModel(model);
        model.setIsComplete(YesOrNoEnum.YES.getValue());
        baseWorkflowBusinessRelMapper.updateByPrimaryKeySelective(model);
        log.info("%s完成", logPrefix);
    }
}
