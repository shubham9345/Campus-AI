package com.campusAI.Campus.AI.services;

import com.campusAI.Campus.AI.entity.UserInfo;
import com.campusAI.Campus.AI.entity.UserInfoDetails;
import com.campusAI.Campus.AI.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userDetail = userInfoRepository.findByUsername(username);
        if (userDetail == null) {
            throw new UsernameNotFoundException("user is not find with this " + username);
        }
        return new UserInfoDetails(userDetail);
    }
}