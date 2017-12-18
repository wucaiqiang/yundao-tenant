
package com.yundao.tenant.dto.productnoticeexamine;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ProductNoticeExaminePageReqDto extends AbstractBasePageDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "范围，unprocess：未处理的申请，all：全部申请，默认all")
    private String scope;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "公告类型,多个用逗号分开")
    private String noticeTypeIds;

    @ApiModelProperty(value = "创建用户")
    private String createUser;

    @ApiModelProperty(value = "申请时间开始")
    private Date createDateStart;

    @ApiModelProperty(value = "申请时间结束")
    private Date createDateEnd;

    @ApiModelProperty(value = "审核时间结束")
    private Date updateDateStart;

    @ApiModelProperty(value = "审核时间结束")
    private Date updateDateEnd;

    @ApiModelProperty(value = "审核状态")
    private String statuss;

    public String getStatuss() {

        return statuss;
    }

    public void setStatuss(String statuss) {

        this.statuss = statuss;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNoticeTypeIds() {
        return noticeTypeIds;
    }

    public void setNoticeTypeIds(String noticeTypeIds) {
        this.noticeTypeIds = noticeTypeIds;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Date getUpdateDateStart() {
        return updateDateStart;
    }

    public void setUpdateDateStart(Date updateDateStart) {
        this.updateDateStart = updateDateStart;
    }

    public Date getUpdateDateEnd() {
        return updateDateEnd;
    }

    public void setUpdateDateEnd(Date updateDateEnd) {
        this.updateDateEnd = updateDateEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
