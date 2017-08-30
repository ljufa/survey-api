package com.draganlj.survey.capture.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class QuestionAnswer {

    private String surveyResultId;
    private String questionId;
    private Integer[] answerIds;

}
