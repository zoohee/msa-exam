package com.sparta.msa_exam.auth.entity;

import com.sparta.msa_exam.auth.dto.request.SignUpRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String nickname;
    private String email;
    private UserRole role;

    public static User create(SignUpRequest request) {
        return User.builder()
                .username(request.username())
                .password(request.password()) // 암호화 필요
                .nickname(request.nickname())
                .email(request.email())
                .role(UserRole.valueOf(request.role()))
                .build();
    }
}