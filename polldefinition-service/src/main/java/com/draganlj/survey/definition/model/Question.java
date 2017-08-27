package com.draganlj.survey.definition.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Question {

    private Integer id;

    private String questionText;

}
