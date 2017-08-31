package com.draganlj.survey.authoring.api;

import com.draganlj.survey.authoring.ValidationException;
import com.draganlj.survey.authoring.model.Question;
import com.draganlj.survey.authoring.service.SurveyAuthoringService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SurveyAuthoringService service;


    @Before
    public void setup() throws Exception {
        Mockito.when(service.addQuestion(Matchers.eq("1"), Matchers.any())).thenReturn(Question.builder().id(2).build());


    }


    @Test
    public void return_201_AddQuestion() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/questions/1/")
                .content("{ \"questionText\": \"Fourth question\"}")
                .contentType("application/vnd.survey-1.0+json")
                .header("Accept", "application/vnd.survey-1.0+json"));
        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(header().string("location", "http://localhost/questions/1/2"));
    }

    @Test
    public void return_400_On_ValidationException_AddQuestion() throws Exception {
        Mockito.doThrow(ValidationException.class).when(service).addQuestion(Matchers.anyString(), Matchers.any());
        ResultActions resultActions = mockMvc.perform(post("/questions/3/")
                .content("{ \"questionText\": \"Fourth question\"}")
                .contentType("application/vnd.survey-1.0+json")
                .header("Accept", "application/vnd.survey-1.0+json"));
        resultActions.andExpect(status().isBadRequest());
    }

    @Test
    public void return_406_On_WrongVersionHeade_AddQuestion() throws Exception {
        ResultActions resultActions = mockMvc.perform(post("/questions/3/")
                .content("{ \"questionText\": \"Fourth question\"}")
                .contentType("application/vnd.survey-1.0+json")
                .header("Accept", "application/vnd.survey-1111.0+json"));
        resultActions.andExpect(status().isNotAcceptable());
    }


    // TODO: more tests

}
