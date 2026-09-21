package com.blog_app.service;

import com.blog_app.entity.User;
import com.blog_app.repository.UserRepository;
import com.blog_app.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private  final JwtService jwtService;
    private  final UserRepository userRepository;
    public String refreshAccessToken(String refreshToken) {

        Long userId = jwtService.getUserIdFromRefreshToken(refreshToken);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jwtService.generateAccessTokenFromRefreshToken(
                refreshToken,
                user
        );
    }
}
