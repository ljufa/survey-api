package com.draganlj.survey.authoring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(collection = "surveys")
@NoArgsConstructor
@AllArgsConstructor
public class Survey {

    @Id
    private String id;
    private String author;
    private Date createDate;
    private String surveyTitle;
    private Boolean published;
    private List<Question> questions = new ArrayList<>();
}
