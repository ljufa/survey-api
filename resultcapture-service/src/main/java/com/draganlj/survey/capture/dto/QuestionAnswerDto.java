package com.draganlj.survey.capture.dto;

import lombok.Data;

@Data
public class QuestionAnswerDto {

    private String questionId;
    private Integer[] answerIds;

}
