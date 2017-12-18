
package com.yundao.tenant.dto.customerfollowupattach;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CustomerFollowUpAttachReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "客户跟进记录Id")
    private Long custoemrFollowUpId;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "")
    private String url;

    @ApiModelProperty(value = "文件格式")
    private String format;

    @ApiModelProperty(value = "排序")
    private String sort;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getCustoemrFollowUpId (){
        return custoemrFollowUpId;
    }

    public void setCustoemrFollowUpId (Long custoemrFollowUpId){
        this.custoemrFollowUpId = custoemrFollowUpId;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getUrl (){
        return url;
    }

    public void setUrl (String url){
        this.url = url;
    }

    public String getFormat (){
        return format;
    }

    public void setFormat (String format){
        this.format = format;
    }

    public String getSort (){
        return sort;
    }

    public void setSort (String sort){
        this.sort = sort;
    }

}
