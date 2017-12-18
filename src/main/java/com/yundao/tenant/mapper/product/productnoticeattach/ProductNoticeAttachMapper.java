package com.yundao.tenant.mapper.product.productnoticeattach;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ProductNoticeAttachMapper{

    void deleteByNoticeId(@Param("id") Long id, @Param("headerUserId") Long headerUserId, @Param("date") Date date);
}
