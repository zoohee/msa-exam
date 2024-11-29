package com.sparta.msa_exam.auth;

import com.sparta.msa_exam.auth.dto.request.SignUpRequest;
import com.sparta.msa_exam.auth.dto.response.SignupResponse;
import com.sparta.msa_exam.auth.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public SignupResponse signup(SignUpRequest request) {
        User user = userRepository.save(User.create(request));
        return SignupResponse.from(user);
    }
}