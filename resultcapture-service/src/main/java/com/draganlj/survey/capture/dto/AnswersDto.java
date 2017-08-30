package com.draganlj.survey.capture.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

@Data
public class AnswersDto {

    @NotEmpty
    @Valid
    private List<QuestionAnswerDto> answers;

}
