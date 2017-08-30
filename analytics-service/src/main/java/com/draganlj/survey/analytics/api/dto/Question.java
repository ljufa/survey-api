package com.draganlj.survey.analytics.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class Question {

    private String questionText;

    private List<Answer> answers;

}
