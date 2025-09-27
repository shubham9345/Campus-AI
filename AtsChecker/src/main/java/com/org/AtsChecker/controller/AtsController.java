package com.org.AtsChecker.controller;

import com.org.AtsChecker.model.Resume;
import com.org.AtsChecker.service.AtsService;
import com.org.AtsChecker.service.ResumeParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/ats")
public class AtsController {

    private final ResumeParser resumeParser;
    private final AtsService atsService;

    public AtsController(ResumeParser resumeParser, AtsService atsService) {
        this.resumeParser = resumeParser;
        this.atsService = atsService;
    }

    @PostMapping("/check")
    public ResponseEntity<Resume> checkAtsScore(
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("jobDescription") String jobDescription) throws IOException {

        String resumeText = "";

        if (resume.getOriginalFilename().endsWith(".pdf")) {
            resumeText = resumeParser.extractTextFromPdf(resume);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

        Resume result = atsService.analyzeResume(resumeText, jobDescription);
        return ResponseEntity.ok(result);
    }
}
