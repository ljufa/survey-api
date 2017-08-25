package com.draganlj.survey.definition.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Question {
    private Integer id;
    private List<Answer> answers;
}
