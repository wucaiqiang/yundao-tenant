package com.yundao.tenant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;

import io.swagger.annotations.Api;

@RestController
@Api("测试接口")
public class TestController {
	private static Log log = LogFactory.getLog(TestController.class);

	
	/**
	 * 获取任务的业务key
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> getBusinessKey()throws Exception{
		log.info("测试成功");
		return Result.newSuccessResult("成功!");
	}
	
	
	


}
