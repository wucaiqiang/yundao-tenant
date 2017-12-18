package com.yundao.tenant.enums;

/**
 * URL枚举
 *
 * @author jan
 * @create 2017-06-21 PM8:09
 **/
public enum UrlEnum {

    /**
     * 基础服务
     */
    Base_URL("base.url"),

    /**
     * 工作流
     */
    WORKFLOW_URL("workflow.url"),

    /**
     * 公共管理系统
     */
    SCM_URL("scm.url");

    private String key;

    private UrlEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
