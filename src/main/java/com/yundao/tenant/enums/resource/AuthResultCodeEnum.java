package com.yundao.tenant.enums.resource;

/**
 * 资源鉴权结果编码枚举
 *
 * @author jan
 * @create 2017-11-08 10:24
 **/
public enum AuthResultCodeEnum {

    /**
     * 授权
     */
    AUTHORIZATION("authorization", "授权"),

    /**
     * 白名单
     */
    WHITELIST("whitelist", "白名单"),

    /**
     * 不在数据库资源内
     * 如果请求地址，在数据库不存在，表示不需要鉴权，临时方案，后面全部api地址加入到数据库后需要修改
     */
    NOT_IN_REOUSRCE("not_in_resource", "不在数据库资源内"),

    /**
     * 拒绝访问
     */
    DENIED("denied", "拒绝访问");

    private String code;
    private String name;


    private AuthResultCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
