package com.draganlj.survey.authoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionIdAndText {

    @NotNull
    private Integer questionId;

    @NotEmpty
    private String questionText;


}
