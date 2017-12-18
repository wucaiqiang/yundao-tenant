package com.yundao.tenant.dto.sale.leads;

import com.yundao.tenant.dto.AbstractBasePageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * 销售线索分页数据请求dto
 *
 * @author jan
 * @create 2017-09-06 PM8:14
 **/
public class LeadsPageReqDto extends AbstractBasePageDto {

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户编号")
    private String number;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "所属理财师姓名")
    private String fpName;

    @ApiModelProperty(value = "线索类型")
    private String types;

    @ApiModelProperty(value = "渠道")
    private String channels;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "创建时间 - 开始")
    private String createDateBegin;

    @ApiModelProperty(value = "创建时间 - 结束")
    private String createDateEnd;

    @ApiModelProperty(value = "线索跟进状态")
    private String statuss;

    @ApiModelProperty(value = "客户状态")
    private String customerStatuss;

    @ApiModelProperty(value = "回访情况")
    private String visitStatuss;

    @ApiModelProperty(value = "查询范围，all:全部，unprocess：待分配，默认all")
    private String scope;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFpName() {
        return fpName;
    }

    public void setFpName(String fpName) {
        this.fpName = fpName;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getCustomerStatuss() {
        return customerStatuss;
    }

    public void setCustomerStatuss(String customerStatuss) {
        this.customerStatuss = customerStatuss;
    }

    public String getVisitStatuss() {
        return visitStatuss;
    }

    public void setVisitStatuss(String visitStatuss) {
        this.visitStatuss = visitStatuss;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
