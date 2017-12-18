package com.yundao.tenant.service.customer.customerbank.impl;

import com.yundao.core.code.Result;
import com.yundao.core.enums.NumberEnum;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.customer.bank.CustomerBankListDto;
import com.yundao.tenant.dto.customer.customerbank.CustomerBankReqDto;
import com.yundao.tenant.mapper.base.customer.BaseCustomerBankMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerBankRelMapper;
import com.yundao.tenant.model.base.customer.BaseCustomerBank;
import com.yundao.tenant.model.base.customer.BaseCustomerBankExample;
import com.yundao.tenant.model.base.customer.BaseCustomerBankRel;
import com.yundao.tenant.model.base.customer.BaseCustomerBankRelExample;
import com.yundao.tenant.service.customer.customerbank.CustomerBankService;
import com.yundao.tenant.util.LocalBeanUtils;
import com.yundao.tenant.util.lambda.LambdaFilter;
import com.yundao.tenant.util.lambda.LambdaMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerBankServiceImpl extends AbstractService implements CustomerBankService {

    @Autowired
    private BaseCustomerBankMapper baseCustomerBankMapper;

    @Autowired
    private BaseCustomerBankRelMapper baseCustomerBankRelMapper;

    public Result<Long> add(CustomerBankReqDto reqDto) throws Exception {
        BaseCustomerBank model = new BaseCustomerBank();
        BeanUtils.copyProperties(reqDto, model);
        if (model.getTenantId() == null) {
            model.setTenantId(this.getHeaderTenantId());
        }
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setId(null);
        baseCustomerBankMapper.insertSelective(model);

        BaseCustomerBankRel rel = new BaseCustomerBankRel();
        super.initialModel(rel);
        rel.setCustomerId(reqDto.getCustomerId());
        rel.setBankId(model.getId());
        baseCustomerBankRelMapper.insertSelective(rel);

        return Result.newSuccessResult(model.getId());
    }

    public Result<Long> update(CustomerBankReqDto reqDto) throws Exception {
        BaseCustomerBank model = new BaseCustomerBank();
        BeanUtils.copyProperties(reqDto, model);
        if (model.getTenantId() == null) {
            model.setTenantId(this.getHeaderTenantId());
        }
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderUserId());
        int count = baseCustomerBankMapper.updateByPrimaryKeySelective(model);
        return Result.newSuccessResult(model.getId());
    }

    public Result<Integer> delete(Long id) throws Exception {
        BaseCustomerBank customerBank = new BaseCustomerBank();
        customerBank.setId(id);
        customerBank.setUpdateDate(new Date());
        customerBank.setUpdateUserId(super.getHeaderUserId());
        customerBank.setIsDelete(1);
        int count = baseCustomerBankMapper.updateByPrimaryKeySelective(customerBank);

        BaseCustomerBankRelExample relExample = new BaseCustomerBankRelExample();
        relExample.createCriteria().andBankIdEqualTo(id);
        baseCustomerBankRelMapper.deleteByExample(relExample);

        return Result.newSuccessResult(count);
    }

    @Override
    public Result<Integer> deleteByCustomerId(Long customerId) throws Exception {
        BaseCustomerBankRelExample relExample = new BaseCustomerBankRelExample();
        relExample.createCriteria().andCustomerIdEqualTo(customerId);
        BaseCustomerBankRel bankRel = baseCustomerBankRelMapper.selectOne(relExample);
        if (bankRel == null)
            return Result.newSuccessResult(NumberEnum.ZERO.getValue());
        baseCustomerBankRelMapper.deleteByPrimaryKey(bankRel.getId());
        int count = baseCustomerBankMapper.deleteByPrimaryKey(bankRel.getBankId());
        return Result.newSuccessResult(count);

    }

    public Result<CustomerBankReqDto> get(Long id) throws Exception {
        BaseCustomerBank model = baseCustomerBankMapper.selectByPrimaryKey(id);
        BaseCustomerBankRelExample relExample = new BaseCustomerBankRelExample();
        relExample.createCriteria().andBankIdEqualTo(id);
        BaseCustomerBankRel bankRel = baseCustomerBankRelMapper.selectOne(relExample);
        CustomerBankReqDto dto = new CustomerBankReqDto();
        BeanUtils.copyProperties(model, dto);
        dto.setCustomerId(bankRel.getCustomerId());
        return Result.newSuccessResult(dto);
    }

    @Override
    public Result<List<CustomerBankListDto>> getByCustomerId(Long customerId) throws Exception {
        List<CustomerBankListDto> dtos = new ArrayList<>();
        BaseCustomerBankRelExample relExample = new BaseCustomerBankRelExample();
        relExample.createCriteria().andCustomerIdEqualTo(customerId);
        List<BaseCustomerBankRel> relList = baseCustomerBankRelMapper.selectByExample(relExample);
        if (BooleanUtils.isEmpty(relList))
            return Result.newSuccessResult(dtos);

        BaseCustomerBankExample example = new BaseCustomerBankExample();
        example.createCriteria().andIdIn(LambdaMap.toSingleList(relList, m -> m.getBankId()));
        List<BaseCustomerBank> bankList = baseCustomerBankMapper.selectByExample(example);
        if (BooleanUtils.isEmpty(bankList))
            return Result.newSuccessResult(dtos);

        dtos = LocalBeanUtils.copyPropertiesList(bankList, CustomerBankListDto.class);
        for (CustomerBankListDto dto : dtos) {
            BaseCustomerBankRel relModel = LambdaFilter.firstOrDefault(relList, m -> dto.getId().equals(m.getBankId()));
            if (relModel != null)
                dto.setCustomerId(relModel.getCustomerId());
        }
        return Result.newSuccessResult(dtos);
    }

}
