package com.yundao.tenant.controller.cc.ccuserdetail;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.cc.ccuserdetail.CcUserInfoDto;
import com.yundao.tenant.service.cc.ccuserdetail.CcUserDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cc/user/detail/")
@ResponseBody
@Api("投资用户详情")
public class CcUserDetailController {

    @Autowired
    private CcUserDetailService ccUserDetailService;

    @RequestMapping(value = "get_info", method = RequestMethod.GET)
    @ApiOperation("获取理财用户信息")
    public Result<CcUserInfoDto> getUserInfo() throws BaseException {
        return ccUserDetailService.getInfo();
    }

//    @Autowired
//    private CcUserDetailService ccUserDetailService;
//
//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询投资用户详情")
//    public Result<PaginationSupport<BaseCcUserDetail>> getPage(@ModelAttribute CcUserDetailReqDto dto, @ModelAttribute BasePageDto pageDto) throws Exception{
//		return ccUserDetailService.getPage(dto, pageDto);
//    }
//
//    @RequestMapping(value="add", method=RequestMethod.POST)
//    @ApiOperation(value="新增投资用户详情", notes="根据CcUserDetail对象创建投资用户详情")
//    public Result<Integer> add(@Validated @ModelAttribute CcUserDetailReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccUserDetailService.add(reqDto);
//    }
//
//    @RequestMapping(value = "update", method=RequestMethod.POST)
//    @ApiOperation(value="编辑投资用户详情信息")
//    public Result<Integer> update(@Validated(value = {Update.class}) @ModelAttribute CcUserDetailReqDto reqDto, BindingResult bindingResult) throws Exception{
//        BindingResultHandler.handleByException(bindingResult);
//        return ccUserDetailService.update(reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取投资用户详情详细信息")
//    public Result<BaseCcUserDetail> get(@RequestParam Long id) throws Exception{
//       return ccUserDetailService.get(id);
//    }
//
//    @RequestMapping(value = "delete", method=RequestMethod.POST)
//    @ApiOperation(value="删除投资用户详情信息")
//    public Result<Integer> delete(@RequestParam Long id) throws Exception{
//        return ccUserDetailService.delete(id);
//    }

}
