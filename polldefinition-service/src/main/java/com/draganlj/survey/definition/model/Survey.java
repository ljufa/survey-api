package com.draganlj.survey.definition.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class Survey {
    private Integer id;
    private String author;
    private Date createDate;
    private String surveyTitle;
    private List<Question> questions;
}
