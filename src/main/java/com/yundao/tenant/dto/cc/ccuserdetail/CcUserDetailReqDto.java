
package com.yundao.tenant.dto.cc.ccuserdetail;

import java.util.Date;
import com.yundao.core.code.config.CommonCode;
import com.yundao.core.validator.group.Update;
import io.swagger.annotations.ApiModelProperty;
import com.yundao.core.validator.number.Number;

public class CcUserDetailReqDto{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "新增不需要传")
    @Number(isBlank = false, message = "{" + CommonCode.COMMON_1079+ "}", groups = {Update.class})
    private Long id;

    @ApiModelProperty(value = "用户账号id")
    private Long userAccountId;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "1：男；2：女")
    private Integer sex;

    @ApiModelProperty(value = "生日")
    private Date birth;

    @ApiModelProperty(value = "微信")
    private String wechat;

    @ApiModelProperty(value = "qq")
    private String qq;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "省份")
    private String provinceCode;

    @ApiModelProperty(value = "市")
    private String cityCode;

    @ApiModelProperty(value = "地址")
    private String address;


    public Long getId (){
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Long getUserAccountId (){
        return userAccountId;
    }

    public void setUserAccountId (Long userAccountId){
        this.userAccountId = userAccountId;
    }

    public String getAvatar (){
        return avatar;
    }

    public void setAvatar (String avatar){
        this.avatar = avatar;
    }

    public String getNickName (){
        return nickName;
    }

    public void setNickName (String nickName){
        this.nickName = nickName;
    }

    public String getRealName (){
        return realName;
    }

    public void setRealName (String realName){
        this.realName = realName;
    }

    public Integer getSex (){
        return sex;
    }

    public void setSex (Integer sex){
        this.sex = sex;
    }

    public Date getBirth (){
        return birth;
    }

    public void setBirth (Date birth){
        this.birth = birth;
    }

    public String getWechat (){
        return wechat;
    }

    public void setWechat (String wechat){
        this.wechat = wechat;
    }

    public String getQq (){
        return qq;
    }

    public void setQq (String qq){
        this.qq = qq;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
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

}
