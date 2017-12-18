
package com.yundao.tenant.dto.fieldgroup;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

public class FieldGroupRelReqDto {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;


    @ApiModelProperty(value = "关联的产品要素")
    private String fieldGroupRelIds;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public void setFieldGroupRelIds(String fieldGroupRelIds) {
        this.fieldGroupRelIds = fieldGroupRelIds;
    }

    public String getFieldGroupRelIds() {
        return fieldGroupRelIds;
    }
}
