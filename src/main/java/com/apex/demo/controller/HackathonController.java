package com.apex.demo.controller;

import com.apex.demo.model.EvaluationReport;
import com.apex.demo.model.HackathonSubmission;
import com.apex.demo.services.HackathonEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/hackathon")
public class HackathonController {

    @Autowired
    private HackathonEvaluationService hackathonEvaluationService;

    @PostMapping(value = "/evaluate")
    public @ResponseBody EvaluationReport evaluate(@RequestBody HackathonSubmission submission) {
        return hackathonEvaluationService.evaluate(submission);
    }
}
