package com.draganlj.survey.authoring.service;

import com.draganlj.survey.authoring.model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {
    List<Answer> findBySurveyIdAndQuestionId(String surveyId, Integer questionId);
}


