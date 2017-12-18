package com.yundao.tenant.util.lambda;

import com.yundao.core.dto.HeaderUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式过滤工具类 单元测试
 *
 * @author jan
 * @create 2017-06-15 PM7:56
 **/
public class LambdaFilterTest {

    private List<HeaderUser> headers;
    private HeaderUser h1;
    private HeaderUser h2;
    private HeaderUser h3;


    @Before
    public void testBefore() {
        headers = new ArrayList<>();

        h1 = new HeaderUser();
        h1.setUserId(1L);
        h1.setRealName("ONE");

        h2 = new HeaderUser();
        h2.setUserId(2L);
        h2.setRealName("TWO");

        h3 = new HeaderUser();
        h3.setUserId(1L);
        h3.setRealName("THREE");

        headers.add(h1);
        headers.add(h2);
        headers.add(h3);
    }

    @Test
    public void firstOrDefault() throws Exception {
        //获取userid==1的第一个结果
        HeaderUser result = LambdaFilter.firstOrDefault(headers, m -> m.getUserId().equals(1L));
        //断言 结果与h1相同
        Assert.assertEquals(h1, result);

        //获取realName==TWO 的第一个结果
        HeaderUser result2 = LambdaFilter.firstOrDefault(headers, m -> m.getRealName().equals("TWO"));
        //断言 结果与h2相同
        Assert.assertEquals(h2, result2);

        //获取第一个结果
        HeaderUser result3 = LambdaFilter.firstOrDefault(headers, m -> true);
        //断言 结果与h1相同
        Assert.assertEquals(h1, result3);

        List<HeaderUser> headers2 = new ArrayList<>();
        HeaderUser result4 = LambdaFilter.firstOrDefault(headers2, m -> true);
        //断言 结果为Null
        Assert.assertEquals(null, result4);

    }

    /**
     * 空引用异常断言
     */
    @Test(expected = NullPointerException.class)
    public void firstOrDefault_NullPointerException() {
        //headers为Null的情况
        List<HeaderUser> headers = null;
        LambdaFilter.firstOrDefault(headers, m -> true);
    }

    @Test
    public void toList() throws Exception {
        List<HeaderUser> result = LambdaFilter.toList(headers, m -> m.getUserId().equals(1L));
        //断言 userid为1的，有2条数据
        Assert.assertEquals(2, result.size());

        //realName==THREE 有1条数据
        List<HeaderUser> result2 = LambdaFilter.toList(headers, m -> m.getRealName().equals("THREE"));
        Assert.assertEquals(1, result2.size());
    }

    @Test(expected = NullPointerException.class)
    public void toList_NullPointerException() {
        //headers为Null的情况
        List<HeaderUser> headers = null;
        LambdaFilter.toList(headers, m -> true);
    }

}