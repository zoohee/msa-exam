package com.sparta.msa_exam.auth;

import com.sparta.msa_exam.auth.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);
    default User getByUsernameAndPassword(String username, String password) {
        return findByUsernameAndPassword(username, password)
                .orElseThrow(() ->  new IllegalArgumentException("ID or PW가 틀렸습니다.")
        );
    }
}
