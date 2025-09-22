package com.campusAI.Campus.AI.services;


import com.campusAI.Campus.AI.entity.UserInfo;
import com.campusAI.Campus.AI.exception.UserNotFoundException;
import com.campusAI.Campus.AI.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserInfo AddUser(UserInfo user) {
        UserInfo existingUser = userInfoRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("username already exist!!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userInfoRepository.save(user);
    }

    public UserInfo getUserbyId(Long Id) {
        Optional<UserInfo> UserOptional = userInfoRepository.findById(Id);
        if (UserOptional.isEmpty()) {
            throw new UserNotFoundException("User not found with Id" + Id, "user is not found!! check it once");
        }
        return UserOptional.get();
    }

    public List<UserInfo> getAllUser() {
        return userInfoRepository.findAll();
    }

    public String deleteUserById(Long userId) {
        UserInfo user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with Id: " + userId, "user is not found!! check it once"));

        userInfoRepository.delete(user);
        return "User deleted successfully with id: " + userId;
    }

}
