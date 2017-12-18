
package com.yundao.tenant.dto.roadshowcolumnrel;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class RoadshowColumnRelReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "路演ID")
    private Long roadshowId;

    @ApiModelProperty(value = "栏目ID")
    private Long columnId;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getRoadshowId (){
        return roadshowId;
    }

    public void setRoadshowId (Long roadshowId){
        this.roadshowId = roadshowId;
    }

    public Long getColumnId (){
        return columnId;
    }

    public void setColumnId (Long columnId){
        this.columnId = columnId;
    }

}
