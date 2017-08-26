package com.draganlj.survey.definition.web;

import com.draganlj.survey.definition.model.Answer;
import com.draganlj.survey.definition.service.SurveyDefinitionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{questionId}/answer")
@AllArgsConstructor
@NoArgsConstructor
public class AnswerController {

    @Autowired
    private SurveyDefinitionService service;

    @PostMapping("/")
    public ResponseEntity addAnswer(@PathVariable Integer questionId, @Valid @RequestBody Answer answer) {
        service.addAnswer(questionId, answer);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{answerId}")
    public ResponseEntity updateAnswer(@PathVariable Integer answerId, @Valid @RequestBody Answer answer) {
        service.updateAnswer(answerId, answer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity deleteAnswer(@PathVariable Integer answerId) {
        service.deleteAnswer(answerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public List<Answer> getAllAnswers(@PathVariable Integer questionId) {
        return service.getAllAnswers(questionId);
    }

}
