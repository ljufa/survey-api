package com.draganlj.survey.definition.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "answers")
public class Answer {
    private Integer id;
    private String answerText;
    private String hint;
}
