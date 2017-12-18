package com.yundao.tenant.mapper.product.productnotice;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.yundao.tenant.model.productnotice.ProductNoticeModel;

public interface ProductNoticeMapper{

    int selectPageCount(Map<String, Object> params);

    List<ProductNoticeModel> selectPageInfo(Map<String, Object> params);
    
    /**
     * 重置审核时间
     * resetAuditDate:
     * @author: 欧阳利
     * @param noticeId
     * @return
     * @description:
     */
    int resetAuditDate(@Param("noticeId") Long noticeId);
}
