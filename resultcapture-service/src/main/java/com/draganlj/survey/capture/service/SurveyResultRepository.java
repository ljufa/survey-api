package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.model.QuestionAnswer;
import com.draganlj.survey.capture.model.SurveyResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyResultRepository extends MongoRepository<SurveyResult, String> {

    List<QuestionAnswer> findAnswersBySurveyId(String surveyId);

}


