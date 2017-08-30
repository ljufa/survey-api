package com.draganlj.survey.analytics.service;

import com.draganlj.survey.analytics.api.dto.QuestionStatistics;
import com.draganlj.survey.analytics.client.ResultCaptureServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InMemoryStatisticalService implements StatisticsService {

    @Autowired
    private ResultCaptureServiceClient captureServiceClient;

    @Override
    public QuestionStatistics getQuestionStatistics(String surveyId, Integer questionId) {
        captureServiceClient.getAnswersOnQuestion(surveyId, questionId);
        return null;
    }
}
