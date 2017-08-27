package com.draganlj.survey.definition;

import com.draganlj.survey.definition.model.Question;
import com.draganlj.survey.definition.model.Survey;
import com.draganlj.survey.definition.service.SurveyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SurveyDefinitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyDefinitionApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
