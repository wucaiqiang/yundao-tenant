package com.yundao.tenant.service.product.productnoticeattach;

import java.util.List;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;


public interface ProductNoticeAttachService{


    public Result<Integer> add(BaseProductNoticeAttach productNoticeAttach) throws Exception;


    public Result<Integer> update(BaseProductNoticeAttach productNoticeAttach) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseProductNoticeAttach> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseProductNoticeAttach>> getPage(BaseProductNoticeAttach baseProductNoticeAttach, AbstractBasePageDto pageDto) throws Exception;
    
    /**
     * 通过公告id查询附件集合
     * gets:
     * @author: 欧阳利
     * @param noticeId
     * @return
     * @throws Exception
     * @description:
     */
    public List<BaseProductNoticeAttach> gets(Long noticeId)throws Exception;

}
