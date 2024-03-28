package com.example.videostreamingplatform.repository;

import com.example.videostreamingplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUserLogin(String login);

    boolean existsByUserLogin(String loging);
}
