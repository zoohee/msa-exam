package com.sparta.msa_exam.auth;

import com.sparta.msa_exam.auth.entity.User;

public record SigninResponse(
        String username,
        String accessToken
) {
    public static SigninResponse of(User user, String accessToken) {
        return new SigninResponse(user.getUsername(), accessToken);
    }
}
