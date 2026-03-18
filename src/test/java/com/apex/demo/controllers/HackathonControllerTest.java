package com.apex.demo.controllers;

import com.apex.demo.model.EvaluationReport;
import com.apex.demo.model.HackathonSubmission;
import com.apex.demo.services.HackathonEvaluationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"file:src/test/resources/token.sql"})
@Transactional
public class HackathonControllerTest {

    private static final String TOKEN = "2176d2c3-89c8-4c3e-acab-253f9b32FFFF";

    @MockBean
    private HackathonEvaluationService hackathonEvaluationService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private HackathonSubmission buildSubmission() {
        return new HackathonSubmission(
                "F1 Analytics Dashboard",
                "A real-time Formula 1 analytics dashboard with ML predictions.",
                "Spring Boot, React, PostgreSQL",
                "https://github.com/user/f1-dashboard",
                "https://docs.f1dashboard.io",
                "https://demo.f1dashboard.io",
                "Real-time ML predictions, custom telemetry visualizations"
        );
    }

    private EvaluationReport buildReport() {
        EvaluationReport report = new EvaluationReport();
        report.setProjectName("F1 Analytics Dashboard");
        report.setInnovationScore(9);
        report.setInnovationFeedback("Excellent innovation!");
        report.setExecutionScore(9);
        report.setExecutionFeedback("Outstanding execution!");
        report.setDesignScore(9);
        report.setDesignFeedback("Excellent design!");
        report.setPresentationScore(9);
        report.setPresentationFeedback("Impressive presentation!");
        report.setOverallScore(9.0);
        report.setOverallAssessment("Outstanding submission!");
        report.setRecommendations(Arrays.asList("Great work! Continue refining the project."));
        report.setEvaluationDate(new Date());
        return report;
    }

    @Test
    public void evaluateReturnsOkWithReport() throws Exception {
        when(hackathonEvaluationService.evaluate(any())).thenReturn(buildReport());
        mvc.perform(post("/api/v1/hackathon/evaluate")
                        .header("Authorization", TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildSubmission())))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.projectName").value("F1 Analytics Dashboard"));
    }

    @Test
    public void evaluateReturnsAllScoreFields() throws Exception {
        when(hackathonEvaluationService.evaluate(any())).thenReturn(buildReport());
        mvc.perform(post("/api/v1/hackathon/evaluate")
                        .header("Authorization", TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildSubmission())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.innovationScore").value(9))
                .andExpect(jsonPath("$.executionScore").value(9))
                .andExpect(jsonPath("$.designScore").value(9))
                .andExpect(jsonPath("$.presentationScore").value(9));
    }

    @Test
    public void evaluateReturnsOverallAssessment() throws Exception {
        when(hackathonEvaluationService.evaluate(any())).thenReturn(buildReport());
        mvc.perform(post("/api/v1/hackathon/evaluate")
                        .header("Authorization", TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildSubmission())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.overallScore").value(9.0))
                .andExpect(jsonPath("$.overallAssessment").value("Outstanding submission!"));
    }

    @Test
    public void evaluateReturnsFeedbackFields() throws Exception {
        when(hackathonEvaluationService.evaluate(any())).thenReturn(buildReport());
        mvc.perform(post("/api/v1/hackathon/evaluate")
                        .header("Authorization", TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildSubmission())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.innovationFeedback").exists())
                .andExpect(jsonPath("$.executionFeedback").exists())
                .andExpect(jsonPath("$.designFeedback").exists())
                .andExpect(jsonPath("$.presentationFeedback").exists());
    }

    @Test
    public void evaluateReturnsRecommendations() throws Exception {
        when(hackathonEvaluationService.evaluate(any())).thenReturn(buildReport());
        mvc.perform(post("/api/v1/hackathon/evaluate")
                        .header("Authorization", TOKEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildSubmission())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recommendations").isArray());
    }

    @Test
    public void evaluateRequiresAuthentication() throws Exception {
        mvc.perform(post("/api/v1/hackathon/evaluate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildSubmission())))
                .andExpect(status().isUnauthorized());
    }
}
