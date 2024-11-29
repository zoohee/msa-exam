package com.sparta.msa_exam.auth.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@AllArgsConstructor
@RedisHash(value = "token", timeToLive = 3600)
public class RedisTokenDto {
    @Id
    private String username;
    private String accessToken;

    public static RedisTokenDto create(String username, String accessToken) {
        return RedisTokenDto.builder()
                .username(username)
                .accessToken(accessToken)
                .build();
    }
}
