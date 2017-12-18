
package com.yundao.tenant.dto.productnoticeexamine;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class ProductNoticeExamineReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "公告id")
    private Long noticeId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "公告类型")
    private Long noticeType;

    @ApiModelProperty(value = "审核状态 1未提交  2审核中  3已通过  4已驳回  5 已撤销")
    private String status;

    @ApiModelProperty(value = "原因")
    private String reason;

    @ApiModelProperty(value = "申请人")
    private String createUser;

    @ApiModelProperty(value = "审核人")
    private String updateUser;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getNoticeId (){
        return noticeId;
    }

    public void setNoticeId (Long noticeId){
        this.noticeId = noticeId;
    }

    public String getProductName (){
        return productName;
    }

    public void setProductName (String productName){
        this.productName = productName;
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

    public Long getNoticeType (){
        return noticeType;
    }

    public void setNoticeType (Long noticeType){
        this.noticeType = noticeType;
    }

    public String getStatus (){
        return status;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public String getReason (){
        return reason;
    }

    public void setReason (String reason){
        this.reason = reason;
    }

    public String getCreateUser (){
        return createUser;
    }

    public void setCreateUser (String createUser){
        this.createUser = createUser;
    }

    public String getUpdateUser (){
        return updateUser;
    }

    public void setUpdateUser (String updateUser){
        this.updateUser = updateUser;
    }

}
