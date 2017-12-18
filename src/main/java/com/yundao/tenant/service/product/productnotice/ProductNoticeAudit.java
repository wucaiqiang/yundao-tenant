

package com.yundao.tenant.service.product.productnotice;

import com.yundao.core.exception.BaseException;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年9月25日 上午10:54:38 
 * @author   欧阳利
 * @version   
 */
public interface ProductNoticeAudit {
   
	
	/**
	 * 任务处理
	 * doTaskApplyAndAudit:
	 * @author: 欧阳利
	 * @param noticeId
	 * @param reason
	 * @throws BaseException
	 * @description:
	 */
	public void doTaskApplyAndAudit(Long noticeId, Integer nextStatus,String reason) throws BaseException;
	
	
	
	/**
	 * 是否申请上线
	 * isApplyRelease:
	 * @author: 欧阳利
	 * @return
	 * @throws BaseException
	 * @description:
	 */
	public boolean isApplyRelease(Long noticeId) throws BaseException;
	
	
	/**
     * 申请发布
     * doApplyRelease:
     * @author: 欧阳利
     * @description:
     */
    public void doApplyRelease(Long noticeId) throws BaseException;
    
    /**
     * 重新提交
     * doAgainSubmit:
     * @author: 欧阳利
     * @description:
     */
    public void doAgainSubmit(Long noticeId)throws BaseException;
    
    
    /**
     * 驳回
     * doRejectSubmit:
     * @author: 欧阳利
     * @description:
     */
    public void doReject(Long noticeId,String reason)throws BaseException;
    
    /**
     * 通过
     * doPass:
     * @author: 欧阳利
     * @description:
     */
    public void doPass(Long noticeId)throws BaseException;
    
    /**
     * 取消
     * doCancel:
     * @author: 欧阳利
     * @description:
     */
    public void doCancel(Long noticeId,String reason)throws BaseException;
}

