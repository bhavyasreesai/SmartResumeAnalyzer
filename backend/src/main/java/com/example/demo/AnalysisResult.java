package com.example.demo;

import java.util.List;

public class AnalysisResult {

    private int score;
    private List<String> matchedSkills;
    private List<String> missingSkills;
    private String suggestion;

    public AnalysisResult(int score, List<String> matchedSkills, List<String> missingSkills, String suggestion) {
        this.score = score;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.suggestion = suggestion;
    }

    public int getScore() {
        return score;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public String getSuggestion() {
        return suggestion;
    }
}