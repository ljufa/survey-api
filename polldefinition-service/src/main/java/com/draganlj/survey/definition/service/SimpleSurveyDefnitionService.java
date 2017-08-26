package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.model.Answer;
import com.draganlj.survey.definition.model.Question;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SimpleSurveyDefnitionService implements SurveyDefinitionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void addQuestion(Integer surveyId, Question question) {

    }

    @Override
    public void updateQuestion(Integer questionId, Question question) {

    }

    @Override
    public void deleteQuestion(Integer questionId) {

    }

    @Override
    public Question getQuestion(Integer questionId, boolean fetchAnswers) {
        return questionRepository.findOne(questionId);
    }

    @Override
    public List<Question> getAllQuestions(Integer surveyId, boolean fetchAnswers) {
        return null;
    }

    @Override
    public List<Answer> getAllAnswers(Integer questionId) {
        return null;
    }

    @Override
    public void deleteAnswer(Integer answerId) {

    }

    @Override
    public void updateAnswer(Integer answerId, Answer answer) {

    }

    @Override
    public void addAnswer(Integer questionId, Answer answer) {

    }
}
