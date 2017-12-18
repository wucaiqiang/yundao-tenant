package com.yundao.tenant.model.productnotice;

import com.yundao.tenant.model.base.product.BaseProductNotice;
import com.yundao.tenant.model.base.product.BaseProductNoticeAttach;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by gjl on 2017/7/12.
 */
public class ProductNoticeModel extends BaseProductNotice {
    
	 /**
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
    private String noticeTypeName;
    
    @ApiModelProperty("申请人名称")
    private String applyUserRealName;
    
    @ApiModelProperty("创建人名称")
    private String createUserRealName;
    
    
    public String getCreateUserRealName() {
	
		return createUserRealName;
	}

	public void setCreateUserRealName(String createUserRealName) {
	
		this.createUserRealName = createUserRealName;
	}

	private List<BaseProductNoticeAttach> baseProductNoticeAttach;

    public String getApplyUserRealName() {
	
		return applyUserRealName;
	}

	public void setApplyUserRealName(String applyUserRealName) {
	
		this.applyUserRealName = applyUserRealName;
	}

	public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNoticeTypeName() {
        return noticeTypeName;
    }

    public void setNoticeTypeName(String noticeTypeName) {
        this.noticeTypeName = noticeTypeName;
    }

    public List<BaseProductNoticeAttach> getBaseProductNoticeAttach() {
        return baseProductNoticeAttach;
    }

    public void setBaseProductNoticeAttach(List<BaseProductNoticeAttach> baseProductNoticeAttach) {
        this.baseProductNoticeAttach = baseProductNoticeAttach;
    }
}
