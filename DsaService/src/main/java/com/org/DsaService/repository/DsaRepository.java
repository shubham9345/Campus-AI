package com.org.DsaService.repository;

import com.org.DsaService.model.Dsa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DsaRepository extends JpaRepository<Dsa, Long> {
    List<Dsa> findDsaQuestionByUserId(Long userId);

}
