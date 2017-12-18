
package com.yundao.tenant.dto.fieldgrouprel;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class FieldGroupRelReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "业务对象字段分组id")
    private Long fieldGroupId;

    @ApiModelProperty(value = "业务对象字段id")
    private Long objectFieldId;

    @ApiModelProperty(value = "排序，越小越靠前")
    private Integer sequence;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getFieldGroupId (){
        return fieldGroupId;
    }

    public void setFieldGroupId (Long fieldGroupId){
        this.fieldGroupId = fieldGroupId;
    }

    public Long getObjectFieldId (){
        return objectFieldId;
    }

    public void setObjectFieldId (Long objectFieldId){
        this.objectFieldId = objectFieldId;
    }

    public Integer getSequence (){
        return sequence;
    }

    public void setSequence (Integer sequence){
        this.sequence = sequence;
    }

}
