package com.sparta.msa_exam.auth.dto.response;

import com.sparta.msa_exam.auth.entity.User;

public record SignupResponse(
        String username
) {
    public static SignupResponse from(User user) {
        return new SignupResponse(user.getUsername());
    }
}
