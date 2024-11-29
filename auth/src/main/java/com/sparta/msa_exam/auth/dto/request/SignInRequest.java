package com.sparta.msa_exam.auth.dto.request;

public record SignInRequest(
        String username,
        String password
) {
}
