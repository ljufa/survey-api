package com.draganlj.survey.authoring.api;

import com.draganlj.survey.authoring.dto.AnswerIdAndText;
import com.draganlj.survey.authoring.dto.AnswerText;
import com.draganlj.survey.authoring.model.Answer;
import com.draganlj.survey.authoring.service.SurveyAuthoringService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/answers", headers = "Accept=application/vnd.survey-1.0+json")
@AllArgsConstructor
@NoArgsConstructor
public class AnswerController {

    @Autowired
    private SurveyAuthoringService service;

    @PostMapping("/{surveyId}/{questionId}")
    @ApiOperation(value = "Add new answer to the question", code = HttpServletResponse.SC_CREATED)
    public ResponseEntity<?> addAnswer(@PathVariable String surveyId, @PathVariable Integer questionId, @Valid @RequestBody AnswerText answer) {
        Answer saved = service.addAnswer(surveyId, questionId, answer);
        return ResponseEntity.created(getUri(saved.getId())).build();
    }

    @PutMapping("/{answerId}")
    @ApiOperation(value = "Update existing answer", code = HttpServletResponse.SC_NO_CONTENT)
    public ResponseEntity<?> updateAnswer(@PathVariable String answerId, @Valid @RequestBody AnswerText answer) {
        service.updateAnswer(answerId, answer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{answerId}")
    @ApiOperation("Delete answer")
    public ResponseEntity<?> deleteAnswer(@PathVariable String answerId) {
        service.deleteAnswer(answerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{surveyId}/{questionId}")
    @ApiOperation("Get all answers for question")
    public List<AnswerIdAndText> getAllAnswers(@PathVariable String surveyId, @PathVariable Integer questionId) {
        return service.getAllAnswers(surveyId, questionId);
    }

    private static URI getUri(String id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
