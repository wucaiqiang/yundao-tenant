 package com.yundao.tenant.controller.cloudfile;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.tenant.dto.AbstractBasePageDto;
import com.yundao.tenant.dto.cloudfile.CloudFileReqDto;
import com.yundao.tenant.dto.cloudfile.CloudFileUploadReqDto;
import com.yundao.tenant.model.base.BaseCloudFile;
import com.yundao.tenant.service.cloudfile.CloudFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping(value = "/cloudfile/")
@ResponseBody
@Api("云文件表")
public class CloudFileController{

    /**
     * 云文件已经修改到msc中。
     */
//    @Autowired
//    private CloudFileService cloudFileService;
//
//    @RequestMapping(value = "get_page",method=RequestMethod.GET)
//    @ApiOperation(value="分页查询云文件表")
//    public Result<PaginationSupport<BaseCloudFile>> getPage(@ModelAttribute CloudFileReqDto dto, @ModelAttribute AbstractBasePageDto pageDto) throws Exception{
//        BaseCloudFile model = new BaseCloudFile();
//        BeanUtils.copyProperties(dto,model);
//		return cloudFileService.getPage(model, pageDto);
//    }
//
//    /**
//     *
//     * @param file
//     * @param reqDto
//     * @throws Exception
//     */
//    @RequestMapping(value="upload", method=RequestMethod.POST)
//    @ApiOperation(value="上传文件", notes="上传文件")
//    public Result<BaseCloudFile> upload(@RequestParam(value = "file") MultipartFile file, @ModelAttribute CloudFileUploadReqDto reqDto) throws Exception{
//        String originalName = file.getOriginalFilename();
//        InputStream is = file.getInputStream();
//        return cloudFileService.add(is, originalName, reqDto);
//    }
//
//    @RequestMapping(value = "get", method=RequestMethod.GET)
//    @ApiOperation(value="获取云文件表详细信息")
//    public Result<BaseCloudFile> get(@RequestParam Long id) throws Exception{
//       return cloudFileService.get(id);
//    }
}
