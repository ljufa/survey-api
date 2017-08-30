package com.draganlj.survey.authoring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class AnswerIdAndText {
    @NotEmpty
    private String answerId;

    @NotEmpty
    private String answerText;

}
