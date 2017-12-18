
package com.yundao.tenant.dto.fieldgroup;

import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import com.yundao.core.validator.length.Length;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.constant.code.GJLCodeConstant;
import io.swagger.annotations.ApiModelProperty;

public class FieldGroupInfoReqDto {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "业务对象Code")
    private String boCode ;

    @ApiModelProperty(value = "名字")
    @Length(min = 1, max = 32, message = "{" + CodeConstant.CODE_1200002 + "}")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否启用，0：否，1：是")
    @Number(isBlank = false, message = "{" + GJLCodeConstant.CODE_1210018+ "}")
    private Integer isEnabled;

    @ApiModelProperty(value = "开始创建时间")
    private String createDateBegin;

    @ApiModelProperty(value = "结束时间")
    private String createDateEnd;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public void setBoCode(String boCode) {
        this.boCode = boCode;
    }

    public String getBoCode() {
        return boCode;
    }

    public String getName (){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getDescription (){
        return description;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }
}
