package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.dto.QuestionOut;
import com.draganlj.survey.definition.model.Answer;
import com.draganlj.survey.definition.model.Question;
import com.draganlj.survey.definition.model.Survey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DefaultSurveyDefnitionService implements SurveyDefinitionService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addQuestion(String surveyId, Question question) {
        Survey survey = surveyRepository.findOne(surveyId);
        List<Question> questions = survey.getQuestions();
        question.setId(questions.size());
        questions.add(question);
        surveyRepository.save(survey);
    }

    @Override
    public void updateQuestion(String questionId, Question question) {

    }

    @Override
    public void deleteQuestion(String questionId) {

    }

    @Override
    public QuestionOut getQuestion(String surveyId, int questionId, boolean fetchAnswers) {
        List<Question> questions = surveyRepository.findOne(surveyId).getQuestions();
        if(questions == null && questions.size()<questionId){
            // todo : handle error
        }
        Question question = questions.get(questionId);
        QuestionOut questionOut = modelMapper.map(question, QuestionOut.class);
        if(fetchAnswers){
           questionOut.setAnswers(answerRepository.findBySurveyIdAndQuestionId(surveyId, questionId));
        }
        return questionOut;
    }

    @Override
    public List<Question> getAllQuestions(String surveyId, boolean fetchAnswers) {
        return surveyRepository.findOne(surveyId).getQuestions();
    }

    @Override
    public List<Answer> getAllAnswers(String questionId) {
        return null;
    }

    @Override
    public void deleteAnswer(String answerId) {

    }

    @Override
    public void updateAnswer(String answerId, Answer answer) {

    }

    @Override
    public void addAnswer(String surveyId, Integer questionId, Answer answer) {
        if (surveyRepository.exists(surveyId)) {
            answer.setSurveyId(surveyId);
            answer.setQuestionId(questionId);
            answerRepository.insert(answer);
        } else {
            // todo: throw exception
        }
    }
}
