package com.yundao.tenant.service.workflow;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.sale.BaseWorkflowBusinessRel;

import java.util.List;

/**
 * 工作流业务关系服务接口
 *
 * @author jan
 * @create 2017-08-23 PM7:08
 **/
public interface WorkflowBusinessRelService {

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
    public List<BaseWorkflowBusinessRel> getBusinessNos(Long objectId, String businessTypeCodes) throws BaseException;

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
    public List<BaseWorkflowBusinessRel> getBusinessNos(Long objectId, String businessTypeCodes, Integer isComplete) throws
            BaseException;

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
    public boolean checkCanStartWorkFlow(Long objectId, String businessTypeCode) throws BaseException;


    /**
     * 启动
     *
     * @param objectId         对象id
     * @param businessNo       业务流水号，启动工作流时，从结果获取
     * @param businessTypeCode 业务类型CODE，对应BusinessTypeCode文件数据
     */
    void start(Long objectId, String businessNo, String businessTypeCode) throws BaseException;

    /**
     * 结束
     *
     * @param businessNo 业务流水号，启动工作流时，从结果获取
     */
    void end(String businessNo) throws BaseException;

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
    List<BaseWorkflowBusinessRel> getBusinessNos(Long objectId, List<String> businessTypeCodes) throws BaseException;

}
