package com.yundao.tenant.util;

import com.yundao.core.exception.BaseException;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void getMonthTest() throws BaseException {

        String strDate = "2017-08-08 18:30:10";
        String result = DateUtil.getMonth(strDate);
        Assert.assertEquals("8", result);

        String strDate2 = "2017-12-08 18:30:10";
        String result2 = DateUtil.getMonth(strDate2);
        Assert.assertEquals("12", result2);

        String strDate3 = "";
        String result3 = DateUtil.getMonth(strDate3);
        Assert.assertEquals("", result3);
    }

    @Test
    public void getDayTest() throws BaseException {

        String strDate = "2017-08-02 18:30:10";
        String result = DateUtil.getDay(strDate);
        Assert.assertEquals("2", result);

        String strDate2 = "2017-12-25 18:30:10";
        String result2 = DateUtil.getDay(strDate2);
        Assert.assertEquals("25", result2);

        String strDate3 = "";
        String result3 = DateUtil.getDay(strDate3);
        Assert.assertEquals("", result3);
    }

}