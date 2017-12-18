package com.yundao.tenant.filter;

import com.yundao.core.constant.CommonConstant;
import com.yundao.core.constant.HeaderConstant;
import com.yundao.core.threadlocal.filter.ThreadLocalFilter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * 本地线程过滤器
 *
 * @author jan
 * @create 2017-06-27 PM5:20
 **/
@Component
@WebFilter(filterName = "tenantThreadLocalFilter", urlPatterns = "/*")
public class TenantThreadLocalFilter extends ThreadLocalFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
    	String tenantId = httpRequest.getHeader(HeaderConstant.HEADER_TENANT_ID);
    	MDC.put(CommonConstant.TENANT_ID, tenantId);
        super.doFilter(request, response, chain);
    }
}
