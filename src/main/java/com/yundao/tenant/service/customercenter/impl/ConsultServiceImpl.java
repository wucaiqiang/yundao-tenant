package com.yundao.tenant.service.customercenter.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import com.yundao.tenant.dto.customercenter.consult.ConsultFPReqDto;
import com.yundao.tenant.dto.customercenter.consult.ConsultProductReqDto;
import com.yundao.tenant.dto.sale.leads.LeadsAddReqDto;
import com.yundao.tenant.enums.sale.leads.LeadsTypeEnum;
import com.yundao.tenant.mapper.base.cc.BaseCcCustomerUserRelMapper;
import com.yundao.tenant.mapper.base.product.BaseProductMapper;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRel;
import com.yundao.tenant.model.base.cc.BaseCcCustomerUserRelExample;
import com.yundao.tenant.model.base.product.BaseProduct;
import com.yundao.tenant.service.cc.product.ProductConsultService;
import com.yundao.tenant.service.customercenter.ConsultService;
import com.yundao.tenant.service.sale.leads.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 预约服务实现
 *
 * @author jan
 * @create 2017-09-07 AM11:48
 **/
@Service
public class ConsultServiceImpl implements ConsultService {

    private static Log log = LogFactory.getLog(ConsultServiceImpl.class);

    @Autowired
    private BaseCcCustomerUserRelMapper baseCcCustomerUserRelMapper;

    @Autowired
    private BaseProductMapper baseProductMapper;

    @Autowired
    private LeadsService leadsService;

    @Autowired
    private ProductConsultService productConsultService;

    @Override
    public Result<Long> addForProduct(ConsultProductReqDto dto) throws BaseException {
        String logPrefix = "理财客户预约||预约产品||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
        Long customerId = this.getCustomerId(dto.getUserId());
        BaseProduct product = baseProductMapper.selectByPrimaryKey(dto.getProductId());
        if (product == null)
            throw new BaseException(CodeConstant.CODE_1200042);
        String productName = product.getName();
        log.info("%s productName %s", logPrefix, productName);
        LeadsAddReqDto leadsDto = new LeadsAddReqDto();
        leadsDto.setChannel(dto.getChannel());
        leadsDto.setType(LeadsTypeEnum.PRODUCT.getValue());
        leadsDto.setContent(BooleanUtils.isEmpty(productName) ? "" : "预约" + productName);

        productConsultService.insert(customerId, product.getId());
        Result<Long> result = leadsService.add(customerId, leadsDto);
        log.info("%s完成 result %s", logPrefix, JsonUtils.objectToJson(result));
        return result;
    }

    @Override
    public Result<Long> addForFP(ConsultFPReqDto dto) throws BaseException {
        String logPrefix = "理财客户预约||预约理财师||";
        log.info("%s dto %s", logPrefix, JsonUtils.objectToJson(dto));
        Long customerId = this.getCustomerId(dto.getUserId());

        LeadsAddReqDto leadsDto = new LeadsAddReqDto();
        leadsDto.setChannel(dto.getChannel());
        leadsDto.setType(LeadsTypeEnum.FP.getValue());
        leadsDto.setContent("预约理财师");
        Result<Long> result = leadsService.add(customerId, leadsDto);
        log.info("%s完成 result %s", logPrefix, JsonUtils.objectToJson(result));
        return result;
    }

    /**
     * 根据用户id，获取对应的客户id
     *
     * @param userId 用户id
     */
    private Long getCustomerId(Long userId) throws BaseException {
        BaseCcCustomerUserRelExample example = new BaseCcCustomerUserRelExample();
        example.createCriteria().andUserAccountIdEqualTo(userId);
        BaseCcCustomerUserRel customerUserRel = baseCcCustomerUserRelMapper.selectOne(example);
        if (customerUserRel == null)
            throw new BaseException(CodeConstant.CODE_1220085);
        return customerUserRel.getCustomerId();
    }
}
