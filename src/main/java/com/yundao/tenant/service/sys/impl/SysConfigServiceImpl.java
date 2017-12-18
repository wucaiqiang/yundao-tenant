package com.yundao.tenant.service.sys.impl;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.dto.sys.sale.SaleConfOpenseaDto;
import com.yundao.tenant.dto.sys.sale.SaleConfOpenseaReqDto;
import com.yundao.tenant.dto.sys.sale.SaleConfResDto;
import com.yundao.tenant.enums.sys.SysConfEnum;
import com.yundao.tenant.mapper.base.sys.BaseSysConfigMapper;
import com.yundao.tenant.model.base.sys.BaseSysConfig;
import com.yundao.tenant.model.base.sys.BaseSysConfigExample;
import com.yundao.tenant.service.sys.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统配置服务实现
 *
 * @author jan
 * @create 2017-11-03 11:47
 **/
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private BaseSysConfigMapper baseSysConfigMapper;

    @Override
    public Result<SaleConfResDto> getSaleConf() throws BaseException {
        BaseSysConfig config = this.getConfig(SysConfEnum.SALE.getCode());

        SaleConfResDto confDto = JsonUtils.jsonToObject(config.getParams(), new BaseTypeReference<SaleConfResDto>() {
        });

        return Result.newSuccessResult(confDto);
    }

    @Override
    public Result<Boolean> updateSaleConf(SaleConfOpenseaReqDto dto) throws BaseException {
        SaleConfResDto saleConf = new SaleConfResDto();
        SaleConfOpenseaDto saleConfOpensea = new SaleConfOpenseaDto();
        saleConfOpensea.setTakeLimitCount(dto.getTakeLimitCount());
        saleConfOpensea.setTakeLimitEnable(dto.getTakeLimitEnable());
        saleConf.setOpensea(saleConfOpensea);

        BaseSysConfig config = this.getConfig(SysConfEnum.SALE.getCode());
        config.setParams(JsonUtils.objectToJson(saleConf));
        baseSysConfigMapper.updateByPrimaryKeySelective(config);
        return Result.newSuccessResult(true);
    }

    private BaseSysConfig getConfig(String code) {
        BaseSysConfigExample example = new BaseSysConfigExample();
        example.createCriteria().andCodeEqualTo(code);
        return baseSysConfigMapper.selectOne(example);
    }


}
