package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.dto.QuestionAnswerDto;
import com.draganlj.survey.capture.model.User;

import java.util.List;

public interface SurveyCaptureService {

    void submitWholeSurvey(User user, List<QuestionAnswerDto> surveyAnswers, String surveyId);

}
