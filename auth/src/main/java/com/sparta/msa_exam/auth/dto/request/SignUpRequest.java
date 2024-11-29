package com.sparta.msa_exam.auth.dto.request;

public record SignUpRequest(
        String username,
        String password,
        String nickname,
        String email,
        String role
) {
}
