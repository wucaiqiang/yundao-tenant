
package com.yundao.tenant.service.user.customer.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.customer.CustomerMultiIdReqDto;
import com.yundao.tenant.dto.user.customer.UserCustomerFocusReqDto;
import com.yundao.tenant.enums.DeleteEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerMapper;
import com.yundao.tenant.mapper.base.customer.BaseUserCustomerFocusMapper;
import com.yundao.tenant.model.base.customer.BaseCustomer;
import com.yundao.tenant.model.base.customer.BaseCustomerExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocus;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocusExample;
import com.yundao.tenant.model.base.customer.BaseUserCustomerFocusExample.Criteria;
import com.yundao.tenant.service.user.customer.UserCustomerFocusService;
import com.yundao.tenant.util.SymbolStrUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 客户关注服务实现
 * Function: Reason: Date: 2017年8月9日 下午2:17:19
 *
 * @author wucq
 */
@Service
public class UserCustomerFocusServiceImpl extends AbstractService implements UserCustomerFocusService {

    private static Log log = LogFactory.getLog(UserCustomerFocusServiceImpl.class);

    @Autowired
    private BaseUserCustomerFocusMapper baseUserCustomerFocusMapper;

    @Autowired
    private BaseCustomerMapper baseCustomerMapper;

    @Override
    public List<BaseUserCustomerFocus> select(UserCustomerFocusReqDto reqDto) throws BaseException {
        BaseUserCustomerFocusExample example = new BaseUserCustomerFocusExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(reqDto.getUserId());
        criteria.andCustomerIdEqualTo(reqDto.getCustomerId());
        List<BaseUserCustomerFocus> customerFocus = baseUserCustomerFocusMapper.selectByExample(example);
        return customerFocus;
    }


    @Override
    public Result<Boolean> doFocus(CustomerMultiIdReqDto dto) throws BaseException {
        log.begin(dto.getCustomerIds());
        List<Long> customerIdList = SymbolStrUtils.toLongWithTypeCheck(dto.getCustomerIds());
        BaseCustomerExample customerExample = new BaseCustomerExample();
        customerExample.createCriteria().andIdIn(customerIdList);
        //查询需要关注的客户数据
        List<BaseCustomer> customers = baseCustomerMapper.selectByExample(customerExample);
        log.info("customer:%s", JsonUtils.objectToJson(customers));
        if (BooleanUtils.isEmpty(customers))
            return Result.newSuccessResult();
        Long userId = super.getHeaderUserId();
        BaseUserCustomerFocusExample focusExample = new BaseUserCustomerFocusExample();
        focusExample.createCriteria().andUserIdEqualTo(userId).andCustomerIdIn(LambdaMap.toSingleList(customers, m -> m
                .getId()));
        //查询这批客户在 关注表的数据
        List<BaseUserCustomerFocus> focusList = baseUserCustomerFocusMapper.selectByExample(focusExample);
        log.info("focusList:%s", JsonUtils.objectToJson(focusList));
        for (Long customerId : customerIdList) {
            BaseUserCustomerFocus existFocus = LambdaFilter.firstOrDefault(focusList, m -> customerId.equals(m.getCustomerId()));
            if (existFocus == null) {
                BaseUserCustomerFocus focus = new BaseUserCustomerFocus();
                super.initialModel(focus);
                focus.setCustomerId(customerId);
                focus.setUserId(userId);
                focus.setFocusDate(new Date());
                baseUserCustomerFocusMapper.insertSelective(focus);
            }
        }
        log.end();
        return Result.newSuccessResult(true);
    }

    @Override
    public Result<Boolean> doUnFocus(Long customerId) throws BaseException {
        log.begin(customerId);
        Long userId = super.getHeaderUserId();
        BaseUserCustomerFocusExample focusExample = new BaseUserCustomerFocusExample();
        focusExample.createCriteria().andCustomerIdEqualTo(customerId).andUserIdEqualTo(userId);
        BaseUserCustomerFocus existFocus = baseUserCustomerFocusMapper.selectOne(focusExample);
        log.info("existFocus:%s", JsonUtils.objectToJson(existFocus));
        if (existFocus == null)
            return Result.newSuccessResult(true);
        super.updateModel(existFocus);
        existFocus.setIsDelete(DeleteEnum.DELETED.getValue());
        baseUserCustomerFocusMapper.updateByPrimaryKeySelective(existFocus);
        return Result.newSuccessResult(true);
    }

}
