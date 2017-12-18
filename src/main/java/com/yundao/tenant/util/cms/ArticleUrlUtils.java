package com.yundao.tenant.util.cms;

/**
 * 文章url处理
 *
 * @author jan
 * @create 2017-10-19 10:14
 **/
public class ArticleUrlUtils {

    static final String article_fristCatalog = "news";
    static final String article_extFileName = ".html";

    static final String column_extCode = "_news";

    /**
     * 生成文章url
     *
     * @param articleCode 文章code
     * @return url
     */
    public static String generateUrl(String articleCode) {
        return "/" + article_fristCatalog + "/" + articleCode + article_extFileName;
    }

    /**
     * 生成文章包含域名的url
     *
     * @param domain      域名
     * @param articleCode 文章code
     * @return url
     */
    public static String generateUrl(String domain, String articleCode) {
        String url = generateUrl(articleCode);
        return domain + url;
    }

    /**
     * 生成文章栏目url
     *
     * @param columnCode 栏目code
     * @return url
     */
    public static String generateColumnUrl(String columnCode) {
        return "/" + columnCode + column_extCode;
    }

}
