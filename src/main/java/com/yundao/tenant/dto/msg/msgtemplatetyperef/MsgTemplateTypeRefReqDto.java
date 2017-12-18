
package com.yundao.tenant.dto.msg.msgtemplatetyperef;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class MsgTemplateTypeRefReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "")
    private Long templateId;

    @ApiModelProperty(value = "证件正面")
    private String typeId;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getTemplateId (){
        return templateId;
    }

    public void setTemplateId (Long templateId){
        this.templateId = templateId;
    }

    public String getTypeId (){
        return typeId;
    }

    public void setTypeId (String typeId){
        this.typeId = typeId;
    }

}
