package com.org.Roadmap.service;

import com.org.Roadmap.model.Roadmap;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoadmapService {
    public Roadmap getRoadmap(String domain);

    public void save_roadmap(Roadmap roadmap, Long userId);

    public List<Roadmap> getRoadmapByUserId(Long userId);

    public String deleteRoadmap(Long roadmapId);
}
