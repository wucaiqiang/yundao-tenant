package com.yundao.tenant.service.region;

import com.yundao.core.exception.BaseException;

/**
 * 区域服务接口
 *
 * @author jan
 * @create 2017-08-09 PM3:29
 **/
public interface RegionService {

    /**
     * 翻译成文本
     *
     * @param code 省或城市的CODE
     */
    String toText(String code) throws BaseException;

}
