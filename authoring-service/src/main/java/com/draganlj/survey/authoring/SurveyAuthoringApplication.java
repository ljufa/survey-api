package com.draganlj.survey.authoring;

import com.google.common.base.Predicates;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class SurveyAuthoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyAuthoringApplication.class, args);
    }

    @Value("${api.version}")
    private String apiVersion;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Docket api() {
        //noinspection Guava
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.draganlj.survey.authoring"))
                .build().apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Survey authoring API")
                .description("Operations on this API allows you to create syrvey with answers and questions.")
                .contact(new Contact("Dragan Ljubojevic", "", "dragan.ljubojevic@gmail.com"))
                .version(apiVersion)
                .build();
    }

}
