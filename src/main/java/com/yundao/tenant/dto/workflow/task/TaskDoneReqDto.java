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
public class TaskDoneReqDto extends BasePageDto {
    /**
     * 
     */
	@ApiModelProperty(value = "需要过虑的节点类型")
	String filtNodeCategorys;
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	public String getFiltNodeCategorys() {
	
		return filtNodeCategorys;
	}
	public void setFiltNodeCategorys(String filtNodeCategorys) {
	
		this.filtNodeCategorys = filtNodeCategorys;
	}

	
}
