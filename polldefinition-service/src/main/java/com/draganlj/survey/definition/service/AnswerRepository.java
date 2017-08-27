package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {
    List<Answer> findBySurveyIdAndQuestionId(String surveyId, Integer questionId);
}


