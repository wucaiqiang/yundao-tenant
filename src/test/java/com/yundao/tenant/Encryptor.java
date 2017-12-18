package com.yundao.tenant;

import org.jasypt.encryption.StringEncryptor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by gjl on 2017/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = Application.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration
public class Encryptor extends AbstractTest{
    @Autowired
    StringEncryptor encryptor;

    @org.junit.Test
    public void 加密(){

        System.out.println(encryptor.decrypt("h+3qBZKPsIb3bNGINDtMn8ObOzBRxezU"));
    }
}
