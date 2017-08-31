package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.model.QuestionAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswer, String> {

    List<QuestionAnswer> findBySurveyIdAndQuestionId(String surveyId, Integer questionId);

}


