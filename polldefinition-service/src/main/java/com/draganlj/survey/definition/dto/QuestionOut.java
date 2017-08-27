package com.draganlj.survey.definition.dto;

import com.draganlj.survey.definition.model.Answer;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class QuestionOut {

    private Integer id;

    private String questionText;

    private List<Answer> answers;

}
