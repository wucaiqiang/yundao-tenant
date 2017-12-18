package com.yundao.tenant.datasource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;

import java.util.List;

public class DruidDynamicDataSource extends DynamicDataSource<DruidDataSource> {

    private final boolean testWhileIdle = true;
    private final boolean testOnBorrow = false;
    private final boolean testOnReturn = false;

    // 是否打开连接泄露自动检测
    private final boolean removeAbandoned = false;
    // 连接长时间没有使用，被认为发生泄露时长
    private final long removeAbandonedTimeoutMillis = 300 * 1000;
    // 发生泄露时是否需要输出 log，建议在开启连接泄露检测时开启，方便排错
    private final boolean logAbandoned = false;

    // 配置监控统计拦截的filters
    private List<Filter> filterList;

    @Override
    public DruidDataSource createDataSource(String driverClassName, String url, String username, String password) {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driverClassName);
        ds.setTestWhileIdle(testWhileIdle);
        ds.setTestOnBorrow(testOnBorrow);
        ds.setTestOnReturn(testOnReturn);

        ds.setRemoveAbandoned(removeAbandoned);
        ds.setRemoveAbandonedTimeoutMillis(removeAbandonedTimeoutMillis);
        ds.setLogAbandoned(logAbandoned);
        addFilterList(ds);
        return ds;
    }

    private void addFilterList(DruidDataSource ds) {
        if (filterList != null) {
            List<Filter> targetList = ds.getProxyFilters();
            for (Filter add : filterList) {
                boolean found = false;
                for (Filter target : targetList) {
                    if (add.getClass().equals(target.getClass())) {
                        found = true;
                        break;
                    }
                }
                if (!found)
                    targetList.add(add);
            }
        }
    }

}
