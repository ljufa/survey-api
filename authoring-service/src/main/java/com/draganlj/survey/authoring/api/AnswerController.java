package com.draganlj.survey.authoring.api;

import com.draganlj.survey.authoring.dto.AnswerIdAndText;
import com.draganlj.survey.authoring.dto.AnswerText;
import com.draganlj.survey.authoring.service.SurveyAuthoringService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/answers", headers = {"Accept=application/vnd.survey-1.0+json"})
@AllArgsConstructor
@NoArgsConstructor
public class AnswerController {

    @Autowired
    private SurveyAuthoringService service;

    @PostMapping("/{surveyId}/{questionId}")
    @ApiOperation("Add new answer to the question")
    public ResponseEntity addAnswer(@PathVariable String surveyId, @PathVariable Integer questionId, @Valid @RequestBody AnswerText answer) {
        service.addAnswer(surveyId, questionId, answer);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{answerId}")
    @ApiOperation("TODO: Update existing answer")
    public ResponseEntity updateAnswer(@PathVariable String answerId, @Valid @RequestBody AnswerText answer) {
        service.updateAnswer(answerId, answer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{answerId}")
    @ApiOperation("TODO: Delete answer")
    public ResponseEntity deleteAnswer(@PathVariable String answerId) {
        service.deleteAnswer(answerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{surveyId}/{questionId}")
    @ApiOperation("Get all answers for question")
    public List<AnswerIdAndText> getAllAnswers(@PathVariable String surveyId, @PathVariable Integer questionId) {
        return service.getAllAnswers(surveyId, questionId);
    }

}
