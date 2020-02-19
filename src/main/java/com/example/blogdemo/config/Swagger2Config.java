package com.example.blogdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket cerateRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.blogdemo.Controller"))//指定扫描controller的包
                .paths(PathSelectors.regex("/*"))//指定controller哪些请求的方法
                .build();
    }
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("使用swagger2创建API文档")
                .description("restful风格")
                .termsOfServiceUrl("http://www.caohao.com")
                .version("1.0")
                .build();
    }
}