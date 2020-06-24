package com.example.testsecurity.repository;

import com.example.testsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {



    User findByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users u SET u.balance = u.balance + ?1 WHERE u.user_id = ?2", nativeQuery = true)
    void changeBalanceByAmount(float amount, int userId);
}