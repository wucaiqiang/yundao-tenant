package com.yundao.tenant.datasource;

import com.yundao.core.code.Result;
import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.json.jackson.type.BaseTypeReference;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.threadlocal.ThreadLocalUtils;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.ConfigUtils;
import com.yundao.tenant.constant.url.ScmUrlConstant;
import com.yundao.tenant.dto.infrastructure.DataSourceDto;
import com.yundao.tenant.util.HeaderUserThreadLocal;
import com.yundao.tenant.util.HttpUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源切换
 *
 * @param <T> 数据源泛型T
 */
public abstract class DynamicDataSource<T extends DataSource> extends AbstractRoutingDataSource {

    private static Log log = LogFactory.getLog(DynamicDataSource.class);

    private static Map<Object, Object> dataSources = new HashMap<>();

    private static final String DEFAULT_SYSTEM_CODE = "WM";


    @Override
    protected Object determineCurrentLookupKey() {
        HeaderUser result = (HeaderUser) ThreadLocalUtils.getFromRequest(CommonConstant.HEADER_USER);
        if (result == null)
            result = HeaderUserThreadLocal.get();
        String dataSourceName = (result != null) ? result.getTenantId().toString() : null;
        if (BooleanUtils.isNotEmpty(dataSourceName)) {
            this.selectDataSource(dataSourceName);
        }
        log.info("切换至数据源：%s", dataSourceName);
        return dataSourceName;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        DynamicDataSource.dataSources = targetDataSources;
        super.setTargetDataSources(DynamicDataSource.dataSources);
        super.afterPropertiesSet();

    }

    /**
     * 保存已使用的数据源
     *
     * @param key        数据源对应的键
     * @param dataSource 数据源
     */
    public void addTargetDataSource(String key, T dataSource) {
        DynamicDataSource.dataSources.put(key, dataSource);
        this.setTargetDataSources(DynamicDataSource.dataSources);
    }

    /**
     * 选中数据源
     *
     * @param tenantId 租户id
     */
    private void selectDataSource(String tenantId) {
        log.info("selectDataSource 开始");
        //当前租户的数据源
        Object obj = DynamicDataSource.dataSources.get(tenantId);
        if (obj == null) {
            T dataSource = this.getDataSource(tenantId);
            if (dataSource == null) {
                log.info("dataSource 结果为空");
                return;
            }
            log.info("addTargetDataSource");
            this.addTargetDataSource(tenantId, dataSource);
        }
    }

    /**
     * 获取数据源
     *
     * @param tenantId 租户id
     * @return 数据源
     */
    private T getDataSource(String tenantId) {
        //默认数据源
        String driverClassName = ConfigUtils.getValue("spring.datasource.driver-class-name");
        log.info("driverClassName:%s", driverClassName);
        String url = ConfigUtils.getValue("spring.datasource.url");
        log.info("url:%s", url);
        String userName = ConfigUtils.getValue("spring.datasource.username");
        log.info("userName:%s", userName);
        String password = ConfigUtils.getValue("spring.datasource.password");
        log.info("password:%s", password);
        //获取租户的数据源
        HashMap<String, Object> params = new HashMap<>();
        params.put("tenantId", tenantId);
        params.put("systemCode", DEFAULT_SYSTEM_CODE);
        try {
            Result<DataSourceDto> result = HttpUtils.get(ScmUrlConstant.GET_DATA_SOURCE, params, new BaseTypeReference<Result<DataSourceDto>>() {
            });
            DataSourceDto dto = result.getResult();
            log.info("scm 返回结果 id:%s,tenantId:%s,name:%s", dto.getId(), dto.getTenantId(), dto.getName());
            if (result == null || result.getResult() == null || !result.getSuccess())
                return null;

            DataSourceDto dataSourceDto = result.getResult();
            driverClassName = dataSourceDto.getDriverClassName();
            url = dataSourceDto.getUrl();
            userName = dataSourceDto.getUsername();
            password = dataSourceDto.getPassword();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return this.createDataSource(driverClassName, url, userName, password);

    }

    public abstract T createDataSource(String driverClassName, String url, String username, String password);

}
