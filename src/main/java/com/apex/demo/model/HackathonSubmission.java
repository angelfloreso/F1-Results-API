package com.apex.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HackathonSubmission {
    private String projectName;
    private String projectDescription;
    private String techStack;
    private String codeUrl;
    private String documentationUrl;
    private String demoUrl;
    private String uniqueFeatures;
}
