
package com.yundao.tenant.dto.productnoticeexamine;

import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;
import com.yundao.tenant.model.base.product.BaseProductNoticeExamine;

import java.util.Date;
import java.util.List;

public class ProductNoticeExamineResDto {
		/**
		 * 主键
		 */
		private Long id;
	
		/**
		 * 主键
		 */
		private Long tenantId;
	
		/**
		 * 创建人id
		 */
		private Long createUserId;
	
		/**
		 * 创建时间
		 */
		private Date createDate;
	
		/**
		 * 更新人id
		 */
		private Long updateUserId;
	
		/**
		 * 更新时间
		 */
		private Date updateDate;
	
		/**
		 * 是否启用 0 否 1是，默认1
		 */
		private Integer isEnabled;
	
		/**
		 * 是否删除 0 否  1是 ，默认0
		 */
		private Integer isDelete;
	   /**
		 * 公告id
		 */
	    private Long noticeId;

	    /**
		 * 产品名称
		 */
	    private String productName;

	    /**
		 * 标题
		 */
	    private String title;

	    /**
		 * 内容
		 */
	    private String content;

	    /**
		 * 公告类型
		 */
	    private String noticeType;

	    /**
		 * 审核状态 1未提交  2审核中  3已通过  4已驳回  5 已撤销
		 */
	    private Integer status;

	    /**
		 * 原因
		 */
	    private String reason;

	    /**
		 * 申请人
		 */
	    private String createUser;

	    /**
		 * 审核人
		 */
	    private String updateUser;

	    /**
		 * 产品ID
		 */
	    private Long productId;

	    /**
		 * 公告类型ID
		 */
	    private Long noticeTypeId;

	
    public Long getId() {
		
			return id;
		}

		public void setId(Long id) {
		
			this.id = id;
		}

		public Long getTenantId() {
		
			return tenantId;
		}

		public void setTenantId(Long tenantId) {
		
			this.tenantId = tenantId;
		}

		public Long getCreateUserId() {
		
			return createUserId;
		}

		public void setCreateUserId(Long createUserId) {
		
			this.createUserId = createUserId;
		}

		public Date getCreateDate() {
		
			return createDate;
		}

		public void setCreateDate(Date createDate) {
		
			this.createDate = createDate;
		}

		public Long getUpdateUserId() {
		
			return updateUserId;
		}

		public void setUpdateUserId(Long updateUserId) {
		
			this.updateUserId = updateUserId;
		}

		public Date getUpdateDate() {
		
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
		
			this.updateDate = updateDate;
		}

		public Integer getIsEnabled() {
		
			return isEnabled;
		}

		public void setIsEnabled(Integer isEnabled) {
		
			this.isEnabled = isEnabled;
		}

		public Integer getIsDelete() {
		
			return isDelete;
		}

		public void setIsDelete(Integer isDelete) {
		
			this.isDelete = isDelete;
		}

		public Long getNoticeId() {
		
			return noticeId;
		}

		public void setNoticeId(Long noticeId) {
		
			this.noticeId = noticeId;
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

		public String getNoticeType() {
		
			return noticeType;
		}

		public void setNoticeType(String noticeType) {
		
			this.noticeType = noticeType;
		}

		public Integer getStatus() {
		
			return status;
		}

		public void setStatus(Integer status) {
		
			this.status = status;
		}

		public String getReason() {
		
			return reason;
		}

		public void setReason(String reason) {
		
			this.reason = reason;
		}

		public String getCreateUser() {
		
			return createUser;
		}

		public void setCreateUser(String createUser) {
		
			this.createUser = createUser;
		}

		public String getUpdateUser() {
		
			return updateUser;
		}

		public void setUpdateUser(String updateUser) {
		
			this.updateUser = updateUser;
		}

		public Long getProductId() {
		
			return productId;
		}

		public void setProductId(Long productId) {
		
			this.productId = productId;
		}

		public Long getNoticeTypeId() {
		
			return noticeTypeId;
		}

		public void setNoticeTypeId(Long noticeTypeId) {
		
			this.noticeTypeId = noticeTypeId;
		}

	private List<BaseProductNoticeAttach> baseProductNoticeAttach;

    public List<BaseProductNoticeAttach> getBaseProductNoticeAttach() {
        return baseProductNoticeAttach;
    }

    public void setBaseProductNoticeAttach(List<BaseProductNoticeAttach> baseProductNoticeAttach) {
        this.baseProductNoticeAttach = baseProductNoticeAttach;
    }
}
