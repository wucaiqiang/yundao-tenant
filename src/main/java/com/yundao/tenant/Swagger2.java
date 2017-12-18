package com.yundao.tenant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 云道
 * @version 1.0.0
 * @date 16/4/18 下午12:02.
 * @blog http://blog.didispace.com
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("headerTenantId")
                .description("请求头参数：租户id")
                .modelRef(new ModelRef("long"))
                .defaultValue("1")
                .parameterType("header")
                .required(true).build();
        pars.add(tokenPar.build());

        tokenPar.name("headerUserId")
                .description("请求头参数：用户id")
                .modelRef(new ModelRef("long"))
                .defaultValue("1")
                .parameterType("header")
                .required(true).build();
        pars.add(tokenPar.build());

        tokenPar.name("headerRealName")
                .description("请求头参数：用户姓名 ")
                .modelRef(new ModelRef("string"))
                .defaultValue("admin")
                .parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yundao.tenant.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("云道出品必是精品")
                .description("")
                .termsOfServiceUrl("http://www.yundao.com")
                .contact("云道")
                .version("1.0")
                .build();
    }

}
