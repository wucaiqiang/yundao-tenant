package com.yundao.tenant.mapper.productnoticeexamine;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExaminePageReqDto;
import com.yundao.tenant.dto.productnoticeexamine.ProductNoticeExamineResDto;

public interface ProductNoticeExamineMapper{
	
	/**
	 * 查询产品公告审核页面数据
	 * getAuditPage:
	 * @author: 欧阳利
	 * @param baseProductNoticeExamine
	 * @return
	 * @description:
	 */
    List<ProductNoticeExamineResDto> getAuditPage(ProductNoticeExaminePageReqDto baseProductNoticeExamine);
    
    /**
     * 查询产品公告审核页面总记录数
     * getAuditCount:
     * @author: 欧阳利
     * @param baseProductNoticeExamine
     * @return
     * @description:
     */
    int getAuditCount(ProductNoticeExaminePageReqDto baseProductNoticeExamine);
    
    /**
     * 通过公告id集合获取公告信息
     * getProductNoticeDto:
     * @author: 欧阳利
     * @param ids
     * @return
     * @description:
     */
    List<ProductNoticeDto> getProductNoticeDto(@Param("ids")List<Long> ids);
}
