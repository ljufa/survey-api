package com.draganlj.survey.capture.api;

import com.draganlj.survey.capture.dto.QuestionAnswerDto;
import com.draganlj.survey.capture.service.SurveyCaptureService;
import com.draganlj.survey.capture.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/capture/{surveyId}", headers = {"Accept=application/vnd.survey-1.0+json"})
@Api(description = "Operations needed to capture submission of survey")
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SubmitController {

    private SurveyCaptureService captureService;
    private UserService userService;

    @PostMapping("/")
    @ApiOperation(value = "Submit survey with all answers.")
    public String submitSurvey(@PathVariable String surveyId, @RequestBody List<QuestionAnswerDto> surveyAnswers, HttpServletRequest request) {
        return captureService.submitWholeSurvey(userService.resolveUser(request), surveyAnswers, surveyId);
    }

    @PostMapping("/{questionId}")
    @ApiOperation(value = "TODO: Submit answer to single question.")
    public String submitAnswerToQuestion(@PathVariable String surveyId, @PathVariable Integer questionId, @RequestParam String[] answerIds) {
        return "return ticket from service";
    }
}
