package com.draganlj.survey.definition.web;

import com.draganlj.survey.definition.dto.QuestionAll;
import com.draganlj.survey.definition.dto.QuestionIdAndText;
import com.draganlj.survey.definition.dto.QuestionText;
import com.draganlj.survey.definition.service.SurveyDefinitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/questions/{surveyId}")
@Api(description = "Basic operations on questions")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class QuestionController {

    @Autowired
    private SurveyDefinitionService service;

    @PostMapping("/")
    @ApiOperation(value = "Add question to survery")
    public ResponseEntity addQuestion(@PathVariable String surveyId, @ApiParam("") @Valid @RequestBody QuestionText question) {
        service.addQuestion(surveyId, question);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{questionId}")
    @ApiOperation("Update existing question in survey")
    public ResponseEntity updateQuestion(@PathVariable String surveyId, @PathVariable Integer questionId, @Valid @RequestBody QuestionIdAndText question) {
        service.updateQuestion(surveyId, questionId, question);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{questionId}")
    @ApiOperation("Remove question from survey")
    public ResponseEntity deleteQuestion(@PathVariable String surveyId, @PathVariable Integer questionId) {
        service.deleteQuestion(surveyId, questionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    @ApiOperation("Return single question with answers")
    public QuestionAll getQuestionWithAnswers(@PathVariable String surveyId, @PathVariable Integer questionId) {
        return service.getQuestion(surveyId, questionId, true);
    }

    @GetMapping("/")
    @ApiOperation("Return all questions from survey with no answers")
    public List<QuestionIdAndText> getAllQuestions(@PathVariable String surveyId) {
        return service.getAllQuestions(surveyId);
    }

}
