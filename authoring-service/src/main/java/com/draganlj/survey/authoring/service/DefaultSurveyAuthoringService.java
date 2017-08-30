package com.draganlj.survey.authoring.service;

import com.draganlj.survey.authoring.dto.*;
import com.draganlj.survey.authoring.model.Answer;
import com.draganlj.survey.authoring.model.Question;
import com.draganlj.survey.authoring.model.Survey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
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
    public Question addQuestion(String surveyId, QuestionText question) {
        Survey survey = surveyRepository.findOne(surveyId);
        if (survey.getStarted()) {
            // todo: handle error
            return null;
        }
        // todo: do other validation

        List<Question> questions = survey.getQuestions();
        Question newQuestion = modelMapper.map(question, Question.class);
        newQuestion.setId(questions.size());
        questions.add(newQuestion);
        surveyRepository.save(survey);
        return newQuestion;
    }

    @Override
    public void updateQuestion(String surveyId, Integer questionId, QuestionIdAndText question) {
        Survey survey = surveyRepository.findOne(surveyId);
        survey.getQuestions().set(questionId, modelMapper.map(question, Question.class));
        surveyRepository.save(survey);

    }

    @Override
    public void deleteQuestion(String surveyId, Integer questionId) {
        // todo
    }

    @Override
    public QuestionAll getQuestion(String surveyId, int questionId, boolean fetchAnswers) {
        List<Question> questions = surveyRepository.findOne(surveyId).getQuestions();
        if (questions == null && questions.size() < questionId) {
            // todo : handle error
        }
        Question question = questions.get(questionId);
        QuestionAll questionDto = modelMapper.map(question, QuestionAll.class);
        if (fetchAnswers) {
            questionDto.setAnswers(modelMapper.map(answerRepository.findBySurveyIdAndQuestionId(surveyId, questionId), answersDtoListType));
        }
        return questionDto;
    }

    @Override
    public List<QuestionIdAndText> getAllQuestions(String surveyId) {
        List<Question> questions = surveyRepository.findOne(surveyId).getQuestions();
        return modelMapper.map(questions, questionDtoListType);
    }

    @Override
    public List<AnswerIdAndText> getAllAnswers(String surveyId, Integer questionId) {
        return modelMapper.map(answerRepository.findBySurveyIdAndQuestionId(surveyId, questionId), answersDtoListType);
    }

    @Override
    public void deleteAnswer(String answerId) {
        answerRepository.delete(answerId);
    }

    @Override
    public void updateAnswer(String answerId, AnswerText answer) {
        Answer existingOne = answerRepository.findOne(answerId);
        existingOne.setAnswerText(answer.getAnswerText());
        answerRepository.save(existingOne);
    }

    @Override
    public Answer addAnswer(String surveyId, Integer questionId, AnswerText answer) {
        if (surveyRepository.exists(surveyId)) {
            Answer newAnswer = modelMapper.map(answer, Answer.class);
            newAnswer.setSurveyId(surveyId);
            newAnswer.setQuestionId(questionId);
            return answerRepository.insert(newAnswer);
        } else {
            // todo: handle error condition
        }
        return null;
    }
}