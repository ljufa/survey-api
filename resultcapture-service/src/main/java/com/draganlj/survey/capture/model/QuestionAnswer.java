package com.draganlj.survey.capture.model;

import lombok.Data;

@Data
public class QuestionAnswer {

    private String surveyResultId;
    private Integer questionId;
    private String[] answerIds;

}
