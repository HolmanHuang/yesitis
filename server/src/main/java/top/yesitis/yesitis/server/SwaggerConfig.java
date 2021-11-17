package top.yesitis.yesitis.server;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createApiDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            // 自定义API 基本信息
            .apiInfo(this.defaultInfo())
            // 开启一个端点
            .select()
            // 开启API 生成路径
            .apis(RequestHandlerSelectors.basePackage("top.yesitis.yesitis.api.rest"))
            // 选择生成路径
            .paths(PathSelectors.any())
            .build();
        return docket;
    }
    public ApiInfo defaultInfo() {
        return new ApiInfoBuilder()
            .title("TEST")
            .description("TEST bye-crud-generate")
            .version("1.0")
            .build();
    }
}
