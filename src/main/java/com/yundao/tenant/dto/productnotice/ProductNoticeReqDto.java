
package com.yundao.tenant.dto.productnotice;

import com.fasterxml.jackson.databind.JavaType;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.core.validator.group.Insert;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import com.yundao.tenant.dto.FileDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class ProductNoticeReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "产品id")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210009 + "}", groups = {Insert.class, Update.class})
    private Long productId;

    @ApiModelProperty(value = "标题")
    @Length(min = 1, max = 50, message = "{" + GJLCodeConstant.CODE_1210010 + "}", groups = {Insert.class, Update.class})
    private String title;

    @ApiModelProperty(value = "内容")
    @Length(min = 1, max = 200, message = "{" + GJLCodeConstant.CODE_1210011 + "}", groups = {Insert.class, Update.class})
    private String content;

    @ApiModelProperty(value = "公告类型")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210012 + "}", groups = {Insert.class, Update.class})
    private Long noticeTypeId;

    @ApiModelProperty(value = "审核状态")
    private String status;

    @ApiModelProperty(value = "定时发送时间")
    private Date sendTime;

    @ApiModelProperty(value = "是否发送")
    private Integer isSend;

    @ApiModelProperty(value = "是否定时发送（0：不是，1：是）")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210013 + "}", groups = {Insert.class, Update.class})
    private Integer isTimingSend;

    @ApiModelProperty(value = "审核人id")
    private Long auditUserId;

    @ApiModelProperty(value = "审核时间")
    private Date auditDate;

    @ApiModelProperty(value = "附件json串，属性fileName，fileUrl")
    private String files;

    private List<FileDto> filesList;

    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getProductId (){
        return productId;
    }

    public void setProductId (Long productId){
        this.productId = productId;
    }

    public String getTitle (){
        return title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public String getContent (){
        return content;
    }

    public void setContent (String content){
        this.content = content;
    }

    public Long getNoticeTypeId (){
        return noticeTypeId;
    }

    public void setNoticeTypeId (Long noticeTypeId){
        this.noticeTypeId = noticeTypeId;
    }

    public String getStatus (){
        return status;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public Date getSendTime (){
        return sendTime;
    }

    public void setSendTime (Date sendTime){
        this.sendTime = sendTime;
    }

    public Integer getIsSend (){
        return isSend;
    }

    public void setIsSend (Integer isSend){
        this.isSend = isSend;
    }

    public Integer getIsTimingSend (){
        return isTimingSend;
    }

    public void setIsTimingSend (Integer isTimingSend){
        this.isTimingSend = isTimingSend;
    }

    public Long getAuditUserId (){
        return auditUserId;
    }

    public void setAuditUserId (Long auditUserId){
        this.auditUserId = auditUserId;
    }

    public Date getAuditDate (){
        return auditDate;
    }

    public void setAuditDate (Date auditDate){
        this.auditDate = auditDate;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
        if(BooleanUtils.isNotEmpty(files)){
            JavaType javaType = JsonUtils.getCollectionType(List.class, FileDto.class);
            this.filesList = JsonUtils.jsonToObject(files,javaType);
        }
    }

    public List<FileDto> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<FileDto> filesList) {
        this.filesList = filesList;
    }
}
