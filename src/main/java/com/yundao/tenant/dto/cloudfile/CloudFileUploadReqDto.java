
package com.yundao.tenant.dto.cloudfile;

import io.swagger.annotations.ApiModelProperty;

public class CloudFileUploadReqDto {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "文件路径，不穿，生成新的目录名，规则是：系统标识（如果配置）+folder（如果为空则置为默认目录）")
    private String folder;
    @ApiModelProperty(value = "云类型 0代表阿里云 1代表腾讯晕 2代表ucloud云，不传默认是1")
    private Integer cloudType = 0;
    @ApiModelProperty(value = "是否生成新文件名，1代表生成新文件名")
    private Integer uploadType = 1;
    @ApiModelProperty(value = "是否异步上传，1代表异步上传")
    private Integer isAsync;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Integer getCloudType() {
        return cloudType;
    }

    public void setCloudType(Integer cloudType) {
        this.cloudType = cloudType;
    }

    public Integer getUploadType() {
        return uploadType;
    }

    public void setUploadType(Integer uploadType) {
        this.uploadType = uploadType;
    }

    public Integer getIsAsync() {
        return isAsync;
    }

    public void setIsAsync(Integer isAsync) {
        this.isAsync = isAsync;
    }
}
