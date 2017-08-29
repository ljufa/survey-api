package com.draganlj.survey.authoring.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(collection = "surveys")
public class Survey {

    @Id
    private String id;
    private String author;
    private Date createDate;
    private String surveyTitle;
    private Boolean started;
    private List<Question> questions = new ArrayList<>();
}
