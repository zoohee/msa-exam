package com.sparta.msa_exam.auth;

import com.sparta.msa_exam.auth.dto.request.SignInRequest;
import com.sparta.msa_exam.auth.dto.request.SignUpRequest;
import com.sparta.msa_exam.auth.dto.response.SignupResponse;
import com.sparta.msa_exam.auth.entity.User;
import com.sparta.msa_exam.auth.jwt.JwtUtil;
import com.sparta.msa_exam.auth.jwt.RedisTokenDto;
import com.sparta.msa_exam.auth.jwt.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;

    public SignupResponse signup(SignUpRequest request) {
        User user = userRepository.save(User.create(request));
        return SignupResponse.from(user);
    }

    public SigninResponse signin(SignInRequest request) {
        User user = userRepository.getByUsernameAndPassword(request.username(), request.password());
        String accessToken = jwtUtil.createAccessToken(user);
        tokenRepository.save(RedisTokenDto.create(user.getUsername(), accessToken));
        return SigninResponse.of(user, accessToken);
    }
}