package com.draganlj.survey.authoring.api;

import com.draganlj.survey.authoring.dto.QuestionAll;
import com.draganlj.survey.authoring.dto.QuestionIdAndText;
import com.draganlj.survey.authoring.dto.QuestionText;
import com.draganlj.survey.authoring.model.Question;
import com.draganlj.survey.authoring.service.SurveyAuthoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/questions/{surveyId}", headers = {"Accept=application/vnd.survey-1.0+json"})
@Api(description = "Basic operations on questions")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class QuestionController {

    @Autowired
    private SurveyAuthoringService service;

    @PostMapping("/")
    @ApiOperation(value = "Add question to survey", code = HttpServletResponse.SC_CREATED)
    public ResponseEntity addQuestion(@PathVariable String surveyId, @Valid @RequestBody QuestionText question) {
        Question saved = service.addQuestion(surveyId, question);
        URI location = getUri(String.valueOf(saved.getId()));
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{questionId}")
    @ApiOperation(value = "Update existing question in survey", code = HttpServletResponse.SC_NO_CONTENT)
    public ResponseEntity updateQuestion(@PathVariable String surveyId, @PathVariable Integer questionId, @Valid @RequestBody QuestionIdAndText question) {
        service.updateQuestion(surveyId, questionId, question);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{questionId}")
    @ApiOperation("TODO: Remove question from survey")
    public ResponseEntity deleteQuestion(@PathVariable String surveyId, @PathVariable Integer questionId) {
        service.deleteQuestion(surveyId, questionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    @ApiOperation("Return single question with answers")
    public QuestionAll getQuestionWithAnswers(@PathVariable String surveyId, @PathVariable Integer questionId) {
        return service.getQuestion(surveyId, questionId, true);
    }

    @GetMapping(value="/" )
    @ApiOperation("Return all questions from survey with no answers")
    public List<QuestionIdAndText> getAllQuestions(@PathVariable String surveyId) {
        return service.getAllQuestions(surveyId);
    }

    private URI getUri(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
