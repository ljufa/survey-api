package com.draganlj.survey.authoring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "answers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    private String id;

    private String answerText;

    private String surveyId;

    private Integer questionId;
}
