package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ResumeAnalyzerService {

    private static final String[] REQUIRED_SKILLS = {
            "Java",
            "Python",
            "SQL",
            "HTML",
            "CSS",
            "JavaScript",
            "Machine Learning",
            "Data Structures",
            "Git",
            "OOP",
            "Spring Boot",
            "REST API"
    };

    public AnalysisResult analyze(String resumeText, String jobDesc) {

        if (resumeText == null) {
            resumeText = "";
        }

        if (jobDesc == null) {
            jobDesc = "";
        }

        int matched = 0;

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        String resumeLower = resumeText.toLowerCase();
        String jobLower = jobDesc.toLowerCase();

        for (String skill : REQUIRED_SKILLS) {
            String skillLower = skill.toLowerCase();

            if (resumeLower.contains(skillLower)) {
                matched++;
                matchedSkills.add(skill);
            } else if (jobLower.contains(skillLower)) {
                missingSkills.add(skill);
            }
        }

        int score = (matched * 100) / REQUIRED_SKILLS.length;

        String suggestion;

        if (score >= 80) {
            suggestion = "Excellent resume match. Add achievements, project links, and measurable results.";
        } else if (score >= 50) {
            suggestion = "Good resume. Add more job-related skills and improve project descriptions.";
        } else {
            suggestion = "Low match. Add missing technical skills, relevant projects, and keywords from the job description.";
        }

        return new AnalysisResult(score, matchedSkills, missingSkills, suggestion);
    }
}