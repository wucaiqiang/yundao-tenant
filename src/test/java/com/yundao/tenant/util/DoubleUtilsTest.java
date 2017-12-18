package com.yundao.tenant.util;

import org.junit.Assert;
import org.junit.Test;

public class DoubleUtilsTest {

    @Test
    public void toWholeStringTest() {
        Double d=500.0;
        String s = DoubleUtils.toWholeString(d);
        Assert.assertEquals("500",s);
    }

}