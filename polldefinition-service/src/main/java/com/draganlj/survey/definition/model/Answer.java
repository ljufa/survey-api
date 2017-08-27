package com.draganlj.survey.definition.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "answers")
@JsonIgnoreProperties({"surveyId", "questionId"})
public class Answer {

    @Id
    private String id;

    private String answerText;

    private String hint;

    private String surveyId;

    private Integer questionId;
}
