package cn.ecnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description knife4j接口文档配置</p>
 */

@Configuration
@EnableOpenApi
public class knife4jConfig {

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("大夏学堂在线学习平台-内容管理系统")
                        .description("对课程等相关信息进行管理")
                        .version("1.0")
                        .contact(new Contact("zachary","http://localhost:63040/content/doc.html","abai.ai@outlook.com"))
                        .build())
                // 分组名称
                .groupName("content")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("cn.ecnu.content"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

}
