package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.dto.QuestionAnswerDto;
import com.draganlj.survey.capture.model.SurveyResult;
import com.draganlj.survey.capture.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DefaultSurveyCaptureService implements SurveyCaptureService {

    private ModelMapper modelMapper;
    private SurveyResultRepository resultRepository;

    private Type questionAnsweristType = new TypeToken<List<QuestionAnswerDto>>() {
    }.getType();

    @Override
    public String submitWholeSurvey(User user, List<QuestionAnswerDto> surveyAnswers, String surveyId) {

        SurveyResult newResult = SurveyResult.builder()
                                            .answers(modelMapper.map(surveyAnswers, questionAnsweristType))
                                            .surveyId(surveyId)
                                            .submitDate(LocalDateTime.now())
                                            .user(user).build();
        resultRepository.insert(newResult);
        return newResult.getId();
    }
}
