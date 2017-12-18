
package com.yundao.tenant.dto.feedtemplate;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class FeedTemplateReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "客户id")
    private String pcContent;

    @ApiModelProperty(value = "证件类型（1：身份证，2：护照）")
    private String appContent;

    @ApiModelProperty(value = "1 不需要 2需要")
    private Integer needPush;

    @ApiModelProperty(value = "证件号码")
    private String pushContent;

    @ApiModelProperty(value = "首页内容")
    private String indexContent;

    @ApiModelProperty(value = "app动作")
    private String appAction;

    @ApiModelProperty(value = "证件正面")
    private String code;

    @ApiModelProperty(value = "验证参数")
    private String params;

    @ApiModelProperty(value = "备注")
    private String remark;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getTitle (){
        return title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public String getPcContent (){
        return pcContent;
    }

    public void setPcContent (String pcContent){
        this.pcContent = pcContent;
    }

    public String getAppContent (){
        return appContent;
    }

    public void setAppContent (String appContent){
        this.appContent = appContent;
    }

    public Integer getNeedPush (){
        return needPush;
    }

    public void setNeedPush (Integer needPush){
        this.needPush = needPush;
    }

    public String getPushContent (){
        return pushContent;
    }

    public void setPushContent (String pushContent){
        this.pushContent = pushContent;
    }

    public String getIndexContent (){
        return indexContent;
    }

    public void setIndexContent (String indexContent){
        this.indexContent = indexContent;
    }

    public String getAppAction (){
        return appAction;
    }

    public void setAppAction (String appAction){
        this.appAction = appAction;
    }

    public String getCode (){
        return code;
    }

    public void setCode (String code){
        this.code = code;
    }

    public String getParams (){
        return params;
    }

    public void setParams (String params){
        this.params = params;
    }

    public String getRemark (){
        return remark;
    }

    public void setRemark (String remark){
        this.remark = remark;
    }

}
