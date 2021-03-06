package com.draganlj.survey.authoring.service;

import com.draganlj.survey.authoring.ValidationException;
import com.draganlj.survey.authoring.dto.*;
import com.draganlj.survey.authoring.model.Answer;
import com.draganlj.survey.authoring.model.Question;
import com.draganlj.survey.authoring.model.Survey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DefaultSurveyAuthoringService implements SurveyAuthoringService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Type questionDtoListType = new TypeToken<List<QuestionIdAndText>>() {
    }.getType();

    private final Type answersDtoListType = new TypeToken<List<AnswerIdAndText>>() {
    }.getType();


    @Override
    public Question addQuestion(@NotEmpty String surveyId, @Valid QuestionText question) {
        Survey survey = surveyRepository.findOne(surveyId);
        validate(survey);
        List<Question> questions = survey.getQuestions();
        Question newQuestion = modelMapper.map(question, Question.class);
        newQuestion.setId(questions.size());
        questions.add(newQuestion);
        surveyRepository.save(survey);
        return newQuestion;
    }

    @Override
    public void updateQuestion(@NotEmpty String surveyId, @NotNull Integer questionId, @Valid QuestionText question) {
        Survey survey = surveyRepository.findOne(surveyId);
        validate(survey, questionId);
        survey.getQuestions().set(questionId, modelMapper.map(question, Question.class));
        surveyRepository.save(survey);
    }

    @Override
    public void deleteQuestion(@NotEmpty String surveyId, @NotNull Integer questionId) {
        throw new RuntimeException("not implemented");
        //        Survey survey = surveyRepository.findOne(surveyId);
//        validate(survey, questionId);
//        survey.getQuestions().remove(questionId.intValue());
//        surveyRepository.save(survey);
    }

    @Override
    public QuestionAll getQuestion(@NotEmpty String surveyId, @NotNull Integer questionId, boolean fetchAnswers) {
        log.debug("Invoke get question surveyid={}, questionid={}", surveyId, questionId);
        Survey survey = surveyRepository.findOne(surveyId);
        validate(survey, questionId);
        List<Question> questions = survey.getQuestions();
        Question question = questions.get(questionId);
        QuestionAll questionDto = modelMapper.map(question, QuestionAll.class);
        if (fetchAnswers) {
            List<Answer> answers = answerRepository.findBySurveyIdAndQuestionId(surveyId, questionId);
            if (answers != null && !answers.isEmpty()) {
                questionDto.setAnswers(modelMapper.map(answers, answersDtoListType));
            }
        }
        return questionDto;
    }

    @Override
    public List<QuestionIdAndText> getAllQuestions(@NotEmpty String surveyId) {
        Survey survey = surveyRepository.findOne(surveyId);
        validate(survey);
        List<Question> questions = survey.getQuestions();
        if (questions != null) {
            return modelMapper.map(questions, questionDtoListType);
        }
        return null;
    }

    @Override
    public List<AnswerIdAndText> getAllAnswers(@NotEmpty String surveyId, @NotNull Integer questionId) {
        Survey survey = surveyRepository.findOne(surveyId);
        validate(survey, questionId);
        List<Answer> answers = answerRepository.findBySurveyIdAndQuestionId(surveyId, questionId);
        if (answers != null) {
            return modelMapper.map(answers, answersDtoListType);
        }
        return null;
    }

    @Override
    public void deleteAnswer(@NotEmpty String answerId) {
        answerRepository.delete(answerId);
    }

    @Override
    public void updateAnswer(@NotEmpty String answerId, @Valid AnswerText answer) {
        Answer existingOne = answerRepository.findOne(answerId);
        if (existingOne != null) {
            existingOne.setAnswerText(answer.getAnswerText());
            answerRepository.save(existingOne);
        }
    }

    @Override
    public Answer addAnswer(@NotEmpty String surveyId, @NotNull Integer questionId, @Valid AnswerText answer) {
        Survey survey = surveyRepository.findOne(surveyId);
        validate(survey, questionId);
        Answer newAnswer = modelMapper.map(answer, Answer.class);
        newAnswer.setSurveyId(surveyId);
        newAnswer.setQuestionId(questionId);
        return answerRepository.insert(newAnswer);
    }

    // todo: implement better and more flexible/reusable validation by using spring custom validators
    private static void validate(Survey survey) {
        if (survey == null) {
            throw new ValidationException(String.format("Survey [%s] could not be found", survey));
        }
        if (survey.getPublished()) {
            throw new ValidationException(String.format("Survey [%s] is already published", survey));
        }
    }

    private static void validate(Survey survey, Integer questionId) {
        validate(survey);
        List<Question> questions = survey.getQuestions();
        if (questions == null) {
            throw new ValidationException(String.format("Survey [%s] has no questions", survey));
        }
        if (questions.size() < questionId) {
            throw new ValidationException(String.format("Survey [%s] has no question with id {%s}", survey, questionId));
        }
    }


}
