package com.draganlj.survey.analytics.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class Answer {

    @NotEmpty
    private String answerText;

}
