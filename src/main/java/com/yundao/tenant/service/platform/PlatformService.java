

package com.yundao.tenant.service.platform;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.platform.PlatformDto;
import com.yundao.tenant.dto.platform.PositionDto;
import com.yundao.tenant.model.base.platform.BasePlatform;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月20日 下午2:03:50 
 * @author   欧阳利
 * @version   
 */
public interface PlatformService {
	
    List<PlatformDto>  getAllPlatformDto()throws Exception;
    
    List<PositionDto> getPositionDtoByPlatform(Long platformId)throws Exception;

    BasePlatform get(String code) throws BaseException;
    BasePlatform getById(Long id) throws BaseException;

    Long getId(String code) throws BaseException;

}

