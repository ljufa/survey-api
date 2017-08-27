package com.draganlj.survey.definition.service;

import com.draganlj.survey.definition.SurveyDefinitionApplication;
import com.draganlj.survey.definition.model.Question;
import com.draganlj.survey.definition.model.Survey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SurveyDefinitionApplication.class})
public class SurveyRepositoryTest {

	@Autowired
	private SurveyRepository repository;

//	@Test
//	public void shouldSaveSurvey() {
//        List<QuestionOut> questions = new ArrayList<>();
//        questions.add(QuestionOut.builder().questionText("pm1").build());
//        questions.add(QuestionOut.builder().questionText("pm2").build());
//        Survey survey = Survey.builder().surveyTitle("It survey").author("Dragan Lj").questions(questions).build();
//        repository.save(survey);
//        System.out.println(survey);
//
//	}
}
