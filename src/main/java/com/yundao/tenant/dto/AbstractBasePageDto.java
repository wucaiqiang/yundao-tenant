/**
 * Project Name:a-crm-ms
 * File Name:AbstractBaseDto.java
 * Package Name:com.zcmall.crmms.dto
 * Date:2016年10月11日上午11:47:02
 *
*/

package com.yundao.tenant.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.yundao.core.pagination.PaginationSupport;

/**
 * 分页基础类
 * 
 * @author 欧阳利
 * 2017年6月23日
 */
public abstract class AbstractBasePageDto implements Serializable{
  
	
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页
	 */
	@ApiModelProperty(value = "当前页")
	private int currentPage;
   /**
    * 分页的偏移量
    */
	@SuppressWarnings("unused")
	@ApiModelProperty(value = "不需要填写，后台自动计算")
	private int offset;
   /**
    * 每页显示条数
   */
   @ApiModelProperty(value = "每页显示条数")
	private int pageSize;

	/**
	 * 排序列名
	 */
	@ApiModelProperty(value = "排序字段名")
	private String orderColumn;
	/**
	 * 升序，降序
	 */
	@ApiModelProperty(value = "降序:desc，升序:asc")
	private String sort;

   
	public int getOffset() {
		return (this.getCurrentPage() - 1) * this.getPageSize();
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		if (pageSize == 0) {
			pageSize = 10;// 默认取10条
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		if (this.currentPage == 0) {
			this.currentPage = 1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取分页列表数据结构 newDefault:
	 * 
	 * @author: wucq
	 * @param page
	 * @return
	 * @description:
	 */
	public <T> PaginationSupport<T> getPaginationSupport() {
		PaginationSupport<T> result = new PaginationSupport<T>();
		result.setCurrentPage(this.getCurrentPage());
		result.setPageSize(this.getPageSize());
		return result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}

