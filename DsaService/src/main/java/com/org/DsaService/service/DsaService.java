package com.org.DsaService.service;

import com.org.DsaService.model.Dsa;

import java.util.List;

public interface DsaService {
    public void saveDsa(Dsa dsa, Long userId);
    public List<Dsa> getDsaByUserId(Long userId);
}
