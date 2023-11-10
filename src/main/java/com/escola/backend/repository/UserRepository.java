package com.escola.backend.repository;

import java.util.Optional;

import com.escola.backend.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM users WHERE user_email = :user_email", nativeQuery = true)
    Users findByEmail(@Param("user_email") String user_email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE user_email = :user_email", nativeQuery = true)
    int deleteByEmail(@Param("user_email") String user_email);

}