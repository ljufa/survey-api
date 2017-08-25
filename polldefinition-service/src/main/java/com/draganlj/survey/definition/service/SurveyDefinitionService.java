package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.model.Answer;
import com.draganlj.survey.definition.model.Question;

import java.util.List;

public interface SurveyDefinitionService {

    void addQuestion(Integer surveyId, Question question);

    void updateQuestion(Integer questionId, Question question);

    void deleteQuestion(Integer questionId);

    Question getQuestion(Integer questionId, boolean fetchAnswers);

    List<Question> getAllQuestions(Integer surveyId, boolean fetchAnswers);

    List<Answer> getAllAnswers(Integer questionId);

    void deleteAnswer(Integer answerId);

    void updateAnswer(Integer answerId, Answer answer);

    void addAnswer(Integer questionId, Answer answer);
}
