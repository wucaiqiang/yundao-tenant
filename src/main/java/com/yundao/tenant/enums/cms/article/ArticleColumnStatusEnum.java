package com.yundao.tenant.enums.cms.article;

/**
 * 文章栏目状态枚举
 *
 * @author jan
 * @create 2017-10-20 14:56
 **/
public enum ArticleColumnStatusEnum {


    /**
     * 停用
     */
    DISENABLE(0, "停用"),

    /**
     * 启用
     */
    ENABLE(1, "启用");

    private Integer value;
    private String name;


    private ArticleColumnStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
