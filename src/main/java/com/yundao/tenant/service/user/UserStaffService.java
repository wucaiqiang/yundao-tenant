package com.yundao.tenant.service.user;

import com.yundao.core.exception.BaseException;
import com.yundao.tenant.model.base.BaseUserStaff;

/**
 * 用户职员管理
 *
 * @author 欧阳利
 *         2017年6月22日
 */
public interface UserStaffService {

    /**
     * 添加用户职员信息
     *
     * @param userStaff
     * @return
     */
    Integer insertUserStaff(BaseUserStaff userStaff, Long createUserId) throws BaseException;


    /**
     * 添加用户职员信息
     *
     * @param userStaff
     * @return
     */
    Integer updateUserStaff(BaseUserStaff userStaff) throws BaseException;

    /**
     * 判断工号是否被使用
     *
     * @param jobNumber
     * @return
     */
    boolean checkJobNumberExist(String jobNumber);

    /**
     * 判断工号是否被使用
     *
     * @param userId
     * @param jobNumber
     * @return
     */
    boolean checkJobNumberExist(Long userId, String jobNumber);


    /**
     * 根据用户id获取
     *
     * @param userId 用户id
     */
    BaseUserStaff getByUserId(Long userId) throws BaseException;
}
