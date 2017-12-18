package com.yundao.tenant.service.user;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.tenant.TenantInitDataDto;

public interface TenantInitService {
	
	/**
	 * 初始化租户信息
	 * @param tenantId
	 * @return
	 */
    public void doTenantInit(TenantInitDataDto tenantInitDataDto, Long tenantId)throws BaseException;
    
    /**
     * 检查租户表是否存在
     * @param tenantId
     * @return
     */
    public boolean checkDBTableExist(Long tenantId)throws BaseException;
    
    
    /**
     * 检查数据库是否初始化
     * @param tenantId
     * @return
     */
    public boolean checkDBFinishInit(Long tenantId)throws BaseException;
    
    
    /**
     * 获取租户初始化数据
     * @param tenantId
     */
    public Result<TenantInitDataDto> getInitData(Long tenantId)throws BaseException;
}
