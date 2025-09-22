package com.org.Roadmap.controller;

import com.org.Roadmap.model.Roadmap;
import com.org.Roadmap.service.RoadmapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roadmap")
public class RoadmapController {
    @Autowired
    private RoadmapServiceImpl roadmapService;

    @GetMapping("r1/{userId}")
    public Roadmap generate_roadmap(@RequestParam String domain, @RequestParam(defaultValue = "false") boolean save, @PathVariable Long userId) {
        Roadmap generated_roadmap = roadmapService.getRoadmap(domain);
        if (save) {
            roadmapService.save_roadmap(generated_roadmap, userId);
        }
        return generated_roadmap;
    }
}
