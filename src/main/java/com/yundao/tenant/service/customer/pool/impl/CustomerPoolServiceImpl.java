package com.yundao.tenant.service.customer.pool.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.core.service.AbstractService;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageReqDto;
import com.yundao.tenant.dto.customer.pool.CustomerPoolPageResDto;
import com.yundao.tenant.enums.common.SexEnum;
import com.yundao.tenant.enums.customer.CustomerLevelEnum;
import com.yundao.tenant.mapper.customer.pool.CustomerPoolMapper;
import com.yundao.tenant.service.customer.pool.CustomerPoolService;
import com.yundao.tenant.service.region.RegionService;
import com.yundao.tenant.service.user.UserService;
import com.yundao.tenant.util.BaseContactUtils;
import com.yundao.tenant.util.LocalBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户池服务实现
 *
 * @author jan
 * @create 2017-08-14 AM9:16
 **/
@Service
public class CustomerPoolServiceImpl extends AbstractService implements CustomerPoolService {

    private static Log log = LogFactory.getLog(CustomerPoolServiceImpl.class);

    @Autowired
    private CustomerPoolMapper customerPoolMapper;

    @Autowired
    private RegionService regionService;

    @Autowired
    private UserService userService;

    @Override
    public Result<PaginationSupport<CustomerPoolPageResDto>> getPage(CustomerPoolPageReqDto dto, Integer permission)
            throws
            BaseException {
        log.begin(dto);
        if (BooleanUtils.isNotEmpty(dto.getMobile()))
            dto.setMobile(BaseContactUtils.encrypt(dto.getMobile()));
        Map<String, Object> paramMap = LocalBeanUtils.toMap(dto);
        PaginationSupport<CustomerPoolPageResDto> page = PaginationSupport.newDefault(paramMap);
        //根据不同权限，设置查询条件
        userService.setPermissionCondition(paramMap, permission);
        List<CustomerPoolPageResDto> dtos = customerPoolMapper.selectCustomerPage(paramMap);
        if (BooleanUtils.isEmpty(dtos))
            return Result.newSuccessResult(page);
        Integer count = customerPoolMapper.selectCustomerPageCount(paramMap);
        page.setTotalCount(count);
        this.setText(dtos);
        page.setDatas(dtos);
        return Result.newSuccessResult(page);
    }

    /**
     * 设置文本
     */
    private void setText(List<CustomerPoolPageResDto> dtos) throws BaseException {
        for (CustomerPoolPageResDto dto : dtos) {
            dto.setLevelText(CustomerLevelEnum.getEnumName(dto.getLevel()));
            dto.setSexText(SexEnum.getEnumName(dto.getSex()));
            dto.setMobile(BaseContactUtils.decrypt(dto.getMobile()));
            dto.setIsDealText(dto.getDealDate() != null ? "是" : "否");
            if (BooleanUtils.isNotEmpty(dto.getProvinceCode()))
                dto.setProvinceText(regionService.toText(dto.getProvinceCode()));
            if (BooleanUtils.isNotEmpty(dto.getCityCode()))
                dto.setCityText(regionService.toText(dto.getCityCode()));
        }
    }
}
