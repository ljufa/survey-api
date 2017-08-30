package com.draganlj.survey.analytics.api.dto;

import lombok.Data;

import java.util.Map;

@Data
public class QuestionStatistics {

    private Question question;
    private Integer numberOfAnswers;
    private Map<String, Integer> answerDistribution;
}
