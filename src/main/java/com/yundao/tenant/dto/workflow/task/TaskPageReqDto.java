package com.yundao.tenant.dto.workflow.task;

import java.util.List;

import com.yundao.tenant.dto.BasePageDto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 客户池分页请求数据
 *
 * @author jan
 * @create 2017-08-14 AM9:10
 **/
public class TaskPageReqDto extends BasePageDto {

    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "审核组集合")
	private String auditGroups;

	public String getAuditGroups() {
		return auditGroups;
	}

	public void setAuditGroups(String auditGroups) {
		this.auditGroups = auditGroups;
	}

	
	
}
