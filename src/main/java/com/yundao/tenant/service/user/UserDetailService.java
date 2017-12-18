package com.yundao.tenant.service.user;

import java.util.List;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.user.UserCardResDto;
import com.yundao.tenant.model.base.BaseUserDetail;

public interface UserDetailService {
	/**
	 * 添加用户详情
	 * @param userDetail
	 * @return
	 */
    public Integer insertUserDetail(BaseUserDetail userDetail,Long createUserId);
    
    
	/**
	 * 添加用户详情
	 * @param userDetail
	 * @return
	 */
    public Integer updateUserDetail(BaseUserDetail userDetail);
    public Integer updateUserDetailAllProperties(BaseUserDetail userDetail);
    /**
     * 修改用户名片
     * updateCardIntroduce:
     * @author: wucq
     * @param cardIntroduce
     * @return
     * @description:
     */
    public Long updateCardIntroduce(String cardIntroduce)throws BaseException;
    public Long updateCardIntroduceAndHeaderBit(String cardIntroduce,String headerBit)throws BaseException;
    public UserCardResDto doAndGetCardByUserId()throws BaseException;
    public UserCardResDto getCardByUUID(String uuid)throws BaseException;
    public BaseUserDetail getByUUID(String uuid)throws BaseException;
    
    
    /**
     * 获取用户列表
     * @param userIds
     * @return
     */
    public List<BaseUserDetail> getUserDetail(List<Long> userIds);
    
    /**
     * 获取用户的姓名
     * @param userId
     * @return
     */
    public String getUserRealName(Long userId);
}
