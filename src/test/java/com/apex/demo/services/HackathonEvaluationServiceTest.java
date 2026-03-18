package com.apex.demo.services;

import com.apex.demo.model.EvaluationReport;
import com.apex.demo.model.HackathonSubmission;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
public class HackathonEvaluationServiceTest {

    @InjectMocks
    private HackathonEvaluationService hackathonEvaluationService;

    private HackathonSubmission buildFullSubmission() {
        return new HackathonSubmission(
                "F1 Analytics Dashboard",
                "A real-time Formula 1 analytics dashboard that visualizes race data, driver performance metrics, and lap times using machine learning models to predict race outcomes based on historical patterns.",
                "Spring Boot, React, PostgreSQL, TensorFlow",
                "https://github.com/user/f1-dashboard",
                "https://docs.f1dashboard.io",
                "https://demo.f1dashboard.io",
                "Real-time ML race outcome predictions, custom telemetry visualizations, driver comparison tools"
        );
    }

    private HackathonSubmission buildMinimalSubmission() {
        return new HackathonSubmission(
                "My Project",
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    @Test
    public void evaluateFullSubmissionReturnsReport() {
        HackathonSubmission submission = buildFullSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        assertNotNull(report);
        assertEquals("F1 Analytics Dashboard", report.getProjectName());
        assertNotNull(report.getEvaluationDate());
    }

    @Test
    public void evaluateFullSubmissionHasHighScores() {
        HackathonSubmission submission = buildFullSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        assertTrue(report.getInnovationScore() >= 8);
        assertTrue(report.getExecutionScore() >= 8);
        assertTrue(report.getDesignScore() >= 8);
        assertTrue(report.getPresentationScore() >= 8);
    }

    @Test
    public void evaluateFullSubmissionOverallScoreIsAverage() {
        HackathonSubmission submission = buildFullSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        double expectedAverage = (report.getInnovationScore() + report.getExecutionScore()
                + report.getDesignScore() + report.getPresentationScore()) / 4.0;
        assertEquals(expectedAverage, report.getOverallScore(), 0.001);
    }

    @Test
    public void evaluateMinimalSubmissionHasLowScores() {
        HackathonSubmission submission = buildMinimalSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        assertTrue(report.getInnovationScore() <= 2);
        assertTrue(report.getExecutionScore() <= 2);
        assertTrue(report.getDesignScore() <= 2);
    }

    @Test
    public void evaluateMinimalSubmissionHasRecommendations() {
        HackathonSubmission submission = buildMinimalSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        List<String> recommendations = report.getRecommendations();
        assertNotNull(recommendations);
        assertFalse(recommendations.isEmpty());
    }

    @Test
    public void evaluateFullSubmissionHasNoActionableRecommendations() {
        HackathonSubmission submission = buildFullSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        List<String> recommendations = report.getRecommendations();
        assertNotNull(recommendations);
        assertEquals(1, recommendations.size());
    }

    @Test
    public void scoreInnovationWithUniqueFeaturesTechStackAndLongDescription() {
        HackathonSubmission submission = new HackathonSubmission(
                "Test", "A".repeat(101), "Java, React", null, null, null, "Novel feature A, Novel feature B"
        );
        int score = hackathonEvaluationService.scoreInnovation(submission);
        assertEquals(9, score);
    }

    @Test
    public void scoreExecutionWithCodeUrlDescriptionAndTechStack() {
        HackathonSubmission submission = new HackathonSubmission(
                "Test", "A".repeat(51), "Spring Boot", "https://github.com/test", null, null, null
        );
        int score = hackathonEvaluationService.scoreExecution(submission);
        assertEquals(9, score);
    }

    @Test
    public void scoreDesignWithDocumentationAndDescription() {
        HackathonSubmission submission = new HackathonSubmission(
                "Test", "A".repeat(76), "Spring Boot", "https://github.com/test", "https://docs.test.io", null, null
        );
        int score = hackathonEvaluationService.scoreDesign(submission);
        assertEquals(10, score);
    }

    @Test
    public void scorePresentationWithDemoAndDocumentation() {
        HackathonSubmission submission = new HackathonSubmission(
                "Test Project", "A".repeat(51), null, null, "https://docs.test.io", "https://demo.test.io", null
        );
        int score = hackathonEvaluationService.scorePresentation(submission);
        assertEquals(10, score);
    }

    @Test
    public void evaluateReturnsOverallAssessmentText() {
        HackathonSubmission submission = buildFullSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        assertNotNull(report.getOverallAssessment());
        assertFalse(report.getOverallAssessment().isEmpty());
    }

    @Test
    public void evaluateReturnsFeedbackForAllCriteria() {
        HackathonSubmission submission = buildFullSubmission();
        EvaluationReport report = hackathonEvaluationService.evaluate(submission);
        assertNotNull(report.getInnovationFeedback());
        assertNotNull(report.getExecutionFeedback());
        assertNotNull(report.getDesignFeedback());
        assertNotNull(report.getPresentationFeedback());
    }
}
