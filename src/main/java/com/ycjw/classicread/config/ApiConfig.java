package com.ycjw.classicread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApiConfig {//配置swaggerUi
    @Bean
    public Docket builldDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ycjw.classicread.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("经典名著阅读")
                .contact(new Contact("ycjw","","1712767833@qq.com"))
                .version("1.0.0")
                .build();
    }
}
