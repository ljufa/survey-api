package com.draganlj.survey.definition.web;

import com.draganlj.survey.definition.model.Question;
import com.draganlj.survey.definition.service.SurveyDefinitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{surveyId}/questions")
@AllArgsConstructor
public class QuestionController {

    private SurveyDefinitionService service;

    @PostMapping("/")
    public ResponseEntity addQuestion(@PathVariable Integer surveyId, @Valid @RequestBody Question question) {
        service.addQuestion(surveyId, question);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{questionId}")
    public ResponseEntity updateQuestion(@PathVariable Integer questionId, @Valid @RequestBody Question question) {
        service.updateQuestion(questionId, question);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable Integer questionId) {
        service.deleteQuestion(questionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    public Question getQuestionWithAnswers(@PathVariable Integer questionId) {
        return service.getQuestion(questionId, true);
    }

    @GetMapping("/")
    public List<Question> getAllQuestions(@PathVariable Integer surveyId) {
        return service.getAllQuestions(surveyId, false);
    }

}
