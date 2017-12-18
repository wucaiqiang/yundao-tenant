
package com.yundao.tenant.dto.customer.customer;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.model.customer.BaseContact;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Function: Reason: Date: 2017年8月9日 下午1:52:42
 *
 * @author wucq
 */
public class CustomerContactReqDto extends BaseContact implements Serializable {

    /**
     * serialVersionUID:
     */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079 + "}", groups = {Update.class})
    private Long id;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

}
