package com.draganlj.survey.analytics.service;

import com.draganlj.survey.analytics.api.dto.QuestionStatistics;

public interface StatisticsService {

    QuestionStatistics getQuestionStatistics(String surveyId, Integer questionId);
}
