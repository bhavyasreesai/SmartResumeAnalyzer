package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin
public class ResumeController {

    private final ResumeAnalyzerService service;

    public ResumeController(ResumeAnalyzerService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public AnalysisResult analyzeResume(@RequestBody Map<String, String> data) {
        String resume = data.get("resume");
        String job = data.get("job");

        return service.analyze(resume, job);
    }
}