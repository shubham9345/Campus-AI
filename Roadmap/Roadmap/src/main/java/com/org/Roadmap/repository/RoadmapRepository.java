package com.org.Roadmap.repository;

import com.org.Roadmap.model.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadmapRepository  extends JpaRepository<Roadmap, Long> {
}