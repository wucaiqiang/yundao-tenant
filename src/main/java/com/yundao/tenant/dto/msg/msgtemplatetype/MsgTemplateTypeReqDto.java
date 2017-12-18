
package com.yundao.tenant.dto.msg.msgtemplatetype;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class MsgTemplateTypeReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "动态类型名称")
    private String name;

    @ApiModelProperty(value = "1、动态 2、消息")
    private Integer type;

    @ApiModelProperty(value = "对应消息：1、代办   2、消息 对应动态：1、客户   2、交易")
    private Integer firsttype;

    @ApiModelProperty(value = "只有消息才有二级：1、客户 ，2、产品 ，3、待回访，4、待跟进，5、待审核，6、待确认，7、交易")
    private Integer twotpe;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public Integer getType (){
        return type;
    }

    public void setType (Integer type){
        this.type = type;
    }

    public Integer getFirsttype (){
        return firsttype;
    }

    public void setFirsttype (Integer firsttype){
        this.firsttype = firsttype;
    }

    public Integer getTwotpe (){
        return twotpe;
    }

    public void setTwotpe (Integer twotpe){
        this.twotpe = twotpe;
    }

}
