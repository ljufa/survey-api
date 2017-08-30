package com.draganlj.survey.authoring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class AnswerText {

    @NotEmpty
    private String answerText;

}
