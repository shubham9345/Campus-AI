package com.org.DsaService.controller;

import com.org.DsaService.model.Dsa;
import com.org.DsaService.service.DsaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dsa")
public class DsaController {
    @Autowired
    private DsaServiceImpl dsaService;

    @GetMapping("generate/{userId}")
    public Dsa generateDsa(@RequestParam String topic, @RequestParam(defaultValue = "false") boolean save, @PathVariable Long userId) {
        Dsa generatedDsa = dsaService.getDsaQuestions(topic);
        if (save) {
            dsaService.saveDsa(generatedDsa, userId);
        }
        return generatedDsa;
    }
    @GetMapping("/all-dsa/{userId}")
    public ResponseEntity<List<Dsa>> getAllRoadmap(@PathVariable Long userId){
        List<Dsa> allDsa = dsaService.getDsaByUserId(userId);
        return new ResponseEntity<>(allDsa, HttpStatus.OK);
    }
}
