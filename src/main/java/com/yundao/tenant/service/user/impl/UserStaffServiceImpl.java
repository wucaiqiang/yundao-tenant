package com.yundao.tenant.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.enums.user.UserDimissionEnum;
import com.yundao.tenant.mapper.base.BaseUserStaffMapper;
import com.yundao.tenant.model.base.BaseUserStaff;
import com.yundao.tenant.model.base.BaseUserStaffExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.user.UserStaffService;
import com.yundao.tenant.service.workflow.WorkFlowGroupUserService;

/**
 * 用户职员管理
 *
 * @author 欧阳利
 *         2017年6月22日
 */
@Service
public class UserStaffServiceImpl extends AbstractService implements UserStaffService {

    @Autowired
    BaseUserStaffMapper baseUserStaffMapper;

    /**
     * 添加用户职员信息
     *
     * @param userStaff
     * @return
     */
    public Integer insertUserStaff(BaseUserStaff userStaff, Long createUserId) throws BaseException {
        userStaff.setCreateUserId(createUserId);
        userStaff.setCreateDate(new Date());
        //是否离职，0：否；1：是
        userStaff.setIsDimission(0);
        userStaff.setIsDelete(0);
        Integer count = baseUserStaffMapper.insert(userStaff);
        return count;
    }


    /**
     * 添加用户职员信息
     *
     * @param userStaff
     * @return
     */
    public Integer updateUserStaff(BaseUserStaff userStaff) throws BaseException {
        userStaff.setUpdateDate(new Date());
        BaseUserStaffExample example = new BaseUserStaffExample();
        example.createCriteria().andUserAccountIdEqualTo(userStaff.getUserAccountId());
        return baseUserStaffMapper.updateByExampleSelective(userStaff, example);
    }

    /**
     * 判断工号是否被使用
     *
     * @param jobNumber
     * @return
     */
    public boolean checkJobNumberExist(String jobNumber) {
        BaseUserStaffExample example = new BaseUserStaffExample();
        example.or().andJobNumberEqualTo(jobNumber);
        List<BaseUserStaff> list = baseUserStaffMapper.selectByExample(example);
        return !BooleanUtils.isEmpty(list);
    }

    @Override
    public BaseUserStaff getByUserId(Long userId) throws BaseException {
        BaseUserStaffExample example = new BaseUserStaffExample();
        example.createCriteria().andUserAccountIdEqualTo(userId);
        return baseUserStaffMapper.selectOne(example);
    }
    
    /**
     * 判断工号是否被使用
     * @param userId
     * @param jobNumber
     * @return
     */
    public boolean checkJobNumberExist(Long userId,String jobNumber){
    	if(BooleanUtils.isBlank(jobNumber)){
    		return false;
    	}
        BaseUserStaffExample example = new BaseUserStaffExample();
        example.createCriteria().andJobNumberEqualTo(jobNumber.trim());
        List<BaseUserStaff> list = baseUserStaffMapper.selectByExample(example);
        if(BooleanUtils.isEmpty(list)){
        	return false;
        }
        
        if(userId == null){
        	return true;
        }
        
        if(userId!=null){
        	for(BaseUserStaff model : list){
            	if(!model.getUserAccountId().equals(userId)){
            		return true;
            	}
            }
        }
        return false;
    }
}
