package com.draganlj.survey.analytics.client;

import com.draganlj.survey.analytics.api.dto.QuestionAnswer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "resultcapture-service")
public interface ResultCaptureServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/capture/results/{surveyId}/{questionId}")
    List<QuestionAnswer> getAnswersOnQuestion(@PathVariable("surveyId") String surveyId, @PathVariable("questionId") Integer questionId);

}
