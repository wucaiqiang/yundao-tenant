package com.yundao.tenant.mapper.base;

import com.yundao.tenant.model.base.BaseSmsCaptcha;
import com.yundao.tenant.model.base.BaseSmsCaptchaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsCaptchaMapper {
    int countByExample(BaseSmsCaptchaExample example);

    int deleteByExample(BaseSmsCaptchaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsCaptcha record);

    int insertSelective(BaseSmsCaptcha record);

    List<BaseSmsCaptcha> selectByExampleWithBLOBs(BaseSmsCaptchaExample example);

    List<BaseSmsCaptcha> selectByExample(BaseSmsCaptchaExample example);

    BaseSmsCaptcha selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsCaptcha record, @Param("example") BaseSmsCaptchaExample example);

    int updateByExampleWithBLOBs(@Param("record") BaseSmsCaptcha record, @Param("example") BaseSmsCaptchaExample example);

    BaseSmsCaptcha selectOne(BaseSmsCaptchaExample example);

    int updateByExample(@Param("record") BaseSmsCaptcha record, @Param("example") BaseSmsCaptchaExample example);

    int updateByPrimaryKeySelective(BaseSmsCaptcha record);

    int updateByPrimaryKeyWithBLOBs(BaseSmsCaptcha record);

    int updateByPrimaryKey(BaseSmsCaptcha record);
}