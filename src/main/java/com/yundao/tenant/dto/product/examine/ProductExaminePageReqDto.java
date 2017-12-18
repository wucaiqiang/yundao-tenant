package com.yundao.tenant.dto.product.examine;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 产品审核分页请求dto
 *
 * @author jan
 * @create 2017-07-22 PM3:21
 **/
public class ProductExaminePageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "范围；unprocess：未处理的申请，all：全部申请，默认为all")
    private String scope;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品类别ids，多个以逗号分隔
     */
    @ApiModelProperty(value = "品类别ids，多个以逗号分隔")
    private String productTypeIds;

    /**
     * 产品对接人
     */
    @ApiModelProperty(value = "产品对接人")
    private String receiver;

    /**
     * 产品助理
     */
    @ApiModelProperty(value = "产品助理")
    private String assistant;

    /**
     * 发行状态ids，多个以逗号分隔
     */
    @ApiModelProperty(value = "发行状态ids，多个以逗号分隔")
    private String issuedStatusIds;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private String proposer;

    /**
     * 申请操作ids
     */
    @ApiModelProperty(value = "申请操作ids")
    private String reqIssuedStatusIds;

    /**
     * 申请时间 - 开始
     */
    @ApiModelProperty(value = "申请时间 - 开始")
    private String createDateBegin;

    /**
     * 申请时间 - 结束
     */
    @ApiModelProperty(value = "申请时间 - 结束")
    private String createDateEnd;

    /**
     * 审核时间 - 开始
     */
    @ApiModelProperty(value = "审核时间 - 开始")
    private String approveDateBegin;

    /**
     * 审核时间 - 结束
     */
    @ApiModelProperty(value = "审核时间 - 结束")
    private String approveDateEnd;

    @ApiModelProperty(value = "审批状态")
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

    public String getProductTypeIds() {
        return productTypeIds;
    }

    public void setProductTypeIds(String productTypeIds) {
        this.productTypeIds = productTypeIds;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAssistant() {
        return assistant;
    }

    public void setAssistant(String assistant) {
        this.assistant = assistant;
    }

    public String getIssuedStatusIds() {
        return issuedStatusIds;
    }

    public void setIssuedStatusIds(String issuedStatusIds) {
        this.issuedStatusIds = issuedStatusIds;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getReqIssuedStatusIds() {
        return reqIssuedStatusIds;
    }

    public void setReqIssuedStatusIds(String reqIssuedStatusIds) {
        this.reqIssuedStatusIds = reqIssuedStatusIds;
    }

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getApproveDateBegin() {
        return approveDateBegin;
    }

    public void setApproveDateBegin(String approveDateBegin) {
        this.approveDateBegin = approveDateBegin;
    }

    public String getApproveDateEnd() {
        return approveDateEnd;
    }

    public void setApproveDateEnd(String approveDateEnd) {
        this.approveDateEnd = approveDateEnd;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
