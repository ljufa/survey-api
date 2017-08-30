package com.draganlj.survey.capture.api;

import com.draganlj.survey.capture.dto.AnswersDto;
import com.draganlj.survey.capture.model.QuestionAnswer;
import com.draganlj.survey.capture.service.SurveyCaptureService;
import com.draganlj.survey.capture.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/results/{surveyId}", headers = "Accept=application/vnd.survey-1.0+json")
@Api(description = "Provides operations to get response data")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ResultsController {

    @Autowired
    private SurveyCaptureService captureService;

    @Autowired
    private UserService userService;

    @GetMapping("/{questionId}")
    @ApiOperation(value = "Get all responses on single question.")
    public List<QuestionAnswer> getAnswersOnQuestion(@PathVariable String surveyId, @PathVariable Integer questionId) {
        return captureService.getAnswersOnQuestion(surveyId, questionId);

    }

}
