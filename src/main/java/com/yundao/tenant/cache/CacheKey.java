package com.yundao.tenant.cache;

import com.yundao.core.utils.ConfigUtils;

/**
 * 缓存key
 *
 * @author jan
 * @create 2017-07-11 PM8:30
 **/
public class CacheKey {

    public static final String SYS_CODE = ConfigUtils.getValue("id") + ":";

    static final String MSC_PREFIX = SYS_CODE + "msc_";

    static final String DICTIONARY_PREFIX = SYS_CODE + "dic_";

    /**
     * 手机号每天最大发送数
     */
    static final String MOBILE_MAX_COUNT = MSC_PREFIX + "mobile_max_count";

    /**
     * 租户每天最大发送数
     */
    static final String TENANT_MAX_COUNT = MSC_PREFIX + "tenant_max_count";

    /**
     * 数据字典缓存
     */
    static final String DICTIONARIES = DICTIONARY_PREFIX + "dictionaries_v2";

    /**
     * 机号每天最大发送数
     */
    public static String getMobileMaxCountKey(Long tenantId, String mobile) {
        return MOBILE_MAX_COUNT + "_" + tenantId + "_" + mobile;
    }

    /**
     * 租户每天最大发送数
     */
    public static String getTenantMaxCount(Long tenantId) {
        return TENANT_MAX_COUNT + "_" + tenantId;
    }

    /**
     * 数据字典
     */
    public static String getDictionaries(Long tenantId) {
        return DICTIONARIES + "_" + tenantId;
    }

}
