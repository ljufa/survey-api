package com.draganlj.survey.authoring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "answers")
public class Answer {

    @Id
    private String id;

    private String answerText;

    private String surveyId;

    private Integer questionId;
}
