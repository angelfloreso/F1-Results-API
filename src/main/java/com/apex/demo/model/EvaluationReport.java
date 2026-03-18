package com.apex.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationReport {
    private String projectName;
    private int innovationScore;
    private String innovationFeedback;
    private int executionScore;
    private String executionFeedback;
    private int designScore;
    private String designFeedback;
    private int presentationScore;
    private String presentationFeedback;
    private double overallScore;
    private String overallAssessment;
    private List<String> recommendations;
    private Date evaluationDate;
}
