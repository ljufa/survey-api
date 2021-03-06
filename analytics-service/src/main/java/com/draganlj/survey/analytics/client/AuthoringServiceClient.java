package com.draganlj.survey.analytics.client;

import com.draganlj.survey.analytics.api.dto.Question;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "authoring-service")
public interface AuthoringServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/authoring/questions/{surveyId}/{questionId}")
    Question getQuestionWithAnswers(@PathVariable("surveyId") String surveyId, @PathVariable("questionId") Integer questionId);

}
