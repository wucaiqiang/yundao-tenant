
package com.yundao.tenant.controller.cc.ccriskrating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.tenant.model.base.cc.BaseCcRiskRating;
import com.yundao.tenant.service.cc.ccriskrating.CcriskRatingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: Reason: Date: 2017年10月12日 上午11:34:12
 * 
 * @author wucq
 * @version
 */
@RestController
@RequestMapping(value = "/cc/risk/rating/")
@ResponseBody
@Api("客户风险特征类型")
public class CcRiskRatingController {
	@Autowired
	private CcriskRatingService ccriskRatingService;

	@RequestMapping(value = "gets", method = RequestMethod.GET)
	@ApiOperation(value = "获取风险特征列表")
	public Result<List<BaseCcRiskRating>> getList() throws Exception {
		return ccriskRatingService.getList();

	}
}
