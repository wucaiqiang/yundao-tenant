package com.yundao.tenant.service.customer.imports;

import com.yundao.core.code.Result;
import com.yundao.core.exception.BaseException;
import com.yundao.tenant.dto.customer.imports.CustomerImportDto;

import java.util.List;

/**
 * 客户导入服务接口
 *
 * @author jan
 * @create 2017-08-31 PM3:31
 **/
public interface CustomerImportService {

    /**
     * 获取已存在的客户
     *
     * @param mobiles 以逗号分隔的多个手机号码
     */
    Result<List<String>> getExistList(String mobiles) throws BaseException;

    /**
     * 从公海导入客户
     */
    Result<Boolean> doImportFormOpensea(List<CustomerImportDto> dtos) throws BaseException;

    /**
     * 从客户页面导入客户 V2接口
     */
    Result<Boolean> doImportV2(List<CustomerImportDto> dtos) throws BaseException;
}
