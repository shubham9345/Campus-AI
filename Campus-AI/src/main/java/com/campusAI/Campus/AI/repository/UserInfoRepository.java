package com.campusAI.Campus.AI.repository;

import com.campusAI.Campus.AI.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String Username);
}
