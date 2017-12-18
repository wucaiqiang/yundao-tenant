
package com.yundao.tenant.dto.customer.customerdetail;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;
import com.yundao.tenant.model.customer.WechatQQ;

public class CustomerDetailReqDto extends WechatQQ{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "省份")
    private String provinceCode;

    @ApiModelProperty(value = "市")
    private String cityCode;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "行业")
    private String trade;

    @ApiModelProperty(value = "机构")
    private String organization;

    @ApiModelProperty(value = "职位")
    private String position;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Date getBirthday (){
        return birthday;
    }

    public void setBirthday (Date birthday){
        this.birthday = birthday;
    }

    public String getProvinceCode (){
        return provinceCode;
    }

    public void setProvinceCode (String provinceCode){
        this.provinceCode = provinceCode;
    }

    public String getCityCode (){
        return cityCode;
    }

    public void setCityCode (String cityCode){
        this.cityCode = cityCode;
    }

    public String getAddress (){
        return address;
    }

    public void setAddress (String address){
        this.address = address;
    }

    public String getTrade (){
        return trade;
    }

    public void setTrade (String trade){
        this.trade = trade;
    }

    public String getOrganization (){
        return organization;
    }

    public void setOrganization (String organization){
        this.organization = organization;
    }

    public String getPosition (){
        return position;
    }

    public void setPosition (String position){
        this.position = position;
    }

}
