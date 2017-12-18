package com.yundao.tenant.cache;

import com.yundao.core.cache.redis.JedisUtils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 短信相关缓存操作
 *
 * @author jan
 * @create 2017-06-14 PM4:48
 **/
public class SmsCache {

    /**
     * 获取手机号今天在指定租户系统下已发条数
     *
     * @param tenantId 租户id
     * @param mobile   手机号码
     * @return 为空 则返回0
     */
    public static Integer getMobileSentCount(Long tenantId, String mobile) {
        Object obj = JedisUtils.getObject(CacheKey.getMobileMaxCountKey(tenantId, mobile));
        return obj == null ? 0 : (Integer) obj;
    }

    /**
     * 获取租户今天已发条数
     *
     * @param tenantId 租户id
     * @return 为空 则返回0
     */
    public static Integer getTenantSentCount(Long tenantId) {
        Object obj = JedisUtils.getObject(CacheKey.getTenantMaxCount(tenantId));
        return obj == null ? 0 : (Integer) obj;
    }

    /**
     * 在原有值基础+1，原有值空时 为0
     *
     * @param tenantId 租户id
     * @param mobile   手机号码
     */
    public static void increMobileSentCount(Long tenantId, String mobile) {
        String key = CacheKey.getMobileMaxCountKey(tenantId, mobile);
        JedisUtils.incrementBy(key, 1);
        //更新缓存过期时间
        JedisUtils.expire(key, getTodayTimeLeft());
    }

    /**
     * 在原有值基础增加sendCount条记录
     *
     * @param tenantId 租户id
     */
    public static void increTenantSentCount(Long tenantId, Integer sendCount) {
        String key = CacheKey.getTenantMaxCount(tenantId);
        JedisUtils.incrementBy(key, sendCount);
        //更新缓存过期时间
        JedisUtils.expire(key, getTodayTimeLeft());
    }


    /**
     * 今天剩余时间
     *
     * @return 秒
     */
    private static int getTodayTimeLeft() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate
                .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                .get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
    }
}
