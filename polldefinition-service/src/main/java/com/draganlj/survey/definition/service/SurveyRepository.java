package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.model.Question;
import com.draganlj.survey.definition.model.Survey;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<Survey, String> {
}
