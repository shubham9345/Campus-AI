package com.campusAI.Campus.AI.controller;

import com.campusAI.Campus.AI.entity.ErrorResponse;
import com.campusAI.Campus.AI.entity.UserInfo;
import com.campusAI.Campus.AI.repository.UserInfoRepository;
import com.campusAI.Campus.AI.security.JwtRequest;
import com.campusAI.Campus.AI.security.JwtResponse;
import com.campusAI.Campus.AI.security.JwtUtil;
import com.campusAI.Campus.AI.services.CustomUserDetailService;
import com.campusAI.Campus.AI.services.UserInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.campusAI.Campus.AI.utility.ConstantUtils.INVALID_CREDENTIAL;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @PostMapping("/signup")
    public ResponseEntity<UserInfo> Signup(@RequestBody UserInfo userInfo) {
        try {
            if (userInfo.getPassword() == null || userInfo.getUsername() == null) {
                throw new RuntimeException(INVALID_CREDENTIAL);

            }
            if (userInfo.getPassword().equals(" ") || userInfo.getUsername().equals(" ") || userInfo.getPassword().isEmpty() || userInfo.getUsername().isEmpty()) {
                throw new RuntimeException(INVALID_CREDENTIAL);
            }
            if (userInfo.getRoles() == null) {
                userInfo.setRoles("User");
            }
            UserInfo newUser = userInfoService.AddUser(userInfo);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/error")
    public ResponseEntity<ErrorResponse> error(HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Invalid username and password or your token is expired");
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(INVALID_CREDENTIAL);
        }

        UserInfo userDetails = userInfoRepository.findByUsername(request.getUsername());
        String token = this.jwtUtil.generateToken(userDetails.getUsername(), userDetails.getId());
        JwtResponse response = new JwtResponse(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-user")
    public ResponseEntity<List<UserInfo>> allUser() {
        List<UserInfo> allUser = userInfoService.getAllUser();
        if (allUser == null) {
            throw new RuntimeException("no user is found");
        }
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
}
