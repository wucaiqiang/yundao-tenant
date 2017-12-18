
package com.yundao.tenant.dto.videocategory;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class VideoCategoryReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "")
    private String refParentId;

    @ApiModelProperty(value = "")
    private String refId;

    @ApiModelProperty(value = "")
    private String name;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getRefParentId (){
        return refParentId;
    }

    public void setRefParentId (String refParentId){
        this.refParentId = refParentId;
    }

    public String getRefId (){
        return refId;
    }

    public void setRefId (String refId){
        this.refId = refId;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }
    

}
