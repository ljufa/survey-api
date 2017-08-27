package com.draganlj.survey.definition.web;

import com.draganlj.survey.definition.dto.QuestionOut;
import com.draganlj.survey.definition.model.Question;
import com.draganlj.survey.definition.service.SurveyDefinitionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{surveyId}/questions")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class QuestionController {

    @Autowired
    private SurveyDefinitionService service;


    @PostMapping("/")
    public ResponseEntity addQuestion(@PathVariable String surveyId, @Valid @RequestBody Question question) {
        service.addQuestion(surveyId, question);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable String questionId, @Valid @RequestBody Question question) {
        service.updateQuestion(questionId, question);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable String questionId) {
        service.deleteQuestion(questionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    public QuestionOut getQuestionWithAnswers(@PathVariable String surveyId, @PathVariable Integer questionId) {
        return service.getQuestion(surveyId, questionId, true);
    }

    @GetMapping("/")
    public List<Question> getAllQuestions(@PathVariable String surveyId) {
        return service.getAllQuestions(surveyId, false);
    }

}
