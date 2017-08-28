package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.dto.*;

import java.util.List;

public interface SurveyDefinitionService {

    void addQuestion(String surveyId, QuestionText question);

    void updateQuestion(String surveyId, Integer questionId, QuestionIdAndText question);

    void deleteQuestion(String surveyId, Integer questionId);

    QuestionAll getQuestion(String surveyId, int questionId, boolean fetchAnswers);

    List<QuestionIdAndText> getAllQuestions(String surveyId);

    List<AnswerIdAndText> getAllAnswers(String surveyId, Integer questionId);

    void deleteAnswer(String answerId);

    void updateAnswer(String answerId, AnswerText answer);

    void addAnswer(String surveyId, Integer questionId, AnswerText answer);
}
