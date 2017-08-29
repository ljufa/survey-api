package com.draganlj.survey.authoring.service;

import com.draganlj.survey.authoring.dto.*;

import java.util.List;

public interface SurveyAuthoringService {

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
