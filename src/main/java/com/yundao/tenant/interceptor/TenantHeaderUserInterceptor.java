package com.yundao.tenant.interceptor;

import com.yundao.core.constant.CommonConstant;
import com.yundao.core.dto.HeaderUser;
import com.yundao.core.exception.BaseException;
import com.yundao.core.interceptor.AbstractInterceptor;
import com.yundao.core.log.Log;
import com.yundao.core.log.LogFactory;
import com.yundao.core.utils.BooleanUtils;
import com.yundao.core.utils.EDUtils;
import com.yundao.tenant.constant.code.CodeConstant;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 从头部获取、设置用户信息拦截器
 *
 * @author jan
 * @create 2017-06-22 PM2:23
 **/
public class TenantHeaderUserInterceptor extends AbstractInterceptor {

    private static Log log = LogFactory.getLog(TenantHeaderUserInterceptor.class);

    private String excludeUrl = null;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userSession = this.getSession(request);
        if (userSession == null)
            throw new BaseException(CodeConstant.CODE_1220020);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 获取用户登录后的会话
     *
     * @param request servlet请求
     * @return 请求用户信息
     */
    public Object getSession(HttpServletRequest request) {
        // 获取用户的登录信息
        HeaderUser result = null;
        String userId = request.getHeader("headerUserId");
        String realName = EDUtils.decode(request.getHeader("headerRealName"));
        String tenantId = request.getHeader("headerTenantId");
        if (!BooleanUtils.isBlank(userId) && !BooleanUtils.isBlank(tenantId)) {
            result = new HeaderUser();
            result.setUserId(NumberUtils.toLong(userId));
            result.setRealName(realName);
            result.setTenantId(NumberUtils.toLong(tenantId));
            request.setAttribute(CommonConstant.HEADER_USER, result);
        } else {
            if (excludeUrl.contains(request.getRequestURI())) {
                return new HeaderUser();
            }
        }
        log.info("从头部获取用户的信息headerUserId=" + userId + ",headerRealName=" + realName + ",headerTenantId=" + tenantId);
        return result;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.printf("");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }

    public String getExcludeUrl() {
        return excludeUrl;
    }

    public void setExcludeUrl(String excludeUrl) {
        this.excludeUrl = excludeUrl;
    }
}
