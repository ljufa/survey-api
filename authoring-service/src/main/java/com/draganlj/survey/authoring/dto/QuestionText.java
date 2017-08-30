package com.draganlj.survey.authoring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class QuestionText {

    @NotEmpty
    private String questionText;

}
