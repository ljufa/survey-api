package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.dto.QuestionAnswerDto;
import com.draganlj.survey.capture.model.QuestionAnswer;
import com.draganlj.survey.capture.model.SurveyResult;
import com.draganlj.survey.capture.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DefaultSurveyCaptureService implements SurveyCaptureService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SurveyResultRepository resultRepository;

    private final Type questionAnsweristType = new TypeToken<List<QuestionAnswerDto>>() {
    }.getType();

    @Override
    public void submitWholeSurvey(User user, List<QuestionAnswerDto> surveyAnswers, String surveyId) {
        SurveyResult newResult = SurveyResult.builder()
                .answers(modelMapper.map(surveyAnswers, questionAnsweristType))
                .surveyId(surveyId)
                // todo: make sure you are able to calculate user time!
                .submitDate(LocalDateTime.now())
                .user(user).build();
        resultRepository.insert(newResult);
    }

    @Override
    public List<QuestionAnswer> getAnswersOnQuestion(String surveyId, Integer questionId) {
        // fixme: change mongo document structure to be able to easy query answers
        List<QuestionAnswer> answersBySurveyId = resultRepository.findAnswersBySurveyId(surveyId);
        return answersBySurveyId.stream().filter(e -> questionId.equals(e.getQuestionId())).collect(Collectors.toList());
    }
}
