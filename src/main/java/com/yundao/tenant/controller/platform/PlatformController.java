

package com.yundao.tenant.controller.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.tenant.dto.platform.PlatformDto;
import com.yundao.tenant.dto.platform.PositionDto;
import com.yundao.tenant.service.platform.PlatformService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月20日 下午2:01:25 
 * @author   欧阳利
 * @version   
 */
@RestController
@RequestMapping("/plafrom")
@ResponseBody
@Api("平台")
public class PlatformController {
	
	@Autowired
	private PlatformService platformService;
	
	
    @ApiOperation(value = "获取所有平台")
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
   public Result<List<PlatformDto>>  getAllPlatformDto()throws Exception{
	   return Result.newSuccessResult(platformService.getAllPlatformDto());
   }
    
    
    
    @ApiOperation(value = "获取平台的位置")
    @RequestMapping(value = "/get_position_by_platform", method = RequestMethod.GET)
   public Result<List<PositionDto>> getPositionDtoByPlatform(@RequestParam Long platformId)throws Exception{
	   return Result.newSuccessResult(platformService.getPositionDtoByPlatform(platformId));
   }
}

