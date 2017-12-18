package com.yundao.tenant;

import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.constant.MethodConstant;
import com.yundao.core.threadlocal.filter.RequestCommonParams;
import com.yundao.core.utils.FileUtils;
import com.yundao.core.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jan
 * @create 2017-06-19 PM7:25
 **/
public class AbstractTest {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * post方法调用
     *
     * @param requestUrl
     * @param methodParams
     * @throws Exception
     */
    public void post(String requestUrl, Map<String, Object> methodParams) throws Exception {
        this.doExecute(requestUrl, methodParams, MethodConstant.POST);
    }

    /**
     * get方法调用
     *
     * @param requestUrl
     * @param methodParams
     * @throws Exception
     */
    public void get(String requestUrl, Map<String, Object> methodParams) throws Exception {
        this.doExecute(requestUrl, methodParams, MethodConstant.GET);
    }

    /**
     * 获取头部用户信息
     *
     * @return
     */
    public Map<String, String> getHeaderParams() {
        Map<String, String> result = new HashMap<String, String>();
//		result.put(CheaderTenantId, "1232");
        result.put("headerTenantId", "1");
        result.put("headerUserId", "1");
        result.put("headerRealName","admin");
        return result;
    }

    private void doExecute(String requestUrl, Map<String, Object> methodParams, String method) throws Exception {
        Map<String, String> headerParams = this.getHeaderParams();
        
        if (methodParams.get(HeaderConstant.USER_ROLE) != null) {
        	headerParams.put(HeaderConstant.USER_ROLE, methodParams.get(HeaderConstant.USER_ROLE).toString());
        }
        RequestCommonParams requestParams = RequestCommonParams.newDefault();
        requestParams.setHeaderParams(headerParams);
        requestParams.setMethodParams(methodParams);
        
        String url ="http://localhost:8202";

        String result = null;
        if (MethodConstant.GET.equals(method)) {
            result = HttpUtils.get(FileUtils.getRealPath(url, requestUrl), requestParams);
        } else {
            result = HttpUtils.post(FileUtils.getRealPath(url, requestUrl), requestParams);
        }
        logger.info(result);
    }
}