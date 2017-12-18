package com.yundao.tenant.dto.operation.visit;

import com.yundao.tenant.constant.code.CodeConstant;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 客户回访添加数据dto
 *
 * @author jan
 * @create 2017-08-29 PM4:04
 **/
public class UserVisitAddReqDto {

    @ApiModelProperty(value = "回访数据id")
    @NotNull(message = "{" + CodeConstant.CODE_1200000 + "}")
    private Long id;

    @ApiModelProperty(value = "回访时间")
    @NotNull(message = "{" + CodeConstant.CODE_1220065 + "}")
    private Date visitDate;

    @ApiModelProperty(value = "回访方式")
    @NotNull(message = "{" + CodeConstant.CODE_1220066 + "}")
    private Integer type;

    @ApiModelProperty(value = "回访状态")
    @NotNull(message = "{" + CodeConstant.CODE_1220067 + "}")
    private Integer status;
    
    @ApiModelProperty(value = "客户状态")
    private Integer customerStatus;
    
    @ApiModelProperty(value = "回访内容")
    private String content;

    @ApiModelProperty(value = "下次回访时间")
    private Date nextTime;

    public Integer getCustomerStatus() {
	
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
	
		this.customerStatus = customerStatus;
	}

	public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
