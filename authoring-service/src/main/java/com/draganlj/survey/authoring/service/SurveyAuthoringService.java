package com.draganlj.survey.authoring.service;

import com.draganlj.survey.authoring.dto.*;
import com.draganlj.survey.authoring.model.Answer;
import com.draganlj.survey.authoring.model.Question;

import java.util.List;

public interface SurveyAuthoringService {

    Question addQuestion(String surveyId, QuestionText question);

    void updateQuestion(String surveyId, Integer questionId, QuestionText question);

    void deleteQuestion(String surveyId, Integer questionId);

    QuestionAll getQuestion(String surveyId, Integer questionId, boolean fetchAnswers);

    List<QuestionIdAndText> getAllQuestions(String surveyId);

    List<AnswerIdAndText> getAllAnswers(String surveyId, Integer questionId);

    void deleteAnswer(String answerId);

    void updateAnswer(String answerId, AnswerText answer);

    Answer addAnswer(String surveyId, Integer questionId, AnswerText answer);
}
