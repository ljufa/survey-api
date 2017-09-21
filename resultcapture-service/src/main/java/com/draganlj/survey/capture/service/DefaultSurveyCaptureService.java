package com.draganlj.survey.capture.service;

import com.draganlj.survey.capture.dto.QuestionAnswerDto;
import com.draganlj.survey.capture.model.QuestionAnswer;
import com.draganlj.survey.capture.model.SurveyResult;
import com.draganlj.survey.capture.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DefaultSurveyCaptureService implements SurveyCaptureService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SurveyResultRepository resultRepository;

    @Autowired
    private QuestionAnswerRepository answerRepository;

    private final Type questionAnsweristType = new TypeToken<List<QuestionAnswerDto>>() {
    }.getType();
    private final Type questionAnsweristModelType = new TypeToken<List<QuestionAnswer>>() {
    }.getType();

    @Override
    public void submitWholeSurvey(User user, @NotEmpty List<QuestionAnswerDto> surveyAnswers, @NotEmpty String surveyId) {
        //todo - validation missing
        SurveyResult newResult = SurveyResult.builder()
                .surveyId(surveyId)
                // todo: make sure you are able to calculate user time!
                .submitDate(LocalDateTime.now())
                .user(user).build();
        SurveyResult insert = resultRepository.insert(newResult);
        List<QuestionAnswer> answers = modelMapper.map(surveyAnswers, questionAnsweristModelType);
        answers.forEach(p -> {
            p.setSurveyResultId(insert.getId());
            p.setSurveyId(surveyId);
        });
        answerRepository.insert(answers);
    }

    @Override
    public List<QuestionAnswer> getAnswersOnQuestion(@NotEmpty String surveyId, @NotNull Integer questionId) {
        log.debug("Invoke getAnswersOnQuestion statistic surveyid={}, questionid={}", surveyId, questionId);
        return answerRepository.findBySurveyIdAndQuestionId(surveyId, questionId);
    }
}
