package com.draganlj.survey.analytics.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class QuestionStatistics {

    private Question question;
    private Long numberOfAnswers;
    private Map<String, Long> answerDistribution;
}
