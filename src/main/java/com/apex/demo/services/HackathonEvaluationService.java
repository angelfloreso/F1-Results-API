package com.apex.demo.services;

import com.apex.demo.model.EvaluationReport;
import com.apex.demo.model.HackathonSubmission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class HackathonEvaluationService {

    public EvaluationReport evaluate(HackathonSubmission submission) {
        log.info("Evaluating submission for project: {}", submission.getProjectName());

        int innovationScore = scoreInnovation(submission);
        int executionScore = scoreExecution(submission);
        int designScore = scoreDesign(submission);
        int presentationScore = scorePresentation(submission);

        double overallScore = (innovationScore + executionScore + designScore + presentationScore) / 4.0;

        List<String> recommendations = buildRecommendations(submission, innovationScore, executionScore, designScore, presentationScore);

        EvaluationReport report = new EvaluationReport();
        report.setProjectName(submission.getProjectName());
        report.setInnovationScore(innovationScore);
        report.setInnovationFeedback(buildInnovationFeedback(submission, innovationScore));
        report.setExecutionScore(executionScore);
        report.setExecutionFeedback(buildExecutionFeedback(submission, executionScore));
        report.setDesignScore(designScore);
        report.setDesignFeedback(buildDesignFeedback(submission, designScore));
        report.setPresentationScore(presentationScore);
        report.setPresentationFeedback(buildPresentationFeedback(submission, presentationScore));
        report.setOverallScore(overallScore);
        report.setOverallAssessment(buildOverallAssessment(overallScore));
        report.setRecommendations(recommendations);
        report.setEvaluationDate(new Date());

        return report;
    }

    int scoreInnovation(HackathonSubmission submission) {
        int score = 0;
        if (hasContent(submission.getUniqueFeatures())) {
            score += 4;
        }
        if (hasContent(submission.getTechStack())) {
            score += 3;
        }
        if (hasContent(submission.getProjectDescription()) && submission.getProjectDescription().length() > 100) {
            score += 2;
        }
        if (hasContent(submission.getCodeUrl())) {
            score += 1;
        }
        return Math.min(score, 10);
    }

    int scoreExecution(HackathonSubmission submission) {
        int score = 0;
        if (hasContent(submission.getCodeUrl())) {
            score += 4;
        }
        if (hasContent(submission.getProjectDescription()) && submission.getProjectDescription().length() > 50) {
            score += 3;
        }
        if (hasContent(submission.getTechStack())) {
            score += 2;
        }
        if (hasContent(submission.getUniqueFeatures())) {
            score += 1;
        }
        return Math.min(score, 10);
    }

    int scoreDesign(HackathonSubmission submission) {
        int score = 0;
        if (hasContent(submission.getDocumentationUrl())) {
            score += 4;
        }
        if (hasContent(submission.getProjectDescription()) && submission.getProjectDescription().length() > 75) {
            score += 3;
        }
        if (hasContent(submission.getTechStack())) {
            score += 2;
        }
        if (hasContent(submission.getCodeUrl())) {
            score += 1;
        }
        return Math.min(score, 10);
    }

    int scorePresentation(HackathonSubmission submission) {
        int score = 0;
        if (hasContent(submission.getDemoUrl())) {
            score += 4;
        }
        if (hasContent(submission.getDocumentationUrl())) {
            score += 3;
        }
        if (hasContent(submission.getProjectDescription()) && submission.getProjectDescription().length() > 50) {
            score += 2;
        }
        if (hasContent(submission.getProjectName())) {
            score += 1;
        }
        return Math.min(score, 10);
    }

    private String buildInnovationFeedback(HackathonSubmission submission, int score) {
        if (score >= 8) {
            return "Excellent innovation! The project demonstrates a highly creative approach with unique features and a well-chosen tech stack.";
        } else if (score >= 5) {
            return "Good level of innovation. Consider elaborating on unique features and the technologies used to better showcase the originality of your idea.";
        } else {
            return "The project needs more innovation. Provide details about unique features, novel technologies, and the creative problem-solving approach.";
        }
    }

    private String buildExecutionFeedback(HackathonSubmission submission, int score) {
        if (score >= 8) {
            return "Outstanding execution! The code is accessible, well-described, and leverages appropriate technologies effectively.";
        } else if (score >= 5) {
            return "Decent execution. Sharing the code repository and providing a more detailed technical description would improve this score.";
        } else {
            return "Execution needs improvement. Include a link to the code repository and provide a thorough description of the technical implementation.";
        }
    }

    private String buildDesignFeedback(HackathonSubmission submission, int score) {
        if (score >= 8) {
            return "Excellent design! The project is well-documented and shows strong consideration for architecture and maintainability.";
        } else if (score >= 5) {
            return "Solid design foundation. Adding documentation and expanding the project description would highlight your architectural decisions better.";
        } else {
            return "Design aspects need attention. Provide documentation covering the architecture, code structure, and design principles followed.";
        }
    }

    private String buildPresentationFeedback(HackathonSubmission submission, int score) {
        if (score >= 8) {
            return "Impressive presentation! The project has a live demo and comprehensive documentation that clearly communicates the solution.";
        } else if (score >= 5) {
            return "Good presentation. Adding a demo link and more thorough documentation would significantly improve how the project is communicated.";
        } else {
            return "Presentation needs significant improvement. Include a demo link, detailed documentation, and a clear description of the project.";
        }
    }

    private String buildOverallAssessment(double overallScore) {
        if (overallScore >= 8.0) {
            return "Outstanding submission! This project excels across all evaluation criteria and demonstrates exceptional quality.";
        } else if (overallScore >= 6.0) {
            return "Strong submission with good overall quality. Some areas have room for improvement to reach excellence.";
        } else if (overallScore >= 4.0) {
            return "Promising submission that meets the basic requirements. Focused improvements in weaker areas will greatly enhance the overall quality.";
        } else {
            return "The submission requires significant work across multiple areas. Please review the feedback for each criterion and address the recommendations.";
        }
    }

    private List<String> buildRecommendations(HackathonSubmission submission, int innovationScore, int executionScore, int designScore, int presentationScore) {
        List<String> recommendations = new ArrayList<>();
        if (!hasContent(submission.getUniqueFeatures())) {
            recommendations.add("Describe the unique features of your project to highlight its originality.");
        }
        if (!hasContent(submission.getCodeUrl())) {
            recommendations.add("Provide a link to your code repository to demonstrate your technical implementation.");
        }
        if (!hasContent(submission.getDocumentationUrl())) {
            recommendations.add("Add documentation covering the project architecture, setup instructions, and design decisions.");
        }
        if (!hasContent(submission.getDemoUrl())) {
            recommendations.add("Include a demo link or video to effectively present your project to the judges.");
        }
        if (!hasContent(submission.getTechStack())) {
            recommendations.add("List the technologies, frameworks, and tools used in your project.");
        }
        if (!hasContent(submission.getProjectDescription()) || submission.getProjectDescription().length() <= 100) {
            recommendations.add("Expand your project description to provide a comprehensive overview of the problem and your solution.");
        }
        if (recommendations.isEmpty()) {
            recommendations.add("Great work! Continue refining the project and ensure all aspects are polished before the final submission.");
        }
        return recommendations;
    }

    private boolean hasContent(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
