package com.draganlj.survey.authoring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class QuestionIdAndText {

    @NotNull
    private Integer questionId;

    @NotEmpty
    private String questionText;


}
