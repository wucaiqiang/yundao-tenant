package com.yundao.tenant.service.sms.impl;

import com.yundao.core.exception.BaseException;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.enums.YesOrNoEnum;
import com.yundao.tenant.mapper.base.BaseSmsAccountMapper;
import com.yundao.tenant.model.base.BaseSmsAccount;
import com.yundao.tenant.model.base.BaseSmsAccountExample;
import com.yundao.tenant.service.sms.SmsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短信账号服务实现
 *
 * @author jan
 * @create 2017-09-14 PM11:40
 **/
@Service
public class SmsAccountServiceImpl implements SmsAccountService {

    @Autowired
    private BaseSmsAccountMapper baseSmsAccountMapper;

    @Override
    public BaseSmsAccount get(Long tenantId) throws BaseException {
        BaseSmsAccountExample example = new BaseSmsAccountExample();
        example.createCriteria().andTenantIdEqualTo(tenantId).andIsEnableEqualTo(YesOrNoEnum.YES.getValue());
        example.setOrderByClause("create_date DESC");
        List<BaseSmsAccount> accounts = baseSmsAccountMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(accounts))
            return null;
        return accounts.get(0);
    }
}
