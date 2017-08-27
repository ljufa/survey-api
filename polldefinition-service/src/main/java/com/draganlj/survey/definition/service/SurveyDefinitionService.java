package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.dto.QuestionOut;
import com.draganlj.survey.definition.model.Answer;
import com.draganlj.survey.definition.model.Question;

import java.util.List;

public interface SurveyDefinitionService {

    void addQuestion(String surveyId, Question question);

    void updateQuestion(String questionId, Question question);

    void deleteQuestion(String questionId);


    QuestionOut getQuestion(String surveyId, int questionOrder, boolean fetchAnswers);

    List<Question> getAllQuestions(String surveyId, boolean fetchAnswers);

    List<Answer> getAllAnswers(String questionId);

    void deleteAnswer(String answerId);

    void updateAnswer(String answerId, Answer answer);

    void addAnswer(String surveyId, Integer questionId, Answer answer);
}
