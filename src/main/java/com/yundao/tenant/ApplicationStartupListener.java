package com.yundao.tenant;

import com.yundao.core.cache.redis.JedisUtils;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.JsonUtils;
import com.yundao.tenant.cache.CacheKey;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import redis.clients.jedis.Jedis;

import javax.servlet.annotation.WebListener;
import java.util.Set;

/**
 * 应用程序监听
 *
 * @author jan
 * @create 2017-11-07 11:41
 **/
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Log log = LogFactory.getLog(ApplicationStartupListener.class);

    public void onApplicationEvent(ContextRefreshedEvent event) {
        String logPrefix = "spring容器加载完成||清除缓存||";
        if (event.getApplicationContext().getParent() != null) {
            log.info("%s 非主容器", logPrefix);
            return;
        }
        try {
            log.info("%s开始", logPrefix);
            Jedis jedis = JedisUtils.getJedis();
            Set<String> keys = jedis.keys(CacheKey.SYS_CODE + "*");
            log.info("%s keys：%s", logPrefix, JsonUtils.objectToJson(keys));
            for (String key : keys)
                JedisUtils.remove(key);
            log.info("%s完成", logPrefix);
        } catch (Exception ex) {
            log.error("%s 异常：%s", logPrefix, ex.toString());
        }
    }
}
