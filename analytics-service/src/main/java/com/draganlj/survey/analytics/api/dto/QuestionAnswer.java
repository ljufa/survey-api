package com.draganlj.survey.analytics.api.dto;

import lombok.Data;

@Data
public class QuestionAnswer {

    private String surveyResultId;
    private String surveyId;
    private Integer questionId;
    private String[] answerIds;

}
