
package com.yundao.tenant.service.customer.credentials.impl;

import com.yundao.core.constant.CommonConstant;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customer.credentials.CustomerCredentialsDto;
import com.yundao.tenant.enums.customer.CustomerCredentialsEnum;
import com.yundao.tenant.mapper.base.customer.BaseCustomerCredentialsMapper;
import com.yundao.tenant.mapper.base.customer.BaseCustomerCredentialsRelMapper;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentials;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRel;
import com.yundao.tenant.model.base.customer.BaseCustomerCredentialsRelExample;
import com.yundao.core.service.AbstractService;
import com.yundao.tenant.service.customer.credentials.CustomerCredentialsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Function: Reason: Date: 2017年8月10日 下午2:33:12
 *
 * @author wucq
 */
@Service
public class CustomerCredentialsServiceImpl extends AbstractService implements CustomerCredentialsService {

    @Autowired
    private BaseCustomerCredentialsMapper baseCustomerCredentialsMapper;

    @Autowired
    private BaseCustomerCredentialsRelMapper baseCustomerCredentialsRelMapper;

    @Override
    public CustomerCredentialsDto selectByCustomerId(Long customerId) throws BaseException {
        BaseCustomerCredentialsRelExample relExample = new BaseCustomerCredentialsRelExample();
        relExample.createCriteria().andCustomerIdEqualTo(customerId);
        BaseCustomerCredentialsRel rel = baseCustomerCredentialsRelMapper.selectOne(relExample);
        if (rel == null)
            return null;

        BaseCustomerCredentials credential = baseCustomerCredentialsMapper.selectByPrimaryKey(rel.getCredentialsId());
        CustomerCredentialsDto dto = null;

        if (credential != null) {
            dto = new CustomerCredentialsDto();
            BeanUtils.copyProperties(credential, dto);
            if (dto.getType() != null) {
                dto.setTypeText(CustomerCredentialsEnum.getEnumName(dto.getType().intValue()));
            }
        }
        return dto;
    }

    @Override
    public int update(BaseCustomerCredentials model) throws BaseException {
        if (model == null) {
            throw new BaseException(CodeConstant.CODE_1200092);
        }
        if (model.getNumber() != null && model.getType() == null) {
            throw new BaseException(CodeConstant.CODE_1200091);
        }
        model.setUpdateDate(new Date());
        model.setUpdateUserId(super.getHeaderTenantId());
        int count = baseCustomerCredentialsMapper.updateByPrimaryKey(model);
        return count;

    }

    @Override
    public int insert(BaseCustomerCredentials model) throws BaseException {
        if (model == null) {
            model = new BaseCustomerCredentials();
        }
        model.setCreateDate(new Date());
        model.setCreateUserId(super.getHeaderUserId());
        model.setTenantId(super.getHeaderTenantId());
        model.setId(null);
        model.setIsDelete(CommonConstant.ZERO);

        int count = baseCustomerCredentialsMapper.insert(model);
        return count;

    }

    @Override
    public Long insertRel(Long customerId, Long credentialsId) throws BaseException {
        BaseCustomerCredentialsRel ccRel = new BaseCustomerCredentialsRel();
        super.initialModel(ccRel);
        ccRel.setCustomerId(customerId);
        ccRel.setCredentialsId(credentialsId);
        baseCustomerCredentialsRelMapper.insertSelective(ccRel);
        return ccRel.getId();
    }

}
