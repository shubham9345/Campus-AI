package com.org.Roadmap.repository;

import com.org.Roadmap.model.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadmapRepository  extends JpaRepository<Roadmap, Long> {
    List<Roadmap>findRoadmapByUserId(Long userId);
}