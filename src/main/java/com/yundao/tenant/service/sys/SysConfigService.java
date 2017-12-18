package com.yundao.tenant.service.sys;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.sys.sale.SaleConfOpenseaReqDto;
import com.yundao.tenant.dto.sys.sale.SaleConfResDto;

/**
 * 系统配置服务接口
 *
 * @author jan
 * @create 2017-11-03 11:29
 **/
public interface SysConfigService {

    /**
     * 获取销售管理配置
     */
    Result<SaleConfResDto> getSaleConf() throws BaseException;

    /**
     * 更新销售管理配置
     */
    Result<Boolean> updateSaleConf(SaleConfOpenseaReqDto dto) throws BaseException;

}
