package com.campusAI.Campus.AI.security;

import lombok.Getter;
import lombok.Setter;

import static com.campusAI.Campus.AI.utility.ConstantUtils.TOKEN_EXPIRATION_TIME;

@Getter
@Setter
public class JwtResponse {
    private final String jwtToken;
    private final String  expirationTimes;

    public JwtResponse(String jwtToken){
        this.jwtToken = jwtToken;
        this.expirationTimes = ((TOKEN_EXPIRATION_TIME) / (1000 * 60)) + " minutes";

    }
}

