

package com.yundao.tenant.controller.cms.product.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.validator.spring.BindingResultHandler;
import com.yundao.tenant.dto.cms.product.recommend.RecommendAddReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendDetailDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListReqDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendListResDto;
import com.yundao.tenant.dto.cms.product.recommend.RecommendUpdateReqDto;
import com.yundao.tenant.service.cms.product.recommend.RecommendService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Function: 
 * Reason:	  
 * Date:     2017年10月18日 下午3:59:08 
 * @author   欧阳利
 * @version   
 */
@RestController
@RequestMapping("/cms/product/recommend")
@ResponseBody
@Api("产品推荐配置")
public class RecommendController {
	
	@Autowired
	private RecommendService recommendService;
	

	
	
	@ApiOperation(value = "添加产品附件")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<Long> add(@Validated @ModelAttribute RecommendAddReqDto reqDto, BindingResult bindingResult)throws BaseException{
		 BindingResultHandler.handleByException(bindingResult);
		return recommendService.add(reqDto);
    }
	
	
	@ApiOperation(value = "列表查询")
	@RequestMapping(value = "/get_page", method = RequestMethod.GET)
    public Result<PaginationSupport<RecommendListResDto>> getPage(@ModelAttribute RecommendListReqDto reqDto)throws BaseException{
    	return recommendService.getPage(reqDto);
    }
	
	@ApiOperation(value = "删除单个配置")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Integer> delete(@RequestParam String ids)throws BaseException{
		String[] arrayIds = ids.split(",");
    	return recommendService.delete(arrayIds);
    }
	
	@ApiOperation(value = "编辑推荐配置")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Integer> update(@Validated @ModelAttribute RecommendUpdateReqDto reqDto, BindingResult bindingResult)throws BaseException{
		 BindingResultHandler.handleByException(bindingResult);
		return recommendService.update(reqDto);
    }
	
	@ApiOperation(value = "详情")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<RecommendDetailDto> get(@RequestParam Long id)throws BaseException{
    	return recommendService.get(id);
    }
}

