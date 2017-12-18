/**
 *
 */
package com.yundao.tenant.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis基础文件生成启动入口
 *
 * @author JonChiang
 * @date 2016年5月25日下午6:05:36
 */

public class MybatisBuilder {
    public static void main(String[] args) {
        try {
            System.setProperty("generated.source.dir", "");
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("build/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            for (String warning : warnings) {
                System.out.println(warning);
            }
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

